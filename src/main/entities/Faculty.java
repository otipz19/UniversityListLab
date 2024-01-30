package main.entities;

import main.entities.help.OrganizationName;
import main.utils.list.IMyList;

public class Faculty {
    private OrganizationName name;

    private IMyList<Cathedra> cathedras;

    public OrganizationName getName() {
        return name;
    }

    public void setName(OrganizationName name) {
        this.name = name;
    }

    public IMyList<Cathedra> getCathedras() {
        return cathedras;
    }

    public void setCathedras(IMyList<Cathedra> cathedras) {
        this.cathedras = cathedras;
    }
}
