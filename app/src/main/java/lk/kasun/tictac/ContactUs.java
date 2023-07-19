package lk.kasun.tictac;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tic_tacgame.R;

import java.util.Timer;
import java.util.TimerTask;

public class ContactUs extends AppCompatActivity {
    ImageView imgM;
    Button btn;

    EditText firstName,email,tp,message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us);

        imgM = (ImageView) findViewById(R.id.fixed_button);
        btn = (Button) findViewById(R.id.send_btn);

        // Text fields initialization
        firstName = (EditText) findViewById(R.id.first_name);
        email = (EditText) findViewById(R.id.email);
        tp = (EditText) findViewById(R.id.tp);
        message = (EditText) findViewById(R.id.message_d);

        imgM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String first_Name = firstName.getText().toString();
                String email_Address = email.getText().toString();
                String tp_No = tp.getText().toString();
                String user_Message = message.getText().toString();
                System.out.println(first_Name+" "+email_Address+" "+tp_No+" "+user_Message);

                String[] recipients = {email_Address.trim()};
                String subject = "I am "+ first_Name;
                String body = user_Message;

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, body);

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

                Toast.makeText(ContactUs.this, "Message Sent", Toast.LENGTH_SHORT).show();

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
        });
    }
}
