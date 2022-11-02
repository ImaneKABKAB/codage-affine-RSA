package com.example.androidproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class Activity3 extends AppCompatActivity {
private TextView res;
private TextView temps;
    //cles secretes a et b ,n
static int a=17;
static int b=20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        res=(TextView) findViewById(R.id.codeAFFINE);
        temps=(TextView) findViewById(R.id.timeAFFINE);
        /*Recupération des donnees envoyees par l'activite main*/
        Bundle ba=getIntent().getExtras();
        String strAFFINE=ba.getString("msgAFFINE");
        //Recuperation du temps actuel en milisecondes
        Calendar calendar=Calendar.getInstance();
        long ta1=calendar.getTimeInMillis();
        //cryptage affine du message
        String cipher=encryptMessage(strAFFINE.toCharArray());
        long ta2=calendar.getTimeInMillis();
        //Recuperation du temps d'execution en milisecondes
        long ta=ta2-ta1;
        //Affichage des resultats
        res.setText(cipher);
        temps.setText(String.valueOf(ta));

    }
    //methode de cryptage affine
    static String encryptMessage(char[] msge){
        StringBuilder cipher= new StringBuilder();
        int i;
        for (i=0;i<msge.length;i++) {
            if (msge[i] != ' ') {
                cipher.append((char) ((((a * (msge[i] - 'A')) + b) % 26) + 'A'));
            } else cipher.append(msge[i]);
        }
   return cipher.toString();
    }
}