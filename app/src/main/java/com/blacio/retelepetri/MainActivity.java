package com.blacio.retelepetri;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    String[] index;
    boolean bol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        index = new String[3];

            index[0] = "Quiz nr. 1";
            index[1] = "Quiz nr. 2";
            index[2] = "Quiz nr. 3";

        SharedPreferences sharedPrefr = getSharedPreferences("Rezumat", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefr.edit();

        bol = sharedPrefr.getBoolean("bool",true);

        if(bol) {
            create_name_dialog("Cum va numiti ?", "nume");

            editor.putBoolean("bool", false);
            editor.apply();
        }

    }

    public void teorie(View v){
        Intent i = new Intent(this,TheoryActivity.class);
        startActivity(i);
    }

    public void quiz(View v) {
        createDialog(index).show();
    }


    public void medie(View v){
        Intent i = new Intent (this,ResultsActivity.class);
        startActivity(i);
    }


        Dialog createDialog(final String [] index) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Alegeti un tip de Retea Petri")
                    .setIcon(R.mipmap.ic_launcher)
                    .setItems(index, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            startIntent(which);

                        }
                    });
            return builder.create();
        }


    private void create_name_dialog(String text, final String s) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        final EditText input = new EditText(MainActivity.this);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);


        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
        input.setLayoutParams(lp);

        input.setFilters(new InputFilter[] {new InputFilter.LengthFilter(9)});

        builder.setTitle("Type your name")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage(text)
                .setView(input)
                .setCancelable(false)
                .setNeutralButton("OK",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which){

                        SharedPreferences sharedPrefr = getSharedPreferences("Rezumat", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPrefr.edit();

                        editor.putString(s, input.getText().toString());
                        editor.apply();

                    }
                });

        builder.create().show();
    }


    public void startIntent(int x){
        Intent i = new Intent (this,ImageActivity.class);
        i.putExtra("TAG",x);
        startActivity(i);
    }

    public void onBackPressed(){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
