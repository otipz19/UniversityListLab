package main.model.entities;

import main.model.exceptions.crud.CathedraNotFoundException;
import main.model.utils.Guard;
import main.model.utils.list.MyList;
import main.model.valueObjects.OrganizationAbbreviation;
import main.model.valueObjects.OrganizationName;
import main.model.utils.list.IMyList;

public class Faculty {
    private OrganizationName name;
    private OrganizationAbbreviation abbreviation;

    private final IMyList<Cathedra> cathedras = new MyList<Cathedra>();

    public Faculty(OrganizationName name, OrganizationAbbreviation abbreviation){
        Guard.againstNull(name);
        Guard.againstNull(abbreviation);
        this.name = name;
        this.abbreviation = abbreviation;
    }

    /**
     * Adds new cathedra to list of cathedras.
     * And sets link in cathedra to this faculty.
     */
    public void addCathedra(Cathedra cathedra){
        cathedras.add(cathedra);
        cathedra.setFaculty(this);
    }

    /**
     * Removes cathedra from list of cathedras, if it presents in this list.
     * Otherwise, throws exception.
     * @throws CathedraNotFoundException if Cathedra doesn't present in Faculty
     */
    public void removeCathedra(Cathedra cathedra) throws CathedraNotFoundException {
        int index = -1;
        for (int i = 0; i < cathedras.count(); i++) { // Look for index of cathedra
            if (cathedras.getAt(i).equals(cathedra)) {
                index = i;
                break;
            }
        }
        if (index == -1) { // If cathedra not found, throw exception
            throw new CathedraNotFoundException(cathedra);
        }
        cathedras.removeAt(index);
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
