package main.entities;

import main.valueObjects.OrganizationAbbreviation;
import main.valueObjects.OrganizationName;
import main.utils.list.IMyList;

public class Faculty {
    private OrganizationName name;
    private OrganizationAbbreviation abbreviation;

    private IMyList<Cathedra> cathedras;

    public OrganizationName getName() {
        return name;
    }

    public void setName(OrganizationName name) {
        this.name = name;
    }
}
