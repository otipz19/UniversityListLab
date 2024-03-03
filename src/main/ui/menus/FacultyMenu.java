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

public class FacultyMenu {
    private final Faculty faculty;

    public FacultyMenu(Faculty faculty) {
        this.faculty = faculty;
    }

    public void start() {
        new OptionsReader(
                new Option("Rename this faculty", this::renameFaculty),
                new StopOption("Delete this faculty", this::deleteFaculty),
                new Option("Add cathedra", this::createCathedra),
                new Option("Get cathedras", () -> new GetCathedrasRequest(faculty).get()),
                new Option("Get students", () -> new GetStudentsRequest(faculty).get()),
                new Option("Get teachers", () -> new GetTeachersRequest(faculty).get()),
                new StopOption("Go back to University")
        ).readUntilStop();
    }

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
        System.out.println("Faculty renamed");
    }

    private void deleteFaculty() {
        faculty.getUniversity().removeFaculty(faculty);
        System.out.println("Faculty deleted");
    }

    private void createCathedra() {
        OrganizationName name = ValueObjectReader.readOrganizationName("Enter cathedra name: ");
        Cathedra cathedra = new Cathedra(name);
        faculty.addCathedra(cathedra);
        System.out.println("Cathedra added");
    }
}