package nidhal.tp2.moyenneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class FailActivity extends AppCompatActivity {

    private Button btn_back;
    private TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fail);

        btn_back = (Button) findViewById(R.id.Back);

        msg = (TextView) findViewById(R.id.resultatMoy);
        Intent j = getIntent();

        String s1 = "Désolé, vous êtes ajourné. Votre moy est " +
                j.getFloatExtra("moy", 0);

        String s = getString(R.string.success,
                j.getFloatExtra("moy", 0));

        msg.setText(s);


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

        i.setAction(Intent.ACTION_SENDTO);
        i.setData(Uri.parse("smsto:98123456"));
        i.putExtra("sms_body", "Désolé, vous êtes ajournée ! Votre moyenne est de " +getIntent().getStringExtra("moy"));

//          i.setAction(Intent.ACTION_SEND);
        //i.putExtra(Intent.EXTRA_TEXT, "Félicitations ! Votre moyenne est de "+
        //    getIntent().getFloatExtra("moy", 0));

        //i.setType("text/plain");
        startActivity(i);
    }
}
