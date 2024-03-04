/**
 * This class is used to represent the main class.
 *
 * Author 1 : Tkachenko Oleksandr
 * Author 2: Bublyk Svitlana
 */
package main;

import main.initialization.StudentsGenerator;
import main.initialization.UniversityInitializer;
import main.model.entities.Cathedra;
import main.model.entities.Faculty;
import main.model.entities.Student;
import main.model.entities.University;
import main.model.utils.list.IMyList;
import main.model.valueObjects.OrganizationAbbreviation;
import main.model.valueObjects.OrganizationName;
import main.ui.menus.UniversityMenu;

public class Main {
    private static final University university = new University();
    /**
     * This method is used to initialize the university.
     */
    public static void main(String[] args) {
        new UniversityInitializer(university).initialize();
        System.out.println("Welcome to Kyiv-Mohyla Academy");
        run();
    }
    /**
     * This method is used to run the university.
     */
    private static void run() {
        UniversityMenu universityMenu = new UniversityMenu(university);
        universityMenu.start();
    }
}