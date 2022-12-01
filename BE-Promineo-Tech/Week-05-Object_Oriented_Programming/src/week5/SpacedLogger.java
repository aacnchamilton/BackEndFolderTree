package week5;

import java.util.ArrayList;
import java.util.List;

public class SpacedLogger 
implements iLogger{

	String constError = "ERROR:";
	
	@Override
	public void Log(String text) {
		System.out.println(addSpaces(text));
	}

	private String addSpaces(String text) {
		StringBuilder stringWithSpaces = new StringBuilder();
		for (int i=0;i<text.length();i++) {
			stringWithSpaces.append(text.charAt(i) + " ");
		}
		
		return stringWithSpaces.toString();
	}

	@Override
	public void Error(String text) {
		System.out.println(constError + addSpaces(text));
	}

}
