/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxiapp.coddes;

/**
 *
 * @author NISHANT
 */
public class TaxiFleetThread implements Runnable {

    @Override
    public void run() {
        TaxiFleet taxifleet = new TaxiFleet();
        taxifleet.start(10);//the number of taxis
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
