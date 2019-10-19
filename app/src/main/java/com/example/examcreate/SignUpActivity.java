package com.example.examcreate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText email,password,confirmPassword;
    private Button signUpButton, backToLoginButton;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
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
        backToLoginButton=findViewById(R.id.backlogin_button);
        progressDialog=new ProgressDialog(this);
    }
    private void bindListeners(){
        signUpButton.setOnClickListener(view -> {
            String emailId=email.getText().toString();
            String passwordId=password.getText().toString();
            String confirm=confirmPassword.getText().toString();

            if(TextUtils.isEmpty(emailId) || TextUtils.isEmpty(passwordId) || TextUtils.isEmpty(confirm)){
                Toast.makeText(SignUpActivity.this,"Fill up the fields Properly", Toast.LENGTH_LONG).show();
                return;
            }
            if(!passwordId.equals(confirm)){
                Toast.makeText(SignUpActivity.this,"Passwords do not match", Toast.LENGTH_LONG).show();
                return;
            }
            signup(emailId,passwordId);
        });
        backToLoginButton.setOnClickListener(view -> startActivity(new Intent(SignUpActivity.this,LoginActivity.class)));
    }

    private void signup(String email,String password){
        progressDialog.setTitle("Signing You In");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(SignUpActivity.this,"Success", Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
            }
        }).addOnFailureListener(e -> {
            progressDialog.dismiss();
            Toast.makeText(SignUpActivity.this,"Failed", Toast.LENGTH_LONG).show();
        });
    }
}
