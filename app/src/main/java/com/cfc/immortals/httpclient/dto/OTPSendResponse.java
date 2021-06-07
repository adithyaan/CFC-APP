package com.cfc.immortals.httpclient.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OTPSendResponse {
    @JsonProperty("Status")
    private String status;
    @JsonProperty("Details")
    private String response;

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

