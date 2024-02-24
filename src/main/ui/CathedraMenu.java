package main.ui;

import DataInputUtil.main.ConsoleDataReader;
import DataInputUtil.main.Option;
import DataInputUtil.main.OptionsReader;
import DataInputUtil.main.StopOption;
import main.model.entities.Cathedra;
import main.model.entities.Student;
import main.model.entities.Teacher;
import main.model.exceptions.validation.ValidationException;
import main.model.utils.list.IMyList;
import main.model.valueObjects.Course;
import main.model.valueObjects.Group;
import main.model.valueObjects.OrganizationName;
import main.model.valueObjects.PersonName;


public class CathedraMenu extends RepositoryMenu {
    private Cathedra cathedra;

    public CathedraMenu(Cathedra cathedra) {
        super(cathedra);
        this.cathedra = cathedra;
    }

    public void start() {
        new OptionsReader(
                new Option("Show students", this::showStudents),
                new Option("Look for student by name", this::lookForStudentByName),
                new Option("Show teachers", this::showTeachers),
                new Option("Rename cathedra", this::renameCathedra),
                new StopOption("Delete cathedra", this::deleteCathedra),
                new Option("Go to students", this::goToStudentLayer),
                new Option("Go to teachers", this::goToTeacherLayer),
                new Option("Create a student", this::createStudent),
                new Option("Create a teacher", this::createTeacher),
                new StopOption("Go back to faculty")
        ).readUntilStop();
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
