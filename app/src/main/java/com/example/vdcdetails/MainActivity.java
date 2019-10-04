package com.example.vdcdetails;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    MaterialButton login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        login = findViewById(R.id.login_button);
        final TextInputEditText user = findViewById(R.id.username);
        final TextInputEditText pass = findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            String useret = user.getText().toString();
            String passet = pass.getText().toString();

            @Override
            public void onClick(View view) {
              /*  System.out.println("The username and password is "+useret+", "+passet);
               if(useret =="admin" && passet=="qwe1234"){*/
                   Intent intent = new Intent(view.getContext(),MainView.class);
                   view.getContext().startActivity(intent);
               /*}else{
                   Toast.makeText(MainActivity.this, "Please contact Developer regarding login details", Toast.LENGTH_LONG).show();
               }*/


            }
        });
    }
}