package com.example.shop2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText loginAccount_etext;
    private EditText loginPassword_etext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginAccount_etext = findViewById(R.id.loginAccount_etext);
        loginPassword_etext = findViewById(R.id.loginPassword_etext);
        Button loginBtn = findViewById(R.id.loginBtn);
        Button registerBtn = findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(this);
        loginBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginBtn:
                String loginAddress="http://10.18.22.50:8080/shop1/LoginServlet";
                String loginAccount = loginAccount_etext.getText().toString();
                String loginPassword = loginPassword_etext.getText().toString();
                loginWithOkHttp(loginAddress,loginAccount,loginPassword);
                break;
            case R.id.registerBtn:
                String registerAddress="http://10.18.22.50:8080/shop1/RegisterServlet";
                String registerAccount = loginAccount_etext.getText().toString();
                String registerPassword = loginPassword_etext.getText().toString();
                registerWithOkHttp(registerAddress,registerAccount,registerPassword);
                break;
            default:
                break;
        }
    }

    //实现登录
    public void loginWithOkHttp(String address,String account,String password){
        HttpUtil.loginWithOkHttp(address,account,password, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //在这里对异常情况进行处理
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //得到服务器返回的具体内容
                final String responseData = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (responseData.equals("true")){
                            Intent intent = new Intent(MainActivity.this,productadapter.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(MainActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    //实现注册
    public void registerWithOkHttp(String address,String account,String password){
        HttpUtil.registerWithOkHttp(address, account, password, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //在这里对异常情况进行处理
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseData = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (responseData.equals("true")){
                            Toast.makeText(MainActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}