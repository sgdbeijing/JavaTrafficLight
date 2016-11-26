/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traffic;
import java.awt.*;
import javax.swing.*;

public class Car {
    
    public int posx,posy,sizex,sizey,speed,direction;
    public int bornx = -30;
    public int borny = -30;
    public Color color;
    
    
    public Car(int direction){
        
        
        this.direction = direction;
        color = new Color(
        (new Double(Math.random() * 128)).intValue() + 128, 
        (new Double(Math.random() * 128)).intValue() + 128, 
        (new Double(Math.random() * 128)).intValue() + 128);
        
        speed = 2;
         
        switch(this.direction){
            
            case 0:
                posx = 260;
                posy = borny;
                sizex = 20;
                sizey = 30;
                break;
                
            case 1:
                posx = 290;
                posy = borny;
                sizex = 20;
                sizey = 30;
                break;
                
            case 2:
                posx =320;
                posy =borny;
                sizex = 20;
                sizey = 30;
                break;
                
            case 3:
                posx = bornx;
                posy = 260;
                sizey = 20;
                sizex = 30;
                break;
                
            case 4:
                posx = bornx;
                posy = 290;
                sizey = 20;
                sizex = 30;
                break;
                
            case 5:
                posx = bornx;
                posy = 320;
                sizey = 20;
                sizex = 30;
                break;
                
            
        }
            
    }
    
    public void move(){
    
        switch(this.direction){
            case 0:
                posy += speed;
                break;
               
            case 1:
                posy += speed;
                break; 

            case 2:
                posy += speed;
                break;
                
            case 3:
                posx += speed;
                break;
                
            case 4:
                posx += speed;
                break;
                
            case 5:
                posx += speed;
                break;
                
                
                
        }
    
    }
    
}
