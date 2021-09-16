public class Card {
	private String suit;
	private String value;
	
	public Card(String cardSuit, String cardValue){
		this.suit = cardSuit;
		this.value = cardValue;
	}
	
	public String toString(){
		return this.suit.toString() + "-" + this.value.toString();
	}
	
	public String getValue(){
		return this.value;
	}

}
