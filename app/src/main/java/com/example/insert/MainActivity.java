package com.example.insert;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;




public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText no;
    Button submit;
    DatabaseReference dbref;
    Card card;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        card = new Card();


        name = findViewById(R.id.name);
        no = findViewById(R.id.no);
        submit = findViewById(R.id.submit);





    }

    public void InsertData(View view){
        dbref = FirebaseDatabase.getInstance().getReference().child("Cards");

        card.setName(name.getText().toString().trim());
        card.setNo(no.getText().toString().trim());

        dbref.push().setValue(card);
    }


}