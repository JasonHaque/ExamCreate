package com.example.examcreate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import static com.example.examcreate.ExamCreateActivity.examName;


public class QuestionCreate extends AppCompatActivity {

    private TextView finalexamName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_create);
        bindWidgets();
        finalexamName.setText(""+examName);
    }

    private void bindWidgets(){
        finalexamName=findViewById(R.id.set_exam_name);
    }
}
