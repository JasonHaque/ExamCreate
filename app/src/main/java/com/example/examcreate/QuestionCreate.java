package com.example.examcreate;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import static com.example.examcreate.ExamCreateActivity.examName;
import static com.example.examcreate.LoginActivity.userID;


public class QuestionCreate extends AppCompatActivity {

    private TextView finalexamName,QuestionNumber;
    private EditText questiontext,optionA,optionB,optionC,optionD,ChoiceOption;
    private FirebaseFirestore database = FirebaseFirestore.getInstance();
    private CollectionReference dref = database.collection("EXAMS");
    private CollectionReference examref = dref.document(""+userID).collection(""+examName);
    private ProgressDialog prog;
    private Button CreateExam ,questionCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_create);
        bindWidgets();
        bindListeners();
        finalexamName.setText(""+examName);
    }

    private void bindWidgets(){
        finalexamName=findViewById(R.id.set_exam_name);
        questionCreate = findViewById(R.id.question_button);
        QuestionNumber = findViewById(R.id.Question_number_view);
        questiontext = findViewById(R.id.Question_text);
        optionA = findViewById(R.id.OptionA);
        optionB = findViewById(R.id.OptionB);
        optionC = findViewById(R.id.OptionC);
        optionD = findViewById(R.id.OptionD);
        ChoiceOption = findViewById(R.id.OptionChoice);
        CreateExam = findViewById(R.id.create_exam_button);
        prog=new ProgressDialog(this);


    }

    private void bindListeners(){
        questionCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=QuestionNumber.getText().toString();
                int b = Integer.parseInt(a)+1;
                String optiona,optionb,optionc,optiond,optionchoice,questext;
                questext=questiontext.getText().toString();
                optiona=optionA.getText().toString();
                optionb=optionB.getText().toString();
                optionc=optionC.getText().toString();
                optiond=optionD.getText().toString();
                optionchoice=ChoiceOption.getText().toString();
                if(TextUtils.isEmpty(questext) || TextUtils.isEmpty(optiona) || TextUtils.isEmpty(optionb) || TextUtils.isEmpty(optionc) || TextUtils.isEmpty(optiond) || TextUtils.isEmpty(optionchoice)){
                    Toast.makeText(QuestionCreate.this,"Fill everything properly",Toast.LENGTH_LONG).show();
                    return;
                }
                prog.setTitle("Saving Question");
                prog.show();
                Question question = new Question(questext,optiona,optionb,optionc,optiond,optionchoice,Integer.parseInt(a));

                examref.add(question);
                prog.dismiss();
                QuestionNumber.setText(String.valueOf(b));
                questiontext.setText("");
                optionA.setText("");
                optionB.setText("");
                optionC.setText("");
                optionD.setText("");
                ChoiceOption.setText("");
                Toast.makeText(QuestionCreate.this,"Question Created",Toast.LENGTH_LONG).show();
            }
        });
        CreateExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(QuestionCreate.this,ShowQuestion.class));
            }
        });
    }
}
