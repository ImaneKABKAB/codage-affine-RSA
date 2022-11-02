package com.example.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=(Button) findViewById(R.id.button1);
        button2=(Button) findViewById(R.id.button2);
        text=(EditText) findViewById(R.id.editTextTextPersonName);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CodeAffine();

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CodeRSA();

            }
        });

    }
    public void  CodeAffine(){
        Intent intent = new Intent(this,Activity3.class);
        intent.putExtra("msgAFFINE",text.getText().toString());
        startActivity(intent);

    }
    public void  CodeRSA(){
        Intent intent = new Intent(this,Activity2.class);
        intent.putExtra("msgRSA",text.getText().toString());
        startActivity(intent);

    }

}