package com.samara;

import com.samara.controller.Controller;
import com.samara.model.Model;
import com.samara.view.View;




public class Main {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Model model = new Model();
                View view = new View();
                Controller controller = new Controller(model, view);
                controller.contoll();
            }
        });

    }
}
