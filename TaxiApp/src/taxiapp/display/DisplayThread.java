/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxiapp.display;

//import taxiapp.display.Display;

/**
 *
 * @author NISHANT
 */
public class DisplayThread implements Runnable {
    private volatile boolean flag = true;
    @Override
    public void run() {
        //while(flag)
        //{    
            System.out.println("Running Display Thread"); //To change body of generated methods, choose Tools | Templates.
            Display display = new Display();
            display.Randomgenerator();
            display.go();
            try{
                //Pause for 2 seconds
                //Thread.sleep(2000);
            } catch(Exception e){

            }

        //}
    }
    
}
