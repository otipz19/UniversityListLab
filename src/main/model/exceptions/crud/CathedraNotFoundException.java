package main.model.exceptions.crud;

import main.model.entities.Cathedra;

public class CathedraNotFoundException extends NotFoundException{
    public CathedraNotFoundException(Cathedra cathedra){
        super(cathedra);
    }
}
