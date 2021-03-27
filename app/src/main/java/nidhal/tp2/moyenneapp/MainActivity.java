package nidhal.tp2.moyenneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText val1;
    private EditText val2;
    private EditText val3;
    //private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        val1 = findViewById(R.id.note1);
        val2 = (EditText) findViewById(R.id.note2);
        val3 = (EditText) findViewById(R.id.note3);
        //btn = (Button) findViewById(R.id.bcalcul);

        


    }


    public void calculerMoyenne(View v) {

        String ch1 = val1.getText().toString();
        String ch2 = val2.getText().toString();
        String ch3 = val3.getText().toString();

        if (ch1.equals("") || ch2.equals("") || ch3.equals("")) {
            AlertDialog alertDialog;
            alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Attention! ");
            alertDialog.setMessage("Veuillez saisir les 3 notes pour calculer la moyenne!");
            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertDialog.show();

        } else {

            float num1 = Float.parseFloat(ch1);
            float num2 = Float.valueOf(ch2);
            float num3 = Float.valueOf(ch3);

            float moy = (num1 + num2 + num3) / 3;
            //String s = String.valueOf(moy);


            if (moy >= 10) {
                Intent i = new Intent(MainActivity.this, SuccessActivity.class);
                //String s = String.format("%.2f", moy);
                i.putExtra("moy", moy);
                startActivity(i);

            } else {
                Intent i = new Intent(this, FailActivity.class);
                i.putExtra("moy", moy);
                startActivity(i);
            }

        }


    }

}
