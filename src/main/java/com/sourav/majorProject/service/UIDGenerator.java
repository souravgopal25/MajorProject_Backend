package com.sourav.majorProject.service;

import com.sourav.majorProject.model.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UIDGenerator {
    private String uid;
    public String getuid(User user) {
        String str=user.getFirstName()+user.getLastName()+user.getEmail();
        UUID uuid=UUID.nameUUIDFromBytes(str.getBytes());
        uid=uuid.toString();
        return uid;
    }
}
