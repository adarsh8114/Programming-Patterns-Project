package org.vanier.model;

public class InPersonCourseModel extends CourseModel {
    private String courseRoomNumber;

    public InPersonCourseModel(String courseNumber, int courseSection, int courseCapacity, int courseCredits, int startTime,
                               int endTime, String dayOfWeek, String courseRoomNumber) {
        super(courseNumber, courseSection, courseCapacity, courseCredits, startTime, endTime, dayOfWeek);
        this.courseRoomNumber = courseRoomNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "type=In Person, courseRoomNumber= " + courseRoomNumber;
    }
}
