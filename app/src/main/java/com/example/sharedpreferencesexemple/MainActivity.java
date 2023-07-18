package com.example.sharedpreferencesexemple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        DisplaySavedTxt();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String txtEdited = editText.getText().toString();
            DisplayString(txtEdited);

            }
        });
    }

    private void DisplaySavedTxt() {
        SharedPreferences sharedPreferences = getSharedPreferences("text", MODE_PRIVATE);
        String s1 = sharedPreferences.getString("name", " ");

        textView.setText(s1);
    }

    private void DisplayString(String txtEdited) {
        //displaying text
        textView.setText(txtEdited);
        //saving text
        SharedPreferences sharedPreferences = getSharedPreferences("text", MODE_PRIVATE);
        //writing data to SSharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("name", txtEdited);
        editor.apply();


    }
}