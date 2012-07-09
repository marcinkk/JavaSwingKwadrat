/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswingkwadrat;

import java.util.TimerTask;
/**
 *
 * @author marcin
 */
public class KlasaZadanie extends TimerTask{
    
    int pozX = 50;
    int pozY = 50;
    int kierunek = 1;
    int licznik = 1;

    @Override
    public void run() {
        switch(kierunek){
            case 1:
                licznik++;
                pozX++;
                if(licznik == 600){
                    licznik = 0;
                    kierunek = 2;
                }
                break;
            case 2:
                licznik++;
                pozY++;
                if(licznik == 400){
                    licznik = 0;
                    kierunek = 3;
                }
                break;
            case 3:
                licznik++;
                pozX--;
                if(licznik == 600){
                    licznik = 0;
                    kierunek = 4;
                }
                break;
            case 4:
                licznik++;
                pozY--;
                if(licznik == 400){
                    licznik = 0;
                    kierunek = 1;
                }
                break;
        }
    }
    
}
