package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    String pin;
    JPasswordField oldPinField, newPinField, confirmPinField;
    JButton bChange, bBack;

    PinChange(String pin) {
        this.pin = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        JLabel l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 18));
        l1.setBounds(600, 180, 400, 30);
        l1.setForeground(Color.WHITE);
        l3.add(l1);

        JLabel l2 = new JLabel("Current PIN:");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setBounds(450, 250, 200, 25);
        l2.setForeground(Color.WHITE);
        l3.add(l2);

        oldPinField = new JPasswordField();
        oldPinField.setBounds(650, 250, 180, 25);
        oldPinField.setFont(new Font("Raleway", Font.BOLD, 16));
        l3.add(oldPinField);

        JLabel l3a = new JLabel("New PIN:");
        l3a.setFont(new Font("System", Font.BOLD, 16));
        l3a.setBounds(450, 290, 200, 25);
        l3a.setForeground(Color.WHITE);
        l3.add(l3a);

        newPinField = new JPasswordField();
        newPinField.setBounds(650, 290, 180, 25);
        newPinField.setFont(new Font("Raleway", Font.BOLD, 16));
        l3.add(newPinField);

        JLabel l4 = new JLabel("Confirm New PIN:");
        l4.setFont(new Font("System", Font.BOLD, 16));
        l4.setBounds(450, 330, 200, 25);
        l4.setForeground(Color.WHITE);
        l3.add(l4);

        confirmPinField = new JPasswordField();
        confirmPinField.setBounds(650, 330, 180, 25);
        confirmPinField.setFont(new Font("Raleway", Font.BOLD, 16));
        l3.add(confirmPinField);

        bChange = new JButton("CHANGE");
        bChange.setBounds(550, 400, 120, 30);
        bChange.setBackground(new Color(65, 125, 128));
        bChange.setForeground(Color.WHITE);
        bChange.addActionListener(this);
        l3.add(bChange);

        bBack = new JButton("BACK");
        bBack.setBounds(700, 400, 120, 30);
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
        if (e.getSource() == bBack) {
            setVisible(false);
            new main_Class(pin);
            return;
        }

        try {
            String oldPin = new String(oldPinField.getPassword());
            String newPin = new String(newPinField.getPassword());
            String confirmPin = new String(confirmPinField.getPassword());

            if (!oldPin.equals(this.pin)) {
                JOptionPane.showMessageDialog(null, "Incorrect Current PIN");
                return;
            }

            if (!newPin.equals(confirmPin)) {
                JOptionPane.showMessageDialog(null, "New PINs do not match");
                return;
            }

            if (newPin.length() != 4) {
                JOptionPane.showMessageDialog(null, "PIN must be 4 digits");
                return;
            }

            // Update PIN in login and signupsql3 tables
            con c = new con();
            c.statement.executeUpdate("UPDATE login SET pin = '" + newPin + "' WHERE pin = '" + pin + "'");
            c.statement.executeUpdate("UPDATE signupsql3 SET pin = '" + newPin + "' WHERE pin = '" + pin + "'");

            JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
            setVisible(false);
            new main_Class(newPin); // Pass new PIN to next screen

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error changing PIN");
        }
    }

    public static void main(String[] args) {
        new PinChange("");
    }
}