package org.vanier.model;

import org.vanier.RegistrationSystem;
import org.vanier.factory.PersonFactory;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class AdminModel {
    private RegistrationSystem registrationSystem = RegistrationSystem.getInstance();

    /**
     * Adds a new course to the registration system.
     *
     * @param course The course to be added.
     */
    public void addCourse(CourseModel course) {
        registrationSystem.getCourseList().add(course);
        JOptionPane.showMessageDialog(null, "Course added: " + course.getCourseId(), "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Updates an existing course in the registration system.
     *
     * @param courseId The ID of the course to be updated.
     * @param updatedCourse The updated course information.
     * @return True if the course was successfully updated, otherwise false.
     */
    public boolean updateCourse(int courseId, CourseModel updatedCourse) {
        List<CourseModel> courses = registrationSystem.getCourseList();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseId() == courseId) {
                courses.set(i, updatedCourse);
                JOptionPane.showMessageDialog(null, "Course updated: " + updatedCourse.getCourseId(), "Success", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Course with ID " + courseId + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    /**
     * Deletes a course from the registration system.
     *
     * @param courseId The ID of the course to be deleted.
     * @return True if the course was successfully deleted, otherwise false.
     */
    public boolean deleteCourse(int courseId) {
        boolean removed = registrationSystem.getCourseList().removeIf(course -> course.getCourseId() == courseId);
        if (removed) {
            JOptionPane.showMessageDialog(null, "Course deleted: " + courseId, "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Course with ID " + courseId + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return removed;
    }

    /**
     * Retrieves a list of students enrolled in a specific course.
     *
     * @param courseId The ID of the course for which to retrieve enrollments.
     * @return A list of students enrolled in the specified course.
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

        StringBuilder enrollments = new StringBuilder("Viewing enrollments for course ID " + courseId + "\n");
        for (StudentModel student : enrolledStudents) {
            enrollments.append(" - ").append(student.getFirstName()).append(" ").append(student.getLastName()).append(" (Student ID: ").append(student.getId()).append(")\n");
        }
        JOptionPane.showMessageDialog(null, enrollments.toString(), "Enrollments", JOptionPane.INFORMATION_MESSAGE);
        return enrolledStudents;
    }

    /**
     * Generates a report on course enrollments.
     *
     * @return A string representation of the enrollment report.
     */
    public String generateEnrollmentReport() {
        StringBuilder report = new StringBuilder("Enrollment Report:\n");
        List<CourseModel> courses = registrationSystem.getCourseList();

        for (CourseModel course : courses) {
            report.append(" (ID: ").append(course.getCourseId()).append(")\n");

            List<StudentModel> enrolledStudents = getStudentEnrollments(course.getCourseId());
            report.append("Enrolled Students:\n");
            for (StudentModel student : enrolledStudents) {
                report.append(" - ").append(student.getFirstName()).append(" ").append(student.getLastName())
                        .append(" (Student ID: ").append(student.getId()).append(")\n");
            }
            report.append("\n");
        }
        JOptionPane.showMessageDialog(null, report.toString(), "Enrollment Report", JOptionPane.INFORMATION_MESSAGE);
        return report.toString();
    }

    /**
     * Creates a new student and adds them to the registration system.
     *
     * @param firstName The first name of the student.
     * @param lastName The last name of the student.
     * @param phoneNumber The phone number of the student.
     * @param emailAddress The email address of the student.
     * @param password The password for the student.
     */
    public void createStudent(String firstName, String lastName, String phoneNumber, String emailAddress, String password) {
        StudentModel newStudent = (StudentModel) PersonFactory.createPerson("student", firstName, lastName, phoneNumber, emailAddress, password, null);
        registrationSystem.getStudentList().add(newStudent);
        JOptionPane.showMessageDialog(null, "Student created: " + newStudent.getFirstName() + " " + newStudent.getLastName(), "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Creates a new teacher and adds them to the registration system.
     *
     * @param firstName The first name of the teacher.
     * @param lastName The last name of the teacher.
     * @param phoneNumber The phone number of the teacher.
     * @param emailAddress The email address of the teacher.
     * @param password The password for the teacher.
     * @param coursesTeaching The list of courses the teacher is teaching.
     */
    public void createTeacher(String firstName, String lastName, String phoneNumber, String emailAddress, String password, List<CourseModel> coursesTeaching) {
        TeacherModel newTeacher = (TeacherModel) PersonFactory.createPerson("teacher", firstName, lastName, phoneNumber, emailAddress, password, coursesTeaching);
        registrationSystem.getTeacherList().add(newTeacher);
        JOptionPane.showMessageDialog(null, "Teacher created: " + newTeacher.getFirstName() + " " + newTeacher.getLastName(), "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public CourseModel getCourseById(int courseId) {
        for (CourseModel course : registrationSystem.getCourseList()) {
            if (course.getCourseId() == courseId) {
                return course;
            }
        }
        return null; // Return null if no course is found with the given ID
    }
}