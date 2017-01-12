package com.samara.view;

import javax.swing.*;

/**
 * Created by sr01001 on 26/04/2016.
 */
public class AccessFrameIntern extends JFrame{
    private JLabel infoLabel, progressLabel;

    private JPanel accessPanel;

    public AccessFrameIntern(){
        //    Default Description of View for access Frame
        super("accessFrameIntern");
        setSize(300, 150);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        accessPanel = new JPanel();
        accessPanel.setLayout(null);
        infoLabel = new JLabel("Logged as ");
        infoLabel.setBounds(5, 15, 250, 21);
        progressLabel = new JLabel("Access denied for this user");
        progressLabel.setBounds(5,55,250,21);


        accessPanel.add(infoLabel);
        accessPanel.add(progressLabel);




        setLocationRelativeTo(null);
        setContentPane(accessPanel);
        accessPanel.setFocusable(true);
        accessPanel.requestFocusInWindow();


    }

    public JLabel[] getLabels() {
        JLabel[] labels = {infoLabel, progressLabel};
        return labels;
    }




}
