package com.example.meecartsellerapp_onlinevegetablesgroceriesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegLogChoice extends AppCompatActivity {
    Button reg,log;
    TextView admlog,status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_log_choice);
        reg=(Button)findViewById(R.id.btn_register);
        log=(Button)findViewById(R.id.btnlogin);
        admlog=(TextView)findViewById(R.id.admlog);
        status=(TextView)findViewById(R.id.tvstatus);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegLogChoice.this,LoginPage.class);
                startActivity(intent);
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegLogChoice.this,RegisterPage.class);
                startActivity(intent);
            }
        });
        admlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegLogChoice.this,AdminLogin.class));
            }
        });
        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegLogChoice.this,status.class));
            }
        });
    }
    public void onBackPressed(){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
