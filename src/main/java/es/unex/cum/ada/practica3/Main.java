package main.java.es.unex.cum.ada.practica3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static class Section implements Comparable<Section> {

        int middlePoint;
        int length;
        boolean valid;

        public Section(int middlePoint, int length) {
            this.middlePoint = middlePoint;
            this.length = length;
        }

        public int getMiddlePoint() {
            return middlePoint;
        }

        public int getLength() {
            return length;
        }

        public void setValid(boolean valid) {
            this.valid = valid;
        }

        @Override
        public int compareTo(Section section) {
            return Integer.compare(section.length, this.length);
        }

        public boolean intersects(Section section) {
            int halfLength = length / 2;
            int otherHalfLength = section.getLength() / 2;
    
           
            int start = middlePoint - halfLength;
            int end = middlePoint + halfLength;
    
          
            int otherStart = section.middlePoint - otherHalfLength;
            int otherEnd = section.middlePoint + otherHalfLength;
    
            return (start <= otherEnd && otherStart <= end);
        }

        @Override
        public String toString() {
            return "Section [middlePoint=" + middlePoint + ", length=" + length + ", valid=" + valid + "]";
        }

        public boolean isValid() {
            return valid;
        }

        public boolean coversStartPoint(){
            boolean coversStartPoint = false;
            if (middlePoint - (length/2) <= 0) {
                coversStartPoint = true; 
            }
            return coversStartPoint;
        }
        
        public boolean coversEndPoint(int endPoint){
            boolean coversEndPoint = false;
            if (middlePoint + (length/2) >= endPoint ) {
                coversEndPoint = true; 
            }
            return coversEndPoint;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Section other = (Section) obj;
            if (middlePoint != other.middlePoint)
                return false;
            if (length != other.length)
                return false;
            return true;
        }

    }


    private static List<Section> sections = new ArrayList<>();
    

    public static int minSectionsRequired(List<Section> sections, int routeLength) {
        boolean startCovered = false;
        boolean endCovered = false;
        //la utilizare de auxiliar para ir viendo si los segmentos son contiguos
        Section auxSection = null;

        int numOfSections = -1;

        //compruebo si la ruta cubre al menos el principio y el final
        for (Section section : sections) {
            if (section.coversStartPoint() && !startCovered) {
                section.setValid(true);
                startCovered = true;
                auxSection = section;
            }

            if (section.coversEndPoint(routeLength) && !endCovered) {
                endCovered = true;
            }
        }
        //si no cubre el principio y el final no hay nada que hacer
        if (!startCovered || !endCovered) {
            return numOfSections;
        }
        //si el segmento del principio cubre el final solamente hay 1 segmento
        else if (auxSection.coversEndPoint(routeLength)) {
            return 1;
        }
        //si hay mas segmentos
        else{
            //tomo el del principio
            numOfSections = 1;
            for (Section section : sections) {
                //empiezo a comparar utilizando el segmento del principio con el mas largo (no con el mismo) 
                if (auxSection.intersects(section) && !auxSection.equals(section) ) {

                    auxSection = section;

                    numOfSections++;
                    
                    // si se tocan lo pillo y si ademas resulta que justo ese llega hasta el final devuelvo el numero de segmentos que llevo
                    if (section.coversEndPoint(routeLength)) {
                        return numOfSections;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfSections = scanner.nextInt();
        int routeLenght = scanner.nextInt();

        for (int i = 0; i < numOfSections; i++) {
            Section section = new Section(scanner.nextInt(), scanner.nextInt());
            sections.add(section);
        }

        scanner.close();

        Collections.sort(sections);

        System.out.println(minSectionsRequired(sections, routeLenght));
    }
}