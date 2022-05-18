package com.hades.example.android.testcharles;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    private final String TEST_URL = "https://blog.csdn.net/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        findViewById(R.id.checkUrl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUrl();
            }
        });
    }

    private void checkUrl() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Tell the URLConnection to use our HostnameVerifier
                try {
                    URL url = new URL(TEST_URL);
                    HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                    urlConnection.setHostnameVerifier(new MyHostnameVerifier());
                    InputStream in = urlConnection.getInputStream();
                    in.read();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }
}