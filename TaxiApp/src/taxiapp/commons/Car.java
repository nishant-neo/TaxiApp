/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxiapp.commons;

/**
 *
 * @author NISHANT
 */
public class Car {

    int x;
    int y;
    int status;
    int id;
    public Car() {
        this.x = 0;
        this.y = 0;
        this.status = 0;
        this.id = -1;
    }
    
    public Car(int x, int y, int status, int id) {
        this.x = x;
        this.y = y;
        this.status = status;
        this.id = id;
    }
    
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void changeStatus() {
        this.status = 1 - this.status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }
    
    
}
