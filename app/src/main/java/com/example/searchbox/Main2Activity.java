package com.example.searchbox;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Main2Activity extends AppCompatActivity {

    TextView tv;
    String st;
    String search;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv=(TextView) findViewById(R.id.textView);

        st=getIntent().getExtras().getString("Value");
        tv.setText(st);


        bt=(Button) findViewById(R.id.buttonSearch);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent i=new Intent(Main2Activity.this,Main3Activity.class);
                search=tv.getText().toString();
                i.putExtra("search",search);
                startActivity(i);
                finish();
                */
                search =tv.getText().toString();
                try {
                    search = URLEncoder.encode(search, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                Uri uri = Uri.parse("http://www.google.com/#q=" + search);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                finish();
            }
        });
    }
}

