import java.util.Scanner;

public class Menu {
	boolean exit;
	
	public void runMenu() {
		while(!exit) {
			printMenu();
			int choice = getInput();
			performAction(choice);
			if (choice == 1) {
				break;
			}
		}
	}
	private int getInput() {
		Scanner userInput = new Scanner(System.in);
		int choice = -1;
		while(choice < 0 || choice > 2) {
			try {
				System.out.print("\nEnter your choice: ");
				choice = Integer.parseInt(userInput.nextLine());
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid selection. Please try again.");
			}
		}
		return choice;
	}
	
	private void printMenu() {
		System.out.println("\nPlease make a selection: ");
		System.out.println("1) Playing Blackjack");
		System.out.println("2) Exit");
	}
	
	public void performAction(int choice) {
//		while(!"2".equals(choice)) {
		switch(choice) {
			case 1:
				break;
			case 2:
				exit = true;
				System.out.println("Thank you for using. :)");
				System.exit(0);
			default:
				System.out.println("An unknown error has occured");
		}
	}

}
