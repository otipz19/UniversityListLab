package main.model.entities;

import main.model.valueObjects.Course;
import main.model.valueObjects.Group;

public class Student extends Person{
    private Group group;
    private Course course;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
