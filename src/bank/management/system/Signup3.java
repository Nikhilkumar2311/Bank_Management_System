package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup3 extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    String formno;
    JButton button1, button2;
    JCheckBox c1,c2,c3,c4,c5,c6;
    Signup3(String formno){
        super("APPLICATION FORM");

        addScaledImageIcon("icon/bank.png", 150, 5, 100, 100);

        this.formno = formno;

        createLabel("Page3 :-", "Raleway", Font.BOLD, 20, 280, 40, 400, 40);
        createLabel("Account Details", "Raleway", Font.BOLD, 20, 280, 70, 400, 40);

        createLabel("Account Type :", "Raleway", Font.BOLD, 16, 100, 140, 200, 30);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(new Color(215, 252, 252));
        r1.setBounds(100, 180, 150, 30);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(new Color(215, 252, 252));
        r2.setBounds(350, 180, 300, 30);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(new Color(215, 252, 252));
        r3.setBounds(100, 220, 250, 30);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(new Color(215, 252, 252));
        r4.setBounds(350, 220, 300, 30);
        add(r4);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);
        buttonGroup.add(r4);

        createLabel("Card No. :", "Raleway", Font.BOLD, 16, 100, 270, 200, 30);
        createLabel("(Your 16-Digit Card No.)", "Raleway", Font.BOLD, 12, 100, 300, 200, 20);

        createLabel("XXXX-XXXX-XXXX-2580", "Raleway", Font.BOLD, 16, 330, 270, 250, 30);
        createLabel("(It would appear on the atm card/cheque Book and Statements)", "Raleway", Font.BOLD, 12, 330, 300, 500, 20);

        createLabel("PIN :", "Raleway", Font.BOLD, 16, 100, 340, 200, 30);
        createLabel("(4 Digit PIN)", "Raleway", Font.BOLD, 12, 100, 370, 200, 20);

        createLabel("XXXX", "Raleway", Font.BOLD, 16, 330, 340, 200, 30);

        createLabel("Services Required :", "Raleway", Font.BOLD, 16, 100, 400, 200, 30);

        c1 = createCheckBox("ATM CARD",100, 450, 200, 30);
        c2 = createCheckBox("Internet Banking",350, 450, 200, 30);
        c3 = createCheckBox("Mobile Banking",100, 500, 200, 30);
        c4 = createCheckBox("Email Alerts",350, 500, 200, 30);
        c5 = createCheckBox("Cheque Book",100, 550, 200, 30);
        c6 = createCheckBox("E-Statement",350, 550, 200, 30);

        JCheckBox c7 = new JCheckBox("I here by declares that the above entered details correct to the best of my knowledge.",true);
        c7.setBackground(new Color(215, 252, 252));
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 600, 600, 20);
        add(c7);

        createLabel("Form No :- " + formno, "Raleway", Font.BOLD, 16, 700, 10, 180, 30);

        addButton("Submit", 250, 720, 100, 30, 1);
        addButton("Cancel", 420, 720, 100, 30, 1);


        setLayout(null);
        setSize(850, 800);
        setLocation(400, 20);
        getContentPane().setBackground(new Color(215, 252, 252));
        setVisible(true);
    }


    private JLabel createLabel(String text, String fontName, int fontStyle, int fontSize, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        label.setBounds(x, y, width, height);
        add(label);
        return label;
    }

    public JCheckBox createCheckBox(String label, int x, int y, int width, int height) {
        JCheckBox checkBox = new JCheckBox(label);
        checkBox.setBackground(new Color(215, 252, 252));
        checkBox.setFont(new Font("Raleway", Font.BOLD, 14));
        checkBox.setBounds(x, y, width, height);
        add(checkBox);
        return checkBox;
    }


    private void addButton(String text, int x, int y, int width, int height, int buttonNumber) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setBounds(x, y, width, height);
        //button.addActionListener(this);
        add(button);

        switch (buttonNumber) {
            case 1:
                button1 = button;
                break;
            case 2:
                button2 = button;
                break;
            default:
                throw new IllegalArgumentException("Invalid button number");
        }
    }

    private void addScaledImageIcon(String imagePath, int x, int y, int width, int height) {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource(imagePath));
        Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel label = new JLabel(scaledIcon);
        label.setBounds(x, y, width, height);
        add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new Signup3("");
    }
}
