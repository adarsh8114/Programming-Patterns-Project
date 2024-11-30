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
        ResourceBundle messages = RegistrationSystem.getInstance().getResourceBundle();

        if (isFullTime) {
            return messages.getString("full_time_student");
        }
        return messages.getString("part_time_student");
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

    public int getNumberCoursesRegistered() {
        return numberCoursesRegistered;
    }

    public void setNumberCoursesRegistered(int numberCoursesRegistered) {
        isFullTime = numberCoursesRegistered >= 4;
        this.numberCoursesRegistered = numberCoursesRegistered;
    }

    public void setFullTime(boolean fullTime) {
        isFullTime = fullTime;
    }

    public void setRegisteredCourses(Set<CourseModel> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentModel that = (StudentModel) o;
        return super.equals(o) && numberCoursesRegistered == that.numberCoursesRegistered && isFullTime == that.isFullTime && Objects.equals(registeredCourses, that.registeredCourses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberCoursesRegistered, isFullTime, registeredCourses);
    }
}
