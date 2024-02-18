package main.ui;

import DataInputUtil.main.ConsoleDataReader;
import main.model.entities.Cathedra;
import main.model.entities.Student;
import main.model.entities.Teacher;
import main.model.exceptions.validation.ValidationException;
import main.model.utils.filtering.StudentSearchFilter;
import main.model.utils.filtering.StudentSearchFilterBuilder;
import main.model.utils.filtering.TeacherSearchFilter;
import main.model.utils.list.IMyList;
import main.model.valueObjects.OrganizationName;

public class CathedraMenu {
    private Cathedra cathedra;

    public CathedraMenu(Cathedra cathedra) {
        this.cathedra = cathedra;
    }

    public void start() {
        while (true) {
            System.out.println("1. Show students");
            System.out.println("2. Look for student by name");
            System.out.println("3. Show teachers");
            System.out.println("4. Rename cathedra");
            System.out.println("5. Delete cathedra");
            System.out.println("6. Go to Students");
            System.out.println("7. Go to Teachers");
            System.out.println("8. Go back to Faculty");
            Integer choice = ConsoleDataReader.getInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    showStudents();
                    break;
                case 2:
                    lookForStudentByName();
                    break;
                case 3:
                    showTeachers();
                    break;
                case 4:
                    renameCathedra();
                    break;
                case 5:
                    deleteCathedra();
                    return;
                case 6:
                    goToStudentLayer();
                    break;
                case 7:
                    goToTeacherLayer();
                    break;
                case 8:
                    return;  // Return to Faculty layer
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void showStudents() {
        IMyList<Student> students = cathedra.getStudents();
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
        IMyList<Student> students = cathedra.getStudents(filter);
        System.out.println("Students found: ");
        for (int i = 0; i < students.count(); i++) {
            System.out.println(i + 1 + ". " + students.getAt(i));
        }
    }

    private void showTeachers() {
        IMyList<Teacher> teachers = cathedra.getTeachers();
        System.out.println("Teachers:");
        for (int i = 0; i < teachers.count(); i++) {
            System.out.println((i + 1) + ". " + teachers.getAt(i));
        }
    }


    private void renameCathedra() {
        System.out.println("Enter new cathedra name:");
        OrganizationName newName = readOrganizationName();
        cathedra.setName(newName);
        System.out.println("Cathedra renamed");
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

    private void deleteCathedra() {
        cathedra.getFaculty().removeCathedra(cathedra);
        System.out.println("Cathedra deleted");
    }

    private void goToStudentLayer() {
        StudentMenu studentMenu = new StudentMenu(cathedra);
        studentMenu.start();
    }

    private void goToTeacherLayer() {
        TeacherMenu teacherMenu = new TeacherMenu(cathedra);
        teacherMenu.start();
    }
}