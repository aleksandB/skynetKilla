package com.samara.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sr01001 on 12/01/2016.
 */
public class LoginFrame extends JFrame{



    private JLabel loginLabel, passLabel ,infoLabel;
    private JButton buttonOK, buttonCancel;
    private JTextField loginField;
    private String textLabel =" ";



    private JPasswordField passField;
    private JPanel loginPanel;

    public LoginFrame(){
        //    Default Description of View for Login Frame
        super("Login");
        setSize(230, 130);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginLabel = new JLabel("Login");
        loginLabel.setBounds(5, 5, 95, 21);
        passLabel = new JLabel("Password");
        passLabel.setBounds(5,30,95,21);
        loginField = new JTextField(20);
        loginField.setBounds(100,5,110,21);
        passField = new JPasswordField(20);
        passField.setBounds(100,30,110,21);
        infoLabel = new JLabel(textLabel);
        infoLabel.setBounds(5,82,210,21);

        buttonOK = new JButton("OK");
        buttonOK.setBounds(55,60,75,21);
        buttonCancel = new JButton("Cancel");
        buttonCancel.setBounds(135,60,75,21);
        loginPanel.add(loginLabel);
        loginPanel.add(loginField);
        loginPanel.add(passLabel);
        loginPanel.add(passField);
        loginPanel.add(buttonOK);
        loginPanel.add(buttonCancel);
        loginPanel.add(infoLabel);
        setLocationRelativeTo(null);
        setContentPane(loginPanel);
        loginPanel.setFocusable(true);
        loginPanel.requestFocusInWindow();


 }


    public JButton[] getButtons() {
        JButton[] buttons = {buttonOK, buttonCancel};
        return buttons;
    }

    public JLabel[] getLabels() {
        JLabel[] labels = {infoLabel};
        return labels;
    }


    public JTextField[] getTextFields() {
        JTextField[] textFields = {loginField,passField};
        return textFields;
    }
    public JPanel getLoginPanel() {
        return loginPanel;
    }
    public void setTextLabel(String textLabel) {
        this.textLabel = textLabel;
    }
}
