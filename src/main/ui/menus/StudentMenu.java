package main.ui.menus;

import DataInputUtil.main.ConsoleDataReader;
import DataInputUtil.main.Option;
import DataInputUtil.main.OptionsReader;
import DataInputUtil.main.StopOption;
import main.model.entities.Cathedra;
import main.model.entities.Student;
import main.model.valueObjects.Course;
import main.model.valueObjects.Group;
import main.model.valueObjects.PersonName;
import main.ui.readers.ValueObjectReader;

public class StudentMenu {
    private final Student student;

    public StudentMenu(Student student) {
        this.student = student;
    }

    public void start() {
        new OptionsReader(
                System.out::println,
                new Option("Edit student first name", this::editStudentFirstName),
                new Option("Edit student middle name", this::editStudentMiddleName),
                new Option("Edit student last name", this::editStudentLastName),
                new Option("Edit student course", this::editStudentCourse),
                new Option("Edit student group", this::editStudentGroup),
                new StopOption("Delete this student", this::delete),
                new StopOption("Go back")
        ).readUntilStop("\nYou're at " + student.toString().toUpperCase() + " student level\n");
    }

    private void editStudentFirstName() {
        PersonName firstName = ValueObjectReader.readPersonName("Enter new first name for the student: ");
        student.setFirstName(firstName);
        System.out.println("\nStudent first name updated\n");
    }

    private void editStudentMiddleName() {
        PersonName middleName = ValueObjectReader.readPersonName("Enter new middle name for the student: ");
        student.setMiddleName(middleName);
        System.out.println("\nStudent middle name updated\n");
    }

    private void editStudentLastName() {
        PersonName lastName = ValueObjectReader.readPersonName("Enter new last name for the student: ");
        student.setLastName(lastName);
        System.out.println("\nStudent last name updated\n");
    }

    private void editStudentCourse() {
        Course course = ValueObjectReader.readCourse("Enter new course for the student: ");
        student.setCourse(course);
        System.out.println("\nStudent course updated\n");
    }

    private void editStudentGroup() {
        Group group = ValueObjectReader.readGroup("Enter new group for the student: ");
        student.setGroup(group);
        System.out.println("\nStudent group updated\n");
    }

    private void delete(){
        student.getCathedra().removeStudent(student);
        System.out.println("\nStudent " + student + " deleted\n");
    }
}