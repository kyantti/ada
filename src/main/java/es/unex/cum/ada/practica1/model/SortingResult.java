package main.java.es.unex.cum.ada.practica1.model;

public class SortingResult {
    private int size;
    private long bubbleSortTime;
    private long cocktailSortTime;
    private long quickSortTime;
    private long selectionSortTime;

    public SortingResult(){
       size = 0;
       bubbleSortTime = 0;
       cocktailSortTime = 0;
       quickSortTime = 0;
       selectionSortTime = 0; 
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public Long getBubbleSortTime() {
        return bubbleSortTime;
    }
    public void setBubbleSortTime(Long bubbleSortTime) {
        this.bubbleSortTime = bubbleSortTime;
    }
    public Long getCocktailSortTime() {
        return cocktailSortTime;
    }
    public void setCocktailSortTime(Long cocktailSortTime) {
        this.cocktailSortTime = cocktailSortTime;
    }
    public Long getQuickSortTime() {
        return quickSortTime;
    }
    public void setQuickSortTime(Long quickSortTime) {
        this.quickSortTime = quickSortTime;
    }
    public Long getSelectionSortTime() {
        return selectionSortTime;
    }
    public void setSelectionSortTime(Long selectionSortTime) {
        this.selectionSortTime = selectionSortTime;
    }

}
