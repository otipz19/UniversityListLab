package main.ui.requests;

import DataInputUtil.main.ConsoleDataReader;
import DataInputUtil.main.ConsoleUtils;
import DataInputUtil.main.Option;
import main.model.utils.filtering.SearchFilter;
import main.model.utils.list.IMyList;
import main.model.utils.sorting.IComparator;

public abstract class GetRequest<T> {
    public void get(){
        ConsoleUtils.readOptions(
                new Option("Get all entities", this::getAll),
                new Option("Set filters and sorting", this::getWithFiltersAndSorting)
        );
    }

    protected abstract SearchFilter<T> buildFilter();

    protected abstract IComparator<T> buildComparator();

    protected abstract void runEntityMenu(T entity);

    protected abstract IMyList<T> getEntities(SearchFilter<T> filter, IComparator<T> comparator);

    protected boolean askQuestion(String question){
        return ConsoleDataReader
                .getLine(question + " [y/n]").toLowerCase().trim().startsWith("y");
    }

    private void getAll(){
        IMyList<T> entities = getEntities(null, null);
        runEntitiesList(entities);
    }

    private void getWithFiltersAndSorting(){
        SearchFilter<T> filter = null;
        IComparator<T> comparator = null;
        if(askQuestion("Include filtering?")){
            System.out.println("Set up filters");
            filter = buildFilter();
        }
        if(askQuestion("Include sorting?")){
            System.out.println("Set up sorting");
            comparator = buildComparator();
        }
        var faculties = getEntities(filter, comparator);
        runEntitiesList(faculties);
    }

    private void runEntitiesList(IMyList<T> entities){
        printList(entities);
        processEntityChoice(entities);
    }

    private void printList(IMyList<T> entities) {
        if (entities.count() == 0) {
            System.out.println("No entities available.");
        } else {
            printEntities("Entities found in total: " + entities.count(), entities);
            System.out.println("\n");
        }
    }

    private void processEntityChoice(IMyList<T> entities) {
        int index = validateIndex(entities);
        if(index == -1){
            return;
        }
        T entity = entities.getAt(index);
        runEntityMenu(entity);
    }

    private int validateIndex(IMyList<T> entities){
        int index = ConsoleDataReader
                .getInt("To open entity menu input it's index. To leave input 0: ") - 1;
        if (index < 0 || index >= entities.count()) {
            return -1;
        }
        return index;
    }

    private static <T> void printEntities(String header, IMyList<T> entities) {
        EntitiesPrinter.printEntities(header, entities);
    }
}
