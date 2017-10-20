public class Login extends Application {
  private String username;
  private String password;
  private int attempts;

  public Login(String username, String password) {
    setUsername(username);
    setPassword(password);
  }

  public boolean checkAccount(String message) {
    if (username.equals("mario") && password.equals("1234")) {
      return true;
    } else {
      return false;
    }
 }

  public String loginAttempts() { //recursive function to test for login attempts
        if (attempts > 3)
          return "Try Again Later";
        else if (attempts <= 3) {
          setUsername(Lectura.readString("Username"));
          setPassword(Lectura.readString("Password"));
          checkAccount("Try Again" + "Attempts left: " + (attempts+1));
          attempts++;
          return loginAttempts();
        } else
          return "Success!";
      }
  public String toString() {
    return loginAttempts();
  }

  public void setUsername(String username) {this.username = username;}
  public void setPassword(String password) {this.password = password;}
  public String username() {return username;}
  public String password() {return password;}
}
