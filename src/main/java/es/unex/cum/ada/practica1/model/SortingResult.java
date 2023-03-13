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

    public SortingResult() {
        arraySize = 0;
        bubbleSortAvgTime = 0;
        cocktailSortAvgTime = 0;
        quickSortAvgTime = 0;
        selectionSortAvgTime = 0;
    }

    public long getBubbleSortAvgTime() {
        return bubbleSortAvgTime;
    }

    public void setBubbleSortAvgTime(long bubbleSortAvgTime) {
        this.bubbleSortAvgTime = bubbleSortAvgTime;
    }

    public long getCocktailSortAvgTime() {
        return cocktailSortAvgTime;
    }

    public void setCocktailSortAvgTime(long cocktailSortAvgTime) {
        this.cocktailSortAvgTime = cocktailSortAvgTime;
    }

    public long getQuickSortAvgTime() {
        return quickSortAvgTime;
    }

    public void setQuickSortAvgTime(long quickSortAvgTime) {
        this.quickSortAvgTime = quickSortAvgTime;
    }

    public long getSelectionSortAvgTime() {
        return selectionSortAvgTime;
    }

    public void setSelectionSortAvgTime(long selectionSortAvgTime) {
        this.selectionSortAvgTime = selectionSortAvgTime;
    }

    public int getArraySize() {
        return arraySize;
    }

    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }

}
