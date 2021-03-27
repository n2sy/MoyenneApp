package nidhal.tp2.moyenneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;


public class SuccessActivity extends Activity {

    private TextView tv;
    //private Button btn_back;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        //btn_back = (Button) findViewById(R.id.Back);

        tv = (TextView) findViewById(R.id.resultatReuMoy);
        Intent j = getIntent();

        //String enseignant = getString(R.string.nidhal, "Nidhal",
             //   "Jelassi", 35);

        //String s1 = "Félicitations, votre moy est " +
          //      j.getFloatExtra("moy", 0);

        Float m = j.getFloatExtra("moy", 0);

        String msg = getString(R.string.success, m);

        tv.setText(msg);


    }

    public void RetournerHome(View v)
    {
        Intent i = new Intent (this, MainActivity.class);
        //i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(i);

    }

    public void SendSMS(View v)
    {
        Intent i = new Intent();
//        Intent i1 = new Intent();
//
//        i1.setAction(Intent.ACTION_DIAL);
//        i1.setData(Uri.parse("tel://12345678"));

        i.setAction(Intent.ACTION_SENDTO);
        i.setData(Uri.parse("smsto:98123456"));
        i.putExtra("sms_body", msg);

//        i.setAction(Intent.ACTION_SEND);
//        i.putExtra(Intent.EXTRA_TEXT, "Félicitations ! Votre moyenne est de " +
//            getIntent().getFloatExtra("moy", 0));
//
//        i.setType("text/plain");
        startActivity(i);
    }
}
