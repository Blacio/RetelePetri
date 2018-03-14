package com.blacio.retelepetri;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;


public class ResultsActivity extends Activity {

    TextView tv,tvi,tvex;
    String str;
    int sc1,sc2,sc3;
    int sw;
    int tries;
    float medie1,medie2,medie3,medie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        tv = (TextView)findViewById(R.id.rezultat_medie);
        tvi = (TextView)findViewById(R.id.rezultate_individuale);
        tvex = (TextView)findViewById(R.id.nr_exercitii);

        sw=0;

        SharedPreferences sharedPrefr = getSharedPreferences("Rezumat", Context.MODE_PRIVATE);

        str = sharedPrefr.getString("nume"," ");
        sc1 = sharedPrefr.getInt("joc_unu",-1);
        sc2 = sharedPrefr.getInt("joc_doi",-1);
        sc3 = sharedPrefr.getInt("joc_trei",-1);
        tries = sharedPrefr.getInt("TRY",0);

        if(sc1!=-1) sw++;
        if(sc2!=-1) sw++;
        if(sc3!=-1) sw++;

        if(sw!=0) {
            if(sc1==-1) medie1=0; else medie1 = (float)(10*sc1)/6;
            if(sc2==-1) medie2=0; else medie2 = (float)(10*sc2)/6;
            if(sc3==-1) medie3=0; else medie3 = (float)(10*sc3)/6;

            medie = medie1+medie2+medie3;
            medie = medie / sw;
        }
        else
            medie = 0;


        tv.setText(str +",\nmedia ta in acest moment este:\n"+new DecimalFormat("##.##").format(medie));
        tvi.setText("Medie Quiz 1: "+new DecimalFormat("##.##").format(medie1) +"\nMedie Quiz 2: "+new DecimalFormat("##.##").format(medie2) +"\nMedie Quiz 3: "+new DecimalFormat("##.##").format(medie3));
        tvex.setText("QUIZ-uri abordate: "+sw+"/3\nNumar de incercari: "+tries);

    }


    public void onBackPressed(){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
