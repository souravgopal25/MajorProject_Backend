package com.sourav.majorProject.service;

import com.sourav.majorProject.dao.UserDao;
import com.sourav.majorProject.model.MyUserDetail;
import com.sourav.majorProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    UserDao userdao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user=userdao.findByEmail(username);
        user.orElseThrow(()-> new UsernameNotFoundException("Not Found "+username));
        return user.map(MyUserDetail::new).get();
    }
    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException{
        Optional<User> user=userdao.findByEmail(email);
        user.orElseThrow(()-> new UsernameNotFoundException("Not Found "+email));
        return user.map(MyUserDetail::new).get();
    }
    public User getUserByEmail(String email)throws UsernameNotFoundException{
        Optional<User> user=userdao.findByEmail(email);
        user.orElseThrow(()-> new UsernameNotFoundException("Not Found "+email));
        return user.get();
    }
    public boolean existsUser(String email) {
        Optional<User> user = userdao.findByEmail(email);
        if (user.isPresent()) {
            return true;
        } else {
            return false;
        }
    }
}
