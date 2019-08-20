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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
    }

    public boolean isTriangleNum(int number) {
        int triangular = (8 * number) + 1;
        if (Math.sqrt(triangular) % 2 == 1) {
            return true;
        }
        return false;
    }

    public boolean isSquareNum(int number) {
        int squared = (8 * number) + 1;
        if (Math.sqrt(squared) == 1) {
            return true;
        }
        return false;
    }

    public int checkNumber(int number) {
        if (isTriangleNum(number) && !isSquareNum(number)) {
            return 1;
        } else if (!isTriangleNum(number) && isSquareNum(number)) {
            return 2;
        } else if (isTriangleNum(number) && isSquareNum(number)) {
            return 3;
        } else {
            return 4;
        }
    }

    public void showToast(String string) {

        context = getApplicationContext();
        duration = Toast.LENGTH_LONG;

        Toast.makeText(context, string, duration).show();
    }

    public void displayMessage(View view) {

        Log.i(TAG, "Button was clicked");

        String typedNumber = editText.getText().toString();

        if (checkNumber(number) == 1) {
            showToast(typedNumber + " is a triangle number");
        } else if (checkNumber(number) == 2) {
            showToast(typedNumber + " is a square number");
        } else if (checkNumber(number) == 3) {
            showToast(typedNumber + " is both");
        } else {
            showToast(typedNumber + " is none");
        }
    }
}
