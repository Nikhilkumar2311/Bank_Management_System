package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {
    JTextField textName, textFname, textEmail, textAdd, textCity, textPin, textState;
    JButton button;
    JRadioButton r1, r2, m1, m2, m3;
    JDateChooser dateChooser;
    Random rand = new Random();
    long first4 = (rand.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(first4);

    Signup() {
        super("APPLICATION FORM");

        addScaledImageIcon("icon/bank.png", 25, 10, 100, 100);
        createLabel("Application Form No." + first, "Raleway", Font.BOLD, 38, 160, 20, 600, 40);
        createLabel("Page1:", "Raleway", Font.BOLD, 22, 330, 70, 600, 30);
        createLabel("Personal Details:", "Raleway", Font.BOLD, 22, 290, 90, 600, 30);

        textName = createTextField("Name :", 100, 150, 400, 30);
        textFname = createTextField("Father's Name :", 100, 200, 400, 30);

        createLabel("Date Of Birth :", "Raleway", Font.BOLD, 20, 100, 300, 200, 30);
        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 300, 400, 30);
        add(dateChooser);

        createLabel("Gender :", "Raleway", Font.BOLD, 20, 100, 250, 200, 30);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(new Color(222, 255, 228));
        r1.setBounds(300, 250, 60, 30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(new Color(222, 255, 228));
        r2.setBounds(450, 250, 90, 30);
        add(r2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        textEmail = createTextField("Email :", 100, 350, 400, 30);

        createLabel("Marital Status :", "Raleway", Font.BOLD, 20, 100, 400, 200, 30);

        m1 = new JRadioButton("Married");
        m1.setBounds(300, 400, 100, 30);
        m1.setBackground(new Color(222, 255, 228));
        m1.setFont(new Font("Raleway", Font.BOLD, 14));
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setBounds(455, 400, 100, 30);
        m2.setBackground(new Color(222, 255, 228));
        m2.setFont(new Font("Raleway", Font.BOLD, 14));
        add(m2);

        m3 = new JRadioButton("Other");
        m3.setBounds(635, 400, 100, 30);
        m3.setBackground(new Color(222, 255, 228));
        m3.setFont(new Font("Raleway", Font.BOLD, 14));
        add(m3);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(m1);
        buttonGroup2.add(m2);
        buttonGroup2.add(m3);

        textAdd = createTextField("Address :", 100, 450, 400, 30);
        textCity = createTextField("City :", 100, 500, 400, 30);
        textState = createTextField("State :", 100, 550, 400, 30);
        textPin = createTextField("PIN Code :", 100, 600, 400, 30);

        button = new JButton("Next");
        button.setFont(new Font("Raleway", Font.BOLD, 14));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.addActionListener(this);
        button.setBounds(620, 650, 80, 30);
        add(button);

        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);
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

    private JLabel createLabel(String text, String fontName, int fontStyle, int fontSize, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        label.setBounds(x, y, width, height);
        add(label);
        return label;
    }

    private JTextField createTextField(String labelText, int x, int y, int width, int height) {
        createLabel(labelText, "Raleway", Font.BOLD, 20, x, y, 200, height);
        JTextField textField = new JTextField();
        textField.setFont(new Font("Raleway", Font.BOLD, 14));
        textField.setBounds(300, y, 400, height);
        add(textField);
        return textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO
    }

    public static void main(String[] args) {
        new Signup();
    }
}
