package org.vanier;

import org.vanier.model.CourseModel;
import org.vanier.model.StudentModel;
import org.vanier.model.TeacherModel;

import java.util.ArrayList;
import java.util.List;

public class RegistrationSystem {
    private List<StudentModel> studentList;
    private List<CourseModel> courseList;
    private List<TeacherModel> teacherList;
    private static RegistrationSystem registrationSystem;

    private RegistrationSystem() {
        studentList = new ArrayList<>();
        courseList = new ArrayList<>();
        teacherList = new ArrayList<>();
    }

    /**
     * get or creates a new instance of the registrationSystem
     *
     * @return the singular registration system instnace
     */
    public static RegistrationSystem getInstance() {
        if (registrationSystem == null) {
            synchronized (RegistrationSystem.class) {
                if (registrationSystem == null) {
                    registrationSystem = new RegistrationSystem();
                }
            }
        }
        return registrationSystem;
    }

    public List<StudentModel> getStudentList() {
        return studentList;
    }

    public List<CourseModel> getCourseList() {
        return courseList;
    }
}
