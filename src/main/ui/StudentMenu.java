package main.ui;

import DataInputUtil.main.ConsoleDataReader;
import main.model.entities.Cathedra;
import main.model.entities.Student;
import main.model.valueObjects.Course;
import main.model.valueObjects.Group;
import main.model.valueObjects.PersonName;

public class StudentMenu extends Menu{
    private Cathedra cathedra;
    private Student student;

    public StudentMenu(Cathedra cathedra, Student student) {
        this.cathedra = cathedra;
        this.student = student;
    }

    public void start() {
        while (true) {
            System.out.println("1. Edit student first name");
            System.out.println("2. Edit student middle name");
            System.out.println("3. Edit student last name");
            System.out.println("4. Edit student course");
            System.out.println("5. Edit student group");
            System.out.println("6. Go back to Cathedra");
            Integer choice = ConsoleDataReader.getInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    editStudentFirstName();
                    break;
                case 2:
                    editStudentMiddleName();
                    break;
                case 3:
                    editStudentLastName();
                    break;
                case 4:
                    editStudentCourse();
                    break;
                case 5:
                    editStudentGroup();
                    break;
                case 6:
                    return;  // Return to Cathedra layer
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void editStudentFirstName() {
        System.out.println("Enter new first name for the student:");
        PersonName firstName = new PersonName(ConsoleDataReader.getLine());
        student.setFirstName(firstName);
        System.out.println("Student first name updated");
    }

    private void editStudentMiddleName() {
        System.out.println("Enter new middle name for the student:");
        PersonName middleName = new PersonName(ConsoleDataReader.getLine());
        student.setMiddleName(middleName);
        System.out.println("Student middle name updated");
    }

    private void editStudentLastName() {
        System.out.println("Enter new last name for the student:");
        PersonName lastName = new PersonName(ConsoleDataReader.getLine());
        student.setLastName(lastName);
        System.out.println("Student last name updated");
    }

    private void editStudentCourse() {
        System.out.println("Enter new course for the student:");
        Course course = new Course(ConsoleDataReader.getInt());
        student.setCourse(course);
        System.out.println("Student course updated");
    }

    private void editStudentGroup() {
        System.out.println("Enter new group for the student:");
        Group group = new Group(ConsoleDataReader.getInt());
        student.setGroup(group);
        System.out.println("Student group updated");
    }
}