package com.samara.model.getinfo;

import com.samara.data.BGTPart;
import com.samara.data.BGTPartValidity;
import org.jsoup.nodes.Document;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sr01001 on 10/02/2016.
 */
public class BGTpartsCreator implements StrategyEntity {

    @Override
    public List getInfo(Document doc) {
        return null;
    }

    @Override
    public List getInfo(JTable table) {
        List<BGTPart> list = new ArrayList<>();

        int numrows = table.getRowCount();



        for (int i = 0; i < numrows; i++) {
            BGTPart bgtPart = new BGTPart();

            //command
             bgtPart.setCmd_id(table.getValueAt(i, 0).toString());
            System.out.println("Command " + table.getValueAt(i, 0).toString());
            //ligne
            bgtPart.setLigne_id(table.getValueAt(i, 1).toString());
            System.out.println("Ligne " + table.getValueAt(i, 1).toString());
            //dept_SN
            bgtPart.setClt_dept_id(table.getValueAt(i, 2).toString());
            System.out.println("Dept SN " + table.getValueAt(i, 2).toString());
            //project
            bgtPart.setProject_id(table.getValueAt(i, 3).toString());
            System.out.println("Project " + table.getValueAt(i, 3).toString());
            //dept samara
            bgtPart.setDept_id(table.getValueAt(i, 4).toString());
            System.out.println("Dept SM " + table.getValueAt(i, 4).toString());
            //value
            bgtPart.setPart_value(table.getValueAt(i, 5).toString());
            System.out.println("Value " + table.getValueAt(i, 5).toString());
            //BR
            bgtPart.setBr_nom(table.getValueAt(i, 6).toString());
            System.out.println("BR " + table.getValueAt(i, 6).toString());
            //BR_Val
            bgtPart.setBr_budget(table.getValueAt(i, 7).toString());
            System.out.println("BR_val " + table.getValueAt(i, 7).toString());
            //comment
            bgtPart.setComment(table.getValueAt(i, 8).toString());
            System.out.println("Comment " + table.getValueAt(i, 8).toString());
            //taux
            bgtPart.setTaux(table.getValueAt(i, 9).toString());
            System.out.println("Taux " + table.getValueAt(i, 9).toString());
            //cloture
///write algo for create cloture for project without cloture
            bgtPart.setCloture(table.getValueAt(i, 10).toString());
            System.out.println("Cloture " + table.getValueAt(i, 10).toString());

            //bl
            if(table.getValueAt(i, 11) != null) {
                bgtPart.setBl_link(table.getValueAt(i, 11).toString());
                System.out.println("BL link " + table.getValueAt(i, 11).toString().replace('\\', '/'));
            } else bgtPart.setBl_link("");
            //bl_date
            if(table.getValueAt(i, 12) != null) {
                bgtPart.setBl_date(table.getValueAt(i, 12).toString());
                System.out.println("BL date " + table.getValueAt(i, 12).toString());
            } else bgtPart.setBl_date("");
            //ct
            if(table.getValueAt(i, 13) != null) {
                bgtPart.setCt_link(table.getValueAt(i, 13).toString());
                System.out.println("CT link " + table.getValueAt(i, 13).toString().replace('\\', '/'));
            }else bgtPart.setCt_link("");
            //ct_date
            if(table.getValueAt(i, 14) != null) {
                bgtPart.setCt_date(table.getValueAt(i, 14).toString());
                System.out.println("CT date " + table.getValueAt(i, 14).toString());
            }else bgtPart.setCt_date("");
            //ct_note
            if(table.getValueAt(i, 15) !=null) {
                bgtPart.setCt_value(table.getValueAt(i, 15).toString());
                System.out.println("CT note " + table.getValueAt(i, 15).toString());
            }else bgtPart.setCt_value("");

           if(list.size() != 0 && compareObj(list,bgtPart)){
               System.out.println("true");

           }else {

               list.add(bgtPart);

           }

        }

        return list;

    }

    public boolean compareObj(List<BGTPart> list, BGTPart part){
        for(BGTPart bgt: list){

            if(bgt.getCmd_id().equals(part.getCmd_id()) &&
                    bgt.getLigne_id().equals(part.getLigne_id()) &&
                    bgt.getClt_dept_id().equals(part.getClt_dept_id()) &&
                    bgt.getProject_id().equals(part.getProject_id()) &&
                    bgt.getBr_nom().equals(part.getBr_nom()) &&
                    bgt.getBr_budget().equals(part.getBr_budget()) &&
                    bgt.getTaux().equals(part.getTaux()) &&
                    bgt.getCt_value().equals(part.getCt_value()) &&
                    bgt.getCloture().equals(part.getCloture())){

                 bgt.setPart_value(String.valueOf(Integer.parseInt(bgt.getPart_value()) + Integer.parseInt(part.getPart_value())));
                return true;

            }
        }
        return false;
    }



}
