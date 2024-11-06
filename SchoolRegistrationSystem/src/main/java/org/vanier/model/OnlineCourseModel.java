package org.vanier.model;

public class OnlineCourseModel extends CourseModel{
    private String courseOnlineLink;

    public OnlineCourseModel(String courseNumber, int courseSection, int courseCapacity, int courseCredits, String courseTime,
                             String dayOfWeek, String courseOnlineLink) {
        super(courseNumber, courseSection, courseCapacity, courseCredits, courseTime, dayOfWeek);
        this.courseOnlineLink = courseOnlineLink;
    }
}
