package com.example.android.colorteory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    int cont = 0;
    String blueColor = "Azul";
    String yellowColor = "Amarelo";
    String redColor = "Vermelho";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void activity(View view) {

        EditText nameField1 = (EditText) findViewById(R.id.green_answer_1);
        String greenColor1 = nameField1.getText().toString();

        EditText nameField2 = (EditText) findViewById(R.id.green_answer_2);
        String greenColor2 = nameField2.getText().toString();

        EditText nameField3 = (EditText) findViewById(R.id.orange_answer_1);
        String orangeColor1 = nameField3.getText().toString();

        EditText nameField4 = (EditText) findViewById(R.id.orange_answer_2);
        String orangeColor2 = nameField4.getText().toString();

        EditText nameField5 = (EditText) findViewById(R.id.purple_answer_1);
        String purpleColor1 = nameField5.getText().toString();

        EditText nameField6 = (EditText) findViewById(R.id.purple_answer_2);
        String purpleColor2 = nameField6.getText().toString();

        if ((greenColor1.equals(blueColor)) || (greenColor1.equals(yellowColor)) && (greenColor2.equals(blueColor)) || (greenColor2.equals(yellowColor)) && (!greenColor1.equals(greenColor2))) {
            cont = cont + 1;
        }
        else {
            Toast.makeText(this, "Resposta incorreta", Toast.LENGTH_SHORT).show();
            return;
        }


        if ((orangeColor1.equals(yellowColor)) || (orangeColor1.equals(redColor)) && (orangeColor2.equals(yellowColor)) || (orangeColor2.equals(redColor)) && (!orangeColor1.equals(orangeColor2)) ) {
            cont = cont + 1;
        }
        else {
            Toast.makeText(this, "Resposta incorreta", Toast.LENGTH_SHORT).show();
            return;
        }


        if ((purpleColor1.equals(blueColor)) || (purpleColor1.equals(redColor)) && (purpleColor2.equals(blueColor)) || (purpleColor2.equals(redColor)) && (!purpleColor1.equals(purpleColor2)) )
        {
            cont = cont + 1;
        }
        else
        {
            Toast.makeText(this, "Resposta incorreta", Toast.LENGTH_SHORT).show();
            return;
        }

        if (cont >= 1) {
            cont = 0;
            Toast.makeText(this, "Resposta correta!", Toast.LENGTH_SHORT).show();
        }

    }



}
