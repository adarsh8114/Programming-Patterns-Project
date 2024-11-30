package org.vanier.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class RegistrationSystem {
    private List<StudentModel> studentList;
    private List<CourseModel> courseList;
    private List<TeacherModel> teacherList;
    private List<AdminModel> adminList;
    private static RegistrationSystem registrationSystem;
    private Locale locale = Locale.of("en", "CA"); // Updated constructor
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("Messages", locale);

    public static void main(String[] args) {
        System.out.println(getInstance().resourceBundle.getString("welcomeStudentLoginPage"));
    }

    private RegistrationSystem() {
        studentList = new ArrayList<>();
        courseList = new ArrayList<>();
        teacherList = new ArrayList<>();
    }

    public List<StudentModel> getEnrolledStudentsByCourseId(int courseId) {
        List<StudentModel> enrolledStudents = new ArrayList<>();
        for (StudentModel student : studentList) {
            for (CourseModel course : student.getRegisteredCourses()) {
                if (course.getCourseId() == courseId) {
                    enrolledStudents.add(student);
                    break;
                }
            }
        }
        return enrolledStudents;
    }

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

    public void setStudentList(List<StudentModel> studentList) {
        this.studentList = studentList;
    }

    public void setCourseList(List<CourseModel> courseList) {
        this.courseList = courseList;
    }

    public void setTeacherList(List<TeacherModel> teacherList) {
        this.teacherList = teacherList;
    }

    public List<TeacherModel> getTeacherList() {
        return teacherList;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle("Messages", locale);
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }
}