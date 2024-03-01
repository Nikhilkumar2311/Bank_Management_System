package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {

    JTextField textPan, textAadhar;
    String formno;
    JComboBox religionComboBox, categoryComboBox, incomeComboBox, educationComboBox, occupationComboBox;

    JButton button;

    JRadioButton r1, r2, e1, e2;

    Signup2(String formno){
        super("APPLICATION FORM");


        addScaledImageIcon("icon/bank.png", 150, 5, 100, 100);

        this.formno = formno;


        createLabel("Page2 :-", "Raleway", Font.BOLD, 20, 300, 30, 600, 40);
        createLabel("Additional Details", "Raleway", Font.BOLD, 20, 300, 60, 600, 40);

        createLabel("Religion :", "Raleway", Font.BOLD, 16, 100, 120, 100, 30);

        // Dropdown Which contains all the religion
        String[] religion = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionComboBox = createComboBox(religion, 350, 120, 320, 30);


        createLabel("Category :", "Raleway", Font.BOLD, 16, 100, 170, 100, 30);

        String[] category = {"GENERAL", "OBC", "SC", "ST", "Other"};
        categoryComboBox = createComboBox(category, 350, 170, 320, 30);


        createLabel("Income :", "Raleway", Font.BOLD, 16, 100, 220, 100, 30);

        String[] income = {"None", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000", "Above 10,00,000"};
        incomeComboBox = createComboBox(income, 350, 220, 320, 30);


        createLabel("Education :", "Raleway", Font.BOLD, 16, 100, 270, 100, 30);

        String[] education = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        educationComboBox = createComboBox(education, 350, 270, 320, 30);


        createLabel("Occupation :", "Raleway", Font.BOLD, 16, 100, 330, 100, 30);

        String[] occupation = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
        occupationComboBox = createComboBox(occupation, 350, 330, 320, 30);


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

        createLabel("Form No :- " + formno, "Raleway", Font.BOLD, 14, 700, 10, 180, 30);


        button = new JButton("Next");
        button.setFont(new Font("Raleway", Font.BOLD, 14));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.addActionListener(this);
        button.setBounds(620, 560, 80, 30);
        add(button);


        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);
        setUndecorated(true);
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

    public JComboBox createComboBox(String[] values, int x, int y, int width, int height) {
        JComboBox comboBox = new JComboBox(values);
        comboBox.setBackground(new Color(236, 232, 232));
        comboBox.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox.setBounds(x, y, width, height);
        add(comboBox);
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
        String rel = (String) religionComboBox.getSelectedItem();
        String cate = (String) categoryComboBox.getSelectedItem();
        String inc = (String) incomeComboBox.getSelectedItem();
        String edu = (String) educationComboBox.getSelectedItem();
        String occ = (String) occupationComboBox.getSelectedItem();

        String pan = textPan.getText();
        String aadhar = textAadhar.getText();

        String scitizen = null;
        if((r1.isSelected())){
            scitizen = "Yes";
        } else if (r2.isSelected()) {
            scitizen = "No";
        }

        String eaccount = null;
        if((e1.isSelected())){
            eaccount = "Yes";
        } else if (e2.isSelected()) {
            eaccount = "No";
        }

        try{
            if (textPan.getText().isEmpty() || textAadhar.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            }else{
                Con1 con = new Con1();
                String query = "insert into signup2 values('"+formno+"', '"+rel+"', '"+cate+"', '"+inc+"', '"+edu+"', '"+occ+"', '"+pan+"', '"+aadhar+"', '"+scitizen+"', '"+eaccount+"')";
                con.statement.executeUpdate(query);
                new Signup3(formno);
                setVisible(false);
            }
        } catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Signup2("");
    }
}
