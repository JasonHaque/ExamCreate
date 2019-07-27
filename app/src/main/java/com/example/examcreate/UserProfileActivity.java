package com.example.examcreate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class UserProfileActivity extends AppCompatActivity {

    private TextView profiletext;
    private FirebaseAuth firebaseAuth;
    private Button logOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        bindWidgets();
        bindListeners();
        String user =firebaseAuth.getCurrentUser().getEmail().toString();
        profiletext.setText("Welcome User : "+user);
    }
    private void bindWidgets(){
        profiletext=findViewById(R.id.profile_view);
        logOut=findViewById(R.id.log_out_button);
        firebaseAuth=FirebaseAuth.getInstance();
    }
    private void bindListeners(){
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                startActivity(new Intent(UserProfileActivity.this,LoginActivity.class));
            }
        });
    }
}
