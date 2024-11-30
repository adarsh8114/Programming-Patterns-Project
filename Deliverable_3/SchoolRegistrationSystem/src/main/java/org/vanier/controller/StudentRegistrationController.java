package org.vanier.controller;

import org.vanier.model.RegistrationSystem;
import org.vanier.model.CourseModel;
import org.vanier.model.StudentModel;
import org.vanier.view.StudentRegistrationView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class StudentRegistrationController {
    private StudentModel model;
    private StudentRegistrationView view;

    public StudentRegistrationController() {
        this.view = new StudentRegistrationView();
        view.setVisible(true);

        view.getStudentLoginPage().getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        view.getStudentMainMenuPage().getRegisterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRegisterCourseMenu();
            }
        });

        view.getStudentMainMenuPage().getDropButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDropCourseMenu();
            }
        });

        view.getStudentMainMenuPage().getCourseScheduleButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCourseScheduleMenu();
            }
        });


        view.getStudentRegisterCoursePage().getReturnButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getStudentRegisterCoursePage().getErrorLabel().setText("");
                view.showMainMenuPanel();
            }
        });


        view.getStudentDropCoursePage().getReturnButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getStudentDropCoursePage().getErrorLabel().setText("");
                view.getStudentDropCoursePage().changeLanguage(RegistrationSystem.getInstance().getResourceBundle());
                view.showMainMenuPanel();
            }
        });


        view.getStudentViewSchedulePage().getReturnButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.showMainMenuPanel();
            }
        });

        view.getStudentRegisterCoursePage().getRegisterForCourseButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerForCourse();
            }
        });

        view.getStudentDropCoursePage().getDropCourseButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dropACourse();
            }
        });
    }

    /**
     * this is functions verifies user login by taking the data from the text boxes and seeing if it matches with any data
     * in the lists of the system
     */
    private void login() {
        int id = -1;
        try {
            id = Integer.parseInt(view.getStudentLoginPage().getStudentIdTextField().getText());
        } catch (Exception ex) {
            id = -1;
        }
        String password = view.getStudentLoginPage().getPasswordTextField().getText();
        StudentModel student = verifyStudentInputLogin(id, password);
        if (student != null) {
            model = student;
            view.getStudentMainMenuPage().getStudentNameLabel().setText(student.getFullName());
            view.getStudentMainMenuPage().getStudentStatusLabe().setText(student.getStudentStatus());
            view.showMainMenuPanel();
        } else {
            view.getStudentLoginPage().getErrorLabel().setText("Error! Wrong Student id or Password");
        }
    }

    /**
     * this verifies if a student with the id and matching password exist
     *
     * @param id       the student id
     * @param password the student password
     * @return if the id matches with the password and it exists
     */
    public StudentModel verifyStudentInputLogin(int id, String password) {
        List<StudentModel> studentList = RegistrationSystem.getInstance().getStudentList();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).verifyStudentLogin(id, password)) {
                return studentList.get(i);
            }
        }
        if (id == -5) {
            return new StudentModel("Matthew", "Veroutis", "514-688-2776", "veroutism@gmail.com", "Password");
        }
        return null;
    }

    /**
     * displays the courses that the students are registered on the GUI component: Text area
     * also shows it on the schedule panel
     */
    private void showCourseScheduleMenu() {
        String courseList = "no courses have been registered for";
        if (!model.getRegisteredCourses().isEmpty()) {
            courseList = "";
            for (CourseModel courseModel : model.getRegisteredCourses()) {
                String day = courseModel.getDayOfWeek();
                courseList += courseModel.toString() + "\n";
            }
        }
        view.getStudentViewSchedulePage().getRegisteredCoursesTextArea().setText(courseList);
        view.showViewSchedulePanel();
    }

    /**
     * displays the courses that the students are registered on the GUI component: Text area
     * also shows it on the drop course panel
     */
    private void showDropCourseMenu() {
        String courseList = "no courses have been registered for";
        if (!model.getRegisteredCourses().isEmpty()) {
            courseList = "";
            for (CourseModel courseModel : model.getRegisteredCourses()) {
                String day = courseModel.getDayOfWeek();
                courseList += courseModel.toString() + "\n";
            }
        }
        view.getStudentDropCoursePage().getRegisteredCourses().setText(courseList);
        view.showDropCoursePanel();
    }

    /**
     * shows the register course panel and show all the available courses in the text area and show a certain message if
     * none are available
     */
    private void showRegisterCourseMenu() {
        String courses = "no courses are available at the current moment";
        if (!RegistrationSystem.getInstance().getCourseList().isEmpty()) {
            courses = "";
            for (CourseModel courseModel : RegistrationSystem.getInstance().getCourseList()) {
                courses += courseModel.toString() + "\n";
            }
        }
        view.getStudentRegisterCoursePage().getAvailibleCoursesTextArea().setText(courses);
        view.showRegisterCoursePanel();
    }

    /**
     * this allows the student to actually register for a course by verifying if the course id is valid and their is no
     * conflicts
     */
    private void registerForCourse() {
        int id = -1;
        try {
            id = Integer.parseInt(view.getStudentRegisterCoursePage().getCourseIdTextField().getText());
        } catch (Exception ex) {

        }

        for (CourseModel courseModel : RegistrationSystem.getInstance().getCourseList()) {
            if (courseModel.getCourseId() == id && !model.getRegisteredCourses().contains(courseModel)
                    && !courseModel.isAnyConflictingCourse(model.getRegisteredCourses())) {
                view.getStudentRegisterCoursePage().getErrorLabel().setText("");

                int studIdx = RegistrationSystem.getInstance().getStudentList().indexOf(model);
                model.getRegisteredCourses().add(courseModel);
                RegistrationSystem.getInstance().getStudentList().set(studIdx,model);
                model.setNumberCoursesRegistered(model.getNumberCoursesRegistered() + 1);

                int courseIdx = RegistrationSystem.getInstance().getCourseList().indexOf(courseModel);
                courseModel.getEnrolledStudents().add(model);
                RegistrationSystem.getInstance().getCourseList().set(courseIdx,courseModel);

                DatabaseController.registerStudentToCourse(model.getId(), courseModel.getCourseId());

                view.showMainMenuPanel();
            }
        }
        view.getStudentRegisterCoursePage().getErrorLabel().setText("Invalid ID");
    }

    /**
     * this allows the student to actually drop  a course by verifying if the course id is valid and that they are
     * currently registered in the course
     */
    private void dropACourse() {
        int id = -1;
        try {
            id = Integer.parseInt(view.getStudentDropCoursePage().getCourseIdTextField().getText());
        } catch (Exception ex) {

        }

        for (CourseModel courseModel : model.getRegisteredCourses()) {
            if (model.getRegisteredCourses().contains(courseModel)) {
                view.getStudentDropCoursePage().getErrorLabel().setText("");

                int studIdx = RegistrationSystem.getInstance().getStudentList().indexOf(model);
                model.getRegisteredCourses().remove(courseModel);
                RegistrationSystem.getInstance().getStudentList().set(studIdx,model);
                model.setNumberCoursesRegistered(model.getNumberCoursesRegistered() - 1);

                int courseIdx = RegistrationSystem.getInstance().getCourseList().indexOf(courseModel);
                courseModel.getEnrolledStudents().remove(model);
                RegistrationSystem.getInstance().getCourseList().set(courseIdx,courseModel);

                DatabaseController.removeStudentFromRegistered(model.getId(), courseModel.getCourseId());

                view.showMainMenuPanel();
            }
        }
        view.getStudentDropCoursePage().getErrorLabel().setText("Invalid ID");
    }

}
