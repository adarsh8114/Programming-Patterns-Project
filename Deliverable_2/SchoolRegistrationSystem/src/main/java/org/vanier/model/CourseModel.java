package org.vanier.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CourseModel {
    private int courseId;
    private String courseNumber;
    private int courseSection;
    private int courseCapacity;
    private int currentEnrollementNumber;
    private int courseCredits;
    private int startTime;
    private int endTime;
    private List<StudentModel> enrolledStudents;
    private TeacherModel courseTeacher;
    private String dayOfWeek; //added day which is not on class diagram
    private static int counter = 1;

    public CourseModel(String courseNumber, int courseSection, int courseCapacity, int courseCredits, int startTime,
                       int endTime, String dayOfWeek) {
        courseId = counter++;
        this.courseNumber = courseNumber;
        this.courseSection = courseSection;
        this.courseCapacity = courseCapacity;
        this.courseCredits = courseCredits;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayOfWeek = dayOfWeek;
        this.enrolledStudents = new ArrayList<>();
    }

    /**
     * checks to see if course is at full capacity
     *
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

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getCourseId() {
        return courseId;
    }

    public List<StudentModel> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<StudentModel> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public int getCourseSection() {
        return courseSection;
    }

    public void setCourseSection(int courseSection) {
        this.courseSection = courseSection;
    }

    public int getCourseCapacity() {
        return courseCapacity;
    }

    public void setCourseCapacity(int courseCapacity) {
        this.courseCapacity = courseCapacity;
    }

    public int getCourseCredits() {
        return courseCredits;
    }

    public void setCourseCredits(int courseCredits) {
        this.courseCredits = courseCredits;
    }

    public TeacherModel getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(TeacherModel courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public static int getCounter() {
        return counter;
    }

    /**
     * checks to see if the current course is conflicting in day or time with any courses in the list
     *
     * @param list the list to see if there is any conflicting courses
     * @return if it is conflicting
     */
    public boolean isAnyConflictingCourse(Collection<CourseModel> list) {
        for (CourseModel courseModel : list) {
            if (this.dayOfWeek.equals(courseModel.dayOfWeek)) {
                return (this.startTime < courseModel.endTime) && (this.endTime > courseModel.startTime);
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "courseId=" + courseId + ", courseNumber=" + courseNumber + ", courseSection=" + courseSection +
                ", courseCredits=" + courseCredits + ", courseTime=" + startTime + " to " + endTime + ", courseTeacher=" + courseTeacher +
                ", dayOfWeek=" + dayOfWeek + ", Course Is Full=" + isCourseAtCapacity();
    }
}
