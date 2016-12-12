package algorhythm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginUIv2 extends JFrame{
    
    private JPanel thePanel = null;
    JPanel[] cellNumbers = null;
    JButton cancelButton = null;
    JButton submitButton = null;
    JLabel usernameLabel = null;
    JLabel passwordLabel = null;
    JTextField usernameField = null;
    JPasswordField passwordField = null;
    
    
    public LoginUIv2(){
        initCustomComponents();
    }
    
    public void initCustomComponents(){
        this.setSize(400, 300);
        this.setTitle("My Window");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        // A JPanel for the UI components
        thePanel = new JPanel();
        thePanel.setLayout(new GridLayout(4,4));
        
        // Create cell numbers for the GridLayout
        cellNumbers = new JPanel[16];
        for(int i = 0; i < 16; i++){
            JPanel nextPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
            cellNumbers[i] = nextPanel;
            thePanel.add(nextPanel);
        }
        
        // Construct the UI components
        cancelButton = new JButton("Cancel");
        cancelButton.setSize(30,40);
        
        // Add the ActionListener to the Cancel button
        cancelButton.addActionListener(new CancelListener());
        
        submitButton = new JButton("Submit");
        submitButton.setSize(30,40);
        
        // Add the ActionListener to the Submit button
        submitButton.addActionListener(new SubmitListener());
        
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        
        usernameField = new JTextField("", 20);
        // usernameField.setEnabled(true);
        // usernameField.setEditable(true);
        passwordField = new JPasswordField("", 20);
        passwordField.setEnabled(true);
        passwordField.setEditable(true);

        // Assembly
        cellNumbers[4].add(usernameLabel);
        cellNumbers[5].add(usernameField);
        cellNumbers[8].add(passwordLabel);
        cellNumbers[9].add(passwordField);
        cellNumbers[14].add(cancelButton);
        cellNumbers[15].add(submitButton);
        this.add(thePanel);      
    }
    
    // This inner class listens for the button press
    class CancelListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
                JOptionPane.showMessageDialog(null, "Cancel button was clicked!");
                System.exit(0);
        }
    }
    
        // This inner class listens for the button press
    class SubmitListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
                JOptionPane.showMessageDialog(null, "Submit button was clicked!");
                System.exit(0);
        }
    }

    
}
