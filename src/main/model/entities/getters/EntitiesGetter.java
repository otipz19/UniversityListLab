package main.model.entities.getters;

import main.model.utils.filtering.SearchFilter;
import main.model.utils.list.IMyList;
import main.model.utils.list.MyList;
import main.model.utils.sorting.IComparator;

public class EntitiesGetter {
    public static <T> IMyList<T> getEntities(
            IMyList<T> entities,
            SearchFilter<T> filter,
            IComparator<T> comparator) {
        var filteredEntities = new MyList<T>();
        for(int i = 0; i < entities.count(); i++){
            T cur = entities.getAt(i);
            if(filter == null || filter.appliesTo(cur)){
                filteredEntities.add(cur);
            }
        }
        if(comparator != null){
            filteredEntities.sort(comparator);
        }
        return filteredEntities;
    }
}
