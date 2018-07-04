/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sample;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author abelbeyene
 */
public class Login extends JFrame implements ActionListener{

    JPanel myPanel = new JPanel();
    ImageIcon image = new ImageIcon("RBC.png");


    JLabel logo = new JLabel(image);
    JLabel title = new JLabel("RBC Banking");
    JLabel username = new JLabel("Username:");
    JLabel password = new JLabel("Password: ");
    JTextField nameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton btn = new JButton("Submit");

    Login() {
        initializeGUI();
    }

    private void initializeGUI() {

        this.setTitle("RBC Banking App");
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));

        myPanel.setLayout(new BoxLayout(myPanel,BoxLayout.X_AXIS));

        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial",Font.BOLD,36));
        title.setBorder(BorderFactory.createEmptyBorder(50, 200, 50, 200));
        logo.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameField.setMaximumSize(new Dimension(150,20));
        passwordField.setMaximumSize(new Dimension(150,20));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);

        btn.addActionListener(this);

        this.setBackground(Color.blue);

        this.add(title);
        this.add(logo);
        myPanel.add(username);
        myPanel.add(nameField);
        myPanel.add(Box.createRigidArea(new Dimension(40,0)));
        myPanel.add(password);
        myPanel.add(passwordField);
        this.add(myPanel);
        this.add(Box.createRigidArea(new Dimension(10,30)));
        this.add(btn);

        this.pack();

    }

    public void actionPerformed(ActionEvent ae) {
        String username = this.nameField.getText();
        String password = new String(this.passwordField.getPassword());
        boolean status = false;

        try {
            status = Connect.authenticate(username,password);
        } catch (Exception e) {

        }
        if (status) {
            JOptionPane.showMessageDialog(this, "Login Successful.");
            System.exit(0);
        }
        else {
            JOptionPane.showMessageDialog(this, "Login Unsuccessful.");
            System.exit(1);
        }
    }

    

}
