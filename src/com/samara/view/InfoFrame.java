package com.samara.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by sr01001 on 20/04/2016.
 */
public class InfoFrame extends JFrame{

       private JTable tableInfo;



    public InfoFrame(){
        //Default Description of View for Main Frame
        super("InfoView");


        String[] columns = {" "," "};
        String[][] data = new String[2][2];
        DefaultTableModel model = new DefaultTableModel(data, columns){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };


        tableInfo = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(tableInfo);
        tableInfo.setCellSelectionEnabled(false);



        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setSize(300, 500);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    public JTable getCurrentTable(){
        return tableInfo;
    }


}
