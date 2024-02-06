package main.model.entities;

import main.model.valueObjects.OrganizationName;
import main.model.utils.list.IMyList;

public class Faculty {
    private OrganizationName name;

    private IMyList<Cathedra> cathedras;

    public OrganizationName getName() {
        return name;
    }

    public void setName(OrganizationName name) {
        this.name = name;
    }
}
