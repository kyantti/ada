package main.java.es.unex.cum.ada.practica1.model;

public interface SortingAlgorithm {
    //left y right solo toman valor distinto de null para quicksort
    public abstract int[] sort(int[] array, int left, int right);
}
