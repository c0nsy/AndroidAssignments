package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChatWindow extends AppCompatActivity {
    ArrayList<String> listName = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_chat_window);
        ListView chatListView= findViewById(R.id.chatListView);
        EditText chatEditText = findViewById(R.id.chatEditText);
        Button chatSendButton = findViewById(R.id.chatSendButton);
        ChatAdapter messageAdapter = new ChatAdapter( this );
        chatListView.setAdapter(messageAdapter);
        chatSendButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listName.add(chatEditText.getText().toString());
                messageAdapter.notifyDataSetChanged(); //this restarts the process of getCount()/
                chatEditText.setText("");
            }
        }));

    }
    private class ChatAdapter extends ArrayAdapter<String> {
        public ChatAdapter(Context ctx){
            super(ctx,0);
        }
        public int getCount(){
            return listName.size();
        }
        public String getItem(int position){
            return listName.get(position);
        }
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();
            View result = null;

            if(position %2 ==0){
                result = inflater.inflate(R.layout.chat_row_incoming, null);
            }else{
                result = inflater.inflate(R.layout.chat_row_outgoing, null);
            }
            TextView message = (TextView)result.findViewById(R.id.message_text);
            message.setText(   getItem(position)  ); // get the string at position
            return result;
        }
    }
}