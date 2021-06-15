package com.cfc.immortals.signup.fragments;

import android.app.DatePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.location.Address;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.cfc.immortals.R;
import com.cfc.immortals.signup.SignupActivity;

import java.util.Calendar;
import java.util.Locale;


public class PersonalFragment extends Fragment {

    View root;
    Button nextBtn;
    DatePicker datePicker;
    public PersonalFragment() {
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
        root= inflater.inflate(R.layout.fragment_personal, container, false);
        datePicker=root.findViewById(R.id.dobdate);
        datePicker.setMaxDate(System.currentTimeMillis());
        nextBtn = root.findViewById(R.id.nextBtn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((SignupActivity)getActivity()).transactionFragment(new AddressFragment());
            }
        });
        return  root;
    }

}