package com.cfc.immortals.httpclient.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OTPSendResponse {
    @JsonProperty("Status")
    private String status;
    @JsonProperty("Details")
    private String Details;
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
            return Details;
    }

    public void setResponse(String Details) {
            this.Details = Details;
    }

        @Override
        public String toString() {
            return "OTPSendResponse{" +
                    "status='" + status + '\'' +
                    ", Details='" + Details + '\'' +
                    '}';
        }
    }

