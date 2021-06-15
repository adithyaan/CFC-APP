package com.cfc.immortals.signup.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.cfc.immortals.R;
import com.cfc.immortals.home.HomeActivity;
import com.cfc.immortals.signup.SignupActivity;


public class AccountTypeFragment extends Fragment implements View.OnClickListener {
    Button createButton;
    View root;
    RadioGroup radioUserTypeGroup;
    LinearLayout orgContainer;


    public AccountTypeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root=inflater.inflate(R.layout.fragment_account_type, container, false);
        init();
        return root;
    }

    private void init(){
        createButton = root.findViewById(R.id.createBtn);
        createButton.setOnClickListener(this);
        radioUserTypeGroup=(RadioGroup)root.findViewById(R.id.rg);
        orgContainer = root.findViewById(R.id.ll);
        radioUserTypeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                RadioButton checkedRadioButton = (RadioButton)radioUserTypeGroup.findViewById(i);
                String selected=checkedRadioButton.getText().toString();
                if (selected.equals("Organisation")) {
                    orgContainer.setVisibility(View.VISIBLE);
                }
                else{
                    orgContainer.setVisibility(View.GONE);

                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.createBtn:
                ((SignupActivity)getActivity()).transactionFragment(new PersonalFragment());

        }
    }
}