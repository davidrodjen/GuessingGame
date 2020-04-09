package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button leftButton;
    private Button rightButton;
    private TextView scoreView;
    private Random rand;
    private int leftNumber;
    private int rightNumber;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        leftButton = findViewById(R.id.leftButton);
        rightButton = findViewById(R.id.rightButton);
        scoreView = findViewById(R.id.scoreView);
        score = 0;
        rand = new Random();
        chooseNumbers();
    }

    public void onClick(View v){
        if (v == leftButton){
            if (leftNumber > rightNumber){
                score++;
                Toast.makeText(this, "Correct!", Toast.LENGTH_LONG).show();
            }
            else{
                score--;
                Toast.makeText(this, "Wrong!", Toast.LENGTH_LONG).show();
            }
        }
        else{
            if (leftNumber > rightNumber){
                score--;
                Toast.makeText(this, "Wrong!", Toast.LENGTH_LONG).show();
            }
            else{
                score++;
                Toast.makeText(this, "Correct!", Toast.LENGTH_LONG).show();
            }
        }
        scoreView.setText("Score: " + score);
        chooseNumbers();
    }

    private void chooseNumbers() {
        leftNumber = rand.nextInt( 10);
        rightNumber = rand.nextInt(10);
        while (leftButton == rightButton){
            rightNumber = rand.nextInt(10);
        }
        leftButton.setText("" + leftNumber);
        rightButton.setText("" + rightNumber);
    }
}
