package main.java.es.unex.cum.ada.practica2;

import java.util.Arrays;
import java.util.Scanner;

public class ClosestNumbers {

    private static int[] sort(int[] a, int left, int right) {
		if (left < right) {
			int pivot = average3(a, left, right);
			int i = left;
			int j = right - 1;
			while (i < j) {
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
    
    public static int[] findUpperAndLower(int[] array, int x) {
        int[] result = new int[2];
        
        // Si el array tiene sólo un elemento
        if (array.length == 1) {
            setBoundsForSingleElementArray(array, x, result);
        }
        // Si el array tiene más de un elemento
        else {
            setBoundsForMultiElementArray(array, x, result);
        }
        
        return result;
    }
    
    private static void setBoundsForSingleElementArray(int[] array, int x, int[] result) {
        // Si el elemento es igual a x
        if (array[0] == x) {
            result[0] = -1; // No hay elemento menor a x
            result[1] = -1; // No hay elemento mayor a x
        // Si el elemento es menor a x
        }
        else if (array[0] < x) {
            result[0] = array[0]; // El elemento es el menor de todos los elementos
            result[1] = -1; // No hay elemento mayor a x
        }
        // Si el elemento es mayor a x
        else {
            result[0] = -1; // No hay elemento menor a x
            result[1] = array[0]; // El elemento es el mayor de todos los elementos
        }
    }
    
    private static void setBoundsForMultiElementArray(int[] array, int x, int[] result) {
        // Se divide el array en dos
        int mid = array.length / 2;
        // Se llama a la función de manera recursiva para la mitad izquierda
        int[] left = findUpperAndLower(Arrays.copyOfRange(array, 0, mid), x);
        // Se llama a la función de manera recursiva para la mitad derecha
        int[] right = findUpperAndLower(Arrays.copyOfRange(array, mid, array.length), x);
    
        // Seleccionar el valor menor
        setUpperBound(left, right, x, result);
        // Seleccionar el valor mayor
        setLowerBound(left, right, x, result);
    }
    
    private static void setUpperBound(int[] left, int[] right, int x, int[] result) {
        // Si no existe un límite superior en ninguno de los dos arrays
        if (left[0] == -1 && right[0] == -1) {
            result[0] = -1; // No hay un límite superior
        }
        // Si no existe un límite superior en la mitad izquierda
        else if (left[0] == -1) {
            result[0] = right[0]; // El límite superior es el de la mitad derecha
        }
        // Si no existe un límite superior en la mitad derecha
        else if (right[0] == -1) {
            result[0] = left[0]; // El límite superior es el de la mitad izquierda
        }
        // Si hay un límite superior en ambas mitades, se selecciona el más cercano a x
        else if (x - left[0] <= right[0] - x) {
            result[0] = left[0]; // El límite superior es el de la mitad izquierda
        }
        else {
            result[0] = right[0]; // El límite superior es el de la mitad derecha
        }
    }
    
    private static void setLowerBound(int[] left, int[] right, int x, int[] result) {
        // Si no existe un límite inferior en ninguno de los dos arrays
        if (left[1] == -1 && right[1] == -1) {
            result[1] = -1; // No hay un límite inferior
        }
        // Si no existe un límite inferior en la mitad izquierda
        else if (left[1] == -1) {
            result[1] = right[1]; // El límite inferior es el de la mitad derecha
        }
        // Si no existe un límite inferior en la mitad derecha
        else if (right[1] == -1) {
            result[1] = left[1]; // El límite inferior es el de la mitad izquierda
        }
        // Si hay un límite inferior en ambas mitades, se selecciona el más cercano a x
        else if (x - left[1] < right[1] - x) {
            result[1] = left[1]; // El límite inferior es el de la mitad izquierda
        }
        else {
            result[1] = right[1]; // El límite inferior es el de la mitad derecha

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] result;

        int numberOfTulips = scanner.nextInt();
        int[] tulips = new int[numberOfTulips];

        for (int i = 0; i < numberOfTulips; i++) {
            tulips[i] = scanner.nextInt();
        }

        int numberOfConsults = scanner.nextInt();
        int[] consults = new int[numberOfConsults];

        for (int i = 0; i < numberOfConsults; i++) {
            consults[i] = scanner.nextInt();
        }

        scanner.close();
       
        for (int consult : consults) {
            result = findUpperAndLower(sort(tulips, 0, tulips.length - 1), consult);
            System.out.println((result[1] == -1 ? "X" : result[1]) + " " + (result[0] == -1 ? "X" : result[0]));
        }
    }
}
