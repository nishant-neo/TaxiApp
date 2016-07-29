/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxiapp.commons;

import taxiapp.display.DisplayThread;

/**
 *
 * @author NISHANT
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class TaxiApp {

    /**
     * @param args the command line arguments
     */
    

    public static void main(String[] args) {
        Thread t1 =  new Thread( new DisplayThread() );
        t1.start();
        
    }
    
}
