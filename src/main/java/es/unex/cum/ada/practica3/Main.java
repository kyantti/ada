package main.java.es.unex.cum.ada.practica3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(); // número de segmentos
        int l = scanner.nextInt(); // longitud de la ruta
        
        // arreglo para almacenar los tramos
        int[][] tramos = new int[n][2];
        
        // leer los tramos
        for (int i = 0; i < n; i++) {
            tramos[i][0] = scanner.nextInt(); // posición del tramo
            tramos[i][1] = scanner.nextInt(); // longitud del tramo
        }
        
        // ordenar los tramos por posición en orden ascendente
        Arrays.sort(tramos, Comparator.comparingInt(t -> t[0]));
        
        // verificar si hay una parte de la ruta que no se puede recorrer
        if (tramos[0][0] > 0) {
            System.out.println(-1);
            return;
        }
        
        // recorrer la ruta y tomar los tramos más largos
        int pos = 0;
        int max = 0;
        int count = 0;
        while (pos <= l) {
            int maxActual = 0;
            for (int i = 0; i < n; i++) {
                if (tramos[i][0] <= pos && tramos[i][0] + tramos[i][1] > pos) {
                    int longitudRecorrer = tramos[i][0] + tramos[i][1] - pos;
                    maxActual = Math.max(maxActual, longitudRecorrer);
                }
            }
            if (maxActual == 0) {
                System.out.println(-1);
                return;
            }
            System.out.printf("pos = %d, maxActual = %d, count = %d\n", pos, maxActual, count);
            pos += maxActual;
            count++;
        }
        
        System.out.println(count);
    }
}

