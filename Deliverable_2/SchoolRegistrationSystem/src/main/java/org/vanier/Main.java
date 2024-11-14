package org.vanier;

import org.vanier.view.MainForm;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MainForm mainForm = new MainForm();
        // Set up the JFrame properties
        JFrame frame = new JFrame("Main Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainForm.getContentPane());
        frame.pack();
        frame.setVisible(true);

    }
}
