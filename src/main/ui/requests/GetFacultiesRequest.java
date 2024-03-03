package main.ui.requests;

import DataInputUtil.main.*;
import main.model.entities.Faculty;
import main.model.entities.University;
import main.model.utils.filtering.FacultySearchFilter;
import main.model.utils.list.IMyList;
import main.model.utils.sorting.IComparator;
import main.model.utils.sorting.comparators.ByNameAscendingFacultyComparator;
import main.model.utils.sorting.comparators.ByNameDescendingFacultyComparator;
import main.ui.menus.FacultyMenu;

public class GetFacultiesRequest extends Request{
    private final University university;

    public GetFacultiesRequest(University university){
        this.university = university;
    }

    public void get(){
        ConsoleUtils.readOptions(
                new Option("Get all faculties", this::getAllFaculties),
                new Option("Set filters and sorting", this::getWithFiltersAndSorting)
        );
    }

    private void getAllFaculties(){
        IMyList<Faculty> faculties = university.getFaculties();
        runFacultiesList(faculties);
    }

    private void getWithFiltersAndSorting(){
        FacultySearchFilter filter = null;
        IComparator<Faculty> comparator = null;
        if(ConsoleDataReader.getLine("Include filtering? [y/n]").toLowerCase().trim().startsWith("y")){
            filter = buildFilter();
        }
        if(ConsoleDataReader.getLine("Include sorting? [y/n]").toLowerCase().trim().startsWith("y")){
            comparator = buildComparator();
        }
        var faculties = university.getFaculties(filter, comparator);
        runFacultiesList(faculties);
    }

    private static FacultySearchFilter buildFilter(){
        System.out.println("Set up filters");
        String term = ConsoleDataReader.getLine("Enter search term: ");
        return new FacultySearchFilter(term);
    }

    private static IComparator<Faculty> buildComparator(){
        System.out.println("Set up sorting");
        return ConsoleUtils.readOptions(
                new ReturnableOption<>("Ascending by name", ByNameAscendingFacultyComparator::new),
                new ReturnableOption<>("Descending by name", ByNameDescendingFacultyComparator::new)
        );
    }

    private void runFacultiesList(IMyList<Faculty> faculties){
        printList(faculties);
        processFacultyChoice(faculties);
    }

    private void printList(IMyList<Faculty> faculties) {
        if (faculties.count() == 0) {
            System.out.println("No faculties available.");
        } else {
            printEntities("Faculties found in total: " + faculties.count(), faculties);
            System.out.println("\n");
        }
    }

    private void processFacultyChoice(IMyList<Faculty> faculties) {
        int index = validateIndex(faculties);
        if(index == -1){
            return;
        }
        runFacultyMenu(faculties, index);
    }

    private int validateIndex(IMyList<Faculty> faculties){
        int facultyIndex = ConsoleDataReader
                .getInt("To open faculty menu input it's index. To leave input 0: ") - 1;
        if (facultyIndex < 0 || facultyIndex >= faculties.count()) {
            return -1;
        }
        return facultyIndex;
    }

    private void runFacultyMenu(IMyList<Faculty> faculties, int index) {
        Faculty selectedFaculty = faculties.getAt(index);
        FacultyMenu facultyMenu = new FacultyMenu(selectedFaculty);
        facultyMenu.start();
    }
}
