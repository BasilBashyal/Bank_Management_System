package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class FastCash extends JFrame implements ActionListener {

    String pin;
    JButton b100, b500, b1000, b2000, b5000, b10000, bBack;

    FastCash(String pin) {
        this.pin = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        JLabel l1 = new JLabel("SELECT WITHDRAWAL AMOUNT");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(460, 180, 700, 35);
        l1.setForeground(new Color(220, 223, 220));
        l3.add(l1);

        b100 = new JButton("Rs 100");
        b100.setBounds(410, 250, 150, 35);
        b100.setBackground(new Color(65, 125, 128));
        b100.setForeground(Color.WHITE);
        b100.addActionListener(this);
        l3.add(b100);

        b500 = new JButton("Rs 500");
        b500.setBounds(700, 250, 150, 35);
        b500.setBackground(new Color(65, 125, 128));
        b500.setForeground(Color.WHITE);
        b500.addActionListener(this);
        l3.add(b500);

        b1000 = new JButton("Rs 1000");
        b1000.setBounds(410, 290, 150, 35);
        b1000.setBackground(new Color(65, 125, 128));
        b1000.setForeground(Color.WHITE);
        b1000.addActionListener(this);
        l3.add(b1000);

        b2000 = new JButton("Rs 2000");
        b2000.setBounds(700, 290, 150, 35);
        b2000.setBackground(new Color(65, 125, 128));
        b2000.setForeground(Color.WHITE);
        b2000.addActionListener(this);
        l3.add(b2000);

        b5000 = new JButton("Rs 5000");
        b5000.setBounds(410, 330, 150, 35);
        b5000.setBackground(new Color(65, 125, 128));
        b5000.setForeground(Color.WHITE);
        b5000.addActionListener(this);
        l3.add(b5000);

        b10000 = new JButton("Rs 10000");
        b10000.setBounds(700, 330, 150, 35);
        b10000.setBackground(new Color(65, 125, 128));
        b10000.setForeground(Color.WHITE);
        b10000.addActionListener(this);
        l3.add(b10000);

        bBack = new JButton("BACK");
        bBack.setBounds(700, 406, 150, 35);
        bBack.setBackground(new Color(65, 125, 128));
        bBack.setForeground(Color.WHITE);
        bBack.addActionListener(this);
        l3.add(bBack);

        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == bBack) {
                setVisible(false);
                new main_Class(pin);
                return;
            }

            // Get amount from button text
            String amountStr = ((JButton) e.getSource()).getText().replace("Rs ", "");
            int amount = Integer.parseInt(amountStr);

            // Calculate current balance
            con c = new con();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
            int balance = 0;
            while (rs.next()) {
                String type = rs.getString("Type");
                int amt = Integer.parseInt(rs.getString("amount"));
                if (type.equalsIgnoreCase("Deposit")) {
                    balance += amt;
                } else if (type.equalsIgnoreCase("Withdrawal")) {
                    balance -= amt;
                }
            }

            if (balance < amount) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            // ✅ FIX: Format date for MySQL DATETIME
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = sdf.format(new java.util.Date());

            // ✅ Insert withdrawal with correct Type and formatted date
            c.statement.executeUpdate("INSERT INTO bank VALUES('" + pin + "', '" + formattedDate + "', 'Withdrawal', '" + amount + "')");

            JOptionPane.showMessageDialog(null, "Rs. " + amount + " withdrawn successfully");
            setVisible(false);
            new main_Class(pin);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error processing Fast Cash request");
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}