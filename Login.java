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
	private int attempts = 3;
	protected int status;
	/*private String username;
	private String typedPassword;
	private JPasswordField password;//Hides password*/

public boolean checkAccount(String username, String password) {
        if (username.equals("mario") && password.equals("1234")) {
                status = 0; //manager
                return true;
        } else if (getUsername().equals("paco") && getPassword().equals("12345")) {
          			status = 1; //employee
        }
				return false;

}

	public Login(Frame parent) {
		super(parent, "Login", true);
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();

		cs.fill = GridBagConstraints.HORIZONTAL;
		do{
		lbUsername = new JLabel("User: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		panel.add(lbUsername, cs);

		tfUsername = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		panel.add(tfUsername, cs);

		lbPassword = new JLabel("Password: ");
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		panel.add(lbPassword, cs);

		pfPassword = new JPasswordField(20);
		cs.gridx = 1;
		cs.gridy = 1;
		cs.gridwidth = 2;
		panel.add(pfPassword, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkAccount(getUsername(), getPassword())){//Checks input
					JOptionPane.showMessageDialog(Login.this,
							"Hello " + getUsername() + "! Welcome!",
							"Login",
							JOptionPane.INFORMATION_MESSAGE);
					succeeded = true;
					dispose();
				} else{
					JOptionPane.showMessageDialog(Login.this,
							"Username or Password Incorrect\nAttempts: " + attempts,
							"Login",
							JOptionPane.ERROR_MESSAGE);
					// reset username and password
					attempts--;
					tfUsername.setText("");
					pfPassword.setText("");
					succeeded = false;

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
		}while(attempts > 0);

		JOptionPane.showMessageDialog(Login.this,
				"You ran out of Attempts!",
				"Try again next time!",
				JOptionPane.ERROR_MESSAGE);
		succeeded = false;

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

		public boolean isSucceeded() {
			return succeeded;
		}
}
