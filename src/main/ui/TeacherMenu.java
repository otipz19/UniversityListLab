package main.ui;

import DataInputUtil.main.ConsoleDataReader;
import main.model.entities.Cathedra;
import main.model.entities.Teacher;
import main.model.valueObjects.PersonName;

public class TeacherMenu extends Menu{
    private Cathedra cathedra;
    private Teacher teacher;

    public TeacherMenu(Cathedra cathedra, Teacher teacher) {
        this.cathedra = cathedra;
        this.teacher = teacher;
    }

    public void start() {
        while (true) {
            System.out.println("1. Edit teacher first name");
            System.out.println("2. Edit teacher middle name");
            System.out.println("3. Edit teacher last name");
            System.out.println("4. Go back to Cathedra");
            Integer choice = ConsoleDataReader.getInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    editTeacherFirstName();
                    break;
                case 2:
                    editTeacherMiddleName();
                    break;
                case 3:
                    editTeacherLastName();
                    break;
                case 4:
                    return;  // Return to Cathedra layer
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void editTeacherFirstName() {
        System.out.println("Enter new first name for the teacher:");
        PersonName firstName = new PersonName(ConsoleDataReader.getLine());
        teacher.setFirstName(firstName);
        System.out.println("Teacher first name updated");
    }

    private void editTeacherMiddleName() {
        System.out.println("Enter new middle name for the teacher:");
        PersonName middleName = new PersonName(ConsoleDataReader.getLine());
        teacher.setMiddleName(middleName);
        System.out.println("Teacher middle name updated");
    }

    private void editTeacherLastName() {
        System.out.println("Enter new last name for the teacher:");
        PersonName lastName = new PersonName(ConsoleDataReader.getLine());
        teacher.setLastName(lastName);
        System.out.println("Teacher last name updated");
    }
}