package com.example.lv2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class LoadingView extends Activity {
    private Animation myAlphaAnimation;
    private ImageView myImageView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadingview);
        myImageView=(ImageView)findViewById(R.id.ic_view_loading);
        myImageView.setImageResource(R.drawable.ic_loading);
        myAlphaAnimation=new RotateAnimation(0f, 360f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        myAlphaAnimation.setRepeatCount(3);
        myAlphaAnimation.setDuration(1000);
        myAlphaAnimation.setInterpolator(new LinearInterpolator());
        myImageView.setAnimation(myAlphaAnimation);
        myAlphaAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent2=new Intent(LoadingView.this,Lv1.class);
                startActivity(intent2);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

}