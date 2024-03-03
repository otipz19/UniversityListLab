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

    public GetFacultiesRequest(University university){
        this.university = university;
    }

    @Override
    protected IMyList<Faculty> getEntities(SearchFilter<Faculty> filter, IComparator<Faculty> comparator) {
        return university.getFaculties();
    }

    @Override
    protected  FacultySearchFilter buildFilter(){
        System.out.println("Set up filters");
        String term = ConsoleDataReader.getLine("Enter search term: ");
        return new FacultySearchFilter(term);
    }

    protected IComparator<Faculty> buildComparator(){
        System.out.println("Set up sorting");
        return ConsoleUtils.readOptions(
                new ReturnableOption<>("Ascending by name", ByNameAscendingFacultyComparator::new),
                new ReturnableOption<>("Descending by name", ByNameDescendingFacultyComparator::new)
        );
    }

    @Override
    protected void runEntityMenu(IMyList<Faculty> faculties, int index) {
        Faculty selectedFaculty = faculties.getAt(index);
        FacultyMenu facultyMenu = new FacultyMenu(selectedFaculty);
        facultyMenu.start();
    }
}
