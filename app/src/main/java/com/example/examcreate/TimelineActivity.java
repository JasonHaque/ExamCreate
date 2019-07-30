package com.example.examcreate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TimelineActivity extends AppCompatActivity {

    private Button addExam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        bindWidgets();
        bindListeners();
    }

    private void bindWidgets(){
        addExam=findViewById(R.id.add_exam_button);
    }

    private void bindListeners(){
        addExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TimelineActivity.this,ExamCreateActivity.class));
            }
        });
    }
}
