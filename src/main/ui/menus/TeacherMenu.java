package main.ui.menus;

import DataInputUtil.main.ConsoleDataReader;
import DataInputUtil.main.Option;
import DataInputUtil.main.OptionsReader;
import DataInputUtil.main.StopOption;
import main.model.entities.Cathedra;
import main.model.entities.Teacher;
import main.model.valueObjects.PersonName;
import main.ui.readers.ValueObjectReader;
/**
 * This class is used to represent a teacher menu.
 * It is a public class because it is used in other packages.
 */
public class TeacherMenu {
    private final Teacher teacher;
    /**
     * This constructor is used to create a teacher menu.
     * @param teacher - the teacher
     * @return - the teacher menu
     */
    public TeacherMenu(Teacher teacher) {
        this.teacher = teacher;
    }
    /**
     * This method is used to start the teacher menu.
     */
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
    /**
     * This method is used to edit the teacher first name.
     */
    private void editTeacherFirstName() {
        PersonName firstName = ValueObjectReader.readPersonName("Enter new first name for the teacher: ");
        teacher.setFirstName(firstName);
        System.out.println("\nTeacher first name updated\n");
    }
    /**
     * This method is used to edit the teacher middle name.
     */
    private void editTeacherMiddleName() {
        PersonName middleName = ValueObjectReader.readPersonName("Enter new middle name for the teacher: ");
        teacher.setMiddleName(middleName);
        System.out.println("\nTeacher middle name updated\n");
    }
    /**
     * This method is used to edit the teacher last name.
     */
    private void editTeacherLastName() {
        PersonName lastName = ValueObjectReader.readPersonName("Enter new last name for the teacher: ");
        teacher.setLastName(lastName);
        System.out.println("\nTeacher last name updated\n");
    }
    /**
     * This method is used to delete the teacher.
     */
    private void delete(){
        teacher.getCathedra().removeTeacher(teacher);
        System.out.println("\nTeacher " + teacher + " deleted\n");
    }
}