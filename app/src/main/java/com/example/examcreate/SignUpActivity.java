package com.example.examcreate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.internal.Objects;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText email,password,confirmPassword;
    private Button signUpButton;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        bindWidgets();
        bindListeners();
    }

    private void bindWidgets(){
        email=findViewById(R.id.sign_up_email_text);
        password=findViewById(R.id.sign_up_password_text);
        signUpButton=findViewById(R.id.sign_in_button);
        confirmPassword=findViewById(R.id.confirm_password_text);
        firebaseAuth=FirebaseAuth.getInstance();
    }
    private void bindListeners(){
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailId=email.getText().toString();
                String passwordId=password.getText().toString();
                String confirm=confirmPassword.getText().toString();

                if(emailId.isEmpty() || passwordId.isEmpty() || confirm.isEmpty()){
                    Toast.makeText(SignUpActivity.this,"Fill up the fields Properly", Toast.LENGTH_LONG).show();
                    return;
                }
                if(!passwordId.equals(confirm)){
                    Toast.makeText(SignUpActivity.this,"Passwords do not match", Toast.LENGTH_LONG).show();
                    return;
                }
                signup(emailId,passwordId);
            }
        });
    }

    private void signup(String email,String password){
        //todo: sign up method
    }
}
