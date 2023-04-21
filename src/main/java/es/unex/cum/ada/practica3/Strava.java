package main.java.es.unex.cum.ada.practica3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Strava {

    private static class Section implements Comparable<Section> {

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
        public String toString() {
            return "Section [position=" + position + ", length=" + length + "]";
        }

        
    }

    private static List<Section> sections = new ArrayList<>();

    public static int minSectionsRequired(List<Section> sections, int routeLength) {
    int currentPos = 0;
    int numSections = 0;
    int index = 0;

    while (currentPos < routeLength) {
        Section longestSection = null;
        int longestLength = 0;

        for (int i = index; i < sections.size(); i++) {
            Section section = sections.get(i);
            int startPos = section.getPosition() - (section.getLength() / 2);
            int endPos = section.getPosition() + (section.getLength() / 2);

            if (startPos <= currentPos && endPos > currentPos && endPos > longestLength) {
                longestSection = section;
                longestLength = endPos;
                index = i;
            }
        }

        if (longestSection == null) {
            return -1;
        }
        
        currentPos = longestLength;
        numSections++;
    }

    return numSections;
}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfSections = scanner.nextInt();
        int routeLenght = scanner.nextInt();

        for (int i = 0; i < numOfSections; i++) {
            sections.add(new Section(scanner.nextInt(), scanner.nextInt()));
        }

        scanner.close();

        Collections.sort(sections);

        System.out.println(minSectionsRequired(sections, routeLenght));

    }
}