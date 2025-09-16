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
import com.toedter.calendar.JDateChooser;
public class SignupOne extends JFrame implements ActionListener {
    
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,pinTextField;
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser dateChooser;
    ButtonGroup gendergroup,mstatus;
    SignupOne(){
      setLayout(null);
            
      Random ran=new Random();  
      random= Math.abs((ran.nextLong()%900L)+1000L);    
      JLabel formno=new JLabel("APPLICATION FORM NO. "+random);
      formno.setFont(new Font("Raleway",Font.BOLD,38));
      formno.setBounds(140,20,600,40);
      add(formno);
      
      JLabel personalDetails=new JLabel("Page 1: Personal Details");
      personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
      personalDetails.setBounds(290,80,400,40);
      add(personalDetails);
      
      JLabel name=new JLabel("Name : ");
      name.setFont(new Font("Raleway",Font.BOLD,22));
      name.setBounds(100,140,100,40);
      add(name);
      
      
      nameTextField=new JTextField();
      nameTextField.setBounds(300,140,230,40);
      nameTextField.setFont(new Font("Arial",Font.BOLD,18));
      add(nameTextField);
      
      
      JLabel fname=new JLabel("Father's Name : ");
      fname.setFont(new Font("Raleway",Font.BOLD,22));
      fname.setBounds(100,200,200,40);
      add(fname);
      
      fnameTextField=new JTextField();
      fnameTextField.setBounds(300,200,230,40);
      fnameTextField.setFont(new Font("Arial",Font.BOLD,18));
      add(fnameTextField);
      
      
      JLabel dob=new JLabel("Date of Birth : ");
      dob.setFont(new Font("Raleway",Font.BOLD,22));
      dob.setBounds(100,260,200,40);
      add(dob);
      
      dateChooser= new JDateChooser();
      dateChooser.setBounds(300,260,200,40);
      dateChooser.setForeground(new Color(105,105,105));
      dateChooser.setFont(new Font("Arial",Font.BOLD,18));
      add(dateChooser);
      
      JLabel gender=new JLabel("Gender : ");
      gender.setFont(new Font("Raleway",Font.BOLD,22));
      gender.setBounds(100,320,200,40);
      add(gender);
      
      male= new JRadioButton("Male");
      male.setBounds(300,320,60,30);
      male.setBackground(Color.WHITE);
      add(male);
      
      female= new JRadioButton("Female");
      female.setBounds(450,320,80,30);
      female.setBackground(Color.WHITE);
      add(female);
      
      
      gendergroup=new ButtonGroup();
      gendergroup.add(male);
      gendergroup.add(female);
      
      JLabel email=new JLabel("Email Address : ");
      email.setFont(new Font("Raleway",Font.BOLD,22));
      email.setBounds(100,380,200,40);
      add(email);
      
      
      emailTextField=new JTextField();
      emailTextField.setBounds(300,380,230,40);
      emailTextField.setFont(new Font("Arial",Font.BOLD,18));
      add(emailTextField);
      
      JLabel MStatus=new JLabel("Marital Status : ");
      MStatus.setFont(new Font("Raleway",Font.BOLD,22));
      MStatus.setBounds(100,440,200,40);
      add(MStatus);
      
      married= new JRadioButton("Married");
      married.setBounds(300,440,80,30);
      married.setBackground(Color.WHITE);
      add(married);
      
      unmarried= new JRadioButton("Unmarried");
      unmarried.setBounds(400,440,100,30);
      unmarried.setBackground(Color.WHITE);
      add(unmarried);
      
      other= new JRadioButton("Other");
      other.setBounds(520,440,80,30);
      other.setBackground(Color.WHITE);
      add(other);
      
      
      mstatus=new ButtonGroup();
      mstatus.add(married);
      mstatus.add(unmarried);
      mstatus.add(other);
      
      
      JLabel address=new JLabel("Address : ");
      address.setFont(new Font("Raleway",Font.BOLD,22));
      address.setBounds(100,500,200,40);
      add(address);
      
      addressTextField=new JTextField();
      addressTextField.setBounds(300,500,300,40);
      addressTextField.setFont(new Font("Arial",Font.BOLD,18));
      add(addressTextField);
      
      
      JLabel pinCode=new JLabel("Pin Code : ");
      pinCode.setFont(new Font("Raleway",Font.BOLD,22));
      pinCode.setBounds(100,560,200,40);
      add(pinCode);
      
      pinTextField=new JTextField();
      pinTextField.setBounds(300,560,230,40);
      pinTextField.setFont(new Font("Arial",Font.BOLD,18));
      add(pinTextField);
      
      next=new JButton("Next");
      next.setBounds(380,650,100,30);
      next.setBackground(Color.BLACK);
      next.setForeground(Color.WHITE);
      next.setFont(new Font("Raleway",Font.BOLD,14));
      next.addActionListener(this);
      add(next);

      
        
        
    getContentPane().setBackground(Color.white);    
    setSize(850,800);
    setVisible(true);
    setLocation(350,10);
    }
     public void actionPerformed(ActionEvent ae){
         String formno=""+random;//long
         String name=nameTextField.getText();
         String fname=fnameTextField.getText();
         String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
         String gender=null;
         if(male.isSelected()){
         gender="Male";
         }
         else if(female.isSelected()){
         gender="Female";
         }
         
         String email=emailTextField.getText();
         
         String marital=null;
         if (married.isSelected()){
         marital= "Married";
         }
         else if(unmarried.isSelected()){
         marital="Unmarried";
         }
         else if(other.isSelected()){
         marital="Other";
         }
         
         String address=addressTextField.getText();
         String pin=pinTextField.getText();
         
         try{
             if(name.equals("")){
             JOptionPane.showMessageDialog(null,"Name is Required");
             return;
             }
             
             if(fname.equals("")){
             JOptionPane.showMessageDialog(null,"Father's Name is Required");
             return;
             }
             
             if(dob.equals("")){
             JOptionPane.showMessageDialog(null,"Date of Birth is Required");
             return;
             }
             
             if(gendergroup.getSelection()==null){
             JOptionPane.showMessageDialog(null,"Gender is Required");
             return;
             }
             
             if(email.equals("")){
             JOptionPane.showMessageDialog(null,"Email is Required");
             return;
             }
             
             if(mstatus.getSelection()==null){
             JOptionPane.showMessageDialog(null,"Marital Status is Required");
             return;
             }
             
             if(address.equals("")){
             JOptionPane.showMessageDialog(null,"Address is Required");
             return;
             }
             
             if(pin.equals("")){
             JOptionPane.showMessageDialog(null,"Pin code is Required");
             return;
             }
             
             Conn c= new Conn();
             String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+pin+"')";
             c.s.executeUpdate(query);
             
             setVisible(false);
             new SignUpTwo(formno).setVisible(true);
         
         
         }catch(Exception e){
          e.printStackTrace();
         }
         
     }
    public static void main(String args[]){
    new SignupOne();
    }
    
}
