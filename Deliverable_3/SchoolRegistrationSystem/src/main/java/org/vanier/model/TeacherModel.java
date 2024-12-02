package org.vanier.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TeacherModel extends PersonModel {
    private List<CourseModel> coursesTeaching;

    public TeacherModel(String firstName, String lastName, String phoneNumber, String emailAddress, String password, List<CourseModel> coursesTeaching) {
        super(firstName, lastName, phoneNumber, emailAddress, password);
        this.coursesTeaching = coursesTeaching;
    }

    public List<CourseModel> getCoursesTeaching() {
        return coursesTeaching;
    }

    @Override
    public String toString() {
        return "TeacherModel{" +
                "fullName=" + getFullName() +
                ", coursesTeaching=" + coursesTeaching +
                '}';
    }
}
