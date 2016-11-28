package com.imcgeek.cameraapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;

public class ResultActivity extends AppCompatActivity {

    private static ResultActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        instance = this;

        TextView textView1 = (TextView) findViewById(R.id.result_ph);
        TextView textView2 = (TextView) findViewById(R.id.result_n);
        TextView textView3 = (TextView) findViewById(R.id.result_p);
        TextView textView4 = (TextView) findViewById(R.id.result_k);

        SharedPreferences sharedPreferences = getSharedPreferences(LauncherActivity.SharedPref, Context.MODE_PRIVATE);

        textView1.setText("pH : "+String.valueOf(sharedPreferences.getInt("pHResult",0)));
        textView2.setText("N  : "+String.valueOf(sharedPreferences.getInt("NResult",0)));
        textView3.setText("P  : "+String.valueOf(sharedPreferences.getInt("PResult",0)));
        textView4.setText("K  : "+String.valueOf(sharedPreferences.getInt("KResult",0)));

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        editor.apply();
        clearApplicationData();
    }
    public static ResultActivity getInstance(){
        return instance;
    }
    public void clearApplicationData() {
        File cacheDirectory = getCacheDir();
        File applicationDirectory = new File(cacheDirectory.getParent());
        if (applicationDirectory.exists()) {
            String[] fileNames = applicationDirectory.list();
            for (String fileName : fileNames) {
                if (!fileName.equals("lib")) {
                    deleteFile(new File(applicationDirectory, fileName));
                }
            }
        }
    }

    public static boolean deleteFile(File file) {
        boolean deletedAll = true;
        if (file != null) {
            if (file.isDirectory()) {
                String[] children = file.list();
                for (int i = 0; i < children.length; i++) {
                    deletedAll = deleteFile(new File(file, children[i])) && deletedAll;
                }
            } else {
                deletedAll = file.delete();
            }
        }

        return deletedAll;
    }
}
