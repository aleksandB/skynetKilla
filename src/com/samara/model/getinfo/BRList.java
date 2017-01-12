package com.samara.model.getinfo;

import com.samara.data.BR;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sr01001 on 19/01/2016.
 */
public class BRList implements StrategyEntity {

    @Override
    public List<BR> getInfo(Document document) {
        List<BR> list = new ArrayList<BR>();


        Element table = document.select("table").get(0); //select the second table.

        Elements rows = table.select("tr");
        if (rows.size() <= 1) {
            System.out.println("No br available");
        }
        for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
            BR br = new BR();
            Element row = rows.get(i);
            Elements cols = row.select("td");
            //setBRref
            br.setBrRef(cols.get(0).text());
            System.out.println("BRRef " + cols.get(0).text());
            //setCommandNumber
            br.setCommandNumber(cols.get(2).text());
            System.out.println("CMD " + cols.get(2).text());
            //setLignNumber
            br.setLigneNumber(cols.get(3).text());
            System.out.println("Ligne " + cols.get(3).text());
            //setSumValue
            br.setSumValue(cols.get(5).text());
            System.out.println("SumValue " + cols.get(5).text());
            //setLinkBR
            br.setLinkBR(cols.get(0).getElementsByTag("a").attr("href").toString().replace("view", "edit"));
            System.out.println("LinkBR " + cols.get(0).getElementsByTag("a").attr("href").toString().replace("view", "edit"));

            list.add(br);
        }
        return list;
    }

    @Override
    public List<BR> getInfo(JTable table) {
        List<BR> list = new ArrayList<BR>();

        return list;
    }
}
