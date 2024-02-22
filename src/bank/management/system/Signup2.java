package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {

    JTextField textPan, textAadhar;
    JComboBox comboBox;
    String formno;

    JButton button;

    JRadioButton r1, r2, e1, e2;

    Signup2(String first){
        super("APPLICATION FORM");


        addScaledImageIcon("icon/bank.png", 150, 5, 100, 100);

        this.formno = formno;

        createLabel("Form No :- " + formno, "Raleway", Font.BOLD, 16, 700, 10, 180, 30);
        createLabel("Page2 :-", "Raleway", Font.BOLD, 20, 300, 30, 600, 40);
        createLabel("Additional Details :-", "Raleway", Font.BOLD, 20, 300, 60, 600, 40);

        createLabel("Religion :", "Raleway", Font.BOLD, 16, 100, 120, 100, 30);

        // Dropdown Which contains all the religion
        String[] religion = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        JComboBox religionComboBox = createComboBox(religion, 350, 120, 320, 30);
        add(religionComboBox);


        createLabel("Category :", "Raleway", Font.BOLD, 16, 100, 170, 100, 30);

        String[] category = {"GENERAL", "OBC", "SC", "ST", "Other"};
        JComboBox categoryComboBox = createComboBox(category, 350, 170, 320, 30);
        add(categoryComboBox);


        createLabel("Income :", "Raleway", Font.BOLD, 16, 100, 220, 100, 30);

        String[] income = {"None", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000", "Above 10,00,000"};
        JComboBox incomeComboBox = createComboBox(income, 350, 220, 320, 30);
        add(incomeComboBox);


        createLabel("Education :", "Raleway", Font.BOLD, 16, 100, 270, 100, 30);

        String[] education = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        JComboBox educationComboBox = createComboBox(education, 350, 270, 320, 30);
        add(educationComboBox);


        createLabel("Occupation :", "Raleway", Font.BOLD, 16, 100, 330, 100, 30);

        String[] occupation = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
        JComboBox occupationComboBox = createComboBox(occupation, 350, 330, 320, 30);
        add(occupationComboBox);


        createLabel("PAN No. :", "Raleway", Font.BOLD, 16, 100, 380, 100, 30);

        textPan = createTextField( 350, 380, 320, 30);


        createLabel("Aadhar No. :", "Raleway", Font.BOLD, 16, 100, 430, 100, 30);

        textAadhar = createTextField( 350, 430, 320, 30);


        createLabel("SeniorCitizen :", "Raleway", Font.BOLD, 16, 100, 480, 180, 30);

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(new Color(252, 208, 76));
        r1.setBounds(350, 480, 100, 30);
        add(r1);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(new Color(252, 208, 76));
        r2.setBounds(460, 480, 100, 30);
        add(r2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);


        createLabel("Existing Account :", "Raleway", Font.BOLD, 16, 100, 530, 180, 30);

        e1 = new JRadioButton("Yes");
        e1.setFont(new Font("Raleway", Font.BOLD, 14));
        e1.setBackground(new Color(252, 208, 76));
        e1.setBounds(350, 530, 100, 30);
        add(e1);

        e2 = new JRadioButton("No");
        e2.setFont(new Font("Raleway", Font.BOLD, 14));
        e2.setBackground(new Color(252, 208, 76));
        e2.setBounds(460, 530, 100, 30);
        add(e2);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(e1);
        buttonGroup1.add(e2);


        button = new JButton("Next");
        button.setFont(new Font("Raleway", Font.BOLD, 14));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.addActionListener(this);
        button.setBounds(620, 580, 80, 30);
        add(button);


        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);
        getContentPane().setBackground(new Color(252, 208, 76));
        setVisible(true);
    }

    private JLabel createLabel(String text, String fontName, int fontStyle, int fontSize, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        label.setBounds(x, y, width, height);
        add(label);
        return label;
    }


    private JTextField createTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Raleway", Font.BOLD, 16));
        textField.setBounds(x, y, width, height);
        add(textField);
        return textField;
    }

    public static JComboBox createComboBox(String[] values, int x, int y, int width, int height) {
        JComboBox comboBox = new JComboBox(values);
        comboBox.setBackground(new Color(236, 232, 232));
        comboBox.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox.setBounds(x, y, width, height);
        return comboBox;
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
        new Signup2("");
    }
}