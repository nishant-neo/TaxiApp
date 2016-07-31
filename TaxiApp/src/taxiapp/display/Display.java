/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxiapp.display;



import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import taxiapp.coddes.Location;
import taxiapp.coddes.Taxi;
import taxiapp.coddes.TaxiFleet;


/**
 *
 * @author NISHANT
 */
public class Display {
    JFrame frame;
    ArrayList <Taxi> Taxis;
    MyPanel mypanel;
    TaxiFleet taxifleet;
            
    public Display()
    {
        Taxis = new ArrayList();
        frame = new JFrame();
    }
   /* public static void main( String arg[] )
    {
        Display display = new Display();
        display.Randomgenerator();
        display.go();
    }*/
    public void Randomgenerator()
    {    
        taxifleet = new TaxiFleet();
        taxifleet.start(10);
        Taxis = taxifleet.getTaxis();
   
    }
    public void go()
    {
        frame.getContentPane().removeAll();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        mypanel = new MyPanel(Taxis, taxifleet);
 
        //frame.setLayout(null);
       /* for( Taxi c: Taxis)
        {
            JButton b1 = new JButton();
            b1.setLayout(null);
            b1.setPreferredSize(new Dimension(20,20));
            System.out.println(c.getLocation().getX() +""+ c.getLocation().getY());
            b1.setBounds(c.getLocation().getX(), c.getLocation().getY(), 60, 20);
            b1.setVisible(true);
            b1.setText(c.getTaxiId() + "");
            mypanel.add(b1);
            //frame.getContentPane().add(b1);
        }*/
        //frame.setLayout(null);
        frame.getContentPane().add(mypanel);
        frame.setSize(1000,1000);
        frame.setVisible(true);
    }
    public void go2()
    {
        mypanel.removeAll();
        //add your elements
        mypanel.revalidate();
        mypanel.repaint();
    }
    
}
class MyPanel extends JPanel
{
    
    ArrayList<Taxi> tempCars;
    TaxiFleet taxifleet;
    public MyPanel(ArrayList<Taxi> tempCars, TaxiFleet taxifleet) {
        this.tempCars = tempCars;
        this.taxifleet = taxifleet;

    }
    
    @Override
    public void paintComponent(Graphics g)    
    {
        super.paintComponent(g);
        addMouseListener(new MouseAdapter() {@Override
                public void mousePressed(MouseEvent e) {
                    Taxi temp = new Taxi();
                    taxifleet.request(101, new Location(e.getX(),e.getY()));
                    repaint();
                }

            });
        	
        //super.paintComponent(g);
        this.setLayout(null);
        
        for( Taxi t: tempCars)
        {
            JLabel lbl5 = new JLabel(t.getTaxiId()+"");
            this.add(lbl5);
            lbl5.setLocation(t.getLocation().getX(),t.getLocation().getY());
            lbl5.setSize(14, 14);
            Image image;
            if( t.isBusy() == false)
                try {
                    image = ImageIO.read(new File("C:\\Users\\NISHANT\\Documents\\NetBeansProjects\\TaxiApp\\src\\taxiapp\\display\\img.jpg"));
                    g.drawImage(image, t.getLocation().getX(),t.getLocation().getY(),40, 30, lbl5);
                } catch (IOException ex) {
                    Logger.getLogger(MyPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            else{
                try {
                    image = ImageIO.read(new File("C:\\Users\\NISHANT\\Documents\\NetBeansProjects\\TaxiApp\\src\\taxiapp\\display\\img2.jpg"));
                    g.drawImage(image, t.getLocation().getX(),t.getLocation().getY(),40, 30, lbl5);
                } catch (IOException ex) {
                    Logger.getLogger(MyPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
             
            //g.drawImage(image, t.getLocation().getX(),t.getLocation().getY(),20, 10, lbl5);
            //g.drawRect(t.getLocation().getX(),t.getLocation().getY(), 20, 10);
            //g.drawOval(t.getLocation().getX(),t.getLocation().getY(), 10, 10);
        }
    }
    
}
