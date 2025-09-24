package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class SignUpsql2 extends JFrame implements ActionListener {

    JComboBox combobox,combobox2,combobox3,combobox4,combobox5;
    JTextField textpan;
    JRadioButton R1,R2,E1,E2;
JButton Next;
String formno;
    SignUpsql2(String formno){
        super("Application Form");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        // Add the image to a JLabel
        JLabel Image1= new JLabel(i3);
        Image1.setBounds(150, 5, 100, 100);
        add(Image1);

        this.formno=formno;

        JLabel l1=new JLabel("Page 2");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(300,60,600,40);
        add(l1);

        JLabel l2=new JLabel("Additional Detail");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(300,90,600,40);
        add(l2);


        JLabel l3=new JLabel("Religion :");
        l3.setFont(new Font("Raleway",Font.BOLD,22));
        l3.setBounds(150,150,150,30);
        add(l3);

        String religion[] ={"Hindu","Muslim","Christian","Others"};

        combobox=new JComboBox(religion);
        combobox.setBackground(new Color(225,208,76));
        combobox.setFont(new Font("Raleway",Font.BOLD,22));
        combobox.setBounds(350,150,320,30);
        add(combobox);



        JLabel l4=new JLabel("Category :");
        l4.setFont(new Font("Raleway",Font.BOLD,22));
        l4.setBounds(150,200,150,30);
        add(l4);

        String Category[] ={"General","OBC","SC","ST","Others"};

        combobox2=new JComboBox(Category);
        combobox2.setBackground(new Color(225,208,76));
        combobox2.setFont(new Font("Raleway",Font.BOLD,22));
        combobox2.setBounds(350,200,320,30);
        add(combobox2);



        JLabel l5=new JLabel("Income :");
        l5.setFont(new Font("Raleway",Font.BOLD,22));
        l5.setBounds(150,250,100,30);
        add(l5);

        String income[] ={"Null","<1,50,000","<2,50,000","<5,00,000","UpTo 10,00,000","Above 10,00,000"};

        combobox3=new JComboBox(income);
        combobox3.setBackground(new Color(225,208,76));
        combobox3.setFont(new Font("Raleway",Font.BOLD,22));
        combobox3.setBounds(350,250,320,30);
        add(combobox3);




        JLabel l6=new JLabel("Education :");
        l6.setFont(new Font("Raleway",Font.BOLD,22));
        l6.setBounds(150,300,150,30);
        add(l6);

        String educational[] ={"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};

        combobox4=new JComboBox(educational);
        combobox4.setBackground(new Color(225,208,76));
        combobox4.setFont(new Font("Raleway",Font.BOLD,22));
        combobox4.setBounds(350,300,320,30);
        add(combobox4);



        JLabel l7=new JLabel("Occupation :");
        l7.setFont(new Font("Raleway",Font.BOLD,22));
        l7.setBounds(150,350,150,30);
        add(l7);

        String occupation[] ={"Salaried","Self-Employed","Business","Students","Retired","Others"};

        combobox5=new JComboBox(occupation);
        combobox5.setBackground(new Color(225,208,76));
        combobox5.setFont(new Font("Raleway",Font.BOLD,22));
        combobox5.setBounds(350,350,320,30);
        add(combobox5);




        JLabel l8=new JLabel("PAN Number :");
        l8.setFont(new Font("Raleway",Font.BOLD,22));
        l8.setBounds(150,400,180,30);
        add(l8);

        textpan=new JTextField();
        textpan.setFont(new Font("Raleway",Font.BOLD,18));
        textpan.setBounds(350,400,320,30);
        add(textpan);


        JLabel l9=new JLabel("Senior Citizen :");
        l9.setFont(new Font("Raleway",Font.BOLD,22));
        l9.setBounds(150,450,180,30);
        add(l9);

        R1=new JRadioButton("Yes");
        R1.setFont(new Font("Raleway",Font.BOLD,20));
        R1.setBackground(new Color(252,208,76));
        R1.setBounds(350,450,100,30);
        add(R1);

        R2=new JRadioButton("No");
        R2.setFont(new Font("Raleway",Font.BOLD,20));
        R2.setBackground(new Color(252,208,76));
        R2.setBounds(500,450,100,30);
        add(R2);




        JLabel l10=new JLabel("Existing Account :");
        l10.setFont(new Font("Raleway",Font.BOLD,22));
        l10.setBounds(150,500,200,30);
        add(l10);

        E1=new JRadioButton("Yes");
        E1.setFont(new Font("Raleway",Font.BOLD,20));
        E1.setBackground(new Color(252,208,76));
        E1.setBounds(350,500,100,30);
        add(E1);

        E2=new JRadioButton("No");
        E2.setFont(new Font("Raleway",Font.BOLD,20));
        E2.setBackground(new Color(252,208,76));
        E2.setBounds(500,500,100,30);
        add(E2);



        JLabel l11=new JLabel("Form No :");
        l11.setFont(new Font("Raleway",Font.BOLD,20));
        l11.setBounds(600,10,120,30);
        add(l11);

        JLabel l12=new JLabel(formno);
        l12.setFont(new Font("Raleway",Font.BOLD,22));
        l12.setBounds(700,10,100,30);
        add(l12);


        Next=new JButton("Next");
        Next.setFont(new Font("Raleway",Font.BOLD,14));
        Next.setBackground(Color.WHITE);
        Next.setForeground(Color.BLACK);
        Next.setBounds(570,640,100,30);
        Next.addActionListener(this );
        add(Next);




        setSize(850,750);
    setLocation(450,80);
    getContentPane().setBackground(new Color(252,208,76));
    setLayout(null);
    setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
    String religion = (String) combobox.getSelectedItem();
    String category = (String) combobox2.getSelectedItem();
    String income = (String) combobox3.getSelectedItem();
    String education =(String) combobox4.getSelectedItem();
    String occupation = (String) combobox5.getSelectedItem();
    String pan_number = (String) textpan.getText();
    String senior_citizen =" ";

        if ((R1.isSelected())) {
            senior_citizen="Yes";

        }
        else if(R2.isSelected()) {
            senior_citizen="No";
        }

        String existin_Account =" ";
        if ((E1.isSelected())){
            existin_Account="Yes";
        } else if (E2.isSelected()) {
            existin_Account="No";

        }

        try{
            if (textpan.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill All the form");

            }
            else {
                con c1=new con();
                String q="Insert Into signupsql2(form_no,religion,category,income,education,occupation,pan_number,senior_citizen,existin_Account) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstm = c1.Conn.prepareStatement(q);
                pstm.setString(1,formno);
                pstm.setString(2,religion);
                pstm.setString(3,category);
                pstm.setString(4,income);
                pstm.setString(5,education);
                pstm.setString(6,occupation);
                pstm.setString(7,pan_number);
                pstm.setString(8,senior_citizen);
                pstm.setString(9,existin_Account);

                pstm.executeUpdate();


                new SignUpsql3(formno);
                setVisible(false);
            }
        } catch (Exception ex) {

            {
                ex.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new SignUpsql2("");

    }
}
