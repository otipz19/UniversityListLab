package main.ui;

import DataInputUtil.main.ConsoleDataReader;
import DataInputUtil.main.Option;
import DataInputUtil.main.OptionsReader;
import DataInputUtil.main.StopOption;
import main.model.entities.Cathedra;
import main.model.entities.Teacher;
import main.model.valueObjects.PersonName;

public class TeacherMenu {
    private Cathedra cathedra;
    private Teacher teacher;

    public TeacherMenu(Cathedra cathedra, Teacher teacher) {
        this.cathedra = cathedra;
        this.teacher = teacher;
    }

    public void start() {
        new OptionsReader(
                new Option("Edit teacher first name", this::editTeacherFirstName),
                new Option("Edit teacher middle name", this::editTeacherMiddleName),
                new Option("Edit teacher last name", this::editTeacherLastName),
                new StopOption("Go back to Cathedra")
        ).readUntilStop();
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