package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected static final String MainActivity = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mainActivityButton = findViewById(R.id.button);
        mainActivityButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,  ListItemsActivity.class);
                startActivityForResult(intent,10);
            }
        }));

    }
    protected void onResume(){
        super.onResume();
        Log.i(MainActivity, "In onResume");
    }
    protected void onStart(){
        super.onStart();
        Log.i(MainActivity, "In onStart");
    }
    protected void onPause(){
        super.onPause();
        Log.i(MainActivity, "In onPause");
    }
    protected void onStop(){
        super.onStop();
        Log.i(MainActivity, "In onStop");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.i(MainActivity, "In onDestroy");
    }
    protected void onActivityResult(int requestCode, int responseCode, Intent data){
        super.onActivityResult(requestCode,responseCode,data);
        Log.i(MainActivity, "In onActivityResult");
        if(requestCode == 10){
            Log.i(MainActivity,"Returned to MainActivity.onActivityResult");
            if(requestCode == Activity.RESULT_OK) {
                int duration = Toast.LENGTH_SHORT;
                String messagePassed = data.getStringExtra("Response");
                Toast toast = Toast.makeText(getApplicationContext(), messagePassed,duration);
            }
        }
    }
}
