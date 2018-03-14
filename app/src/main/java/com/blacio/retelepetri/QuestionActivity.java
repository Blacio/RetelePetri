package com.blacio.retelepetri;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class QuestionActivity extends Activity {

    private RadioGroup radioGr;
    private RadioButton radioBut,radioBut1,radioBut2,radioBut3,radioBut4;
    private Button btnDisplay;

    TextView tv;
    int count,count2,scor;
    String arr[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        count = 0;count2=0;

        arr = new String[4];

        radioBut1 = (RadioButton)findViewById(R.id.radio1);
        radioBut2 = (RadioButton)findViewById(R.id.radio2);
        radioBut3 = (RadioButton)findViewById(R.id.radio3);
        radioBut4 = (RadioButton)findViewById(R.id.radio4);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            count = extras.getInt("TAG",0);
            count2 = extras.getInt("TAG2",0);
            scor = extras.getInt("SCOR",0);
        }

        tv = (TextView) findViewById(R.id.intrebare);

        switch (count2) {
            case 0:
                tv.setText(R.string.i1);break;
            case 1:
                tv.setText(R.string.i2);break;
            case 2:
                tv.setText(R.string.i3);break;
            case 3:
                tv.setText(R.string.i4);break;
            case 4:
                tv.setText(R.string.i5);break;
            case 5:
                tv.setText(R.string.i6);break;
            default:break;
        }


        if(count==0){
            switch (count2) {

                case 0:{
                    arr[0]=getResources().getString(R.string.rc1);arr[1]=getResources().getString(R.string.rg11);
                    arr[2]=getResources().getString(R.string.rg12);arr[3]=getResources().getString(R.string.rg13);
                    arr = shuffleArray(arr);

                    radioBut1.setText(arr[0]);
                    radioBut2.setText(arr[1]);
                    radioBut3.setText(arr[2]);
                    radioBut4.setText(arr[3]);

                    break;

                }

                case 1:{
                    arr[0]=getResources().getString(R.string.rc2);arr[1]=getResources().getString(R.string.rg21);
                    arr[2]=getResources().getString(R.string.rg22);arr[3]=getResources().getString(R.string.rg23);
                    arr = shuffleArray(arr);

                    radioBut1.setText(arr[0]);
                    radioBut2.setText(arr[1]);
                    radioBut3.setText(arr[2]);
                    radioBut4.setText(arr[3]);

                    break;
                }

                case 2:{
                    arr[0]=getResources().getString(R.string.rc3);arr[1]=getResources().getString(R.string.rg31);
                    arr[2]=getResources().getString(R.string.rg32);arr[3]=getResources().getString(R.string.rg33);
                    arr = shuffleArray(arr);

                    radioBut1.setText(arr[0]);
                    radioBut2.setText(arr[1]);
                    radioBut3.setText(arr[2]);
                    radioBut4.setText(arr[3]);

                    break;
                }

                case 3:{
                    arr[0]=getResources().getString(R.string.rc4);arr[1]=getResources().getString(R.string.rg41);
                    arr[2]=getResources().getString(R.string.rg42);arr[3]=getResources().getString(R.string.rg43);
                    arr = shuffleArray(arr);

                    radioBut1.setText(arr[0]);
                    radioBut2.setText(arr[1]);
                    radioBut3.setText(arr[2]);
                    radioBut4.setText(arr[3]);

                    break;
                }


                case 4:{
                    arr[0]=getResources().getString(R.string.rc5);arr[1]=getResources().getString(R.string.rg51);
                    arr[2]=getResources().getString(R.string.rg52);arr[3]=getResources().getString(R.string.rg53);
                    arr = shuffleArray(arr);

                    radioBut1.setText(arr[0]);
                    radioBut2.setText(arr[1]);
                    radioBut3.setText(arr[2]);
                    radioBut4.setText(arr[3]);

                    break;
                }

                case 5:{
                    arr[0]=getResources().getString(R.string.rc6);arr[1]=getResources().getString(R.string.rg61);
                    arr[2]=getResources().getString(R.string.rg62);arr[3]=getResources().getString(R.string.rg63);
                    arr = shuffleArray(arr);

                    radioBut1.setText(arr[0]);
                    radioBut2.setText(arr[1]);
                    radioBut3.setText(arr[2]);
                    radioBut4.setText(arr[3]);

                    break;
                }
                default:break;

            }
        }


        else if(count==1){
            switch (count2) {

                case 0:{
                    arr[0]=getResources().getString(R.string.drc1);arr[1]=getResources().getString(R.string.drg11);
                    arr[2]=getResources().getString(R.string.drg12);arr[3]=getResources().getString(R.string.drg13);
                    arr = shuffleArray(arr);

                    radioBut1.setText(arr[0]);
                    radioBut2.setText(arr[1]);
                    radioBut3.setText(arr[2]);
                    radioBut4.setText(arr[3]);

                    break;

                }

                case 1:{
                    arr[0]=getResources().getString(R.string.drc2);arr[1]=getResources().getString(R.string.drg21);
                    arr[2]=getResources().getString(R.string.drg22);arr[3]=getResources().getString(R.string.drg23);
                    arr = shuffleArray(arr);

                    radioBut1.setText(arr[0]);
                    radioBut2.setText(arr[1]);
                    radioBut3.setText(arr[2]);
                    radioBut4.setText(arr[3]);

                    break;
                }

                case 2:{
                    arr[0]=getResources().getString(R.string.drc3);arr[1]=getResources().getString(R.string.drg31);
                    arr[2]=getResources().getString(R.string.drg32);arr[3]=getResources().getString(R.string.drg33);
                    arr = shuffleArray(arr);

                    radioBut1.setText(arr[0]);
                    radioBut2.setText(arr[1]);
                    radioBut3.setText(arr[2]);
                    radioBut4.setText(arr[3]);

                    break;
                }

                case 3:{
                    arr[0]=getResources().getString(R.string.drc4);arr[1]=getResources().getString(R.string.drg41);
                    arr[2]=getResources().getString(R.string.drg42);arr[3]=getResources().getString(R.string.drg43);
                    arr = shuffleArray(arr);

                    radioBut1.setText(arr[0]);
                    radioBut2.setText(arr[1]);
                    radioBut3.setText(arr[2]);
                    radioBut4.setText(arr[3]);

                    break;
                }


                case 4:{
                    arr[0]=getResources().getString(R.string.drc5);arr[1]=getResources().getString(R.string.drg51);
                    arr[2]=getResources().getString(R.string.drg52);arr[3]=getResources().getString(R.string.drg53);
                    arr = shuffleArray(arr);

                    radioBut1.setText(arr[0]);
                    radioBut2.setText(arr[1]);
                    radioBut3.setText(arr[2]);
                    radioBut4.setText(arr[3]);

                    break;
                }

                case 5:{
                    arr[0]=getResources().getString(R.string.drc6);arr[1]=getResources().getString(R.string.drg61);
                    arr[2]=getResources().getString(R.string.drg62);arr[3]=getResources().getString(R.string.drg63);
                    arr = shuffleArray(arr);

                    radioBut1.setText(arr[0]);
                    radioBut2.setText(arr[1]);
                    radioBut3.setText(arr[2]);
                    radioBut4.setText(arr[3]);

                    break;
                }
                default:break;

            }
        }



        else {
            switch (count2) {

                case 0:{
                    arr[0]=getResources().getString(R.string.xrc1);arr[1]=getResources().getString(R.string.xrg11);
                    arr[2]=getResources().getString(R.string.xrg12);arr[3]=getResources().getString(R.string.xrg13);
                    arr = shuffleArray(arr);

                    radioBut1.setText(arr[0]);
                    radioBut2.setText(arr[1]);
                    radioBut3.setText(arr[2]);
                    radioBut4.setText(arr[3]);

                    break;

                }

                case 1:{
                    arr[0]=getResources().getString(R.string.xrc2);arr[1]=getResources().getString(R.string.xrg21);
                    arr[2]=getResources().getString(R.string.xrg22);arr[3]=getResources().getString(R.string.xrg23);
                    arr = shuffleArray(arr);

                    radioBut1.setText(arr[0]);
                    radioBut2.setText(arr[1]);
                    radioBut3.setText(arr[2]);
                    radioBut4.setText(arr[3]);

                    break;
                }

                case 2:{
                    arr[0]=getResources().getString(R.string.xrc3);arr[1]=getResources().getString(R.string.xrg31);
                    arr[2]=getResources().getString(R.string.xrg32);arr[3]=getResources().getString(R.string.xrg33);
                    arr = shuffleArray(arr);

                    radioBut1.setText(arr[0]);
                    radioBut2.setText(arr[1]);
                    radioBut3.setText(arr[2]);
                    radioBut4.setText(arr[3]);

                    break;
                }

                case 3:{
                    arr[0]=getResources().getString(R.string.xrc4);arr[1]=getResources().getString(R.string.xrg41);
                    arr[2]=getResources().getString(R.string.xrg42);arr[3]=getResources().getString(R.string.xrg43);
                    arr = shuffleArray(arr);

                    radioBut1.setText(arr[0]);
                    radioBut2.setText(arr[1]);
                    radioBut3.setText(arr[2]);
                    radioBut4.setText(arr[3]);

                    break;
                }


                case 4:{
                    arr[0]=getResources().getString(R.string.xrc5);arr[1]=getResources().getString(R.string.xrg51);
                    arr[2]=getResources().getString(R.string.xrg52);arr[3]=getResources().getString(R.string.xrg53);
                    arr = shuffleArray(arr);

                    radioBut1.setText(arr[0]);
                    radioBut2.setText(arr[1]);
                    radioBut3.setText(arr[2]);
                    radioBut4.setText(arr[3]);

                    break;
                }

                case 5:{
                    arr[0]=getResources().getString(R.string.xrc6);arr[1]=getResources().getString(R.string.xrg61);
                    arr[2]=getResources().getString(R.string.xrg62);arr[3]=getResources().getString(R.string.xrg63);
                    arr = shuffleArray(arr);

                    radioBut1.setText(arr[0]);
                    radioBut2.setText(arr[1]);
                    radioBut3.setText(arr[2]);
                    radioBut4.setText(arr[3]);

                    break;
                }
                default:break;

            }
        }

        addListenerOnButton();
    }


    public void addListenerOnButton() {

        radioGr = (RadioGroup) findViewById(R.id.radioGr);
        btnDisplay = (Button) findViewById(R.id.buton_resultat);

        btnDisplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioGr.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioBut = (RadioButton) findViewById(selectedId);


                if(count==0) {
                    switch (count2) {
                        case 0: {
                            if (radioBut.getText().toString().equals(getResources().getString(R.string.rc1))) {
                                scor++;createDialog(true);
                                break;
                            } else {
                                createDialog(false);
                                break;
                            }
                        }
                        case 1: {
                            if (radioBut.getText().toString().equals(getResources().getString(R.string.rc2))) {
                                scor++;createDialog(true);
                                break;
                            } else {
                                createDialog(false);
                                break;
                            }
                        }
                        case 2: {
                            if (radioBut.getText().toString().equals(getResources().getString(R.string.rc3))) {
                                scor++;createDialog(true);
                                break;
                            } else {
                                createDialog(false);
                                break;
                            }
                        }
                        case 3: {
                            if (radioBut.getText().toString().equals(getResources().getString(R.string.rc4))) {
                                scor++;createDialog(true);
                                break;
                            } else {
                                createDialog(false);
                                break;
                            }
                        }
                        case 4: {
                            if (radioBut.getText().toString().equals(getResources().getString(R.string.rc5))) {
                                scor++;createDialog(true);
                                break;
                            } else {
                                createDialog(false);
                                break;
                            }
                        }
                        case 5: {
                            if (radioBut.getText().toString().equals(getResources().getString(R.string.rc6))) {
                                scor++;createDialog(true);
                                break;
                            } else {
                                createDialog(false);
                                break;
                            }
                        }
                        default:break;
                    }
                }


                else if(count==1) {
                    switch (count2) {
                        case 0: {
                            if (radioBut.getText().toString().equals(getResources().getString(R.string.drc1))) {
                                scor++;createDialog(true);
                                break;
                            } else {
                                createDialog(false);
                                break;
                            }
                        }
                        case 1: {
                            if (radioBut.getText().toString().equals(getResources().getString(R.string.drc2))) {
                                scor++;createDialog(true);
                                break;
                            } else {
                                createDialog(false);
                                break;
                            }
                        }
                        case 2: {
                            if (radioBut.getText().toString().equals(getResources().getString(R.string.drc3))) {
                                scor++;createDialog(true);
                                break;
                            } else {
                                createDialog(false);
                                break;
                            }
                        }
                        case 3: {
                            if (radioBut.getText().toString().equals(getResources().getString(R.string.drc4))) {
                                scor++;createDialog(true);
                                break;
                            } else {
                                createDialog(false);
                                break;
                            }
                        }
                        case 4: {
                            if (radioBut.getText().toString().equals(getResources().getString(R.string.drc5))) {
                                scor++;createDialog(true);
                                break;
                            } else {
                                createDialog(false);
                                break;
                            }
                        }
                        case 5: {
                            if (radioBut.getText().toString().equals(getResources().getString(R.string.drc6))) {
                                scor++;createDialog(true);
                                break;
                            } else {
                                createDialog(false);
                                break;
                            }
                        }
                        default:break;}}




                else {
                    switch (count2) {
                        case 0: {
                            if (radioBut.getText().toString().equals(getResources().getString(R.string.xrc1))) {
                                scor++;createDialog(true);
                                break;
                            } else {
                                createDialog(false);
                                break;
                            }
                        }
                        case 1: {
                            if (radioBut.getText().toString().equals(getResources().getString(R.string.xrc2))) {
                                scor++;createDialog(true);
                                break;
                            } else {
                                createDialog(false);
                                break;
                            }
                        }
                        case 2: {
                            if (radioBut.getText().toString().equals(getResources().getString(R.string.xrc3))) {
                                scor++;createDialog(true);
                                break;
                            } else {
                                createDialog(false);
                                break;
                            }
                        }
                        case 3: {
                            if (radioBut.getText().toString().equals(getResources().getString(R.string.xrc4))) {
                                scor++;createDialog(true);
                                break;
                            } else {
                                createDialog(false);
                                break;
                            }
                        }
                        case 4: {
                            if (radioBut.getText().toString().equals(getResources().getString(R.string.xrc5))) {
                                scor++;createDialog(true);
                                break;
                            } else {
                                createDialog(false);
                                break;
                            }
                        }
                        case 5: {
                            if (radioBut.getText().toString().equals(getResources().getString(R.string.xrc6))) {
                                scor++;createDialog(true);
                                break;
                            } else {
                                createDialog(false);
                                break;
                            }
                        }
                        default:break;}}
            }

        });

    }

    private void createDialog(boolean b){

        save_data();

        AlertDialog.Builder builder = new AlertDialog.Builder(QuestionActivity.this);

        if(b) builder.setMessage("Corect");
        else {
            switch (count2){
                case 0:{builder.setMessage(getResources().getString(R.string.explicatie1));break;}
                case 1:{builder.setMessage(getResources().getString(R.string.explicatie2));break;}
                case 2:{builder.setMessage(getResources().getString(R.string.explicatie3));break;}
                case 3:{builder.setMessage(getResources().getString(R.string.explicatie4));break;}
                case 4:{builder.setMessage(getResources().getString(R.string.explicatie5));break;}
                case 5:{builder.setMessage(getResources().getString(R.string.explicatie6));break;}
                    default:break;
            }
        }

        builder.setTitle("QUIZ")
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setPositiveButton("Continua", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        count2++;
                        if(count2==6)
                            startIntent2();
                        else
                            startIntent(count,count2,true);
                    }
                })
                .setNegativeButton("Renunta", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startIntent(count,count2,false);
                    }
                });

        builder.create().show();

    }

    private void startIntent2() {

        Intent i = new Intent(this, ResultsActivity.class);
        startActivity(i);
    }

    private void save_data() {

        SharedPreferences sharedPrefr = getSharedPreferences("Rezumat", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefr.edit();

        if(count==0)
            editor.putInt("joc_unu",scor);
        else if(count==1)
            editor.putInt("joc_doi",scor);
        else editor.putInt("joc_trei",scor);

        editor.apply();
    }

    public void startIntent(int x,int y,boolean b){

        if(b) {
            Intent i = new Intent(this, QuestionActivity.class);
            i.putExtra("TAG", x);
            i.putExtra("TAG2", y);
            i.putExtra("SCOR",scor);
            startActivity(i);
        }

        else{
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }


    private String[] shuffleArray(String[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            if (i == index) {
                ++i;
            } else {
                String a = ar[index];
                ar[index] = ar[i];
                ar[i] = a;
            }
        }

        return ar;
    }


    public void onBackPressed(){
            createDialog2().show();
    }


    Dialog createDialog2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(QuestionActivity.this);
        builder.setTitle("QUIZ")
                .setMessage("Sunteti sigur ca doriti sa abandonati ?")
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("Da", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        save_data();
                        startIntent(count,count2,false);
                    }
                })
                .setNegativeButton("Nu", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        return builder.create();
    }

    }

