package main.ui;

import DataInputUtil.main.ConsoleDataReader;
import main.model.entities.IRepositoryEntity;
import main.model.entities.Student;
import main.model.exceptions.validation.ValidationException;
import main.model.utils.filtering.StudentSearchFilter;
import main.model.utils.filtering.StudentSearchFilterBuilder;
import main.model.utils.list.IMyList;
import main.model.valueObjects.Course;
import main.model.valueObjects.Group;
import main.model.valueObjects.OrganizationAbbreviation;
import main.model.valueObjects.OrganizationName;

public abstract class RepositoryMenu {
    private IRepositoryEntity repository;

    public RepositoryMenu(IRepositoryEntity repository){
        this.repository = repository;
    }

    protected OrganizationName readOrganizationName(String prompt) {
        while (true) {
            String name = ConsoleDataReader.getLine(prompt);
            try {
                return new OrganizationName(name);
            } catch (ValidationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    protected OrganizationAbbreviation readOrganizationAbbreviation(String prompt) {
        while (true) {
            String abbreviation = ConsoleDataReader.getLine(prompt);
            try {
                return new OrganizationAbbreviation(abbreviation);
            } catch (ValidationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /*Show students with filter, 2 - Show students without filter, 3 - " +
     *"Look for student by name*/
    protected void showStudents() {
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

    protected void showStudentsWithFilter() {
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
        IMyList<Student> students = repository.getStudents(filter);

        // Print the students
        printStudents(students);
    }

    protected void showStudentsWithoutFilter() {
        printStudents(repository.getStudents());
    }

    /*Look for student by name*/
    protected void lookForStudentByName() {
        StudentSearchFilterBuilder builder = new StudentSearchFilterBuilder();
        String term = ConsoleDataReader.getLine("Enter search term: ");
        builder.addSearchTerm(term);
        StudentSearchFilter filter = builder.build();
        IMyList<Student> students = repository.getStudents(filter);
        System.out.println("Students found: ");
        for(int i = 0; i < students.count(); i++){
            System.out.println(i + 1 + ". " + students.getAt(i));
        }
    }

    protected static void printStudents(IMyList<Student> students) {
        System.out.println("Students found: ");
        for(int i = 0; i < students.count(); i++){
            System.out.println(i + 1 + ". " + students.getAt(i));
        }
    }
}
