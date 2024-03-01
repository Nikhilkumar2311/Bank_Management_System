package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField textField2;
    JPasswordField passwordField3;
    JButton button1, button2, button3;
    Login(){
        super("Bank Management System");

        addScaledImageIcon("icon/bank.png", 350, 10, 100, 100);
        addScaledImageIcon("icon/card.png", 630, 350, 100, 100);

        createLabel("WELCOME TO ATM", "AvantGarde", Font.BOLD, 38, Color.WHITE, 230, 125, 450, 40);
        createLabel("Card No:", "Ralway", Font.BOLD, 28, Color.WHITE, 150, 190, 375, 30);

        textField2 = new JTextField(15);
        textField2.setBounds(325, 190, 230, 30);
        textField2.setFont(new Font("Arial", Font.BOLD, 14));
        add(textField2);

        createLabel("PIN:", "Ralway", Font.BOLD, 28, Color.WHITE, 150, 250, 375, 30);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(325, 250, 230, 30);
        passwordField3.setFont(new Font("Arial", Font.BOLD, 14));
        add(passwordField3);


        button1 = addButton("SIGN IN", 300, 300, 100, 30);
        button2 = addButton("CLEAR", 430, 300, 100, 30);
        button3 = addButton("SIGN UP", 300, 350, 230, 30);

        addScaledImageIcon("icon/backbg.png", 0, 0, 850, 480);

        setLayout(null);
        setSize(850, 480);
        setLocation(250, 100);
        setUndecorated(true);
        setVisible(true);
    }

    private void addScaledImageIcon(String imagePath, int x, int y, int width, int height) {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource(imagePath));
        Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel label = new JLabel(scaledIcon);
        label.setBounds(x, y, width, height);
        add(label);
    }

    private JLabel createLabel(String text, String fontName, int fontStyle, int fontSize, Color color, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        label.setForeground(color);
        label.setBounds(x, y, width, height);
        add(label);
        return label;
    }

    private JButton addButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setBounds(x, y, width, height);
        button.addActionListener(this);
        add(button);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if (e.getSource() == button1){
                Con1 con = new Con1();
                String cardno = textField2.getText();
                String pin = passwordField3.getText();
                String query = "Select * from login where card_number = '"+cardno+"' and pin = '"+pin+"'";
                ResultSet resultSet = con.statement.executeQuery(query);
                if (resultSet.next()){
                    setVisible(false);
                    new Transaction(pin);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                }
            }
            else if (e.getSource() == button2) {
                textField2.setText("");
                passwordField3.setText("");
            }
            else if (e.getSource() == button3) {
                new Signup();
                setVisible(false);
            }

        } catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
