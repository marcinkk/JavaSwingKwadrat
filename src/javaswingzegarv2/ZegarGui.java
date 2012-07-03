/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswingzegarv2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author marcin kaszuba
 */
public class ZegarGui extends JFrame{
    
    private JPanel jPanel = new JPanel(true);
    private GridLayout gridLayout = new GridLayout(1, 1);
    private int width = 400;
    private int height = 400;
    private int pozycja_okna_x = 500;
    private int pozycja_okna_y = 200;
    private Timer timer;
    private int xGodziny, yGodziny, x2Sekundy, y2Sekundy, x2Minuty, y2Minuty, x2Godziny, y2Godziny, x1Kreski, y1Kreski, x2Kreski, y2Kreski, sekundy, minuty, godziny;
    private double katRadSekund, katRadMinut, katRadGodzin, katRadKreski, katRadGodziny;

    public ZegarGui(){
        setTitle("zegar wskazowkowy !!!");
        setLocation(new Point(pozycja_okna_x, pozycja_okna_y));
        setPreferredSize(new Dimension(width, height));
        pack();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(jPanel);
        
        jPanel.setLayout(gridLayout);
        
        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
    }
    
    @Override
    public void paint(Graphics graphics){
        super.paint(graphics);
        Calendar calendar = Calendar.getInstance();
        graphics.fillRoundRect(190, 190, 20, 20, 360, 360);//okrag
        graphics.drawRoundRect(50, 50, 300, 300, 360, 360);//srodek
        int j = 0;
        for(int i = 0; i < 60; ++i){
            if( i % 5 == 0){
                katRadKreski = 2.0 * Math.PI * (i / 60.0) - (Math.PI / 2.0);
                katRadGodziny = 2.0 * Math.PI * (i / 60.0) - (Math.PI / 3.0);
                x1Kreski = (int)(150 * (Math.cos(katRadKreski)));
                y1Kreski = (int)(150 * (Math.sin(katRadKreski)));
                x2Kreski = (int)(130 * (Math.cos(katRadKreski)));
                y2Kreski = (int)(130 * (Math.sin(katRadKreski)));
                xGodziny = (int)(160 * (Math.cos(katRadGodziny)));
                yGodziny = (int)(160 * (Math.sin(katRadGodziny)));
                graphics.drawLine(200 + x1Kreski, 200 + y1Kreski, 200 + x2Kreski, 200 + y2Kreski);//kreska wskaznikowa
                graphics.drawString(String.valueOf(++j), 195 + xGodziny, 205 + yGodziny);//numer godziny
            } else {
                katRadKreski = 2.0 * Math.PI * (i / 60.0) - (Math.PI / 2.0);
                x1Kreski = (int)(150 * (Math.cos(katRadKreski)));
                y1Kreski = (int)(150 * (Math.sin(katRadKreski)));
                x2Kreski = (int)(140 * (Math.cos(katRadKreski)));
                y2Kreski = (int)(140 * (Math.sin(katRadKreski)));
                graphics.drawLine(200 + x1Kreski, 200 + y1Kreski, 200 + x2Kreski, 200 + y2Kreski);//kreska wskaznikowa
            }
        }
        
        sekundy = calendar.get(Calendar.SECOND);
        minuty = calendar.get(Calendar.MINUTE);
        godziny = calendar.get(Calendar.HOUR);
        
        katRadSekund = 2.0 * Math.PI * (sekundy / 60.0) - (Math.PI / 2.0);
        katRadMinut = 2.0 * Math.PI * (minuty / 60.0) - (Math.PI / 2.0);
        katRadGodzin = 2.0 * Math.PI * ((godziny * 60.0 * 60.0 + minuty * 60.0 + sekundy) / 43200.0) - (Math.PI / 2.0);
        
        x2Sekundy = (int)(140 * (Math.cos(katRadSekund)));
        y2Sekundy = (int)(140 * (Math.sin(katRadSekund)));
        
        x2Minuty = (int)(125 * (Math.cos(katRadMinut)));
        y2Minuty = (int)(125 * (Math.sin(katRadMinut)));
        
        x2Godziny = (int)(100 * (Math.cos(katRadGodzin)));
        y2Godziny = (int)(100 * (Math.sin(katRadGodzin)));
        graphics.setColor(Color.red);
        graphics.drawLine(200, 200, 200 + x2Sekundy, 200 + y2Sekundy);//wskazowka sekundowa
        graphics.setColor(Color.BLACK);
        graphics.drawLine(200, 200, 200 + x2Minuty, 200 + y2Minuty);//wskazowka minutowa
        graphics.drawLine(200, 200, 200 + x2Godziny, 200 + y2Godziny);//wskazowka godzinowa
        
    }
    
}