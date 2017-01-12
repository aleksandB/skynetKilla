package com.samara.view;

import javax.swing.*;

/**
 * Created by sr01001 on 20/04/2016.
 */
public class AccessFrame extends JFrame{

    private JLabel infoLabel, progressLabel;
    private JButton buttonOK;

    private JPanel accessPanel;

    public AccessFrame(){
        //    Default Description of View for access Frame
        super("accessFrame");
        setSize(300, 150);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        accessPanel = new JPanel();
        accessPanel.setLayout(null);
        infoLabel = new JLabel("Logged as ");
        infoLabel.setBounds(5, 15, 250, 21);
        progressLabel = new JLabel("Access denied for this user");
        progressLabel.setBounds(5,55,250,21);

        buttonOK = new JButton("Exit");
        buttonOK.setBounds(100, 95, 100, 21);

        accessPanel.add(infoLabel);
        accessPanel.add(progressLabel);




        setLocationRelativeTo(null);
        setContentPane(accessPanel);
        accessPanel.setFocusable(true);
        accessPanel.requestFocusInWindow();


    }


    public JButton[] getButtons() {
        JButton[] buttons = {buttonOK};
        return buttons;
    }

    public JLabel[] getLabels() {
        JLabel[] labels = {infoLabel, progressLabel};
        return labels;
    }



    public void setStatusIg(){
        accessPanel.add(buttonOK);
    }

}
