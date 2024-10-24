package org.example;

import java.util.Vector;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int rows = getInput();
        int columns = getInput();
        int[][] matrix;
        Vector<Boolean> vector;

        matrix = createMatrix(rows, columns);
        vector = createBooleanVector(matrix, rows, columns);

        printMatrix(matrix, rows, columns);
        printVector(vector);
    }

    private static int getInput(){
        int number = 0;
        try{
            Scanner input = new Scanner(System.in);
            number = input.nextInt();
        } catch(InputMismatchException e){
            System.out.println("Вводить можно только числа ");
        }
        return number;
    }

    private static int getRandomNumber(){
        return (int) (Math.random() * 101 - 50);
    }

    private static int[][] createMatrix(int rows, int columns){
        int[][] matrix;
        matrix = new int[rows][columns];
        for(int rowIndex = 0; rowIndex < rows; rowIndex++){
            for(int columnIndex = 0; columnIndex < columns; columnIndex++){
                matrix[rowIndex][columnIndex] = getRandomNumber();
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix, int rows, int columns){
        for(int rowIndex = 0; rowIndex < rows; rowIndex++){
            for(int columnIndex = 0; columnIndex < columns; columnIndex++){
                System.out.print(matrix[rowIndex][columnIndex] + " ");
            }
            System.out.println();
        }
    }

    private static void printVector(Vector<Boolean> vector){
        for (int index = 0; index < vector.size(); index++){
            System.out.print(vector.get(index) + " ");
        }
    }

    private static Vector<Boolean> createBooleanVector(int[][] matrix, int rows, int columns){
        Vector<Boolean> vector = new Vector<>();
        int counterBeforeMiddle = 0;
        int counterAfterMiddle = 0;
        int markElement = 0;
        int iteration = 0;
        double middleElement = Math.floor(columns / 2.0);
        boolean flag = false;
        for(int rowIndex = 0; rowIndex < rows; rowIndex++){
            for(int columnIndex = 0; columnIndex < columns; columnIndex++){
                if(columnIndex != markElement){
                    if(columnIndex < ((int)middleElement)){
                        counterBeforeMiddle += matrix[rowIndex][columnIndex];
                    } else if (columnIndex > ((int)middleElement)){
                        counterAfterMiddle += matrix[rowIndex][columnIndex];
                    }
                }
                if(columnIndex == columns - 1){
                    markElement++;
                    iteration++;
                    columnIndex = 0;
                    if(counterBeforeMiddle == counterAfterMiddle){
                        System.out.println("В строке "  + rowIndex);
                        flag = true;
                    }
                    if(iteration == columns){
                        iteration = 0;
                        markElement = 0;
                        columnIndex = columns;
                    }
                }
            }
            vector.add(flag);
        }
        return vector;
    }
}