package main.model.entities.getters;

import main.model.entities.IRepositoryEntity;
import main.model.entities.Student;
import main.model.utils.filtering.StudentSearchFilter;
import main.model.utils.list.IMyList;
import main.model.utils.list.MyList;

public class StudentsGetter {
    //TODO: Sorting have to be implemented
    public static <T extends IRepositoryEntity> IMyList<Student> getStudents(StudentSearchFilter filter, IMyList<T> innerEntities){
        var result = new MyList<Student>();
        for(int i = 0; i < innerEntities.count(); i++){
            var filteredStudents = innerEntities.getAt(i).getStudents(filter);
            result.addRange(filteredStudents);
        }
        return result;
    }
}
