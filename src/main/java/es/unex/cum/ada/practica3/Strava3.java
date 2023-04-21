package main.java.es.unex.cum.ada.practica3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Strava3 {
    private static class Section implements Comparable<Section> {

        int position;
        int length;
        int startPoint;
        int endPoint;

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


        @Override
        public int compareTo(Section section) {
            return Integer.compare(this.startPoint, section.startPoint);
        }

        @Override
        public String toString() {
            return "Section [position=" + position + ", length=" + length + ", startPoint=" + startPoint + ", endPoint="
                    + endPoint + "]";
        }

        public boolean coversStartPoint(){
            boolean coversStartPoint = false;
            if (getStartPoint() <= 0) {
                coversStartPoint = true; 
            }
            return coversStartPoint;
        }
    
        public boolean coversEndPoint(int endPoint){
            boolean coversEndPoint = false;
            if (getEndPoint() >= endPoint ) {
                coversEndPoint = true; 
            }
            return coversEndPoint;
        }

    }

    private static List<Section> sections = new ArrayList<>();

   


    public static int minSectionsRequired(List<Section> sections, int routeLength) {
        int currentPos = 0;
        
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