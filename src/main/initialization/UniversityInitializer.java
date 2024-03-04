package main.initialization;

import main.model.entities.*;
import main.model.utils.list.IMyList;
import main.model.valueObjects.OrganizationAbbreviation;
import main.model.valueObjects.OrganizationName;

/*
 * This class is a concrete class that is used to initialize the university.
 * It is a concrete class because it is meant to be instantiated.
 * It is a public class because it is used in other packages.
 */
public class UniversityInitializer {
    private final University university;
    private final StudentsGenerator studentsGenerator = new StudentsGenerator();
    private final TeachersGenerator teachersGenerator = new TeachersGenerator();

    /*
     * This constructor is used to create an instance of the UniversityInitializer class.
     * It is a public constructor because it is called from the main method.
     */
    public UniversityInitializer(University university) {
        this.university = university;
    }

    /*
     * This method is used to initialize the university.
     *      */
    public void initialize() {
        Faculty[] faculties = initFaculties();
        for (Faculty f : faculties) {
            university.addFaculty(f);
        }
    }

    /*
     * This method is used to initialize the faculties of the university.
     */
    private Faculty[] initFaculties() {
        Faculty fi = new Faculty(new OrganizationName("Факультет Інформатики"), new OrganizationAbbreviation("ФІ"));
        addCathedrasToFaculty(initFiCathedras(), fi);
        Faculty fgn = new Faculty(new OrganizationName("Факультет Гуманітарних Наук"), new OrganizationAbbreviation("ФГН"));
        addCathedrasToFaculty(initFgnCathedras(), fgn);
        return new Faculty[]{fi, fgn};
    }

    /*
     * This method is used to add cathedras to a faculty.
     * @param fiCathedras - the list of cathedras
     * @param fi - the faculty
     * @return the faculty
     */
    private void addCathedrasToFaculty(Cathedra[] fiCathedras, Faculty fi) {
        for (Cathedra c : fiCathedras) {
            fi.addCathedra(c);
        }
    }

    /*
     * This method is used to initialize the cathedras of the faculty of informatics.
     * @return the list of cathedras
     */
    private Cathedra[] initFiCathedras() {
        Cathedra informatics = setupCathedra("Кафедра Інформатики");
        Cathedra math = setupCathedra("Кафедра Математики");
        return new Cathedra[]{informatics, math};
    }

    /*
     * This method is used to initialize the cathedras of the faculty of humanities.
     * @return the list of cathedras
     * @param name - the name of the cathedra
     * @return the cathedra
     */
    private Cathedra[] initFgnCathedras() {
        Cathedra english = setupCathedra("Кафедра Англійської Мови");
        Cathedra history = setupCathedra("Кафедра історії");
        return new Cathedra[]{english, history};
    }

    /*
     * This method is used to setup a cathedra.
     * @param name - the name of the cathedra
     * @return the cathedra
     */
    private Cathedra setupCathedra(String name) {
        Cathedra cathedra = new Cathedra(new OrganizationName(name));
        addStudentsToCathedra(generateStudents(), cathedra);
        addTeachersToCathedra(generateTeachers(), cathedra);
        return cathedra;
    }

    /*
     * This method is used to add students to a cathedra.
     * @param students - the list of students
     * @param cathedra - the cathedra
     * @return the cathedra
     */
    private static void addStudentsToCathedra(IMyList<Student> students, Cathedra cathedra) {
        for (int i = 0; i < students.count(); i++) {
            cathedra.addStudent(students.getAt(i));
        }
    }

    /*
     * This method is used to add teachers to a cathedra.
     * @param teachers - the list of teachers
     * @param cathedra - the cathedra
     * @return the cathedra
     */
    private static void addTeachersToCathedra(IMyList<Teacher> teachers, Cathedra cathedra) {
        for (int i = 0; i < teachers.count(); i++) {
            cathedra.addTeacher(teachers.getAt(i));
        }
    }

    /*
     * This method is used to generate a list of students.
     * @return the list of students
     */
    private IMyList<Student> generateStudents() {
        return studentsGenerator.generate(10);
    }

    /*
     * This method is used to generate a list of teachers.
     * @return the list of teachers
     */
    private IMyList<Teacher> generateTeachers() {
        return teachersGenerator.generate(4);
    }
}
