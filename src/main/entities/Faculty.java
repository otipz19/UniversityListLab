package main.entities;

import main.entities.help.OrganizationName;
import main.utils.list.CathedrasList;

public class Faculty {
    private OrganizationName name;

    private CathedrasList cathedras;

    public OrganizationName getName() {
        return name;
    }

    public void setName(OrganizationName name) {
        this.name = name;
    }

    public CathedrasList getCathedras() {
        return cathedras;
    }

    public void setCathedras(CathedrasList cathedras) {
        this.cathedras = cathedras;
    }
}
