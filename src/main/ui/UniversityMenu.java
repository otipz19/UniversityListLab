package main.ui;

import DataInputUtil.main.ConsoleDataReader;
import main.model.entities.Faculty;
import main.model.entities.Student;
import main.model.entities.University;
import main.model.exceptions.validation.ValidationException;
import main.model.utils.filtering.StudentSearchFilter;
import main.model.utils.filtering.StudentSearchFilterBuilder;
import main.model.utils.list.IMyList;
import main.model.utils.list.MyList;
import main.model.valueObjects.Course;
import main.model.valueObjects.Group;
import main.model.valueObjects.OrganizationAbbreviation;
import main.model.valueObjects.OrganizationName;

public class UniversityMenu extends Menu{

    private University university;

    public UniversityMenu(University university) {
        super(university);
        this.university = university;
    }

    /**
     * Interact with faculties
     */
    public void start() {
        while (true) {
            System.out.println("1. Show faculties");
            System.out.println("2. Add faculty");
            System.out.println("3. Show students");
            System.out.println("4. Look for student by name");
            System.out.println("5. Go to Faculties");
            System.out.println("6. Exit");
            Integer choice = ConsoleDataReader.getInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    showFaculties();
                    break;
                case 2:
                    createFaculty();
                    break;
                case 3:
                    showStudents();
                    break;
                case 4:
                    lookForStudentByName();
                    break;
                case 5:
                    runFacultyMenu();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
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

        System.out.println("Select a faculty:");
        for (int i = 0; i < faculties.count(); i++) {
            System.out.println((i + 1) + ". " + faculties.getAt(i).getName());
        }

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
            System.out.println("\nFaculties:");
            for (int i = 0; i < faculties.count(); i++) {
                System.out.println((i + 1) + ". " + faculties.getAt(i).getName());
            }
            System.out.println("\n");
        }
    }
}
