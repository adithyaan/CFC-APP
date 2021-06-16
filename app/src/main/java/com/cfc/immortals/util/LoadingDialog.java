package com.cfc.immortals.util;

import android.app.ProgressDialog;
import android.content.Context;

public class LoadingDialog {

    public static ProgressDialog showProgressDialog(String title, Context context){
        ProgressDialog progressDialog=new ProgressDialog(context);

        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage(title);
        progressDialog.show();
        return progressDialog;
    }
}
