package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // Puchkov Alexey 3 course group PI
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double x = input.nextDouble();
        double y = getY(x);

        double dot = Math.pow(x, 2) + Math.pow(y, 2);

        if ((x == 0) || ((dot <= 25) && (x <= 0))) {
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }

    private static double getY(double x ){
        double valueAcos;
        if (x < 0){
            valueAcos = -Math.acos(Math.pow(Math.pow(Math.abs(x), 1.0/5) / (Math.pow(Math.abs(x), 1.0/5) + 1), 9));
        } else{
            valueAcos = Math.acos(Math.pow(Math.pow(x, 1.0/5) / (Math.pow(x, 1.0/5) + 1), 9));
        }
        double tg3x = (3 * Math.tan(x) - Math.pow(Math.tan(x), 3)) / (1 - 3 * Math.pow(Math.tan(x), 2));
        double firstTermLog = Math.pow(4, tg3x);
        double secondTermLog = Math.sqrt(Math.abs(3 * x - 1));
        double thirdTermLog = Math.pow(Math.abs(x), 2 * Math.sin(x) - Math.cos(x));
        double valueLog = Math.pow(Math.log((firstTermLog + secondTermLog + thirdTermLog ))/ Math.log(5), 2);
        double y = valueAcos + valueLog;
        return y;
    }
}