package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Withdrawl extends JFrame implements ActionListener {

    String pin;
    JTextField textField;
    JButton b1, b2;

    Withdrawl(String pin) {
        setLayout(null);
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        JLabel l1 = new JLabel("MAXIMUM WITHDRAWAL IS 10000");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(460, 180, 400, 35);
        l1.setForeground(new Color(220, 223, 220));
        l3.add(l1);

        JLabel l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setBounds(460, 220, 400, 35);
        l2.setForeground(new Color(220, 223, 220));
        l3.add(l2);

        textField = new JTextField();
        textField.setBackground(new Color(65, 125, 128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460, 260, 320, 25);
        textField.setFont(new Font("Raleway", Font.BOLD, 22));
        l3.add(textField);

        b1 = new JButton("WITHDRAWAL");
        b1.setBounds(700, 365, 150, 35);
        b1.setBackground(new Color(65, 125, 128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(700, 400, 150, 35);
        b2.setBackground(new Color(65, 125, 128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == b1) { // WITHDRAWAL button
                String amount = textField.getText().trim();

                if (amount.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
                    return;
                }

                // Validate amount is a number
                int withdrawAmount;
                try {
                    withdrawAmount = Integer.parseInt(amount);
                    if (withdrawAmount <= 0) {
                        JOptionPane.showMessageDialog(null, "Amount must be greater than 0");
                        return;
                    }
                    if (withdrawAmount > 10000) {
                        JOptionPane.showMessageDialog(null, "Maximum withdrawal limit is Rs. 10000");
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number");
                    return;
                }

                con c = new con();
                ResultSet resultSet = c.statement.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
                int balance = 0;

                // Calculate total balance from all transactions
                while (resultSet.next()) {
                    String type = resultSet.getString("Type");
                    int transAmount = Integer.parseInt(resultSet.getString("amount"));

                    if (type.equalsIgnoreCase("Deposit")) {
                        balance += transAmount;
                    } else if (type.equalsIgnoreCase("Withdrawal")) {
                        balance -= transAmount;
                    }
                }

                // Check sufficient balance
                if (balance < withdrawAmount) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                // ✅ Format date for MySQL DATETIME
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = sdf.format(new java.util.Date());

                // ✅ Insert new withdrawal record with correct Type and formatted date
                c.statement.executeUpdate("INSERT INTO bank VALUES('" + pin + "', '" + formattedDate + "', 'Withdrawal', '" + withdrawAmount + "')");

                JOptionPane.showMessageDialog(null, "Rs. " + amount + " debited successfully");
                setVisible(false);
                new main_Class(pin);

            } else if (e.getSource() == b2) { // BACK button
                setVisible(false);
                new main_Class(pin);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error processing withdrawal");
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}