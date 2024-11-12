package org.vanier.model;

import org.vanier.RegistrationSystem;
import org.vanier.factory.PersonFactory;

import java.util.ArrayList;
import java.util.List;

public class AdminModel {
    private RegistrationSystem registrationSystem = RegistrationSystem.getInstance();

    public void addCourse(CourseModel course) {
        registrationSystem.getCourseList().add(course);
        System.out.println("Course added: " + course.getCourseId());
    }

    // Update an existing course
    public boolean updateCourse(int courseId, CourseModel updatedCourse) {
        List<CourseModel> courses = registrationSystem.getCourseList();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseId() == courseId) {
                courses.set(i, updatedCourse);
                System.out.println("Course updated: " + updatedCourse.getCourseId());
                return true;
            }
        }
        System.out.println("Course with ID " + courseId + " not found.");
        return false;
    }

    // Delete a course
    public boolean deleteCourse(int courseId) {
        return registrationSystem.getCourseList().removeIf(course -> course.getCourseId() == courseId);
    }

    // Retrieve a list of students enrolled in a specific course
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

    // Generate a report on course enrollments
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
        return report.toString();
    }

    // Method for creating a new student
    public void createStudent(String firstName, String lastName, String phoneNumber, String emailAddress, String password) {
        StudentModel newStudent = (StudentModel) PersonFactory.createPerson("student", firstName, lastName, phoneNumber, emailAddress, password, null);
        registrationSystem.getStudentList().add(newStudent);
        System.out.println("Student created: " + newStudent.getFirstName() + " " + newStudent.getLastName());
    }

    // Method for creating a new teacher
    public void createTeacher(String firstName, String lastName, String phoneNumber, String emailAddress, String password, List<CourseModel> coursesTeaching) {
        TeacherModel newTeacher = (TeacherModel) PersonFactory.createPerson("teacher", firstName, lastName, phoneNumber, emailAddress, password, coursesTeaching);
        registrationSystem.getTeacherList().add(newTeacher);
        System.out.println("Teacher created: " + newTeacher.getFirstName() + " " + newTeacher.getLastName());
    }
}