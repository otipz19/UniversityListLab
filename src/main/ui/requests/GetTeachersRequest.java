package main.ui.requests;

import DataInputUtil.main.ConsoleDataReader;
import DataInputUtil.main.ConsoleUtils;
import DataInputUtil.main.ReturnableOption;
import main.model.entities.IRepositoryEntity;
import main.model.entities.Teacher;
import main.model.utils.filtering.SearchFilter;
import main.model.utils.filtering.TeacherSearchFilter;
import main.model.utils.list.IMyList;
import main.model.utils.sorting.IComparator;
import main.model.utils.sorting.comparators.ByNameAscendingTeacherComparator;
import main.model.utils.sorting.comparators.ByNameDescendingTeacherComparator;
import main.ui.menus.TeacherMenu;

public class GetTeachersRequest extends GetRequest<Teacher> {
    private final IRepositoryEntity repository;

    public GetTeachersRequest(IRepositoryEntity repository) {
        this.repository = repository;
    }

    @Override
    protected SearchFilter<Teacher> buildFilter() {
        String term = ConsoleDataReader.getLine("Input search term: ");
        return new TeacherSearchFilter(term);
    }

    @Override
    protected IComparator<Teacher> buildComparator() {
        return ConsoleUtils.readOptions(
                new ReturnableOption<>("ASC by name", ByNameAscendingTeacherComparator::new),
                new ReturnableOption<>("DESC by name", ByNameDescendingTeacherComparator::new)
        );
    }

    @Override
    protected void runEntityMenu(Teacher entity) {
        new TeacherMenu(entity).start();
    }

    @Override
    protected IMyList<Teacher> getEntities(SearchFilter<Teacher> filter, IComparator<Teacher> comparator) {
        return repository.getTeachers(filter, comparator);
    }
}
