
package com.example.snehasaj.nhpcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import com.example.snehasaj.nhpcapp.DataQ;
import com.example.snehasaj.nhpcapp.EmpDir;
import com.example.snehasaj.nhpcapp.R;
import com.example.snehasaj.nhpcapp.Userpage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Login extends AppCompatActivity {
    private static TextView login_page;
    private static TextView attempts;
    private static TextView signup;
    private static EditText username;
    private static EditText password;
    private static Button login;
    private static EditText deptId;
    private int counter = 5;
    private Intent packageContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_page = (TextView) findViewById(R.id.text_login);
        attempts = (TextView) findViewById(R.id.text_attempts);
        signup = (TextView) findViewById(R.id.text_sign);
        username = (EditText) findViewById(R.id.edit_username);
        password = (EditText) findViewById(R.id.edit_password);
        login = (Button) findViewById(R.id.button_login);
        deptId = (EditText) findViewById(R.id.edit_deptId);

        attempts.setText("no of attempts remaining : 5");

        login.setOnClickListener((view) -> {
            validate(username.getText().toString(), password.getText().toString(), deptId.getText().toString());
        });
        signup.setOnClickListener((View view) -> {
            startActivity(new Intent(Login.this, EmpDir.class));
        });


    }

    private void validate(String userName, String userPassword, String deptno) {
        DataQ data = new DataQ();

        if ((userName.equals("Sneha")) && (userPassword.equals("1234")) && deptno.equals("01")) {
            Intent intent = new Intent(Login.this, Userpage.class);
            startActivity(intent);
            System.out.println("heloo");
        } else if (data.ValidateLogin(userName, userPassword,deptno) == "Y") {
            Intent intent = new Intent(Login.this, Userpage.class);
            startActivity(intent);
            System.out.println("heloo");
        } else {
            counter--;
            attempts.setText("the remaining attempts :" + String.valueOf(counter));
            if (counter == 0) {
                login.setEnabled(false);
                System.out.println("heloo");
            }

        }


    }


}



