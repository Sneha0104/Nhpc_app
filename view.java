package com.example.snehasaj.nhpcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class View extends AppCompatActivity {

    private static TextView view_emp;
    private static TextView view_id;
    private static TextView view_deptId;
    private static TextView view_fname;
    private static TextView view_lname;
    private static TextView view_dept;
    private static TextView view_title;
    private static TextView view_phno;
    private static TextView view_city;
    private static TextView view_email;
    private static TextView view_dob;
    private static TextView view_doj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        view_emp= (TextView)findViewById(R.id.emp_dir);
        view_id=(TextView)findViewById(R.id.id);
        view_deptId=(TextView)findViewById(R.id.dept_id);
        view_fname=(TextView)findViewById(R.id.fname);
        view_lname=(TextView)findViewById(R.id.lname);
        view_dept=(TextView)findViewById(R.id.dept);
        view_title=(TextView)findViewById(R.id.title);
        view_phno=(TextView)findViewById(R.id.phno);
        view_city=(TextView)findViewById(R.id.city);
        view_email=(TextView)findViewById(R.id.email);
        view_dob=(TextView)findViewById(R.id.dob);
        view_doj=(TextView)findViewById(R.id.doj);
    }
}


 
 
