package com.imcgeek.cameraapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Map;

public class LauncherActivity extends AppCompatActivity {

    public static final String SharedPref = "MyPrefs";
    public static final String Test = "Test";
    Intent i;
    SharedPreferences sharedPreferences;
    private static final String TAG = "CameraApp";

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_launcher);
        Button button_pH = (Button)findViewById(R.id.pH);
        Button button_n = (Button)findViewById(R.id.N);
        Button button_p = (Button)findViewById(R.id.P);
        Button button_k = (Button)findViewById(R.id.K);

        button_n.setEnabled(false);
        button_p.setEnabled(false);
        button_k.setEnabled(false);

        sharedPreferences = getSharedPreferences(SharedPref, Context.MODE_PRIVATE);
        Map<String,?> keys = sharedPreferences.getAll();

        for(Map.Entry<String,?> entry : keys.entrySet()){
            if(entry.getKey().equals(Test)){
                if (entry.getValue().toString().equals("pHTest")){
                    button_pH.setEnabled(false);
                    button_pH.setBackgroundColor(getColor(R.color.accentGreen));
                    button_n.setEnabled(true);
                    button_p.setEnabled(false);
                    button_k.setEnabled(false);
                }else if(entry.getValue().toString().equals("NTest")){
                    button_pH.setEnabled(false);
                    button_pH.setBackgroundColor(getColor(R.color.accentGreen));
                    button_n.setEnabled(false);
                    button_n.setBackgroundColor(getColor(R.color.accentGreen));
                    button_p.setEnabled(true);
                    button_k.setEnabled(false);
                }else if (entry.getValue().toString().equals("PTest")){
                    button_pH.setEnabled(false);
                    button_pH.setBackgroundColor(getColor(R.color.accentGreen));
                    button_n.setEnabled(false);
                    button_n.setBackgroundColor(getColor(R.color.accentGreen));
                    button_p.setEnabled(false);
                    button_p.setBackgroundColor(getColor(R.color.accentGreen));
                    button_k.setEnabled(true);
                }
                else if (entry.getValue().toString().equals("KTest")){
                    button_pH.setEnabled(false);
                    button_pH.setBackgroundColor(getColor(R.color.accentGreen));
                    button_n.setEnabled(false);
                    button_n.setBackgroundColor(getColor(R.color.accentGreen));
                    button_p.setEnabled(false);
                    button_p.setBackgroundColor(getColor(R.color.accentGreen));
                    button_k.setEnabled(false);
                    button_k.setBackgroundColor(getColor(R.color.accentGreen));
                    Intent i = new Intent(LauncherActivity.this,ResultActivity.class);
                    startActivity(i);
                }
            }
            Log.d(TAG,entry.getKey() + ": " +
                    entry.getValue().toString());
        }

        button_pH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Test,"pHTest");
                editor.commit();
                i = new Intent(LauncherActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        button_n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Test,"NTest");
                editor.commit();
                i = new Intent(LauncherActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        button_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Test,"PTest");
                editor.commit();
                i = new Intent(LauncherActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        button_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Test,"KTest");
                editor.commit();
                i = new Intent(LauncherActivity.this,MainActivity.class);
                startActivity(i);
            }
        });


    }
}
