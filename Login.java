package jdialogdemo;
import java.awt.*;
<<<<<<< HEAD
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Login extends JDialog {
	private JTextField tfUsername;
	private JPasswordField pfPassword;
	private JLabel lbUsername;
	private JLabel lbPassword;
	private JButton btnLogin;
	private JButton btnCancel;
	private boolean succeeded;
=======
import java.awt.event.ActionEvent;
public class Login extends Application{
private int attempts = 2;//2+initial
private String username;
private String typedPassword;
protected int status;
private JPasswordField password;//Hides password

public Login() {
        setUsername(username);
        setTypedPassword(typedPassword);
        setStatus(status);
}

public boolean checkAccount() {
        if (username.equals("mario") && typedPassword.equals("1234")) {
                status = 0; //manager
                return true;
        } else if (username.equals("paco") && typedPassword.equals("12345")) {
          status = 1; //employee
        }else {
                return false;
        }
}
>>>>>>> 5dfe7d25a4ab27c502dc015521d02c782a594e01

	public boolean authenticate(String username, String password) {
		// hardcoded username and password
		if (username.equals("mario") && password.equals("1234")) {
			return true;
		}
		return false;
	}

	public Login(Frame parent) {
		super(parent, "Login", true);
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();

		cs.fill = GridBagConstraints.HORIZONTAL;

		lbUsername = new JLabel("Usuario: ");
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
				if (TrueInput.authenticate(getUsername(), getPassword())) {//Checks input
					JOptionPane.showMessageDialog(LoginDialog.this,
							"Hello " + getUsername() + "! Welcome!",
							"Login",
							JOptionPane.INFORMATION_MESSAGE);
					succeeded = true;
					dispose();
				} else {
					JOptionPane.showMessageDialog(LoginDialog.this,
							"Password or Username is incorrect",
							"Login",
							JOptionPane.ERROR_MESSAGE);
					// reset username and password
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
