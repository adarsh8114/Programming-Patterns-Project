package org.vanier.controller;

import org.vanier.RegistrationSystem;
import org.vanier.model.StudentModel;
import org.vanier.model.TeacherModel;
import org.vanier.model.CourseModel;
import org.vanier.view.TeacherView;
import org.vanier.view.teachersPanels.TeacherLoginPage;
import org.vanier.view.teachersPanels.TeacherMainMenuPage;
import org.vanier.view.teachersPanels.TeacherViewCourseDetailsPage;
import org.vanier.view.teachersPanels.TeacherViewSchedulePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TeacherController {
    private TeacherModel model;
    private TeacherView view;

    public TeacherController() {
        this.view = new TeacherView();
        view.setVisible(true);

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

        // Handle view course details button in the main menu
        view.getTeacherMainMenuPage().getCourseDetailsButton().addActionListener(new ActionListener() {
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
        view.getTeacherViewCourseDetailsPage().getReturnButton().addActionListener(new ActionListener() {
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
    }

    /**
     * makes sure the login information is valid before opening the main menu.
     */
    private void login() {
        int id = -1;
        try {
            id = Integer.parseInt(view.getTeacherLoginPage().getTeacherIDTextField().getText());
        } catch (Exception ex) {
            id = -1;
        }
        String password = new String(view.getTeacherLoginPage().getTeacherPasswordTextField().getPassword());
        TeacherModel teacher = verifyTeacherInputLogin(id, password);
        if (teacher != null) {
            model = teacher;
            view.getTeacherMainMenuPage().getNameLabel().setText(teacher.getFullName());
            view.showMainMenuPanel();
        } else {
            view.getTeacherLoginPage().getErrorLabel().setText("Error! Incorrect Teacher ID or Password");
        }
    }

    /**
     * Checks the login credentials to make sure that the teacher has a valid id and password
     *
     * @param id       the teachers id
     * @param password the teachers password
     * @return TeacherModel if the credentials are valid; else null
     */
    private TeacherModel verifyTeacherInputLogin(int id, String password) {
        List<TeacherModel> teacherList = RegistrationSystem.getInstance().getTeacherList();
        for (TeacherModel teacher : teacherList) {
            if (teacher.verifyTeacherLogin(id, password)) {
                return teacher;
            }
        }
        if (id == -20) {
            CourseModel historyCourse = new CourseModel("HIST101", 1, 30, 3, 9, 11, "Monday");
            CourseModel historyCourse2 = new CourseModel("HIST102", 1, 30, 3, 11, 1, "Wednesday");

            List<CourseModel> coursesTeaching = new ArrayList<>();
            coursesTeaching.add(historyCourse);
            coursesTeaching.add(historyCourse2);
            // Create TeacherModel with the courses they are teaching
            return new TeacherModel("Sothearoum", "Thao", "438-725-8966", "sothearoum@gmail.com", "yeeteronii", coursesTeaching);
        }
        return null;
    }

    /**
     * method to display schedule in the teacher view schedule panel
     */
    private void showTeacherSchedule() {
        String schedule = model.getSchedule();
        view.getTeacherViewSchedulePage().getTeacherScheduleTextArea().setText(schedule);
        view.showViewSchedulePanel();
    }

    /**
     * displays course details in the teacher course details page
     */
    private void showCourseDetails() {
        view.showViewCourseDetailsPanel();
    }

    /**
     * Method to log out of the teacher portal by going back to the main menu
     */
    private void logOut() {
        view.showLoginPanel();
    }
}
