package main.model.entities.getters;

import main.model.entities.IRepositoryEntity;
import main.model.entities.Student;
import main.model.utils.filtering.SearchFilter;
import main.model.utils.filtering.StudentSearchFilter;
import main.model.utils.list.IMyList;
import main.model.utils.list.MyList;
import main.model.utils.sorting.IComparator;

public class StudentsGetter {
    public static <T extends IRepositoryEntity> IMyList<Student> getStudents(
            IMyList<T> innerEntities,
            SearchFilter<Student> filter,
            IComparator<Student> comparator){
        var result = new MyList<Student>();
        for(int i = 0; i < innerEntities.count(); i++){
            var filteredStudents = innerEntities.getAt(i).getStudents(filter);
            result.addRange(filteredStudents);
        }
        if(comparator != null){
            result.sort(comparator);
        }
        return result;
    }
}
