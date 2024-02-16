package main.ui;

import main.model.entities.University;

import java.io.IOException;

public class Main {
    private static University university = new University();

    public static void main(String[] args) {
        try {
            runUniversityMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void runUniversityMenu() throws IOException {
        while (true) {
            System.out.println("1. Interact with faculties");
            System.out.println("2. Exit");
            int choice = DataInput.getInt("Enter your choice: ");

            if (choice == 1) {
                runFacultyMenu();
            } else if (choice == 2) {
                break;
            }
        }
    }

    /**
     * Interact with faculties
     */

    private static void runFacultyMenu() throws IOException {
        while (true) {
            System.out.println("1. Add faculty");
            System.out.println("2. Remove faculty");
            System.out.println("3. Rename faculty");
            System.out.println("4. Interact with cathedras");
            System.out.println("5. Go back to University menu");
            int choice = DataInput.getInt("Enter your choice: ");

            if (choice == 4) {
                runCathedraMenu();
            } else if (choice == 5) {
                break;
            }
            // Handle faculty interactions
        }
    }

    private static void runCathedraMenu()  {
        while (true) {
            System.out.println("1. Add cathedra");
            System.out.println("2. Remove cathedra");
            System.out.println("3. Rename cathedra");
            System.out.println("4. Interact with students and teachers");
            System.out.println("5. Go back to Faculty menu");
            int choice = DataInput.getInt("Enter your choice: ");

            if (choice == 4) {
                runStudentTeacherMenu();
            } else if (choice == 5) {
                break;
            }
            // Handle cathedra interactions
        }
    }

    private static void runStudentTeacherMenu()  {
        while (true) {
            System.out.println("1. Add student");
            System.out.println("2. Remove student");
            System.out.println("3. Rename student");
            System.out.println("4. Add teacher");
            System.out.println("5. Remove teacher");
            System.out.println("6. Rename teacher");
            System.out.println("7. Go back to Cathedra menu");
            int choice = DataInput.getInt("Enter your choice: ");

            if (choice == 7) {
                break;
            }
            // Handle student and teacher interactions
        }
    }
}