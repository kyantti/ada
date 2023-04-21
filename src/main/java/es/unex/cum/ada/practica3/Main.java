package main.java.es.unex.cum.ada.practica3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static class Section implements Comparable<Section> {

        int position;
        int length;
        int startPoint;
        int endPoint;
        boolean takeIt;

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

        public void setStartPoint(int startPoint) {
            this.startPoint = startPoint;
        }

        public void setEndPoint(int endPoint) {
            this.endPoint = endPoint;
        }

        public int getStartPoint() {
            return startPoint;
        }

        public int getEndPoint() {
            return endPoint;
        }

        public void takeIt(boolean takeIt) {
            this.takeIt = takeIt;
        }

        @Override
        public int compareTo(Section section) {
            return Integer.compare(section.length, this.length);
        }

        @Override
        public String toString() {
            return "Section [position=" + position + ", length=" + length + ", startPoint=" + startPoint + ", endPoint="
                    + endPoint + ", takeIt=" + takeIt + "]";
        }

        public boolean isTakeIt() {
            return takeIt;
        }
    }

    private static List<Section> sections = new ArrayList<>();

    public static boolean coversStartPoint(Section section){
        boolean coversStartPoint = false;
        if (section.getStartPoint() <= 0) {
            coversStartPoint = true; 
        }
        return coversStartPoint;
    }

    public static boolean coversEndPoint(Section section, int endPoint){
        boolean coversEndPoint = false;
        if (section.getEndPoint() >= endPoint ) {
            coversEndPoint = true; 
        }
        return coversEndPoint;
    }


    public static int minSectionsRequired(List<Section> sections, int routeLength) {
        boolean startCovered = false;
        boolean endCovered = false;
        int count = 0;
        //si los tramos no son iguales
        sections.get(0).takeIt(true);
        for (int i = 1; i < sections.size(); i++) {
            if (coversStartPoint(sections.get(i)) && !startCovered) {
                sections.get(i).takeIt(true);
                startCovered = true;

            }
            if (coversEndPoint(sections.get(i), routeLength) && !endCovered) {
                sections.get(i).takeIt(true);
                endCovered = true;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfSections = scanner.nextInt();
        int routeLenght = scanner.nextInt();

        for (int i = 0; i < numOfSections; i++) {
            Section section = new Section(scanner.nextInt(), scanner.nextInt());
            section.setStartPoint(section.getPosition() - (section.getLength() / 2));
            section.setEndPoint(section.getPosition() + (section.getLength() / 2));
            sections.add(section);
        }

        scanner.close();

        Collections.sort(sections);

        System.out.println(minSectionsRequired(sections, routeLenght));

    }
}