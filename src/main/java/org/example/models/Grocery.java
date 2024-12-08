package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    Scanner scanner = new Scanner(System.in);

    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void addItems(String input) {
        String[] items = input.trim().split(",");

        for (String item: items) {
            if (!checkItemIsInList(item)){
                groceryList.add(item);
            }
        }

        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String[] items = input.trim().split(",");

        for (String item: items) {
            if(checkItemIsInList(item)) {
                groceryList.remove(item);
            }
        }

        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println(groceryList);
    }

    public void startGrocery() {
        int choice;
        do {
            System.out.println("Press 0 to quit || 1 to add items || 2 to remove items");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                    String itemToAdd = scanner.nextLine();
                    addItems(itemToAdd);
                    printSorted();
                    break;
                case 2:
                    System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    printSorted();
                    break;
                default:
                    System.out.println("quitting the app...");
                    break;
            }
        }while (choice != 0);

        scanner.close();
    }

}
