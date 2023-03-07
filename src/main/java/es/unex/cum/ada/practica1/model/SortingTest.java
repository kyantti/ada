package main.java.es.unex.cum.ada.practica1.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortingTest {
    private long time1;
    private long time2;
    private ArrayGenerator arrayGenerator;
    private BubbleSort bubbleSort;
    private CocktailSort cocktailSort;
    private QuickSort quickSort;
    private SelectionSort selectionSort;
    private static int[] sizes = { 2000, 4000, 6000, 8000, 10000, 12000, 14000, 16000, 18000, 20000 };
    private long [] bubbleSortTimes;
    private long [] cocktailSortTimes;
    private long [] quickSortTimes;
    private long [] selectionSortTimes;
    private Map <Integer, SortingResult> resultsMap;

    public SortingTest() {
        time1 = 0;
        time2 = 0;
        arrayGenerator = new ArrayGenerator();
        bubbleSort = new BubbleSort();
        cocktailSort = new CocktailSort();
        quickSort = new QuickSort();
        selectionSort = new SelectionSort();
        bubbleSortTimes = new long[10];
        cocktailSortTimes = new long[10];
        quickSortTimes = new long[10];
        selectionSortTimes = new long[10];
        resultsMap = new HashMap<>();
    }

    public Map<Integer, SortingResult> getResultsMap() {
        return resultsMap;
    }

    public void setResultsMap(Map<Integer, SortingResult> resultsMap) {
        this.resultsMap = resultsMap;
    }

    public void selectTest(String type) {
        switch (type) {
            case "Best":
                testBestCase();
                break;
            case "Average":
                testAvgCase();
                break;
            case "Worst":
                testWorstCase();
                break;
            default:
                break;
        }
    }

    private void testBestCase() {
        for (int size : sizes) {
            int[] initialBestCaseArray = arrayGenerator.generateBestCase(size);
            for (int i = 0; i < 10; i++) {
                // BUBBLESORT
                time1 = System.currentTimeMillis();
                bubbleSort.sort(Arrays.copyOf(initialBestCaseArray, initialBestCaseArray.length), 0, 0);
                time2 = System.currentTimeMillis();
                bubbleSortTimes[i] = time2 - time1;
                // COCKTAILSORT
                time1 = System.currentTimeMillis();
                cocktailSort.sort(Arrays.copyOf(initialBestCaseArray, initialBestCaseArray.length), 0, 0);
                time2 = System.currentTimeMillis();
                cocktailSortTimes[i] = time2 - time1;
                // QUICKSORT
                time1 = System.currentTimeMillis();
                quickSort.sort(Arrays.copyOf(initialBestCaseArray, initialBestCaseArray.length), 0, initialBestCaseArray.length - 1);
                time2 = System.currentTimeMillis();
                quickSortTimes[i] = time2 - time1;
                // SELECTIONSORT
                time1 = System.currentTimeMillis();
                selectionSort.sort(Arrays.copyOf(initialBestCaseArray, initialBestCaseArray.length), 0, 0);
                time2 = System.currentTimeMillis();
                selectionSortTimes[i] = time2 - time1;
            }
            resultsMap.put(size, new SortingResult(size, average(bubbleSortTimes), average(cocktailSortTimes),
                    average(quickSortTimes), average(selectionSortTimes)));
        }
    }

    private void testAvgCase() {
        for (int size : sizes) {
            int[] initialAvgCaseArray = arrayGenerator.generateAverageCase(size);
            for (int i = 0; i < 10; i++) {
                // BUBBLESORT
                time1 = System.currentTimeMillis();
                bubbleSort.sort(Arrays.copyOf(initialAvgCaseArray, initialAvgCaseArray.length), 0, 0);
                time2 = System.currentTimeMillis();
                bubbleSortTimes[i] = time2 - time1;
                // COCKTAILSORT
                time1 = System.currentTimeMillis();
                cocktailSort.sort(Arrays.copyOf(initialAvgCaseArray, initialAvgCaseArray.length), 0, 0);
                time2 = System.currentTimeMillis();
                cocktailSortTimes[i] = time2 - time1;
                // QUICKSORT
                time1 = System.currentTimeMillis();
                quickSort.sort(Arrays.copyOf(initialAvgCaseArray, initialAvgCaseArray.length), 0, initialAvgCaseArray.length - 1);
                time2 = System.currentTimeMillis();
                quickSortTimes[i] = time2 - time1;
                // SELECTIONSORT
                time1 = System.currentTimeMillis();
                selectionSort.sort(Arrays.copyOf(initialAvgCaseArray, initialAvgCaseArray.length), 0, 0);
                time2 = System.currentTimeMillis();
                selectionSortTimes[i] = time2 - time1;
            }
            resultsMap.put(size, new SortingResult(size, average(bubbleSortTimes), average(cocktailSortTimes),
                    average(quickSortTimes), average(selectionSortTimes)));
        }
    }

    private void testWorstCase() {
        for (int size : sizes) {
            int[] initialWorstCaseArray = arrayGenerator.generateWorstCase(size);
            for (int i = 0; i < 10; i++) {
                // BUBBLESORT
                time1 = System.currentTimeMillis();
                bubbleSort.sort(Arrays.copyOf(initialWorstCaseArray, initialWorstCaseArray.length), 0, 0);
                time2 = System.currentTimeMillis();
                bubbleSortTimes[i] = time2 - time1;
                // COCKTAILSORT
                time1 = System.currentTimeMillis();
                cocktailSort.sort(Arrays.copyOf(initialWorstCaseArray, initialWorstCaseArray.length), 0, 0);
                time2 = System.currentTimeMillis();
                cocktailSortTimes[i] = time2 - time1;
                // QUICKSORT
                time1 = System.currentTimeMillis();
                quickSort.sort(Arrays.copyOf(initialWorstCaseArray, initialWorstCaseArray.length), 0, initialWorstCaseArray.length - 1);
                time2 = System.currentTimeMillis();
                quickSortTimes[i] = time2 - time1;
                // SELECTIONSORT
                time1 = System.currentTimeMillis();
                selectionSort.sort(Arrays.copyOf(initialWorstCaseArray, initialWorstCaseArray.length), 0, 0);
                time2 = System.currentTimeMillis();
                selectionSortTimes[i] = time2 - time1;
            }
            resultsMap.put(size, new SortingResult(size, average(bubbleSortTimes), average(cocktailSortTimes),
                    average(quickSortTimes), average(selectionSortTimes)));
        }
    }

    private long average(long[] array) {
        long sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        return sum / array.length;
    }

}
