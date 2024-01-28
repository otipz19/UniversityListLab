package main.entities;

import main.utils.list.CathedrasList;

public class Faculty {
    private OrganizationName name;

    private CathedrasList cathedras;

    public CathedrasList getCathedras() {
        return cathedras;
    }

    public void setCathedras(CathedrasList cathedras) {
        this.cathedras = cathedras;
    }
}
