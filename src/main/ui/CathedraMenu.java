package main.ui;

import DataInputUtil.main.ConsoleDataReader;
import main.model.entities.Cathedra;
import main.model.entities.Student;
import main.model.entities.Teacher;
import main.model.exceptions.validation.ValidationException;
import main.model.utils.filtering.StudentSearchFilter;
import main.model.utils.filtering.StudentSearchFilterBuilder;
import main.model.utils.list.IMyList;
import main.model.valueObjects.Course;
import main.model.valueObjects.Group;
import main.model.valueObjects.OrganizationName;
import main.model.valueObjects.PersonName;


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
            System.out.println("8. Create a student");
            System.out.println("9. Create a teacher");
            System.out.println("10. Go back to Faculty");
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
                    createStudent();
                    break;
                case 9:
                    createTeacher();
                    break;
                case 10:
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
        System.out.println("Enter the index of the student you want to edit:");
        int index = ConsoleDataReader.getInt();
        Student student = cathedra.getStudents().getAt(index);
        StudentMenu studentMenu = new StudentMenu(cathedra, student);
        studentMenu.start();
    }

    private void goToTeacherLayer() {
        System.out.println("Enter the index of the teacher you want to edit:");
        int index = ConsoleDataReader.getInt();
        Teacher teacher = cathedra.getTeachers().getAt(index);
        TeacherMenu teacherMenu = new TeacherMenu(cathedra, teacher);
        teacherMenu.start();
    }

    private void createStudent() {
        System.out.println("Enter student first name:");
        String firstName = ConsoleDataReader.getLine();
        System.out.println("Enter student middle name:");
        String middleName = ConsoleDataReader.getLine();
        System.out.println("Enter student last name:");
        String lastName = ConsoleDataReader.getLine();
        System.out.println("Enter student group:");
        Group group = new Group(ConsoleDataReader.getInt());
        System.out.println("Enter student course:");
        Course course = new Course(ConsoleDataReader.getInt());
        Student student = new Student(new PersonName(firstName), new PersonName(middleName), new PersonName(lastName), group, course);
        cathedra.addStudent(student);
        System.out.println("Student created");
    }

    private void createTeacher() {
        System.out.println("Enter teacher first name:");
        String firstName = ConsoleDataReader.getLine();
        System.out.println("Enter teacher middle name:");
        String middleName = ConsoleDataReader.getLine();
        System.out.println("Enter teacher last name:");
        String lastName = ConsoleDataReader.getLine();
        Teacher teacher = new Teacher(new PersonName(firstName), new PersonName(middleName), new PersonName(lastName));
        cathedra.addTeacher(teacher);
        System.out.println("Teacher created");
    }
}
