package ru.it1;

import java.util.HashMap;
import java.util.Map;

/** The type FirstUniqFromList */
public class FirstUniqFromList {

    //Найти первый не повторяющийся элемент в массиве целых чисел
    public static void main(String[] args) {
        int[] arr = {9, 4, 9, 6, 7, 4, 5};

        Map<Integer, Integer> bank = new HashMap<>();

        int n = 0;

        for (int num : arr) {
            bank.put(num, bank.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            if (bank.get(num) == 1) {
                n = num;
                break;
            }
        }

        System.out.println(n);
    }
}

