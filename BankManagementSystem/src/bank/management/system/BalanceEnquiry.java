package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JLabel l2;
    JButton b1;
    String pin;

    BalanceEnquiry(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        JLabel l1 = new JLabel("Your current balance is : ");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(430, 180, 400, 35);
        l1.setForeground(new Color(220, 223, 220));
        l3.add(l1);

        l2 = new JLabel();
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setBounds(430, 220, 400, 35);
        l2.setForeground(new Color(220, 223, 220));
        l3.add(l2);

        b1 = new JButton("Back");
        b1.setBounds(700, 406, 150, 35);
        b1.setBackground(new Color(65, 125, 128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        int balance = 0;
        try {
            con c = new con();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
            while (resultSet.next()) {
                String type = resultSet.getString("Type");
                int amount = Integer.parseInt(resultSet.getString("amount"));

                // ✅ FIXED: Deposit adds, Withdrawal subtracts
                if (type.equalsIgnoreCase("Deposit")) {
                    balance += amount;
                } else if (type.equalsIgnoreCase("Withdrawal")) {
                    balance -= amount;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        l2.setText("Rs. " + balance);
        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new main_Class(pin);
    }
}