/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traffic;
import java.awt.*;
import javax.swing.*;

public class Traffic {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Traffic");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        frame.add(new TrafficPanel());     
        frame.pack();
        frame.setVisible(true);
        
    }
    
}
