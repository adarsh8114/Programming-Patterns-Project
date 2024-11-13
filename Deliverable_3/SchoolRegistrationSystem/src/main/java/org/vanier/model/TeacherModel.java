package org.vanier.model;

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

    public void setCoursesTeaching(List<CourseModel> coursesTeaching) {
        this.coursesTeaching = coursesTeaching;
    }

    /**
     * Verifies teacher login credentials.
     *
     * @param id       the teacher ID
     * @param password the teacher password
     * @return true if credentials match, false otherwise
     */
    public boolean verifyTeacherLogin(int id, String password) {
        return this.getId() == id && this.getPassword().equals(password);
    }

    /**
     * Generates a formatted schedule string.
     *
     * @return a string of the teacher's schedule with day and time details
     */
    public String getSchedule() {
        if (coursesTeaching == null || coursesTeaching.isEmpty()) {
            return "No courses assigned.";
        }
        return coursesTeaching.stream()
                .map(course -> course.getCourseId() + " - Section: " + course.getCourseSection() +
                        " on " + course.getDayOfWeek() + " from " + course.getStartTime() + " to " + course.getEndTime())
                .collect(Collectors.joining("\n"));
    }

    /**
     * Checks if the teacher is teaching a particular course.
     *
     * @param courseId the ID of the course to check
     * @return true if the teacher is teaching the course, false otherwise
     */
    public boolean isTeachingCourse(int courseId) {
        return coursesTeaching.stream().anyMatch(course -> course.getCourseId() == courseId);
    }

    /**
     * Checks if adding a new course would create a schedule conflict.
     *
     * @param newCourse the course to check for conflicts
     * @return true if there is a conflict, false otherwise
     */
    public boolean hasScheduleConflict(CourseModel newCourse) {
        return coursesTeaching.stream().anyMatch(course -> course.isAnyConflictingCourse(List.of(newCourse)));
    }

    @Override
    public String toString() {
        return "TeacherModel{" +
                "fullName=" + getFullName() +
                ", coursesTeaching=" + coursesTeaching +
                '}';
    }
}