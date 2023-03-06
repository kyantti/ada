package main.java.es.unex.cum.ada.practica1.model;

import java.util.HashMap;
import java.util.Map;

public class SortingTest {

    private Map<Integer, SortingResult> resultsMap;

    public SortingTest() {
        resultsMap = new HashMap<>();
    }

    public Map<Integer, SortingResult> getResultsMap() {
        return resultsMap;
    }

    public void test() {

        System.out.println("Ejecutando test");

        long time1 = 0;
        long time2 = 0;
        long time3 = 0;

        long bubbleSortTime = 0;
        long cocktailSortTime = 0;
        long quickSortTime = 0;
        long selectionSortTime = 0;

        int[] sizes = { 2000, 4000, 6000, 8000, 10000, 12000, 14000, 16000, 18000, 20000 };

        ArrayGenerator arrayGenerator = new ArrayGenerator();

        SortingAlgorithm bubbleSort = new BubbleSort();
        SortingAlgorithm cocktailSort = new CocktailSort();
        SortingAlgorithm quickSort = new QuickSort();
        SortingAlgorithm selectionSort = new SelectionSort();

        for (int size : sizes) {

            SortingResult sortingResult = new SortingResult();

            // ------------------------BUBBLESORT--------------------------------------
            // Best case
            time1 = System.currentTimeMillis();
            bubbleSort.sort(arrayGenerator.generateBestCase(size), 0, 0);
            time2 = System.currentTimeMillis();
            time3 = time2 - time1;
            // Average case
            time1 = System.currentTimeMillis();
            bubbleSort.sort(arrayGenerator.generateAverageCase(size), 0, 0);
            time2 = System.currentTimeMillis();
            time3 = time3 + (time2 - time1);
            // Worst case
            time1 = System.currentTimeMillis();
            bubbleSort.sort(arrayGenerator.generateWorstCase(size), 0, 0);
            time2 = System.currentTimeMillis();

            // Store results
            bubbleSortTime = time3 + (time2 - time1);

            // ------------------------COCKTAILSORT-------------------------------------

            // Best case
            time1 = System.currentTimeMillis();
            cocktailSort.sort(arrayGenerator.generateBestCase(size), 0, 0);
            time2 = System.currentTimeMillis();
            time3 = time2 - time1;
            // Average case
            time1 = System.currentTimeMillis();
            cocktailSort.sort(arrayGenerator.generateAverageCase(size), 0, 0);
            time2 = System.currentTimeMillis();
            time3 = time3 + (time2 - time1);
            // Worst case
            time1 = System.currentTimeMillis();
            cocktailSort.sort(arrayGenerator.generateWorstCase(size), 0, 0);
            time2 = System.currentTimeMillis();
            // Store results
            cocktailSortTime = time3 + (time2 - time1);

            // ------------------------QUICKSORT-------------------------------------

            // Best case
            time1 = System.currentTimeMillis();
            quickSort.sort(arrayGenerator.generateBestCase(size), 0, size - 1);
            time2 = System.currentTimeMillis();
            time3 = time2 - time1;
            // Average case
            time1 = System.currentTimeMillis();
            quickSort.sort(arrayGenerator.generateAverageCase(size), 0, size - 1);
            time2 = System.currentTimeMillis();
            time3 = time3 + (time2 - time1);
            // Worst case
            time1 = System.currentTimeMillis();
            quickSort.sort(arrayGenerator.generateWorstCase(size), 0, size - 1);
            time2 = System.currentTimeMillis();
            // Store results
            quickSortTime = time3 + (time2 - time1);

            // ------------------------SELECTIONSORT-------------------------------------

            // Best case
            time1 = System.currentTimeMillis();
            selectionSort.sort(arrayGenerator.generateBestCase(size), 0, 0);
            time2 = System.currentTimeMillis();
            time3 = time2 - time1;
            // Average case
            time1 = System.currentTimeMillis();
            selectionSort.sort(arrayGenerator.generateAverageCase(size), 0, 0);
            time2 = System.currentTimeMillis();
            time3 = time3 + (time2 - time1);
            // Worst case
            time1 = System.currentTimeMillis();
            selectionSort.sort(arrayGenerator.generateWorstCase(size), 0, 0);
            time2 = System.currentTimeMillis();
            // Store results
            selectionSortTime = time3 + (time2 - time1);

            sortingResult.setSize(size);
            sortingResult.setBubbleSortTime(bubbleSortTime / 3);
            sortingResult.setCocktailSortTime(cocktailSortTime / 3);
            sortingResult.setQuickSortTime(quickSortTime / 3);
            sortingResult.setSelectionSortTime(selectionSortTime / 3);

            resultsMap.put(size, sortingResult);

        }
    }

}
