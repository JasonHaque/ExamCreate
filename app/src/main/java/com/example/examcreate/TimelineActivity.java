package com.example.examcreate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TimelineActivity extends AppCompatActivity {

    private ImageButton addExam;
    private Button examList;
    private BottomNavigationView bottomnavView;
    private BottomNavigationItemView home,activity_log,Profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        bindWidgets();
        bindListeners();
    }

    private void bindWidgets(){
        addExam=findViewById(R.id.add_exam_button);
        Profile=findViewById(R.id.profile);
        bottomnavView=findViewById(R.id.nav_view);
        activity_log=findViewById(R.id.exam_log);
    }

    private void bindListeners(){
        addExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TimelineActivity.this,ExamCreateActivity.class));
            }
        });


        bottomnavView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId() == R.id.profile){
                    startActivity(new Intent(TimelineActivity.this,UserProfileActivity.class));
                }
                else if(menuItem.getItemId() == R.id.exam_log){
                    startActivity(new Intent(TimelineActivity.this,ExamList.class));
                }
            }
        });
    }
}
