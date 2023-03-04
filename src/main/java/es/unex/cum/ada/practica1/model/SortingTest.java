package main.java.es.unex.cum.ada.practica1.model;

import java.util.HashMap;
import java.util.Map;

public class SortingTest {

    private Map <Integer, Long> bubbleSortTimes;
    private Map <Integer, Long> cocktailSortTimes;
    private Map <Integer, Long> quickSortTimes;
    private Map <Integer, Long> selectionSortTimes;

    public SortingTest(){
        bubbleSortTimes = new HashMap<>();
        cocktailSortTimes = new HashMap<>();
        quickSortTimes = new HashMap<>();
        selectionSortTimes = new HashMap<>(); 
    }

    public void test(){
        long time1 = 0;
        long time2 = 0;
        long time3 = 0;

        int[] sizes = {2000, 4000, 6000, 8000, 10000, 12000, 14000, 16000, 18000, 20000};

        ArrayGenerator arrayGenerator = new ArrayGenerator();

        SortingAlgorithm bubbleSort = new BubbleSort();
        SortingAlgorithm cocktailSort = new CocktailSort();
        SortingAlgorithm quickSort = new QuickSort();
        SortingAlgorithm selectionSort = new SelectionSort(); 

        for (int size : sizes) {
            //------------------------BUBBLESORT--------------------------------------
            //Best case
            time1 = System.nanoTime();
            bubbleSort.sort(arrayGenerator.generateBestCase(size), 0, 0);
            time2 = System.nanoTime();
            time3 = time2 - time1;
            //Average case
            time1 = System.nanoTime();
            bubbleSort.sort(arrayGenerator.generateAverageCase(size), 0, 0);
            time2 = System.nanoTime();
            time3 = time3 + (time2-time1);
            //Worst case
            time1 = System.nanoTime();
            bubbleSort.sort( arrayGenerator.generateWorstCase(size), 0, 0);
            time2 = System.nanoTime();
            time3 = time3 + (time2-time1);
            //Store results
            bubbleSortTimes.put(size, time3/3);

            //------------------------COCKTAILSORT-------------------------------------
    
            //Best case
            time1 = System.nanoTime();
            cocktailSort.sort(arrayGenerator.generateBestCase(size), 0, 0);
            time2 = System.nanoTime();
            time3 = time2 - time1;
            //Average case
            time1 = System.nanoTime();
            cocktailSort.sort(arrayGenerator.generateAverageCase(size), 0, 0);
            time2 = System.nanoTime();
            time3 = time3 + (time2-time1);
            //Worst case
            time1 = System.nanoTime();
            cocktailSort.sort( arrayGenerator.generateWorstCase(size), 0, 0);
            time2 = System.nanoTime();
            time3 = time3 + (time2-time1);
            //Store results
            cocktailSortTimes.put(size, time3/3);

            //------------------------QUICKSORT-------------------------------------
    
            //Best case
            time1 = System.nanoTime();
            quickSort.sort(arrayGenerator.generateBestCase(size), 0, size);
            time2 = System.nanoTime();
            time3 = time2 - time1;
            //Average case
            time1 = System.nanoTime();
            quickSort.sort(arrayGenerator.generateAverageCase(size), 0, size);
            time2 = System.nanoTime();
            time3 = time3 + (time2-time1);
            //Worst case
            time1 = System.nanoTime();
            quickSort.sort( arrayGenerator.generateWorstCase(size), 0, size);
            time2 = System.nanoTime();
            time3 = time3 + (time2-time1);
            //Store results
            quickSortTimes.put(size, time3/3);

            //------------------------SELECTIONSORT-------------------------------------
    
            //Best case
            time1 = System.nanoTime();
            selectionSort.sort(arrayGenerator.generateBestCase(size), 0, 0);
            time2 = System.nanoTime();
            time3 = time2 - time1;
            //Average case
            time1 = System.nanoTime();
            selectionSort.sort(arrayGenerator.generateAverageCase(size), 0, 0);
            time2 = System.nanoTime();
            time3 = time3 + (time2-time1);
            //Worst case
            time1 = System.nanoTime();
            selectionSort.sort( arrayGenerator.generateWorstCase(size), 0, 0);
            time2 = System.nanoTime();
            time3 = time3 + (time2-time1);
            //Store results
            selectionSortTimes.put(size, time3/3);
        }
    }

    public static void main(String[] args) {
        SortingTest sortingTest = new SortingTest();
        sortingTest.test();
    }
}
