package com.example.examcreate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExamCreateActivity extends AppCompatActivity {

    private Button examCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_create);
        bindWidgets();
        bindListeners();
    }

    private void bindWidgets(){
        examCreate=findViewById(R.id.create_exam);

    }
    private void bindListeners(){
        examCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExamCreateActivity.this,QuestionCreate.class));
            }
        });
    }
}
