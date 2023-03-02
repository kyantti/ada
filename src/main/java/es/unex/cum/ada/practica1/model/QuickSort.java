package main.java.es.unex.cum.ada.practica1.model;

public class QuickSort implements SortingAlgorithm {
	long time;
    @Override
	public int[] sort(int[] a, int left, int right) {
		if (left < right) {
			int pivot = average3(a, left, right);
			int i = left;
			int j = right - 1;
			for (; i < j;) {
				while (pivot - a[++i] > 0);
				while (pivot - a[--j] < 0);
				swap(a, i, j);
			}
			swap(a, i, j); // Deshacer el ultimo cambio
			swap(a, i, right - 1); // Restaurar el pivote
			sort(a, left, i - 1); // Ordenar recursivamente los elementos menores
			sort(a, i + 1, right); // Ordenar recursivamente los elementos mayores
		}
        return a;
	}

	// Metodo para intercambiar dos elementos de un arrayay
	private static void swap(int[] a, int ind1, int ind2) {
		int tmp = a[ind1];
		a[ind1] = a[ind2];
		a[ind2] = tmp;
	}

	/**
	 * Metodo para calculo de la mediana de 3, devuelve el valor del pivote
	 */
	private static int average3(int[] a, int left, int right) {
		int c = (left + right) / 2;
		if (a[c] - (a[left]) < 0)
			swap(a, left, c);
		if (a[right] - (a[left]) < 0)
			swap(a, left, right);
		if (a[right] - (a[c]) < 0)
			swap(a, c, right);
		// (ocultar el pivote en la posicion right-1
		swap(a, c, right - 1);
		return a[right - 1];
	}
}