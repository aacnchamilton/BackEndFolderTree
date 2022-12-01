package week5;

public class App {

	public static void main(String[] args) {
		AsteriskLogger asteriskLogger = new AsteriskLogger();
		asteriskLogger.Log("test asterisk");
		
		asteriskLogger.Error("test asterisk error");
		
		SpacedLogger spacedLogger = new SpacedLogger();
		spacedLogger.Log("test spaces");
		
		spacedLogger.Error("test spaces error");

	}

}
