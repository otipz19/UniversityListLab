package main.model.entities;

import main.model.entities.getters.EntitiesGetter;
import main.model.entities.getters.StudentsGetter;
import main.model.entities.getters.TeachersGetter;
import main.model.exceptions.ObjectInListNotFoundException;
import main.model.exceptions.crud.CathedraNotFoundException;
import main.model.utils.Guard;
import main.model.utils.filtering.CathedraSearchFilter;
import main.model.utils.filtering.SearchFilter;
import main.model.utils.filtering.StudentSearchFilter;
import main.model.utils.filtering.TeacherSearchFilter;
import main.model.utils.list.MyList;
import main.model.utils.sorting.IComparator;
import main.model.valueObjects.OrganizationAbbreviation;
import main.model.valueObjects.OrganizationName;
import main.model.utils.list.IMyList;
/**
 * This class is a concrete class that is used to represent a faculty.
 * It is a concrete class because it is meant to be instantiated.
 * It is a public class because it is used in other packages.
 */
public class Faculty implements IRepositoryEntity {
    private University university;

    private OrganizationName name;
    private OrganizationAbbreviation abbreviation;

    private final IMyList<Cathedra> cathedras = new MyList<Cathedra>();

    public Faculty(OrganizationName name, OrganizationAbbreviation abbreviation) {
        Guard.againstNull(name);
        Guard.againstNull(abbreviation);
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public Faculty(OrganizationName name){
        Guard.againstNull(name);
        this.name = name;
        formAbbreviation();
    }

    public void formAbbreviation() {
        var words = name.getValue().split(" ");
        var builder = new StringBuilder();
        for(String w: words){
            builder.append(w.charAt(0));
        }
        this.abbreviation = new OrganizationAbbreviation(builder.toString().toUpperCase());
    }

    /**
     * Adds new cathedra to list of cathedras.
     * And sets link in cathedra to this faculty.
     */
    public void addCathedra(Cathedra cathedra) {
        cathedras.add(cathedra);
        cathedra.setFaculty(this);
    }

    /**
     * @return list of all cathedras
     */
    public IMyList<Cathedra> getCathedras() {
        return getCathedras(null);
    }

    public IMyList<Cathedra> getCathedras(SearchFilter<Cathedra> filter) {
        return getCathedras(filter, null);
    }

    /**
     * @return list of filtered cathedras
     */
    public IMyList<Cathedra> getCathedras(SearchFilter<Cathedra> filter, IComparator<Cathedra> comparator) {
        return EntitiesGetter.getEntities(cathedras, filter, comparator);
    }

    /**
     * Removes cathedra from list of cathedras, if it presents in this list.
     * Otherwise, throws exception.
     *
     * @throws CathedraNotFoundException if Cathedra doesn't present in Faculty
     */
    public void removeCathedra(Cathedra cathedra) throws CathedraNotFoundException {
        try {
            cathedras.remove(cathedra);
        } catch (ObjectInListNotFoundException ex) {
            throw new CathedraNotFoundException(cathedra);
        }
    }

    public IMyList<Student> getStudents(SearchFilter<Student> filter, IComparator<Student> comparator) {
        return StudentsGetter.getStudents(cathedras, filter, comparator);
    }

    public IMyList<Teacher> getTeachers(SearchFilter<Teacher> filter, IComparator<Teacher> comparator) {
        return TeachersGetter.getTeachers(cathedras, filter, comparator);
    }

    public OrganizationName getName() {
        return name;
    }

    public void setName(OrganizationName name) {
        Guard.againstNull(name);
        this.name = name;
    }

    public OrganizationAbbreviation getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(OrganizationAbbreviation abbreviation) {
        Guard.againstNull(abbreviation);
        this.abbreviation = abbreviation;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        Guard.againstNull(university);
        this.university = university;
    }

    @Override
    public String toString() {
        return name + ", " + abbreviation;
    }
}
