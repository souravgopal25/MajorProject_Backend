package com.sourav.majorProject.controller;

import com.sourav.majorProject.dao.UserDao;
import com.sourav.majorProject.model.AuthenticationRequest;
import com.sourav.majorProject.model.AuthenticationResponse;
import com.sourav.majorProject.model.User;
import com.sourav.majorProject.model.UserModelForResponse;
import com.sourav.majorProject.service.MyUserDetailService;
import com.sourav.majorProject.service.UIDGenerator;
import com.sourav.majorProject.utilService.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailService userDetailService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UIDGenerator uidGenerator;
    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));

        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect Username password", e);
        }
        final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        User user=userDetailService.getUserByEmail(authenticationRequest.getUsername());
        UserModelForResponse obj=new UserModelForResponse(user.getFirstName(),user.getLastName(),user.getEmail(),user.uid,user.getPhotoUrl());
        AuthenticationResponse response = new AuthenticationResponse(jwt, obj);
        return ResponseEntity.ok(response);
    }
    //TODO SIGNUP ME ADD USER
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> signup(@RequestBody User user) throws Exception {
        System.out.println("signup hit");
        System.out.println(user.toString());
        boolean isPresent = userDetailService.existsUser(user.getEmail());
        if (!isPresent) {
            String uid = uidGenerator.getuid(user);
            user.setUid(uid);
            userDao.save(user);
            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
            } catch (BadCredentialsException e) {
                throw new Exception("Error", e);
            }
            final UserDetails userDetails = userDetailService.loadUserByEmail(user.getEmail());
            final String jwt = jwtUtil.generateToken(userDetails);
            UserModelForResponse obj=new UserModelForResponse(user.getFirstName(),user.getLastName(),user.getEmail(),user.uid,user.getPhotoUrl());
            AuthenticationResponse response = new AuthenticationResponse(jwt, obj);
            return ResponseEntity.ok(response);
        } else {
            Map<String,Object> map=new HashMap<>();

            map.put("Status",403);
            map.put("message","User Already Exists");
            ResponseEntity response=new ResponseEntity(map, HttpStatus.valueOf(403));

            return response;
        }

    }
}
