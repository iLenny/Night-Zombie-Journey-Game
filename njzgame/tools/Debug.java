package njzgame.tools;

public class Debug {

	public static void printErrorMessage(Class<?> classObject, String name, String message) {
		System.err.println("ERROR FROM CLASS: " +classObject.getSimpleName()+ ": " + name + ": " + message);
	}
	
	public static void printMessage(Class<?> classObject, String name, String message) {
		System.out.println("FROM CLASS: " +classObject.getSimpleName()+ ": " + name + ": " + message);
	}
}
