package main.model.utils.filtering;

import main.model.utils.Guard;

public abstract class SearchFilter<T> {
    protected String searchTerm;

    protected SearchFilter(String searchTerm){
        this.searchTerm = searchTerm.toLowerCase();
    }

    public abstract boolean appliesTo(T entity);
}
