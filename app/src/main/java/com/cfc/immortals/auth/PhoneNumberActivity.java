package com.cfc.immortals.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cfc.immortals.R;
import com.cfc.immortals.httpclient.AuthClient;
import com.cfc.immortals.httpclient.RetrofitClient;
import com.cfc.immortals.httpclient.dto.OTPSendResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhoneNumberActivity extends AppCompatActivity implements View.OnClickListener {
    AppCompatButton continueBtn;
    EditText phoneNumberEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        continueBtn = findViewById(R.id.continueBtn);
        phoneNumberEt = findViewById(R.id.mobileNumber_et);

        continueBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.continueBtn:
                String phoneNumber = getMobileNumber();

                if(phoneNumber.length()>0){
                    startActivity(new Intent(this,OtpActivity.class));
                    AuthClient authClient = RetrofitClient.getRetrofitInstance().create(AuthClient.class);
                    authClient.sendOtp(phoneNumber).enqueue(new Callback<OTPSendResponse>() {
                        @Override
                        public void onResponse(Call<OTPSendResponse> call, Response<OTPSendResponse> response) {
                            if(response.isSuccessful()){
                                Toast.makeText(PhoneNumberActivity.this, "OTP is Sent", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                try {
                                    Toast.makeText(PhoneNumberActivity.this, "Error"+response.errorBody().string(), Toast.LENGTH_SHORT).show();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                        }

                        @Override
                        public void onFailure(Call<OTPSendResponse> call, Throwable t) {
                            Toast.makeText(PhoneNumberActivity.this, "Request Failed"+t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }

        }
    }


    private String getMobileNumber(){
        String phoneNumber = phoneNumberEt.getText().toString();
        if (phoneNumber!=null && !TextUtils.isEmpty(phoneNumber)){
            return phoneNumber;
        }
        else{
            Toast.makeText(this, "Please Enter a Valid Mobile Number", Toast.LENGTH_SHORT).show();
            return "";
        }

    }
}