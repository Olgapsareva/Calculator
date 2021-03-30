package ru.geekbrains.mycalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView input;
    private TextView saved;
    ButtonInitializer buttonInitializer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        input = findViewById(R.id.textView1);
        saved = findViewById(R.id.textView2);
        buttonInitializer = new ButtonInitializer(input, saved);

        Button button0 = findViewById(R.id.button_0);
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button button4 = findViewById(R.id.button_4);
        Button button5 = findViewById(R.id.button_5);
        Button button6 = findViewById(R.id.button_6);
        Button button7 = findViewById(R.id.button_7);
        Button button8 = findViewById(R.id.button_8);
        Button button9 = findViewById(R.id.button_9);

        Button[] buttons = {button0, button1, button2, button3, button4, button5, button6, button7, button8, button9};
        for (Button button : buttons) {
            buttonInitializer.initNumberButton(button);
        }

        Button buttonDot = findViewById(R.id.button_Dot);
        buttonInitializer.initButtonDot(buttonDot);

        Button buttonDivision = findViewById(R.id.button_Division);
        Button buttonSubtraction = findViewById(R.id.button_subtraction);
        Button buttonMultiplication = findViewById(R.id.button_multiplicaion);
        Button buttonAddition = findViewById(R.id.button_addition);

        Button[] actionButtons = {buttonDivision, buttonSubtraction, buttonMultiplication, buttonAddition};
        for (Button actionButton : actionButtons) {
            buttonInitializer.initActionButton(actionButton);
        }

        Button buttonC = findViewById(R.id.button_C);
        buttonInitializer.initButtonC(buttonC);

        Button buttonEquals = findViewById(R.id.button_equals);
        buttonInitializer.initButtonEquals(buttonEquals);

    }
    //надуваем меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.action_themes){
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }
        return true;
    }
}