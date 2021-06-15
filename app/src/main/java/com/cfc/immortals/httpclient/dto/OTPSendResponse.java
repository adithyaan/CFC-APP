package com.cfc.immortals.httpclient.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OTPSendResponse {
    @JsonIgnore
    @JsonProperty("Status")
    private String status;
    @JsonProperty("Details")
    @JsonIgnore
    private String response;

    @JsonIgnore
    @JsonProperty("message")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
            return status;
    }

    public void setStatus(String status) {
            this.status = status;
    }
    public String getResponse() {
            return response;
    }

    public void setResponse(String response) {
            this.response = response;
    }

        @Override
        public String toString() {
            return "OTPSendResponse{" +
                    "status='" + status + '\'' +
                    ", response='" + response + '\'' +
                    '}';
        }
    }

