package org.vanier.view.teachersPanels;

import javax.swing.*;

public class TeacherViewCourseDetailsPage {
    private JLabel courseIDLabel;
    private JTextField idTextField;
    private JButton idButton;
    private JTable studentListTable;
    private JButton returnButton;
    private JPanel teacherViewCoursePanel;
    private JLabel errorLabel;

    public JLabel getCourseIDLabel() {
        return courseIDLabel;
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public JButton getIdButton() {
        return idButton;
    }

    public JTable getStudentListTable() {
        return studentListTable;
    }

    public JButton getReturnButton() {
        return returnButton;
    }

    public JPanel getTeacherViewCoursePanel() {
        return teacherViewCoursePanel;
    }

    public JLabel getErrorLabel() {
        return errorLabel;
    }
}
