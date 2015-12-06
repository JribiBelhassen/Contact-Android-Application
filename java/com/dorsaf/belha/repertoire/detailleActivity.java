package com.dorsaf.belha.repertoire;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.StringTokenizer;

public class detailleActivity extends Activity {
    TextView nom;
    TextView num;
    ImageButton b1;
    ImageButton b2;
    ImageButton b3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detaille);
        String phone = getIntent().getExtras().getString("phone");
        String name = getIntent().getExtras().getString("nom");
        nom = (TextView) findViewById(R.id.textView);
        num = (TextView) findViewById(R.id.textView2);
        b1 = (ImageButton) findViewById(R.id.imageButton);
        nom.setText(name);
        num.setText(phone);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+num.getText()));
                startActivity(i);
            }
        });

        b2 = (ImageButton)findViewById(R.id.smsbtn);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setData(Uri.parse("smsto:"));
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address"  , num.getText());
                startActivity(smsIntent);
            }
        });

        b3 = (ImageButton)findViewById(R.id.numsend);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setData(Uri.parse("smsto:"));
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("sms_body","Voici le numéro de \n"+nom.getText()+" : "+num.getText());
                startActivity(smsIntent);
            }
        });

    }
}
