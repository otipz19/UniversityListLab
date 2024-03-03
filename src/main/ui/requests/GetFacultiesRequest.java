package main.ui.requests;

import DataInputUtil.main.*;
import main.model.entities.Faculty;
import main.model.entities.University;
import main.model.utils.filtering.FacultySearchFilter;
import main.model.utils.filtering.SearchFilter;
import main.model.utils.list.IMyList;
import main.model.utils.sorting.IComparator;
import main.model.utils.sorting.comparators.ByNameAscendingFacultyComparator;
import main.model.utils.sorting.comparators.ByNameDescendingFacultyComparator;
import main.ui.menus.FacultyMenu;

public class GetFacultiesRequest extends GetRequest<Faculty> {
    private final University university;

    public GetFacultiesRequest(University university) {
        this.university = university;
    }

    @Override
    protected IMyList<Faculty> getEntities(SearchFilter<Faculty> filter, IComparator<Faculty> comparator) {
        return university.getFaculties();
    }

    @Override
    protected FacultySearchFilter buildFilter() {
        String term = ConsoleDataReader.getLine("Input search term: ");
        return new FacultySearchFilter(term);
    }

    protected IComparator<Faculty> buildComparator() {
        return ConsoleUtils.readOptions(
                new ReturnableOption<>("ASC by name", ByNameAscendingFacultyComparator::new),
                new ReturnableOption<>("DESC by name", ByNameDescendingFacultyComparator::new)
        );
    }

    @Override
    protected void runEntityMenu(Faculty faculty) {
        new FacultyMenu(faculty).start();
    }
}
