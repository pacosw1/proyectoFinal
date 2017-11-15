import java.io.*;
import java.util.*;
public class Login extends Application {
private int attempts = 2;//2+initial
private JPasswordField password;//Hides password
private String username = Lectura.readString("Attempts: " + (attempts+1) + "\nusername:");
private String typedPassword = typedPassword = Lectura.readString("password");//Asks for password
protected boolean status;

public Login() {
        setUsername(username);
        setTypedPassword(typedPassword);
        setPassword(password);
        setStatus(status);
}

/*
  password.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){//Inputs and checks Password
        password = (JPasswordField) e.getSource();
    }
  });
*/
public boolean checkAccount() {//True Username and Password
        if (username.equals("mario") && typedPassword.equals("1234")) {
                return true;
        } else {
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
  password.setBackgroundColor(Color.white);
        if (checkAccount()) {
                setStatus(true); //log in status to true;
                return "Success!";
        }
        else if (attempts > 0) {
                //Displays error tab
                JOptionPane.showMessageDialog(null, "Incorrect Password", JOptionPane.ERROR_MESSAGE);
                System.out.println("Attempts: " + (attempts));
                //char[] password = console.readPassword("Enter password");
                setUsername(Lectura.readString("Username")); setTypedPassword(Lectura.readString("Password"));
                checkAccount();
                attempts--;
                return loginAttempts();
        } else
                return "Attempts Depleted, Try Again Later";
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
}
public void setPassword(JPasswordField password){
        this.password = password;
}/*
public String username() {
        return username;
}
public String password() {
        return password;
}
^Sets?*/
}
