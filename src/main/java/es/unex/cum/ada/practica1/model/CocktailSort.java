package main.java.es.unex.cum.ada.practica1.model;

public class CocktailSort implements SortingAlgorithm {
	private long time;

	public CocktailSort(){
		time = 0;
	}

	public long getTime(){
		return time;
	}

    @Override
	public int[] sort (int[] numbers, int left, int right) {
		long t1 = System.currentTimeMillis();
		boolean swapped = true;
		int i = 0;
		int j = numbers.length - 1;
		while (i < j && swapped) { 
			swapped = false;
			for (int k = i; k < j; k++) {
				if (numbers[k] > numbers[k + 1]) {
					int temp = numbers[k];
					numbers[k] = numbers[k + 1];
					numbers[k + 1] = temp;
					swapped = true;
				}
			}
			j--;
			if (swapped) {
				swapped = false;
				for (int k = j; k > i; k--) {
					if (numbers[k] < numbers[k - 1]) {
						int temp = numbers[k];
						numbers[k] = numbers[k - 1];
						numbers[k - 1] = temp;
						swapped = true;
					}
				}
			}
			i++;
		}
		long t2 = System.currentTimeMillis();
        time = t2 - t1;
        return numbers;
	}

}
