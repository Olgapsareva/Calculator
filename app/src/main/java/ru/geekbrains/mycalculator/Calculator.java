package ru.geekbrains.mycalculator;


public class Calculator {

    private double firstNum;
    private double secondNum;
    private double result;
    private String currentAction;

    public Calculator() {
        this.firstNum = 0;
        this.secondNum = 0;
        this.result = 0;
    }

    public double getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(double firstNum) {
        this.firstNum = firstNum;
    }

    public double getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(double secondNum) {
        this.secondNum = secondNum;
    }

    public double getResult() {
        return result;
    }

    public String getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(String currentAction) {
        this.currentAction = currentAction;
    }

    public void makeCalculation() {
        switch (currentAction){
            case"/": division(); break;
            case"*": multiplication(); break;
            case"-": subtraction(); break;
            case"+": addition(); break;
        }
    }
    public void addition() {
        result = firstNum + secondNum;
    }
    public void subtraction() {
        result = firstNum - secondNum;
    }
    public void multiplication() {
        result = firstNum * secondNum;
    }

    public void division() {
        result = firstNum / secondNum;
    }
}
