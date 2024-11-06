package org.vanier.model;

import java.util.ArrayList;
import java.util.List;

public class CourseModel {
    private int courseId;
    private String courseNumber;
    private int courseSection;
    private int courseCapacity;
    private int currentEnrollementNumber;
    private int courseCredits;
    private String courseTime;
    private List<StudentModel> enrolledStudents;
    private TeacherModel courseTeacher;
    private String dayOfWeek; //added day which is not on class diagram
    private static int counter = 1;

    public CourseModel(String courseNumber, int courseSection, int courseCapacity, int courseCredits, String courseTime,
                       String dayOfWeek) {
        courseId = counter++;
        this.courseNumber = courseNumber;
        this.courseSection = courseSection;
        this.courseCapacity = courseCapacity;
        this.courseCredits = courseCredits;
        this.courseTime = courseTime;
        this.dayOfWeek = dayOfWeek;
        this.enrolledStudents = new ArrayList<>();
    }

    /**
     * checks to see if course is at full capacity
     * @return if course is full
     */
    public boolean isCourseAtCapacity() {
        return currentEnrollementNumber > courseCapacity;
    }

    public int getCurrentEnrollementNumber() {
        return currentEnrollementNumber;
    }

    public void setCurrentEnrollementNumber(int currentEnrollementNumber) {
        this.currentEnrollementNumber = currentEnrollementNumber;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public int getCourseId() {
        return courseId;
    }
}
