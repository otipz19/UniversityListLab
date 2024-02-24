package main.ui;

import DataInputUtil.main.ConsoleDataReader;
import main.model.entities.*;
import main.model.exceptions.validation.ValidationException;
import main.model.utils.filtering.StudentSearchFilter;
import main.model.utils.filtering.StudentSearchFilterBuilder;
import main.model.utils.list.IMyList;
import main.model.valueObjects.OrganizationName;

public class FacultyMenu extends Menu{
    private Faculty faculty;

    public FacultyMenu(Faculty faculty) {
        super(faculty);
        this.faculty = faculty;

    }
    public void start() {
        while (true) {
            System.out.println("1. Show cathedras");
            System.out.println("2. Add cathedra");
            System.out.println("3. Rename faculty");
            System.out.println("4. Delete faculty");
            System.out.println("5. Show students");
            System.out.println("6. Look for student by name");
            System.out.println("7. Show teachers");
            System.out.println("8. Go to Cathedras");
            System.out.println("9. Go back to University");
            Integer choice = ConsoleDataReader.getInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    showCathedras();
                    break;
                case 2:
                    createCathedra();
                    break;
                case 3:
                    renameFaculty();
                    break;
                case 4:
                    deleteFaculty();
                    return;  // Return to University layer after deleting
                case 5:
                    showStudents();
                    break;
                case 6:
                    lookForStudentByName();
                    break;
                case 7:
                    showTeachers();
                    break;
                case 8:
                    runCathedraMenu();
                    break;
                case 9:
                    return;  // Return to University layer
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void showCathedras() {
        IMyList<Cathedra> cathedras = faculty.getCathedras();
        if (cathedras.count() == 0) {
            System.out.println("No cathedras available.");
            return;
        }

        System.out.println("Cathedras:");
        for (int i = 0; i < cathedras.count(); i++) {
            System.out.println((i + 1) + ". " + cathedras.getAt(i).getName());
        }
    }

    private void createCathedra() {
        OrganizationName name = readOrganizationName("Enter cathedra name: ");
        Cathedra cathedra = new Cathedra(name);
        faculty.addCathedra(cathedra);
        System.out.println("Cathedra added");
    }

    private void showTeachers() {
        IMyList<Teacher> teachers = faculty.getTeachers();
        System.out.println("Teachers:");
        for (int i = 0; i < teachers.count(); i++) {
            System.out.println((i + 1) + ". " + teachers.getAt(i));
        }
    }

    private void renameFaculty() {
        OrganizationName newName = readOrganizationName("Enter new faculty name:");
        faculty.setName(newName);
        System.out.println("Faculty renamed");
    }

    private void deleteFaculty() {
        faculty.getUniversity().removeFaculty(faculty);
        System.out.println("Faculty deleted");
    }

    private void runCathedraMenu() {
        IMyList<Cathedra> cathedras = faculty.getCathedras();
        if (cathedras.count() == 0) {
            System.out.println("No cathedras available.");
            return;
        }

        System.out.println("Select a cathedra:");
        for (int i = 0; i < cathedras.count(); i++) {
            System.out.println((i + 1) + ". " + cathedras.getAt(i).getName());
        }

        int cathedraIndex = ConsoleDataReader.getInt("Enter your choice: ") - 1;
        if (cathedraIndex < 0 || cathedraIndex >= cathedras.count()) {
            System.out.println("Invalid choice");
            return;
        }

        Cathedra selectedCathedra = cathedras.getAt(cathedraIndex);
        CathedraMenu cathedraMenu = new CathedraMenu(selectedCathedra);
        cathedraMenu.start();
    }
}