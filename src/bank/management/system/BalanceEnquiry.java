package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    String pinnumber; // Renamed for clarity

    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 820, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 820);
        add(image);

        back = new JButton("Back");
        back.setBounds(340, 450, 100, 30);
        back.addActionListener(this);
        image.add(back);

        // --- Calculate and Display Balance ---
        int balance = 0;
        Conn c = new Conn();
        try {
            String query = "select * from bank where pin = ?";
            PreparedStatement pst = c.c.prepareStatement(query);
            pst.setString(1, pinnumber); // Use the correct variable
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else { // Withdrawal
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         
        // Create a new label to show the calculated balance
        JLabel text = new JLabel("Your Current Account Balance is Tk " + balance);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(160, 270, 400, 30);
        image.add(text); // Add the balance label to the image

        setSize(850, 820);
        setLocation(350, 10);
        setUndecorated(true);
        setVisible(true);
    }

    // This method now ONLY handles the back button action
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }

    public static void main(String args[]) {
        new BalanceEnquiry("");
    }
}