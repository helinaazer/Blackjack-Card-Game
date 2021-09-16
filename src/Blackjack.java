
import java.util.Scanner;

public class Blackjack 	{
	public static void main(String[] args){
		Menu menu = new Menu();
		
		System.out.println("+--------------------------------------------+");
		System.out.println("            Welcome to Blackjack!             ");
		System.out.println("             Menu Application                ");
		System.out.println("+--------------------------------------------+");
		//playingDeck will be the deck the dealer holds
		Deck playingDeck = new Deck();
		playingDeck.createFullDeck();
		playingDeck.shuffle();
		
		//playerCards will be the cards the player has in their hand
		Deck playerCards = new Deck();
		//playerMoney holds players cash - we will be lazy and use doubles instead of bigdecimals
		double playerMoney = 100.00;
		//dealerCards will be the cards the dealer has in their hand
		Deck dealerCards = new Deck();
		
		//Scanner for user input
		Scanner userInput = new Scanner(System.in);
		
		//Play the game while the player has money
		//Game loop

	while(playerMoney>0){
		menu.runMenu();
		//Take Bet
	System.out.println("You have $" + playerMoney + "0" + " ,how much would you like to bet(Please enter a valid integer; ex: 34)?");
	 String inputCheck = "";

	 double playerBet = -1;
	 while (Double.compare(playerBet, 0) < 0) {
		 try {
			 
			 
			 inputCheck = userInput.next();
			 playerBet = Double.parseDouble(inputCheck);
			 if(playerBet <= 0) {
				 System.out.println("Enter a valid integer");
			 } 
		 }catch (Exception e) {
			 System.out.println("Enter a valid integer");
			 
		 }
		 
	 }
	
	boolean endRound = false;
	if(playerBet > playerMoney){
		//Break if they bet too much
		System.out.println("You cannot bet more than you have.");
		continue;
	}
	
	System.out.println("Dealing...");
	//Player gets two cards
	playerCards.draw(playingDeck);
	playerCards.draw(playingDeck);
	
	//Dealer gets two cards
	dealerCards.draw(playingDeck);
	dealerCards.draw(playingDeck);
			
			
	//While loop for drawing new cards
			
	while(true)
			{
				//Display player cards
				System.out.println("Your Hand:" + playerCards.toString());
				
				//Display Value
				System.out.println("Your hand is currently valued at: " + playerCards.cardsValue());
				
				//Display dealer cards
				System.out.println("Dealer Hand: " + dealerCards.getCard(0).toString() + " and [hidden]");
				
				//What do they want to do
				System.out.println("Would you like to (1)Hit or (2)Stand");
				int response = userInput.nextInt();	
				//They hit
				if(response == 1){
					playerCards.draw(playingDeck);
					System.out.println("You draw a:" + playerCards.getCard(playerCards.deckSize()-1).toString());
					//Bust if they go over 21
					if(playerCards.cardsValue() > 21){
						System.out.println("Bust. Currently valued at: " + playerCards.cardsValue());
						playerMoney -= playerBet;
						endRound = true;
						break;
					}
				}
				
				//Stand
				if(response == 2){
					break;
				}else {
					System.out.println("The input has be 1 or 2");
				}
				
			}
				
			//Reveal Dealer Cards
			System.out.println("Dealer Cards:" + dealerCards.toString());
			//See if dealer has more points than player
			if((dealerCards.cardsValue() > playerCards.cardsValue())&&endRound == false){
				System.out.println("Dealer beats you " + dealerCards.cardsValue() + " to " + playerCards.cardsValue());
				playerMoney -= playerBet;
				endRound = true;
			}
			//Dealer hits at 16 stands at 17
			while((dealerCards.cardsValue() < 17) && endRound == false){
				dealerCards.draw(playingDeck);
				System.out.println("Dealer draws: " + dealerCards.getCard(dealerCards.deckSize()-1).toString());
			}
			//Display value of dealer
			System.out.println("Dealers hand value: " + dealerCards.cardsValue());
			//Determine if dealer busted
			if((dealerCards.cardsValue() > 21)&& endRound == false){
				System.out.println("Dealer Busts. You win!");
				playerMoney += playerBet;
				endRound = true;
			}
			//Determine if push
			if((dealerCards.cardsValue() == playerCards.cardsValue()) && endRound == false){
				System.out.println("Push.");
				endRound = true;
			}
			//Determine if player wins
			if((playerCards.cardsValue() > dealerCards.cardsValue()) && endRound == false){
				System.out.println("You win the hand.");
				playerMoney += playerBet;
				endRound = true;
			}
			else if(endRound == false) //dealer wins
			{
				System.out.println("Dealer wins.");
				playerMoney -= playerBet;
			}

			//End of hand - put cards back in deck
			playerCards.moveAllToDeck(playingDeck);
			dealerCards.moveAllToDeck(playingDeck);
			System.out.println("End of Hand.");
			System.out.println("Now you have $" + playerMoney + "0");
		}
		//Game is over
		System.out.println("Game over! You lost all your money. :(");
		
		//Close Scanner
		userInput.close();
		
	}
	private static double getDouble(Scanner scanner) {
		String test = scanner.next();
		while (!isFloat(test)) {
		System.out.println("Invalid number: " + test + " Please try again");
		test = scanner.next();
		}
		return Double.parseDouble(test);
		}
	private static boolean isFloat(String test) {
		return false;
	}
	static boolean isDouble(String s) {
		try {
		Double.parseDouble(s);
		} catch(NumberFormatException e) {
		return false;
		} catch(NullPointerException e) {
		return false;
		}
		// only got here if we didn't return false
		return true;
		}
	
	
	}

	


	