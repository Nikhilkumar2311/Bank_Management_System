package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JLabel label, l1, l2;

    JButton b1;

    String pin;

    BalanceEnquiry(String pin){
        super("ATM");

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1350, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        label = new JLabel(i3);
        label.setBounds(0,0,1350,830);
        add(label);


        l1 = createLabel("YOUR CURRENT BALANCE IS Rs. ", "System", Font.BOLD, 16, 390, 180, 400, 35);
        l1.setForeground(new Color(255,255,255));
        label.add(l1);

        l2 = createLabel("", "System", Font.BOLD, 16, 390, 220, 400, 35);
        l2.setForeground(new Color(255,255,255));
        label.add(l2);

        b1 = addButton("BACK", 620, 406, 120, 35);
        label.add(b1);

        long balance = 0L;
        try{
            Con1 con = new Con1();
            ResultSet resultSet = con.statement.executeQuery("Select * from bank where pin = '"+pin+"'");
            while (resultSet.next()){
                if(resultSet.getString("type").equals("Deposit")){
                    balance += Long.parseLong(resultSet.getString("amount"));
                }else {
                    balance -= Long.parseLong(resultSet.getString("amount"));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        l2.setText("" + balance);



        setLayout(null);
        setSize(1920, 1080);
        setLocation(0, 0);
        setUndecorated(true);
        setVisible(true);
    }


    private JLabel createLabel(String text, String fontName, int fontStyle, int fontSize, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        label.setBounds(x, y, width, height);
        return label;
    }


    private JButton addButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.BLACK);
        button.setBackground(Color.WHITE);
        button.setBounds(x, y, width, height);
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transaction(pin);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
