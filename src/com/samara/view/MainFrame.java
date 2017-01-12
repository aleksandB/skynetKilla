package com.samara.view;


import com.samara.data.BGTPart;
import com.samara.data.BR;
import com.samara.data.Command;
import com.samara.data.Livrable;
import com.samara.model.ExcelAdapter;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableColumn;
import java.awt.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.TreeMap;


/**
 * Created by sr01001 on 12/01/2016.
 */
public class MainFrame extends JFrame {

    private JPanel mainPanel;
    final private JMenuBar menuBar = new JMenuBar();
    private JMenu infoMenu, nearestLivrablesMenu, addPartsMenu,bgtEditMenu;
    private JMenuItem infoDeptSN, infoDeptSM, infoDeptGlobal, infoDeptUserId, infoDeptPrjId, infoListBR, infoListCMD, getLivr, setParts, delBGT ,infoListTaux, getAllDepts;
    private JMenu infoClotures;
    private JMenuItem  cltM_D1, cltM_CM2, cltM_CM1, cltM_D3, cltM_CT1, cltM_CT2, cltM_E, cltS_CM1, cltS_CM2, cltS_CM3, cltS_CM4, cltS_CM5, cltS_CM6, cltS_CM7, cltS_CM8, cltS_CD, cltS_D1, cltS_CT, cltM_ADM ;
    private JLabel labelInfo;
    private JTable table;

    private JButton buttonExit,buttonInfo;

    public MainFrame(){
        //Default Description of View for Main Frame
        super("mainView");

        mainPanel = new JPanel(new GridBagLayout());
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //create menus
        infoMenu = new JMenu("DB Info");
        nearestLivrablesMenu = new JMenu("NearestLivrables");
        addPartsMenu = new JMenu("PartEditor");
        bgtEditMenu = new JMenu("PartDelete");
        infoClotures = new JMenu("InfoListClotures");


        //create items;
        infoDeptSN = new JMenuItem("InfoDeptSnecma");
        infoDeptSN.setActionCommand("InfoDeptSnecma");
        infoDeptSM = new JMenuItem("InfoDeptsamara");
        infoDeptSM.setActionCommand("InfoDeptsamara");
        infoDeptGlobal = new JMenuItem("InfoDeptGlobal");
        infoDeptGlobal.setActionCommand("InfoDeptGlobal");
        infoDeptUserId = new JMenuItem("InfoDeptUserID");
        infoDeptUserId.setActionCommand("InfoDeptUserID");
        infoDeptPrjId = new JMenuItem("InfoDeptPrjID");
        infoDeptPrjId.setActionCommand("InfoDeptPrjID");
        infoListBR = new JMenuItem("InfoListBR");
        infoListBR.setActionCommand("InfoListBR");
        infoListCMD = new JMenuItem("InfoListCMD");
        infoListCMD.setActionCommand("InfoListCMD");
        infoListTaux = new JMenuItem("InfoListTaux");
        infoListTaux.setActionCommand("InfoListTaux");
        getLivr = new JMenuItem("Get Nearest Livrables");
        getLivr.setActionCommand("GetNearestLivrables");
        setParts = new JMenuItem("Set Parts By Table");
        setParts.setActionCommand("SetPartsByTable");
        delBGT = new JMenuItem("Delete BGTParts");
        delBGT.setActionCommand("DeleteBGTParts");
        getAllDepts = new JMenuItem("GetInfo all Depts");
        getAllDepts.setActionCommand("GetInfo");

        ///clotures all equipes M et S

        cltM_D1 = new JMenuItem("M_D1");
        cltM_D1.setActionCommand("M_D1");
        cltM_CM2 = new JMenuItem("M_CM2");
        cltM_CM2.setActionCommand("M_CM2");
        cltM_CM1 = new JMenuItem("M_CM1");
        cltM_CM1.setActionCommand("M_CM1");
        cltM_D3 = new JMenuItem("M_D3");
        cltM_D3.setActionCommand("M_D3");
        cltM_CT1 = new JMenuItem("M_CT1");
        cltM_CT1.setActionCommand("M_CT1");
        cltM_CT2 = new JMenuItem("M_CT2");
        cltM_CT2.setActionCommand("M_CT2");
        cltM_E = new JMenuItem("M_E");
        cltM_E.setActionCommand("M_E");
        cltM_ADM = new JMenuItem("M_ADM");
        cltM_ADM.setActionCommand("M_ADM");

        cltS_CM1 = new JMenuItem("S_CM1");
        cltS_CM1.setActionCommand("S_CM1");
        cltS_CM2 = new JMenuItem("S_CM2");
        cltS_CM2.setActionCommand("S_CM2");
        cltS_CM3 = new JMenuItem("S_CM3");
        cltS_CM3.setActionCommand("S_CM3");
        cltS_CM4 = new JMenuItem("S_CM4");
        cltS_CM4.setActionCommand("S_CM4");
        cltS_CM5 = new JMenuItem("S_CM5");
        cltS_CM5.setActionCommand("S_CM5");
        cltS_CM6 = new JMenuItem("S_CM6");
        cltS_CM6.setActionCommand("S_CM6");
        cltS_CM7 = new JMenuItem("S_CM7");
        cltS_CM7.setActionCommand("S_CM7");
        cltS_CM8 = new JMenuItem("S_CM8");
        cltS_CM8.setActionCommand("S_CM8");
        cltS_CD = new JMenuItem("S_CD");
        cltS_CD.setActionCommand("S_CD");
        cltS_D1 = new JMenuItem("S_D1");
        cltS_D1.setActionCommand("S_D1");
        cltS_CT = new JMenuItem("S_CT");
        cltS_CT.setActionCommand("S_CT");

        //add menu items
        infoMenu.add(infoDeptSN);
        infoMenu.add(infoDeptSM);
        infoMenu.add(infoDeptGlobal);
        infoMenu.add(infoDeptUserId);
        infoMenu.add(infoDeptPrjId);
        infoMenu.add(infoListBR);
        infoMenu.add(infoListCMD);
        infoMenu.add(infoListTaux);
        infoMenu.add(infoClotures);

        infoClotures.add(cltM_D1);
        infoClotures.add(cltM_CM2);
        infoClotures.add(cltM_CM1);
        infoClotures.add(cltM_D3);
        infoClotures.add(cltM_CT1);
        infoClotures.add(cltM_CT2);
        infoClotures.add(cltM_E);
        infoClotures.add(cltM_ADM);

        infoClotures.add(cltS_CM1);
        infoClotures.add(cltS_CM2);
        infoClotures.add(cltS_CM3);
        infoClotures.add(cltS_CM4);
        infoClotures.add(cltS_CM5);
        infoClotures.add(cltS_CM6);
        infoClotures.add(cltS_CM7);
        infoClotures.add(cltS_CM8);
        infoClotures.add(cltS_CD);
        infoClotures.add(cltS_D1);
        infoClotures.add(cltS_CT);


        nearestLivrablesMenu.add(getLivr);
        addPartsMenu.add(setParts);
        bgtEditMenu.add(delBGT);
        bgtEditMenu.add(getAllDepts);

        //add menus
        menuBar.add(infoMenu);
        menuBar.add(nearestLivrablesMenu);
        menuBar.add(addPartsMenu);
        menuBar.add(bgtEditMenu);

        //add menu to frame
        setJMenuBar(menuBar);


        String[] columns = {" "," "," "," "};
        String[][] data = new String[0][10];
        DefaultTableModel model = new DefaultTableModel(data, columns){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };


        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        table.setCellSelectionEnabled(false);
        mainPanel.add(scrollPane, new GridBagConstraints(0, 0, 10, 1, 1, 0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        buttonInfo = new JButton("OK");
        buttonInfo.setActionCommand("OK");
        buttonExit = new JButton("Exit");
        buttonExit.setActionCommand("Exit");
        buttonExit.setPreferredSize(new Dimension(150,30));
        buttonInfo.setPreferredSize(new Dimension(150,30));

        mainPanel.add(buttonInfo, new GridBagConstraints(8, 1, 1, 1, 1, 0, GridBagConstraints.EAST,
                GridBagConstraints.NONE, new Insets(0, 0, 5, 5), 0, 0));
        mainPanel.add(buttonExit, new GridBagConstraints(9, 1, 1, 1, 0, 0, GridBagConstraints.EAST,
                GridBagConstraints.NONE, new Insets(0, 0, 5, 5), 0, 0));


        getContentPane().add(mainPanel, BorderLayout.NORTH);
        labelInfo = new JLabel("Information");
        getContentPane().add(labelInfo, BorderLayout.SOUTH);

        setSize(1268, 768);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }
    public JMenuItem[] getMenuItems() {
        JMenuItem[] items = {  infoDeptSN,     //0
                infoDeptSM,     //1
                infoDeptGlobal,     //2
                infoDeptUserId,     //3
                infoDeptPrjId,     //4
                infoListBR,     //5
                infoListCMD,     //6
                getLivr,     //7
                setParts,     //8
                delBGT,             //9
                infoListTaux,       //10
                cltM_D1,            //11
                cltM_CM2,            //12
                cltM_CM1,            //13
                cltM_D3,            //14
                cltM_CT1,            //15
                cltM_CT2,            //16
                cltM_E,              //17
                cltM_ADM,             //18
                cltS_CM1,            //19
                cltS_CM2,            //20
                cltS_CM3,            //21
                cltS_CM4,            //22
                cltS_CM5,            //23
                cltS_CM6,            //24
                cltS_CM7,            //25
                cltS_CM8,            //26
                cltS_CD,            //27
                cltS_D1,            //28
                cltS_CT,            //29
                getAllDepts,            //30

        };
        return items;
    }
    public JButton[] getButtons() {
        JButton[] buttons = { buttonInfo ,     //0
               buttonExit,     //1

        };
        return buttons;
    }

    public JLabel getLable(){
        return labelInfo;
    }

    public JTable getCurrentTable(){
        return table;
    }

    public void updateView(String str){
        if(str.equals("Livrable")){
            String[] columnNamesBR = {
                    "NAME",
                    "DDI_ID",
                    "DEPT_ID",
                    "PROJECT_ID",
                    "DATE_END_INI",
                    "DATE_END_REAL",
                    "DATE_END_AGREED",
                    "STATUS",
                    "LINK",
            };
       DefaultTableModel tbl = new DefaultTableModel(1, 9){
           @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

            tbl.setColumnIdentifiers(columnNamesBR);
            table.setModel(tbl);
            table.setCellSelectionEnabled(false);
            updateUI("SetDataL");
        }
        if(str.equals("CMD")){
            String[] columnNamesCMD = {
                    "Command",
                    "Ligne",
                    "Dept SN",
                    "Project",
                    "Dept samara",
                    "Value, $",
                    "BR",
                    "Budget Ligne, $",
                    "Comment",
                    "Taux",
                    "Cloture",
                    "BL",
                    "BL date",
                    "CT",
                    "CT date",
                    "CT note",
            };
            DefaultTableModel tbl = new DefaultTableModel(1, 16){
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return true;
                }
            };

            tbl.setColumnIdentifiers(columnNamesCMD);
            table.setModel(tbl);
            table.setCellSelectionEnabled(false);
            ExcelAdapter ad = new ExcelAdapter(table);
            updateUI("SetDataCMD");
        }
    }


    public void updateView(Map<String, String> map){
        InfoFrame infoFrame = new InfoFrame();


        String[] columnNames = {
                "Name",
                "Index",
        };

        DefaultTableModel tbl = new DefaultTableModel(map.size(),2);
        tbl.setColumnIdentifiers(columnNames);
        infoFrame.getCurrentTable().setModel(tbl);




        HashMap<Integer,String> mapTrans = new HashMap<>();
        for(Map.Entry<String, String> pair : map.entrySet())
        {
            mapTrans.put(Integer.parseInt(pair.getKey()),pair.getValue());
        }

        TreeMap<Integer,String> tree = new TreeMap<>();
        tree.putAll(mapTrans);
        int rows = 0;
        int columns = 0;
        for(Map.Entry<Integer, String> pair : tree.entrySet())
        {
            infoFrame.getCurrentTable().setValueAt(pair.getValue(), rows, columns);
            infoFrame.getCurrentTable().setValueAt(pair.getKey(), rows, columns + 1);
            rows++;
        }
        infoFrame.setVisible(true);


    }
    public void updateViewBR(List list){
        System.out.println("enterBR");
            List<BR> listBR = list;
            String[] columnNamesBR = {
                    "BRref",
                    "Command Number",
                    "Ligne Number",
                    "Sum value",
                    "Link BR",
            };

            System.out.println("List size " + listBR.size());
            DefaultTableModel tbl = new DefaultTableModel(list.size(), 5);
            tbl.setColumnIdentifiers(columnNamesBR);
            table.setModel(tbl);

                   int rows = 0;

        for (BR br : listBR) {
                table.setValueAt(br.getBrRef(),rows,0);
                table.setValueAt(br.getCommandNumber(),rows,1);
                table.setValueAt(br.getLigneNumber(),rows,2);
                table.setValueAt(br.getSumValue(),rows,3);
                table.setValueAt(br.getLinkBR(),rows,4);
            rows++;
                    }
        updateUI("Info");

    }
    public void updateViewCMD(List list){
        System.out.println("enterCMD");
        List<Command> listCMD = list;
        String[] columnNamesBR = {
                "Command Number",
                "Ligne Number",
                "Free value",
                "Dept Command",
                "Link Command",
                "Link Ligne",
                "Status",
        };

        System.out.println("List size " + listCMD.size());
        DefaultTableModel tbl = new DefaultTableModel(list.size(), 7);
        tbl.setColumnIdentifiers(columnNamesBR);
        table.setModel(tbl);

        int rows = 0;

        for (Command cmd : listCMD) {
            table.setValueAt(cmd.getCommandNumber(),rows,0);
            table.setValueAt(cmd.getLigneNumber(),rows,1);
            table.setValueAt(cmd.getFreeValue(),rows,2);
            table.setValueAt(cmd.getDeptClient(),rows,3);
            table.setValueAt(cmd.getLinkCommand(),rows,4);
            table.setValueAt(cmd.getLinkLigne(),rows,5);
            table.setValueAt(cmd.getStatus(),rows,6);

            rows++;
        }
        updateUI("Info");

    }

    public void updateViewLivr(List list){
        System.out.println("enterLivr");
        List<Livrable> listL = list;
        String[] columnNamesBR = {
                "NAME",
                "DDI_ID",
                "DEPT_ID",
                "PROJECT_ID",
                "DATE_END_INI",
                "DATE_END_REAL",
                "DATE_END_AGREED",
                "STATUS",
                "LINK",
        };

        System.out.println("List size " + listL.size());
        DefaultTableModel tbl = new DefaultTableModel(list.size(), 9){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0 || column==5 || column==6 || column==7 ? true : false;
            }
         };

        tbl.setColumnIdentifiers(columnNamesBR);
        table.setModel(tbl);

        int rows = 0;

        for (Livrable livr : listL) {
            table.setValueAt(livr.getName(),rows,0);
            table.setValueAt(livr.getDdi_id(),rows,1);
            table.setValueAt(livr.getDept_id(),rows,2);
            table.setValueAt(livr.getProject_id(),rows,3);
            table.setValueAt(livr.getDate_end_ini(),rows,4);
            table.setValueAt(livr.getDate_end_real(),rows,5);
            table.setValueAt(livr.getDate_end_agreed(),rows,6);
            table.setValueAt("Accepted",rows,7);
            table.setValueAt(livr.getLinkLivr(),rows,8);
            rows++;
        }

        String[] items1 = {"Open", "Delivered", "Accepted","Deleted"};

        DefaultComboBoxModel comboModel = new DefaultComboBoxModel( items1 );
        JComboBox combo = new JComboBox();
        combo.setModel(comboModel);
        TableColumn col = table.getColumnModel().getColumn( 7 );
        col.setCellEditor( new DefaultCellEditor( combo ) );
 //       table.setDefaultRenderer(Object.class, new CustomRenderer());


        updateUI("SetDataL");

    }


    public void updateViewPart(List list){
        System.out.println("enterPart");
        List<BGTPart> listP = list;
        String[] columnNamesCMD = {
                "Command",
                "Ligne",
                "Dept SN",
                "Project",
                "Dept samara",
                "Value, $",
                "BR",
                "Budget Ligne, $",
                "Comment",
                "Taux",
                "Cloture",
                "BL",
                "BL date",
                "CT",
                "CT date",
                "CT note",
        };
        DefaultTableModel tbl = new DefaultTableModel(list.size(), 16){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        tbl.setColumnIdentifiers(columnNamesCMD);
        table.setModel(tbl);

        int rows = 0;

        for (BGTPart bgt : listP) {
            table.setValueAt(bgt.getCmd_id(),rows,0);
            table.setValueAt(bgt.getLigne_id(),rows,1);
            table.setValueAt(bgt.getClt_dept_id(),rows,2);
            table.setValueAt(bgt.getProject_id(),rows,3);
            table.setValueAt(bgt.getDept_id(),rows,4);
            table.setValueAt(bgt.getPart_value(),rows,5);
            table.setValueAt(bgt.getBr_nom(),rows,6);
            table.setValueAt(bgt.getBr_budget(),rows,7);
            table.setValueAt(bgt.getComment(),rows,8);
            table.setValueAt(bgt.getTaux(),rows,9);
            table.setValueAt(bgt.getCloture(),rows,10);
            table.setValueAt(bgt.getBl_link(),rows,11);
            table.setValueAt(bgt.getBl_date(),rows,12);
            table.setValueAt(bgt.getCt_link(),rows,13);
            table.setValueAt(bgt.getCt_date(),rows,14);
            table.setValueAt(bgt.getCt_value(),rows,15);

            rows++;
        }


        updateUI("SetDataCMD");

    }

    public void updateUI(String text){
        if(text.equals("Info")){
            buttonInfo.setText("OK");
            buttonInfo.setActionCommand("OK");
            buttonExit.setText("Exit");
            buttonExit.setActionCommand("Exit");
        }
        if(text.equals("SetDataL")){
            buttonInfo.setText("Verify Table");
            buttonInfo.setActionCommand("VerifyTable");
            buttonExit.setText("Post Data");
            buttonExit.setActionCommand("PostData");
        }
        if(text.equals("SetDataCMD")){
            buttonInfo.setText("Verify Table");
            buttonInfo.setActionCommand("VerifyTableCMD");
            buttonExit.setText("Post Data");
            buttonExit.setActionCommand("PostDataCMD");
        }
    }

    public boolean isEmpty(JTable jTable) {
        if (jTable != null && jTable.getModel() != null) {
            return jTable.getModel().getRowCount()<=0?true:false;
        }
        return false;
    }


}

/*
class CustomRenderer extends DefaultTableCellRenderer
{


        public Component getTableCellRendererComponent(	JTable table, Object value,
        boolean isSelected, boolean hasFocus,
        int row, int column)
        {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if(column == 1 || column == 2 || column == 3 || column == 4 || column == 8)
            {
                c.setBackground(Color.gray);
            }
            else
            {
                c.setBackground(Color.white);
            }

            return c;
        }

}*/