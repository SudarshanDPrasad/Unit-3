package com.example.evaluationpraticesprint_2;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {
    //    private static final String SHARED_PREFERENCE_KEY = "com.xyz.sharedpreferences";
//    private static SharedPreferences sharedPreferences;
//
//    public static SharedPreferences getInstance(Context context) {
////        if(sharedPreferences == null){
//            sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_KEY,Context.MODE_PRIVATE);
////        }
//        return sharedPreferences;
//    }
//
//    public static void writeStringToPreference(Context context,String key, String value) {
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString(key, value);
//        editor.apply();
//    }
//
//    public static String getIntSharedPreferenceKey( Context context, String key){
//        return sharedPreferences.getString(key, null);
//    }
//}
    public static final String KEY = "mausam.singhspring3";

    public static SharedPreferences getSharedPrefernce(Context context) {
        return context.getSharedPreferences(KEY, Context.MODE_PRIVATE);
    }

    public static void writeStringToPreference(Context context, String key, String value) {
        SharedPreferences.Editor editor = getSharedPrefernce(context).edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getStringFromPreference(Context context, String key) {
        return getSharedPrefernce(context).getString(key, null);
    }
}

