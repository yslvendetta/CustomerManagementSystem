package admin.panel;


import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfname, tfidno, tfage, tfphone, tfemail, tfgender;
    JDateChooser dcdob;
    JLabel lblempId;
    JButton add, back;
    
    AddCustomer() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Customer Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        JLabel labelidno = new JLabel("ID Number");
        labelidno.setBounds(400, 150, 150, 30);
        labelidno.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelidno);
        
        tfidno = new JTextField();
        tfidno.setBounds(600, 150, 150, 30);
        add(tfidno);
        
        JLabel labeldob = new JLabel("Date Of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);
        
        
        JLabel labelgender = new JLabel("Gender");
        labelgender.setBounds(400, 200, 150, 30);
        labelgender.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelgender);
        
        tfgender = new JTextField();
        tfgender.setBounds(600, 200, 150, 30);
        add(tfgender);
        
        JLabel labelage = new JLabel("Age");
        labelage.setBounds(50, 250, 150, 30);
        labelage.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelage);
        
        tfage = new JTextField();
        tfage.setBounds(200, 250, 150, 30);
        add(tfage);
       
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        
        JLabel labelempId = new JLabel("Customer id");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        lblempId = new JLabel("" + number);
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);
        
        
        add = new JButton("Add Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String idno = tfidno.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String gender = tfgender.getText();
            String age = tfage.getText();
            String mobileno = tfphone.getText();
            String email = tfemail.getText(); 
            String empId = lblempId.getText();
            

           

            try {
                Conn conn = new Conn();
                String query = "insert into customer values( '"+name+"', '"+idno+"', '"+dob+"', '"+gender+"', '"+age+"', '"+mobileno+"', '"+email+"',  '"+empId+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddCustomer();
    }
}
