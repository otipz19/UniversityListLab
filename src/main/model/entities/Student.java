package main.model.entities;

import main.model.utils.Guard;
import main.model.valueObjects.Course;
import main.model.valueObjects.Group;
import main.model.valueObjects.PersonName;

public class Student extends Person{
    private Group group;
    private Course course;

    public Student(PersonName firstName,
                   PersonName middleName,
                   PersonName lastName,
                   Group group,
                   Course course) {
        super(firstName, middleName, lastName);
        Guard.againstNull(group);
        Guard.againstNull(course);
        this.group = group;
        this.course = course;
    }

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

    @Override
    public String toString(){
        return super.toString() + " Group: " + group + " Course: " + course;
    }
}
