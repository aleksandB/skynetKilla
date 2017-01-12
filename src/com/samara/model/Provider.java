package com.samara.model;

import com.samara.model.getinfo.StrategyEntity;
import org.jsoup.nodes.Document;

import javax.swing.*;
import java.util.List;


/**
 * Created by sr01001 on 14/01/2016.
 */
public class Provider {

    private StrategyEntity strategyEntity;


    public Provider(StrategyEntity strategyEntity){
        this.strategyEntity = strategyEntity;
    }

    public List executeStrategy(Document document){
        return strategyEntity.getInfo(document);
    }
    public List executeStrategy(JTable table){
        return strategyEntity.getInfo(table);
    }

}
