package com.example.androidassignments;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class ListItemsActivity extends AppCompatActivity {
    protected static final String ListItemsActivity ="ListItemsActivity";
    protected static final String ACTIVITY_NAME = "ListItemsActivity";
    final String[] CAMERA_PERMS = {Manifest.permission.CAMERA};
    final int REQUEST_CAMERA = 1888;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
        Switch switchButton = findViewById(R.id.switchButton);

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    CharSequence text = "Switch is On";// "Switch is On"
                    int duration = Toast.LENGTH_SHORT; //= Toast.SHORT if on
                    Toast toast = Toast.makeText(getApplicationContext() , text, duration); //this is the ListActivity
                    toast.show(); //display your message box
                }else{
                    CharSequence text = "Switch is Off";// "Switch is Off"
                    int duration = Toast.LENGTH_LONG; //= Toast.LENGTH_LONG if Off
                    Toast toast = Toast.makeText(getApplicationContext() , text, duration); //this is the ListActivity
                    toast.show(); //display your message box
                }

            }
        });
        imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int camera = ActivityCompat.checkSelfPermission(ListItemsActivity.this, Manifest.permission.CAMERA);
                if(camera != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ListItemsActivity.this, CAMERA_PERMS, REQUEST_CAMERA);
                } else {
                    Intent cameraIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                    startActivityForResult(cameraIntent, REQUEST_CAMERA);
                }
            }
        });
        CheckBox checkBox = findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);
                builder.setMessage(R.string.dialog_message)
                        .setTitle(R.string.dialog_title)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent resultIntent = new Intent();
                                resultIntent.putExtra("Response", "Here is my response");
                                setResult(Activity.RESULT_OK, resultIntent);
                                finish();
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                return;
                            }
                        })
                        .show();
            }
        });
    }
    protected void onResume(){
        super.onResume();
        Log.i(ListItemsActivity, "In onResume");
    }
    protected void onStart(){
        super.onStart();
        Log.i(ListItemsActivity, "In onStart");
    }
    protected void onPause(){
        super.onPause();
        Log.i(ListItemsActivity, "In onPause");
    }
    protected void onStop(){
        super.onStop();
        Log.i(ListItemsActivity, "In onStop");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.i(ListItemsActivity, "In onDestroy");
    }
    public void print(String string){
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplicationContext(), string,duration);
    }
    @Override
    protected void onActivityResult(int requestCode, int responseCode, Intent data) {
        super.onActivityResult(requestCode, responseCode, data);
        if (requestCode == REQUEST_CAMERA && responseCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageButton.setImageBitmap(photo);
        }
    }

}