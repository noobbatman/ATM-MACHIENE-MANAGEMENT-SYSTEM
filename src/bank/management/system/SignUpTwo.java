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


public class SignUpTwo extends JFrame implements ActionListener {
    
    
    JTextField nationalTextField;
    JButton next;
    JRadioButton seniorYes,seniorNo,existYes,existNo;
    JComboBox dropreligion,dropincome,dropeducation,occ;
    String formno;
    ButtonGroup sstatus,sexist;
    SignUpTwo(String formno){
        
        this.formno=formno;
      setLayout(null);
      setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 2") ;     
     
      
      JLabel additionalDetails=new JLabel("Page 2: Additional Details");
      additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
      additionalDetails.setBounds(290,80,400,40);
      add(additionalDetails);
      
      JLabel religion=new JLabel("Religion : ");
      religion.setFont(new Font("Raleway",Font.BOLD,22));
      religion.setBounds(100,140,150,40);
      add(religion);
      
      String valReligion[]={"Hindu","Muslim","Christian","Buddhist","Other"};
      dropreligion=new JComboBox(valReligion);
      dropreligion.setBounds(300,140,230,40);
      dropreligion.setBackground(Color.WHITE);
      add(dropreligion);
     
      
      JLabel income=new JLabel("Income : ");
      income.setFont(new Font("Raleway",Font.BOLD,22));
      income.setBounds(100,200,200,40);
      add(income);
      
      String incomeCategory[]={"NULL","<150k","250k","500k","Upto 1M"};
      dropincome=new JComboBox(incomeCategory);
      dropincome.setBounds(300,200,230,40);
      dropincome.setBackground(Color.WHITE);
      add(dropincome);
      
      JLabel education=new JLabel("Educational");
      education.setFont(new Font("Raleway",Font.BOLD,22));
      education.setBounds(100,260,200,40);
      add(education);
      
      
      
      JLabel qualification=new JLabel("Qualification : ");
      qualification.setFont(new Font("Raleway",Font.BOLD,22));
      qualification.setBounds(100,290,200,40);
      add(qualification);
      
      String educationValue[]={"ILLITERATE","PSC","JSC","SSC","HSC","GRADUATION "};
      dropeducation=new JComboBox(educationValue);
      dropeducation.setBounds(300,290,230,40);
      dropeducation.setBackground(Color.WHITE);
      add(dropeducation);
      
      
      JLabel occupation=new JLabel("Occupation : ");
      occupation.setFont(new Font("Raleway",Font.BOLD,22));
      occupation.setBounds(100,350,200,40);
      add(occupation);
      
      String occValue[]={"Govt Job","Business","Unemployeed","Retired","Others"};
      occ=new JComboBox(occValue);
      occ.setBounds(300,350,230,40);
      occ.setBackground(Color.WHITE);
      add(occ);
      
      
      JLabel national=new JLabel("National ID No : ");
      national.setFont(new Font("Raleway",Font.BOLD,22));
      national.setBounds(100,410,200,40);
      add(national);
      
      nationalTextField=new JTextField();
      nationalTextField.setBounds(300,410,300,40);
      nationalTextField.setFont(new Font("Arial",Font.BOLD,18));
      add(nationalTextField);
      
      
      JLabel senior=new JLabel("Senior Citizen : ");
      senior.setFont(new Font("Raleway",Font.BOLD,22));
      senior.setBounds(100,470,200,40);
      add(senior);
      
      seniorYes=new JRadioButton("Yes");
      seniorYes.setBounds(300,475 ,80,30);
      seniorYes.setBackground(Color.WHITE);
      add(seniorYes);
      
      seniorNo=new JRadioButton("No");
      seniorNo.setBounds(420,475 ,80,30);
      seniorNo.setBackground(Color.WHITE);
      add(seniorNo);
      
      sstatus=new ButtonGroup();
      sstatus.add(seniorYes);
      sstatus.add(seniorNo);
      
      
      
      JLabel existAccount=new JLabel("Existing Account : ");
      existAccount.setFont(new Font("Raleway",Font.BOLD,22));
      existAccount.setBounds(100,530,300,40);
      add(existAccount);
      
      existYes=new JRadioButton("Yes");
      existYes.setBounds(300,540 ,80,30);
      existYes.setBackground(Color.WHITE);
      add(existYes);
      
      existNo=new JRadioButton("No");
      existNo.setBounds(420,540 ,80,30);
      existNo.setBackground(Color.WHITE);
      add(existNo);
      
      
      sexist=new ButtonGroup();
      sexist.add(existYes);
      sexist.add(existNo);
      
      
      next=new JButton("Next");
      next.setBounds(380,680,100,30);
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
         
         String sreligion=(String)dropreligion.getSelectedItem();
         String sincome=(String)dropincome.getSelectedItem();
         String seducation=(String)dropeducation.getSelectedItem();
         String soccupation=(String)occ.getSelectedItem();
         String snation=nationalTextField.getText();
         String ssenior=null;
         if(seniorYes.isSelected()){
         ssenior="Yes";
         }
         else if(seniorNo.isSelected()){
         ssenior="No";
         }
         
         
         String exists=null;
         if (existYes.isSelected()){
         exists= "Yes";
         }
         else if(existNo.isSelected()){
         exists="No";
         }
         
         
         
         
         try{
             if(dropreligion.getSelectedIndex()==0){
             JOptionPane.showMessageDialog(null,"Religion is Required");
             return;
             }
             
             if(dropincome.getSelectedIndex()==0){
             JOptionPane.showMessageDialog(null,"Income is Required");
             return;
             }
             
             if(dropeducation.getSelectedIndex()==0){
             JOptionPane.showMessageDialog(null,"Education is Required");
             return;
             }
             
             if(occ.getSelectedIndex()==0){
             JOptionPane.showMessageDialog(null,"Occupation is Required");
             return;
             }
             
             if(snation.equals("")){
             JOptionPane.showMessageDialog(null,"Nation ID No is Required");
             return;
             }
             
             if(sexist.getSelection()==null){
             JOptionPane.showMessageDialog(null,"Data for Existing account Required");
             return;
             }
             
             if(sstatus.getSelection()==null){
             JOptionPane.showMessageDialog(null,"Senior Citizen is Required");
             return;
             }
             
             
             
             Conn c= new Conn();
             String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+snation+"','"+ssenior+"','"+exists+"')";
             c.s.executeUpdate(query);
             
             
         setVisible(false);
         new SignupThree(formno).setVisible(true);
         
         }catch(Exception e){
          e.printStackTrace();
         }
         
     }
    public static void main(String args[]){
    new SignUpTwo("");
    }
    
}
