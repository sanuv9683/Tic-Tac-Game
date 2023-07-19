package lk.kasun.tictac;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tic_tacgame.R;

import java.util.Timer;
import java.util.TimerTask;

public class Splash_Screen extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash_screen);
        textView = (TextView) findViewById(R.id.txt);
        final Animation anim = AnimationUtils.loadAnimation(this, R.anim.alphs);
        anim.setFillAfter(true);
        textView.startAnimation(anim);
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/part.ttf");
        textView.setTypeface(type);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 4000);
    }
}
