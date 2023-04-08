package main.java.es.unex.cum.ada.practica1.model;

import java.util.Random;

public class ArrayGenerator {

    private Random random;
    private int[] array;

    public ArrayGenerator(){
        random = new Random();
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int[] generateBestCase(int size) {
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i+1;
        }
        return array;
    }
    
    public int[] generateWorstCase(int size) {
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size-i;
        }
        return array;
    }
    
    public int[] generateAverageCase(int size) {
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }
}
