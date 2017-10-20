public class Login extends Application {
  private String username;
  private String password;
  private int attempts = 3;

  public Login(String username, String password) {
    setUsername(username);
    setPassword(password);
  }

  public boolean checkAccount() {
    if (username.equals("mario") && password.equals("1234")) {
      return true;
    } else {
      return false;
    }
 }
//char[] password = console.readPassword("Enter password");
//Arrays.fill(password, ' ');
  public String loginAttempts() { //recursive function to test for login attempts
        if (checkAccount())
          return "Success!";
        else if (attempts > 0) {
          System.out.println("Attempts: " + (attempts));
          setUsername(Lectura.readString("Username")); setPassword(Lectura.readString("Password")); //
          checkAccount();
          attempts--;
          return loginAttempts();
        } else
          return "Try Again Later";
      }
  public String toString() {
    return loginAttempts();
  }

  public void setUsername(String username) {this.username = username;}
  public void setPassword(String password) {this.password = password;}
  public String username() {return username;}
  public String password() {return password;}
}
