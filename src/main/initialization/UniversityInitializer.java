package main.initialization;

import main.model.entities.*;
import main.model.utils.list.IMyList;
import main.model.valueObjects.OrganizationAbbreviation;
import main.model.valueObjects.OrganizationName;

public class UniversityInitializer {
    private final University university;
    private final StudentsGenerator studentsGenerator = new StudentsGenerator();
    private final TeachersGenerator teachersGenerator = new TeachersGenerator();

    public UniversityInitializer(University university){
        this.university = university;
    }

    public void initialize() {
        Faculty[] faculties = initFaculties();
        for (Faculty f : faculties) {
            university.addFaculty(f);
        }
    }

    private Faculty[] initFaculties() {
        Faculty fi = new Faculty(new OrganizationName("Факультет Інформатики"), new OrganizationAbbreviation("ФІ"));
        addCathedrasToFaculty(initFiCathedras(), fi);
        Faculty fgn = new Faculty(new OrganizationName("Факультет Гуманітарних Наук"), new OrganizationAbbreviation("ФГН"));
        addCathedrasToFaculty(initFgnCathedras(), fgn);
        return new Faculty[] {fi, fgn};
    }

    private void addCathedrasToFaculty(Cathedra[] fiCathedras, Faculty fi) {
        for(Cathedra c: fiCathedras){
            fi.addCathedra(c);
        }
    }

    private Cathedra[] initFiCathedras(){
        Cathedra informatics = setupCathedra("Кафедра Інформатики");
        Cathedra math = setupCathedra("Кафедра Математики");
        return new Cathedra[] {informatics, math};
    }

    private Cathedra[] initFgnCathedras(){
        Cathedra english = setupCathedra("Кафедра Англійської Мови");
        Cathedra history = setupCathedra("Кафедра історії");
        return new Cathedra[] {english, history};
    }

    private Cathedra setupCathedra(String name){
        Cathedra cathedra = new Cathedra(new OrganizationName(name));
        addStudentsToCathedra(generateStudents(), cathedra);
        addTeachersToCathedra(generateTeachers(), cathedra);
        return cathedra;
    }

    private static void addStudentsToCathedra(IMyList<Student> students, Cathedra cathedra){
        for(int i = 0; i < students.count(); i++){
            cathedra.addStudent(students.getAt(i));
        }
    }

    private static void addTeachersToCathedra(IMyList<Teacher> teachers, Cathedra cathedra){
        for(int i = 0; i < teachers.count(); i++){
            cathedra.addTeacher(teachers.getAt(i));
        }
    }

    private IMyList<Student> generateStudents(){
        return studentsGenerator.generate(10);
    }

    private IMyList<Teacher> generateTeachers(){
        return teachersGenerator.generate(4);
    }
}
