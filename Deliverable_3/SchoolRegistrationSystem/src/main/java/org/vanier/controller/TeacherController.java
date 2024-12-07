package org.vanier.controller;

import org.vanier.model.CourseModel;
import org.vanier.model.RegistrationSystem;
import org.vanier.model.StudentModel;
import org.vanier.model.TeacherModel;
import org.vanier.view.TeacherView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TeacherController {
    private TeacherModel model;
    private TeacherView view;
    private ResourceBundle resourceBundle;

    public TeacherController() {
        this.view = new TeacherView();
        this.resourceBundle = RegistrationSystem.getInstance().getResourceBundle();
        view.changeLanguage(resourceBundle);
        view.setVisible(true);

        // Button to go back to main form
        view.getTeacherLoginPage().getGoBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goBack();
            }
        });

        // Handle login confirmation
        view.getTeacherLoginPage().getLoginConfirmButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        // Handle view schedule button in the main menu
        view.getTeacherMainMenuPage().getViewScheduleButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTeacherSchedule();
            }
        });

        // Handle view course teaching button in the main menu
        view.getTeacherMainMenuPage().getCourseDetailsButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCourseTeaching();
            }
        });

        // Handle view course details button
        view.getTeacherViewCourseTeachingPage().getViewDetailsButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCourseDetails();
            }
        });

        // Handle logout button in the main menu
        view.getTeacherMainMenuPage().getLogOutButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logOut();
            }
        });

        // Return buttons in different panels to go back to main menu
        view.getTeacherViewCourseTeachingPage().getReturnButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.showMainMenuPanel();
            }
        });

        view.getTeacherViewSchedulePage().getReturnButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.showMainMenuPanel();
            }
        });

        // return button in course detail page to go back to course teaching page
        view.getTeacherViewCourseDetailsPage().getReturnButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.showViewCourseTeachingPanel();
            }
        });
    }

    /**
     * Validates login information against the database and loads the main menu.
     */
    private void login() {
        int id;
        try {
            id = Integer.parseInt(view.getTeacherLoginPage().getTeacherIDTextField().getText());
        } catch (NumberFormatException ex) {
            id = -1;
        }
        String password = new String(view.getTeacherLoginPage().getTeacherPasswordTextField().getPassword());

        TeacherModel teacher = verifyTeacherInputLogin(id, password);
        if (teacher != null) {
            model = teacher;
            System.out.println("Logged-in Teacher ID: " + model.getId());
            view.getTeacherMainMenuPage().getNameLabel().setText(teacher.getFullName());
            view.showMainMenuPanel();
        } else {
            // Use resourceBundle to set error message
            view.getTeacherLoginPage().getErrorLabel().setText(resourceBundle.getString("teacherLoginErrorLabel"));
        }
    }


    /**
     * Verifies teacher credentials using the database.
     */
    public TeacherModel verifyTeacherInputLogin(int id, String password) {
        String query = "SELECT * FROM Teacher WHERE TEACHER_ID = ? AND PASSWORD = ?";
        try (Connection conn = DatabaseController.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Debug log
                System.out.println("Login successful for Teacher ID: " + rs.getInt("TEACHER_ID"));

                // Create and return TeacherModel with the correct ID
                TeacherModel teacher = new TeacherModel(
                        rs.getString("FIRST_NAME"),
                        rs.getString("LAST_NAME"),
                        rs.getString("PHONE_NUMBER"),
                        rs.getString("EMAIL_ADDRESS"),
                        rs.getString("PASSWORD"),
                        new ArrayList<>() // Placeholder for courses
                );
                teacher.setId(rs.getInt("TEACHER_ID")); // Set the ID
                return teacher;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Displays the teacher's schedule by fetching it from the database.
     */
    private void showTeacherSchedule() {
        try {
            String query = "SELECT COURSE_DAY_OF_WEEK, COURSE_START_TIME, COURSE_END_TIME, COURSE_NUMBER, COURSE_TYPE FROM Course WHERE TEACHER_ID = ?";
            try (Connection conn = DatabaseController.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setInt(1, model.getId());
                ResultSet rs = stmt.executeQuery();

                StringBuilder schedule = new StringBuilder();
                while (rs.next()) {
                    schedule.append(rs.getString("COURSE_DAY_OF_WEEK")).append(", ")
                            .append(rs.getString("COURSE_START_TIME")).append(" - ")
                            .append(rs.getString("COURSE_END_TIME")).append(": ")
                            .append(rs.getString("COURSE_TYPE")).append("\n");
                }

                if (schedule.isEmpty()) {
                    schedule.append(resourceBundle.getString("teacherScheduleNoCourses"));
                }

                view.getTeacherViewSchedulePage().getTeacherScheduleTextArea().setText(schedule.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            view.getTeacherViewSchedulePage().getTeacherScheduleTextArea().setText(resourceBundle.getString("teacherScheduleErrorLabel"));
        }
        view.showViewSchedulePanel();
    }


    /**
     * Displays the teacher's courses from the database.
     */
    private void showCourseTeaching() {
        try {
            view.getTeacherViewCourseTeachingPage().getCoursesList().setListData(new String[0]); // Clear old data
            System.out.println("Cleared old data from JList.");

            List<CourseModel> courses = getCoursesForTeacher(model.getId());
            List<String> courseList = new ArrayList<>();

            for (CourseModel course : courses) {
                courseList.add(course.getCourseId() + " - " + course.getCourseNumber() + " " + course.getCourseSection());
            }

            if (courseList.isEmpty()) {
                view.getTeacherViewCourseTeachingPage().getErrorLabel().setText(resourceBundle.getString("teacherCourseTeachingErrorLabel"));
                System.out.println("No courses found for Teacher ID: " + model.getId());
            } else {
                JList<String> courseJList = view.getTeacherViewCourseTeachingPage().getCoursesList();
                courseJList.setListData(courseList.toArray(new String[0]));
                System.out.println("Updated JList with courses.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            view.getTeacherViewCourseTeachingPage().getErrorLabel().setText(resourceBundle.getString("teacherCourseTeachingErrorLabel"));
        }
        view.showViewCourseTeachingPanel();
    }

    /**
     * helper method to retrieve the courses that matches the current logged-in user's id
     *
     * @param teacherId the id we want to match
     * @return the list of courses taught by that teacher
     */
    private List<CourseModel> getCoursesForTeacher(int teacherId) {
        List<CourseModel> courses = new ArrayList<>();
        String query = """
                    SELECT c.*
                    FROM Course c
                    INNER JOIN Teacher t ON c.TEACHER_ID = t.TEACHER_ID
                    WHERE t.TEACHER_ID = ?
                """;

        try (Connection conn = DatabaseController.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, teacherId); // Pass the currently logged-in teacher's ID
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                CourseModel course = new CourseModel(
                        rs.getString("COURSE_NUMBER"),
                        rs.getInt("COURSE_SECTION"),
                        rs.getInt("COURSE_CAPACITY"),
                        rs.getInt("COURSE_CREDITS"),
                        rs.getInt("COURSE_START_TIME"),
                        rs.getInt("COURSE_END_TIME"),
                        rs.getString("COURSE_DAY_OF_WEEK")
                );
                course.setCourseId(rs.getInt("COURSE_ID"));
                course.setCurrentEnrollementNumber(rs.getInt("CURRENT_ENROLLMENT_NUMBER"));
                courses.add(course);

                // Debug: Log each retrieved course
                System.out.println("Fetched Course: " + course.getCourseId() + " - " + course.getCourseNumber());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Debug: Log the size of the course list
        System.out.println("Total courses retrieved for Teacher ID " + teacherId + ": " + courses.size());
        return courses;
    }

    /**
     * method to show students who are registered to a course
     */

    private void showCourseDetails() {
        String selectedCourse = (String) view.getTeacherViewCourseTeachingPage().getCoursesList().getSelectedValue();
        if (selectedCourse == null || !selectedCourse.contains("-")) {
            view.getTeacherViewCourseTeachingPage().getErrorLabel().setText(resourceBundle.getString("teacherCourseDetailsInvalidSelection"));
            return;
        }

        String courseIdString = selectedCourse.split(" - ")[0];
        int courseId;
        try {
            courseId = Integer.parseInt(courseIdString);
        } catch (NumberFormatException e) {
            view.getTeacherViewCourseTeachingPage().getErrorLabel().setText(resourceBundle.getString("teacherCourseDetailsInvalidId"));
            return;
        }

        try {
            List<CourseModel> courses = DatabaseController.readCourses();
            CourseModel matchedCourse = null;
            for (CourseModel course : courses) {
                if (course.getCourseId() == courseId) {
                    matchedCourse = course;
                    break;
                }
            }

            if (matchedCourse == null) {
                view.getTeacherViewCourseTeachingPage().getErrorLabel().setText(resourceBundle.getString("teacherCourseDetailsNotFound"));
                return;
            }

            List<StudentModel> students = matchedCourse.getEnrolledStudents();
            List<String[]> studentData = new ArrayList<>();
            for (StudentModel student : students) {
                studentData.add(new String[]{
                        String.valueOf(student.getId()),
                        student.getFirstName(),
                        student.getLastName()
                });
            }

            JTable courseTable = view.getTeacherViewCourseDetailsPage().getCourseDetailTable();
            String[] columnNames = {"Student ID", "First Name", "Last Name"};
            String[][] tableData = studentData.toArray(new String[0][]);

            courseTable.setModel(new javax.swing.table.AbstractTableModel() {
                @Override
                public int getRowCount() {
                    return tableData.length;
                }

                @Override
                public int getColumnCount() {
                    return columnNames.length;
                }

                @Override
                public Object getValueAt(int rowIndex, int columnIndex) {
                    return tableData[rowIndex][columnIndex];
                }

                @Override
                public String getColumnName(int column) {
                    return columnNames[column];
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            view.getTeacherViewCourseDetailsPage().getCourseSelectedLabel().setText(resourceBundle.getString("teacherCourseDetailsErrorLabel"));
        }
        view.showViewCourseDetailsPanel();
    }

    /**
     * Logs out the teacher and returns to the login panel.
     */
    private void logOut() {
        model = null; // Clear the teacher model
        view.showLoginPanel();
    }

    /**
     * method to go back from the login page to the main form
     */
    private void goBack() {
        System.out.println("Navigating back to the main form.");
        view.dispose();
    }

    /**
     * method to change language errors
     * @param resourceBundle the resource bundle to use to translate
     */
    public void changeLanguage(ResourceBundle resourceBundle) {
        view.changeLanguage(resourceBundle);
        System.out.println("Language changed to: " + resourceBundle.getLocale());
    }
}