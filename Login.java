public class Login extends Application {
  private String username;
  private String password;
  private int attempts = 3;
  protected boolean status;

  public Login(String username, String password, boolean status) {
    setUsername(username);
    setPassword(password);
    setStatus(status);
  }

  public boolean checkAccount() {
    if (username.equals("mario") && password.equals("1234")) {
      return true;
    } else {
      return false;
    }
 }

 public String stringPassword(char[] pass) {
   String t = "";
   for (int i = 0;i<pass.length;i++) {
     t+= pass[i];
   }
   return t;
 }
//char[] password = console.readPassword("Enter password");
//Arrays.fill(password, ' ');
  public String loginAttempts() { //recursive function to test for login attempts
        if (checkAccount()) {
          setStatus(true); //log in status to true;
          return "Success!";
        }
        else if (attempts > 0) {
          System.out.println("Attempts: " + (attempts));
          //char[] password = console.readPassword("Enter password");
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
  public void setStatus(boolean status) {this.status = status;}
  public void setPassword(String password) {this.password = password;}
  public String username() {return username;}
  public String password() {return password;}
}
