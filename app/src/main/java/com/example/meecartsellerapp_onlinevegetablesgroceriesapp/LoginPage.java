package com.example.meecartsellerapp_onlinevegetablesgroceriesapp;

import android.content.Intent;
import android.database.DatabaseErrorHandler;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LoginPage extends AppCompatActivity {
    EditText phoneno, pass;
    Button login;
    TextView status;
    String ph,pa;
    static String tmpname;
    //static DatabaseReference databaseCurrentUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        phoneno = (EditText) findViewById(R.id.logphone);
        pass = (EditText) findViewById(R.id.logpass);
        login = (Button) findViewById(R.id.btnlogin);
        status=(TextView)findViewById(R.id.tvstatus);
        status.setText("");
        //databaseCurrentUser= FirebaseDatabase.getInstance().getReference("getUserLogin");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterPage.getuser();
                ph = phoneno.getText().toString();
                pa = pass.getText().toString();
                RegisterPage.databaseUsers.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        int x = 0;
                        for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                            MemberReg memberReg = userSnapshot.getValue(MemberReg.class);
                            String dpn = memberReg.getUsername();
                            String dph = memberReg.getPhone();
                            String dpa = memberReg.getPassword();
                            if (dph.equals(ph) && dpa.equals(pa)) {
                                /*{
                                    String id=databaseCurrentUser.push().getKey();
                                    GetUserLogin getUserLogin=new GetUserLogin(dpn,dph,id);
                                    databaseCurrentUser.child(id).setValue(getUserLogin);
                                }*/

                                Intent i=new Intent(String.valueOf(LoginPage.this));
                                i.putExtra("NAME",dpn);
                                i.putExtra("PHONE",dph);
                                i.putExtra("PASSWORD",dpa);
                                i.putExtra("CALLINGACTIVITY","LoginPage");
                                startActivity(i);
                                x = 1;
                            }
                        }
                        if (x == 0)
                            status.setText("Invalid Credentials");
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseErrorHandler databaseError) {

                    }
                });

            }
        });
    }
    public void onBackPressed(){
        startActivity(new Intent(LoginPage.this,RegLogChoice.class));
    }
}