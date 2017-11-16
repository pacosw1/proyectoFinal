import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
public class CLogin extends Application{
private int attempts = 2;//2+initial
private String username;
private String typedPassword;
protected int status;
private JPasswordField password;//Hides password

public CLogin() {
        setUsername(username);
        setTypedPassword(typedPassword);
        setStatus(status);
}
public boolean checkAccount() {
        if (username.equals("mario") && typedPassword.equals("1234")) {
                setStatus(0); //manager
                return true;
        } else if (username.equals("paco") && typedPassword.equals("12345")) {
          setStatus(1); //employee
          return true;
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
public boolean loginAttempts() {//Recursive function to test for login attempts
        if(checkAccount()) {
                //log in status to true;
                if (status == 0) {
                  System.out.println("Logging in as Admin");
                  return true;
                }
                else {
                  System.out.println("Logging in as floor employee");
                  return true;
                }
        }
        else if (attempts > 0) {

                System.out.println("Attempts: " + (attempts));

                setUsername(Lectura.readString("Username"));
                setTypedPassword(Lectura.readString("Password"));
                checkAccount();
                attempts--;
                return loginAttempts();
        } else
                System.out.println("Attempts Depleted, Try Again Later");
                return false;
}
public String toString() {
        return loginAttempts() + "";
}


public String username() {
        return username;
}

	public int getAttempts() {
		return attempts;
	}

	public String getUsername() {
		return username;
	}

	public String getTypedPassword() {
		return typedPassword;
	}

	public int getStatus() {
		return status;
	}


	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setTypedPassword(String typedPassword) {
		this.typedPassword = typedPassword;
	}

	public void setStatus(int status) {
		this.status = status;
	}



}
