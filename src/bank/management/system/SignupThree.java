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
public class SignupThree extends JFrame implements ActionListener {
    
    
    JRadioButton r1,r2,r3,r4;
    ButtonGroup groupaccount;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton Submit,Cancel;
    String formno;
    SignupThree(String formno){
        
        this.formno=formno;
      setLayout(null);
    JLabel page3=new JLabel("Page 3:Account Details");
    page3.setFont(new Font("Raleway",Font.BOLD,38));
    page3.setBounds(240,40,450,45);
    add(page3);
    
    JLabel type=new JLabel("Account Type:");
    type.setFont(new Font("Raleway",Font.BOLD,22));
    type.setBounds(100,140,200,30);
    add(type);
    
    r1=new JRadioButton("Saving Account");
    r1.setFont(new Font("Raleway",Font.BOLD,16));
    r1.setBackground(Color.WHITE);
    r1.setBounds(100,180,150,20);
    add(r1);
    
    r2=new JRadioButton("Fixed Deposit");
    r2.setFont(new Font("Raleway",Font.BOLD,16));
    r2.setBackground(Color.WHITE);
    r2.setBounds(270,180,150,20);
    add(r2);
    
    r3=new JRadioButton("Current Account");
    r3.setFont(new Font("Raleway",Font.BOLD,16));
    r3.setBackground(Color.WHITE);
    r3.setBounds(100,220,150,20);
    add(r3);
    
    r4=new JRadioButton("Recurring Deposit Account");
    r4.setFont(new Font("Raleway",Font.BOLD,16));
    r4.setBackground(Color.WHITE);
    r4.setBounds(270,220,350,30);
    add(r4);
    
    JLabel card=new JLabel("Card Number:");
    card.setFont(new Font("Raleway",Font.BOLD,22));
    card.setBounds(100,260,200,30);
    add(card);
    
    JLabel carddetails=new JLabel("Your 16 digit card number");
    carddetails.setFont(new Font("Raleway",Font.BOLD,12));
    carddetails.setBounds(100,280,400,20);
    add(carddetails);
    
    JLabel number=new JLabel("XXXX-XXXX-XXXX-2323");
    number.setFont(new Font("Raleway",Font.BOLD,22));
    number.setBounds(300,260,300,30);
    add(number);
    
    JLabel pin=new JLabel("PIN Number:");
    pin.setFont(new Font("Raleway",Font.BOLD,22));
    pin.setBounds(100,310,200,30);
    add(pin);
    
    JLabel pindetails=new JLabel("Your 4 digit pin");
    pindetails.setFont(new Font("Raleway",Font.BOLD,12));
    pindetails.setBounds(100,330,200,30);
    add(pindetails);
    
    JLabel pnumber=new JLabel("****");
    pnumber.setFont(new Font("Raleway",Font.BOLD,22));
    pnumber.setBounds(300,310,300,30);
    add(pnumber);
    
    groupaccount=new ButtonGroup();
    groupaccount.add(r1);
    groupaccount.add(r2);
    groupaccount.add(r3);
    groupaccount.add(r4);
    
    
    JLabel services=new JLabel("Services Required:");
    services.setFont(new Font("Raleway",Font.BOLD,22));
    services.setBounds(100,380,400,30);
    add(services); 
    
    c1=new JCheckBox("ATM CARD");
    c1.setBackground(Color.WHITE);
    c1.setFont(new Font("Raleway",Font.BOLD,16));
    c1.setBounds(100,430,300,30);
    add(c1);
    
    
    c2=new JCheckBox("Internet Banking");
    c2.setBackground(Color.WHITE);
    c2.setFont(new Font("Raleway",Font.BOLD,16));
    c2.setBounds(420,430,300,30);
    add(c2);
    
    c3=new JCheckBox("Mobile Banking");
    c3.setBackground(Color.WHITE);
    c3.setFont(new Font("Raleway",Font.BOLD,16));
    c3.setBounds(100,480,300,30);
    add(c3);
    
    c4=new JCheckBox("Email and SMS alerts");
    c4.setBackground(Color.WHITE);
    c4.setFont(new Font("Raleway",Font.BOLD,16));
    c4.setBounds(420,480,300,30);
    add(c4);
    
    c5=new JCheckBox("Cheque Book");
    c5.setBackground(Color.WHITE);
    c5.setFont(new Font("Raleway",Font.BOLD,16));
    c5.setBounds(100,530,300,30);
    add(c5);
    
    c6=new JCheckBox("E-Statement");
    c6.setBackground(Color.WHITE);
    c6.setFont(new Font("Raleway",Font.BOLD,16));
    c6.setBounds(420,530,300,30);
    add(c6);
    
    c7=new JCheckBox("I agree to all the terms and conditions.");
    c7.setBackground(Color.WHITE);
    c7.setFont(new Font("Raleway",Font.BOLD,16));
    c7.setBounds(100,600,500,30);
    add(c7);
    
    Submit=new JButton("Submit");
    Submit.setBackground(Color.BLACK);
    Submit.setForeground(Color.WHITE);
    Submit.setBounds(100,650,100,30);
    Submit.addActionListener(this);
    add(Submit);
    
    Cancel=new JButton("Cancel");
    Cancel.setBackground(Color.BLACK);
    Cancel.setForeground(Color.WHITE);
    Cancel.setBounds(220,650,100,30);
    Cancel.addActionListener(this);
    add(Cancel);
    
    getContentPane().setBackground(Color.white);    
    setSize(850,820);
    setVisible(true);
    setLocation(350,10);
    
     }
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==Submit){
    String accountType=null;
        if(r1.isSelected()){
        accountType="Saving Account";
        }
        else if(r2.isSelected()){
        accountType="Fixed Deposit";
        }
        else if(r3.isSelected()){
        accountType="Current Account";
        }
        else if(r4.isSelected()){
        accountType="Recurring Current Deposit";
        }
        Random random=new Random();
        long generatedCardNumber=Math.abs((random.nextLong()%90000000L))+5040936000000000L;
        String cardnumber=""+generatedCardNumber;
        long generatedPinNumber=Math.abs((random.nextLong()%9000L))+1000L;
        
        String pinnumber=""+generatedPinNumber;
        String facilities="";
        if(c1.isSelected()){
        facilities=facilities+" ATM Card";
        }
        if(c2.isSelected()){
        facilities=facilities+" Internet banking";
        }
        if(c3.isSelected()){
        facilities=facilities+" Mobile Banking";
        }
        if(c4.isSelected()){
        facilities=facilities+" Email and SMS Alert";
        }
        if(c5.isSelected()){
        facilities=facilities+" Cheque Book";
        }
        if(c6.isSelected()){
        facilities=facilities+" E-Statement";
        }
        
        try{
        if(groupaccount.getSelection()==null){
        JOptionPane.showMessageDialog(null,"Account type is required");
        }
        else {
        Conn conn=new Conn();
        String query1="insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facilities+"')";
        String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
        conn.s.executeUpdate(query2);
        conn.s.executeUpdate(query1);
        
        JOptionPane.showMessageDialog(null,"Card Number "+cardnumber+"\n Pin "+pinnumber);
        setVisible(false);
        new Deposit(pinnumber).setVisible(true);
        }
        }
        catch(Exception e){
        System.out.println(e);
        }
    
    }
    else if(ae.getSource()==Cancel){
        setVisible(false);
        new Login().setVisible(true);
    }
    }
    public static void main(String args[]){
    new SignupThree("");
    }
}
