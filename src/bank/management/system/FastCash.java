package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JLabel label, l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    FastCash(String pin){
        this.pin = pin;


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1350, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        label = new JLabel(i3);
        label.setBounds(0,0,1350,830);
        add(label);

        l1 = createLabel("SELECT WITHDRAWAL AMOUNT", "System", Font.BOLD, 24, 360, 180, 400, 35);
        l1.setForeground(new Color(255,255,255));
        label.add(l1);

        b1 = addButton("Rs. 100", 360, 272, 120, 32);
        label.add(b1);

        b2 = addButton("Rs. 500", 620, 272, 120, 32);
        label.add(b2);

        b3 = addButton("Rs. 1000", 360, 318, 120, 32);
        label.add(b3);

        b4 = addButton("Rs. 2000", 620, 318, 120, 32);
        label.add(b4);

        b5 = addButton("Rs. 5000", 360, 364, 120, 32);
        label.add(b5);

        b6 = addButton("Rs. 10000", 620, 364, 120, 32);
        label.add(b6);

        b7 = addButton("BACK", 620, 406, 120, 32);
        label.add(b7);


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
        if(e.getSource() == b7){
            setVisible(false);
            new Transaction(pin);
        }else {
            String amount = ((JButton)e.getSource()).getText().substring(4);
            Con1 con = new Con1();
            Date date = new Date();
            try{
                ResultSet resultSet = con.statement.executeQuery("select * from bank where pin = '"+pin+"'");
                long balance = 0;
                while (resultSet.next()){
                    if(resultSet.getString("type").equals("Deposit")){
                        balance += Long.parseLong(resultSet.getString("amount"));
                    }else{
                        balance -= Long.parseLong(resultSet.getString("amount"));
                    }
                }

                if (e.getSource() != b7 && balance < Long.parseLong(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                con.statement.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawal', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");

            }catch (Exception E){
                E.printStackTrace();
            }
            setVisible(false);
            new Transaction(pin);
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
