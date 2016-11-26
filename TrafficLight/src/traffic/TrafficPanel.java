/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traffic;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Random;
import static javafx.scene.input.KeyCode.I;


public class TrafficPanel extends JPanel{
    
    public static java.util.ArrayList <Car> list1 = new ArrayList<Car>();
    public static java.util.ArrayList <Car> list2 = new ArrayList<Car>(); 
    public static java.util.ArrayList <Car> list3 = new ArrayList<Car>();
    public static java.util.ArrayList <Car> list4 = new ArrayList<Car>();
    public static java.util.ArrayList <Car> list5 = new ArrayList<Car>();
    public static java.util.ArrayList <Car> list6 = new ArrayList<Car>();
    //public static boolean light,center;
    public static int light,light1,bgpnum;
    JPanel oppanel,listpanel;
    JButton changebtn,addbtn,bgpbtn;
    JLabel listbtn;
    JCheckBox r1,r2,r3,r4,r5,r6;
    CarPanel carpanel;
    Timer changetimer,lightchoose1,lightchoose2,lightchoose3,lightchoose0;
    int carborn = -10;
    Random r;
    public int count,count1= 0;
    
//    public boolean carlist1 = true;
//    public boolean carlist2 = true;
//    public boolean carlist3 = true;
//    public boolean carlist4 = true;
//    public boolean carlist5 = true;
//    public boolean carlist6 = true;
    
    
    public TrafficPanel(){
        
        this.setLayout(new BorderLayout());
        r = new Random();
        
        light = 0;
        light1 = 0;
        oppanel = new JPanel();
        oppanel.setLayout(new FlowLayout());
        listpanel = new JPanel();
        listpanel.setLayout(new FlowLayout());
        Icon i=new ImageIcon("background.jpg");
        changebtn = new JButton("Change");
        addbtn = new JButton("add");
        bgpbtn = new JButton("background");

        
        changebtn.addActionListener(new ButtonListener());
        addbtn.addActionListener(new ButtonListener());
        bgpbtn.addActionListener(new ButtonListener());
        
        r1 = new JCheckBox ("list1");
        r2 = new JCheckBox ("list2");
        r3 = new JCheckBox ("list3");
        r4 = new JCheckBox ("list4");
        r5 = new JCheckBox ("list5");
        r6 = new JCheckBox ("list6");
        listbtn = new JLabel("选择你所要显示的车道（可多选）");
        
        Change listener = new Change();
        r1.addItemListener(listener);
        r2.addItemListener(listener);
        r3.addItemListener(listener);
        r4.addItemListener(listener);
        r5.addItemListener(listener);
        r6.addItemListener(listener);
        listpanel.add(r1); 
        listpanel.add(r2); 
        listpanel.add(r3);
        listpanel.add(r4);
        listpanel.add(r5);
        listpanel.add(r6);
        listpanel.add(listbtn);
                
        oppanel.add(changebtn);
        oppanel.add(addbtn);
        oppanel.add(bgpbtn);
        
        changetimer = new Timer(100,new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                int i = r.nextInt(10);

                switch(i){
                    case 1:
                        if(list1.size()>=1){
                            if(list1.get(list1.size()-1).posy > carborn){
                                list1.add(new Car(0));
                                break;
                                
                            }                            
                        }else{
                            list1.add(new Car(0));
                            break;
                        }
                        
                    case 2:
                        if(list2.size()>=1){
                            if(list2.get(list2.size()-1).posy > carborn){
                                list2.add(new Car(1));
                                break;
                                
                            }                            
                        }else{
                            list2.add(new Car(1));
                            break;
                        }
                    
                    case 3:
                        if(list3.size()>=1){
                            if(list3.get(list3.size()-1).posy > carborn){
                                list3.add(new Car(2));
                                break;        
                            }
                            
                        }else{
                            list3.add(new Car(2));
                            break;
                        }

                    case 4:
                        if(list4.size()>=1){
                            if(list4.get(list4.size()-1).posx > carborn){
                                list4.add(new Car(3));
                                break;
                                
                            }
                            
                        }else{
                            list4.add(new Car(3));
                            break;
                        }                    

                    case 5:
                        if(list5.size()>=1){
                            if(list5.get(list5.size()-1).posx > carborn){
                                list5.add(new Car(4));
                                break;                                
                            }
                            
                        }else{
                            list5.add(new Car(4));
                            break;
                        }

                    case 6:
                        if(list6.size()>=1){
                            if(list6.get(list6.size()-1).posx > carborn){
                                list6.add(new Car(5));
                                break;                                
                            }
                            
                        }else{
                            list6.add(new Car(5));
                            break;
                        }
                    
                    default:
                        break;
                }
                
            }
        });
        
        lightchoose0 = new Timer(7000,new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                
                light += 1;
                light1 += 1;
                lightchoose0.stop();
                lightchoose1.start();
            }
        });
        
        lightchoose1 = new Timer(2000,new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                
                light += 1;
                light1 += 1;
                lightchoose1.stop();
                lightchoose2.start();
            }
        });
        
        lightchoose2 = new Timer(6000,new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                
                light += 1;
                light1 += 1;
                lightchoose2.stop();
                lightchoose3.start();
            }
        });
        
        lightchoose3 = new Timer(2000,new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                
                light = 0;
                light1 = 0;
                lightchoose3.stop();
                lightchoose0.start();
            }
        });
        
        
        lightchoose0.start();
        changetimer.start();
        
        carpanel = new CarPanel();
        
        this.add(oppanel,BorderLayout.EAST);
        this.add(carpanel,BorderLayout.WEST);
        this.add(listpanel,BorderLayout.SOUTH);
    
    }
    
    
    class ButtonListener implements ActionListener{
    
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource() == addbtn){
                list1.add(new Car(0));
                list2.add(new Car(1));
                list3.add(new Car(2));
                list4.add(new Car(3));
                list5.add(new Car(4));
                list6.add(new Car(5));
                System.out.print("length:" + list4.size() + "\n");
                
            }
            
            if(e.getSource() == changebtn){

                if(light < 3){ 
                    light +=1; 
                }else {
                    light = 0;
                }
                if(light1 < 3){ 
                    light1 +=1; 
                }else {
                    light1 = 0;
                }
                
                
            }
            
            if(e.getSource() == bgpbtn){
                int a=count%5;
                count++;
                switch(a){
                    case 0:
                        bgpnum =1;
                        break;
                    case 1:
                        bgpnum =2;
                        break;
                    case 2:
                        bgpnum =3;
                        break;
                    case 3:
                        bgpnum =4;
                        break;
                    case 4:
                        bgpnum =5;
                        break;
                        
                }
                
            }
            
        }
    
    }
    
    
    private class Change implements ItemListener{
        public void itemStateChanged(ItemEvent e){
            String s = "选择你所要显示的车道（可多选）";
            if (r1.isSelected())
                carpanel.carlist1 = true;
            else
                carpanel.carlist1 = false;
            if (r2.isSelected())
                carpanel.carlist2 = true;
            else
                carpanel.carlist2 = false;
            if (r3.isSelected())
                carpanel.carlist3 = true;
            else
                carpanel.carlist3 = false;
            if (r4.isSelected())
                carpanel.carlist4 = true;
            else
                carpanel.carlist4 = false;
            if (r5.isSelected())
                carpanel.carlist5 = true;
            else
                carpanel.carlist5 = false;
            if (r6.isSelected())
                carpanel.carlist6 = true;
            else
                carpanel.carlist6 = false;
            listbtn.setText(s);
        }
    }
        
       
}
