package ru.geekbrains.mycalculator;

import android.widget.Button;
import android.widget.TextView;

public class ButtonInitializer {

    private TextView input;
    private TextView saved;
    private StringBuilder sb = new StringBuilder();
    private Calculator calculator = new Calculator();

    public ButtonInitializer(TextView input, TextView saved) {
        this.input = input;
        this.saved = saved;
    }

    //ининциализация 0-9
    public void initNumberButton(Button btn){
        String val = btn.getText().toString();
        btn.setOnClickListener(v -> {
            if (sb.length() != 0) {
                input.append(val);
            } else{
                input.setText(val);
            }
            sb.append(val);
        });
    }

    public void initButtonDot(Button btn) {
        btn.setOnClickListener( v_->{
            if (sb.lastIndexOf(".") == -1) {
                String symbol = (sb.length() > 0) ? ".":"0.";
                sb.append(symbol);
                input.setText(sb.toString());
            }
        });
    }

    //ининциализация действий: / * + -
    public void initActionButton(Button btn){
        String val = btn.getText().toString();
        btn.setOnClickListener( v_->{
            if (sb.length() != 0 && calculator.getCurrentAction() == null) {
                calculator.setCurrentAction(val);
                calculator.setFirstNum(Double.valueOf(sb.toString()));
                sb.delete(0, sb.length());
                saved.setText(calculator.getFirstNum() + " "+ calculator.getCurrentAction() + " ");
            }
        });
    }

    public void initButtonC(Button buttonC) {
            buttonC.setOnClickListener( v_->{
                sb.delete(0, sb.length());
                calculator.setFirstNum(0);
                calculator.setSecondNum(0);
                calculator.setCurrentAction(null);
                saved.setText("");
                input.setText("0");
            });
    }

    public void initButtonEquals(Button buttonEquals) {
            buttonEquals.setOnClickListener( v_->{
                //кнопка срабатывает только в случае если пользователь выбрал действие и ввел что-то в качестве 2го числа
                if (calculator.getCurrentAction() != null & sb.length() >0) {
                    calculator.setSecondNum(Double.valueOf(sb.toString()));
                    saved.setText(calculator.getFirstNum() + " " + calculator.getCurrentAction() + " " + calculator.getSecondNum() + " =");
                    calculator.makeCalculation();
                    sb.delete(0, sb.length());
                    input.setText(String.valueOf(calculator.getResult()));
                }
            });
    }
}
