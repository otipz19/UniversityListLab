package main.model.entities;

import main.model.valueObjects.OrganizationName;
import main.model.utils.list.IMyList;

public class Cathedra {
    private OrganizationName name;

    private IMyList<Student> students;
    private IMyList<Teacher> teachers;

    public OrganizationName getName() {
        return name;
    }

    public void setName(OrganizationName name) {
        this.name = name;
    }
}
