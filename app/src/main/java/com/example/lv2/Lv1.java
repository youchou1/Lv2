package com.example.lv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class Lv1 extends BaseActivity {
    private Button mBtnNot;
    private int mWinWidth;
    private int mWinHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv1);
        Button forceOffline=(Button)findViewById(R.id.force_offline);
        forceOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent("com.example.broadcastbestpractice.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
        initView();
        initEvent();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        mWinWidth = displayMetrics.widthPixels;
        mWinHeight = displayMetrics.heightPixels;
    }
    private void initView() {
        mBtnNot = findViewById(R.id.btn_main_not);
    }

    private void initEvent() {
        mBtnNot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                float x = new Random().nextInt(mWinWidth - 2*v.getWidth());
                float y = new Random().nextInt(mWinHeight - 2*v.getHeight());
                v.setX(x);
                v.setY(y);
            }
        });
    }
}