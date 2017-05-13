package com.myapplicationdev.android.p04_revisionnotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.myapplicationdev.android.p04_revisionnotes.R.id.lv;

public class MainActivity extends AppCompatActivity {
    TextView tvNote;
    EditText edNote;
    TextView tvStar;
    RadioGroup rgStars;
    RadioButton r1,r2,r3,r4,r5;
    Button btnInsert;
    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNote = (TextView)findViewById(R.id.textViewNote);
        edNote = (EditText)findViewById(R.id.editTextNote);
        tvStar = (TextView)findViewById(R.id.textView2);
        rgStars = (RadioGroup)findViewById(R.id.radioGroupStars);
        r1 = (RadioButton)findViewById(R.id.radio1);
        r2 = (RadioButton)findViewById(R.id.radio2);
        r3 = (RadioButton)findViewById(R.id.radio3);
        r4 = (RadioButton)findViewById(R.id.radio4);
        r5 = (RadioButton)findViewById(R.id.radio5);
        btnInsert = (Button)findViewById(R.id.buttonInsertNote);
        btnShow = (Button)findViewById(R.id.buttonShowList);

        int selectedButtonId = rgStars.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton)findViewById(selectedButtonId);
        String selected = rb.getText().toString();

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                String insert = edNote.getText().toString();
                db.insertNote(insert,1);
                Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_LONG).show();

                db.close();
            }
        });


    }
}
