package main.java.es.unex.cum.ada.practica3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class JuanCarlos {

    public static void main(String[] args) throws IOException {

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(reader);

        String[] NL = input.readLine().split(" ");

        int n = Integer.parseInt(NL[0]);
        int l = Integer.parseInt(NL[1]);

        ArrayList<int[]> posTam = new ArrayList<int[]>();
        for (int i = 0; i < n; i++) {
            int[] v = new int[2];
            String[] PT = input.readLine().split(" ");
            for (int j = 0; j < 2; j++) {
                v[j] = Integer.parseInt(PT[j]);
            }
            posTam.add(v);
        }

        Collections.sort(posTam, (a, b) -> Integer.compare(b[1], a[1])); // ordeno la lista del tramo mas largo al mas
                                                                         // corto

        System.out.println(RutasStrava(n, l, posTam));

    }

    public static int RutasStrava(int n, int l, ArrayList<int[]> posTam) {
        int TotalRutas = 0;
        int i = 0, longitud = l;
        boolean vale = true;

        int[] inicio = new int[] { 0, 0 }; // declaro un vector inicio = 0 para saber si hay algun tramo que cominece al
                                           // principio del camino, pues si no hay no se puede realizar la ruta

        while (longitud > 0 && vale == true) { // mientras no se reccorra todo el camino o se cerciore que no hay
                                               // cominezo ni fin se realiza el bucle

            for (i = 0; i < n; i++) { // Utilizo un for para comprobar todos los tramos de la lista he ir
                                      // seleccionandoo descartando
                vale = false;
                int[] resultado = posTam.get(i);
                if (resultado[0] - resultado[1] / 2 <= inicio[0] + (inicio[1] / 2) && resultado[0] > inicio[0]) { // para
                                                                                                                  // que
                                                                                                                  // los
                                                                                                                  // tramos
                                                                                                                  // se
                                                                                                                  // puedan
                                                                                                                  // seleccionar
                                                                                                                  // deben
                                                                                                                  // ser
                                                                                                                  // contiguos
                    vale = true;
                }
                if (vale) { // si son contiguos se selecciona el tramo si no lo son se descarta
                    longitud -= resultado[1];
                    TotalRutas++;
                    inicio = resultado;
                }
                if (longitud <= 0)
                    vale = false;

            }
        }
        if (longitud > 0) { // sino no se a completado la ruta se devuelve -1
            return -1;
        }
        return TotalRutas; // si se ha completado la ruta se devuelve el numero de tramos que se han
                           // recorrido
    }
}