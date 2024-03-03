package main.ui.menus;

import DataInputUtil.main.ConsoleDataReader;
import DataInputUtil.main.Option;
import DataInputUtil.main.OptionsReader;
import DataInputUtil.main.StopOption;
import main.model.entities.Cathedra;
import main.model.entities.Student;
import main.model.entities.Teacher;
import main.model.utils.list.IMyList;
import main.model.valueObjects.Course;
import main.model.valueObjects.Group;
import main.model.valueObjects.OrganizationName;
import main.model.valueObjects.PersonName;
import main.ui.menus.base.RepositoryMenu;
import main.ui.readers.ValueObjectReader;


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
        printEntities("Teachers:", teachers);
    }

    private void renameCathedra() {
        OrganizationName newName = ValueObjectReader.readOrganizationName("Enter new cathedra name:");
        cathedra.setName(newName);
        System.out.println("Cathedra renamed");
    }

    private void deleteCathedra() {
        cathedra.getFaculty().removeCathedra(cathedra);
        System.out.println("Cathedra deleted");
    }

    //TODO: This is not safe method. Should show variants to choose from and validate inputted index,
    //TODO: as it made with faculties and cathedras
    private void goToStudentLayer() {
        System.out.println("Enter the index of the student you want to edit:");
        int index = ConsoleDataReader.getInt();
        Student student = cathedra.getStudents().getAt(index);
        StudentMenu studentMenu = new StudentMenu(student);
        studentMenu.start();
    }

    //TODO: The same problem as with the method above
    private void goToTeacherLayer() {
        System.out.println("Enter the index of the teacher you want to edit:");
        int index = ConsoleDataReader.getInt();
        Teacher teacher = cathedra.getTeachers().getAt(index);
        TeacherMenu teacherMenu = new TeacherMenu(teacher);
        teacherMenu.start();
    }

    private void createStudent() {
        PersonName firstName = ValueObjectReader.readPersonName("Enter student first name:");
        PersonName middleName = ValueObjectReader.readPersonName("Enter student middle name:");
        PersonName lastName = ValueObjectReader.readPersonName("Enter student last name:");
        Group group = ValueObjectReader.readGroup("Enter student group:");
        Course course = ValueObjectReader.readCourse("Enter student course:");
        Student student = new Student(firstName, middleName, lastName, group, course);
        cathedra.addStudent(student);
        System.out.println("Student created");
    }

    private void createTeacher() {
        PersonName firstName = ValueObjectReader.readPersonName("Enter teacher first name:");
        PersonName middleName = ValueObjectReader.readPersonName("Enter teacher middle name:");
        PersonName lastName = ValueObjectReader.readPersonName("Enter teacher last name:");
        Teacher teacher = new Teacher(firstName, middleName, lastName);
        cathedra.addTeacher(teacher);
        System.out.println("Teacher created");
    }
}
