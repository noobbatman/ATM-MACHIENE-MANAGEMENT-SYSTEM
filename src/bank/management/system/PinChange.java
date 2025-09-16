/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    JTextField pin,repin;
    JButton change,back;
    String pinnumber;
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
    setLayout(null);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2=i1.getImage().getScaledInstance(850,820,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel label=new JLabel(i3);
    label.setBounds(0,0,850,820);
    add(label);
    
    JLabel text= new JLabel("CHANGE YOUR PIN");
    text.setBounds(230,270,700,35);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System",Font.BOLD,16));
    label.add(text);
    
    
    JLabel repintext= new JLabel("Re-enter New Pin :");
    repintext.setBounds(160,360,700,35);
    repintext.setForeground(Color.WHITE);
    repintext.setFont(new Font("System",Font.BOLD,16));
    label.add(repintext);
    
    repin=new JTextField();
    repin.setBounds(310,360,150,30);
    repin.setFont(new Font("System",Font.BOLD,14));
    label.add(repin);
    
    JLabel pintext= new JLabel("NEW PIN :");
    pintext.setBounds(160,305,100,35);
    pintext.setForeground(Color.WHITE);
    pintext.setFont(new Font("System",Font.BOLD,16));
    label.add(pintext);
    
    pin=new JTextField();
    pin.setBounds(310,305,150,30);
    pin.setFont(new Font("System",Font.BOLD,14));
    label.add(pin);
    
    change=new JButton("Change");
    change.setBounds(340,410,100,30);
    change.addActionListener(this);
    label.add(change);
    
    back=new JButton("Back");
    back.setBounds(340,450,100,30);
    back.addActionListener(this);
    label.add(back);
    
    getContentPane().setBackground(Color.WHITE);    
    setSize(850,820);
   // setUndecorated(true);
    setLocation(350,10);
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
     if(ae.getSource()==change){
    try{
       
    String npin=pin.getText();
    String rpin=repin.getText();
    if(!npin.equals(rpin)){
    JOptionPane.showMessageDialog(null,"Entered PIN does nor match");
    return;
    }
    
    if(npin.isEmpty()){
    JOptionPane.showMessageDialog(null,"Please enter new PIN");
    return;
    }
    
    if(rpin.isEmpty()){
    JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
    return;
    }
    Conn conn=new Conn();
    //                                          V-- Add a space here
String query1 = "update bank set pin='" + rpin + "' where pin='" + pinnumber + "'";

//                                          V-- And here
String query2 = "update login set pinnumber='" + rpin + "' where pinnumber='" + pinnumber + "'";

//                                          V-- And here
String query3 = "update signupthree set pinnumber='" + rpin + "' where pinnumber='" + pinnumber + "'";
    conn.s.executeUpdate(query1);
    conn.s.executeUpdate(query2);
    conn.s.executeUpdate(query3);
    JOptionPane.showMessageDialog(null,"PIN changed succesfully");
    setVisible(false);
    new Transactions(rpin).setVisible(true);
    }catch(Exception e){
    System.out.println(e);
    }
     }else{
     setVisible(false);
     new Transactions(pinnumber).setVisible(true);
     }
    }
    public static void main(String args[]){
    new PinChange("").setVisible(true);
    }
}
