package com.project.assignments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    ImageView imageView;
    Button btnStart;
    Animation blink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        btnStart = (Button) findViewById(R.id.btnStart);
        // loads the animation
        blink= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        //animF = AnimationUtils.loadAnimation(getApplicationContext(),
            //    R.anim.fade_in);

        // set listener
        blink.setAnimationListener(this);

        // button click event
        btnStart.setOnClickListener(new View.OnClickListener() {
            //fadein fade out effect in image view
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.VISIBLE);

                // start the animation
                imageView.startAnimation(blink);
            }
        });

    }

    @Override
    public void onAnimationEnd(Animation animation) {

        // check for fade in animation with image
        if (animation == blink) {

            imageView.startAnimation(blink);
            blink.start();
        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onAnimationStart(Animation animation) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
