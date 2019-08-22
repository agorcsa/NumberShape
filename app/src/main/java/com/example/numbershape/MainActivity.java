package com.example.numbershape;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    private Context context;
    private int duration;
    private EditText editText;
    private Button button;

    private int number;
    private int myNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
    }


    public void showToast(String string) {

        context = getApplicationContext();
        duration = Toast.LENGTH_LONG;

        Toast.makeText(context, string, duration).show();
    }

    public void checkNumber(View view) {
        Number myNumber = new Number();
        String typedNumber = editText.getText().toString();
        if (typedNumber.isEmpty()) {
            showToast("Please type a number");
        } else {
            myNumber.number = Integer.valueOf(typedNumber);

            if (myNumber.isTriangular() && !myNumber.isSquare()) {
                showToast(myNumber.getNumber() + " is triangle number");
            } else if (!myNumber.isTriangular() && myNumber.isSquare()) {
                showToast(myNumber.getNumber() + " is square number");
            } else if (myNumber.isTriangular() && myNumber.isSquare()) {
                showToast(myNumber.getNumber() + " is both");
            } else {
                showToast(myNumber.getNumber()+ " is none");
            }
        }
    }

    class Number {

        int number;

        public int getNumber() {
            return number;
        }

        public boolean isTriangular() {
            // counter variable
            int x = 1;
            // triangular number
            int triangularNumber = 1;
            // we will generate triangular numbers till our input nr will reach the tri number

            while (triangularNumber < number) {

                x++;

                triangularNumber = triangularNumber + x;

            }

            if (triangularNumber == number) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isSquare() {
            double squareRoot = Math.sqrt(number);

            if (squareRoot == Math.floor(squareRoot)) {
                return true;
            } else {
                return false;
            }
        }
    }
}

