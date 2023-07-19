package lk.kasun.tictac;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tic_tacgame.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    int gameFinished = 100;
    int flag = 0;
    TextView b1, b2, b3, b4, b5, b6, b7, b8, b9, t, tt, ttt, fol,contact,about_us,help;
    int count = 0;
    static boolean Exit = false;
    ImageView imgM, repeat, exit;
    RadioGroup rGroup;
    RadioButton rb1, rb2;
    String tt1, tt2, tt3, tt4, tt5, tt6, tt7, tt8, tt9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (TextView) findViewById(R.id.ctxt1);
        b2 = (TextView) findViewById(R.id.ctxt2);
        b3 = (TextView) findViewById(R.id.ctxt3);
        b4 = (TextView) findViewById(R.id.ctxt4);
        b5 = (TextView) findViewById(R.id.ctxt5);
        b6 = (TextView) findViewById(R.id.ctxt6);
        b7 = (TextView) findViewById(R.id.ctxt7);
        b8 = (TextView) findViewById(R.id.ctxt8);
        b9 = (TextView) findViewById(R.id.ctxt9);
        imgM = (ImageView) findViewById(R.id.mood);
        fol = (TextView) findViewById(R.id.follow);
        contact = (TextView) findViewById(R.id.contactus);
        about_us = (TextView) findViewById(R.id.about_us);
        help = (TextView) findViewById(R.id.help);

        repeat = (ImageView) findViewById(R.id.repeat);
        exit = (ImageView) findViewById(R.id.Exit);
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/part.ttf");
        fol.setTypeface(type);


        UserNames userNames = new UserNames(this, "test");
        userNames.execute();

        rGroup = (RadioGroup) findViewById(R.id.Rgroup);
        rb1 = (RadioButton) findViewById(R.id.rgP1);
        rb2 = (RadioButton) findViewById(R.id.rgP2);
        getValue();

        fol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/sanuv9683"));
                startActivity(browserIntent);
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ContactUs.class);
                startActivity(intent);
                finish();
            }
        });
        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AboutUs.class);
                startActivity(intent);
                finish();
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Help.class);
                startActivity(intent);
                finish();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exit = true;
                callBackMethod();
            }
        });

        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t = b1;
                tt = b2;
                ttt = b3;
                gameAgain();
            }
        });
    }

    public void openNewScreen(View view) {
        Intent intent = new Intent(this, AboutUs.class);
        startActivity(intent);
    }

    private void getValue() {
        if (flag == 0) {
            rGroup.check(rb2.getId());
        } else if (flag == 1) {
            rGroup.check(rb1.getId());
        }
    }


    public void check(View view) {
        TextView txtchng = (TextView) view;
        if (gameFinished == 100) {
            if (txtchng.getText().equals("")) {
                if (flag == 0) {
                    txtchng.setText("0");
                    flag = 1;
                    getValue();
                    count++;
                } else {
                    txtchng.setText("X");
                    flag = 0;
                    getValue();
                    count++;
                }
            }

            if (count > 4) {
                tt1 = b1.getText().toString();
                tt2 = b2.getText().toString();
                tt3 = b3.getText().toString();
                tt4 = b4.getText().toString();
                tt5 = b5.getText().toString();
                tt6 = b6.getText().toString();
                tt7 = b7.getText().toString();
                tt8 = b8.getText().toString();
                tt9 = b9.getText().toString();

                if (b1.getText().toString().equals(b2.getText().toString()) && b2.getText().toString().equals(b3.getText().toString()) && !b1.getText().toString().equals("")) {
                    Toast.makeText(this, "Congratulation. You Won.!", Toast.LENGTH_SHORT).show();
                    afterWinner(b1, b2, b3);
                } else if (tt1.equals(tt4) && tt4.equals(tt7) && !tt1.equals("")) {
                    Toast.makeText(this, "Congratulation. You Won.!", Toast.LENGTH_SHORT).show();
                    afterWinner(b1, b4, b7);
                } else if (tt4.equals(tt5) && tt5.equals(tt6) && !tt4.equals("")) {
                    Toast.makeText(this, "Congratulation. You Won.!", Toast.LENGTH_SHORT).show();
                    afterWinner(b4, b5, b6);
                } else if (tt7.equals(tt8) && tt7.equals(tt9) && !tt7.equals("")) {
                    Toast.makeText(this, "Congratulation. You Won.!", Toast.LENGTH_SHORT).show();
                    afterWinner(b7, b8, b9);
                } else if (tt2.equals(tt5) && tt5.equals(tt8) && !tt2.equals("")) {
                    Toast.makeText(this, "Congratulation. You Won.!", Toast.LENGTH_SHORT).show();
                    afterWinner(b2, b5, b8);
                } else if (tt3.equals(tt6) && tt6.equals(tt9) && !tt3.equals("")) {
                    Toast.makeText(this, "Congratulation. You Won.!", Toast.LENGTH_SHORT).show();
                    afterWinner(b6, b9, b3);
                } else if (tt1.equals(tt5) && tt5.equals(tt9) && !tt1.equals("")) {
                    Toast.makeText(this, "Congratulation. You Won.!", Toast.LENGTH_SHORT).show();
                    afterWinner(b1, b5, b9);
                } else if (tt3.equals(tt5) && tt5.equals(tt7) && !tt7.equals("")) {
                    Toast.makeText(this, "Congratulation. You Won.!", Toast.LENGTH_SHORT).show();
                    afterWinner(b3, b5, b7);
                } else if (!tt7.equals("") && !tt1.equals("") && !tt2.equals("") && !tt3.equals("") && !tt4.equals("") && !tt5.equals("")
                        && !tt6.equals("") && !tt8.equals("") && !tt9.equals("")) {
                    Toast.makeText(this, "Try Again. Match Draw", Toast.LENGTH_SHORT).show();
                    gameAgain();
                }
            }
        } else {
            Toast.makeText(MainActivity.this, "Next match Start after 5 Sec", Toast.LENGTH_SHORT).show();
        }

    }

    void afterWinner(TextView t, TextView tt, TextView ttt) {
        this.t = t;
        this.tt = tt;
        this.ttt = ttt;
        rGroup.clearCheck();
        changeColour(t, ttt, tt);
        final Animation anim = AnimationUtils.loadAnimation(this, R.anim.alphs);
        anim.setFillAfter(true);
        t.startAnimation(anim);
        tt.startAnimation(anim);
        ttt.startAnimation(anim);
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotatee);
        animation.setFillAfter(true);
        imgM.startAnimation(animation);
        gameFinished = 200;
        gameAgain();
    }

    private void changeColour(TextView t, TextView ttt, TextView tt) {
        t.setTextColor(getResources().getColor(R.color.Red));
        tt.setTextColor(getResources().getColor(R.color.Red));
        ttt.setTextColor(getResources().getColor(R.color.Red));
    }

    private void normalColourAgain(TextView t, TextView ttt, TextView tt) {
        tt.setTextColor(getResources().getColor(R.color.black));
        ttt.setTextColor(getResources().getColor(R.color.black));
        t.setTextColor(getResources().getColor(R.color.black));
    }

    private void gameAgain() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getValue();
                gameFinished = 100;
                b1.setText("");
                b2.setText("");
                b3.setText("");
                b4.setText("");
                b5.setText("");
                b6.setText("");
                b7.setText("");
                b8.setText("");
                count = 0;
                normalColourAgain(t, ttt, tt);
                b9.setText("");
            }
        }, 4000);
    }


    @Override
    public void onBackPressed() {   //backPress Code
        callBackMethod();
    }

    private void callBackMethod() {
        if (Exit == true) {
            finish();
        } else {
            Toast.makeText(this, "Press Again to Exit", Toast.LENGTH_SHORT).show();
        }
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Exit = false;
            }
        }, 2000);
        Exit = true;
    }
}