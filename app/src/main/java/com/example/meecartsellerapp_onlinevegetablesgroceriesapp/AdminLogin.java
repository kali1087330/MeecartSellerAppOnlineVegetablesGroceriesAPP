package com.example.meecartsellerapp_onlinevegetablesgroceriesapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AdminLogin extends AppCompatActivity {
    EditText admuser,admpass;
    Button admlog;
    TextView admstatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        admuser=(EditText)findViewById(R.id.admuser);
        admpass=(EditText)findViewById(R.id.etPass);
        admlog=(Button)findViewById(R.id.admlog);
        admstatus=(TextView)findViewById(R.id.tvstatus);
        admstatus.setText("");
        admlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!((TextUtils.isEmpty(admuser.getText().toString()))||(TextUtils.isEmpty(admpass.getText().toString())))){
                    if (admuser.getText().toString().equals("Meecartseller")&&admpass.getText().toString().equals("admin123")){
                    }else{
                        admstatus.setText("Invalid credentials");
                    }
                }else{
                    admstatus.setText("Please enter all credentials");
                }
            }
        });

    }
    public void onBackPressed(){
        startActivity(new Intent(AdminLogin.this,RegLogChoice.class));
    }
}
