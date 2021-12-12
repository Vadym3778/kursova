package com.example.kursova;

public class ArraySum {


    void ArrayS(long[] array) {

        long sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
            array[i] = sum;
        }
    }


}