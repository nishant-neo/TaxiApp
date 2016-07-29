/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxiapp.display;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import taxiapp.commons.Car;

/**
 *
 * @author NISHANT
 */
public class Display {
    JFrame frame;
    ArrayList <Car> Cars;
    
    public Display()
    {
        Cars = new ArrayList();
    }
   /* public static void main( String arg[] )
    {
        Display display = new Display();
        display.Randomgenerator();
        display.go();
    }*/
    public void Randomgenerator()
    {    
        Random rand = new Random();
            for( int i = 0; i < 10; i ++)
            {
                Car tempCar = new Car();
                tempCar.setX(rand.nextInt(600)+ 200); 
                tempCar.setY(rand.nextInt(600)+ 200); 
                Cars.add(tempCar);   
            }
   
    }
    public void go()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        MyPanel mypanel = new MyPanel(Cars);
        //
        mypanel.setLayout(null);
        JLabel lbl5 = new JLabel("label 5");
        mypanel.add(lbl5);
        lbl5.setLocation(Cars.get(0).getX(), Cars.get(0).getY());
        lbl5.setSize(13, 14);
        //
        frame.getContentPane().add(mypanel);
        frame.setSize(1000,1000);
        frame.setVisible(true);
    }
    
}
class MyPanel extends JPanel
{
    
    ArrayList<Car> tempCars;
    public MyPanel(ArrayList<Car> tempCars) {
        
        this.tempCars = tempCars;
        //System.out.println(tempCars);
    }
    
    public void eucladian( Car p)
        {
            double min = 1000000.0f;
            int minIndex = 0;
            for( int i= 0; i < 10; i++)
            {
                Car t = tempCars.get(i);
                double x = Math.sqrt((t.getX() - p.getX())* (t.getX() - p.getX())  + (t.getY() - p.getY())* (t.getY() - p.getY()));
                if( x < min){
                    min = x;
                    minIndex = i;
                }
               
            }
            tempCars.get(minIndex).changeStatus();
        }
    @Override
    public void paintComponent(Graphics g)    
    {
        //setPreferredSize(new Dimension(80, 75));
        addMouseListener(new MouseAdapter() {@Override
                public void mousePressed(MouseEvent e) {
                    Car temp = new Car();
                    temp.setX(e.getX())  ;
                    temp.setY(e.getY());
                    eucladian(temp);
                    repaint();
                }

            });
        
        for( Car t: tempCars)
        {
            if( t.getStatus() == 0)
                g.setColor(Color.blue);
            else
                g.setColor(Color.red);
            g.drawOval(t.getX(), t.getY(), 10, 10);
        }
    }
    
}
