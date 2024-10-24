package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double x = input.nextDouble();

        if (x <= 8){
            calculateFirstFunction(x);
        } else if(x > 8 && x < 9){
            calculateSecondFunction(x);
        } else if (x >= 9){
            calculateThirdFunction(x);
        }
    }

    private static void calculateFirstFunction(double x){
        double y;
        y = Math.acos(Math.pow(Math.E, -Math.abs(x)));
        System.out.println(y);
    }

    private static void calculateSecondFunction(double x){
        double y = 0;
        double denominator = 7 + Math.pow(x, 2);
        if(denominator == 0){
            System.out.println("Знаменатель не может ровняться нулю");
        } else{
            y = Math.cos(Math.pow(x, 5) / (7 + Math.pow(x, 2)));
        }
        System.out.println(y);
    }

    private static void calculateThirdFunction(double x){
        double y;
        y = Math.pow(x, 8) + Math.pow(x, x - 10);
        System.out.println(y);
    }
}