package org.vanier.model;

import java.util.*;

public class StudentModel extends PersonModel {
    private int numberCoursesRegistered;
    private boolean isFullTime;
    private Set<CourseModel> registeredCourses;

    public StudentModel(String firstName, String lastName, String phoneNumber, String emailAddress, String password) {
        super(firstName, lastName, phoneNumber, emailAddress, password);
        numberCoursesRegistered = 0;
        this.isFullTime = false;
        this.registeredCourses = new TreeSet<>(new Comparator<CourseModel>() {
            private final Map<String, Integer> dayOrder = Map.of(
                    "Monday", 1,
                    "Tuesday", 2,
                    "Wednesday", 3,
                    "Thursday", 4,
                    "Friday", 5
            );

            @Override
            public int compare(CourseModel c1, CourseModel c2) {
                return (dayOrder.get(c1.getDayOfWeek()) - dayOrder.get(c2.getDayOfWeek())) * 100 +
                        c1.getStartTime() - c2.getStartTime();
            }
        });
    }


    /**
     * gets the student status based on if they are full time or not
     *
     * @return the full or part time status of student
     */
    public String getStudentStatus() {
        if (isFullTime) {
            return "You are currently a full time student";
        }
        return "You are currently a part time student!";
    }

    /**
     * increases the number of courses that they are registered and change full time status if they have registered for
     * 4 or more courses
     */
    public void increaseCourseRegistered() {
        numberCoursesRegistered++;
        if (numberCoursesRegistered >= 4) {
            isFullTime = true;
        }
    }

    /**
     * decreases the number of courses that they are registered and changes full time status if they have registered for
     * 3 or less courses
     */
    public void decreaseCourseRegistered() {
        numberCoursesRegistered--;
        if (numberCoursesRegistered < 4) {
            isFullTime = false;
        }
    }

    /**
     * this checks to see if the id and password is the correct one and associated with this student
     *
     * @param id       the id of the student
     * @param password the password of the student
     * @return if it is the correct password and id
     */
    public boolean verifyStudentLogin(int id, String password) {
        return getId() == id && getPassword().equals(password);
    }

    public Set<CourseModel> getRegisteredCourses() {
        return registeredCourses;
    }
}
