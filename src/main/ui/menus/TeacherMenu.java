package main.ui.menus;

import DataInputUtil.main.ConsoleDataReader;
import DataInputUtil.main.Option;
import DataInputUtil.main.OptionsReader;
import DataInputUtil.main.StopOption;
import main.model.entities.Cathedra;
import main.model.entities.Teacher;
import main.model.valueObjects.PersonName;
import main.ui.readers.ValueObjectReader;

public class TeacherMenu {
    private final Teacher teacher;

    public TeacherMenu(Teacher teacher) {
        this.teacher = teacher;
    }

    public void start() {
        new OptionsReader(
                System.out::println,
                new Option("Edit teacher first name", this::editTeacherFirstName),
                new Option("Edit teacher middle name", this::editTeacherMiddleName),
                new Option("Edit teacher last name", this::editTeacherLastName),
                new StopOption("Delete this teacher", this::delete),
                new StopOption("Go back")
        ).readUntilStop("\nYou're at " + teacher.toString().toUpperCase() + " teacher level\n");
    }

    private void editTeacherFirstName() {
        PersonName firstName = ValueObjectReader.readPersonName("Enter new first name for the teacher: ");
        teacher.setFirstName(firstName);
        System.out.println("\nTeacher first name updated\n");
    }

    private void editTeacherMiddleName() {
        PersonName middleName = ValueObjectReader.readPersonName("Enter new middle name for the teacher: ");
        teacher.setMiddleName(middleName);
        System.out.println("\nTeacher middle name updated\n");
    }

    private void editTeacherLastName() {
        PersonName lastName = ValueObjectReader.readPersonName("Enter new last name for the teacher: ");
        teacher.setLastName(lastName);
        System.out.println("\nTeacher last name updated\n");
    }

    private void delete(){
        teacher.getCathedra().removeTeacher(teacher);
        System.out.println("\nTeacher " + teacher + " deleted\n");
    }
}