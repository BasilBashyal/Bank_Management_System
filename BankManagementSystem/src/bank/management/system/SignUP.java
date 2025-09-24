package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class SignUP implements ActionListener {

    JFrame frame;
    JLabel label1, labelA, label2;
    JRadioButton RMale, RFemale, ROthers, RMarried, RUnmarried;
    JTextField textName, Fname, TextEmail, TextAddr, TextCity, TextPin, TextState;
    JDateChooser dateChooser;
    JButton Next;

    Random ran = new Random();
    long first4 = (ran.nextLong() % 900l) + 1000L;
    String first = " " + Math.abs(first4);

    SignUP() {
        frame = new JFrame("Application Form");


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        // Add the image to a JLabel
        label1 = new JLabel(i3);
        label1.setBounds(25, 10, 100, 100);
        frame.add(label1);

        labelA = new JLabel("Application Form NO." + first4);
        labelA.setBounds(160, 20, 600, 40);
        labelA.setFont(new Font("Raleway", Font.BOLD, 38));
        frame.add(labelA);

        label2 = new JLabel("Page 1");
        label2.setFont(new Font("Raleway", Font.BOLD, 22));
        label2.setBounds(330, 70, 600, 30);
        frame.add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Raleway", Font.BOLD, 28));
        label3.setBounds(290, 90, 600, 35);
        frame.add(label3);

        JLabel lableName = new JLabel("Name :");
        lableName.setFont(new Font("Raleway", Font.BOLD, 20));
        lableName.setBounds(100, 190, 100, 30);
        frame.add(lableName);

        textName = new JTextField();
        textName.setFont(new Font("Raleway", Font.BOLD, 14));
        textName.setBounds(300, 198, 200, 30);
        frame.add(textName);


        JLabel fathersName = new JLabel("Father's Name :");
        fathersName.setFont(new Font("Raleway", Font.BOLD, 20));
        fathersName.setBounds(100, 240, 200, 30);
        frame.add(fathersName);

        Fname = new JTextField();
        Fname.setFont(new Font("Raleway", Font.BOLD, 14));
        Fname.setBounds(300, 240, 200, 30);
        frame.add(Fname);


        JLabel GenderLabel = new JLabel("Gender :");
        GenderLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        GenderLabel.setBounds(100, 290, 200, 30);
        frame.add(GenderLabel);

        RMale = new JRadioButton("Male");
        RMale.setFont(new Font("Raleway", Font.BOLD, 14));
        RMale.setBackground(new Color(222, 225, 228));
        RMale.setBounds(300, 290, 60, 30);
        frame.add(RMale);

        RFemale = new JRadioButton("Female");
        RFemale.setFont(new Font("Raleway", Font.BOLD, 14));
        RFemale.setBackground(new Color(222, 225, 228));
        RFemale.setBounds(450, 290, 90, 30);
        frame.add(RFemale);

        ROthers = new JRadioButton("Others");
        ROthers.setFont(new Font("Raleway", Font.BOLD, 14));
        ROthers.setBackground(new Color(222, 225, 228));
        ROthers.setBounds(600, 290, 90, 30);
        frame.add(ROthers);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(RMale);
        buttonGroup.add(RFemale);
        buttonGroup.add(ROthers);


        JLabel DOB = new JLabel("Date-Of-Birth :");
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        DOB.setBounds(100, 340, 200, 30);
        frame.add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 340, 200, 30);
        frame.add(dateChooser);


        JLabel Emaillbl = new JLabel("Email Address :");
        Emaillbl.setFont(new Font("Raleway", Font.BOLD, 20));
        Emaillbl.setBounds(100, 390, 200, 30);
        frame.add(Emaillbl);

        TextEmail = new JTextField();
        TextEmail.setFont(new Font("Raleway", Font.BOLD, 14));
        TextEmail.setBounds(300, 390, 400, 30);
        frame.add(TextEmail);


        JLabel MS = new JLabel("Marital Status :");
        MS.setFont(new Font("Raleway", Font.BOLD, 20));
        MS.setBounds(100, 440, 200, 30);
        frame.add(MS);

        RMarried = new JRadioButton("Married");
        RMarried.setFont(new Font("Raleway", Font.BOLD, 14));
        RMarried.setBackground(new Color(222, 225, 228));
        RMarried.setBounds(300, 440, 100, 30);
        frame.add(RMarried);

        RUnmarried = new JRadioButton("Un-Married");
        RUnmarried.setFont(new Font("Raleway", Font.BOLD, 14));
        RUnmarried.setBackground(new Color(222, 225, 228));
        RUnmarried.setBounds(450, 440, 120, 30);
        frame.add(RUnmarried);


        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(RMarried);
        buttonGroup1.add(RUnmarried);


        JLabel addr = new JLabel("Address :");
        addr.setFont(new Font("Raleway", Font.BOLD, 20));
        addr.setBounds(100, 490, 200, 30);
        frame.add(addr);

        TextAddr = new JTextField();
        TextAddr.setFont(new Font("Raleway", Font.BOLD, 14));
        TextAddr.setBounds(300, 490, 400, 30);
        frame.add(TextAddr);


        JLabel City = new JLabel("City :");
        City.setFont(new Font("Raleway", Font.BOLD, 20));
        City.setBounds(100, 540, 200, 30);
        frame.add(City);

        TextCity = new JTextField();
        TextCity.setFont(new Font("Raleway", Font.BOLD, 14));
        TextCity.setBounds(300, 540, 400, 30);
        frame.add(TextCity);


        JLabel Pin = new JLabel("Pin Code:");
        Pin.setFont(new Font("Raleway", Font.BOLD, 20));
        Pin.setBounds(100, 590, 200, 30);
        frame.add(Pin);

        TextPin = new JTextField();
        TextPin.setFont(new Font("Raleway", Font.BOLD, 14));
        TextPin.setBounds(300, 590, 400, 30);
        frame.add(TextPin);


        JLabel lState = new JLabel("State:");
        lState.setFont(new Font("Raleway", Font.BOLD, 20));
        lState.setBounds(100, 640, 200, 30);
        frame.add(lState);

        TextState = new JTextField();
        TextState.setFont(new Font("Raleway", Font.BOLD, 14));
        TextState.setBounds(300, 640, 400, 30);
        frame.add(TextState);


        Next = new JButton("Submit");
        Next.setFont(new Font("Raleway", Font.BOLD, 20));
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        Next.setBounds(350, 690, 200, 30);
        Next.addActionListener (this);
        frame.add(Next);


        frame.getContentPane().setBackground(new Color(222, 225, 228));
        frame.setSize(850, 800);
        frame.setLayout(null);
        frame.setLocation(360, 40);
        frame.setVisible(true);


    }
@Override
    public void actionPerformed(ActionEvent e) {

    //textName, Fname, TextEmail, TextAddr, TextCity, TextPin, TextState

    String formno=first;
    String name=textName.getText();
    String fathersName=Fname.getText();
    String dob=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
    String gender = null;
    if(RMale.isSelected()){
        gender="Male";
    }
    if (RFemale.isSelected()){
    gender="Female";
    }
    if (ROthers.isSelected()){
    gender="Others";
    }
    String email = TextEmail.getText();


    String MaritalStatus=null;
        if (RMarried.isSelected()){
            MaritalStatus="Married";
        }
        if (RUnmarried.isSelected()){
            MaritalStatus="UnMarried";
        }


    String address = TextAddr.getText();
    String cities = TextCity.getText();
    String pin = TextPin.getText();
    String stateOfContry = TextState.getText();

    try{
        if (textName.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Fill All The Field");
        }
        else{
            con con1=new con();
            String q="insert into SignUp values('"+formno+"','"+name+"','"+fathersName+"','"+dob+"','"+gender+"','"+email+"','"+MaritalStatus+"','"+address+"','"+cities+"','"+pin+"','"+stateOfContry+"')";
            con1.statement.executeUpdate(q);
            new SignUpsql2(formno);
            frame.setVisible(false);
        }
    } catch (Exception E) {
      E.printStackTrace();
    }
    }

    public static void main(String[] args) {
        new SignUP();
    }
}