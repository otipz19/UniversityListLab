package main.model.entities;

import main.model.entities.getters.EntitiesGetter;
import main.model.entities.getters.TeachersGetter;
import main.model.exceptions.ObjectInListNotFoundException;
import main.model.exceptions.crud.StudentNotFoundException;
import main.model.exceptions.crud.TeacherNotFoundException;
import main.model.utils.Guard;
import main.model.utils.filtering.SearchFilter;
import main.model.utils.filtering.StudentSearchFilter;
import main.model.utils.filtering.TeacherSearchFilter;
import main.model.utils.list.MyList;
import main.model.utils.sorting.IComparator;
import main.model.valueObjects.OrganizationName;
import main.model.utils.list.IMyList;

public class Cathedra implements IRepositoryEntity {
    private OrganizationName name;

    private Faculty faculty;

    private final IMyList<Student> students = new MyList<Student>();
    private final IMyList<Teacher> teachers = new MyList<Teacher>();

    public Cathedra(OrganizationName name) {
        Guard.againstNull(name);
        this.name = name;
    }

    /**
     * Adds student to students list and sets backwards link.
     */
    public void addStudent(Student student) {
        students.add(student);
        student.setCathedra(this);
    }

    /**
     * Adds teacher to teachers list and sets backwards link.
     */
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        teacher.setCathedra(this);
    }

    /**
     * Removes student from students list, if it presents in this list.
     * Otherwise, throws exception.
     *
     * @throws StudentNotFoundException if student doesn't exist
     */
    public void removeStudent(Student student) throws StudentNotFoundException {
        try {
            students.remove(student);
        } catch (ObjectInListNotFoundException ex) {
            throw new StudentNotFoundException(student);
        }
    }

    /**
     * Removes teacher from teachers list, if it presents in this list.
     * Otherwise, throws exception.
     *
     * @throws TeacherNotFoundException if teacher doesn't exist
     */
    public void removeTeacher(Teacher teacher) throws TeacherNotFoundException {
        try {
            teachers.remove(teacher);
        } catch (ObjectInListNotFoundException ex) {
            throw new TeacherNotFoundException(teacher);
        }
    }

    public IMyList<Student> getStudents(SearchFilter<Student> filter, IComparator<Student> comparator) {
        return EntitiesGetter.getEntities(students, filter, comparator);
    }

    public IMyList<Teacher> getTeachers(SearchFilter<Teacher> filter, IComparator<Teacher> comparator) {
        return EntitiesGetter.getEntities(teachers, filter, comparator);
    }

    public OrganizationName getName() {
        return name;
    }

    public void setName(OrganizationName name) {
        Guard.againstNull(name);
        this.name = name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        Guard.againstNull(faculty);
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
