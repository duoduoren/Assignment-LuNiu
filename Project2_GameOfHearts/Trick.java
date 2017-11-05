
public class Trick extends GroupOfCards {
	private int winner;
	private Card winningCard;
	private boolean hearts;
	private boolean queen;
	
	public int getWinner() {
		return winner;
	}
	
	public Card getWinningCard() {
		return winningCard;
	}
	
	public boolean getHearts() {
		return hearts;
	}
	
	public boolean getQueen() {
		return queen;
	}

 	public Trick(int players) {
		super(2 * players -1);
	}
 	
 	public void update(int playerNum, Card card) {
 		if (this.isWinner(card)) {
 			this.winningCard = card;
 			this.winner = playerNum;
 			if (card.getSuit() == 2) {
 				this.hearts = true;
 			}
 			
 			if (card.getNum() == 12) {
 				this.queen = true;
 			}
 		}
 	}
 	
 	public boolean isWinner(Card card) {
 		if (this.winningCard != null
 				&& this.winningCard.getSuit() != card.getSuit()
 				&& card.getNum() < this.winningCard.getNum()) {
 			return false;
 		}
 		
 		return true;
 	}
}
