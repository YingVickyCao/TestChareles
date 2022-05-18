package com.hades.example.android.testcharles;

import android.util.Log;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class MyHostnameVerifier implements HostnameVerifier {
    private static final String TAG = "MyHostnameVerifier";

    @Override
    public boolean verify(String hostname, SSLSession session) {
        Log.d(TAG, "verify: " + hostname);
        return true;
    }
}