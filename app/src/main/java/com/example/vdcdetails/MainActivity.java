package com.example.vdcdetails;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    MaterialButton login;
    TextInputEditText user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login_button);
        user = (TextInputEditText) findViewById(R.id.username);
        pass = (TextInputEditText) findViewById(R.id.password);



        login.setOnClickListener(new View.OnClickListener() {

            String username = user.getText().toString();
            String password = pass.getText().toString();

            @Override
            public void onClick(View view) {

               System.out.println("the user name is "+username);
                    Intent intent = new Intent(view.getContext(),Adddetails.class);
                    view.getContext().startActivity(intent);

            }
        });
    }
}