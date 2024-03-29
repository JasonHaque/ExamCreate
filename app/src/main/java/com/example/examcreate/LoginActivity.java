package com.example.examcreate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText emailText,passwordText;
    private Button loginButton,signupButton;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    public static String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindWidgetCallers();
        bindButtonListeners();
        checkUserStatus();
    }

    private void bindWidgetCallers(){
        emailText=findViewById(R.id.login_email_text);
        passwordText=findViewById(R.id.login_password_text);
        loginButton=findViewById(R.id.log_in_button);
        firebaseAuth=FirebaseAuth.getInstance();
        signupButton=findViewById(R.id.sign_up_button);
        progressDialog=new ProgressDialog(this);
    }

    private void bindButtonListeners(){
        loginButton.setOnClickListener(view -> {
            String email=emailText.getText().toString();
            String password = passwordText.getText().toString();
            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                Toast.makeText(LoginActivity.this,"Fill up Email And Password Properly", Toast.LENGTH_LONG).show();
                return;
            }
            login(email,password);

        });
        signupButton.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this,SignUpActivity.class)));
    }

    private void login(String email,String password){
        progressDialog.setTitle("Logging you in");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(authResult -> {
            Toast.makeText(LoginActivity.this,"Success", Toast.LENGTH_LONG).show();
            progressDialog.dismiss();
            String[] ID=firebaseAuth.getCurrentUser().getEmail().toString().split("@");
            userID=ID[0];
            startActivity(new Intent(LoginActivity.this,TimelineActivity.class));
        }).addOnFailureListener(e -> {
            Toast.makeText(LoginActivity.this,"Login Failed", Toast.LENGTH_LONG).show();
            progressDialog.dismiss();
            return;
        });
    }
    private void checkUserStatus(){
        if(firebaseAuth.getCurrentUser() != null){
            String[] ID=firebaseAuth.getCurrentUser().getEmail().toString().split("@");
            userID=ID[0];
            startActivity(new Intent(LoginActivity.this,TimelineActivity.class));
        }
    }
}
