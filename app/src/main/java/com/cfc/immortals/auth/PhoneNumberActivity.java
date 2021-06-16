package com.cfc.immortals.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cfc.immortals.R;
import com.cfc.immortals.httpclient.AuthClient;
import com.cfc.immortals.httpclient.RetrofitClient;
import com.cfc.immortals.httpclient.dto.OTPSendResponse;
import com.cfc.immortals.util.LoadingDialog;
import com.cfc.immortals.util.SharedPreferencesUtil;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhoneNumberActivity extends AppCompatActivity implements View.OnClickListener {
    AppCompatButton continueBtn;
    EditText phoneNumberEt;
    ProgressDialog pd;
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
                Toast.makeText(this, "test"+phoneNumber, Toast.LENGTH_SHORT).show();
                if(phoneNumber.length()>0){
                    pd=LoadingDialog.showProgressDialog("Getting Otp",PhoneNumberActivity.this);
                    AuthClient authClient = RetrofitClient.getRetrofitInstance().create(AuthClient.class);
                    authClient.sendOtp(phoneNumber).enqueue(new Callback<OTPSendResponse>() {
                        @Override
                        public void onResponse(Call<OTPSendResponse> call, Response<OTPSendResponse> response) {
                            if(response.isSuccessful()){
                                pd.dismiss();
                                Toast.makeText(PhoneNumberActivity.this, "OTP is Sent", Toast.LENGTH_SHORT).show();
                                Log.e("onResponse: ",response.body().getResponse()+"\n"+response.body().getMessage() );
                                OTPSendResponse otpSendResponse = response.body();
                                SharedPreferencesUtil.setOtpToken(otpSendResponse.getResponse(),PhoneNumberActivity.this);
                                startActivity(new Intent(PhoneNumberActivity.this,OtpActivity.class));
                            }
                            else{
                                pd.dismiss();
                                try {

                                    Toast.makeText(PhoneNumberActivity.this, "Error"+response.errorBody().string(), Toast.LENGTH_SHORT).show();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                        }

                        @Override
                        public void onFailure(Call<OTPSendResponse> call, Throwable t) {
                            pd.dismiss();
                            Toast.makeText(PhoneNumberActivity.this, "Request Failed"+t.getMessage(), Toast.LENGTH_SHORT).show();
                            Log.e("onFailure: ",call.toString()+"\n"+t.getMessage().toString() );
                                            startActivity(new Intent(PhoneNumberActivity.this,OtpActivity.class));

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