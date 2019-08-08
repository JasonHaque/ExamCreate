package com.example.examcreate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import static com.example.examcreate.LoginActivity.userID;

public class ExamList extends AppCompatActivity {

    private TextView examListView;
    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private CollectionReference dref = db.collection("EXAMS");
    private DocumentReference dhref =dref.document(""+userID);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_list);
        bindWidgets();

    }

    private void bindWidgets(){
        examListView=findViewById(R.id.exam_list_view);
    }
}
