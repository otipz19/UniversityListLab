package main.model.entities;

import main.model.entities.getters.EntitiesGetter;
import main.model.entities.getters.StudentsGetter;
import main.model.entities.getters.TeachersGetter;
import main.model.exceptions.ObjectInListNotFoundException;
import main.model.exceptions.crud.CathedraNotFoundException;
import main.model.utils.Guard;
import main.model.utils.filtering.CathedraSearchFilter;
import main.model.utils.filtering.StudentSearchFilter;
import main.model.utils.filtering.TeacherSearchFilter;
import main.model.utils.list.MyList;
import main.model.utils.sorting.IComparator;
import main.model.valueObjects.OrganizationAbbreviation;
import main.model.valueObjects.OrganizationName;
import main.model.utils.list.IMyList;

public class Faculty implements IRepositoryEntity{
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

    public IMyList<Cathedra> getCathedras(CathedraSearchFilter filter){
        return getCathedras(filter, null);
    }

    /**
     * @return list of filtered cathedras
     */
    public IMyList<Cathedra> getCathedras(CathedraSearchFilter filter, IComparator<Cathedra> comparator) {
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

    public IMyList<Student> getStudents(){
        return getStudents(null);
    }

    public IMyList<Student> getStudents(StudentSearchFilter filter){
        return StudentsGetter.getStudents(filter, cathedras);
    }

    public IMyList<Teacher> getTeachers(){
        return getTeachers(null);
    }

    public IMyList<Teacher> getTeachers(TeacherSearchFilter filter){
        return TeachersGetter.getTeachers(filter, cathedras);
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

    public University getUniversity(){
        return university;
    }

    public void setUniversity(University university){
        this.university = university;
    }

    @Override
    public String toString(){
        return name + " " + abbreviation;
    }
}
