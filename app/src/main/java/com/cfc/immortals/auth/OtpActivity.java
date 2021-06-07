package com.cfc.immortals.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.cfc.immortals.R;
import com.cfc.immortals.signup.SignupActivity;

public class OtpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText otpEt;
    AppCompatButton verifyBtn;
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
                startActivity(new Intent(this, SignupActivity.class));
        }
    }

}