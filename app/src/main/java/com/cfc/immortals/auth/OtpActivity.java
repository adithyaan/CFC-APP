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
import com.cfc.immortals.httpclient.dto.OTPVerifyResponse;
import com.cfc.immortals.signup.SignupActivity;
import com.cfc.immortals.util.LoadingDialog;
import com.cfc.immortals.util.SharedPreferencesUtil;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText otpEt;
    AppCompatButton verifyBtn;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        init();
    }

    private void init(){
        verifyBtn = findViewById(R.id.verify_btn);
        otpEt = findViewById(R.id.otp_et);
        verifyBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.verify_btn:
                String otp = getOtp();
                AuthClient authClient = RetrofitClient.getRetrofitInstance().create(AuthClient.class);
                pd= LoadingDialog.showProgressDialog("Verifying Otp",OtpActivity.this);

                authClient.verifyOtp(otp,SharedPreferencesUtil.getOTPToken(OtpActivity.this)).enqueue(new Callback<OTPVerifyResponse>() {
                    @Override
                    public void onResponse(Call<OTPVerifyResponse> call, Response<OTPVerifyResponse> response) {
                        pd.dismiss();
                        if(response.isSuccessful()){
                            Toast.makeText(OtpActivity.this, "OTP Verfied", Toast.LENGTH_SHORT).show();
//                            Log.e("onResponse: ",response.body().getResponse()+"\n"+response.body().getMessage() );
                            OTPVerifyResponse otpSendResponse = response.body();
                            startActivity(new Intent(OtpActivity.this,SignupActivity.class));
                        }
                        else{
                            try {

                                Toast.makeText(OtpActivity.this, "Error"+response.errorBody().string(), Toast.LENGTH_SHORT).show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<OTPVerifyResponse> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(OtpActivity.this, "Request Failed"+t.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.e("onFailure: ",call.toString()+"\n"+t.getMessage().toString() );

                    }
                });
        }
        }



    private String getOtp(){
        String otp = otpEt.getText().toString();
        if (otp!=null && !TextUtils.isEmpty(otp)){
            return otp;
        }
        else{
            Toast.makeText(this, "Please Enter OTP", Toast.LENGTH_SHORT).show();
            return "";
        }

    }

}