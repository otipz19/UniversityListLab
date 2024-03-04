package main.ui.menus;

import DataInputUtil.main.*;
import main.model.entities.*;
import main.model.utils.list.IMyList;
import main.model.valueObjects.OrganizationAbbreviation;
import main.model.valueObjects.OrganizationName;
import main.ui.readers.ValueObjectReader;
import main.ui.requests.GetCathedrasRequest;
import main.ui.requests.GetStudentsRequest;
import main.ui.requests.GetTeachersRequest;
/**
 * This class is used to represent a faculty menu.
 * It is a public class because it is used in other packages.
 */
public class FacultyMenu {
    private final Faculty faculty;
    /**
     * This constructor is used to create a faculty menu.
     * @param faculty - the faculty
     * @return - the faculty menu
     */
    public FacultyMenu(Faculty faculty) {
        this.faculty = faculty;
    }
    /**
     * This method is used to start the faculty menu.
     */
    public void start() {
        new OptionsReader(
                System.out::println,
                new Option("Rename this faculty", this::renameFaculty),
                new StopOption("Delete this faculty", this::deleteFaculty),
                new Option("Add cathedra", this::createCathedra),
                new Option("Get cathedras", () -> new GetCathedrasRequest(faculty).get()),
                new Option("Get students", () -> new GetStudentsRequest(faculty).get()),
                new Option("Get teachers", () -> new GetTeachersRequest(faculty).get()),
                new StopOption("Go back to University")
        ).readUntilStop("\nYou're at " + faculty.toString().toUpperCase() + " faculty level\n");
    }
    /**
     * This method is used to rename the faculty.
     */
    private void renameFaculty() {
        OrganizationName newName = ValueObjectReader.readOrganizationName("Enter new faculty name: ");
        faculty.setName(newName);
        if(ConsoleUtils.askQuestion("Do you want to form abbreviation automatically?")){
            faculty.formAbbreviation();
        }
        else{
            OrganizationAbbreviation abbreviation = ValueObjectReader
                    .readOrganizationAbbreviation("Enter faculty abbreviation: ");
            faculty.setAbbreviation(abbreviation);
        }
        System.out.println("\nFaculty renamed\n");
    }
    /**
     * This method is used to delete the faculty.
     */
    private void deleteFaculty() {
        faculty.getUniversity().removeFaculty(faculty);
        System.out.println("\nFaculty deleted\n");
    }
    /**
     * This method is used to create a cathedra.
     */
    private void createCathedra() {
        OrganizationName name = ValueObjectReader.readOrganizationName("Enter cathedra name: ");
        Cathedra cathedra = new Cathedra(name);
        faculty.addCathedra(cathedra);
        System.out.println("\nCathedra " + cathedra + " added\n");
    }
}