package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int iteration = 0;
        int[][] arr;
        int comparison;
        int[][] foundElements;
        while(iteration != 3){
            int rows = getInput();
            int columns = getInput();
            System.out.print("Число для сравнения: ");
            comparison = getInput();

            arr = new int[rows][columns];
            fillArray(arr, rows, columns);
            searchElementMoreInput(arr, rows, columns, comparison);
            foundElements = searchPositionElement(arr, rows, columns, comparison);
            printFoundElements(foundElements, rows, columns);
            iteration++;
        }

    }

    private static int getInput(){
        int numberInput = 0;
        try {
            Scanner input = new Scanner(System.in);
            numberInput = input.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Могут быть введены только числа ");
        }
        return numberInput;
    }

    private static int getRandomNumber(){
        return (int) (Math.random() * 101 - 50);
    }

    private static void fillArray(int[][] arr, int rows, int columns){
        for(int rowIndex = 0; rowIndex < rows; rowIndex++){
            for(int columnIndex = 0; columnIndex < columns; columnIndex++){
                arr[rowIndex][columnIndex] = getRandomNumber();
            }
        }
    }

    private static void printArray(int[][] arr, int rows, int columns){
        for(int rowIndex = 0; rowIndex < rows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < columns; columnIndex++) {
                System.out.print(arr[rowIndex][columnIndex] + " ");
            }
            System.out.println();
        }
    }

    private static void printFoundElements(int[][] foundElements, int rows, int columns){
        int row;
        int column;
        for(int rowIndex = 0; rowIndex < rows; rowIndex++){
            for(int columnIndex = 0; columnIndex < columns; columnIndex++){
                if(foundElements[rowIndex][columnIndex] != 0){
                    row = rowIndex + 1;
                    column = columnIndex + 1;
                    System.out.println("Элемент найден в ряду "+ row + "\n" + "Элемент найден в колонке " + column);
                }
            }
        }
    }

    private static void searchElementMoreInput(int[][] arr, int rows, int columns, int comparison){
        int elements = 0;
        for(int rowIndex = 0; rowIndex < rows; rowIndex++){
            for(int columnIndex = 0; columnIndex < columns; columnIndex++) {
                if (arr[rowIndex][columnIndex] >= comparison && ((rowIndex  + columnIndex) % 2 != 0)){
                    elements++;
                }
            }
        }
        System.out.println("Количество элементов которые не меньше введёного: " + elements);
    }

    private  static int[][] searchPositionElement(int[][] arr, int rows, int columns, int comparison){
        int[][] foundElements;
        foundElements = new int[rows][columns];
        for(int rowIndex = 0; rowIndex < rows; rowIndex++){
            for(int columnIndex = 0; columnIndex < columns; columnIndex++) {
                if (arr[rowIndex][columnIndex] >= comparison && ((rowIndex  + columnIndex) % 2 != 0)){
                    foundElements[rowIndex][columnIndex] = arr[rowIndex][columnIndex];
                }
            }
        }
        return foundElements;
    }
}