package main.model.utils.filtering;

import main.model.entities.Person;

public abstract class PersonSearchFilter extends SearchFilter<Person>{
    protected PersonSearchFilter(String searchTerm) {
        super(searchTerm);
    }

    @Override
    public boolean appliesTo(Person entity){
        return applies(entity, searchTerm);
    }

    //This is made to avoid incorrect type erasure with StudentSearchFilter
    static boolean applies(Person entity, String searchTerm){
        return entity.getFirstName().contains(searchTerm)
                || entity.getMiddleName().contains(searchTerm)
                || entity.getLastName().contains(searchTerm);
    }
}
