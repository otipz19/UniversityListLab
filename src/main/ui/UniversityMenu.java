package main.ui;

import DataInputUtil.main.*;
import main.model.entities.Faculty;
import main.model.entities.University;
import main.model.utils.list.IMyList;
import main.model.valueObjects.OrganizationAbbreviation;
import main.model.valueObjects.OrganizationName;

public class UniversityMenu extends RepositoryMenu {
    private University university;

    public UniversityMenu(University university) {
        super(university);
        this.university = university;
    }

    public void start() {
        new OptionsReader(
                new Option("Show faculties", this::showFaculties),
                new Option("Add faculty", this::createFaculty),
                new Option("Show students", this::showStudents),
                new Option("Look for student by name", this::lookForStudentByName),
                new Option("Go to faculties", this::runFacultyMenu),
                new StopOption("Exit")
        ).readUntilStop();
    }

    private void createFaculty() {
        OrganizationName name = readOrganizationName("Enter faculty name: ");
        OrganizationAbbreviation abbreviation = readOrganizationAbbreviation("Enter faculty abbreviation: ");
        Faculty faculty = new Faculty(name, abbreviation);
        university.addFaculty(faculty);
        System.out.println("Faculty added");
    }

    private void runFacultyMenu() {
        IMyList<Faculty> faculties = university.getFaculties();
        if (faculties.count() == 0) {
            System.out.println("No faculties available.");
            return;
        }

        printEntities("Select a faculty: ", faculties);
        int facultyIndex = ConsoleDataReader.getInt("Enter your choice: ") - 1;
        if (facultyIndex < 0 || facultyIndex >= faculties.count()) {
            System.out.println("Invalid choice");
            return;
        }

        Faculty selectedFaculty = faculties.getAt(facultyIndex);
        FacultyMenu facultyMenu = new FacultyMenu(selectedFaculty);
        facultyMenu.start();
    }
    private void showFaculties() {
        IMyList<Faculty> faculties = university.getFaculties();
        if (faculties.count() == 0) {
            System.out.println("No faculties available.");
        } else {
            printEntities("Faculties found:", faculties);
            System.out.println("\n");
        }
    }
}
