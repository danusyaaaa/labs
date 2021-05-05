package com.laba7.laba7;

import com.laba7.laba7.service.impl.Calculator;
import com.laba7.laba7.service.impl.CalculatorImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@Slf4j
public class Laba7Application {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Calculator calculator = applicationContext.getBean(CalculatorImpl.class);

        Scanner input = new Scanner(System.in);


        log.debug("Input number 1 :");
        int number1 = input.nextInt();

        log.debug("Input number 2 :");
        int number2 = input.nextInt();

        log.info("Input operation : ");
        switch (input.next()) {
            case "+":
                log.info("Result fold : {}", calculator.fold(number1, number2));
                break;
            case "-":
                log.info("Result subtract : {}", calculator.subtract(number1, number2));
                break;
            case "/":
                log.info("Result division : {}", calculator.division(number1, number2));
                break;
            case "*":
                log.info("Result multiply : {}", calculator.multiply(number1, number2));
                break;
            default:
                log.info("Not founded operation ");
                break;
        }
    }
}
