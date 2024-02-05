package main.entities;

import main.valueObjects.OrganizationName;
import main.utils.list.IMyList;

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
