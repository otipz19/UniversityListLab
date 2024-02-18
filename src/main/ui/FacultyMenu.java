package main.ui;

import DataInputUtil.main.ConsoleDataReader;
import main.model.entities.Cathedra;
import main.model.entities.Faculty;
import main.model.entities.Student;
import main.model.entities.University;
import main.model.exceptions.validation.ValidationException;
import main.model.utils.filtering.StudentSearchFilter;
import main.model.utils.filtering.StudentSearchFilterBuilder;
import main.model.utils.list.IMyList;
import main.model.valueObjects.OrganizationName;

public class FacultyMenu {
    private University university;
    private Faculty faculty;

    public FacultyMenu(Faculty faculty) {
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
            System.out.println("7. Go to Cathedras");
            System.out.println("7. Go back to University");
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
                    runCathedraMenu();
                    break;
                case 8:
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
        OrganizationName name = readOrganizationName();
        Cathedra cathedra = new Cathedra(name);
        faculty.addCathedra(cathedra);
        System.out.println("Cathedra added");
    }


    private OrganizationName readOrganizationName() {
        while (true) {
            String name = ConsoleDataReader.getLine("Enter cathedra name: ");
            try {
                return new OrganizationName(name);
            } catch (ValidationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void renameFaculty() {
        System.out.println("Enter new faculty name:");
        OrganizationName newName = readOrganizationName();
        faculty.setName(newName);
        System.out.println("Faculty renamed");
    }

    private void deleteFaculty() {
        // Assuming University class has a removeFaculty method
        university.removeFaculty(faculty);
        System.out.println("Faculty deleted");
    }

    private void showStudents() {
        IMyList<Student> students = faculty.getStudents();
        System.out.println("Students:");
        for (int i = 0; i < students.count(); i++) {
            System.out.println((i + 1) + ". " + students.getAt(i));
        }
    }

    private void lookForStudentByName() {
        StudentSearchFilterBuilder builder = new StudentSearchFilterBuilder();
        String term = ConsoleDataReader.getLine("Enter search term: ");
        builder.addSearchTerm(term);
        StudentSearchFilter filter = builder.build();
        IMyList<Student> students = faculty.getStudents(filter);
        System.out.println("Students found: ");
        for(int i = 0; i < students.count(); i++){
            System.out.println(i + 1 + ". " + students.getAt(i));
        }
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