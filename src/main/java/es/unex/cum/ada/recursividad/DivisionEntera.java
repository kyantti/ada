package main.java.es.unex.cum.ada.recursividad;
import java.util.Scanner;

public class DivisionEntera {
    public static int division(int dividendo, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("El divisor no puede ser 0");
        }
        if (dividendo < divisor) {
            return 0;
        } else {
            return 1 + division(dividendo - divisor, divisor);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dividendo = scanner.nextInt();
        int divisor = scanner.nextInt();
        scanner.close();
        System.out.println(division(dividendo, divisor)); 
    }
}
