
public class GroupOfCards {
    protected Card[] cards;
    protected int currentSize = 0;

    GroupOfCards(int num) {
        this.cards = new Card[num];
    }

    public int getCurrentSize() {
        return this.currentSize;
    }

    public Card getCard(int i) {
	    	if ( i < 0 || i >= currentSize) {
	    		return null;
	    	}
	    	
        return this.cards[i];
    }

    public void addCard(Card card) {
        if (currentSize < this.cards.length) {
        		this.cards[this.currentSize++] = card; 
        }
    }

    public Card removeCard(int index) {
    		if (index < 0 || index >= this.currentSize) {
    			return null;
    		}
    		
    		Card card = this.cards[index];
    		
    		for (int i = index; i < this.currentSize - 1; i++) {
    			this.cards[i] = this.cards[i + 1];
    		}
    		
    		this.cards[this.currentSize - 1] = null;
    		this.currentSize--;
    		
    		return card;
    }
    
    public void display() {
    		for (int i = 0; i < this.currentSize; i++) {
    			this.cards[i].display();
    			System.out.println();
    		}
    }
}
