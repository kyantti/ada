package main.java.es.unex.cum.ada.practica1.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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

        long bubbleSortTime = 0;
        long cocktailSortTime = 0;
        long quickSortTime = 0;
        long selectionSortTime = 0;

        long totalTime = 0;

        int[] sizes = { 2000, 4000, 6000, 8000, 10000, 12000, 14000, 16000, 18000, 20000 };

        ArrayGenerator arrayGenerator = new ArrayGenerator();

        SortingAlgorithm bubbleSort = new BubbleSort();
        SortingAlgorithm cocktailSort = new CocktailSort();
        SortingAlgorithm quickSort = new QuickSort();
        SortingAlgorithm selectionSort = new SelectionSort();

        for (int size : sizes) {
            SortingResult sortingResult = new SortingResult();

            int [] bestCaseArray = arrayGenerator.generateBestCase(size);
            int [] averageCaseArray = arrayGenerator.generateAverageCase(size);
            int [] worstCaseArray = arrayGenerator.generateWorstCase(size);
            
            for (int i = 0; i < sizes.length; i++) {

                //--------------------------------BUBBLESORT--------------------------------
                time1 = System.currentTimeMillis();
                bubbleSort.sort(bestCaseArray, 0, 0);
                time2 = System.currentTimeMillis();
                sortingResult.getBubbleSortTimes().put("Best", time2-time1);

                time1 = System.currentTimeMillis();
                bubbleSort.sort(averageCaseArray, 0, 0);
                time2 = System.currentTimeMillis();
                sortingResult.getBubbleSortTimes().put("Average", time2-time1);

                time1 = System.currentTimeMillis();
                bubbleSort.sort(worstCaseArray, 0, 0);
                time2 = System.currentTimeMillis();
                sortingResult.getBubbleSortTimes().put("Worst", time2-time1);

                //--------------------------------COCKTAILSORT--------------------------------
                time1 = System.currentTimeMillis();
                cocktailSort.sort(bestCaseArray, 0, 0);
                time2 = System.currentTimeMillis();
                sortingResult.getCocktailSortTimes().put("Best", time2-time1);

                time1 = System.currentTimeMillis();
                cocktailSort.sort(averageCaseArray, 0, 0);
                time2 = System.currentTimeMillis();
                sortingResult.getCocktailSortTimes().put("Average", time2-time1);

                time1 = System.currentTimeMillis();
                cocktailSort.sort(worstCaseArray, 0, 0);
                time2 = System.currentTimeMillis();
                sortingResult.getCocktailSortTimes().put("Worst", time2-time1);

                //--------------------------------QUICKSORT--------------------------------
                time1 = System.currentTimeMillis();
                quickSort.sort(bestCaseArray, 0, 0);
                time2 = System.currentTimeMillis();
                sortingResult.getQuickSortTimes().put("Best", time2-time1);

                time1 = System.currentTimeMillis();
                quickSort.sort(averageCaseArray, 0, 0);
                time2 = System.currentTimeMillis();
                sortingResult.getQuickSortTimes().put("Average", time2-time1);

                time1 = System.currentTimeMillis();
                quickSort.sort(worstCaseArray, 0, 0);
                time2 = System.currentTimeMillis();
                sortingResult.getQuickSortTimes().put("Worst", time2-time1);

                 //--------------------------------QUICKSORT--------------------------------
                 time1 = System.currentTimeMillis();
                 selectionSort.sort(bestCaseArray, 0, 0);
                 time2 = System.currentTimeMillis();
                 sortingResult.getSelectionSortTimes().put("Best", time2-time1);
 
                 time1 = System.currentTimeMillis();
                 selectionSort.sort(averageCaseArray, 0, 0);
                 time2 = System.currentTimeMillis();
                 sortingResult.getSelectionSortTimes().put("Average", time2-time1);
 
                 time1 = System.currentTimeMillis();
                 selectionSort.sort(worstCaseArray, 0, 0);
                 time2 = System.currentTimeMillis();
                 sortingResult.getSelectionSortTimes().put("Worst", time2-time1);

            }

            

        }
    }

}
