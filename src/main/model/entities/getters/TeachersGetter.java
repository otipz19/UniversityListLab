package main.model.entities.getters;

import main.model.entities.IRepositoryEntity;
import main.model.entities.Teacher;
import main.model.utils.filtering.SearchFilter;
import main.model.utils.filtering.TeacherSearchFilter;
import main.model.utils.list.IMyList;
import main.model.utils.list.MyList;
import main.model.utils.sorting.IComparator;

public class TeachersGetter {
    public static <T extends IRepositoryEntity> IMyList<Teacher> getTeachers(
            IMyList<T> innerEntities,
            SearchFilter<Teacher> filter,
            IComparator<Teacher> comparator){
        var result = new MyList<Teacher>();
        for(int i = 0; i < innerEntities.count(); i++){
            var filteredTeachers = innerEntities.getAt(i).getTeachers(filter);
            result.addRange(filteredTeachers);
        }
        if(comparator != null){
            result.sort(comparator);
        }
        return result;
    }
}
