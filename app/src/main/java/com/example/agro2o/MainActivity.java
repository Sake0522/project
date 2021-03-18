package com.example.agro2o;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    TextView tv;
    Timer timer;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    iv=(ImageView)findViewById(R.id.imageView);
        iv.animate().alpha(1f).setDuration(500);
    tv = (TextView)findViewById(R.id.textView);
        tv.animate().alpha(1f).setDuration(3000);
    timer = new Timer();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        timer.schedule(new TimerTask() {
        @Override
        public void run() {
            Intent i = new Intent(MainActivity.this, secondActivity.class);
            startActivity(i);

        }
    }, 5000);
    bt = (Button)findViewById(R.id.abc);
        bt.animate().alpha(1f).setDuration(20000);

}
    public void xyz(View view)
    {
        Intent i = new Intent(MainActivity.this,secondActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(i);
    }
}
