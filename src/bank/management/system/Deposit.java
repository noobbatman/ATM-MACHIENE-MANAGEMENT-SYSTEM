/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

/**
 *
 * @author Istiak
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Deposit extends JFrame implements ActionListener{
    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    Deposit(String pinnumber){
        this.pinnumber=pinnumber;
    setLayout(null);   
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2=i1.getImage().getScaledInstance(850,820,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel label=new JLabel(i3);
    label.setBounds(0,0,850,820);
    add(label);   
    
    JLabel text= new JLabel("Enter the amount you want to deposit");
    text.setBounds(180,270,700,35);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System",Font.BOLD,16));
    label.add(text);
    
    amount=new JTextField();
    amount.setFont(new Font("Raleway",Font.BOLD,22));
    amount.setBounds(180,330,250,25);
    label.add(amount);
    
    deposit=new JButton("Deposit");
    deposit.setBounds(330,450,100,30);
    deposit.addActionListener(this);
    label.add(deposit);
    
    back=new JButton("Back");
    back.setBounds(180,450,100,30);
    back.addActionListener(this);
    label.add(back);
        
    getContentPane().setBackground(Color.WHITE);    
    setSize(850,820);
    setLocation(350,10);
    setVisible(true);
    }
    
   public void actionPerformed(ActionEvent ae){
   if(ae.getSource()==deposit){
   String number = amount.getText();
   Date date= new Date();
   if(number.equals("")){
   JOptionPane.showMessageDialog(null,"Please enter amount");
   }else {
       try{
    Conn conn=new Conn();
    String query="insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";

    conn.s.executeUpdate(query);
    JOptionPane.showMessageDialog(null,"Amount has been depsoited");
    setVisible(false);
    new Transactions(pinnumber).setVisible(true);
       }catch(Exception e){
       System.out.println(e);
       }
   }
   }
   else if(ae.getSource()==back){
   setVisible(false);
   new Transactions(pinnumber).setVisible(true);
   }
   
   }
    public static void main(String args[]){
        new Deposit("");
    }
}
