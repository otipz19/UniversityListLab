package main.model.entities;

import main.model.utils.Guard;
import main.model.valueObjects.Course;
import main.model.valueObjects.Group;
import main.model.valueObjects.PersonName;
/*
 * This class is a concrete class that is used to represent a student.
 */
public class Student extends Person{
    private Group group;
    private Course course;
    /*
     * This method is used to create a student.
     * @param firstName - the first name of the student
     * @param middleName - the middle name of the student
     * @param lastName - the last name of the student
     * @param group - the group of the student
     * @param course - the course of the student
     * @return - the student
     */
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
    /*
     * This method is used to get the group of the student.
     * @return - the group of the student
     */
    public Group getGroup() {
        return group;
    }
    /*
     * This method is used to set the group of the student.
     * @param group - the group of the student
     */
    public void setGroup(Group group) {
        Guard.againstNull(group);
        this.group = group;
    }
    /*
     * This method is used to get the course of the student.
     * @return - the course of the student
     */
    public Course getCourse() {
        return course;
    }
    /*
     * This method is used to set the course of the student.
     * @param course - the course of the student
     */
    public void setCourse(Course course) {
        Guard.againstNull(course);
        this.course = course;
    }
    /*
     * This method is used to get the string representation of the student.
     * @return - the string representation of the student
     */
    @Override
    public String toString(){
        return super.toString() + " Group: " + group + " Course: " + course;
    }
}
