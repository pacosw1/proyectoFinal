import java.io.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Login extends Application {
private String username;
private String typedPassword;
private int attempts;
private int status;
private JFrame frame;

public Login(JFrame frame) {

}

public boolean checkAccount() {

								if (username.equals("mario") && typedPassword.equals("1234")) {
																status = 0;
																return true;
								} else {
																return false;
								}
}

public int loginAttempts(int attempts) {//recursive function to test for login attempts
								attempts = 0;


								JFrame frame = new JFrame("Demo application");
								frame.setSize(300, 150);
								frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

								JPanel panel = new JPanel();
								frame.add(panel);
								panel.setLayout(null);
								JLabel attemptsLabel = new JLabel("Attempts: ");
								attemptsLabel.setBounds(10, 100, 100, 25);
								panel.add(attemptsLabel);

								JLabel userLabel = new JLabel("User");
								userLabel.setBounds(10, 10, 80, 25);
								panel.add(userLabel);

								JTextField userText = new JTextField(20);
								userText.setBounds(100, 10, 160, 25);
								panel.add(userText);

								JLabel passwordLabel = new JLabel("Password");
								passwordLabel.setBounds(10, 40, 80, 25);
								panel.add(passwordLabel);

								JPasswordField passwordText = new JPasswordField(20);
								passwordText.setBounds(100, 40, 160, 25);
								panel.add(passwordText);

								JButton loginButton = new JButton("login");
								loginButton.setBounds(10, 80, 80, 25);
								panel.add(loginButton);

								frame.setVisible(true);

								loginButton.addActionListener(new ActionListener() {
																								public void actionPerformed(ActionEvent e) {
																																username = userText.getText();
																																typedPassword = passwordText.getText();
																																while (!checkAccount()) {
																																								if (checkAccount()) {
																																																frame.dispose();
																																								}
																																								else {
																																																checkAccount();
																																								}
																																}

																								};
																});



return 0;//Not sure this needs a return but it needs one as is
}
public String toString() {
								loginAttempts(0);//Parameter
								return "";
}


}
