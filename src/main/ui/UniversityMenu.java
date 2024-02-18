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

public class UniversityMenu {

    private University university;

    public UniversityMenu(University university) {
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
                    university.getFaculties();
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
        // Create a new instance of StudentSearchFilterBuilder
        StudentSearchFilterBuilder builder = new StudentSearchFilterBuilder();

        // Get the user's choice for the filter type
        int filterChoice = ConsoleDataReader.getInt("1 - filter by course, 2 - filter by group : ");

        switch (filterChoice) {
            case 1:
                // Ask for the course name
                int courseName = ConsoleDataReader.getInt("Enter course name: ");
                // Create a new Course object
                Course course = new Course(courseName);
                // Add the course filter to the builder
                builder.addCourse(course);
                break;
            case 2:
                // Ask for the group name
                int groupName = ConsoleDataReader.getInt("Enter group name: ");
                // Create a new Group object
                Group group = new Group(groupName);
                // Add the group filter to the builder
                builder.addGroup(group);
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        // Build the filter
        StudentSearchFilter filter = builder.build();

        // Get the filtered list of students from the university
        IMyList<Student> students = university.getStudents(filter);

        // Print the students
        System.out.println("Students found: ");
        for(int i = 0; i < students.count(); i++){
            System.out.println(i + 1 + ". " + students.getAt(i));
        }
    }

    private void showStudentsWithoutFilter() {
        university.getStudents();
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
}
