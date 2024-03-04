package main.ui.requests;

import DataInputUtil.main.ConsoleDataReader;
import DataInputUtil.main.ConsoleUtils;
import DataInputUtil.main.Option;
import main.model.utils.filtering.SearchFilter;
import main.model.utils.list.IMyList;
import main.model.utils.sorting.IComparator;
/**
 * This class is used to represent a get request.
 * It is a public class because it is used in other packages.
 */
public abstract class GetRequest<T> {
    public void get(){
        ConsoleUtils.readOptions(
                System.out::println,
                new Option("Get all entities", this::getAll),
                new Option("Set filters and sorting", this::getWithFiltersAndSorting)
        );
    }

    protected abstract SearchFilter<T> buildFilter();

    protected abstract IComparator<T> buildComparator();

    protected abstract void runEntityMenu(T entity);
    /**
     * This method is used to get entities.
     * @param filter - the filter
     * @param comparator - the comparator
     * @return - the entities
     */
    protected abstract IMyList<T> getEntities(SearchFilter<T> filter, IComparator<T> comparator);

    private void getAll(){
        IMyList<T> entities = getEntities(null, null);
        runEntitiesList(entities);
    }
    /**
     * This method is used to get with filters and sorting.
     */
    private void getWithFiltersAndSorting(){
        SearchFilter<T> filter = null;
        IComparator<T> comparator = null;
        if(ConsoleUtils.askQuestion("Include filtering?")){
            System.out.println("Set up filters");
            filter = buildFilter();
        }
        if(ConsoleUtils.askQuestion("Include sorting?")){
            System.out.println("Set up sorting");
            comparator = buildComparator();
        }
        var faculties = getEntities(filter, comparator);
        runEntitiesList(faculties);
    }
    /**
     * This method is used to run entities list.
     * @param entities - the entities
     */
    private void runEntitiesList(IMyList<T> entities){
        printList(entities);
        processEntityChoice(entities);
    }
    /**
     * This method is used to print list.
     * @param entities - the entities
     */
    private void printList(IMyList<T> entities) {
        if (entities.count() == 0) {
            System.out.println("No entities available.\n");
        } else {
            printEntities("Entities found in total: " + entities.count(), entities);
            System.out.println();
        }
    }
    /**
     * This method is used to process entity choice.
     * @param entities - the entities
     */
    private void processEntityChoice(IMyList<T> entities) {
        int index = getValidIndex(entities);
        if(index == -1){
            return;
        }
        T entity = entities.getAt(index);
        runEntityMenu(entity);
    }

    private int getValidIndex(IMyList<T> entities){
        int index = ConsoleDataReader
                .getInt("To open entity menu input it's index. To leave input 0: ") - 1;
        if (index < 0 || index >= entities.count()) {
            return -1;
        }
        return index;
    }
    /**
     * This method is used to print entities.
     * @param header - the header
     * @param entities - the entities
     */
    private static <T> void printEntities(String header, IMyList<T> entities) {
        EntitiesPrinter.printEntities(header, entities);
    }
}
