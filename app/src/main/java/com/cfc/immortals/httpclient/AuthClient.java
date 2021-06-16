package com.cfc.immortals.httpclient;

import com.cfc.immortals.httpclient.dto.OTPSendResponse;
import com.cfc.immortals.httpclient.dto.OTPVerifyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AuthClient {

    @GET("sendOTP")
    Call<OTPSendResponse> sendOtp(@Query("mobileno") String mobileno);

    @GET("verifyOTP")
    Call<OTPVerifyResponse> verifyOtp(@Query("otp") String otp,@Query("sessionId") String sessionId);



}
