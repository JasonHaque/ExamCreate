package com.example.examcreate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class TimelineActivity extends AppCompatActivity {

    private ImageButton addExam;
    private Button profile,examList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        bindWidgets();
        bindListeners();
    }

    private void bindWidgets(){
        addExam=findViewById(R.id.add_exam_button);
        profile=findViewById(R.id.profile_button);
        examList=findViewById(R.id.exam_list);
    }

    private void bindListeners(){
        addExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TimelineActivity.this,ExamCreateActivity.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TimelineActivity.this,UserProfileActivity.class));
            }
        });
        examList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TimelineActivity.this,ExamList.class));
            }
        });
    }
}
