package com.cfc.immortals.signup.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cfc.immortals.R;
import com.cfc.immortals.home.HomeActivity;
import com.cfc.immortals.signup.SignupActivity;


public class AddressFragment extends Fragment implements View.OnClickListener{
    AppCompatButton nextButton;
    View root;

    public AddressFragment() {
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
        root= inflater.inflate(R.layout.fragment_address, container, false);
        init();
        return root;
    }

    private void init(){
        nextButton = root.findViewById(R.id.nextBtn);
        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.nextBtn:
                Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), HomeActivity.class));
                break;
        }
    }
}