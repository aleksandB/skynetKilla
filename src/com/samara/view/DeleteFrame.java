package com.samara.view;

import javax.swing.*;

/**
 * Created by sr01001 on 22/04/2016.
 */
public class DeleteFrame extends JFrame{
    
    
    private JButton buttonDel;
    private JTextField deleteField;
    private JLabel statusLabel;

    private JPanel deletePanel;

    public DeleteFrame(){
        //    Default Description of View for delete Frame
        super("deleteFrame");
        setSize(230, 100);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        deletePanel = new JPanel();
        deletePanel.setLayout(null);
        deleteField = new JTextField(10);
        deleteField.setBounds(20,20,75,21);
        buttonDel = new JButton("Delete Part");
        buttonDel.setActionCommand("DeletePart");
        buttonDel.setBounds(100,20,120,21);
        deletePanel.add(deleteField);
        deletePanel.add(buttonDel);
        setLocationRelativeTo(null);
        setContentPane(deletePanel);
        deletePanel.setFocusable(true);
        deletePanel.requestFocusInWindow();

    }


    public JButton[] getButtons() {
        JButton[] buttons = {buttonDel};
        return buttons;
    }


    public JTextField[] getTextFields() {
        JTextField[] textFields = {deleteField};
        return textFields;
    }


}
