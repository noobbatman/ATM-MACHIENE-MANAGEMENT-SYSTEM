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
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener {
    JButton deposit,withdrawal,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
    setLayout(null);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2=i1.getImage().getScaledInstance(850,820,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel label=new JLabel(i3);
    label.setBounds(0,0,850,820);
    add(label);
    
    JLabel text= new JLabel("Select Withdrawal Amount");
    text.setBounds(200,270,700,35);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System",Font.BOLD,16));
    label.add(text);
    
    deposit=new JButton("500 tk");
    deposit.setBounds(150,320,150,30);
    deposit.addActionListener(this);
    label.add(deposit);
    
    withdrawal=new JButton("1000 tk");
    withdrawal.setBounds(330,320,150,30);
    withdrawal.addActionListener(this);
    label.add(withdrawal);
    
    fastcash=new JButton("2000 tk");
    fastcash.setBounds(150,370,150,30);
    fastcash.addActionListener(this);
    label.add(fastcash);
            
    ministatement=new JButton("5000 tk");
    ministatement.setBounds(330,370,150,30);
    ministatement.addActionListener(this);
    label.add(ministatement);
    
    pinchange=new JButton("50000 tk");
    pinchange.setBounds(330,420,150,30);
    pinchange.addActionListener(this);
    label.add(pinchange);
    
    balanceenquiry=new JButton("10000 tk");
    balanceenquiry.setBounds(150,420,150,30);
    balanceenquiry.addActionListener(this);
    label.add(balanceenquiry);
    
    exit=new JButton("BACK");
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
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else {
        JButton button =(JButton) ae.getSource();
        String fullText= button.getText();
        String amount = fullText.substring(0, fullText.length() - 3);
        Conn c=new Conn();
        try{
        ResultSet rs=c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
        int balance=0;
       
        while(rs.next()){
        if (rs.getString("type").equals("Deposit")){
        balance+=Integer.parseInt(rs.getString("amount"));
        }
        else {
        balance-=Integer.parseInt(rs.getString("amount"));
        }
        }
        if(ae.getSource()!= exit && balance<Integer.parseInt(amount)){
        JOptionPane.showMessageDialog(null,"Insufficient balance");
        return;
        }
        Date date= new Date();
        String query="insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+amount+"')";
        c.s.executeUpdate(query);
        JOptionPane.showMessageDialog(null,"Amount debited succesfully");
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
        }catch(Exception e){
        System.out.println(e);
        }
        }
        
    }
    
   public static void main(String args[]){
   new FastCash("");
   }
            
}
