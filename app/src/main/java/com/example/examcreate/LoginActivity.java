package com.example.examcreate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText emailText,passwordText;
    private Button loginButton,signupButton;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindWidgetCallers();
        bindButtonListeners();

    }

    private void bindWidgetCallers(){
        emailText=findViewById(R.id.login_email_text);
        passwordText=findViewById(R.id.login_password_text);
        loginButton=findViewById(R.id.log_in_button);
        firebaseAuth=FirebaseAuth.getInstance();
        signupButton=findViewById(R.id.sign_up_button);
    }

    private void bindButtonListeners(){
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=emailText.getText().toString();
                String password = passwordText.getText().toString();
                if(email.isEmpty() || password.isEmpty()){
                    Toast.makeText(LoginActivity.this,"Fill up Email And Password Properly", Toast.LENGTH_LONG).show();
                    return;
                }
                login(email,password);

            }
        });
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
            }
        });
    }

    private void login(String email,String password){
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LoginActivity.this,"Success", Toast.LENGTH_LONG).show();
                startActivity(new Intent(LoginActivity.this,UserProfileActivity.class));
            }
        });
    }
}
