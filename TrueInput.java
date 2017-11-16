package jdialogdemo;//Esto se puede simplificar pero asi se me hiso facil de aser en el momento

public class TrueInput {

	public static boolean authenticate(String username, String password) {
		// hardcoded username and password
		if (username.equals("mario") && password.equals("1234")) {
			return true;
		}
		return false;
	}
}
