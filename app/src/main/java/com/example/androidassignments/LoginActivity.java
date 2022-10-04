package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity{
    protected static final String LoginActivity = "LoginActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        Button loginButton = (Button) findViewById(R.id.loginButton);
        EditText loginEmail = (EditText) findViewById(R.id.loginEmail);
        EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);

        SharedPreferences sharedPref = getSharedPreferences("DefaultEmail", MODE_PRIVATE);
        String defaultEmail = sharedPref.getString("DefaultEmail", "email@domain.com");

        loginEmail.setText(defaultEmail);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(LoginActivity, "Click event fired");
                if(android.util.Patterns.EMAIL_ADDRESS.matcher(loginEmail.getText().toString()).matches() && passwordEditText.length() > 0) {
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("DefaultEmail", loginEmail.getText().toString());
                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Failure to enter email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    protected void onResume(){
        super.onResume();
        Log.i(LoginActivity, "In onResume()");
    }
    protected void onStart(){
        super.onStart();
        Log.i(LoginActivity, "In onStart()");
    }
    protected void onPause(){
        super.onPause();
        Log.i(LoginActivity, "In onStart()");
    }
    protected void onStop(){
        super.onStop();
        Log.i(LoginActivity, "In onStart()");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.i(LoginActivity, "In onDestroy()");
    }


}