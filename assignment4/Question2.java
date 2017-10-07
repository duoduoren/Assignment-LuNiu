package assignment4;

class Tool {
	protected int strength;
	protected char type;
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	public int getStrength() {
		return this.strength;
	}
	
	public char getType() {
		return this.type;
	}
	
	boolean fight(Tool tool) {
		boolean res;
		int tempStrength = 0;
		switch (tool.getType()) {
			case 's':
				if (this.type == 'r') {
					tempStrength = this.strength * 2;
				}
				
				res = tempStrength > tool.strength;
				break;
			case 'p':
				if (this.type == 's') {
					tempStrength = this.strength * 2;
				}
				
				res = tempStrength > tool.strength;
				break;
			case 'r':
			default:
				if (this.type == 'p') {
					tempStrength = this.strength * 2;
				}
				
				res = tempStrength > tool.strength;
				break;
		}
		
		return res;
	}
}

class Scissors extends Tool{
	public Scissors(int strength) {
		this.strength = strength;
		this.type = 's';
	}
}

class Paper extends Tool{
	public Paper(int strength) {
		this.strength = strength;
		this.type = 'p';
	}
}

class Rock extends Tool{
	public Rock(int strength) {
		this.strength = strength;
		this.type = 'r';
	}
}

class RockPaperScissorsGame{
    public static void main(String args[]){
        Scissors s = new Scissors(5);
        Paper p = new Paper(7);
        Rock r = new Rock(15);
        
        System.out.println(s.fight(p) + " , "+ p.fight(s) );
        System.out.println(p.fight(r) + " , "+ r.fight(p) );
        System.out.println(r.fight(s) + " , "+ s.fight(r) );
    } 
}

