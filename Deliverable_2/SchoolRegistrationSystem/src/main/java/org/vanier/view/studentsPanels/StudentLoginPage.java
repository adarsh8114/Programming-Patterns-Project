package org.vanier.view.studentsPanels;

import javax.swing.*;

public class StudentLoginPage extends JFrame{
    private JPanel StudentLoginPanel;
    private JLabel WelcomeLabel;
    private JLabel StudentId;
    private JLabel PasswordLabel;
    private JTextField StudentIdTextField;
    private JTextField PasswordTextField;
    private JButton loginButton;
    private JLabel ErrorLabel;

    public JPanel getStudentLoginPanel() {
        return StudentLoginPanel;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JTextField getStudentIdTextField() {
        return StudentIdTextField;
    }

    public JTextField getPasswordTextField() {
        return PasswordTextField;
    }

    public JLabel getErrorLabel() {
        return ErrorLabel;
    }
}
