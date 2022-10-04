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
    protected static final String ListItemsActivity = "ListItemsActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        EditText loginEditText = (EditText) findViewById(R.id.loginEmail);
        EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.login);

        SharedPreferences sharedPref = getSharedPreferences("DefaultEmail", MODE_PRIVATE);
        String defaultEmail = sharedPref.getString("DefaultEmail", "email@domain.com");

        loginEditText.setText(defaultEmail);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(Patterns.EMAIL_ADDRESS.matcher(loginEditText.getText().toString()).matches() && passwordEditText.length() > 0){
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("DefaultEmail", loginEditText.getText().toString());
                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this, "Failure to use email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
        setContentView(R.layout.activity_login);
    }
    protected void onResume(){
        super.onResume();
        Log.i(ListItemsActivity, "In onResume()");
    }
    protected void onStart(){
        super.onStart();
        Log.i(ListItemsActivity, "In onStart()");
    }
    protected void onPause(){
        super.onPause();
        Log.i(ListItemsActivity, "In onStart()");
    }
    protected void onStop(){
        super.onStop();
        Log.i(ListItemsActivity, "In onStart()");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.i(ListItemsActivity, "In onDestroy()");
    }


}