/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traffic;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;
import static traffic.TrafficPanel.bgpnum;

public class CarPanel extends JPanel{

    Timer timer;
    int distance = 50;
    int lightdiastance =  40;
    public boolean carlist1 = true;
    public boolean carlist2 = true;
    public boolean carlist3 = true;
    public boolean carlist4 = true;
    public boolean carlist5 = true;
    public boolean carlist6 = true;
     
     

    public void paintComponent(Graphics g) {
        ImageIcon background = new ImageIcon("background.jpg");//加载图片 
        Image im=Toolkit.getDefaultToolkit().getImage("background.jpg");
        super.paintComponent(g);
        g.drawImage(im, 0, 0, 600,600, this);
        
        switch(TrafficPanel.bgpnum){
            case 1:
                im=Toolkit.getDefaultToolkit().getImage("background.jpg");
                g.drawImage(im, 0, 0, 600,600, this);
                break;
            
            case 2:
                im=Toolkit.getDefaultToolkit().getImage("background1.jpg");
                g.drawImage(im, 0, 0, 600,600, this);
                break;
                
            case 3:
                im=Toolkit.getDefaultToolkit().getImage("background2.jpg");
                g.drawImage(im, 0, 0, 600,600, this);
                break;
            
            case 4:
                im=Toolkit.getDefaultToolkit().getImage("background3.jpg");
                g.drawImage(im, 0, 0, 600,600, this);
                break;
                
            case 5:
                im=Toolkit.getDefaultToolkit().getImage("background4.jpg");
                g.drawImage(im, 0, 0, 600,600, this);
                break;
            default: 
                break;
        }
        
        g.setColor(Color.BLACK);
        g.fillRect(250, 0, 100, 600);
        g.fillRect(0, 250, 600, 100);
        

        switch(TrafficPanel.light){
            
            case 0:
                g.setColor(Color.GREEN);
                break;
                
            case 1:
                g.setColor(Color.YELLOW);
                break;
            
            case 2:
                g.setColor(Color.RED);
                break;
                
            case 3:
                g.setColor(Color.YELLOW);
                break;
                
        }
        
        g.fillOval(220, 360, 20, 20);
        switch(TrafficPanel.light1){
            
            case 0:
                g.setColor(Color.RED);                
                break;
                
            case 1:
                g.setColor(Color.YELLOW);
                break;
            
            case 2:
                g.setColor(Color.GREEN);
                break;
                
            case 3:
                g.setColor(Color.YELLOW);
                break;
                
        }
        g.fillOval(360, 360, 20, 20);
        
        
                
        for(int i=0; i<TrafficPanel.list1.size(); i++){
            if (carlist1) {
                g.setColor(TrafficPanel.list1.get(i).color);
                g.fillRect(TrafficPanel.list1.get(i).posx,TrafficPanel.list1.get(i).posy,TrafficPanel.list1.get(i).sizex,TrafficPanel.list1.get(i).sizey);
            }
            else
                break;
        }
        
        for(int i=0; i<TrafficPanel.list2.size(); i++){
            System.out.println(carlist2);
            if (carlist2) {
                g.setColor(TrafficPanel.list2.get(i).color);
                g.fillRect(TrafficPanel.list2.get(i).posx,TrafficPanel.list2.get(i).posy,TrafficPanel.list2.get(i).sizex,TrafficPanel.list2.get(i).sizey);
            }
            else
                break;
        }
        
        for(int i=0; i<TrafficPanel.list3.size(); i++){
            if (carlist3) {
                g.setColor(TrafficPanel.list3.get(i).color);
                g.fillRect(TrafficPanel.list3.get(i).posx,TrafficPanel.list3.get(i).posy,TrafficPanel.list3.get(i).sizex,TrafficPanel.list3.get(i).sizey);
            }
            else
                break;
        }
        
        for(int i=0; i<TrafficPanel.list4.size(); i++){
            if (carlist4) {
                g.setColor(TrafficPanel.list4.get(i).color);
                g.fillRect(TrafficPanel.list4.get(i).posx,TrafficPanel.list4.get(i).posy,TrafficPanel.list4.get(i).sizex,TrafficPanel.list4.get(i).sizey);
            }
            else
                break;
        }
        
        for(int i=0; i<TrafficPanel.list5.size(); i++){
            if (carlist5) {
                g.setColor(TrafficPanel.list5.get(i).color);
                g.fillRect(TrafficPanel.list5.get(i).posx,TrafficPanel.list5.get(i).posy,TrafficPanel.list5.get(i).sizex,TrafficPanel.list5.get(i).sizey);
            }
            else
                break;
        }
        
        for(int i=0; i<TrafficPanel.list6.size(); i++){
            if (carlist6) {
                g.setColor(TrafficPanel.list6.get(i).color);
                g.fillRect(TrafficPanel.list6.get(i).posx,TrafficPanel.list6.get(i).posy,TrafficPanel.list6.get(i).sizex,TrafficPanel.list6.get(i).sizey);
            }
            else
                break;
        }
        
        
         
    }
    
    public CarPanel(){
        
        this.setPreferredSize(new Dimension(600,600));
        this.setBackground(Color.WHITE);
        
        timer = new Timer(10,new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                
                checkRoad1();
                checkRoad2();
                checkRoad3();
                checkRoad4();
                checkRoad5();
                checkRoad6();
                repaint();
            }
        });
        
        timer.start();
        
    }
       

    
    
    
    public void checkRoad1(){
        
        for(int i = 0; i<TrafficPanel.list1.size(); i++){
            

            if(TrafficPanel.list1.get(i).posy < 250){ //在通过红灯之前
                                
                //if(TrafficPanel.light){ //绿灯时
                if(TrafficPanel.light == 0){ //case0
                    if(i == 0){ //是第一辆车
                        TrafficPanel.list1.get(i).speed = 3;
                        TrafficPanel.list1.get(i).move();
                                        
                    }else{ //不是第一辆车
                        if(TrafficPanel.list1.get(i).posy <= TrafficPanel.list1.get(i-1).posy - distance){ //车距大于20
                            TrafficPanel.list1.get(i).speed = 3;
                            TrafficPanel.list1.get(i).move();
                                            
                        }
                    }
                    
                    
                }else if(TrafficPanel.light == 1){ //黄灯
                    //已经过线的接着走
                    //没过线的在线前停下
                    if(i == 0){ //是第一辆车
                                        
                        if(TrafficPanel.list1.get(i).posy <= (250 - lightdiastance)){ //在停车线之前
                            TrafficPanel.list1.get(i).speed = 2;                
                            TrafficPanel.list1.get(i).move();
 
                        }else{ //到停车线时
                                            
                            if((TrafficPanel.list1.get(i).posy + 30)>250){//如果过线
                                TrafficPanel.list1.get(i).speed = 3;
                                TrafficPanel.list1.get(i).move();
                                                
                            }
                        }
                                        
                    }else{ //不是第一辆车
                                        
                        if(TrafficPanel.list1.get(i).posy < (250 - lightdiastance)){ //在停车线以前
                                            
                            if(TrafficPanel.list1.get(i).posy <= (TrafficPanel.list1.get(i-1).posy - distance)){ //车距大于20
                                TrafficPanel.list1.get(i).speed = 2;
                                TrafficPanel.list1.get(i).move();
                                                
                            }
                                         
                        }else{ //在到停车线时
                                            
                            if((TrafficPanel.list1.get(i).posy + 30)>250){//如果过线
                                TrafficPanel.list1.get(i).speed = 3;
                                TrafficPanel.list1.get(i).move();
                                                
                            }
                        }
                                        
                    }
                      
                    
                }else if(TrafficPanel.light == 2){//红灯时  //case2
                                    
                    if(i == 0){ //是第一辆车
                                        
                        if(TrafficPanel.list1.get(i).posy <= (250 - lightdiastance)){ //在停车线之前
                            TrafficPanel.list1.get(i).speed = 1;                
                            TrafficPanel.list1.get(i).move();
 
                        }else{ //到停车线时
                                            
                            if((TrafficPanel.list1.get(i).posy + 30)>250){//如果过线
                                TrafficPanel.list1.get(i).speed = 3;
                                TrafficPanel.list1.get(i).move();
                                                
                            }
                        }
                                        
                    }else{ //不是第一辆车
                                        
                        if(TrafficPanel.list1.get(i).posy < (250 - lightdiastance)){ //在停车线以前
                                            
                            if(TrafficPanel.list1.get(i).posy <= (TrafficPanel.list1.get(i-1).posy - distance)){ //车距大于20
                                TrafficPanel.list1.get(i).speed = 1;
                                TrafficPanel.list1.get(i).move();
                                                
                            }
                                         
                        }else{ //在到停车线时
                                            
                            if((TrafficPanel.list1.get(i).posy + 30)>250){//如果过线
                                TrafficPanel.list1.get(i).speed = 3;
                                TrafficPanel.list1.get(i).move();
                                                
                            }
                        }
                                        
                    }
                                    
                }else{ //case3
                
                    //在停车线前的等待
                    //没到停车线的往前开
                    if(i == 0){ //是第一辆车
                                        
                        if(TrafficPanel.list1.get(i).posy <= (250 - lightdiastance)){ //在停车线之前
                            TrafficPanel.list1.get(i).speed = 1;                
                            TrafficPanel.list1.get(i).move();
 
                        }else{ //到停车线时
                                            
                            if((TrafficPanel.list1.get(i).posy + 30)>250){//如果过线
                                TrafficPanel.list1.get(i).speed = 3;
                                TrafficPanel.list1.get(i).move();
                                                
                            }
                        }
                                        
                    }else{ //不是第一辆车
                                        
                        if(TrafficPanel.list1.get(i).posy < (250 - lightdiastance)){ //在停车线以前
                                            
                            if(TrafficPanel.list1.get(i).posy <= (TrafficPanel.list1.get(i-1).posy - distance)){ //车距大于20
                                TrafficPanel.list1.get(i).speed = 1;
                                TrafficPanel.list1.get(i).move();
                                                
                            }
                                         
                        }else{ //在到停车线时
                                            
                            if((TrafficPanel.list1.get(i).posy + 30)>250){//如果过线
                                TrafficPanel.list1.get(i).speed = 3;
                                TrafficPanel.list1.get(i).move();
                                                
                            }
                        }
                                        
                    }
                    
                
                }
                
            }else { //在通过红灯之后
                if(TrafficPanel.list1.get(i).posy < 650){
                    TrafficPanel.list1.get(i).speed = 3;
                    TrafficPanel.list1.get(i).move();
                }else{
                    TrafficPanel.list1.remove(i);
                }
                                
            }

        }
    
    }
    
    public void checkRoad2(){
        
        for(int i = 0; i<TrafficPanel.list2.size(); i++){
            
            if(TrafficPanel.list2.get(i).posy < 250){ //在通过红灯之前
                                
                //if(TrafficPanel.light){ //绿灯时
                if(TrafficPanel.light == 0){ //case0
                    if(i == 0){ //是第一辆车
                        TrafficPanel.list2.get(i).speed = 4;
                        TrafficPanel.list2.get(i).move();
                                        
                    }else{ //不是第一辆车
                        if(TrafficPanel.list2.get(i).posy <= TrafficPanel.list2.get(i-1).posy - distance){ //车距大于20
                            TrafficPanel.list2.get(i).speed = 4;
                            TrafficPanel.list2.get(i).move();
                                            
                        }else{//车距小于20
                                            
                        }
                    }
                    
                    
                }else if(TrafficPanel.light == 1){ //case1
                    //已经过线的接着走
                    //没过线的在线前停下
                    if(i == 0){ //是第一辆车
                                        
                        if(TrafficPanel.list2.get(i).posy <= (250 - lightdiastance)){ //在停车线之前
                            TrafficPanel.list2.get(i).speed = 2;                
                            TrafficPanel.list2.get(i).move();
 
                        }else{ //到停车线时
                                            
                            if((TrafficPanel.list2.get(i).posy + 30)>250){//如果过线
                                TrafficPanel.list2.get(i).speed = 4;
                                TrafficPanel.list2.get(i).move();
                                                
                            }else{
                                                
                            }
                        }
                                        
                    }else{ //不是第一辆车
                                        
                        if(TrafficPanel.list2.get(i).posy < (250 - lightdiastance)){ //在停车线以前
                                            
                            if(TrafficPanel.list2.get(i).posy <= (TrafficPanel.list2.get(i-1).posy - distance)){ //车距大于20
                                TrafficPanel.list2.get(i).speed = 2;
                                TrafficPanel.list2.get(i).move();
                                                
                            }
                                         
                        }else{ //在到停车线时
                                            
                            if((TrafficPanel.list2.get(i).posy + 30)>250){//如果过线
                                TrafficPanel.list2.get(i).speed = 4;
                                TrafficPanel.list2.get(i).move();
                                                
                            }
                        }
                                        
                    }
                    
                    
                    
                    
                    
                }else if(TrafficPanel.light == 2){//红灯时  //case2
                                    
                    if(i == 0){ //是第一辆车
                                        
                        if(TrafficPanel.list2.get(i).posy <= (250 - lightdiastance)){ //在停车线之前
                            
                            TrafficPanel.list2.get(i).speed = 2;
                            TrafficPanel.list2.get(i).move();
 
                        }else{ //到停车线时
                                            
                            if((TrafficPanel.list2.get(i).posy + 30)>250){//如果过线
                                TrafficPanel.list2.get(i).speed = 4;
                                TrafficPanel.list2.get(i).move();
                                                
                            }
                        }
                                        
                    }else{ //不是第一辆车
                                        
                        if(TrafficPanel.list2.get(i).posy < (250 - lightdiastance)){ //在停车线以前
                                            
                            if(TrafficPanel.list2.get(i).posy <= (TrafficPanel.list2.get(i-1).posy - distance)){ //车距大于20
                                TrafficPanel.list2.get(i).speed = 2;
                                TrafficPanel.list2.get(i).move();
                                                
                            }
                                         
                        }else{ //在到停车线时
                                            
                            if((TrafficPanel.list2.get(i).posy + 30)>250){//如果过线
                                TrafficPanel.list2.get(i).speed = 4;
                                TrafficPanel.list2.get(i).move();
                                                
                            }
                        }
                                        
                    }
                                    
                }else{ //case3
                
                    //在停车线前的等待
                    //没到停车线的往前开
                    if(i == 0){ //是第一辆车
                                        
                        if(TrafficPanel.list2.get(i).posy <= (250 - lightdiastance)){ //在停车线之前
                            TrafficPanel.list2.get(i).speed = 2;                
                            TrafficPanel.list2.get(i).move();
 
                        }else{ //到停车线时
                                            
                            if((TrafficPanel.list2.get(i).posy + 30)>250){//如果过线
                                TrafficPanel.list2.get(i).speed = 4;
                                TrafficPanel.list2.get(i).move();
                                                
                            }
                        }
                                        
                    }else{ //不是第一辆车
                                        
                        if(TrafficPanel.list2.get(i).posy < (250 - lightdiastance)){ //在停车线以前
                                            
                            if(TrafficPanel.list2.get(i).posy <= (TrafficPanel.list2.get(i-1).posy - distance)){ //车距大于20
                                TrafficPanel.list2.get(i).speed = 2;
                                TrafficPanel.list2.get(i).move();
                                                
                            }
                                         
                        }else{ //在到停车线时
                                            
                            if((TrafficPanel.list2.get(i).posy + 30)>250){//如果过线
                                TrafficPanel.list2.get(i).speed = 4;
                                TrafficPanel.list2.get(i).move();
                                                
                            }
                        }
                                        
                    }
                    
                
                }
                
            }else { //在通过红灯之后
                
                if(TrafficPanel.list2.get(i).posy < 650){
                    TrafficPanel.list2.get(i).speed = 4;
                    TrafficPanel.list2.get(i).move();
                }else{
                    TrafficPanel.list2.remove(i);
                }
                                
            }

        }
    
    }
    
    public void checkRoad3(){
        
        for(int i = 0; i<TrafficPanel.list3.size(); i++){
            
            if(TrafficPanel.list3.get(i).posy < 250){ //在通过红灯之前
                                
                //if(TrafficPanel.light){ //绿灯时
                if(TrafficPanel.light == 0){ //case0
                    if(i == 0){ //是第一辆车
                        TrafficPanel.list3.get(i).speed = 5;
                        TrafficPanel.list3.get(i).move();
                                        
                    }else{ //不是第一辆车
                        if(TrafficPanel.list3.get(i).posy <= TrafficPanel.list3.get(i-1).posy - distance){ //车距大于20
                            TrafficPanel.list3.get(i).speed = 5;
                            TrafficPanel.list3.get(i).move();
                                            
                        }
                    }
                    
                    
                }else if(TrafficPanel.light == 1){ //case1
                    //已经过线的接着走
                    //没过线的在线前停下
                    if(i == 0){ //是第一辆车
                                        
                        if(TrafficPanel.list3.get(i).posy <= (250 - lightdiastance)){ //在停车线之前
                            TrafficPanel.list3.get(i).speed = 2;                
                            TrafficPanel.list3.get(i).move();
 
                        }else{ //到停车线时
                                            
                            if((TrafficPanel.list3.get(i).posy + 30)>250){//如果过线
                                TrafficPanel.list3.get(i).speed = 5;
                                TrafficPanel.list3.get(i).move();
                                                
                            }
                        }
                                        
                    }else{ //不是第一辆车
                                        
                        if(TrafficPanel.list3.get(i).posy < (250 - lightdiastance)){ //在停车线以前
                                            
                            if(TrafficPanel.list3.get(i).posy <= (TrafficPanel.list3.get(i-1).posy - distance)){ //车距大于20
                                TrafficPanel.list3.get(i).speed = 2;
                                TrafficPanel.list3.get(i).move();
                                                
                            }
                                         
                        }else{ //在到停车线时
                                            
                            if((TrafficPanel.list3.get(i).posy + 30)>250){//如果过线
                                TrafficPanel.list3.get(i).speed = 5;
                                TrafficPanel.list3.get(i).move();
                                                
                            }
                        }
                                        
                    }
                    
                    
                    
                    
                    
                }else if(TrafficPanel.light == 2){//红灯时  //case2
                                    
                    if(i == 0){ //是第一辆车
                                        
                        if(TrafficPanel.list3.get(i).posy <= (250 - lightdiastance)){ //在停车线之前
                            TrafficPanel.list3.get(i).speed = 2;                
                            TrafficPanel.list3.get(i).move();
 
                        }else{ //到停车线时
                                            
                            if((TrafficPanel.list3.get(i).posy + 30)>250){//如果过线
                                TrafficPanel.list3.get(i).speed = 5;
                                TrafficPanel.list3.get(i).move();
                                                
                            }
                        }
                                        
                    }else{ //不是第一辆车
                                        
                        if(TrafficPanel.list3.get(i).posy < (250 - lightdiastance)){ //在停车线以前
                                            
                            if(TrafficPanel.list3.get(i).posy <= (TrafficPanel.list3.get(i-1).posy - distance)){ //车距大于20
                                TrafficPanel.list3.get(i).speed = 2;
                                TrafficPanel.list3.get(i).move();
                                                
                            }
                                         
                        }else{ //在到停车线时
                                            
                            if((TrafficPanel.list3.get(i).posy + 30)>250){//如果过线
                                TrafficPanel.list3.get(i).speed = 5;
                                TrafficPanel.list3.get(i).move();
                                                
                            }
                        }
                                        
                    }
                                    
                }else{ //case3
                
                    //在停车线前的等待
                    //没到停车线的往前开
                    if(i == 0){ //是第一辆车
                                        
                        if(TrafficPanel.list3.get(i).posy <= (250 - lightdiastance)){ //在停车线之前
                            TrafficPanel.list3.get(i).speed = 3;                
                            TrafficPanel.list3.get(i).move();
 
                        }else{ //到停车线时
                                            
                            if((TrafficPanel.list3.get(i).posy + 30)>250){//如果过线
                                TrafficPanel.list3.get(i).speed = 5;
                                TrafficPanel.list3.get(i).move();
                                                
                            }
                        }
                                        
                    }else{ //不是第一辆车
                                        
                        if(TrafficPanel.list3.get(i).posy < (250 - lightdiastance)){ //在停车线以前
                                            
                            if(TrafficPanel.list3.get(i).posy <= (TrafficPanel.list3.get(i-1).posy - distance)){ //车距大于20
                                TrafficPanel.list3.get(i).speed = 3;
                                TrafficPanel.list3.get(i).move();
                                                
                            }
                                         
                        }else{ //在到停车线时
                                            
                            if((TrafficPanel.list3.get(i).posy + 30)>250){//如果过线
                                TrafficPanel.list3.get(i).speed = 5;
                                TrafficPanel.list3.get(i).move();
                                                
                            }
                        }
                                        
                    }
                    
                
                }
                
            }else { //在通过红灯之后
                
                if(TrafficPanel.list3.get(i).posy < 650){
                    TrafficPanel.list3.get(i).speed = 5;
                    TrafficPanel.list3.get(i).move();
                }else{
                    TrafficPanel.list3.remove(i);
                }
                                
            }

        }
    
    }
      
    public void checkRoad4(){
        
        for(int i = 0; i<TrafficPanel.list4.size(); i++){
            
            if(TrafficPanel.list4.get(i).posx < 250){ 
                                
                
                if(TrafficPanel.light == 2){ 
                    if(i == 0){ //是第一辆车
                        TrafficPanel.list4.get(i).speed = 5;
                        TrafficPanel.list4.get(i).move();
                                        
                    }else{ //不是第一辆车
                        if(TrafficPanel.list4.get(i).posx <= TrafficPanel.list4.get(i-1).posx - distance){ //车距大于20
                            TrafficPanel.list4.get(i).speed = 5;
                            TrafficPanel.list4.get(i).move();
                                            
                        }
                    }
                    
                    
                }else if(TrafficPanel.light == 3){ 
                    //已经过线的接着走
                    //没过线的在线前停下
                    if(i == 0){ //是第一辆车
                                        
                        if(TrafficPanel.list4.get(i).posx <= (250 - lightdiastance)){ //在停车线之前
                            TrafficPanel.list4.get(i).speed = 3;
                            TrafficPanel.list4.get(i).move();
 
                        }else{ //到停车线时
                                            
                            if((TrafficPanel.list4.get(i).posx + 30)>250){//如果过线
                                TrafficPanel.list4.get(i).speed = 5;
                                TrafficPanel.list4.get(i).move();
                                                
                            }
                        }
                                        
                    }else{ //不是第一辆车
                                        
                        if(TrafficPanel.list4.get(i).posx < (250 - lightdiastance)){ //在停车线以前
                                            
                            if(TrafficPanel.list4.get(i).posx <= (TrafficPanel.list4.get(i-1).posx - distance)){ //车距大于20
                                TrafficPanel.list4.get(i).speed = 3;
                                TrafficPanel.list4.get(i).move();
                                                
                            }
                                         
                        }else{ //在到停车线时
                                            
                            if((TrafficPanel.list4.get(i).posx + 30)>250){//如果过线
                                TrafficPanel.list4.get(i).speed = 5;
                                TrafficPanel.list4.get(i).move();
                                                
                            }
                        }
                                        
                    }

                }else if(TrafficPanel.light == 0){//红灯时  //case2
                                    
                    if(i == 0){ //是第一辆车
                                        
                        if(TrafficPanel.list4.get(i).posx <= (250 - lightdiastance)){ //在停车线之前
                            TrafficPanel.list4.get(i).speed = 2;                     
                            TrafficPanel.list4.get(i).move();
 
                        }else{ //到停车线时
                                            
                            if((TrafficPanel.list4.get(i).posx + 30)>250){//如果过线
                                TrafficPanel.list4.get(i).speed = 5;
                                TrafficPanel.list4.get(i).move();
                                                
                            }
                        }
                                        
                    }else{ //不是第一辆车
                                        
                        if(TrafficPanel.list4.get(i).posx < (250 - lightdiastance)){ //在停车线以前
                                            
                            if(TrafficPanel.list4.get(i).posx <= (TrafficPanel.list4.get(i-1).posx - distance)){ //车距大于20
                                TrafficPanel.list4.get(i).speed = 2;
                                TrafficPanel.list4.get(i).move();
                                                
                            }
                                         
                        }else{ //在到停车线时
                                            
                            if((TrafficPanel.list4.get(i).posx + 30)>250){//如果过线
                                TrafficPanel.list4.get(i).speed = 5;
                                TrafficPanel.list4.get(i).move();
                                                
                            }
                        }
                                        
                    }
                                    
                }else{ //case3
                
                    if(i == 0){ //是第一辆车
                                        
                        if(TrafficPanel.list4.get(i).posx <= (250 - lightdiastance)){ //在停车线之前
                            TrafficPanel.list4.get(i).speed = 3;                
                            TrafficPanel.list4.get(i).move();
 
                        }else{ //到停车线时
                                            
                            if((TrafficPanel.list4.get(i).posx + 30)>250){//如果过线
                                TrafficPanel.list4.get(i).speed = 5;
                                TrafficPanel.list4.get(i).move();
                                                
                            }
                        }
                                        
                    }else{ //不是第一辆车
                                        
                        if(TrafficPanel.list4.get(i).posx < (250 - lightdiastance)){ //在停车线以前
                                            
                            if(TrafficPanel.list4.get(i).posx <= (TrafficPanel.list4.get(i-1).posx - distance)){ //车距大于20
                                TrafficPanel.list4.get(i).speed = 3;
                                TrafficPanel.list4.get(i).move();
                                                
                            }
                                         
                        }else{ //在到停车线时
                                            
                            if((TrafficPanel.list4.get(i).posx + 30)>250){//如果过线
                                TrafficPanel.list4.get(i).speed = 5;
                                TrafficPanel.list4.get(i).move();
                                                
                            }
                        }
                                        
                    }
                
                }
                
            }else { //在通过红灯之后
                
                if(TrafficPanel.list4.get(i).posx < 650){
                    TrafficPanel.list4.get(i).speed = 5;
                    TrafficPanel.list4.get(i).move();
                }else{
                    TrafficPanel.list4.remove(i);
                }
                                
            }

        }
    
    }    
    
    public void checkRoad5(){
        
        for(int i = 0; i<TrafficPanel.list5.size(); i++){
            
            if(TrafficPanel.list5.get(i).posx < 250){ 
                                
                
                if(TrafficPanel.light == 2){ 
                    if(i == 0){ //是第一辆车
                        TrafficPanel.list5.get(i).speed = 4;
                        TrafficPanel.list5.get(i).move();
                                        
                    }else{ //不是第一辆车
                        if(TrafficPanel.list5.get(i).posx <= TrafficPanel.list5.get(i-1).posx - distance){ //车距大于20
                            TrafficPanel.list5.get(i).speed = 4;
                            TrafficPanel.list5.get(i).move();
                                            
                        }
                    }
                    
                    
                }else if(TrafficPanel.light == 3){ 
                    //已经过线的接着走
                    //没过线的在线前停下
                    if(i == 0){ //是第一辆车
                                        
                        if(TrafficPanel.list5.get(i).posx <= (250 - lightdiastance)){ //在停车线之前
                            TrafficPanel.list5.get(i).speed = 3;
                            TrafficPanel.list5.get(i).move();
 
                        }else{ //到停车线时
                                            
                            if((TrafficPanel.list5.get(i).posx + 30)>250){//如果过线
                                TrafficPanel.list5.get(i).speed = 4;
                                TrafficPanel.list5.get(i).move();
                                                
                            }
                        }
                                        
                    }else{ //不是第一辆车
                                        
                        if(TrafficPanel.list5.get(i).posx < (250 - lightdiastance)){ //在停车线以前
                                            
                            if(TrafficPanel.list5.get(i).posx <= (TrafficPanel.list5.get(i-1).posx - distance)){ //车距大于20
                                TrafficPanel.list5.get(i).speed = 3;
                                TrafficPanel.list5.get(i).move();                                              
                                             
                            }
                                         
                        }else{ //在到停车线时
                                            
                            if((TrafficPanel.list5.get(i).posx + 30)>250){//如果过线
                                TrafficPanel.list5.get(i).speed = 4;
                                TrafficPanel.list5.get(i).move();
                                                
                            }
                        }
                                        
                    }

                }else if(TrafficPanel.light == 0){//红灯时  //case2
                                    
                    if(i == 0){ //是第一辆车
                                        
                        if(TrafficPanel.list5.get(i).posx <= (250 - lightdiastance)){ //在停车线之前
                            TrafficPanel.list5.get(i).speed = 2;                
                            TrafficPanel.list5.get(i).move();
 
                        }else{ //到停车线时
                                            
                            if((TrafficPanel.list5.get(i).posx + 30)>250){//如果过线
                                TrafficPanel.list5.get(i).speed = 4;
                                TrafficPanel.list5.get(i).move();
                                                
                            }
                        }
                                        
                    }else{ //不是第一辆车
                                        
                        if(TrafficPanel.list5.get(i).posx < (250 - lightdiastance)){ //在停车线以前
                                            
                            if(TrafficPanel.list5.get(i).posx <= (TrafficPanel.list5.get(i-1).posx - distance)){ //车距大于20
                                TrafficPanel.list5.get(i).speed = 2;
                                TrafficPanel.list5.get(i).move();
                                                
                            }
                                         
                        }else{ //在到停车线时
                                            
                            if((TrafficPanel.list5.get(i).posx + 30)>250){//如果过线
                                TrafficPanel.list5.get(i).speed = 4;
                                TrafficPanel.list5.get(i).move();
                                                
                            }
                        }
                                        
                    }
                                    
                }else{ //case3
                
                    if(i == 0){ //是第一辆车
                                        
                        if(TrafficPanel.list5.get(i).posx <= (250 - lightdiastance)){ //在停车线之前
                            TrafficPanel.list5.get(i).speed = 2;                
                            TrafficPanel.list5.get(i).move();
 
                        }else{ //到停车线时
                                            
                            if((TrafficPanel.list5.get(i).posx + 30)>250){//如果过线
                                TrafficPanel.list5.get(i).speed = 4;
                                TrafficPanel.list5.get(i).move();
                                                
                            }
                        }
                                        
                    }else{ //不是第一辆车
                                        
                        if(TrafficPanel.list5.get(i).posx < (250 - lightdiastance)){ //在停车线以前
                                            
                            if(TrafficPanel.list5.get(i).posx <= (TrafficPanel.list5.get(i-1).posx - distance)){ //车距大于20
                                TrafficPanel.list5.get(i).speed = 2;
                                TrafficPanel.list5.get(i).move();
                                                
                            }
                                         
                        }else{ //在到停车线时
                                            
                            if((TrafficPanel.list5.get(i).posx + 30)>250){//如果过线
                                TrafficPanel.list5.get(i).speed = 4;
                                TrafficPanel.list5.get(i).move();
                                                
                            }
                        }
                                        
                    }
                
                }
                
            }else { //在通过红灯之后
                
                if(TrafficPanel.list5.get(i).posx < 650){
                    TrafficPanel.list5.get(i).speed = 4;
                    TrafficPanel.list5.get(i).move();
                }else{
                    TrafficPanel.list5.remove(i);
                }
                                
            }

        }
    
    }    
   
    public void checkRoad6(){
        
        for(int i = 0; i<TrafficPanel.list6.size(); i++){
            
            if(TrafficPanel.list6.get(i).posx < 250){ 
                                
                
                if(TrafficPanel.light == 2){ 
                    if(i == 0){ //是第一辆车
                        TrafficPanel.list6.get(i).speed = 3;
                        TrafficPanel.list6.get(i).move();
                                        
                    }else{ //不是第一辆车
                        if(TrafficPanel.list6.get(i).posx <= TrafficPanel.list6.get(i-1).posx - distance){ //车距大于20
                            TrafficPanel.list6.get(i).speed = 3;
                            TrafficPanel.list6.get(i).move();
                                            
                        }
                    }
                    
                    
                }else if(TrafficPanel.light == 3){ 
                    //已经过线的接着走
                    //没过线的在线前停下
                    if(i == 0){ //是第一辆车
                                        
                        if(TrafficPanel.list6.get(i).posx <= (250 - lightdiastance)){ //在停车线之前
                            TrafficPanel.list6.get(i).speed = 2;
                            TrafficPanel.list6.get(i).move();
 
                        }else{ //到停车线时
                                            
                            if((TrafficPanel.list6.get(i).posx + 30)>250){//如果过线
                                TrafficPanel.list6.get(i).speed = 3;
                                TrafficPanel.list6.get(i).move();
                                                
                            }
                        }
                                        
                    }else{ //不是第一辆车
                                        
                        if(TrafficPanel.list6.get(i).posx < (250 - lightdiastance)){ //在停车线以前
                                            
                            if(TrafficPanel.list6.get(i).posx <= (TrafficPanel.list6.get(i-1).posx - distance)){ //车距大于20
                                TrafficPanel.list6.get(i).speed = 2;
                                TrafficPanel.list6.get(i).move();
                                                
                            }
                                         
                        }else{ //在到停车线时
                                            
                            if((TrafficPanel.list6.get(i).posx + 30)>250){//如果过线
                                TrafficPanel.list6.get(i).speed = 3;
                                TrafficPanel.list6.get(i).move();
                                                
                            }
                        }
                                        
                    }

                }else if(TrafficPanel.light == 0){//红灯时  //case2
                                    
                    if(i == 0){ //是第一辆车
                                        
                        if(TrafficPanel.list6.get(i).posx <= (250 - lightdiastance)){ //在停车线之前
                            TrafficPanel.list6.get(i).speed = 2;                
                            TrafficPanel.list6.get(i).move();
 
                        }else{ //到停车线时
                                            
                            if((TrafficPanel.list6.get(i).posx + 30)>250){//如果过线
                                TrafficPanel.list6.get(i).speed = 3;
                                TrafficPanel.list6.get(i).move();
                                                
                            }
                        }
                                        
                    }else{ //不是第一辆车
                                        
                        if(TrafficPanel.list6.get(i).posx < (250 - lightdiastance)){ //在停车线以前
                                            
                            if(TrafficPanel.list6.get(i).posx <= (TrafficPanel.list6.get(i-1).posx - distance)){ //车距大于20
                                TrafficPanel.list6.get(i).speed = 2;
                                TrafficPanel.list6.get(i).move();
                                                
                            }
                                         
                        }else{ //在到停车线时
                                            
                            if((TrafficPanel.list6.get(i).posx + 30)>250){//如果过线
                                TrafficPanel.list6.get(i).speed = 3;
                                TrafficPanel.list6.get(i).move();
                                                
                            }
                        }
                                        
                    }
                                    
                }else{ //case3
                
                    if(i == 0){ //是第一辆车
                                        
                        if(TrafficPanel.list6.get(i).posx <= (250 - lightdiastance)){ //在停车线之前
                            TrafficPanel.list6.get(i).speed = 2;                
                            TrafficPanel.list6.get(i).move();
 
                        }else{ //到停车线时
                                            
                            if((TrafficPanel.list6.get(i).posx + 30)>250){//如果过线
                                TrafficPanel.list6.get(i).speed = 3;
                                TrafficPanel.list6.get(i).move();
                                                
                            }
                        }
                                        
                    }else{ //不是第一辆车
                                        
                        if(TrafficPanel.list6.get(i).posx < (250 - lightdiastance)){ //在停车线以前
                                            
                            if(TrafficPanel.list6.get(i).posx <= (TrafficPanel.list6.get(i-1).posx - distance)){ //车距大于20
                                TrafficPanel.list6.get(i).speed = 2;
                                TrafficPanel.list6.get(i).move();
                                                
                            }
                                         
                        }else{ //在到停车线时
                                            
                            if((TrafficPanel.list6.get(i).posx + 30)>250){//如果过线
                                TrafficPanel.list6.get(i).speed = 3;
                                TrafficPanel.list6.get(i).move();
                                                
                            }
                        }
                                        
                    }
                
                }
                
            }else { //在通过红灯之后
                if(TrafficPanel.list6.get(i).posx < 650){
                    TrafficPanel.list6.get(i).speed = 3;
                    TrafficPanel.list6.get(i).move();
                }else{
                    TrafficPanel.list6.remove(i);
                }
                                
            }

        }
    
    }    
  

}
