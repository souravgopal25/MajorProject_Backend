package com.sourav.majorProject.model;

public class AuthenticationResponse {
    private final String jwt;
    private final UserModelForResponse user;


    public AuthenticationResponse(String jwt, UserModelForResponse user) {
        this.jwt = jwt;
        this.user = user;
    }

    public String getJwt() {
        return jwt;
    }

    public UserModelForResponse getUser() {
        return user;
    }
}
