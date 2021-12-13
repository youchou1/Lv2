package com.example.lv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    private EditText mEtUsername;
    private EditText mEtPassword;
    private Button mBtnLogin;
    private Button mBtnRegister;
    private CheckBox mCbRememberPass;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initLogin();
        initRegister();
        initRemember();
    }
    private void initRemember () {
        SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
        boolean isRemember = pref.getBoolean("remember_password", false);
        if (isRemember) {
            String username = pref.getString("username", "");
            String password = pref.getString("password", "");
            mEtUsername.setText(username);
            mEtPassword.setText(password);
            mCbRememberPass.setChecked(true);
        }
    }
    private void initView() {

        mEtUsername = findViewById(R.id.et_main_username);
        mEtPassword = findViewById(R.id.et_main_password);
        mBtnLogin = findViewById(R.id.btn_main_login);
        mBtnRegister=findViewById(R.id.btn_main_register);
        mCbRememberPass=findViewById(R.id.cb_remember_pass);
    }
    private void initLogin() {
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_main_login:
                        login();
                        break;
                }
            }
        });
    }
    private void initRegister(){
        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(MainActivity.this,Register.class);
                startActivity(intent3);
            }
        });
    }
    private void login() {
        SharedPreferences pref=getSharedPreferences("data",MODE_PRIVATE);
        String username = pref.getString("username","");
        String password = pref.getString("password","");
        String username1=mEtUsername.getText().toString();
        String password1=mEtPassword.getText().toString();
        if (username1.equals(username) && password1.equals(password)) {
            editor=pref.edit();
            if(mCbRememberPass.isChecked()){
                editor.putBoolean("remember_password",true);
                editor.putString("username",username);
                editor.putString("password",password);
            }else{
                editor.clear();
            }
            editor.apply();
            loginSuccess();
            Intent intent1 = new Intent(this, LoadingView.class);
            startActivity(intent1);
            finish();
        } else {
            loginFailure();
        }
    }
    private void loginSuccess(){
        Toast.makeText(this,"登入成功！",Toast.LENGTH_SHORT).show();
    }
    private void loginFailure(){
        Toast.makeText(this,"账号或密码可能输入错了呢:(",Toast.LENGTH_SHORT).show();
    }
}