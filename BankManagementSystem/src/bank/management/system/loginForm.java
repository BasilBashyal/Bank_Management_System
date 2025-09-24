package bank.management.system;

import javax.swing.*;
import javax.xml.namespace.QName;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class loginForm implements ActionListener {
    JFrame frame;
    JLabel label0,labelA,labelB,label1,label2,label3,label4,label5;
    JTextField textFieldA;
    JPasswordField passwordFieldA;
    JButton Button1,Button2,Button3;

    loginForm() {
        frame = new JFrame("Banking System");

        label0=new JLabel("WELCOME TO ATM");
        label0.setForeground(Color.WHITE);
        label0.setFont(new Font("AvantGarde", Font.BOLD, 38));
        label0.setBounds(230,125,450,40);
        frame.add(label0);


        labelA=new JLabel("Card NO:");
        labelA.setFont(new Font("Ralway",Font.BOLD,30));
        labelA.setForeground(Color.WHITE);
        labelA.setBounds(150,190,375,30);
        frame.add(labelA);

        textFieldA=new JTextField(15);
        textFieldA.setBounds(325, 190, 230, 30);
        textFieldA.setFont(new Font("Arial",Font.BOLD,14));
        frame.add(textFieldA);



        labelB=new JLabel("PIN:");
        labelB.setFont(new Font("Ralway",Font.BOLD,30));
        labelB.setForeground(Color.WHITE);
        labelB.setBounds(150,250,375,30);
        frame.add(labelB);

        passwordFieldA= new JPasswordField(15);
        passwordFieldA.setBounds(325,250,230,30);
        passwordFieldA.setFont(new Font("Arial",Font.BOLD,14));
        frame.add(passwordFieldA);


        Button1=new JButton("SIGN IN");
        Button1.setFont(new Font("Arial",Font.BOLD, 14));
        Button1.setForeground(Color.WHITE);
        Button1.setBackground(Color.BLACK);
        Button1.setBounds(300,300,100,30);
        Button1.addActionListener(this);
        frame.add(Button1);


        Button2=new JButton("CLEAR");
        Button2.setFont(new Font("Arial",Font.BOLD, 14));
        Button2.setForeground(Color.WHITE);
        Button2.setBackground(Color.BLACK);
        Button2.setBounds(430,300,100,30);
        Button2.addActionListener(this);
        frame.add(Button2);


        Button3=new JButton("SIGN UP");
        Button3.setFont(new Font("Arial",Font.BOLD, 14));
        Button3.setForeground(Color.WHITE);
        Button3.setBackground(Color.BLACK);
        Button3.setBounds(300,350,230,30);
        Button3.addActionListener(this);
        frame.add(Button3);



        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/backbg.png"));
        Image bgImg = bgIcon.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon bgIconScaled = new ImageIcon(bgImg);
        label3 = new JLabel(bgIconScaled);
        label3.setBounds(0, 0, 850, 480);



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        // Add the image to a JLabel
        label1 = new JLabel(i3);
        label1.setBounds(350,10,100,100);
        frame.add(label1);


        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icons/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        // Add the image to a JLabel
        label2 = new JLabel(ii3);
        label2.setBounds(630,350,100,100);
        frame.add(label2);

        frame.add(label3);


        frame.setSize(850, 480);
        frame.setLocation(450, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);// recommended
        frame.setLayout(null);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try
        {
            if(e.getSource()==Button1){

                con c=new con();
                String cardno=textFieldA.getText();
                String pin= passwordFieldA.getText();
                String q = "select * from login where card_number ='" + cardno + "' and pin ='" + pin + "'";
                ResultSet resultSet= c.statement.executeQuery(q);
                if (resultSet.next()){
                    frame.setVisible(false);
                    new main_Class(pin);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card NO Or PIN NO");
                }


            }
            else if (e.getSource()==Button2) {
                textFieldA.setText("");
                passwordFieldA.setText("");
            }
            else if (e.getSource()==Button3) {
                new SignUP();
                frame.setVisible(false);

            }

        }catch (Exception E){

            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new loginForm();
    }


}
