package main.model.entities;

import main.model.exceptions.crud.CathedraNotFoundException;
import main.model.exceptions.crud.NotFoundException;
import main.model.valueObjects.OrganizationAbbreviation;
import main.model.valueObjects.OrganizationName;
import main.model.utils.list.IMyList;

public class Faculty {
    private OrganizationName name;
    private OrganizationAbbreviation abbreviation;

    private IMyList<Cathedra> cathedras;

    public Faculty(OrganizationName name, OrganizationAbbreviation abbreviation){
        this.name = name;
        this.abbreviation = abbreviation;
    }

    /**
     * Adds new cathedra to list of cathedras.
     * And sets link in cathedra to this faculty.
     */
    public void addCathedra(Cathedra cathedra){
        //TODO: add cathedra and set backward link
    }

    /**
     * Removes cathedra from list of cathedras, if it presents in this list.
     * Otherwise, throws exception.
     * @throws CathedraNotFoundException if Cathedra doesn't present in Faculty
     */
    public void removeCathedra(Cathedra cathedra) throws CathedraNotFoundException {
        //TODO: remove cathedra, if it presents
    }

    public OrganizationName getName() {
        return name;
    }

    public void setName(OrganizationName name) {
        this.name = name;
    }

    public OrganizationAbbreviation getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(OrganizationAbbreviation abbreviation) {
        this.abbreviation = abbreviation;
    }
}
