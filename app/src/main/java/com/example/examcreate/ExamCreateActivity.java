package com.example.examcreate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class ExamCreateActivity extends AppCompatActivity {

    private Button examCreate, backTotimeline;
    public static String examName, examDate;
    public EditText examSet, dateOfExam;
    public CheckBox mcqO, writtenO;
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
        backTotimeline=findViewById(R.id.exam_back);
        dateOfExam=findViewById(R.id.exam_date);
        mcqO=findViewById(R.id.mcqid);
        writtenO=findViewById(R.id.writtenid);
    }
    private void bindListeners(){
        examCreate.setOnClickListener(view -> {
            examName=examSet.getText().toString();
            examDate=dateOfExam.getText().toString();
            if((TextUtils.isEmpty(examName) || TextUtils.isEmpty(examDate) || !mcqO.isChecked()) && (TextUtils.isEmpty(examName) || TextUtils.isEmpty(examDate) || !writtenO.isChecked())){
                Toast.makeText(ExamCreateActivity.this,"Fill up the fields properly", Toast.LENGTH_LONG).show();
                return;
            }
            else if(!TextUtils.isEmpty(examName) && !TextUtils.isEmpty(examDate) && mcqO.isChecked()){
                startActivity(new Intent(ExamCreateActivity.this, QuestionCreate.class));
            }
        });
        backTotimeline.setOnClickListener(view -> startActivity(new Intent(ExamCreateActivity.this, TimelineActivity.class)));
    }

}
