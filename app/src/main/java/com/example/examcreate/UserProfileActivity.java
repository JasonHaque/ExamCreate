package com.example.examcreate;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import static com.example.examcreate.LoginActivity.userID;

public class UserProfileActivity extends AppCompatActivity {

    private TextView profiletext;
    private ImageView profileImage;
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
        profileImage.setImageResource(R.drawable.profile);
    }
    private void bindWidgets(){
        profiletext=findViewById(R.id.profile_view);
        logOut=findViewById(R.id.log_out_button);
        timBack=findViewById(R.id.profback_button);
        profileImage=findViewById(R.id.profile_image);
        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
    }
    private void bindListeners(){
        logOut.setOnClickListener(view -> {
            firebaseAuth.signOut();
            startActivity(new Intent(UserProfileActivity.this,LoginActivity.class));
        });
        timBack.setOnClickListener(view -> startActivity(new Intent(UserProfileActivity.this,TimelineActivity.class)));
    }
}
