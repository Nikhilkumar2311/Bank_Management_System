package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {

    JLabel label, l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;

    Transaction(String pin){
        super("Main");
        this.pin = pin;


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1350, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        label = new JLabel(i3);
        label.setBounds(0,0,1350,830);
        add(label);

        l1 = createLabel("Please Select Your Transaction", "System", Font.BOLD, 24, 370, 180, 400, 35);
        l1.setForeground(new Color(255,255,255));
        label.add(l1);

        b1 = addButton("DEPOSIT", 360, 272, 120, 32);
        label.add(b1);

        b2 = addButton("CASH WITHDRAW", 560, 272, 180, 32);
        label.add(b2);

        b3 = addButton("FAST CASH", 360, 318, 120, 32);
        label.add(b3);

        b4 = addButton("MINI STATEMENT", 560, 318, 180, 32);
        label.add(b4);

        b5 = addButton("PIN CHANGE", 360, 364, 120, 32);
        label.add(b5);

        b6 = addButton("BALANCE ENQUIRY", 560, 364, 180, 32);
        label.add(b6);

        b7 = addButton("EXIT", 560, 406, 180, 32);
        label.add(b7);


        setLayout(null);
        setSize(1920, 1080);
        setLocation(0, 0);
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
        try{
            if(e.getSource() == b1){
                new Deposit(pin);
                setVisible(false);
            } else if (e.getSource() == b2) {
                new Withdrawal(pin);
                setVisible(false);
            } else if (e.getSource() == b3) {
                new FastCash(pin);
                setVisible(false);
            } else if (e.getSource() == b6) {
                new BalanceEnquiry(pin);
                setVisible(false);
            } else if (e.getSource() == b7) {
                System.exit(0);
            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Transaction("");
    }
}
