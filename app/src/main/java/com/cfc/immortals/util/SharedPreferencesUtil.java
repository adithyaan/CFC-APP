package com.cfc.immortals.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Locale;

public class SharedPreferencesUtil {

    public SharedPreferencesUtil() {

    }

    public static String getOTPToken(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("OTP_AUTH", Context.MODE_PRIVATE);
        return sharedPreferences.getString("SessionId", "");
    }

    public static void setOtpToken(String Session,Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("OTP_AUTH", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("SessionId", Session);
        editor.apply();
    }

    public static String getTempToken(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("RELAX_CAB_AUTH", Context.MODE_PRIVATE);
        return sharedPreferences.getString("TEMP_TOKEN", "");
    }

    public static void clear(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("RELAX_CAB_AUTH", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
        SharedPreferences dataPreferences = context.getSharedPreferences("RELAX_CAB_DATA", Context.MODE_PRIVATE);
        dataPreferences.edit().clear().apply();
    }

    public static String getId(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("RELAX_CAB_AUTH", Context.MODE_PRIVATE);
        return sharedPreferences.getString("ID", "");
    }


}
