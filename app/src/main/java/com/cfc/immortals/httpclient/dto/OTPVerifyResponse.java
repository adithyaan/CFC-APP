package com.cfc.immortals.httpclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OTPVerifyResponse {

    @JsonProperty("Status")
    private String status;
    @JsonProperty("Details")
    private String details;
//    @JsonProperty("token")
//    private String token;
//    private boolean newUser;
//    @JsonProperty("id")
//    private String id;
//    @JsonProperty("isError")
//    private boolean isError;
//    @JsonProperty("isNewUser")
//    private boolean isNewUser;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setResponse(String details) {
        this.details = details;
    }

//    public String getToken() {
//        return token;
//    }
//
//    public void setToken(String token) {
//        this.token = token;
//    }
//
//    public boolean isNewUser() {
//        return newUser;
//    }
//
//    public void setNewUser(boolean newUser) {
//        this.newUser = newUser;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public boolean isError() {
//        return isError;
//    }
//
//    public void setError(boolean error) {
//        isError = error;
//    }
}
