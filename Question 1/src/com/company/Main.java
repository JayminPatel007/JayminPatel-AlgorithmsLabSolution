package com.company;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of transaction array");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the values of array");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the total no of targets that needs to be achieved");
        int noOfTransactions = sc.nextInt();
        for (int i = 0; i < noOfTransactions; i++) {
            System.out.println("Enter the value of target");
            int target = sc.nextInt();
            int count = Main.count(arr, target);
            if (count == 0) {
                System.out.println("Given target is not achieved");
            } else {
                System.out.println("Target achieved after " + count +" transactions");
            }
        }
        
    }

    private static int count(int[] arr, int target) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum > target) {
                break;
            }
            sum += arr[i];
            count++;
        }
        return count;
    }
}
