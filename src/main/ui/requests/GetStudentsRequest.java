package main.ui.requests;

import DataInputUtil.main.ConsoleDataReader;
import DataInputUtil.main.ConsoleUtils;
import DataInputUtil.main.ReturnableOption;
import main.model.entities.IRepositoryEntity;
import main.model.entities.Student;
import main.model.utils.filtering.SearchFilter;
import main.model.utils.filtering.StudentSearchFilterBuilder;
import main.model.utils.list.IMyList;
import main.model.utils.sorting.IComparator;
import main.model.utils.sorting.comparators.*;
import main.model.valueObjects.Course;
import main.model.valueObjects.Group;
import main.ui.menus.StudentMenu;
import main.ui.readers.ValueObjectReader;

import static DataInputUtil.main.ConsoleUtils.askQuestion;

public class GetStudentsRequest extends GetRequest<Student> {
    private final IRepositoryEntity repository;

    public GetStudentsRequest(IRepositoryEntity repository) {
        this.repository = repository;
    }

    @Override
    protected SearchFilter<Student> buildFilter() {
        var filterBuilder = new StudentSearchFilterBuilder();
        if (askQuestion("Add filter by name?")) {
            String term = ConsoleDataReader.getLine("Input search term: ");
            filterBuilder.addSearchTerm(term);
        }
        if (askQuestion("Add filter by group?")) {
            Group group = ValueObjectReader.readGroup("Input group: ");
            filterBuilder.addGroup(group);
        }
        if (askQuestion("Add filter by course?")) {
            Course course = ValueObjectReader.readCourse("Input course: ");
            filterBuilder.addCourse(course);
        }
        return filterBuilder.build();
    }

    @Override
    protected IComparator<Student> buildComparator() {
        return ConsoleUtils.readOptions(
                new ReturnableOption<>("ASC by name", ByNameAscendingStudentComparator::new),
                new ReturnableOption<>("DESC by name", ByNameDescendingStudentComparator::new),
                new ReturnableOption<>("ASC by course", ByCourseAscendingStudentComparator::new),
                new ReturnableOption<>("DESC by course", ByCourseDescendingStudentComparator::new),
                new ReturnableOption<>("ASC by group", ByGroupAscendingStudentComparator::new),
                new ReturnableOption<>("DESC by group", ByGroupDescendingStudentComparator::new)
        );
    }

    @Override
    protected void runEntityMenu(Student student) {
        new StudentMenu(student).start();
    }

    @Override
    protected IMyList<Student> getEntities(SearchFilter<Student> filter, IComparator<Student> comparator) {
        return repository.getStudents(filter, comparator);
    }
}
