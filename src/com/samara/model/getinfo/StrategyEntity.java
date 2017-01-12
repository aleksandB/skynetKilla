package com.samara.model.getinfo;


import org.jsoup.nodes.Document;

import javax.swing.*;
import java.util.List;


/**
 * Created by sr01001 on 14/01/2016.
 */
public interface StrategyEntity {
    List getInfo (Document doc);
    List getInfo (JTable table);


}
