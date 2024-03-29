package com.example.examcreate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import static com.example.examcreate.ExamCreateActivity.examName;
import static com.example.examcreate.LoginActivity.userID;

public class ShowQuestion extends AppCompatActivity {

    private TextView textView,examView;
    private Button confirmQuestion, backToQcreate;
    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private CollectionReference dref = db.collection("EXAMS");
    private CollectionReference examref = dref.document(""+userID).collection(""+examName);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_question);
        bindWidgets();
        bindListeners();
        examView.setText(""+examName+"\n \n");
        showQuestion();

    }

    private void bindWidgets(){
        textView=findViewById(R.id.text_view_data);
        confirmQuestion=findViewById(R.id.confirm_question);
        backToQcreate=findViewById(R.id.createQback_button);
        examView=findViewById(R.id.text_view_name);
    }
    private void showQuestion(){
        examref.orderBy("questionnumber", Query.Direction.ASCENDING)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        String data="";
                        int count =0;
                        for (QueryDocumentSnapshot dshot : queryDocumentSnapshots){
                            Question question = dshot.toObject(Question.class);

                            int question_number = question.getQuestionnumber();
                            String question_text =question.getQuestiontext();
                            String optionA = question.getOptiona();
                            String optionB = question.getOptionb();
                            String optionC = question.getOptionc();
                            String optionD = question.getOptiond();
                            count++;

                            data += question_number +". "+question_text +"\n"+
                                    "A." + " "+optionA+"\n"+
                                    "B." + " "+optionB+"\n"+
                                    "C." + " "+optionC+"\n"+
                                    "D." + " "+optionD+"\n\n\n";

                            System.out.println(data);

                        }
                        textView.setText(data);
                        System.out.println(count);
                    }
                });
    }

    private void bindListeners(){
        confirmQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShowQuestion.this,TimelineActivity.class));
            }
        });
        backToQcreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShowQuestion.this,QuestionCreate.class));
            }
        });

    }
}
