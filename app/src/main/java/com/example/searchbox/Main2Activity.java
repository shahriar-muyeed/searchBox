package com.example.searchbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tv;
    String st,search;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv=findViewById(R.id.textView);

        st=getIntent().getExtras().getString("Value");
        tv.setText(st);

        bt.findViewById(R.id.buttonSearch);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main2Activity.this,Main3Activity.class);
                search=tv.getText().toString();
                i.putExtra("search",search);
                startActivity(i);
                finish();
            }
        });



    }
}
