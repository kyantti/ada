package main.java.es.unex.cum.ada.practica1.model;

import java.util.HashMap;
import java.util.Map;

public class SortingResult {
    private int size;
    private Map<String, Long> bubbleSortTimes;
    private Map<String, Long> cocktailSortTimes;
    private Map<String, Long> quickSortTimes;
    private Map<String, Long> selectionSortTimes;

    public SortingResult() {
        size = 0;
        bubbleSortTimes = new HashMap<>();
        cocktailSortTimes = new HashMap<>();
        quickSortTimes = new HashMap<>();
        selectionSortTimes = new HashMap<>();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Map<String, Long> getBubbleSortTimes() {
        return bubbleSortTimes;
    }

    public void setBubbleSortTimes(Map<String, Long> bubbleSortTimes) {
        this.bubbleSortTimes = bubbleSortTimes;
    }

    public Map<String, Long> getCocktailSortTimes() {
        return cocktailSortTimes;
    }

    public void setCocktailSortTimes(Map<String, Long> cocktailSortTimes) {
        this.cocktailSortTimes = cocktailSortTimes;
    }

    public Map<String, Long> getQuickSortTimes() {
        return quickSortTimes;
    }

    public void setQuickSortTimes(Map<String, Long> quickSortTimes) {
        this.quickSortTimes = quickSortTimes;
    }

    public Map<String, Long> getSelectionSortTimes() {
        return selectionSortTimes;
    }

    public void setSelectionSortTimes(Map<String, Long> selectionSortTimes) {
        this.selectionSortTimes = selectionSortTimes;
    }

    

}
