package org.vanier.controller;

import org.vanier.factory.PersonFactory;
import org.vanier.model.AdminModel;
import org.vanier.model.CourseModel;
import org.vanier.model.StudentModel;
import org.vanier.model.TeacherModel;
import org.vanier.view.AdminManagementView;
import org.vanier.view.adminPanels.AdminViewStudentEnrollmentPage;

import javax.swing.*;
import java.util.List;

public class AdminManagementController {
    private final AdminManagementView adminManagementView;
    private final AdminModel adminModel = new AdminModel();

    public AdminManagementController(AdminManagementView adminManagementView) {
        this.adminManagementView = adminManagementView;
        setupMainAdminViewListeners();
    }

    private void setupMainAdminViewListeners() {
        adminManagementView.getViewEnrollmentsButton().addActionListener(e -> openViewStudentEnrollmentPage());
        adminManagementView.getAddCourseButton().addActionListener(e -> addCourse());
        adminManagementView.getUpdateCourseButton().addActionListener(e -> updateCourse());
        adminManagementView.getDeleteCourseButton().addActionListener(e -> deleteCourse());
        adminManagementView.getGenerateReportButton().addActionListener(e -> generateReport());
        adminManagementView.getAddStudentButton().addActionListener(e -> addStudent());
        adminManagementView.getAddTeacherButton().addActionListener(e -> addTeacher());
    }

    private void openViewStudentEnrollmentPage() {
        AdminViewStudentEnrollmentPage enrollmentPage = new AdminViewStudentEnrollmentPage();
        setupViewStudentEnrollmentListeners(enrollmentPage);

        JFrame enrollmentFrame = new JFrame("Student Enrollment");
        enrollmentFrame.setSize(600, 400);
        enrollmentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        enrollmentFrame.add(enrollmentPage);
        enrollmentFrame.setVisible(true);
    }

    private void setupViewStudentEnrollmentListeners(AdminViewStudentEnrollmentPage enrollmentPage) {
        enrollmentPage.getViewStudentEnrollmentButton().addActionListener(e -> viewStudentEnrollments(enrollmentPage));
        enrollmentPage.getReturnToPreviousPageButton().addActionListener(e -> {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(enrollmentPage);
            if (parentFrame != null) {
                parentFrame.dispose();
            }
        });
    }

    private void viewStudentEnrollments(AdminViewStudentEnrollmentPage enrollmentPage) {
        JTextArea enrollmentTextArea = enrollmentPage.getEnrollmentTextArea();
        try {
            int courseId = Integer.parseInt(enrollmentPage.getCourseIdTextField().getText().trim());
            List<StudentModel> enrolledStudents = adminModel.getStudentEnrollments(courseId);

            if (enrolledStudents.isEmpty()) {
                enrollmentTextArea.setText("No students enrolled for Course ID: " + courseId);
            } else {
                enrollmentTextArea.setText("Enrolled Students for Course ID: " + courseId + "\n");
                for (StudentModel student : enrolledStudents) {
                    enrollmentTextArea.append(student.getFirstName() + " " + student.getLastName() + " (ID: " + student.getId() + ")\n");
                }
            }
        } catch (NumberFormatException ex) {
            enrollmentTextArea.setText("");
            JOptionPane.showMessageDialog(enrollmentPage, "Please enter a valid numeric Course ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addTeacher() {
        try {
            String firstName = JOptionPane.showInputDialog("Enter First Name:");
            String lastName = JOptionPane.showInputDialog("Enter Last Name:");
            String phoneNumber = JOptionPane.showInputDialog("Enter Phone Number:");
            String emailAddress = JOptionPane.showInputDialog("Enter Email Address:");
            String password = JOptionPane.showInputDialog("Enter Password:");

            TeacherModel teacher = (TeacherModel) PersonFactory.createPerson("Teacher", firstName, lastName, phoneNumber, emailAddress, password, null);
            adminModel.addTeacher(teacher);

            JOptionPane.showMessageDialog(adminManagementView, "Teacher added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(adminManagementView, "Error adding teacher. Please check the input values.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addStudent() {
        try {
            String firstName = JOptionPane.showInputDialog("Enter First Name:");
            String lastName = JOptionPane.showInputDialog("Enter Last Name:");
            String phoneNumber = JOptionPane.showInputDialog("Enter Phone Number:");
            String emailAddress = JOptionPane.showInputDialog("Enter Email Address:");
            String password = JOptionPane.showInputDialog("Enter Password:");

            StudentModel student = (StudentModel) PersonFactory.createPerson("Student", firstName, lastName, phoneNumber, emailAddress, password, null);
            adminModel.addStudent(student);

            JOptionPane.showMessageDialog(adminManagementView, "Student added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(adminManagementView, "Error adding student. Please check the input values.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addCourse() {
        try {
            String courseNumber = JOptionPane.showInputDialog("Enter Course Number:");
            int courseSection = Integer.parseInt(JOptionPane.showInputDialog("Enter Course Section:"));
            int courseCapacity = Integer.parseInt(JOptionPane.showInputDialog("Enter Course Capacity:"));
            int courseCredits = Integer.parseInt(JOptionPane.showInputDialog("Enter Course Credits:"));
            int startTime = Integer.parseInt(JOptionPane.showInputDialog("Enter Start Time (e.g., 900 for 9:00 AM):"));
            int endTime = Integer.parseInt(JOptionPane.showInputDialog("Enter End Time (e.g., 1700 for 5:00 PM):"));
            String dayOfWeek = JOptionPane.showInputDialog("Enter Day of the Week:");

            CourseModel course = new CourseModel(courseNumber, courseSection, courseCapacity, courseCredits, startTime, endTime, dayOfWeek);
            adminModel.addCourse(course);

            JOptionPane.showMessageDialog(adminManagementView, "Course added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(adminManagementView, "Invalid input. Please enter numeric values where required.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateCourse() {
        try {
            int courseId = Integer.parseInt(JOptionPane.showInputDialog("Enter Course ID to update:"));
            CourseModel existingCourse = adminModel.getCourseById(courseId);

            if (existingCourse == null) {
                JOptionPane.showMessageDialog(adminManagementView, "Course not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String courseNumber = JOptionPane.showInputDialog("Enter Updated Course Number:", existingCourse.getCourseNumber());
            int courseSection = Integer.parseInt(JOptionPane.showInputDialog("Enter Updated Course Section:", existingCourse.getCourseSection()));
            int courseCapacity = Integer.parseInt(JOptionPane.showInputDialog("Enter Updated Course Capacity:", existingCourse.getCourseCapacity()));
            int courseCredits = Integer.parseInt(JOptionPane.showInputDialog("Enter Updated Course Credits:", existingCourse.getCourseCredits()));
            int startTime = Integer.parseInt(JOptionPane.showInputDialog("Enter Updated Start Time:", existingCourse.getStartTime()));
            int endTime = Integer.parseInt(JOptionPane.showInputDialog("Enter Updated End Time:", existingCourse.getEndTime()));
            String dayOfWeek = JOptionPane.showInputDialog("Enter Updated Day of Week:", existingCourse.getDayOfWeek());

            CourseModel updatedCourse = new CourseModel(courseNumber, courseSection, courseCapacity, courseCredits, startTime, endTime, dayOfWeek);
            boolean success = adminModel.updateCourse(courseId, updatedCourse);

            JOptionPane.showMessageDialog(adminManagementView, success ? "Course updated successfully." : "Error updating course.", "Update Status", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(adminManagementView, "Invalid input. Please enter numeric values where required.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteCourse() {
        try {
            int courseId = Integer.parseInt(JOptionPane.showInputDialog("Enter Course ID to delete:"));
            boolean success = adminModel.deleteCourse(courseId);

            JOptionPane.showMessageDialog(adminManagementView, success ? "Course deleted successfully." : "Error deleting course.", "Delete Status", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(adminManagementView, "Invalid input. Please enter a numeric Course ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void generateReport() {
        StringBuilder report = new StringBuilder("Enrollment Report:\n");

        List<CourseModel> courses = adminModel.getAllCourses();
        for (CourseModel course : courses) {
            report.append("Course ID: ").append(course.getCourseId()).append(" - ").append(course.getCourseNumber()).append("\n");

            List<StudentModel> students = adminModel.getStudentEnrollments(course.getCourseId());
            if (students.isEmpty()) {
                report.append("   No students enrolled.\n");
            } else {
                report.append("   Enrolled Students:\n");
                for (StudentModel student : students) {
                    report.append("      - ").append(student.getFirstName()).append(" ").append(student.getLastName())
                            .append(" (ID: ").append(student.getId()).append(")\n");
                }
            }
            report.append("\n");
        }

        JOptionPane.showMessageDialog(adminManagementView, report.toString(), "Enrollment Report", JOptionPane.INFORMATION_MESSAGE);
    }
}