package main.ui.requests;

import DataInputUtil.main.ConsoleDataReader;
import DataInputUtil.main.ConsoleUtils;
import DataInputUtil.main.ReturnableOption;
import main.model.entities.Cathedra;
import main.model.entities.Faculty;
import main.model.utils.filtering.CathedraSearchFilter;
import main.model.utils.filtering.SearchFilter;
import main.model.utils.list.IMyList;
import main.model.utils.sorting.IComparator;
import main.model.utils.sorting.comparators.*;
import main.ui.menus.CathedraMenu;
/**
 * This class is used to represent a get cathedras request.
 * It is a public class because it is used in other packages.
 */
public class GetCathedrasRequest extends GetRequest<Cathedra> {
    private final Faculty faculty;
    /**
     * This constructor is used to create a get cathedras request.
     * @param faculty - the faculty
     * @return - the get cathedras request
     */
    public GetCathedrasRequest(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    protected SearchFilter<Cathedra> buildFilter() {
        String term = ConsoleDataReader.getLine("Input search term: ");
        return new CathedraSearchFilter(term);
    }

    @Override
    protected IComparator<Cathedra> buildComparator() {
        return ConsoleUtils.readOptions(
                new ReturnableOption<>("ASC by name", ByNameAscendingCathedraComparator::new),
                new ReturnableOption<>("DESC by name", ByNameDescendingCathedraComparator::new)
        );
    }

    @Override
    protected void runEntityMenu(Cathedra entity) {
        new CathedraMenu(entity).start();
    }

    @Override
    protected IMyList<Cathedra> getEntities(SearchFilter<Cathedra> filter, IComparator<Cathedra> comparator) {
        return faculty.getCathedras(filter, comparator);
    }
}
