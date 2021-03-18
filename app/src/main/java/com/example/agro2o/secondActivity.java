package com.example.agro2o;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    public void signUp(View view)
    {
        Intent i = new Intent(secondActivity.this,signUp.class);
        i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        startActivity(i);
    }
//    public void login(View view)
//    {
//        Intent i =new Intent(secondActivity.this,simpleLogin.class);
//        i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
//        startActivity(i);
//    }
}
