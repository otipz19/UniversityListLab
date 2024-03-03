package tests.model.entities;

import main.model.entities.Cathedra;
import main.model.entities.Faculty;
import main.model.entities.Student;
import main.model.entities.University;
import main.model.utils.filtering.StudentSearchFilter;
import main.model.utils.list.IMyList;
import main.model.utils.sorting.IComparator;
import main.model.valueObjects.OrganizationAbbreviation;
import main.model.valueObjects.OrganizationName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class UniversityTest {
    private static final int FACULTIES_COUNT = 2;
    private static final int CATHEDRAS_COUNT = 2;
    private static final int STUDENTS_COUNT = 2;

    private University university;

    @BeforeEach
    void init(){
        university = new University();
        var faculties = generateFaculties();
        for(Faculty f: faculties){
            university.addFaculty(f);
        }
    }

    private static Faculty[] generateFaculties(){
        Faculty[] result = new Faculty[FACULTIES_COUNT];
        for(int i = 0; i < result.length; i++){
            var name = "fac";
            result[i] = new Faculty(new OrganizationName(name), new OrganizationAbbreviation(name));
            var cathedras = generateCathedras();
            for(Cathedra c: cathedras){
                result[i].addCathedra(c);
            }
        }
        return result;
    }

    private static Cathedra[] generateCathedras(){
        var result = new Cathedra[CATHEDRAS_COUNT];
        for(int i = 0; i < result.length; i++){
            var name = "cat";
            result[i] = new Cathedra(new OrganizationName(name));
        }
        return result;
    }


    @ParameterizedTest
    @MethodSource("tests.model.entities.StudentsArgumentsProvider#provideStudents")
    void getStudents(Student[] input, Student[] expected) {
        test(input, expected, () -> university.getStudents());
    }

    @ParameterizedTest
    @MethodSource("tests.model.entities.StudentsArgumentsProvider#provideStudents_WithFilter")
    void getStudents_WithFilter(Student[] input, Student[] expected, StudentSearchFilter filter) {
        test(input, expected, () -> university.getStudents(filter));
    }

    @ParameterizedTest
    @MethodSource("tests.model.entities.StudentsArgumentsProvider#provideStudents_WithSort")
    void getStudents_WithSort(
            Student[] input,
            Student[] expected,
            IComparator<Student> comparator) {
        test(input, expected, () -> university.getStudents(comparator));
    }

    private void test(Student[] input, Student[] expected, Supplier<IMyList<Student>> getter){
        loadStudentsInputToUniversity(input);

        var actual = getter.get();

        assertResult(expected, actual);
    }

    private void loadStudentsInputToUniversity(Student[] input) {
        var faculties = university.getFaculties();
        for(int i = 0; i < FACULTIES_COUNT; i++){
            var cathedras = faculties.getAt(i).getCathedras();
            for(int j = 0; j < CATHEDRAS_COUNT; j++){
                var cathedra = cathedras.getAt(j);
                for(int k = 0; k < STUDENTS_COUNT; k++){
                    int index = i * CATHEDRAS_COUNT * STUDENTS_COUNT + j * STUDENTS_COUNT + k;
                    cathedra.addStudent(input[index]);
                }
            }
        }
    }

    private static void assertResult(Student[] expected, IMyList<Student> actual) {
        assertEquals(expected.length, actual.count());
        for(int i = 0; i < actual.count(); i++){
            assertTrue(equalsStudentsByValue(expected[i], actual.getAt(i)));
        }
    }

    private static boolean equalsStudentsByValue(Student left, Student right){
        return left.getFirstName().equals(right.getFirstName())
                && left.getMiddleName().equals(right.getMiddleName())
                && left.getLastName().equals(right.getLastName())
                && left.getCourse().equals(right.getCourse())
                && left.getGroup().equals(right.getGroup());
    }
}