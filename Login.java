package jdialogdemo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class Login extends JDialog {
	private JTextField tfUsername;
	private JPasswordField pfPassword;
	private JLabel lbUsername;
	private JLabel lbPassword;
	private JButton btnLogin;
	private JButton btnCancel;
	private boolean succeeded;
	private int attempts = 2;

public boolean checkAccount(String username, String password) {
        if (username.equals("mario") && password.equals("1234")) {
                checkStatus(0); //Manager
                return true;
        } else if (getUsername().equals("paco") && getPassword().equals("12345")) {
          			checkStatus(1);//Employee
        }
				return false;

}
public String checkStatus(int status){
				if(status == 0)
				return "Manager";
				else
				return "Employee";
}

	public Login(Frame parent) {
		super(parent, "Login", true);
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();

		cs.fill = GridBagConstraints.HORIZONTAL;
		lbUsername = new JLabel("User: ");//User Label
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		panel.add(lbUsername, cs);

		tfUsername = new JTextField(20);//User Text Field
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		panel.add(tfUsername, cs);

		lbPassword = new JLabel("Password: ");//Password Label
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		panel.add(lbPassword, cs);

		pfPassword = new JPasswordField(20);//Password Text Field
		cs.gridx = 1;
		cs.gridy = 1;
		cs.gridwidth = 2;
		panel.add(pfPassword, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {//Starts event
			public void actionPerformed(ActionEvent e) {//Obtains input
				if (checkAccount(getUsername(), getPassword())){//Verifies input
					JOptionPane.showMessageDialog(Login.this,
							"Hello " + getUsername() + "! Welcome!",
							"Login",
							JOptionPane.INFORMATION_MESSAGE);
					succeeded = true;
					dispose();
				} else{
					JOptionPane.showMessageDialog(Login.this,
							"Username or Password Incorrect\nAttempts: " + (attempts + 1),
							"Login",
							JOptionPane.ERROR_MESSAGE);
					//Resets username and password
					tfUsername.setText("");
					pfPassword.setText("");
					if(attempts == 0){
						succeeded = false;
						dispose();
					}
					attempts--;
				}
			}
		});
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JPanel bp = new JPanel();
		bp.add(btnLogin);
		bp.add(btnCancel);

		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().add(bp, BorderLayout.PAGE_END);

		pack();
		setResizable(false);
		setLocationRelativeTo(parent);
	}
		public String getUsername() {
			return tfUsername.getText().trim();
		}

		public String getPassword() {
			return new String(pfPassword.getPassword());
		}
		public String getStatus(){
			return checkStatus();
		}
		public boolean isSucceeded() {
			return succeeded;
		}
}
