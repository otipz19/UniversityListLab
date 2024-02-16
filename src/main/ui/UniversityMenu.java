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
import main.model.valueObjects.OrganizationAbbreviation;
import main.model.valueObjects.OrganizationName;

public class UniversityMenu {

    private University university;

    public UniversityMenu(University university) {
        this.university = university;
    }

    /**
     * Interact with faculties
     */
    public void start() {
        System.out.println("1. Show faculties");
        System.out.println("2. Add faculty");
        System.out.println("3. Show students");
        System.out.println("4. Exit");
        Integer choice = ConsoleDataReader.getInt("Enter your choice: ");
        switch (choice) {
            case 1:
                university.getFaculties();
                break;
            case 2:
                createFaculty();
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private void createFaculty() {
        OrganizationName name = rdRgnstnNm();
        OrganizationAbbreviation abbreviation = rdRgnstnAbbrvtn();
        Faculty faculty = new Faculty(name, abbreviation);
        university.addFaculty(faculty);
        System.out.println("Faculty added");
    }

    /**
     * Adds new faculty to list of faculties.
     */
    private OrganizationAbbreviation rdRgnstnAbbrvtn() {
        while (true) {
            String abbreviation = ConsoleDataReader.getLine("Enter faculty abbreviation: ");
            try {
                return new OrganizationAbbreviation(abbreviation);
            } catch (ValidationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Adds new faculty to list of faculties.
     */
    private static OrganizationName rdRgnstnNm() {
        while (true) {
            String name = ConsoleDataReader.getLine("Enter faculty name: ");
            try {
                return new OrganizationName(name);
            } catch (ValidationException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    /*Show students with filter, 2 - Show students without filter, 3 - " +
     *"Look for student by name*/
    private void showStudents() {
        System.out.println("1 - Show students with filter, 2 - Show students without filter, 3 - " +
                "Look for student by name");
        Integer choice = ConsoleDataReader.getInt("Enter your choice: ");
        if (choice == 1) {
            showStudentsWithFilter();
        } else if (choice == 2) {
            showStudentsWithoutFilter();
        } else if (choice == 3) {
            lookForStudentByName();
        } else {
            System.out.println("Invalid choice");
        }
    }
    /*Look for student by name*/
    private void lookForStudentByName() {
        StudentSearchFilterBuilder builder = new StudentSearchFilterBuilder();
        String term = ConsoleDataReader.getLine("Enter search term: ");
        builder.addSearchTerm(term);
        StudentSearchFilter filter = builder.build();
        IMyList<Student> students = university.getStudents(filter);
        System.out.println("Students found: ");
        for(int i = 0; i < students.count(); i++){
            System.out.println(i + 1 + ". " + students.getAt(i));
        }
    }

    private void showStudentsWithFilter() {
        StudentSearchFilterBuilder builder = new StudentSearchFilterBuilder();
        String filter = ConsoleDataReader.getLine("1 - filter by course, 2 - filter by group : ");


    }

    private void showStudentsWithoutFilter() {
        university.getStudents();
    }

}
