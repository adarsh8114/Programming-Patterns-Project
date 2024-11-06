package org.vanier.model;

public class InPersonCourseModel extends CourseModel{
    private String courseRoomNumber;

    public InPersonCourseModel(String courseNumber, int courseSection, int courseCapacity, int courseCredits, String courseTime,
                               String dayOfWeek, String courseRoomNumber) {
        super(courseNumber, courseSection, courseCapacity, courseCredits, courseTime, dayOfWeek);
        this.courseRoomNumber = courseRoomNumber;
    }
}
