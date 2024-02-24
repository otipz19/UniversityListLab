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
    private Cathedra cathedra;
    private Student student;

    public StudentMenu(Cathedra cathedra, Student student) {
        this.cathedra = cathedra;
        this.student = student;
    }

    public void start() {
        new OptionsReader(
                new Option("Edit student first name", this::editStudentFirstName),
                new Option("Edit student middle name", this::editStudentMiddleName),
                new Option("Edit student las name", this::editStudentLastName),
                new Option("Edit student course", this::editStudentCourse),
                new Option("Edit student group", this::editStudentGroup),
                new StopOption("Go back to cathedra")
        ).readUntilStop();
    }

    private void editStudentFirstName() {
        PersonName firstName = ValueObjectReader.readPersonName("Enter new first name for the student:");
        student.setFirstName(firstName);
        System.out.println("Student first name updated");
    }

    private void editStudentMiddleName() {
        PersonName middleName = ValueObjectReader.readPersonName("Enter new middle name for the student:");
        student.setMiddleName(middleName);
        System.out.println("Student middle name updated");
    }

    private void editStudentLastName() {
        PersonName lastName = ValueObjectReader.readPersonName("Enter new last name for the student:");
        student.setLastName(lastName);
        System.out.println("Student last name updated");
    }

    private void editStudentCourse() {
        Course course = ValueObjectReader.readCourse("Enter new course for the student:");
        student.setCourse(course);
        System.out.println("Student course updated");
    }

    private void editStudentGroup() {
        Group group = ValueObjectReader.readGroup("Enter new group for the student:");
        student.setGroup(group);
        System.out.println("Student group updated");
    }
}