package projects;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import projects.exception.DbException;

public class ProjectsApp {

	// @formatter:off
	List<String> operations = List.of(
		"1). Add a project." 
	);
	// @formatter:On
	
	Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		new ProjectsApp().processUserSelections();
	}

	private void processUserSelections() {
		boolean done = false;
		while (!done) {
			try {
				int selection = getUserSelection();
			}
			catch(Exception e) {
				System.out.println("\nError: " + e + "Try again.");
			}
		}
	}

	private int getUserSelection() {
		printOperations();
		Integer input = getIntInput("Enter a manu selection");
		return Objects.isNull(input) ? -1 : input;
	}

	private Integer getIntInput(String prompt) {
		String input = getStringInput(prompt);
		if (Objects.isNull(input)) {
			return null;
		}
		try {
			return Integer.valueOf(input);
		}
		catch (NumberFormatException e) {
			throw new DbException(input + " is not a valid number.");
		}
		
		
	}

	private String getStringInput(String prompt) {
		System.out.print(prompt + ": ");
		String input = scanner.nextLine();
		return Objects.isNull(input) ? null : input.trim();
	}

	private void printOperations() {
		System.out.println("\nThese are the available selections. Press the Enter key to quit:");
		operations.forEach(line -> System.out.println("  " + line));
	}

}
