package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Mini extends JFrame implements ActionListener {

    JButton button;
    String pin;
    Mini(String pin){
        this.pin = pin;

        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(400, 600);
        setLocation(20,20);
        setUndecorated(true);
        setLayout(null);

        JLabel l1 = createLabel(20, 20, 400, 200);

        JLabel l2 = new JLabel("Bank");
        l2.setFont(new Font("System", Font.BOLD, 15));
        l2.setBounds(150, 20, 200, 20);
        add(l2);

        JLabel l3 = createLabel(20, 80, 300, 20);

        JLabel l4 = createLabel(20, 400, 300, 20);

        try{
            Con1 con = new Con1();
            String q = "select * from login where pin = '"+pin+"'";
            ResultSet resultSet = con.statement.executeQuery(q);
            while(resultSet.next()){
                l3.setText("Card Number: "+resultSet.getString("card_number").substring(0,4) + "XXXXXXXX" + resultSet.getString("card_number").substring(12));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        try{
            long balance = 0;
            Con1 con = new Con1();
            ResultSet resultSet = con.statement.executeQuery("select * from bank where pin = '"+pin+"'");
            while (resultSet.next()){
                l1.setText(l1.getText() + "<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+"<br><br><html>");
                if(resultSet.getString("type").equals("Deposit")){
                    balance += Long.parseLong(resultSet.getString("amount"));
                }else{
                    balance -= Long.parseLong(resultSet.getString("amount"));
                }
            }
            l4.setText("Your Total Balance is Rs. "+balance);
        }catch (Exception e){
            e.printStackTrace();
        }

        button = new JButton("BACK");
        button.setBounds(20, 500, 100, 25);
        button.addActionListener(this);
        add(button);

        setVisible(true);
    }


    private JLabel createLabel(int x, int y, int width, int height) {
        JLabel label = new JLabel();
        label.setBounds(x, y, width, height);
        add(label);
        return label;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        new Transaction(pin);
        setVisible(false);
    }

    public static void main(String[] args) {
        new Mini("");
    }
}
