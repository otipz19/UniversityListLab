package main.ui.menus.base;

import DataInputUtil.main.ConsoleDataReader;
import DataInputUtil.main.ConsoleUtils;
import DataInputUtil.main.Option;
import main.model.entities.*;
import main.model.utils.filtering.*;
import main.model.utils.list.IMyList;
import main.model.utils.pagination.Paginator;
import main.model.valueObjects.*;

public abstract class RepositoryMenu {
    private IRepositoryEntity repository;

    public RepositoryMenu(IRepositoryEntity repository){
        this.repository = repository;
    }

    protected void showStudents() {
        ConsoleUtils.readOptions(
                new Option("Show students with filter", this::showStudentsWithFilter),
                new Option("Show students without filter", this::showStudentsWithoutFilter),
                new Option("Look for student by name", this::lookForStudentByName)
        );
    }

    //TODO: Choice of filtering have to be done more agile,
    //TODO: so user can filter by group AND by course
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
        printEntities("Students found: ", students);
    }

    protected void showStudentsWithoutFilter() {
        printEntities("Students found: ", repository.getStudents());
    }

    /*Look for student by name*/
    protected void lookForStudentByName() {
        StudentSearchFilterBuilder builder = new StudentSearchFilterBuilder();
        String term = ConsoleDataReader.getLine("Enter search term: ");
        builder.addSearchTerm(term);
        StudentSearchFilter filter = builder.build();
        IMyList<Student> students = repository.getStudents(filter);
        printEntities("Students found: ", students);
    }

    //TODO: Here have to be pagination implemented.
    protected static <T> void printEntities(String header, IMyList<T> entities) {
        System.out.println(header);
        Paginator<T> paginator = new Paginator<>(5, entities);
        System.out.println("Pages: " + paginator.getTotalPages());
        while(paginator.hasNextPage()){
            IMyList<T> page = paginator.getNextPage();
            System.out.println("Page#" + paginator.getCurPage() + "\n");
            for(int i = 0; i < page.count(); i++){
                int index = ((paginator.getCurPage() - 1) * paginator.getPageSize() + (i + 1));
                System.out.println(index + ". " + page.getAt(i));
            }
            if(paginator.hasNextPage()){
                String input = ConsoleDataReader.getLine("Input anything to get next page, or 'stop' to stop");
                if(input.equals("stop")){
                    break;
                }
            }
        }
    }
}
