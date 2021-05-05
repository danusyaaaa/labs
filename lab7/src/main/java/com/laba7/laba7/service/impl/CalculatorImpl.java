package com.laba7.laba7.service.impl;

public class CalculatorImpl implements Calculator {


    @Override
    public int fold(int number1, int number2) {
        return number1 + number2;
    }

    @Override
    public int subtract(int number1, int number2) {
        return number1 - number2;
    }

    @Override
    public int multiply(int number1, int number2) {
        return number1 * number2;
    }

    @Override
    public double division(double number1, double number2) {
        return number1 / number2;
    }
}
