package week5;

public class AsteriskLogger 
implements iLogger{

	String constError = "Error:";
	String constAsterisk = "***";
	
	@Override
	public void Log(String text) {
		System.out.println(constAsterisk + text + constAsterisk);		
	}

	@Override
	public void Error(String text) {
		String asteriskBox = "*";
		String prePend = constAsterisk + constError;
		String postPend = constAsterisk;
		for (int i=0;i<text.length()+prePend.length()+postPend.length()-1;i++) {
			asteriskBox += "*";
		}
		System.out.println(asteriskBox);
		System.out.println(prePend + text + postPend);
		System.out.println(asteriskBox);
		
	}

}
