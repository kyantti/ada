package main.java.es.unex.cum.ada.recursividad;

import java.util.Scanner;

public class InvertirNumero {

    private static int invertir(int numero) {
        if (numero <= 10) {
            return numero;
        }
        System.out.println(numero%10);
        return invertir(numero/10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();
        scanner.close();
        System.out.println(invertir(numero));
    }
}
