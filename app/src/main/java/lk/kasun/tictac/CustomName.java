package lk.kasun.tictac;

import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.example.tic_tacgame.R;

public class CustomName {
    MainActivity mainActivity;
    String[] add = new String[2];
    Dialog dialog;

    public CustomName(MainActivity mainActivity, String st) {
        this.mainActivity = mainActivity;
    }

    void execute() {
        dialog = new Dialog(mainActivity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_name_ask_dialoge);
        dialog.setCancelable(true);
        com.google.android.material.button.MaterialButton cardView = (com.google.android.material.button.MaterialButton) dialog.findViewById(R.id.playBtn);
        EditText editText = (EditText) dialog.findViewById(R.id.play1);
        EditText editText1 = (EditText) dialog.findViewById(R.id.play2);

        dialog.show();
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().equals("") || editText1.getText().toString().equals("")) {
                    Toast.makeText(mainActivity, "Please Enter A Name", Toast.LENGTH_SHORT).show();
                } else {
                    add[0] = editText.getText().toString();
                    add[1] = editText1.getText().toString();
                    dialog.dismiss();
                    nameGroup();
                }
            }
        });

        nameGroup();

    }

    private final void nameGroup() {
        RadioButton radioButton = mainActivity.findViewById(R.id.rgP1);
        radioButton.setText(add[0]);
        RadioButton radioButton1 = mainActivity.findViewById(R.id.rgP2);
        radioButton1.setText(add[1]);
        radioButton.getId();
        RadioGroup radioGroup = mainActivity.findViewById(R.id.Rgroup);
    }


}
