package main.java.es.unex.cum.ada.practica1.model;

public class SortingResult {
    private int  arraySize;
    private long bubbleSortAvgTime;
    private long cocktailSortAvgTime;
    private long quickSortAvgTime;
    private long selectionSortAvgTime;

    public SortingResult(int arraySize, long bubbleSortAvgTime, long cocktailSortAvgTime,
            long quickSortAvgTime, long selectionSortAvgTime) {
        this.arraySize = arraySize;
        this.bubbleSortAvgTime = bubbleSortAvgTime;
        this.cocktailSortAvgTime = cocktailSortAvgTime;
        this.quickSortAvgTime = quickSortAvgTime;
        this.selectionSortAvgTime = selectionSortAvgTime;
    }

    public long getBubbleSortAvgTime() {
        return bubbleSortAvgTime;
    }

    public long getCocktailSortAvgTime() {
        return cocktailSortAvgTime;
    }

    public long getQuickSortAvgTime() {
        return quickSortAvgTime;
    }

    public long getSelectionSortAvgTime() {
        return selectionSortAvgTime;
    }

    public int getArraySize() {
        return arraySize;
    }
}
