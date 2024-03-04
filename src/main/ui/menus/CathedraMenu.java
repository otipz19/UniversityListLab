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
import main.ui.readers.ValueObjectReader;
import main.ui.requests.GetStudentsRequest;
import main.ui.requests.GetTeachersRequest;
/**
 * This class is used to represent a cathedra menu.
 * It is a public class because it is used in other packages.
 */

public class CathedraMenu {
    private final Cathedra cathedra;
    /**
     * This constructor is used to create a cathedra menu.
     * @param cathedra - the cathedra
     * @return - the cathedra menu
     */
    public CathedraMenu(Cathedra cathedra) {
        this.cathedra = cathedra;
    }
    /**
     * This method is used to start the cathedra menu.
     */
    public void start() {
        new OptionsReader(
                System.out::println,
                new Option("Rename this cathedra", this::renameCathedra),
                new StopOption("Delete this cathedra", this::deleteCathedra),
                new Option("Create a student", this::createStudent),
                new Option("Create a teacher", this::createTeacher),
                new Option("Get students", () -> new GetStudentsRequest(cathedra).get()),
                new Option("Get teachers", () -> new GetTeachersRequest(cathedra).get()),
                new StopOption("Go back to faculty")
        ).readUntilStop("\nYou're at " + cathedra.toString().toUpperCase() + " cathedra level\n");
    }
    /**
     * This method is used to rename the cathedra.
     */
    private void renameCathedra() {
        OrganizationName newName = ValueObjectReader.readOrganizationName("Enter new cathedra name: ");
        cathedra.setName(newName);
        System.out.println("\nCathedra renamed to " + cathedra + "\n");
    }
    /**
     * This method is used to delete the cathedra.
     */
    private void deleteCathedra() {
        cathedra.getFaculty().removeCathedra(cathedra);
        System.out.println("\nCathedra " + cathedra + " deleted\n");
    }
    /**
     * This method is used to create a student.
     */
    private void createStudent() {
        PersonName firstName = ValueObjectReader.readPersonName("Enter student first name: ");
        PersonName middleName = ValueObjectReader.readPersonName("Enter student middle name: ");
        PersonName lastName = ValueObjectReader.readPersonName("Enter student last name: ");
        Group group = ValueObjectReader.readGroup("Enter student group: ");
        Course course = ValueObjectReader.readCourse("Enter student course: ");
        Student student = new Student(firstName, middleName, lastName, group, course);
        cathedra.addStudent(student);
        System.out.println("\nStudent " + student + " created\n");
    }
    /**
     * This method is used to create a teacher.
     */
    private void createTeacher() {
        PersonName firstName = ValueObjectReader.readPersonName("Enter teacher first name: ");
        PersonName middleName = ValueObjectReader.readPersonName("Enter teacher middle name: ");
        PersonName lastName = ValueObjectReader.readPersonName("Enter teacher last name: ");
        Teacher teacher = new Teacher(firstName, middleName, lastName);
        cathedra.addTeacher(teacher);
        System.out.println("\nTeacher " + teacher + " created\n");
    }
}
