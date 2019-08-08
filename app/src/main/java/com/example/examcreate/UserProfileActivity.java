package com.example.examcreate;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import static com.example.examcreate.LoginActivity.userID;

public class UserProfileActivity extends AppCompatActivity {

    private TextView profiletext;
    private FirebaseAuth firebaseAuth;
    private Button logOut, timBack;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        bindWidgets();
        bindListeners();
        profiletext.setText("Welcome User : "+userID);
    }
    private void bindWidgets(){
        profiletext=findViewById(R.id.profile_view);
        logOut=findViewById(R.id.log_out_button);
        timBack=findViewById(R.id.profback_button);
        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
    }
    private void bindListeners(){
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                startActivity(new Intent(UserProfileActivity.this,LoginActivity.class));
            }
        });
        timBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfileActivity.this,TimelineActivity.class));
            }
        });
    }
}
