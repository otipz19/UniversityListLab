package main.ui;

import main.model.entities.University;

public class Main {
    public static void main(String[] args) {
        // Create University
        University university = new University();
        System.out.println("Welcome to Kyiv-Mohyla Academy");

        // Start UniversityMenu
        UniversityMenu universityMenu = new UniversityMenu(university);
        universityMenu.start();
    }
}