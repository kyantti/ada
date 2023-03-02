package main.java.es.unex.cum.ada.practica1.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
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
            array[i] = random.nextInt() * size;
        }
        return array;
    }
    
    public void makeFile() throws FileNotFoundException{
        
        int[] sizes = {2000, 4000, 6000, 8000, 10000, 12000, 14000, 16000, 18000, 20000};
        
        // Crear el archivo de texto donde se guardará la salida
        File file = new File("salida.txt");
        PrintStream ps = new PrintStream(file);
        
        // Redirigir la salida de la consola al archivo de texto
        System.setOut(ps);
        
        for (int size : sizes) {
            
            int[] bestCase = generateBestCase(size);
            System.out.println("Array de " + size + " elementos en el mejor caso: " + bestCase.toString());
            
            int[] worstCase = generateWorstCase(size);
            System.out.println("Array de " + size + " elementos en el peor caso: " + worstCase.toString());
            
            int[] averageCase = generateAverageCase(size);
            System.out.println("Array de " + size + " elementos en el caso promedio: " + averageCase.toString());
            
        }
        
        // Cerrar el objeto PrintStream para liberar recursos
        ps.close();
    }
}
