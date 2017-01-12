package com.samara.view;


import javax.swing.*;

/**
 * Created by sr01001 on 11/01/2016.
 */
public class View {

    MainFrame mFrame;
    LoginFrame lFrame;
    AccessFrame aFrame;
    DeleteFrame delFrame;
    AccessFrameIntern aFrameInt;



    public View(){

        mFrame = new MainFrame();
        lFrame = new LoginFrame();
        aFrame = new AccessFrame();
        delFrame = new DeleteFrame();
        aFrameInt = new AccessFrameIntern();
        lFrame.setVisible(true);
        aFrame.setVisible(false);
        mFrame.setVisible(false);
        delFrame.setVisible(false);
        aFrameInt.setVisible(false);
        setlFrame(lFrame);
        setaFrame(aFrame);
        setmFrame(mFrame);
        setDelFrame(delFrame);
        setaFrameInt(aFrameInt);
        JFrame.setDefaultLookAndFeelDecorated(true);
    }


    public MainFrame getmFrame() {
        return mFrame;
    }

    public void setmFrame(MainFrame mFrame) {
        this.mFrame = mFrame;
    }

    public LoginFrame getlFrame() {
        return lFrame;
    }

    public void setlFrame(LoginFrame lFrame) {
        this.lFrame = lFrame;
    }

    public AccessFrame getaFrame() {
        return aFrame;
    }

    public void setaFrame(AccessFrame aFrame) {
        this.aFrame = aFrame;
    }
    public DeleteFrame getDelFrame() {
        return delFrame;
    }

    public void setDelFrame(DeleteFrame delFrame) {
        this.delFrame = delFrame;
    }

    public AccessFrameIntern getaFrameInt() {
        return aFrameInt;
    }

    public void setaFrameInt(AccessFrameIntern aFrameInt) {
        this.aFrameInt = aFrameInt;
    }

}

