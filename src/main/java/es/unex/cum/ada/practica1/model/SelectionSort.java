package main.java.es.unex.cum.ada.practica1.model;

public class SelectionSort implements SortingAlgorithm {
    @Override
    public int[] sort(int[] numbers, int left, int right) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < numbers.length; j++)
                if (numbers[j] < numbers[index]) // Finds smallest number
                    index = j;

            int smallerNumber = numbers[index]; // Swap
            numbers[index] = numbers[i];
            numbers[i] = smallerNumber;

        }
        return numbers;
    }
}
