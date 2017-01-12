package com.samara.controller;

import com.samara.model.Model;
import com.samara.view.View;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;


/**
 * Created by sr01001 on 11/01/2016.
 */
public class Controller {
    private Model model;
    private ActionListener actionListenerItems, actionListenerButtons;
    private boolean statusLivr = false;

    public boolean isStatusLivr() {
        return statusLivr;
    }

    public void setStatusLivr(boolean statusLivr) {
        this.statusLivr = statusLivr;
    }

    private View view;
    private ActionListener actionListenerOK;
    private ActionListener actionListenerCancel;
    private ActionListener actionListenerExit;
    private WindowListener windowListner;
    private KeyListener keyListener;
    private ListSelectionListener tableListner;


    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }


    public void contoll() {

///Begin controller LoginForm
        {


            actionListenerOK = new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                   verifyLogOn();
                }
            };

            actionListenerCancel = new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    view.getlFrame().dispose();
                }
            };

            keyListener = new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        System.out.println("ENTER");
                        verifyLogOn();
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {

                }
            };

            view.getlFrame().getButtons()[0].addActionListener(actionListenerOK);
            view.getlFrame().getButtons()[1].addActionListener(actionListenerCancel);
            view.getlFrame().getLoginPanel().addKeyListener(keyListener);
            view.getlFrame().getTextFields()[0].addKeyListener(keyListener);
            view.getlFrame().getTextFields()[1].addKeyListener(keyListener);
        }
////End Controller LoginForm

///Begin controller AccessForm
        {

            actionListenerExit = new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    view.getaFrame().dispose();
                }
            };

            windowListner = new WindowListener() {
                @Override
                public void windowOpened(WindowEvent e) {
                    model.getDeptInfo();
                    model.getEntity("Command");
                    model.getEntity("BR");
                    view.getaFrame().dispose();
                    view.getmFrame().setVisible(true);
                }

                @Override
                public void windowClosing(WindowEvent e) {

                }

                @Override
                public void windowClosed(WindowEvent e) {

                }

                @Override
                public void windowIconified(WindowEvent e) {

                }

                @Override
                public void windowDeiconified(WindowEvent e) {

                }

                @Override
                public void windowActivated(WindowEvent e) {

                }

                @Override
                public void windowDeactivated(WindowEvent e) {

                }
            };

            view.getaFrame().getButtons()[0].addActionListener(actionListenerExit);

        }


///End controller AccessForm




///Begin controller MainForm

        actionListenerItems = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                   if (model.isStatusGet()) {
                         if (actionEvent.getActionCommand().equals("InfoDeptSnecma")) {
                             view.getmFrame().updateView(model.getMapDEPTSnecma());
                         }
                         if (actionEvent.getActionCommand().equals("InfoDeptsamara")) {
                             view.getmFrame().updateView(model.getMapDEPTsamara());
                         }
                         if (actionEvent.getActionCommand().equals("InfoDeptGlobal")) {
                             view.getmFrame().updateView(model.getMapDEPTGlobal());
                         }
                         if (actionEvent.getActionCommand().equals("InfoDeptUserID")) {
                             view.getmFrame().updateView(model.getMapDEPTUserId());
                         }
                         if (actionEvent.getActionCommand().equals("InfoDeptPrjID")) {
                             view.getmFrame().updateView(model.getMapDEPTPrjId());
                         }
                         if (actionEvent.getActionCommand().equals("InfoListBR")) {
                             view.getmFrame().updateViewBR(model.getBrList());
                         }
                         if (actionEvent.getActionCommand().equals("InfoListCMD")) {
                             view.getmFrame().updateViewCMD(model.getCmdList());
                         }
                         if (actionEvent.getActionCommand().equals("InfoListTaux")) {
                             view.getmFrame().updateView(model.getMapTaux());
                         }
                         if (actionEvent.getActionCommand().equals("InfoListCloture")) {
                             view.getmFrame().updateView(model.getMapCloture());
                         }
                         if (actionEvent.getActionCommand().equals("M_D1")) {
                             view.getmFrame().updateView(model.getKeysByValueMap(model.getMapCloture(), "M_D1"));
                         }
                         if (actionEvent.getActionCommand().equals("M_CM2")) {
                             view.getmFrame().updateView(model.getKeysByValueMap(model.getMapCloture(),"M_CM2"));
                         }
                         if (actionEvent.getActionCommand().equals("M_CM1")) {
                             view.getmFrame().updateView(model.getKeysByValueMap(model.getMapCloture(),"M_CM1"));
                         }
                         if (actionEvent.getActionCommand().equals("M_D3")) {
                             view.getmFrame().updateView(model.getKeysByValueMap(model.getMapCloture(),"M_D3"));
                         }
                         if (actionEvent.getActionCommand().equals("M_CT1")) {
                             view.getmFrame().updateView(model.getKeysByValueMap(model.getMapCloture(),"M_CT1"));
                         }
                         if (actionEvent.getActionCommand().equals("M_CT2")) {
                             view.getmFrame().updateView(model.getKeysByValueMap(model.getMapCloture(),"M_CT2"));
                         }
                         if (actionEvent.getActionCommand().equals("M_E")) {
                             view.getmFrame().updateView(model.getKeysByValueMap(model.getMapCloture(),"M_E"));
                         }
                       if (actionEvent.getActionCommand().equals("M_ADM")) {
                           view.getmFrame().updateView(model.getKeysByValueMap(model.getMapCloture(),"M_ADM"));
                       }
                         if (actionEvent.getActionCommand().equals("S_CM1")) {
                             view.getmFrame().updateView(model.getKeysByValueMap(model.getMapCloture(), "S_CM1"));
                         }
                         if (actionEvent.getActionCommand().equals("S_CM2")) {
                            view.getmFrame().updateView(model.getKeysByValueMap(model.getMapCloture(), "S_CM2"));
                         }
                         if (actionEvent.getActionCommand().equals("S_CM3")) {
                             view.getmFrame().updateView(model.getKeysByValueMap(model.getMapCloture(),"S_CM3"));
                         }
                         if (actionEvent.getActionCommand().equals("S_CM4")) {
                             view.getmFrame().updateView(model.getKeysByValueMap(model.getMapCloture(),"S_CM4"));
                         }
                         if (actionEvent.getActionCommand().equals("S_CM5")) {
                             view.getmFrame().updateView(model.getKeysByValueMap(model.getMapCloture(),"S_CM5"));
                         }
                         if (actionEvent.getActionCommand().equals("S_CM6")) {
                             view.getmFrame().updateView(model.getKeysByValueMap(model.getMapCloture(),"S_CM6"));
                         }
                         if (actionEvent.getActionCommand().equals("S_CM7")) {
                             view.getmFrame().updateView(model.getKeysByValueMap(model.getMapCloture(),"S_CM7"));
                         }
                         if (actionEvent.getActionCommand().equals("S_CM8")) {
                             view.getmFrame().updateView(model.getKeysByValueMap(model.getMapCloture(),"S_CM8"));
                         }
                         if (actionEvent.getActionCommand().equals("S_CD")) {
                             view.getmFrame().updateView(model.getKeysByValueMap(model.getMapCloture(),"S_CD"));
                         }
                         if (actionEvent.getActionCommand().equals("S_D1")) {
                             view.getmFrame().updateView(model.getKeysByValueMap(model.getMapCloture(),"S_D1"));
                         }
                         if (actionEvent.getActionCommand().equals("S_CT")) {
                             view.getmFrame().updateView(model.getKeysByValueMap(model.getMapCloture(),"S_CT"));
                         }
                         if (actionEvent.getActionCommand().equals("GetNearestLivrables")) {
                             if (model.verifySession()) {
                                 setStatusLivr(false);
                                 model.getEntity("Livrable");
                                 if (model.isLivrExist()) {
                                     view.getmFrame().updateViewLivr(model.getLivrableList());
                                 } else {
                                     view.getmFrame().getLable().setText("No nearests livrables");
                                     view.getmFrame().updateView("Livrable");

                                 }
                             } else {
                                 System.out.println("Session Failed");
                                 restartSession();
                             }}
                             if (actionEvent.getActionCommand().equals("SetPartsByTable")) {
                                 view.getmFrame().updateView("CMD");
                             }

                              if (actionEvent.getActionCommand().equals("DeleteBGTParts")) {
                                  if (model.getUserIDReal().equals("sr01001")) {
                                      view.getDelFrame().setVisible(true);
                                      System.out.println("test");
                                  } else {
                                      System.out.println("test2");
                                      view.getaFrameInt().getLabels()[0].setText("Logged as " + model.getUserId());
                                      view.getaFrameInt().setVisible(true);
                                  }
                              }
                                if (actionEvent.getActionCommand().equals("GetInfo") ) {
                                    if (model.getUserIDReal().equals("sr01001")) {
                                        if (model.verifySession()) {
                                            model.getAllDeptInfo();
                                            view.getmFrame().getLable().setText("Info for all depts have collected");

                                        } else {
                                            System.out.println("Session Failed");
                                            restartSession();
                                        }
                                    } else {
                                        view.getaFrameInt().getLabels()[0].setText("Logged as " + model.getUserId());
                                        view.getaFrameInt().setVisible(true);
                                    }
                                }

                         } else {
                            view.getmFrame().getLable().setText("Information has not collected");
                         }

            }
        };

        actionListenerButtons = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

                    if (actionEvent.getActionCommand().equals("Exit")) {
                        view.getmFrame().dispose();
                    }
                    if (actionEvent.getActionCommand().equals("VerifyTable")) {
                        if (model.isLivrExist()) {
                            model.verifyEntity("Livrable", view.getmFrame().getCurrentTable());
                            view.getmFrame().getLable().setText("Livrables have verifyed");
                            setStatusLivr(true);
                        } else {
                            view.getmFrame().getLable().setText("No Data");
                        }

                    }
                if (actionEvent.getActionCommand().equals("VerifyTableCMD")) {
                   if(view.getmFrame().isEmpty(view.getmFrame().getCurrentTable())) {
                       model.verifyEntity("BGTparts", view.getmFrame().getCurrentTable());
                       view.getmFrame().getLable().setText("BGTParts have verifyed");
                       view.getmFrame().updateViewPart(model.getBgtPartList());
                   }else{
                       view.getmFrame().getLable().setText("The table is empty");
                   }
                }



                if (actionEvent.getActionCommand().equals("DeletePart")) {
                    if (model.verifySession()) {
                        model.deletePart(view.getDelFrame().getTextFields()[0].getText());
                        view.getDelFrame().getTextFields()[0].setText("");
      //                  view.getmFrame().getLable().setText("Info for all depts have collected");
                    } else {
                        System.out.println("Session Failed");
                        restartSession();
                    }
                }


                if (actionEvent.getActionCommand().equals("PostData")){
                    if(isStatusLivr()) {
                        if (model.verifySession()) {
                            model.executeEntity(model.getLivrableList());
                            view.getmFrame().getLable().setText("Livrables have posted");
                            view.getmFrame().updateView("Livrable");
                        } else {
                            System.out.println("Session failed");
                            restartSession();
                        }
                    } else {
                        view.getmFrame().getLable().setText("Verify Data");
                    }}

                if (actionEvent.getActionCommand().equals("PostDataCMD")){
                    if(model.isBGTstatus()) {
                        if (model.verifySession()) {
                            model.executeEntity(model.getBgtPartList());
                            view.getmFrame().getLable().setText("Part has created");
      //                      view.getmFrame().updateView("Livrable");
                        } else {
                            System.out.println("Session failed");
                            restartSession();

                        }
                    }else{
                        view.getmFrame().getLable().setText("Verify Data");
                    }}



                }

        };
        tableListner = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent actionEvent) {
                setStatusLivr(false);
            }
        };



        view.getmFrame().getMenuItems()[0].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[1].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[2].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[3].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[4].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[5].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[6].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[7].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[8].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[9].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[10].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[11].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[12].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[13].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[14].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[15].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[16].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[17].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[18].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[19].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[20].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[21].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[22].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[23].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[24].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[25].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[26].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[27].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[28].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[29].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[30].addActionListener(actionListenerItems);
        view.getmFrame().getButtons()[0].addActionListener(actionListenerButtons);
        view.getmFrame().getButtons()[1].addActionListener(actionListenerButtons);
        view.getDelFrame().getButtons()[0].addActionListener(actionListenerButtons);
        view.getmFrame().getCurrentTable().getSelectionModel().addListSelectionListener(tableListner);



///End controller MainForm

    }

        public void verifyLogOn(){
            if (view.getlFrame().getTextFields()[0].getText().length() != 0 && view.getlFrame().getTextFields()[1].getText().length() != 0) {

                if (model.logOn(view.getlFrame().getTextFields()[0].getText(), view.getlFrame().getTextFields()[1].getText()) == true) {
                    String nom =view.getlFrame().getTextFields()[0].getText();
                    model.setUserIDReal(view.getlFrame().getTextFields()[0].getText());
                    view.getlFrame().dispose();
                    view.getaFrame().getLabels()[0].setText("Logged as " + model.getUserId());
                    if(model.getMapUser().containsKey(nom)){
                        System.out.println("nom");
                        view.getaFrame().getLabels()[1].setText("Collection info from DB...please wait");
                        view.getaFrame().addWindowListener(windowListner);
                    }else{
                        view.getaFrame().setStatusIg();

                    }
                    view.getaFrame().setVisible(true);

                } else {

                           System.out.println("Verify Login and password");
                           view.getlFrame().getLabels()[0].setText("Verify Login and password");


                }

            } else {

                System.out.println("Verify Login and password");
                view.getlFrame().getLabels()[0].setText("Verify Login and password");
            }
        }
        public void restartSession(){
            view.getmFrame().setVisible(false);
            view.getlFrame().setVisible(true);
        }

}
