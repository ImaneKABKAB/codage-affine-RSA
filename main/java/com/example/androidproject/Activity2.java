package com.example.androidproject;
import java.math.*;
import java.util.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
private TextView resultat;
private TextView time;
       @Override
       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_2);
           resultat=(TextView) findViewById(R.id.codeRSA);
           time=(TextView) findViewById(R.id.timeRSA);
           /*Recupération des donnees envoyees par l'activite main*/
        Bundle b=getIntent().getExtras();
        String strRSA=b.getString("msgRSA");
        //Recuperation du temps actuel en milisecondes
        long t1= System.currentTimeMillis();
        //DEclaration et initiation des cles RSA
           int p=3,q=11;
           int n=p*q;
       int z=(p-1)*(q-1);
           StringBuilder enc= new StringBuilder();
           int e,i;
           for(e=2;e<z;e++)
           {
               if(pgcd(e,z)==1) break;
           }
           //chiffrement RSA
          char[] msg=strRSA.toCharArray();
           for(i=0;i<msg.length;i++) {
               if (msg[i] != ' ') {
                   enc.append((char) (((Math.pow(msg[i], e)) % n)+'A'));
               }
               else enc.append(msg[i]);
           }
           long t2= System.currentTimeMillis();
           //Recuperation du temps d'execution en milisecondes
           long t=t2-t1;
           //Affichage des resultats
       resultat.setText(String.valueOf(enc));
       time.setText(String.valueOf(t));
}
//methode de recherche de pgcd
static int pgcd(int e,int z){
        if(e==0) return z;
        else return pgcd(z % e, e);
    }
}
