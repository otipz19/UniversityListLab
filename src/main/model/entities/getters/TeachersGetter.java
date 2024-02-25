package main.model.entities.getters;

import main.model.entities.IRepositoryEntity;
import main.model.entities.Teacher;
import main.model.utils.filtering.TeacherSearchFilter;
import main.model.utils.list.IMyList;
import main.model.utils.list.MyList;

public class TeachersGetter {
    public static <T extends IRepositoryEntity> IMyList<Teacher> getTeachers(TeacherSearchFilter filter, IMyList<T> innerEntities){
        var result = new MyList<Teacher>();
        for(int i = 0; i < innerEntities.count(); i++){
            var filteredTeachers = innerEntities.getAt(i).getTeachers(filter);
            result.addRange(filteredTeachers);
        }
        return result;
    }
}
