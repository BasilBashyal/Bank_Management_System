package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {

    String pin;
    JTextArea textArea;
    JButton bBack;

    MiniStatement(String pin) {
        this.pin = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        JLabel l1 = new JLabel("MINI STATEMENT");
        l1.setFont(new Font("System", Font.BOLD, 18));
        l1.setBounds(600, 150, 400, 30);
        l1.setForeground(Color.WHITE);
        l3.add(l1);

        textArea = new JTextArea();
        textArea.setBounds(400, 200, 600, 400);
        textArea.setFont(new Font("Raleway", Font.PLAIN, 16));
        textArea.setBackground(new Color(65, 125, 128));
        textArea.setForeground(Color.WHITE);
        textArea.setEditable(false);
        l3.add(textArea);

        bBack = new JButton("BACK");
        bBack.setBounds(700, 630, 150, 35);
        bBack.setBackground(new Color(65, 125, 128));
        bBack.setForeground(Color.WHITE);
        bBack.addActionListener(this);
        l3.add(bBack);

        // Load transactions
        StringBuilder sb = new StringBuilder();
        sb.append("PIN: ").append(pin).append("\n");
        sb.append("================================\n");

        int balance = 0;
        try {
            con c = new con();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "' ORDER BY date DESC LIMIT 10");
            while (rs.next()) {
                String date = rs.getString("date");
                String type = rs.getString("Type");
                String amount = rs.getString("amount");

                sb.append(date.substring(0, 19)).append(" | ");
                sb.append(type).append(" | Rs. ").append(amount).append("\n");

                if (type.equalsIgnoreCase("Deposit")) balance += Integer.parseInt(amount);
                else if (type.equalsIgnoreCase("Withdrawal")) balance -= Integer.parseInt(amount);
            }
            sb.append("================================\n");
            sb.append("CURRENT BALANCE: Rs. ").append(balance);

            textArea.setText(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new main_Class(pin);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}