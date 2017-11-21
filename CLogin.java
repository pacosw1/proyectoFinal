import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
public class CLogin extends Application {
private int attempts = 3;//2+initial
private String username;
private String typedPassword;
protected int status = 5;

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
                attempts--;
                return false;
        }
}

public boolean loginAttempts() {//Recursive function to test for login attempts

        //log in status to true;
        if (status == 0) {
                System.out.println("Logging in as Admin");
                return true;
        }
        else if (status == 1) {
                System.out.println("Logging in as floor employee");
                return true;
        }
        else {
                return false;
        }

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
