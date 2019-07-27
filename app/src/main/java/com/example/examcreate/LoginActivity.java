package com.example.examcreate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                //code for login
            }
        });
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code to navigate to sign Up page
            }
        });
    }
}
