package org.vanier.model;

public class OnlineCourseModel extends CourseModel {
    private String courseOnlineLink;

    public OnlineCourseModel(String courseNumber, int courseSection, int courseCapacity, int courseCredits, int startTime,
                             int endTime, String dayOfWeek, String courseOnlineLink) {
        super(courseNumber, courseSection, courseCapacity, courseCredits, startTime, endTime, dayOfWeek);
        this.courseOnlineLink = courseOnlineLink;
    }

    @Override
    public String toString() {
        return super.toString() + "type=Online, courseOnlineLink= " + courseOnlineLink;
    }
}
