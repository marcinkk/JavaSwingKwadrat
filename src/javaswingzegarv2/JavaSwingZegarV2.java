/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswingzegarv2;

import javax.swing.SwingUtilities;

/**
 *
 * @author marcin
 */
public class JavaSwingZegarV2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                ZegarGui zegarGui = new ZegarGui();
            }
        });
    }
}
