package com.info46.startnewactivity2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        ///MultiLine_id
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        //try  EditText textView2 = findViewById(R.id.MultiLine_id);
        //try  textView2.setText(message);
        // final is like constant
        EditText editText = findViewById(R.id.MultiLine_id);
        editText.setText(message);



        /* try from Edit multiline to textview
        TextView text =  findViewById(R.id.txt3);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                text.setText(editText.getText().toString());
            }
        });
        /**/


    }
}
//        // Capture the layout's TextView and set the string as its text
//        //try  EditText textView2 = findViewById(R.id.MultiLine_id);
//        //try  textView2.setText(message);
//        TextView textView = findViewById(R.id.MultiLine_id);
//        textView.setText(message);