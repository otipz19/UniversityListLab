package main.ui.menus;

import DataInputUtil.main.*;
import main.model.entities.Faculty;
import main.model.entities.University;
import main.model.valueObjects.OrganizationAbbreviation;
import main.model.valueObjects.OrganizationName;
import main.ui.readers.ValueObjectReader;
import main.ui.requests.GetFacultiesRequest;
import main.ui.requests.GetStudentsRequest;
import main.ui.requests.GetTeachersRequest;

/**
 * This class is used to represent a university menu.
 * It is a public class because it is used in other packages.
 */
public class UniversityMenu {
    private final University university;
    /**
     * This constructor is used to create a university menu.
     * @param university - the university
     * @return - the university menu
     */
    public UniversityMenu(University university) {
        this.university = university;
    }
    /**
     * This method is used to start the university menu.
     */
    public void start() {
        new OptionsReader(
                System.out::println,
                new Option("Add faculty", this::createFaculty),
                new Option("Get faculties", () -> new GetFacultiesRequest(university).get()),
                new Option("Get students", () -> new GetStudentsRequest(university).get()),
                new Option("Get teachers", () -> new GetTeachersRequest(university).get()),
                new StopOption("Exit")
        ).readUntilStop("\nYou're at UNIVERSITY level\n");
    }
    /**
     * This method is used to create a faculty.
     */
    private void createFaculty() {
        Faculty faculty = null;
        OrganizationName name = ValueObjectReader.readOrganizationName("Enter faculty name: ");
        if (ConsoleUtils.askQuestion("Do you want to form abbreviation automatically?")) {
            faculty = new Faculty(name);
        } else {
            OrganizationAbbreviation abbreviation = ValueObjectReader
                    .readOrganizationAbbreviation("Enter faculty abbreviation: ");
            faculty = new Faculty(name, abbreviation);
        }
        university.addFaculty(faculty);
        System.out.println("\nFaculty " + faculty + " added\n");
    }
}
