package org.vanier.model;

import org.vanier.RegistrationSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * The AdminModel class provides business logic for managing courses and retrieving enrollments.
 * It utilizes the RegistrationSystem to perform operations such as adding, updating, and deleting courses.
 */
public class AdminModel {
    private final RegistrationSystem registrationSystem = RegistrationSystem.getInstance();

    /**
     * Adds a new course to the registration system's course list.
     *
     * @param course The CourseModel object representing the course to be added.
     */
    public void addCourse(CourseModel course) {
        registrationSystem.getCourseList().add(course);
    }

    /**
     * Updates the details of an existing course in the registration system.
     *
     * @param courseId      The ID of the course to be updated.
     * @param updatedCourse The updated CourseModel object containing new course details.
     * @return True if the course was successfully updated; otherwise, false.
     */
    public boolean updateCourse(int courseId, CourseModel updatedCourse) {
        List<CourseModel> courses = registrationSystem.getCourseList();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseId() == courseId) {
                courses.set(i, updatedCourse);
                return true;
            }
        }
        return false;
    }

    /**
     * Deletes a course from the registration system by its course ID.
     *
     * @param courseId The ID of the course to be deleted.
     * @return True if the course was successfully deleted; otherwise, false.
     */
    public boolean deleteCourse(int courseId) {
        return registrationSystem.getCourseList().removeIf(course -> course.getCourseId() == courseId);
    }

    /**
     * Retrieves a list of students enrolled in a specific course by course ID.
     *
     * @param courseId The ID of the course for which to retrieve enrolled students.
     * @return A list of StudentModel objects representing students enrolled in the specified course.
     */
    public List<StudentModel> getStudentEnrollments(int courseId) {
        List<StudentModel> enrolledStudents = new ArrayList<>();
        List<StudentModel> students = registrationSystem.getStudentList();

        for (StudentModel student : students) {
            for (CourseModel course : student.getRegisteredCourses()) {
                if (course.getCourseId() == courseId) {
                    enrolledStudents.add(student);
                    break;
                }
            }
        }
        return enrolledStudents;
    }

    /**
     * Retrieves a course by its unique course ID.
     *
     * @param courseId The ID of the course to retrieve.
     * @return The CourseModel object if the course exists; otherwise, null.
     */
    public CourseModel getCourseById(int courseId) {
        return registrationSystem.getCourseList().stream()
                .filter(course -> course.getCourseId() == courseId)
                .findFirst()
                .orElse(null);
    }

    /**
     * Retrieves the list of all courses in the system.
     *
     * @return A list of CourseModel objects representing all courses.
     */
    public List<CourseModel> getAllCourses() {
        return registrationSystem.getCourseList();
    }
}
