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
    JRadioButton r1, r2, r3, m1, m2;
    JDateChooser dateChooser;
    Random rand = new Random();
    long first4 = (rand.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(first4);

    Signup() {
        super("APPLICATION FORM");

        addScaledImageIcon("icon/bank.png", 25, 10, 100, 100);
        createLabel("Application Form No." + first, "Raleway", Font.BOLD, 30, 160, 20, 600, 40);
        createLabel("Page1 :-", "Raleway", Font.BOLD, 22, 330, 60, 600, 30);
        createLabel("Personal Details", "Raleway", Font.BOLD, 22, 290, 80, 600, 30);

        textName = createTextField("Name :", 100, 140, 400, 30);
        textFname = createTextField("Father's Name :", 100, 190, 400, 30);

        createLabel("Date Of Birth :", "Raleway", Font.BOLD, 20, 100, 290, 200, 30);
        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 290, 400, 30);
        add(dateChooser);

        createLabel("Gender :", "Raleway", Font.BOLD, 20, 100, 240, 200, 30);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(new Color(222, 255, 228));
        r1.setBounds(300, 240, 60, 30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(new Color(222, 255, 228));
        r2.setBounds(420, 240, 90, 30);
        add(r2);

        r3 = new JRadioButton("Other");
        r3.setBounds(550, 240, 150, 30);
        r3.setBackground(new Color(222, 255, 228));
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        add(r3);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);

        textEmail = createTextField("Email :", 100, 340, 400, 30);

        createLabel("Marital Status :", "Raleway", Font.BOLD, 20, 100, 390, 200, 30);

        m1 = new JRadioButton("Married");
        m1.setBounds(300, 390, 100, 30);
        m1.setBackground(new Color(222, 255, 228));
        m1.setFont(new Font("Raleway", Font.BOLD, 14));
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setBounds(455, 390, 100, 30);
        m2.setBackground(new Color(222, 255, 228));
        m2.setFont(new Font("Raleway", Font.BOLD, 14));
        add(m2);


        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(m1);
        buttonGroup2.add(m2);

        textAdd = createTextField("Address :", 100, 440, 400, 30);
        textCity = createTextField("City :", 100, 490, 400, 30);
        textState = createTextField("State :", 100, 540, 400, 30);
        textPin = createTextField("PIN Code :", 100, 590, 400, 30);

        button = new JButton("Next");
        button.setFont(new Font("Raleway", Font.BOLD, 14));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.addActionListener(this);
        button.setBounds(620, 630, 80, 30);
        add(button);

        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);
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
        String formno = first;
        String name = textName.getText();
        String fname = textFname.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(r1.isSelected()){
            gender = "Male";
        } else if (r2.isSelected()) {
            gender = "Female";
        } else if (r3.isSelected()) {
            gender = "Other";
        }
        String email = textEmail.getText();
        String marital = null;
        if(m1.isSelected()){
            marital = "Married";
        } else if (m2.isSelected()) {
            marital = "Unmarried";
        }

        String address = textAdd.getText();
        String city = textCity.getText();
        String pincode = textPin.getText();
        String state = textState.getText();

        try{
            if(textName.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the Fields");
            }else{
                Con1 con = new Con1();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+pincode+"', '"+state+"')";
                con.statement.executeUpdate(query);
                new Signup2(first);
                setVisible(false);
            }

        } catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Signup();
    }
}
