package main.ui.menus;

import DataInputUtil.main.*;
import main.model.entities.Faculty;
import main.model.entities.University;
import main.model.utils.list.IMyList;
import main.model.valueObjects.OrganizationAbbreviation;
import main.model.valueObjects.OrganizationName;
import main.ui.menus.base.RepositoryMenu;
import main.ui.readers.ValueObjectReader;
import main.ui.requests.GetFacultiesRequest;

public class UniversityMenu extends RepositoryMenu {
    private University university;

    public UniversityMenu(University university) {
        super(university);
        this.university = university;
    }

    public void start() {
        new OptionsReader(
                new Option("Add faculty", this::createFaculty),
                new Option("Get faculties", () -> new GetFacultiesRequest(university).get()),
                new Option("Get students", this::getStudents),
                new Option("Get teachers", this::getTeachers),
                new StopOption("Exit")
        ).readUntilStop();
    }

    private void createFaculty() {
        OrganizationName name = ValueObjectReader.readOrganizationName("Enter faculty name: ");
        OrganizationAbbreviation abbreviation = ValueObjectReader.readOrganizationAbbreviation("Enter faculty abbreviation: ");
        Faculty faculty = new Faculty(name, abbreviation);
        university.addFaculty(faculty);
        System.out.println("Faculty added");
    }
}
