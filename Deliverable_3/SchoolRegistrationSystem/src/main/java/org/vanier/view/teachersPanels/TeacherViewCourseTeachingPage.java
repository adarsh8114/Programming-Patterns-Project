package org.vanier.view.teachersPanels;

import javax.swing.*;
import java.util.ResourceBundle;

public class TeacherViewCourseTeachingPage {
    private JLabel courseNumberLabel;
    private JTextField idTextField;
    private JButton confirmButton;
    private JButton returnButton;
    private JPanel teacherViewCoursePanel;
    private JButton cancelFilterButton;
    private JList coursesList;
    private JButton viewDetailsButton;
    private JLabel errorLabel;

    public JLabel getCourseNumberLabel() {
        return courseNumberLabel;
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public JButton getConfirmButton() {
        return confirmButton;
    }

    public JButton getReturnButton() {
        return returnButton;
    }

    public JPanel getTeacherViewCoursePanel() {
        return teacherViewCoursePanel;
    }

    public JList getCoursesList() {
        return coursesList;
    }

    public JButton getCancelFilterButton() {
        return cancelFilterButton;
    }

    public JButton getViewDetailsButton() {
        return viewDetailsButton;
    }

    public JLabel getErrorLabel() {
        return errorLabel;
    }

    public void changeLanguage(ResourceBundle resourceBundle) {
        courseNumberLabel.setText(resourceBundle.getString("teacherCourseNumberLabel"));
        confirmButton.setText(resourceBundle.getString("teacherViewCoursePageConfirmButton"));
        returnButton.setText(resourceBundle.getString("teacherViewCoursePageReturnButton"));
        cancelFilterButton.setText(resourceBundle.getString("teacherCancelFilterButton"));
        viewDetailsButton.setText(resourceBundle.getString("teacherViewDetailsButton"));
    }
}
