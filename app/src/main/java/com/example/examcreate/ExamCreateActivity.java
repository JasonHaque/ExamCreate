package com.example.examcreate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ExamCreateActivity extends AppCompatActivity {

    private Button examCreate;
    public static String examName;
    public EditText examSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_create);
        bindWidgets();
        bindListeners();
    }

    private void bindWidgets(){
        examCreate=findViewById(R.id.create_exam);
        examSet=findViewById(R.id.exam_name);

    }
    private void bindListeners(){
        examCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                examName=examSet.getText().toString();
                if(TextUtils.isEmpty(examName)){
                    Toast.makeText(ExamCreateActivity.this,"Fill up subject of exam properly", Toast.LENGTH_LONG).show();
                    return;
                }
                else {
                    startActivity(new Intent(ExamCreateActivity.this, QuestionCreate.class));
                }
            }
        });
    }
}
