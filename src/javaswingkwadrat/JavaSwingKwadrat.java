/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswingkwadrat;

import javax.swing.SwingUtilities;

/**
 *
 * @author marcin
 */
public class JavaSwingKwadrat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                KlasaKwadrat klasaKwadrat = new KlasaKwadrat();
            }
        });
    }
}
