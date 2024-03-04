package tests.model.entities;

import main.model.entities.Student;
import main.model.utils.filtering.StudentSearchFilterBuilder;
import main.model.utils.sorting.comparators.*;
import main.model.valueObjects.Course;
import main.model.valueObjects.Group;
import main.model.valueObjects.PersonName;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;
/**
 * This class is used to represent a students arguments provider.
 * It is a public class because it is used in other packages.
 */
public class StudentsArgumentsProvider {
    public static Stream<Arguments> provideStudents() {
        return Stream.of(
                provideStudents_Arguments_Variant1(),
                provideStudents_Arguments_Variant2(),
                provideStudents_Arguments_Variant3()
        );
    }

    private static Arguments provideStudents_Arguments_Variant1() {
        var students = new Student[]{
                new Student(new PersonName("John"), new PersonName("John"), new PersonName("John"), new Group(1), new Course(1)),
                new Student(new PersonName("Alice"), new PersonName("Alice"), new PersonName("Alice"), new Group(2), new Course(1)),
                new Student(new PersonName("Bob"), new PersonName("Bob"), new PersonName("Bob"), new Group(1), new Course(2)),
                new Student(new PersonName("David"), new PersonName("David"), new PersonName("David"), new Group(2), new Course(2)),
                new Student(new PersonName("Emma"), new PersonName("Emma"), new PersonName("Emma"), new Group(1), new Course(1)),
                new Student(new PersonName("Frank"), new PersonName("Frank"), new PersonName("Frank"), new Group(2), new Course(1)),
                new Student(new PersonName("Grace"), new PersonName("Grace"), new PersonName("Grace"), new Group(1), new Course(2)),
                new Student(new PersonName("Henry"), new PersonName("Henry"), new PersonName("Henry"), new Group(2), new Course(2))
        };
        return Arguments.of(students, Arrays.copyOf(students, students.length));
    }

    private static Arguments provideStudents_Arguments_Variant2() {
        var students = new Student[]{
                new Student(new PersonName("James"), new PersonName("James"), new PersonName("James"), new Group(1), new Course(1)),
                new Student(new PersonName("Emily"), new PersonName("Emily"), new PersonName("Emily"), new Group(2), new Course(1)),
                new Student(new PersonName("Charlie"), new PersonName("Charlie"), new PersonName("Charlie"), new Group(1), new Course(2)),
                new Student(new PersonName("Sophia"), new PersonName("Sophia"), new PersonName("Sophia"), new Group(2), new Course(2)),
                new Student(new PersonName("Olivia"), new PersonName("Olivia"), new PersonName("Olivia"), new Group(1), new Course(1)),
                new Student(new PersonName("Jacob"), new PersonName("Jacob"), new PersonName("Jacob"), new Group(2), new Course(1)),
                new Student(new PersonName("Liam"), new PersonName("Liam"), new PersonName("Liam"), new Group(1), new Course(2)),
                new Student(new PersonName("Charlotte"), new PersonName("Charlotte"), new PersonName("Charlotte"), new Group(2), new Course(2))
        };
        return Arguments.of(students, Arrays.copyOf(students, students.length));
    }

    private static Arguments provideStudents_Arguments_Variant3() {
        var students = new Student[]{
                new Student(new PersonName("Michael"), new PersonName("Michael"), new PersonName("Michael"), new Group(1), new Course(1)),
                new Student(new PersonName("Emma"), new PersonName("Emma"), new PersonName("Emma"), new Group(2), new Course(1)),
                new Student(new PersonName("William"), new PersonName("William"), new PersonName("William"), new Group(1), new Course(2)),
                new Student(new PersonName("Isabella"), new PersonName("Isabella"), new PersonName("Isabella"), new Group(2), new Course(2)),
                new Student(new PersonName("Alexander"), new PersonName("Alexander"), new PersonName("Alexander"), new Group(1), new Course(1)),
                new Student(new PersonName("Ava"), new PersonName("Ava"), new PersonName("Ava"), new Group(2), new Course(1)),
                new Student(new PersonName("James"), new PersonName("James"), new PersonName("James"), new Group(1), new Course(2)),
                new Student(new PersonName("Charlotte"), new PersonName("Charlotte"), new PersonName("Charlotte"), new Group(2), new Course(2))
        };
        return Arguments.of(students, Arrays.copyOf(students, students.length));
    }


    public static Stream<Arguments> provideStudents_WithFilter() {
        return Stream.of(
                provideStudents_Arguments_Variant1_FilterByName(),
                provideStudents_Arguments_Variant2_FilterByGroup(),
                provideStudents_Arguments_Variant3_FilterByCourse(),
                provideStudents_Arguments_Variant4_FilterByCourseAndGroup(),
                provideStudents_Arguments_Variant5_EmptyResult()
        );
    }

    private static Arguments provideStudents_Arguments_Variant1_FilterByName() {
        Student[] initialStudents = new Student[]{
                new Student(new PersonName("John"), new PersonName("John"), new PersonName("John"), new Group(1), new Course(1)),
                new Student(new PersonName("Alice"), new PersonName("Alice"), new PersonName("Alice"), new Group(2), new Course(1)),
                new Student(new PersonName("Emma"), new PersonName("Emma"), new PersonName("Emma"), new Group(1), new Course(1)),
                new Student(new PersonName("David"), new PersonName("David"), new PersonName("David"), new Group(2), new Course(2)),
                new Student(new PersonName("Henry"), new PersonName("Henry"), new PersonName("Henry"), new Group(2), new Course(2)),
                new Student(new PersonName("Grace"), new PersonName("Grace"), new PersonName("Grace"), new Group(1), new Course(2)),
                new Student(new PersonName("Bob"), new PersonName("Bob"), new PersonName("Bob"), new Group(1), new Course(2)),
                new Student(new PersonName("Frank"), new PersonName("Frank"), new PersonName("Frank"), new Group(2), new Course(1))
        };

        // Filtered by "e"
        Student[] filteredStudents = new Student[]{
                new Student(new PersonName("Alice"), new PersonName("Alice"), new PersonName("Alice"), new Group(2), new Course(1)),
                new Student(new PersonName("Emma"), new PersonName("Emma"), new PersonName("Emma"), new Group(1), new Course(1)),
                new Student(new PersonName("Henry"), new PersonName("Henry"), new PersonName("Henry"), new Group(2), new Course(2)),
                new Student(new PersonName("Grace"), new PersonName("Grace"), new PersonName("Grace"), new Group(1), new Course(2)),
        };

        var filter = new StudentSearchFilterBuilder().addSearchTerm("e").build();

        return Arguments.of(initialStudents, filteredStudents, filter);
    }

    private static Arguments provideStudents_Arguments_Variant2_FilterByGroup() {
        Student[] initialStudents = new Student[]{
                new Student(new PersonName("John"), new PersonName("John"), new PersonName("John"), new Group(1), new Course(1)),
                new Student(new PersonName("Alice"), new PersonName("Alice"), new PersonName("Alice"), new Group(2), new Course(1)),
                new Student(new PersonName("Emma"), new PersonName("Emma"), new PersonName("Emma"), new Group(1), new Course(1)),
                new Student(new PersonName("David"), new PersonName("David"), new PersonName("David"), new Group(2), new Course(2)),
                new Student(new PersonName("Henry"), new PersonName("Henry"), new PersonName("Henry"), new Group(2), new Course(2)),
                new Student(new PersonName("Grace"), new PersonName("Grace"), new PersonName("Grace"), new Group(1), new Course(2)),
                new Student(new PersonName("Bob"), new PersonName("Bob"), new PersonName("Bob"), new Group(1), new Course(2)),
                new Student(new PersonName("Frank"), new PersonName("Frank"), new PersonName("Frank"), new Group(2), new Course(1))
        };

        // Filtered by group = 1
        Student[] filteredStudents = new Student[]{
                new Student(new PersonName("John"), new PersonName("John"), new PersonName("John"), new Group(1), new Course(1)),
                new Student(new PersonName("Emma"), new PersonName("Emma"), new PersonName("Emma"), new Group(1), new Course(1)),
                new Student(new PersonName("Grace"), new PersonName("Grace"), new PersonName("Grace"), new Group(1), new Course(2)),
                new Student(new PersonName("Bob"), new PersonName("Bob"), new PersonName("Bob"), new Group(1), new Course(2))
        };

        var filter = new StudentSearchFilterBuilder().addGroup(new Group(1)).build();

        return Arguments.of(initialStudents, filteredStudents, filter);
    }

    private static Arguments provideStudents_Arguments_Variant3_FilterByCourse() {
        Student[] initialStudents = new Student[]{
                new Student(new PersonName("John"), new PersonName("John"), new PersonName("John"), new Group(1), new Course(1)),
                new Student(new PersonName("Alice"), new PersonName("Alice"), new PersonName("Alice"), new Group(2), new Course(1)),
                new Student(new PersonName("Emma"), new PersonName("Emma"), new PersonName("Emma"), new Group(1), new Course(1)),
                new Student(new PersonName("David"), new PersonName("David"), new PersonName("David"), new Group(2), new Course(2)),
                new Student(new PersonName("Henry"), new PersonName("Henry"), new PersonName("Henry"), new Group(2), new Course(2)),
                new Student(new PersonName("Grace"), new PersonName("Grace"), new PersonName("Grace"), new Group(1), new Course(2)),
                new Student(new PersonName("Bob"), new PersonName("Bob"), new PersonName("Bob"), new Group(1), new Course(2)),
                new Student(new PersonName("Frank"), new PersonName("Frank"), new PersonName("Frank"), new Group(2), new Course(1))
        };

        // Filtered by course = 1
        Student[] filteredStudents = new Student[]{
                new Student(new PersonName("John"), new PersonName("John"), new PersonName("John"), new Group(1), new Course(1)),
                new Student(new PersonName("Alice"), new PersonName("Alice"), new PersonName("Alice"), new Group(2), new Course(1)),
                new Student(new PersonName("Emma"), new PersonName("Emma"), new PersonName("Emma"), new Group(1), new Course(1)),
                new Student(new PersonName("Frank"), new PersonName("Frank"), new PersonName("Frank"), new Group(2), new Course(1))
        };

        var filter = new StudentSearchFilterBuilder().addCourse(new Course(1)).build();

        return Arguments.of(initialStudents, filteredStudents, filter);
    }

    private static Arguments provideStudents_Arguments_Variant4_FilterByCourseAndGroup() {
        Student[] initialStudents = new Student[]{
                new Student(new PersonName("John"), new PersonName("John"), new PersonName("John"), new Group(1), new Course(1)),
                new Student(new PersonName("Alice"), new PersonName("Alice"), new PersonName("Alice"), new Group(2), new Course(1)),
                new Student(new PersonName("Emma"), new PersonName("Emma"), new PersonName("Emma"), new Group(1), new Course(1)),
                new Student(new PersonName("David"), new PersonName("David"), new PersonName("David"), new Group(2), new Course(2)),
                new Student(new PersonName("Henry"), new PersonName("Henry"), new PersonName("Henry"), new Group(2), new Course(2)),
                new Student(new PersonName("Grace"), new PersonName("Grace"), new PersonName("Grace"), new Group(1), new Course(2)),
                new Student(new PersonName("Bob"), new PersonName("Bob"), new PersonName("Bob"), new Group(1), new Course(2)),
                new Student(new PersonName("Frank"), new PersonName("Frank"), new PersonName("Frank"), new Group(2), new Course(1))
        };

        // Filtered by course = 1 group = 1
        Student[] filteredStudents = new Student[]{
                new Student(new PersonName("John"), new PersonName("John"), new PersonName("John"), new Group(1), new Course(1)),
                new Student(new PersonName("Emma"), new PersonName("Emma"), new PersonName("Emma"), new Group(1), new Course(1)),
        };

        var filter = new StudentSearchFilterBuilder().addCourse(new Course(1)).addGroup(new Group(1)).build();

        return Arguments.of(initialStudents, filteredStudents, filter);
    }

    private static Arguments provideStudents_Arguments_Variant5_EmptyResult() {
        // Initial array of students
        Student[] initialStudents = new Student[]{
                new Student(new PersonName("John"), new PersonName("John"), new PersonName("John"), new Group(1), new Course(1)),
                new Student(new PersonName("Alice"), new PersonName("Alice"), new PersonName("Alice"), new Group(2), new Course(1)),
                new Student(new PersonName("Emma"), new PersonName("Emma"), new PersonName("Emma"), new Group(1), new Course(1)),
                new Student(new PersonName("David"), new PersonName("David"), new PersonName("David"), new Group(2), new Course(2)),
                new Student(new PersonName("Henry"), new PersonName("Henry"), new PersonName("Henry"), new Group(2), new Course(2)),
                new Student(new PersonName("Grace"), new PersonName("Grace"), new PersonName("Grace"), new Group(1), new Course(2)),
                new Student(new PersonName("Bob"), new PersonName("Bob"), new PersonName("Bob"), new Group(1), new Course(2)),
                new Student(new PersonName("Frank"), new PersonName("Frank"), new PersonName("Frank"), new Group(2), new Course(1))
        };

        // Empty array for filtered students
        Student[] filteredStudents = new Student[0];

        var filter = new StudentSearchFilterBuilder().addSearchTerm("sometesttexttogetemptyarray").build();

        return Arguments.of(initialStudents, filteredStudents, filter);
    }

    public static Stream<Arguments> provideStudents_WithSort() {
        return Stream.of(
                provideStudents_SortedByNameAscending(),
                provideStudents_SortedByNameDescending()
        );
    }

    private static Arguments provideStudents_SortedByNameAscending() {
        Student[] initialStudents = new Student[]{
                new Student(new PersonName("John"), new PersonName("John"), new PersonName("John"), new Group(1), new Course(3)),
                new Student(new PersonName("Alice"), new PersonName("Alice"), new PersonName("Alice"), new Group(2), new Course(1)),
                new Student(new PersonName("Emma"), new PersonName("Emma"), new PersonName("Emma"), new Group(1), new Course(2)),
                new Student(new PersonName("David"), new PersonName("David"), new PersonName("David"), new Group(2), new Course(4)),
                new Student(new PersonName("Henry"), new PersonName("Henry"), new PersonName("Henry"), new Group(2), new Course(4)),
                new Student(new PersonName("Grace"), new PersonName("Grace"), new PersonName("Grace"), new Group(1), new Course(1)),
                new Student(new PersonName("Bob"), new PersonName("Bob"), new PersonName("Bob"), new Group(1), new Course(2)),
                new Student(new PersonName("Frank"), new PersonName("Frank"), new PersonName("Frank"), new Group(2), new Course(3))
        };

        Student[] sortedStudents = Arrays.copyOf(initialStudents, initialStudents.length);
        Arrays.sort(sortedStudents, (s1, s2) -> getPib(s1).compareTo(getPib(s2)));

        var comparator = new ByNameAscendingPersonComparator();

        return Arguments.of(initialStudents, sortedStudents, comparator);
    }

    private static Arguments provideStudents_SortedByNameDescending() {
        Student[] initialStudents = new Student[]{
                new Student(new PersonName("John"), new PersonName("John"), new PersonName("John"), new Group(1), new Course(3)),
                new Student(new PersonName("Alice"), new PersonName("Alice"), new PersonName("Alice"), new Group(2), new Course(1)),
                new Student(new PersonName("Emma"), new PersonName("Emma"), new PersonName("Emma"), new Group(1), new Course(2)),
                new Student(new PersonName("David"), new PersonName("David"), new PersonName("David"), new Group(2), new Course(4)),
                new Student(new PersonName("Henry"), new PersonName("Henry"), new PersonName("Henry"), new Group(2), new Course(4)),
                new Student(new PersonName("Grace"), new PersonName("Grace"), new PersonName("Grace"), new Group(1), new Course(1)),
                new Student(new PersonName("Bob"), new PersonName("Bob"), new PersonName("Bob"), new Group(1), new Course(2)),
                new Student(new PersonName("Frank"), new PersonName("Frank"), new PersonName("Frank"), new Group(2), new Course(3))
        };

        Student[] sortedStudents = Arrays.copyOf(initialStudents, initialStudents.length);
        Arrays.sort(sortedStudents, (s1, s2) -> getPib(s2).compareTo(getPib(s1)));

        var comparator = new ByNameDescendingPersonComparator();

        return Arguments.of(initialStudents, sortedStudents, comparator);
    }

    private static String getPib(Student student) {
        return String.join(" ",
                student.getLastName().getValue(),
                student.getFirstName().getValue(),
                student.getMiddleName().getValue());
    }
}
