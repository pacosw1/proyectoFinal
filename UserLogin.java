package jdialogdemo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class UserLogin extends Application {//Tiene que estar en application
	public static void main(String[] args) {
		final JFrame frame = new JFrame("Start Session");
		final JButton btnLogin = new JButton("Click here to start session");

		btnLogin.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						Login loginDlg = new LoginDialog(frame);
						loginDlg.setVisible(true);
						// if login is successfull
						if(loginDlg.isSucceeded()){
							btnLogin.setText(loginDlg.getUsername());

						}
					}
				});

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 100);
		frame.setLayout(new FlowLayout());
		frame.getContentPane().add(btnLogin);
		frame.setVisible(true);
	}
}
