package com.cfc.immortals.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.cfc.immortals.R;
import com.cfc.immortals.signup.fragments.AccountTypeFragment;
import com.cfc.immortals.signup.fragments.AddressFragment;
import com.cfc.immortals.signup.fragments.PersonalFragment;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.container, new PersonalFragment(), null)
                .commit();
    }


    public void transactionFragment(Fragment stepName){


        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.container, stepName, null)
                .commit();
    }
}