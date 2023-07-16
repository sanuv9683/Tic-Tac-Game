package com.example.tic_tacgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import java.util.Timer;
import java.util.TimerTask;

public class Splash_Screen extends AppCompatActivity {
LottieAnimationView lottieAnimationView;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash_screen);
        textView=(TextView) findViewById(R.id.txt);
        final Animation anim = AnimationUtils.loadAnimation(this, R.anim.alphs);
        anim .setFillAfter(true);
        textView.startAnimation(anim);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/part.ttf");
        textView.setTypeface(type);


        Timer timer= new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);






        /*

       // setContentView(R.layout.activity_splash_screen);
/*
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }


        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);



      //  lottieAnimationView.setAnimation(R.raw.tae_tac);
        lottieAnimationView.playAnimation();
        lottieAnimationView.loop(true);

        getSupportActionBar().hide();
        textView=(TextView) findViewById(R.id.txt);
        final Animation anim = AnimationUtils.loadAnimation(this, R.anim.alphs);
        anim .setFillAfter(true);
        textView.startAnimation(anim);
/*
*/
    }
}
/* java k andr animation*/