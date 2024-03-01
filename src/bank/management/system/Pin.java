package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {

    JLabel label, l1, l2, l3;
    JPasswordField p, p1, p2;

    JButton b1, b2;

    String pin;
    Pin(String pin){

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1350, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        label = new JLabel(i3);
        label.setBounds(0,0,1350,830);
        add(label);


        l1 = createLabel("CHANGE YOUR PIN", "System", Font.BOLD, 16, 360, 180, 400, 35);
        l1.setForeground(new Color(255,255,255));
        label.add(l1);

        l2 = createLabel("NEW PIN: ", "System", Font.BOLD, 16, 360, 220, 150, 35);
        l2.setForeground(new Color(255,255,255));
        label.add(l2);

        p1 = createPasswordField( 550, 220, 180, 25);
        label.add(p1);

        l3 = createLabel("Re-Enter NEW PIN: ", "System", Font.BOLD, 16, 360, 250, 400, 35);
        l3.setForeground(new Color(255,255,255));
        label.add(l3);

        p2 = createPasswordField( 550, 255, 180, 25);
        label.add(p2);

        b1 = addButton("CHANGE", 630, 362, 100, 35);
        label.add(b1);

        b2 = addButton("BACK", 630, 406, 100, 35);
        label.add(b2);


        setLayout(null);
        setSize(1920, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    private JPasswordField createPasswordField(int x, int y, int width, int height) {
        p = new JPasswordField();
        p.setFont(new Font("Raleway", Font.BOLD, 22));
        p.setBounds(x, y, width, height);
        return p;
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

            String pin1 = p1.getText();
            String pin2 = p2.getText();

            if(!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null, "Entered PINs doesn't match");
                return;
            }
            if(e.getSource() == b1){
                if(p1.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Fill all the fields");
                    return;
                }
                if(p2.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Fill all the fields");
                    return;
                }

                Con1 con = new Con1();
                String q1 = "update bank set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q2 = "update login set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q3 = "update signup3 set pin = '"+pin1+"' where pin = '"+pin+"'";

                con.statement.executeUpdate(q1);
                con.statement.executeUpdate(q2);
                con.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transaction(pin);
            } else if (e.getSource() == b2) {
                new Transaction(pin);
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Pin("");
    }
}
