import java.io.*;
import javax.swing.*;
import java.awt.*;
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

public String stringPassword(char[] pass) {
        String t = "";
        for (int i = 0; i<pass.length; i++) {
                t+= pass[i];
        }
        return t;
}
//char[] password = console.readPassword("Enter password");
//Arrays.fill(password, ' ');
public String loginAttempts() {//Recursive function to test for login attempts
  password = new JPasswordField(30);
  password.setBounds(280, 240, 90, 20);
  password.setEchoChar('*');
  password.setBackground(Color.white);
  setUsername(Lectura.readString("Attempts: " + (attempts+1) + "\nusername:"));//Inputs Username
  password.addActionListener(ActionListener(actionPerformed(ActionEvent)));//Hides input

        if(checkAccount()) {
                setStatus(true); //log in status to true;
                return "Success!";
        }
        else if (attempts > 0) {
                //Displays error tab
                JOptionPane.showMessageDialog(null, "Incorrect Password", "Enter password again", JOptionPane.ERROR_MESSAGE);
                System.out.println("Attempts: " + (attempts));
                //char[] password = console.readPassword("Enter password");
                setUsername(Lectura.readString("Username"));
                password.addActionListener(new ActionListener(){//Hides input
                  public void actionPerformed(ActionEvent e){//Inputs and checks Password
                  password = (JPasswordField) e.getSource(setTypedPassword(Lectura.readString("Password")));
                  }
                });
                checkAccount();
                attempts--;
                return loginAttempts();
        } else
                return "Attempts Depleted, Try Again Later";
}
public void actionPerformed(ActionEvent e){//Inputs and checks Password
    password = (JPasswordField) e.getSource(setTypedPassword(Lectura.readString("password")));
    }
public String toString() {
        return loginAttempts();
}

public void setUsername(String username) {
        this.username = username;
}
public void setStatus(boolean status) {
        this.status = status;
}
public void setTypedPassword(String typedPassword) {
        this.typedPassword = typedPassword;
}/*
public String username() {
        return username;
}
public String password() {
        return password;
}
^Sets?*/
}
