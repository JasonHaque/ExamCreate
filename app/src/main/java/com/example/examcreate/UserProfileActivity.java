package com.example.examcreate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class UserProfileActivity extends AppCompatActivity {

    private TextView profiletext;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        bindWidgets();
        String user =firebaseAuth.getCurrentUser().getEmail().toString();
        profiletext.setText("Welcome User : "+user);
    }
    private void bindWidgets(){
        profiletext=findViewById(R.id.profile_view);
        firebaseAuth=FirebaseAuth.getInstance();
    }
}
