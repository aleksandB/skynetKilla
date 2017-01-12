package com.samara;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alex on 22.02.2016.
 */
public class CompileTest {

    public static void main(String[] args) {
        String str="";
        Pattern p = Pattern.compile("-?\\d+");
        Matcher m = p.matcher("bgtpart/create/1254644");
        while (m.find()) {

            str = m.group();
        }


    }
}
