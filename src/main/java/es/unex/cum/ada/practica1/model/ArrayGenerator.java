package main.java.es.unex.cum.ada.practica1.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;

public class ArrayGenerator {

    private Random random;
    private int[] array;

    public ArrayGenerator(){
        random = new Random();
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int[] generateBestCase(int size) {
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i+1;
        }
        return array;
    }
    
    public int[] generateWorstCase(int size) {
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size-i;
        }
        return array;
    }
    
    public int[] generateAverageCase(int size) {
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(0, size);
        }
        return array;
    }

    public void makeFile(int[] sizes) throws FileNotFoundException{
        // Crear el archivo de texto donde se guardará la salida
        File file = new File("salida.txt");
        PrintStream ps = new PrintStream(file);
        
        // Redirigir la salida de la consola al archivo de texto
        System.setOut(ps);
        
        for (int size : sizes) {
            
            int[] bestCase = generateBestCase(size);
            System.out.println("Array de " + size + " elementos en el mejor caso: " + Arrays.toString(bestCase));
            
            int[] worstCase = generateWorstCase(size);
            System.out.println("Array de " + size + " elementos en el peor caso: " + Arrays.toString(worstCase));
            
            int[] averageCase = generateAverageCase(size);
            System.out.println("Array de " + size + " elementos en el caso promedio: " + Arrays.toString(averageCase));
            
        }
        // Cerrar el objeto PrintStream para liberar recursos
        ps.close();
    }
}
