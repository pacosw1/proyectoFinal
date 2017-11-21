package jdialogdemo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class UserLogin extends Application{
	public static void main(String[] args) {
		final JFrame frame = new JFrame("Start Session");
		final JButton btnLogin = new JButton("Click here to start session");

		btnLogin.addActionListener(
				new ActionListener(){//Starts Event
					public void actionPerformed(ActionEvent e) {
						Login loginDlg = new Login(frame);
						loginDlg.setVisible(true);
						// if login is successfull
						for(int i = 0; i < 2; i++){
							if(loginDlg.isSucceeded() == true){
								btnLogin.setText("Welcome: " + loginDlg.getStatus() + " " + loginDlg.getUsername());
							}
							else if(loginDlg.isSucceeded() == false){
								btnLogin.setText("You ran out of attempts!");
							}
						}
					}
				});

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 100);
		frame.setLayout(new FlowLayout());
		frame.getContentPane().add(btnLogin);
		frame.setVisible(true);

		if(loginDlg.getStatus() == 0) {
						//admin actions (access reports etc...)
						managerOptions();
						TransactionReport report = new TransactionReport(new CurrentDate(),"test","C:\\Users\\Mario\\Documents\\GitHub\\proyectoFinal\\data\\");
						System.out.println(report);
		} else {

		}
	}
}
