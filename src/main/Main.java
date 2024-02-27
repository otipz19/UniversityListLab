package main;

import main.model.entities.Cathedra;
import main.model.entities.Faculty;
import main.model.entities.Student;
import main.model.entities.University;
import main.model.utils.list.IMyList;
import main.model.valueObjects.OrganizationAbbreviation;
import main.model.valueObjects.OrganizationName;
import main.ui.menus.UniversityMenu;

public class Main {
    private static University university;

    public static void main(String[] args) {
        initialize();
        System.out.println("Welcome to Kyiv-Mohyla Academy");
        run();
    }

    private static void initialize() {
        university = new University();
        Faculty[] faculties = initFaculties();
        for (Faculty f : faculties) {
            university.addFaculty(f);
        }
    }

    private static Faculty[] initFaculties() {
        Faculty fi = new Faculty(new OrganizationName("Факультет Інформатики"), new OrganizationAbbreviation("ФІ"));
        addCathedrasToFaculty(initFiCathedras(), fi);
        Faculty fgn = new Faculty(new OrganizationName("Факультет Гуманітарних Наук"), new OrganizationAbbreviation("ФГН"));
        addCathedrasToFaculty(initFgnCathedras(), fgn);
        return new Faculty[] {fi, fgn};
    }

    private static void addCathedrasToFaculty(Cathedra[] fiCathedras, Faculty fi) {
        for(Cathedra c: fiCathedras){
            fi.addCathedra(c);
        }
    }

    private static Cathedra[] initFiCathedras(){
        Cathedra informatics = new Cathedra(new OrganizationName("Кафедра Інформатики"));
        addStudentsToCathedra(generateStudents(), informatics);
        Cathedra math = new Cathedra(new OrganizationName("Кафедра Математики"));
        addStudentsToCathedra(generateStudents(), math);
        return new Cathedra[] {informatics, math};
    }

    private static Cathedra[] initFgnCathedras(){
        Cathedra english = new Cathedra(new OrganizationName("Кафедра Англійської Мови"));
        addStudentsToCathedra(generateStudents(), english);
        Cathedra history = new Cathedra(new OrganizationName("Кафедра історії"));
        addStudentsToCathedra(generateStudents(), history);
        return new Cathedra[] {english, history};
    }

    private static void addStudentsToCathedra(IMyList<Student> students, Cathedra cathedra){
        for(int i = 0; i < students.count(); i++){
            cathedra.addStudent(students.getAt(i));
        }
    }

    private static IMyList<Student> generateStudents(){
        return StudentsGenerator.generate(10);
    }

    private static void run() {
        UniversityMenu universityMenu = new UniversityMenu(university);
        universityMenu.start();
    }
}