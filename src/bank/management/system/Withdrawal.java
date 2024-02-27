package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    JLabel label, l1, l2;
    JTextField textField1;

    JButton b1, b2;

    String pin;

    Withdrawal(String pin){
        super("ATM");

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1350, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        label = new JLabel(i3);
        label.setBounds(0,0,1350,830);
        add(label);


        l1 = createLabel("MAXIMUM WITHDRAWAL IS RS. 10,000", "System", Font.BOLD, 16, 390, 180, 400, 35);
        l1.setForeground(new Color(255,255,255));
        label.add(l1);

        l2 = createLabel("PLEASE ENTER YOUR AMOUNT", "System", Font.BOLD, 16, 390, 220, 400, 35);
        l2.setForeground(new Color(255,255,255));
        label.add(l2);

        textField1 = createTextField( 390, 260, 300, 25);
        label.add(textField1);

        b1 = addButton("WITHDRAW", 620, 362, 120, 35);
        label.add(b1);

        b2 = addButton("BACK", 620, 406, 120, 35);
        label.add(b2);


        setLayout(null);
        setSize(1920, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    private JTextField createTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Raleway", Font.BOLD, 22));
        textField.setBounds(x, y, width, height);
        return textField;
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
            String amount = textField1.getText();
            Date date = new Date();
            if(textField1.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdraw");
            }else{
                Con1 con = new Con1();
                ResultSet resultSet = con.statement.executeQuery("select * from bank where pin = '"+pin+"'");
                int balance = 0;
                while (resultSet.next()){
                    if(resultSet.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }
                if(balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                con.statement.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawal', '"+amount+"')");
                JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Successfully");
                setVisible(false);
                new Transaction(pin);
            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }
}
