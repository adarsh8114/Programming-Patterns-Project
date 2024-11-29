package org.vanier.view.teachersPanels;

import javax.swing.*;
import java.util.ResourceBundle;

public class TeacherLoginPage {
    private JTextField teacherIDTextField;
    private JButton loginConfirmButton;
    private JLabel teacherIdLabel;
    private JLabel passwordLabel;
    private JLabel loginPageLabel;
    private JPasswordField teacherPasswordTextField;
    private JPanel teacherLoginPagePanel;
    private JLabel errorLabel;

    public JTextField getTeacherIDTextField() {
        return teacherIDTextField;
    }

    public JButton getLoginConfirmButton() {
        return loginConfirmButton;
    }

    public JPasswordField getTeacherPasswordTextField() {
        return teacherPasswordTextField;
    }

    public JPanel getTeacherLoginPagePanel() {
        return teacherLoginPagePanel;
    }

    public JLabel getErrorLabel() {
        return errorLabel;
    }

    public void changeLanguage(ResourceBundle resourceBundle) {
        loginPageLabel.setText(resourceBundle.getString("teacherLoginPageLabel"));
        teacherIdLabel.setText(resourceBundle.getString("teacherIDLabel"));
        passwordLabel.setText(resourceBundle.getString("passwordTeacherLabel"));
        loginConfirmButton.setText(resourceBundle.getString("teacherLoginConfirmButton"));
    }
}
