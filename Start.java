import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Start implements Serializable {
public static String start() { //Starts the tab

								final JFrame frame = new JFrame("Login");
								final JButton btnLogin = new JButton("Press to start");

								Login loginDlg = new Login(frame);
								loginDlg.setVisible(true);//Doesn't find setVisible
								// if login is successfull
								for(int i = 0; i < 2; i++) {
																if(loginDlg.isSucceeded() == true){//isSucceeded() doesn't exist in Login
																								dispose();
																}
																else if(loginDlg.isSucceeded() == false){
																								btnLogin.setText("You ran out of attempts!");
																								dispose();
																}
								}

								frame.setSize(1350,730);
								frame.setLayout(new FlowLayout());
								frame.getContentPane().add(btnLogin);
								frame.setVisible(true);
								return "";
}
}
