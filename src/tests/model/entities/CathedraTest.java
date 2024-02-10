package tests.model.entities;

import main.model.entities.Cathedra;
import main.model.entities.Student;
import main.model.utils.filtering.StudentSearchFilter;
import main.model.utils.filtering.StudentSearchFilterBuilder;
import main.model.utils.list.IMyList;
import main.model.valueObjects.Course;
import main.model.valueObjects.Group;
import main.model.valueObjects.OrganizationName;
import main.model.valueObjects.PersonName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CathedraTest {
    private Cathedra cathedra;

    @BeforeEach
    void init() {
        cathedra = new Cathedra(new OrganizationName("test"));
    }

    @ParameterizedTest
    @MethodSource("provideStudentsArguments")
    void getStudents(Student[] students) {
        addStudentsToCathedra(students);
        var fromRequest = cathedra.getStudents();
        testRequestResult(students, fromRequest);
    }

    @ParameterizedTest
    @MethodSource("provideStudentsArgumentsWithFilter")
    void getStudentsWithFilter(Student[] input, StudentSearchFilter filter, Student[] expectedOutput) {
        addStudentsToCathedra(input);
        var fromRequest = cathedra.getStudents(filter);
        testRequestResult(expectedOutput, fromRequest);
    }

    private void addStudentsToCathedra(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            cathedra.addStudent(students[i]);
        }
    }

    private static void testRequestResult(Student[] students, IMyList<Student> fromRequest) {
        assertEquals(students.length, fromRequest.count());
        for (int i = 0; i < students.length; i++) {
            assertEquals(students[i], fromRequest.getAt(i));
        }
    }

    private static Stream<Arguments> provideStudentsArguments() {
        return Stream.of(Arguments.of(
                new Student[0],
                new Student[]{
                        new Student(
                                new PersonName("John"),
                                new PersonName("John"),
                                new PersonName("John"),
                                new Group(1),
                                new Course(1)
                        ),
                        new Student(
                                new PersonName("Alice"),
                                new PersonName("Alice"),
                                new PersonName("Alice"),
                                new Group(2),
                                new Course(1)
                        ),
                        new Student(
                                new PersonName("Bob"),
                                new PersonName("Bob"),
                                new PersonName("Bob"),
                                new Group(1),
                                new Course(2)
                        )
                }));
    }

    private static Stream<Arguments> provideStudentsArgumentsWithFilter() {
        return Stream.of(
                getArguments_StudentsFilteredByAll_EmptyResult(),
                getArguments_StudentsFilteredByGroup_NotEmptyResult(),
                getArguments_StudentsFilteredByCourse_NotEmptyResult(),
                getArguments_StudentsFilteredByGroupAndCourse_NotEmptyResult(),
                getArguments_StudentsFilteredBySearchTerm_NotEmptyResult()
        );
    }

    private static Arguments getArguments_StudentsFilteredByGroup_NotEmptyResult() {
        Student inResult = new Student(
                new PersonName("Alice"),
                new PersonName("Eve"),
                new PersonName("Brown"),
                new Group(2),
                new Course(2)
        );

        return Arguments.of(
                new Student[]{
                        new Student(
                                new PersonName("John"),
                                new PersonName("Doe"),
                                new PersonName("Smith"),
                                new Group(1),
                                new Course(1)
                        ),
                        inResult,
                        new Student(
                                new PersonName("Bob"),
                                new PersonName("Doe"),
                                new PersonName("Black"),
                                new Group(3),
                                new Course(3)
                        )
                },
                new StudentSearchFilterBuilder()
                        .addGroup(new Group(2))
                        .build(),
                new Student[]{
                        inResult
                }
        );
    }

    private static Arguments getArguments_StudentsFilteredByCourse_NotEmptyResult() {
        Student inResult = new Student(
                new PersonName("Bob"),
                new PersonName("Doe"),
                new PersonName("Black"),
                new Group(3),
                new Course(3)
        );

        return Arguments.of(
                new Student[]{
                        new Student(
                                new PersonName("John"),
                                new PersonName("Doe"),
                                new PersonName("Smith"),
                                new Group(1),
                                new Course(1)
                        ),
                        new Student(
                                new PersonName("Alice"),
                                new PersonName("Eve"),
                                new PersonName("Brown"),
                                new Group(2),
                                new Course(2)
                        ),
                        inResult
                },
                new StudentSearchFilterBuilder()
                        .addCourse(new Course(3))
                        .build(),
                new Student[]{
                        inResult
                }
        );
    }

    private static Arguments getArguments_StudentsFilteredByGroupAndCourse_NotEmptyResult() {
        Student inResult = new Student(
                new PersonName("Alice"),
                new PersonName("Eve"),
                new PersonName("Brown"),
                new Group(2),
                new Course(2)
        );

        return Arguments.of(
                new Student[]{
                        new Student(
                                new PersonName("John"),
                                new PersonName("Doe"),
                                new PersonName("Smith"),
                                new Group(1),
                                new Course(1)
                        ),
                        inResult,
                        new Student(
                                new PersonName("Bob"),
                                new PersonName("Doe"),
                                new PersonName("Black"),
                                new Group(3),
                                new Course(3)
                        )
                },
                new StudentSearchFilterBuilder()
                        .addGroup(new Group(2))
                        .addCourse(new Course(2))
                        .build(),
                new Student[]{
                        inResult
                }
        );
    }

    private static Arguments getArguments_StudentsFilteredBySearchTerm_NotEmptyResult() {
        Student inResult = new Student(
                new PersonName("John"),
                new PersonName("Doe"),
                new PersonName("Smith"),
                new Group(1),
                new Course(1)
        );

        return Arguments.of(
                new Student[]{
                        inResult,
                        new Student(
                                new PersonName("Alice"),
                                new PersonName("Eve"),
                                new PersonName("Brown"),
                                new Group(2),
                                new Course(2)
                        ),
                        new Student(
                                new PersonName("Bob"),
                                new PersonName("Doe"),
                                new PersonName("Black"),
                                new Group(3),
                                new Course(3)
                        )
                },
                new StudentSearchFilterBuilder()
                        .addSearchTerm("Smith")
                        .build(),
                new Student[]{
                        inResult
                }
        );
    }

    private static Arguments getArguments_StudentsFilteredByAll_EmptyResult() {
        return Arguments.of(
                new Student[]{
                        new Student(
                                new PersonName("John"),
                                new PersonName("Doe"),
                                new PersonName("Smith"),
                                new Group(1),
                                new Course(1)
                        ),
                        new Student(
                                new PersonName("Alice"),
                                new PersonName("Eve"),
                                new PersonName("Brown"),
                                new Group(2),
                                new Course(2)
                        ),
                        new Student(
                                new PersonName("Bob"),
                                new PersonName("Doe"),
                                new PersonName("Black"),
                                new Group(3),
                                new Course(3)
                        )
                },
                new StudentSearchFilterBuilder()
                        .addSearchTerm("Smith")
                        .addGroup(new Group(6))
                        .addCourse(new Course(4))
                        .build(),
                new Student[0]
        );
    }
}