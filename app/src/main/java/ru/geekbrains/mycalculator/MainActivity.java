package ru.geekbrains.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView input;
    TextView saved;
    StringBuilder sb = new StringBuilder();
    Calculator calculator = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        input = findViewById(R.id.textView1);
        saved = findViewById(R.id.textView2);

        initNumberButtons();
        initActionButtons();
        initButtonC();
        initButtonEquals();

    }

    private void initNumberButtons() {
        initButton0();
        initButton1();
        initButton2();
        initButton3();
        initButton4();
        initButton5();
        initButton6();
        initButton7();
        initButton8();
        initButton9();
        initButtonDot();
    }

    private void initButton0() {
        Button button0 = findViewById(R.id.button_0);
        button0.setOnClickListener(v -> {
            if (sb.length() != 0) {
                sb.append(0);
                input.append("0");
            } else{
                input.setText("0");
            }
        });
    }

    private void initButton1() {
        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener( v_->{
            if (sb.length() != 0) {
                input.append("1");
            } else {
                input.setText("1");
            }
            sb.append(1);
        });
    }

    private void initButton2() {
        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener( v_->{
            if (sb.length() != 0) {
                input.append("2");
            } else {
                input.setText("2");
            }
            sb.append(2);
        });
    }

    private void initButton3() {
        Button button3 = findViewById(R.id.button_3);
        button3.setOnClickListener( v_->{
            if (sb.length() != 0) {
                input.append("3");
            } else {
                input.setText("3");
            }
            sb.append(3);
        });
    }

    private void initButton4() {
        Button button4 = findViewById(R.id.button_4);
        button4.setOnClickListener( v_->{
            if (sb.length() != 0) {
                input.append("4");
            } else {
                input.setText("4");
            }
            sb.append(4);
        });
    }

    private void initButton5() {
        Button button5 = findViewById(R.id.button_5);
        button5.setOnClickListener( v_->{
            if (sb.length() != 0) {
                input.append("5");
            } else {
                input.setText("5");
            }
            sb.append(5);
        });
    }

    private void initButton6() {
        Button button6 = findViewById(R.id.button_6);
        button6.setOnClickListener( v_->{
            if (sb.length() != 0) {
                input.append("6");
            } else {
                input.setText("6");
            }
            sb.append(6);
        });
    }

    private void initButton7() {
        Button button7 = findViewById(R.id.button_7);
        button7.setOnClickListener( v_->{
            if (sb.length() != 0) {
                input.append("7");
            } else {
                input.setText("7");
            }
            sb.append(7);
        });
    }

    private void initButton8() {
        Button button8 = findViewById(R.id.button_8);
        button8.setOnClickListener( v_->{
            if (sb.length() != 0) {
                input.append("8");
            } else {
                input.setText("8");
            }
            sb.append(8);
        });
    }

    private void initButton9() {
        Button button9 = findViewById(R.id.button_9);
        button9.setOnClickListener( v_->{
            if (sb.length() != 0) {
                input.append("9");
            } else {
                input.setText("9");
            }
            sb.append(9);
        });
    }

    private void initButtonDot() {
        Button buttonDot = findViewById(R.id.button_Dot);
        buttonDot.setOnClickListener( v_->{
            if (sb.lastIndexOf(".") == -1) {
                String symbol = (sb.length() > 0) ? ".":"0.";
                sb.append(symbol);
                input.setText(sb.toString());
            }
        });
    }

    private void initActionButtons() {
        initButtonDivision();
        initButtonMultiplication();
        initButtonSubtraction();
        initButtonAddition();
    }

    private void initButtonDivision(){
        Button buttonDivision = findViewById(R.id.button_Division);
        buttonDivision.setOnClickListener( v_->{
            if (sb.length() != 0 && calculator.getCurrentAction() == null) {
                calculator.setCurrentAction("/");
                calculator.setFirstNum(Double.valueOf(sb.toString()));
                sb.delete(0, sb.length());
                saved.setText(calculator.getFirstNum() + " "+ calculator.getCurrentAction() + " ");
            }
        });
    }

    private void initButtonMultiplication() {
        Button buttonMultiplication = findViewById(R.id.button_multiplicaion);
        buttonMultiplication.setOnClickListener( v_->{
            if (sb.length() != 0 && calculator.getCurrentAction() == null) {
                calculator.setCurrentAction("*");
                calculator.setFirstNum(Double.valueOf(sb.toString()));
                sb.delete(0, sb.length());
                saved.setText(calculator.getFirstNum() + " "+ calculator.getCurrentAction() + " ");
            }
        });
    }

    private void initButtonSubtraction() {
        Button buttonSubtraction = findViewById(R.id.button_subtraction);
        buttonSubtraction.setOnClickListener( v_->{
            if (sb.length() != 0 && calculator.getCurrentAction() == null) {
                calculator.setCurrentAction("-");
                calculator.setFirstNum(Double.valueOf(sb.toString()));
                sb.delete(0, sb.length());
                saved.setText(calculator.getFirstNum() + " "+ calculator.getCurrentAction() + " ");
            }
        });
    }

    private void initButtonAddition() {
        Button buttonAddition = findViewById(R.id.button_addition);
        buttonAddition.setOnClickListener( v_->{
            if (sb.length() != 0 && calculator.getCurrentAction() == null) {
                calculator.setCurrentAction("+");
                calculator.setFirstNum(Double.valueOf(sb.toString()));
                sb.delete(0, sb.length());
                saved.setText(calculator.getFirstNum() + " "+ calculator.getCurrentAction() + " ");
            }
        });
    }

    private void initButtonC() {
        Button buttonC = findViewById(R.id.button_C);
        buttonC.setOnClickListener( v_->{
            sb.delete(0, sb.length());
            calculator.setFirstNum(0);
            calculator.setSecondNum(0);
            calculator.setCurrentAction(null);
            saved.setText("");
            input.setText("0");
        });
    }


    private void initButtonEquals() {
        Button buttonEquals = findViewById(R.id.button_equals);
        buttonEquals.setOnClickListener( v_->{
            calculator.setSecondNum(Double.valueOf(sb.toString()));
            saved.setText(calculator.getFirstNum() + " "+ calculator.getCurrentAction() + " "+ calculator.getSecondNum()+" =");
            calculator.makeCalculation();
            sb.delete(0, sb.length());
            input.setText(String.valueOf(calculator.getResult()));
        });
    }
}