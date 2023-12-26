package isp.lab9.exercise1.ui;

import javax.security.auth.login.LoginException;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mihai.hulea
 * @author radu.miron
 */
public class LoginJFrame extends JFrame {
    public static final Map<String, String> accounts = new HashMap<>();

    public LoginJFrame() {
        //initialize accounts
        initAccounts();

        //setup the window
        this.setTitle("Login");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(200, 200, 300, 200);

        //create and add components
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 20, 100, 20);
        this.add(userLabel);

        JTextField userInputField = new JTextField();
        userInputField.setBounds(160, 20, 100, 20);
        this.add(userInputField);

        JLabel pwdLabel = new JLabel("Password:");
        pwdLabel.setBounds(20, 60, 100, 20);
        this.add(pwdLabel);

        JPasswordField pwdInputField = new JPasswordField();
        pwdInputField.setBounds(160, 60, 100, 20);
        this.add(pwdInputField);

        JButton button = new JButton("Login");
        button.setBounds(20, 100, 240, 20);
        this.add(button);

        // add event listener to button
        button.addActionListener(e -> verifyCredentials(userInputField, pwdInputField));

        //display
        this.setVisible(true);
    }

    private void verifyCredentials(JTextField userInputField, JPasswordField pwdInputField) {

        LoginJFrame.this.setVisible(false);

        for(String i : accounts.keySet()){
            if(accounts.containsKey(userInputField.getText()) && accounts.containsValue(pwdInputField.getText())){
                JDialog f = new JDialog();
                JDialog d = new JDialog(f, "Successful login");
                JLabel l = new JLabel("You are logged in");

                d.add(l);

                // setize of dialog
                d.setBounds(200,400, 180, 100);

                // set visibility of dialog
                d.setVisible(true);
                LoginJFrame.this.setVisible(false);

                new StockMarketJFrame();
            }
            else{
                JDialog f = new JDialog();

                JDialog d = new JDialog(f, "Error");
                JLabel l = new JLabel("You don't have an account");

                d.add(l);

                // setsize of dialog
                d.setBounds(200,400, 180, 100);

                // set visibility of dialog
                d.setVisible(true);
                LoginJFrame.this.setVisible(true);
            }
        }
        // todo: implement the login by checking the credentials
        //  show an error message (in a JDialog) in case of bad credentials
    }

    private void initAccounts() {
        accounts.put("paul", "1234");
    }
}
