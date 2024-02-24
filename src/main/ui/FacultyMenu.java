package main.ui;

import DataInputUtil.main.*;
import main.model.entities.*;
import main.model.utils.list.IMyList;
import main.model.valueObjects.OrganizationName;

public class FacultyMenu extends RepositoryMenu {
    private Faculty faculty;

    public FacultyMenu(Faculty faculty) {
        super(faculty);
        this.faculty = faculty;

    }

    public void start() {
        new OptionsReader(
                new Option("Show cathedras", this::showCathedras),
                new Option("Add cathedra", this::createCathedra),
                new Option("Rename faculty", this::renameFaculty),
                new StopOption("Delete faculty", this::deleteFaculty),
                new Option("Show students", this::showStudents),
                new Option("Look for student by name", this::lookForStudentByName),
                new Option("Show teachers", this::showTeachers),
                new Option("Go to cathedras", this::runCathedraMenu),
                new StopOption("Go back to University")
        ).readUntilStop();
    }

    private void showCathedras() {
        IMyList<Cathedra> cathedras = faculty.getCathedras();
        if (cathedras.count() == 0) {
            System.out.println("No cathedras available.");
            return;
        }

        printEntities("Cathedras:", cathedras);
    }

    private void createCathedra() {
        OrganizationName name = readOrganizationName("Enter cathedra name: ");
        Cathedra cathedra = new Cathedra(name);
        faculty.addCathedra(cathedra);
        System.out.println("Cathedra added");
    }

    private void showTeachers() {
        IMyList<Teacher> teachers = faculty.getTeachers();
        printEntities("Teachers:", teachers);
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

        printEntities("Select a cathedra:", cathedras);

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