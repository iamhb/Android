package com.example.hari.demohb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText name,regno,phno;
    private Button upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setListeners();
    }
    private void setListeners()
    {

        upload.setOnClickListener(this);
    }

    private void init()
    {
        name=(EditText)findViewById(R.id.name);
        regno=(EditText)findViewById(R.id.regno);
        phno=(EditText)findViewById(R.id.phno);
        upload=(Button) findViewById(R.id.savebtn);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.savebtn:
                    Student stud= new Student(name.getText().toString().trim(),regno.getText().toString().trim(),phno.getText().toString().trim());
                    saveData(stud);
        }
    }
    private void saveData(Student stud) {
        FirebaseDatabase database= FirebaseDatabase.getInstance();
        DatabaseReference myRef=database.getReference("students");
        myRef.push().setValue(stud);
    }
}
