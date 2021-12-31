package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of currency denominations");
        int size = sc.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter the currency denominations value");
        for (int i = 0; i < size; i++) { 
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the amount you want to pay");
        int amount = sc.nextInt();
        sc.close();

        Main.descendingSort(arr);
        
        int[] arrCount = new int[size];
        int amountLeft = amount;
        for (int i = 0; i < size; i++) {
            int count = amountLeft / arr[i];
            arrCount[i] = count;
            amountLeft = amountLeft - count * arr[i];
        }
        if (amountLeft == 0) {
            System.out.println("Your payment approach in order to give min no of notes will be");
            for (int i = 0; i < size; i++) {
                if (arrCount[i] != 0) {
                    System.out.println(arr[i] + ":" +arrCount[i]);
                }
            }
        }
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        int no1 = mid - l + 1;
        int no2 = r - mid;

        int[] list1 = new int[no1];
        int[] list2 = new int[no2];

        for (int i = 0; i < no1; i++) {
            list1[i] = arr[l + i];
        }

        for (int i = 0; i < no2; i++) {
            list2[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = l;
        while (i < no1 && j < no2) {
            if (list1[i] < list2[j]) {
                arr[k] = list1[i];
                i++;
            } else {
                arr[k] = list2[j];
                j++;
            }
            k++;
        }
        while (i < no1) {
            arr[k] = list1[i];
            k++;
            i++;
        }
        while (j < no2) {
            arr[k] = list2[j];
            k++;
            j++;
        }
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            Main.mergeSort(arr, l, mid);
            Main.mergeSort(arr, mid + 1, r);

            Main.merge(arr, l, mid, r);
        }
    }
    public static void descendingSort(int[] list) {
        Main.mergeSort(list, 0, list.length - 1);
        for (int i = 0; i < list.length/2; i++ ) {
            int temp = list[i];
            list[i] = list[list.length - 1 - i];
            list[list.length - 1 - i] = temp;
        }
    }
}
