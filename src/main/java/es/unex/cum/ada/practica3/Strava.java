package main.java.es.unex.cum.ada.practica3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Strava {

    private static class Section implements Comparable<Section>{
    
        int position;
        int length;

        public Section(int position, int length) {
            this.position = position;
            this.length = length;
        }

        public int getPosition() {
            return position;
        }
        
        public int getLength() {
            return length;
        }

        @Override
        public int compareTo(Section o) {
            return Integer.compare(this.position, o.getPosition());
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Section)) {
                return false;
            }
            Section other = (Section) obj;
            return this.position == other.getPosition() && this.length == other.getLength();
        }
        @Override
        public String toString() {
            return "Section [position=" + position + ", length=" + length + "]";
        }
    }

    private static List <Section> sections = new ArrayList<>();

    private static void minSectionsRequired(List <Section> lowerHalf, List <Section> higherHalf){
        for (int i = 0; i < lowerHalf.size(); i++) {
            Section section = lowerHalf.get(i);
            if (section.getPosition() - (section.getLength() / 2) > 0) {
                lowerHalf.remove(i);
                i--; // actualizar el índice para compensar la eliminación
            }
        }
    
        for (int i = 0; i < higherHalf.size(); i++) {
            Section section = higherHalf.get(i);
            if (section.getPosition() + (section.getLength() / 2) < 40) {
                higherHalf.remove(i);
                i--; // actualizar el índice para compensar la eliminación
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numOfSections = scanner.nextInt(); 
        int routeLenght = scanner.nextInt(); 
        
        
        for (int i = 0; i < numOfSections; i++) {
            sections.add(new Section(scanner.nextInt(),scanner.nextInt()));
        }

        scanner.close();

        Collections.sort(sections);

        List<Section> lowerHalf = new ArrayList<>(sections.subList(0, sections.size() / 2));
        List<Section> higherHalf = new ArrayList<>(sections.subList(sections.size() / 2, sections.size()));

        minSectionsRequired(lowerHalf, higherHalf);

        

        for (Section section : lowerHalf) {
            System.out.println(section.toString());
        }

        for (Section section : higherHalf) {
            System.out.println(section.toString());
        }
        
        

    }
}
