package com.example.snehasaj.nhpcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EmpDir extends AppCompatActivity {

    private static TextView em_heading;
    private static EditText em_id;
    private static EditText em_deptId;
    private static EditText em_username;
    private static EditText em_password;
    private static EditText em_title;
    private static EditText em_dept;
    private static EditText em_city;
    private static EditText em_phno;
    private static EditText em_email;
    private static EditText em_dob;
    private static EditText em_doj;
    private static Button   em_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_dir);
        em_heading= (TextView)findViewById(R.id.text_head);
        em_city = (EditText)findViewById(R.id.edit_city);
        em_dept =(EditText)findViewById(R.id.edit_dept);
        em_id = (EditText)findViewById(R.id.edit_id);
        em_deptId=(EditText)findViewById(R.id.edit_deptId);
        em_username=(EditText)findViewById(R.id.edit_username);
        em_password=(EditText)findViewById(R.id.edit_password);
        em_title=(EditText)findViewById(R.id.edit_title);
        em_phno =(EditText)findViewById(R.id.edit_phno);
        em_email=(EditText)findViewById(R.id.edit_email);
        em_dob=(EditText)findViewById(R.id.edit_dob);
        em_doj=(EditText)findViewById(R.id.edit_doj);
        em_add=(Button)findViewById(R.id.button_add);

        em_add.setOnClickListener((view) -> {
            Intent intent = new Intent(EmpDir.this,Userpage.class);
            startActivity(intent);
        });


    }
    }
