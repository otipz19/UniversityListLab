package main.ui.requests;

import main.model.entities.IRepositoryEntity;
import main.model.entities.Student;

public class GetStudentsRequest extends GetRequest<Student> {
    private IRepositoryEntity repository;

    public GetStudentsRequest(IRepositoryEntity repository){
        this.repository = repository;
    }


    @Override
    public void get() {

    }
}
