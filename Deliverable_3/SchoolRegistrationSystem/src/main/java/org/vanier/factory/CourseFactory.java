package org.vanier.factory;

import org.vanier.model.CourseModel;
import org.vanier.model.InPersonCourseModel;
import org.vanier.model.OnlineCourseModel;

public class CourseFactory {

    /**
     * creates a certain type of course with all its attributes
     * @param courseType the course type to create (in person, online)
     * @param courseNumber the course number
     * @param courseSection the course section
     * @param courseCapacity the course capacity
     * @param courseCredits the course credits
     * @param startTime the start time
     * @param endTime the end time
     * @param dayOfWeek the day of the week
     * @param location the location
     * @return the course which is a person or online course
     */
    public static CourseModel createCourse(String courseType, String courseNumber, int courseSection, int courseCapacity,
                                           int courseCredits, int startTime, int endTime, String dayOfWeek, String location) {
        if (courseType.equalsIgnoreCase("inPersonCourse")) {
            return new InPersonCourseModel(courseNumber, courseSection, courseCapacity, courseCredits, startTime, endTime,
                                            dayOfWeek, location);
        } else {
            return new OnlineCourseModel(courseNumber, courseSection, courseCapacity, courseCredits, startTime, endTime,
                    dayOfWeek, location);
        }
    }
}
