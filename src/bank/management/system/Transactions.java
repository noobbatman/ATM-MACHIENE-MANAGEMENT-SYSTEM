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

public class Transactions extends JFrame implements ActionListener {
    JButton deposit,withdrawal,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
    setLayout(null);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2=i1.getImage().getScaledInstance(850,820,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel label=new JLabel(i3);
    label.setBounds(0,0,850,820);
    add(label);
    
    JLabel text= new JLabel("Please select your Transaction");
    text.setBounds(200,270,700,35);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System",Font.BOLD,16));
    label.add(text);
    
    deposit=new JButton("Deposit");
    deposit.setBounds(150,320,150,30);
    deposit.addActionListener(this);
    label.add(deposit);
    
    withdrawal=new JButton("Withdrawal");
    withdrawal.setBounds(330,320,150,30);
    withdrawal.addActionListener(this);
    label.add(withdrawal);
    
    fastcash=new JButton("FastCash");
    fastcash.setBounds(150,370,150,30);
    fastcash.addActionListener(this);
    label.add(fastcash);
            
    ministatement=new JButton("Mini Statement");
    ministatement.setBounds(330,370,150,30);
    ministatement.addActionListener(this);
    label.add(ministatement);
    
    pinchange=new JButton("Pin Change");
    pinchange.setBounds(330,420,150,30);
    pinchange.addActionListener(this);
    label.add(pinchange);
    
    balanceenquiry=new JButton("Balance Enquiry");
    balanceenquiry.setBounds(150,420,150,30);
    balanceenquiry.addActionListener(this);
    label.add(balanceenquiry);
    
    exit=new JButton("Exit");
    exit.setBounds(250,470,100,30);
    exit.addActionListener(this);
    label.add(exit);
    
    
    getContentPane().setBackground(Color.WHITE);    
    setSize(850,820);
   // setUndecorated(true);
    setLocation(350,10);
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }
        else if(ae.getSource()==deposit){
        setVisible(false);
        new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawal){
        setVisible(false);
        new Withdrawal(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash){
        new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinchange){
        new PinChange(pinnumber).setVisible(true);
        }
         else if(ae.getSource()==balanceenquiry){
        new BalanceEnquiry(pinnumber).setVisible(true);
        }
         else if(ae.getSource()==ministatement){
        new MiniStatement(pinnumber).setVisible(true);
        }
    }
    
   public static void main(String args[]){
   new Transactions("");
   }
            
}
