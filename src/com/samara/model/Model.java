package com.samara.model;


import com.samara.data.*;
import com.samara.model.getinfo.BGTpartsCreator;
import com.samara.model.getinfo.BRList;
import com.samara.model.getinfo.CommandList;
import com.samara.model.getinfo.NearestLivrables;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by ux11111 on 11/01/2016.
 */
public class Model {


    public static final String LOGINURL = "http://skynet2.int.dosamara.ru/main/login";
    public static final String URLLIVRABLE = "http://skynet2.int.dosamara.ru/main/nearest_livrables/";
    public static final String URLDEPT = "http://skynet2.int.dosamara.ru/prodreport/index/";
    public static final String URLMAIN = "http://skynet2.int.dosamara.ru";
    public static final String URLCMD = "http://skynet2.int.dosamara.ru/ligne";
    public static final String URLDEPTSN = "http://skynet2.int.dosamara.ru/bgtpart/create/1";
    public static final String URLCLOTURE = "http://skynet2.int.dosamara.ru/cloture";
    public static final String URLDELPART = "http://skynet2.int.dosamara.ru/bgtpart/delete/";

    public static final String URLDEPTPRJ = "http://skynet2.int.dosamara.ru/heurreport/index";
    public static final String URLBR = "http://skynet2.int.dosamara.ru/br";


    private boolean statusGet = false;
    private boolean isLivrExist = false;
    private boolean BGTstatus = false;
    private String userIDReal = "";  //samara description

    private Map<String, String> cookies;
    private Map<String,String> mapDEPTSnecma;
    private Map<String,String> mapDEPTsamara;
    private Map<String,String> mapDEPTGlobal;
    private Map<String,String> mapDEPTUserId;
    private Map<String,String> mapDEPTPrjId;
    private Map<String,String> mapTaux;
    private Map<String,String> mapCloture;
    private Map<String,String> mapUser;

    private List<BR> brList;
    private List<Livrable> livrableList;
    private List<Command> cmdList;
    private List<BGTPart> bgtPartList;
    private List<BGTPartValidity> bgtPartValiditiesList;

    private String UserId;  //skynet description

    public Model(){
        mapUser = new HashMap<>();
        mapUser.put("ux11111","S_CM1");
        mapUser.put("ux11306","S_CT");
        mapUser.put("ux11120","S_CM5");

    }

    public String getUserIDReal() {
        return userIDReal;
    }

    public void setUserIDReal(String userIDReal) {
        this.userIDReal = userIDReal;
    }

    public boolean isLivrExist() {
        return isLivrExist;
    }

    public void setIsLivrExist(boolean isLivrExist) {
        this.isLivrExist = isLivrExist;
    }

    public boolean isStatusGet() {
        return statusGet;
    }

    public void setStatusGet(boolean statusGet) {
        this.statusGet = statusGet;
    }

    public boolean isBGTstatus() {
        return BGTstatus;
    }

    public void setBGTstatus(boolean BGTstatus) {
        this.BGTstatus = BGTstatus;
    }

    public Map<String, String> getMapUser() {
        return mapUser;
    }

    public Map<String, String> getMapCloture() {
        return mapCloture;
    }

    public void setMapCloture(Map<String, String> mapCloture) {
        this.mapCloture = mapCloture;
    }

    public Map<String, String> getMapTaux() {
        return mapTaux;
    }

    public void setMapTaux(Map<String, String> mapTaux) {
        this.mapTaux = mapTaux;
    }

    public Map<String, String> getMapDEPTPrjId() {
        return mapDEPTPrjId;
    }

    public void setMapDEPTPrjId(Map<String, String> mapDEPTPrjId) {
        this.mapDEPTPrjId = mapDEPTPrjId;
    }

    public Map<String, String> getMapDEPTUserId() {
        return mapDEPTUserId;
    }

    public void setMapDEPTUserId(Map<String, String> mapDEPTUserId) {
        this.mapDEPTUserId = mapDEPTUserId;
    }

    public Map<String, String> getMapDEPTSnecma() {
        return mapDEPTSnecma;
    }

    public void setMapDEPTSnecma(Map<String, String> mapDEPTSnecma) {
        this.mapDEPTSnecma = mapDEPTSnecma;
    }

    public Map<String, String> getMapDEPTsamara() {
        return mapDEPTsamara;
    }

    public void setMapDEPTsamara(Map<String, String> mapDEPTsamara) {
        this.mapDEPTsamara = mapDEPTsamara;
    }

    public Map<String, String> getMapDEPTGlobal() {
        return mapDEPTGlobal;
    }

    public void setMapDEPTGlobal(Map<String, String> mapDEPTGlobal) {
        this.mapDEPTGlobal = mapDEPTGlobal;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public Map<String, String> getCookies() {
        return cookies;
    }

    private void setCookies(Map<String, String> cookies) {
        this.cookies = cookies;
    }

    public List<BGTPartValidity> getBgtPartValiditiesList() {
        return bgtPartValiditiesList;
    }

    public void setBgtPartValiditiesList(List<BGTPartValidity> bgtPartValiditiesList) {
        this.bgtPartValiditiesList = bgtPartValiditiesList;
    }

    public boolean logOn(String login, String password){
        boolean status = false;

        try {
            Connection.Response response = Jsoup.connect(LOGINURL)
                    .data("login", login)
                    .data("password", password)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.90 Safari/537.36")
                    .followRedirects(true)
                    .timeout(15000)
                    .method(Connection.Method.POST)
                    .execute();

            setCookies(response.cookies());

            status = verifySession();

         }catch (UnknownHostException e){
            System.out.println("Unknown host");

        } catch (IOException e){

                e.printStackTrace();
         }

        return status;
    }

    public void deletePart(String number){
        Document delete = getDocument(URLDELPART + number);

    }

    public boolean verifySession(){
        boolean status;
        Document docVerif = getDocument(URLMAIN);
        if (docVerif.html().toString().contains("Logged as")) {
            setUserId(docVerif.getElementsByAttributeValueContaining("href", "/simpleprofile?login").text());
            System.out.println("Login OK!");
            System.out.println("Name " + getUserId());

            status = true;
        } else {
            status = false;
        }
        return status;
    }

    public static String getKeysByValue(Map<String, String> map, String value) {
        for (String valSearch : map.keySet()){
            if(map.get(valSearch).equals(value)){
                return valSearch;
            }
        }return null;
    }

    public static String getValueByKey(Map<String, String> map, String key) {
        for(Map.Entry<String, String> pair : map.entrySet()) {
            if(pair.getKey().contains(key)){
                return pair.getValue();
            }

        }return null;
    }

    public static Map<String, String> getKeysByValueMap(Map<String, String> map, String value) {
    Map<String,String> mapVerif = new HashMap<>();
        for(Map.Entry<String, String> pair : map.entrySet()) {
            if(pair.getValue().contains(value)){
               mapVerif.put(pair.getKey(),pair.getValue());
        }
         }return mapVerif;
    }

    public void getEntity(String str){

            if (str.equals("Livrable")) {
                try{
                Provider livrableProvider = new Provider(new NearestLivrables());
                setLivrableList(livrableProvider.executeStrategy(getDocument(URLLIVRABLE)));
                    setIsLivrExist(true);
                System.out.println(getLivrableList().size());
                 }catch (IndexOutOfBoundsException e){
                 System.out.println("No Data");
                    setIsLivrExist(false);
             }
           } else if (str.equals("Command")) {
                Provider cmdProvider = new Provider(new CommandList());

                setCmdList(cmdProvider.executeStrategy(getDocument(URLCMD)));
                System.out.println(getCmdList().size());
            } else if (str.equals("BR")) {
                Provider brProvider = new Provider(new BRList());

                setBrList(brProvider.executeStrategy(getDocument(URLBR)));
                System.out.println(getBrList().size());
            } else System.out.println("Not accepted");

    }

    public void verifyEntity(String str, JTable table){
        if (str.equals("Livrable")){
            Provider livrableProvider = new Provider(new NearestLivrables());

            setLivrableList(livrableProvider.executeStrategy(table));
            System.out.println(getLivrableList().size());
            for (Livrable liv : getLivrableList()) {
                System.out.println("# " + liv.getName() + " # " + liv.getDdi_id() + " # " + liv.getDept_id() + " # " + liv.getProject_id() +
                 " # " + liv.getDate_end_ini() + " # " + liv.getDate_end_real() + " # " + liv.getDate_end_agreed() + " # " + liv.getStatus() + " # " + liv.getLinkLivr());
            }
        }
        if (str.equals("BGTparts")) {
            Provider cmdProvider = new Provider(new BGTpartsCreator());

            setBgtPartList(cmdProvider.executeStrategy(table));

            List<BGTPartValidity> listVa = new ArrayList<>();

            for(BGTPart prt: getBgtPartList()){
                listVa.add(verifyEntity(prt));

            }
            setBgtPartValiditiesList(listVa);
            boolean state = true;
            int count = 1;
            for(BGTPartValidity valPart: getBgtPartValiditiesList()){

                if(valPart.isValidAll()){
                    System.out.println("row " + count + " : OK");
                    System.out.println("########################");
                }else{
                    state = false;
                    System.out.println("row " + count + " : NOK");
                    if(!valPart.isValidCommand() || !valPart.isValidLine()){
                        System.out.println("Wrong command number or ligne");
                    }
                    if(!valPart.isValidStatus()){
                        System.out.println("Command status is \"Canceled\"");
                    }
                    if(!valPart.isValidVal()){
                        System.out.println("Not enough budget in line or Budget value more than budget BR");
                    }
                    if(!valPart.isValidBR() || !valPart.isValidBRVal()){
                        System.out.println("Wrong BR or BR value");
                    }
                    if(!valPart.isValidDeptSN()){
                        System.out.println("Department of SNECMA is absent in the List of departments of Skynet");
                    }
                    if(!valPart.isValidDeptSMC()){
                        System.out.println("Wrong Department of samara");
                    }
                    if(!valPart.isValidTaux()){
                        System.out.println("Wrong Taux!");

                    }
                    if(!valPart.isValidCloture()){
                        System.out.println("Cloture is absent in the List of clotures of Skynet");
                    }
                    System.out.println("########################");
                }
                count++;
            }
               setBGTstatus(state);
            System.out.println(isBGTstatus());
        }
    }

    public BGTPartValidity verifyEntity(BGTPart part) {

        int countAll = 0;

        BGTPartValidity bgtPartValidity = new BGTPartValidity();

        //command
        for (Command cmd : getCmdList()) {
            //verify command and line
            if (cmd.getCommandNumber().replaceAll(" ", "").equals(part.getCmd_id().replaceAll(" ", "")) &&
                    cmd.getLigneNumber().trim().equals(part.getLigne_id().trim())) {
                bgtPartValidity.setValidCommand(true);
                bgtPartValidity.setValidLine(true);
                part.setLinkCreate(cmd.getLinkLigne().replace("ligne/edit/", "bgtpart/create/"));
                ///verify status command
                if (cmd.getStatus().equals("Open")) {
                    bgtPartValidity.setValidStatus(true);
                } else {
                    bgtPartValidity.setValidStatus(false);
                    countAll++;
                }
                //verify freevalue
                if (Integer.parseInt(cmd.getFreeValue()) >= Integer.parseInt(part.getPart_value().trim())) {
                    bgtPartValidity.setValidVal(true);
                } else {
                    bgtPartValidity.setValidVal(false);
                    countAll++;
                }
                break;
            } else if (!bgtPartValidity.isValidCommand()) {
            } else {
                bgtPartValidity.setValidCommand(false);
                bgtPartValidity.setValidLine(false);
                countAll++;
            }

        }

        //verify BR and BRVal

        for (BR brve : getBrList()) {

            if (brve.getBrRef().trim().equals(part.getBr_nom().trim()) &&
                    brve.getSumValue().trim().equals(part.getBr_budget().trim()) &&
                    brve.getCommandNumber().replaceAll(" ", "").equals(part.getCmd_id().replaceAll(" ", "")) &&
                    brve.getLigneNumber().trim().equals(part.getLigne_id().trim())) {
                bgtPartValidity.setValidBR(true);
                bgtPartValidity.setValidBRVal(true);
                if (Integer.parseInt(brve.getSumValue().trim()) < Integer.parseInt(part.getPart_value()) && bgtPartValidity.isValidVal()) {
                    bgtPartValidity.setValidVal(false);
                    countAll++;
                }
                break;
            } else if (!bgtPartValidity.isValidBR()) {

            } else {
                bgtPartValidity.setValidBR(false);
                bgtPartValidity.setValidBRVal(false);
                countAll++;
            }

        }
//verify SN dept

        if (getMapDEPTSnecma().containsKey(getKeysByValue(getMapDEPTSnecma(), part.getClt_dept_id()))) {
            bgtPartValidity.setValidDeptSN(true);
        } else {
            part.setClt_dept_id(part.getClt_dept_id().substring(0, 3));
            if (getMapDEPTSnecma().containsKey(getKeysByValue(getMapDEPTSnecma(), part.getClt_dept_id()))) {
                bgtPartValidity.setValidDeptSN(true);
            } else {

                bgtPartValidity.setValidDeptSN(false);
                countAll++;
            }

        }

        //verify SM dept
        if(getMapDEPTsamara().containsKey(getKeysByValue(getMapDEPTsamara(), part.getDept_id()))){
            bgtPartValidity.setValidDeptSMC(true);
        }else{
            bgtPartValidity.setValidDeptSMC(false);
            countAll++;
        }
//verify taux
        if (getMapTaux().containsKey(getKeysByValue(getMapTaux(), part.getTaux()))){
            bgtPartValidity.setValidTaux(true);
        }else{
            bgtPartValidity.setValidTaux(false);
            countAll++;
        }
//verify clt map

        if(getKeysByValueMap(getMapCloture(),part.getDept_id()).containsKey(part.getCloture())){
            bgtPartValidity.setValidCloture(true);
        }else{
            bgtPartValidity.setValidCloture(false);
            countAll++;
        }



        System.out.println("Count All is : " +  countAll);
        if(countAll == 0 ){
            bgtPartValidity.setValidAll(true);
        } else {
            bgtPartValidity.setValidAll(false);
        }
        System.out.println("Status All " + bgtPartValidity.isValidAll());
        return bgtPartValidity;
    }

    public void executeEntity(List list){
          if(list.get(0) instanceof Livrable){
          try {
                List<Livrable> listL = list;
              for (Livrable liv : listL) {
                    System.out.println(liv.getName());
                    Connection.Response responseL = postDocument(URLMAIN + liv.getLinkLivr(), liv);
                   System.out.println(responseL.statusMessage());

                    System.out.println();
                }
        }catch (IOException e){
               e.printStackTrace();
           }
        }
        if(list.get(0) instanceof Command){
            try {
                List<Command> listC = list;
                for (Command cmd : listC) {

                    System.out.println(postDocumentToLog(cmd));

                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if(list.get(0) instanceof BR){
            try {
                List<BR> listB = list;
                for (BR br : listB) {

                    System.out.println(postDocumentToLog(br));

                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if(list.get(0) instanceof BGTPart){
           try {
                List<BGTPart> listB = list;
                for (BGTPart bgt : listB) {
                    System.out.println(postDocumentToLog(bgt));
                    System.out.println(bgt.getLinkCreate());

                                Connection.Response responseB = postDocument(URLMAIN + bgt.getLinkCreate(), bgt);
                                System.out.println(responseB.statusMessage());
                    System.out.println(responseB.statusCode());



                    System.out.println();
                }
          }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    public List<BR> getBrList() {
        return brList;
    }

    public void setBrList(List<BR> brList) {
        this.brList = brList;
    }

    public List<Livrable> getLivrableList() {
        return livrableList;
    }

    public void setLivrableList(List<Livrable> livrableList) {
        this.livrableList = livrableList;
    }

    public List<Command> getCmdList() {
        return cmdList;
    }

    public void setCmdList(List<Command> cmdList) {
        this.cmdList = cmdList;
    }

    public List<BGTPart> getBgtPartList() {
        return bgtPartList;
    }

    public void setBgtPartList(List<BGTPart> bgtPartList) {
        this.bgtPartList = bgtPartList;
    }

    public void getAllDeptInfo(){
        String cltDep[] = {"M_D1", "M_CM2", "M_CM1", "M_D3", "M_CT1", "M_CT2", "M_E", "M_ADM",
                "S_CM1", "S_CM2", "S_CM3", "S_CM4", "S_CM5", "S_CM6", "S_CM7", "S_CM8", "S_CD", "S_D1", "S_CT"};

        Connection.Response response = null;
        Document document3 = null;
       Map<String,String> allClt = new HashMap<>();
        for (int i = 0; i < cltDep.length; i++) {
            try {

                response = postDocument(URLCLOTURE, cltDep[i]);
                document3 = response.parse();
                Map<String,String> mP = parseDeptOption(document3);
                allClt.putAll(mP);

            }catch(IOException e){
                e.printStackTrace();
            }
          }
        setMapCloture(allClt);

    }

    public void getDeptInfo(){



           Document document =  getDocument(URLDEPT);

           setMapDEPTsamara(parseDeptOption(document, "name", "depts[]"));
           setMapDEPTGlobal(parseDeptOption(document, "name", "comp_id[]"));
           Document document1 = getDocument(URLDEPTSN);
           setMapDEPTSnecma(parseDeptOption(document1, "name", "clt_dept_id"));
        setMapTaux(parseDeptOption(document1, "name", "rate_id"));


           Document document2 =  getDocument(URLDEPTPRJ);

           setMapDEPTPrjId(parseDeptOption(document2, "name", "project_id"));
           setMapDEPTUserId(parseDeptOption(document2, "name", "user_id"));
           getKeysByValue(getMapDEPTUserId(), getUserId());

        //collection of list the clotures all departements of samara


        try {
            System.out.println(getValueByKey(getMapUser(), getUserIDReal()));
            Connection.Response response = postDocument(URLCLOTURE, getValueByKey(getMapUser(), getUserIDReal()));
            Document document3 = response.parse();
            setMapCloture(parseDeptOption(document3));

        }catch(IOException e){
            e.printStackTrace();
        }


        setStatusGet(true);

    }

    protected Map<String,String> parseDeptOption(Document document, String attrSearch, String attrSearchName){
            Map<String, String> deptsamara = new HashMap<>();
            Element mySelect = document.getElementsByAttributeValue(attrSearch, attrSearchName).get(0);
            Elements options = mySelect.getElementsByTag("option");
            for (Element option : options) {
                if(option.attr("value").equals("")){
                    continue;
                }else {
                    if (option.text().contains(" / ")){
                        for (int i = 0; i < option.text().length(); i++) {
                            if (option.text().charAt(i) == '/' && i <10) {
                                if (option.text().charAt(i - 1) == ' ') {
                                    String optionModif = option.text().substring(0, i - 1).trim();
                                    deptsamara.put(option.attr("value"), optionModif);
                                    System.out.println("Value " + option.attr("value") + " Name " + optionModif);
                               } else continue;
                            }
                        }
                    }else {
                        deptsamara.put(option.attr("value"), option.text());
                        System.out.println("Value " + option.attr("value") + " Name " + option.text());
                    }
                }
            }
            return deptsamara;
        }

    protected Map<String,String> parseDeptOption(Document document){
            Map<String, String> map = new HashMap<>();

                 Element table = document.select("table").get(1); //select the second table.

                 Elements rows = table.select("tr");

                 for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.

                     Element row = rows.get(i);
                     Elements cols = row.select("td");

                     if(cols.get(11).text().length() != 0 || cols.get(12).text().length() != 0) {
                         System.out.println("Name " + cols.get(0).text());
                         System.out.println("P1 " + cols.get(11).text());
                         System.out.println("P2 " + cols.get(12).text());

                         continue;
                     }else {
                         String temp="";

                         Pattern p = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
                         Matcher m = p.matcher(cols.get(0).getElementsByTag("a").attr("href").toString());
                         while (m.find()) {
                             temp = m.group();
                         }
                         System.out.println("Name " + cols.get(0).text());
                         System.out.println("Value " + temp);
                         System.out.println("P1 " + cols.get(11).text());
                         System.out.println("P2 " + cols.get(12).text());
                         map.put(temp,cols.get(0).text());
                     }
                 }
                 return map;

         }

    protected Document getDocument(String URL){
            Document doc = null;
            int retry = 0;
            int timeOut = 2500;
            while(doc == null && retry<5) {
                retry++;
                try {
                    doc = Jsoup.connect(URL)
                            .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.90 Safari/537.36")
                            .cookies(getCookies())
                            .timeout(timeOut)
                            .get();
                } catch (IOException e) {
                    System.out.println("JSoup didn't get a document");
                    timeOut = timeOut + 2500;
                    System.out.println("New timeout = " + timeOut);
                }
            }

           return doc;
        }

    protected Connection.Response postDocument(String URL, Object o) throws IOException{

             if(o instanceof Livrable){

                 return  Jsoup.connect(URL)
                            .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.90 Safari/537.36")
                            .followRedirects(true)
                            .cookies(getCookies())
                            .data("name", ((Livrable) o).getName())
                            .data("ddi_id", getKeysByValue(getMapDEPTGlobal(), ((Livrable) o).getDdi_id()))
                            .data("dept_id", getKeysByValue(getMapDEPTsamara(), ((Livrable) o).getDept_id()))
                            .data("project_id", getKeysByValue(getMapDEPTPrjId(), ((Livrable) o).getProject_id()))
                            .data("date_end_ini", ((Livrable) o).getDate_end_ini())
                            .data("date_end_real", ((Livrable) o).getDate_end_real())
                            .data("date_end_agreed", ((Livrable) o).getDate_end_agreed())
                            .data("status", ((Livrable) o).identStatus(((Livrable) o).getStatus())) //4 - Deleted; 3 - Accepted; 2 -Delivered; 1 - Open
                            .data("responsible", getKeysByValue(getMapDEPTUserId(), getUserId()))
                            .data("submit", "Save")
                            .timeout(10000)
                            .method(Connection.Method.POST)
                            .execute();

             } else if(o instanceof BGTPart) {
                 System.out.println("postdoc");

                 String cmdIDVal = "";
                 String ligneIDVal = "";
                 String brNomVal = "";

                FileInputStream fs1 = null;
                 String name1 = "";
                FileInputStream fs2 = null;
                String name2 = "";
                 String bldate = "";
                 String ctdate = "";
                 String ctnote = "";

                 if(((BGTPart) o).getBl_link().length() > 0){
                     try {
                         fs1 = new FileInputStream(new File(((BGTPart) o).getBl_link()));
                         String path = ((BGTPart) o).getBl_link().replaceAll("\\\\", "/");

                         name1 = path.substring(path.lastIndexOf("/") + 1, path.length());
                         if(isDateValid(((BGTPart) o).getBl_date())){
                             bldate = ((BGTPart) o).getBl_date();
                         }
                     } catch (FileNotFoundException e){
                         System.out.println("File not found");
                     }
                 }
                 if(((BGTPart) o).getCt_link().length() > 0){
                     try {
                         fs2 = new FileInputStream(new File(((BGTPart) o).getCt_link()));
                         String path2 = ((BGTPart) o).getCt_link().replaceAll("\\\\", "/");

                         name2 = path2.substring(path2.lastIndexOf("/") + 1, path2.length());
                         if(isDateValid(((BGTPart) o).getCt_date())){
                            ctdate = ((BGTPart) o).getCt_date();
                         }
                         ctnote = ((BGTPart) o).getCt_value();
                     } catch (FileNotFoundException e){
                         System.out.println("File not found");
                     }
                 }


                 for(Command cmd : getCmdList() ){
                     if(cmd.getCommandNumber().replaceAll(" ", "").equals(((BGTPart) o).getCmd_id().replaceAll(" ", ""))){
                         Pattern p = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
                         Matcher m = p.matcher(cmd.getLinkCommand());
                         while (m.find()) {
                             cmdIDVal = m.group();
                         }
                     }
                     if(cmd.getCommandNumber().replaceAll(" ", "").equals(((BGTPart) o).getCmd_id().replaceAll(" ", "")) &&
                             cmd.getLigneNumber().trim().equals(((BGTPart) o).getLigne_id().trim())){
                         Pattern p = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
                         Matcher m = p.matcher(cmd.getLinkLigne());
                         while (m.find()) {
                             ligneIDVal = m.group();
                         }

                     }
                 }
                 for(BR brve: getBrList()){
                     if(brve.getBrRef().trim().equals(((BGTPart) o).getBr_nom().trim()) &&
                             brve.getSumValue().trim().equals(((BGTPart) o).getBr_budget().trim())){
                         Pattern p = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
                         Matcher m = p.matcher(brve.getLinkBR());
                         while (m.find()) {
                             brNomVal = m.group();
                         }
                     }
                 }
                 System.out.println(URL);
                 System.out.println("cmdIDVal:" + cmdIDVal);
                 System.out.println("ligneIDVal:" + ligneIDVal);
                 System.out.println("dept_id:" + getKeysByValue(getMapDEPTsamara(), ((BGTPart) o).getDept_id()));
                 System.out.println("clt_dept_id:" + getKeysByValue(getMapDEPTSnecma(), ((BGTPart) o).getClt_dept_id()));
                 System.out.println("summ:" + ((BGTPart) o).getPart_value().trim());
                 System.out.println("rate_id:" + getKeysByValue(getMapTaux(), ((BGTPart) o).getTaux()));
                 System.out.println("comment:" + ((BGTPart) o).getComment());
                 System.out.println("ct_value:" + ((BGTPart) o).getBr_budget());
                 System.out.println("Cloture:" + ((BGTPart) o).getCloture());
                 System.out.println("brNomVal" + brNomVal);

                 return  Jsoup.connect(URL)
                         .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.90 Safari/537.36")
                         .followRedirects(true)
                         .ignoreHttpErrors(true)
                         .cookies(getCookies())
                         .data("br_date", "")
                         .data("br_ref", "")
                         .data("value", "")
                         .data("br_status", "")
                         .data("cmd_id", cmdIDVal)
                         .data("ligne_id", ligneIDVal)
                         .data("dept_id", getKeysByValue(getMapDEPTsamara(),((BGTPart) o).getDept_id()))
                         .data("clt_dept_id", getKeysByValue(getMapDEPTSnecma(), ((BGTPart) o).getClt_dept_id()))
                         .data("part_cloture_id", ((BGTPart) o).getCloture())  //number of cloture
                         .data("part", "")
                         .data("summ", ((BGTPart) o).getPart_value().trim())
                         .data("rate_id", getKeysByValue(getMapTaux(), ((BGTPart) o).getTaux()))
                         .data("comment", ((BGTPart) o).getComment())
                         .data("bl_doc_id", "")
                         .data("bl_doc_file", name1 , fs1)  ///.data("bl_doc_file", name1 , fs1)
                         .data("bl_doc_date", bldate)   //.data("bl_doc_date", bldate)
                         .data("dc_doc_id", "")
                         .data("dc_doc_file", "", null)
                         .data("ct_doc_id", "")
                         .data("ct_doc_file", name2, fs2)  //.data("ct_doc_file", name2, fs2)
                         .data("redirect_cloture", "0")
                         .data("ct_doc_date", ctdate)  //.data("ct_doc_date", ctdate)
                         .data("ct_note", ctnote)  //.data("ct_note", ctnote)
                         .data("ct_value", ((BGTPart) o).getBr_budget())
                         .data("act_id", "")
                         .data("cloture_id", "")
                         .data("act_file", "", null)
                         .data("date_fin_anti", "")
                         .data("br_ref_number", brNomVal) //.data("br_ref_number", brNomVal)
                         .data("submit", "Save")
                         .timeout(10000)
                         .method(Connection.Method.POST)
                         .execute();

             }else {
                 System.out.println("Incorrect data");
                 return null;
             }


    }

    protected Connection.Response postDocument(String URL, String str) throws IOException{
        System.out.println(str);

        Connection.Response response = null;
        int retry = 0;
        int timeOut = 15000;
        while(response == null  && retry<5) {
            retry++;
            try {
                response = Jsoup.connect(URL)
                        .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.90 Safari/537.36")
                        .followRedirects(true)
                        .cookies(getCookies())
                        .data("cloturefilter_dept_id", getKeysByValue(getMapDEPTsamara(), str))
                        .data("cloturefilter_date_operation", "equals")
                        .data("cloturefilter_completion_date", "")
                        .data("submit", "Apply")
                        .timeout(timeOut)
                        .method(Connection.Method.POST)
                        .execute();
            } catch (IOException e) {
                System.out.println("JSoup didn't get a document");
                timeOut = timeOut + 5000;
                System.out.println("New timeout = " + timeOut);
            }
        }

        return response;



        }

    protected String postDocumentToLog(Object o) throws IOException{

        if(o instanceof Livrable){
             String builder;

            builder = "name " + ((Livrable) o).getName() + "\n" +
                        "ddi_id " + getKeysByValue(getMapDEPTGlobal(), ((Livrable) o).getDdi_id()) + "\n" +
                        "dept_id " + getKeysByValue(getMapDEPTsamara(), ((Livrable) o).getDept_id()) + "\n" +
                        "project_id " + getKeysByValue(getMapDEPTPrjId(), ((Livrable) o).getProject_id()) + "\n" +
                        "date_end_ini " + ((Livrable) o).getDate_end_ini() + "\n" +
                        "date_end_real " + ((Livrable) o).getDate_end_real() + "\n" +
                        "date_end_agreed " + ((Livrable) o).getDate_end_agreed() + "\n" +
                        "status " + "3" + "\n" +
                        "responsible " + getKeysByValue(getMapDEPTUserId(), getUserId()) + "\n" +
                        "submit " + "Save" + "\n" +
                        "Link " + ((Livrable) o).getLinkLivr();


            return builder;

        }else if(o instanceof Command) {
            String builder;
            builder =   "CMD " + ((Command) o).getCommandNumber() + "\n" +
                    "Ligne " + ((Command) o).getLigneNumber() + "\n" +
                    "FreeValue " + ((Command) o).getFreeValue() + "\n" +
                    "DeptClient " + getKeysByValue(getMapDEPTSnecma(),((Command) o).getDeptClient()) + "\n" +
                    "Status " + ((Command) o).getStatus() + "\n" +
                    "LinkCMD " + ((Command) o).getLinkCommand() + "\n" +
                    "LinkLigne " + ((Command) o).getLinkLigne() + "\n";
            return builder;
        }else if(o instanceof BR) {
            String builder;
            builder =   "BRRef " + ((BR) o).getBrRef() + "\n" +
                    "Command " + ((BR) o).getCommandNumber() + "\n" +
                    "Ligne  " + ((BR) o).getLigneNumber() + "\n" +
                    "SumValue " + ((BR) o).getSumValue() + "\n" +
                    "LinkBR " + ((BR) o).getLinkBR() + "\n";
            return builder;
        }else if(o instanceof BGTPart) {
            String builder;
            String cmdIDVal = "";
            String ligneIDVal = "";
            String brNomVal = "";

            FileInputStream fs1 = null;
            String name1 = "";
            FileInputStream fs2 = null;
            String name2 = "";
            String bldate = "";
            String ctdate = "";
            String ctnote = "";

            if(((BGTPart) o).getBl_link().length() > 0){
                try {
                    fs1 = new FileInputStream(new File(((BGTPart) o).getBl_link()));
                    String path = ((BGTPart) o).getBl_link().replaceAll("\\\\", "/");

                    name1 = path.substring(path.lastIndexOf("/") + 1, path.length());
                    if(isDateValid(((BGTPart) o).getBl_date())){
                        bldate = ((BGTPart) o).getBl_date();
                    }
                } catch (FileNotFoundException e){
                    System.out.println("File not found");
                }
            }
            if(((BGTPart) o).getCt_link().length() > 0){
                try {
                    fs2 = new FileInputStream(new File(((BGTPart) o).getCt_link()));
                    String path2 = ((BGTPart) o).getCt_link().replaceAll("\\\\", "/");

                    name2 = path2.substring(path2.lastIndexOf("/") + 1, path2.length());
                    if(isDateValid(((BGTPart) o).getCt_date())){
                        ctdate = ((BGTPart) o).getCt_date();
                    }
                    ctnote = ((BGTPart) o).getCt_value();
                } catch (FileNotFoundException e){
                    System.out.println("File not found");
                }
            }


            for(Command cmd : getCmdList() ){
                if(cmd.getCommandNumber().replaceAll(" ","").equals(((BGTPart) o).getCmd_id().replaceAll(" ",""))){
                    Pattern p = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
                    Matcher m = p.matcher(cmd.getLinkCommand());
                    while (m.find()) {
                        cmdIDVal = m.group();
                    }
                }
                if(cmd.getCommandNumber().replaceAll(" ","").equals(((BGTPart) o).getCmd_id().replaceAll(" ","")) &&
                        cmd.getLigneNumber().trim().equals(((BGTPart) o).getLigne_id().trim())){
                    Pattern p = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
                    Matcher m = p.matcher(cmd.getLinkLigne());
                    while (m.find()) {
                        ligneIDVal = m.group();
                    }

                }
            }
            for(BR brve: getBrList()){
                if(brve.getBrRef().trim().equals(((BGTPart) o).getBr_nom().trim()) &&
                        brve.getSumValue().trim().equals(((BGTPart) o).getBr_budget().trim())){
                    Pattern p = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
                    Matcher m = p.matcher(brve.getLinkBR());
                    while (m.find()) {
                        brNomVal = m.group();
                    }
                }
            }


            builder = "CMD_ID " + cmdIDVal + "\n" +
                    "Ligne_ID " + ligneIDVal + "\n" +
                    "Dept_ID  " + getKeysByValue(getMapDEPTsamara(), ((BGTPart) o).getDept_id()) + "\n" +
                    "Clt_Dept_id " + getKeysByValue(getMapDEPTSnecma(), ((BGTPart) o).getClt_dept_id()) + "\n" +
                    "Summ " + ((BGTPart) o).getPart_value().trim() +
                    "rate_ID " + getKeysByValue(getMapTaux(), ((BGTPart) o).getTaux()) + "\n" +
                    "comment  " + ((BGTPart) o).getComment() + "\n" +
                    "bldocname " + name1 + "\n" +
                    "bldate " + bldate +
                    "ctname " + name2 + "\n" +
                    "ctdate  " + ctdate + "\n" +
                    "ctnote " + ctnote + "\n" +
                    "ctvalue " + ((BGTPart) o).getBr_budget() +
                    "brref " + brNomVal + "\n";
            return builder;
        }else{
            System.out.println("NULL");
            return null;
        }
    }

    final static String DATE_FORMAT = "dd.MM.yyyy";

    public static boolean isDateValid(String date)
    {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

}
