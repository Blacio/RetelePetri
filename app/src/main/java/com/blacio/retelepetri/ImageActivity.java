package com.blacio.retelepetri;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class ImageActivity extends Activity implements View.OnTouchListener {

    int count;
    ImageView img;


    private static final String TAG = "Touch";
    private static final float MIN_ZOOM = 1f, MAX_ZOOM = 1f;

    Matrix matrix = new Matrix();
    Matrix savedMatrix = new Matrix();

    static final int NONE = 0;
    static final int DRAG = 1;
    static final int ZOOM = 2;
    int mode = NONE;

    PointF start = new PointF();
    PointF mid = new PointF();
    float oldDist = 1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        img = (ImageView) findViewById(R.id.imagine_RP);
        img.setOnTouchListener(this);

        count = 0;

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            count = extras.getInt("TAG");
        }


        switch (count) {
            case 0:
                img.setImageResource(R.mipmap.rp1);
                break;
            case 1:
                img.setImageResource(R.mipmap.rp2);
                break;
            case 2:
                img.setImageResource(R.mipmap.rp3);
                break;
            default:
                break;
        }

        SharedPreferences sharedPrefr = getSharedPreferences("Rezumat", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefr.edit();

        int incercari = sharedPrefr.getInt("TRY", 0);
        incercari += 1;

        editor.putInt("TRY", incercari);
        editor.apply();

        createDialog();

    }

    public void incepe_quiz_button(View v) {
        startIntent(count);
    }

    public void startIntent(int x) {
        Intent i = new Intent(this, QuestionActivity.class);
        i.putExtra("TAG", x);
        i.putExtra("TAG2", 0);
        i.putExtra("SCOR", 0);
        startActivity(i);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        ImageView view = (ImageView) v;
        view.setScaleType(ImageView.ScaleType.MATRIX);
        float scale;


        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                savedMatrix.set(matrix);
                start.set(event.getX(), event.getY());
                mode = DRAG;
                break;

            case MotionEvent.ACTION_UP: // first finger lifted

            case MotionEvent.ACTION_POINTER_UP: // second finger lifted

                mode = NONE;
                break;

            case MotionEvent.ACTION_POINTER_DOWN: // first and second finger down

                oldDist = spacing(event);
                if (oldDist > 5f) {
                    savedMatrix.set(matrix);
                    midPoint(mid, event);
                    mode = ZOOM;
                }
                break;

            case MotionEvent.ACTION_MOVE:

                if (mode == DRAG) {
                    matrix.set(savedMatrix);
                    matrix.postTranslate(event.getX() - start.x, event.getY() - start.y); // create the transformation in the matrix  of points
                } else if (mode == ZOOM) {
                    // pinch zooming
                    float newDist = spacing(event);
                    if (newDist > 5f) {
                        matrix.set(savedMatrix);
                        scale = newDist / oldDist; // setting the scaling of the
                        // matrix...if scale > 1 means
                        // zoom in...if scale < 1 means
                        // zoom out
                        matrix.postScale(scale, scale, mid.x, mid.y);
                    }
                }
                break;
        }

        view.setImageMatrix(matrix); // display the transformation on screen

        return true; // indicate event was handled
    }

    private float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float)Math.sqrt(x * x + y * y);
    }


    private void midPoint(PointF point, MotionEvent event) {
        float x = event.getX(0) + event.getX(1);
        float y = event.getY(0) + event.getY(1);
        point.set(x / 2, y / 2);
    }



    private void createDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(ImageActivity.this);
        builder.setTitle("QUIZ")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("Realizati arborele de acoperire pentru urmatoarea Retea Petri dupa care incepeti testul")
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                    }
                });

        builder.create().show();

    }


}