package main.java.es.unex.cum.ada.practica1.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public SortingTest() {
        time1 = 0;
        time2 = 0;
        arrayGenerator = new ArrayGenerator();
        bubbleSort = new BubbleSort();
        cocktailSort = new CocktailSort();
        quickSort = new QuickSort();
        selectionSort = new SelectionSort();
    }

    public void selectTest(String type) {
        switch (type) {
            case "Best":
                testBestCase();
                break;
            case "Average"
                testAvgCase();
                break;
            case "Worst"
                testWorstCase();
                break;
            default:
                break;
        }
    }

    private void testWorstCase() {

    }

    private void testAvgCase() {

    }

    private Map<Integer, SortingResult> testBestCase() {
        Map <Integer, SortingResult> bestCaseMap = new HashMap<>();
        for (int size : sizes) {
            int[] bestCaseArray = arrayGenerator.generateBestCase(size);
            for (int i = 0; i < sizes.length; i++) {
                //BUBBLESORT
                time1 = System.currentTimeMillis();
                bubbleSort.sort(bestCaseArray, 0, 0);
                time2 = System.currentTimeMillis();

                
            }


        }
    }

    private long calculateAvgTime(Map<String, List<Long>> map) {
        long avg = 0;
        long sum = 0;
        for (Map.Entry<String, List<Long>> entry : map.entrySet()) {
          String key = entry.getKey();
          List<Long> values = entry.getValue();
          for (Long value : values) {
            sum += value;
          }
          avg = sum / values.size();
        }
        return avg;
    }
}
