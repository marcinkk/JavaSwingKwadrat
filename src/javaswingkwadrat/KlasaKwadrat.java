/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswingkwadrat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author marcin
 */
public class KlasaKwadrat extends JFrame{
    
    private int width = 800;
    private int height = 600;
    private Dimension dimension = new Dimension(width, height);
    JPanel jPanel = new JPanel(true);
    KlasaTask klasaZadanie = new KlasaTask();
    Timer timer;
    Image bufor;
    Graphics bg;

    public KlasaKwadrat() {
        setTitle("ruchomy kwadrat !!!");
        setSize(dimension);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(jPanel);
        
        bufor = createImage(width, height);
        bg = bufor.getGraphics();
        timer = new Timer(10, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                klasaZadanie.run();
                repaint();
            }
        });
        timer.start();
    }
    
    @Override
    public void update(Graphics graphics){
        bg.clearRect(0, 0, width, height);
        paint(bg);
        graphics.drawImage(bufor, 0, 0, jPanel);
    }
    
    @Override
    public void paint(Graphics graphics){
        super.paint(graphics);
        graphics.setColor(Color.red);
        graphics.fillRect(klasaZadanie.pozX, klasaZadanie.pozY, 100, 100);
    }
}
