package org.vanier.view.adminPanels;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginPage extends JFrame{
    private JLabel adminWelcomeLabel;
    private JLabel adminIdLabel;
    private JLabel passwordLabel;
    private JButton loginLabel;

    public AdminLoginPage() {
        loginLabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminMainMenuPage adminMainMenuPage = new AdminMainMenuPage();
                adminMainMenuPage.setVisible(true);
            }
        });
    }
}
