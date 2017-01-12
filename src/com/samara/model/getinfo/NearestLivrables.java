package com.samara.model.getinfo;

import com.samara.data.Livrable;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by sr01001 on 18/12/2015.
 */
public class NearestLivrables implements StrategyEntity {

    @Override


    public List<Livrable> getInfo(Document document) {


        List<Livrable> list = new ArrayList<>();

                    Element table = document.select("table").get(0); //select the first table.

                    Elements rows = table.select("tr");
                    if (rows.size() <= 1) {
                        System.out.println("No nearest livrables");

                    }
                    for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
                            Livrable livrable = new Livrable();
                            Element row = rows.get(i);
                            Elements cols = row.select("td");
                            //setName
                            livrable.setName(cols.get(0).text());
                            System.out.println("Name " + cols.get(0).text());
                            //setDDI_ID
                            livrable.setDdi_id(cols.get(1).text());
                            System.out.println("DDI_ID " + cols.get(1).text());
                            //setDEPT_ID
                            livrable.setDept_id(cols.get(2).text());
                            System.out.println("DEPT_ID " + cols.get(2).text());
                            //setPROJECT_ID
                            livrable.setProject_id(cols.get(3).text());
                            System.out.println("PROJECT_ID " + cols.get(3).text());
                            //setDATE_END_INI
                            livrable.setDate_end_ini(cols.get(4).text());
                            System.out.println("DATE_END_INI " + cols.get(4).text());
                            //setDATE_END_REAL
                            livrable.setDate_end_real(cols.get(5).text());
                            System.out.println("DATE_END_REAL " + cols.get(5).text());
                            //setDATE_END_AGREED
                            livrable.setDate_end_agreed(cols.get(6).text());
                            System.out.println("DATE_END_AGREED " + cols.get(6).text());
                            //setSTATUS
                            livrable.setStatus(cols.get(7).text());
                            System.out.println("OPEN " + cols.get(7).text());
                            //setLinks
                            livrable.setLinkLivr(cols.get(0).getElementsByTag("a").attr("href").toString().replace("view", "edit"));
                            System.out.println("Name " + cols.get(0).getElementsByTag("a").attr("href").toString().replace("view", "edit"));
                            list.add(livrable);
                        }
                        return list;


        }

    public List<Livrable> getInfo(JTable table) {


        List<Livrable> list = new ArrayList<>();

        int numrows = table.getRowCount();
        int numcol = table.getColumnCount();

        if (numrows <= 1) {
            System.out.println("No nearest livrables");
        }
        for (int i = 0; i < numrows; i++) { //first row is the col names so skip it.
            Livrable livrable = new Livrable();
            livrable.setName(table.getValueAt(i, 0).toString());
            System.out.println("Name " + table.getValueAt(i, 0).toString());
            //setDDI_ID
            livrable.setDdi_id(table.getValueAt(i, 1).toString());
            System.out.println("DDI_ID " + table.getValueAt(i, 1).toString());
            //setDEPT_ID
            livrable.setDept_id(table.getValueAt(i, 2).toString());
            System.out.println("DEPT_ID " + table.getValueAt(i, 2).toString());
            //setPROJECT_ID
            livrable.setProject_id(table.getValueAt(i, 3).toString());
            System.out.println("PROJECT_ID " + table.getValueAt(i, 3).toString());
            //setDATE_END_INI
            livrable.setDate_end_ini(table.getValueAt(i, 4).toString());
            System.out.println("DATE_END_INI " + table.getValueAt(i, 4).toString());
            //setDATE_END_REAL
            livrable.setDate_end_real(table.getValueAt(i, 5).toString());
            System.out.println("DATE_END_REAL " + table.getValueAt(i, 5).toString());
            //setDATE_END_AGREED
            livrable.setDate_end_agreed(table.getValueAt(i, 6).toString());
            System.out.println("DATE_END_AGREED " + table.getValueAt(i, 6).toString());
            //setSTATUS
            livrable.setStatus(table.getValueAt(i, 7).toString());
            System.out.println("STATUS " + table.getValueAt(i, 7).toString());
            //setLinks
            livrable.setLinkLivr(table.getValueAt(i, 8).toString());
            System.out.println("Name " + table.getValueAt(i, 8).toString());
            list.add(livrable);
        }

        return list;

    }

}