package main.java.es.unex.cum.ada.practica1.model;

public class BubbleSort implements SortingAlgorithm {

    private long time;

    private BubbleSort(){
        time = 0;
    }

    public long getTime() {
        return time;
    }

    @Override
    public int[] sort(int[] numbers, int left, int right) {
        long t1 = System.currentTimeMillis();
        boolean swapped = true;
        for(int i = numbers.length - 1; i > 0 && swapped; i--) {
            swapped = false;
            for (int j = 0; j < i; j++) {
                if (numbers[j] > numbers[j+1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                    swapped = true;
                }
            }
        }
        long t2 = System.currentTimeMillis();
        time = t2 - t1;
        return numbers;
    }
}
