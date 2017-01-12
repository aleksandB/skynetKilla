package com.samara.model.getinfo;

import com.samara.data.Command;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sr01001 on 14/01/2016.
 */
public class CommandList implements StrategyEntity {

    @Override
    public List<Command> getInfo(Document document) {
        List<Command> list = new ArrayList<Command>();


            Element table = document.select("table").get(1); //select the second table.

            Elements rows = table.select("tr");
            if (rows.size() <= 1) {
                System.out.println("No cmd available");
            }
            for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
                Command cmd = new Command();
                Element row = rows.get(i);
                Elements cols = row.select("td");
                //setCommand
                cmd.setCommandNumber(cols.get(0).text());
                System.out.println("CMD " + cols.get(0).text());
                //setLigneNumber
                cmd.setLigneNumber(cols.get(1).text());
                System.out.println("Ligne " + cols.get(1).text());
                //setFreeValue
                cmd.setFreeValue(cols.get(6).text());
                System.out.println("FreeValue " + cols.get(6).text());
                //setDEPTSN
                cmd.setDeptClient(cols.get(7).text());
                System.out.println("DeptSN " + cols.get(7).text());
                //setStatus
                cmd.setStatus(cols.get(12).text());
                System.out.println("Status " + cols.get(12).text());
                //setLinkCMD
                cmd.setLinkCommand(cols.get(0).getElementsByTag("a").attr("href").toString().replace("view", "edit"));
                System.out.println("LinkCMD " + cols.get(0).getElementsByTag("a").attr("href").toString().replace("view", "edit"));
                //setLinkLigne
                cmd.setLinkLigne(cols.get(1).getElementsByTag("a").attr("href").toString().replace("view", "edit"));
                System.out.println("LinkLigne " + cols.get(1).getElementsByTag("a").attr("href").toString().replace("view", "edit"));

                list.add(cmd);
        }
        return list;
    }
    @Override
    public List<Command> getInfo(JTable table) {
        List<Command> list = new ArrayList<Command>();

        return list;
    }
}
