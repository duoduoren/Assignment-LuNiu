import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hangman {
	ArrayList<String> words;
	ArrayList<Character> correctList;
	ArrayList<Character> wrongList;
	Map<Character, Integer> wordMap;
	String word;
	char[] displayWord;
	int step;
	
	public static void main(String[] args) {
		System.out.println("       HangmanGame      ");
		System.out.println("------------------------");
		ArrayList<String> words = new ArrayList<String>();
		words.add("amazon");
		words.add("microsoft");
		words.add("facebook");
		words.add("snapchat");
		words.add("alibaba");
		words.add("uber");
		Hangman hangman = new Hangman(words);
		hangman.chooseWord();
		boolean quit = false;
		Scanner in = new Scanner(System.in);
		while (!quit) {
			hangman.printDisplayWord();
			if (hangman.gameOver()) {
				System.out.println("You loss, press any key to quit;");
				quit = true;
				in.nextLine();
				continue;
			}
			
			if (hangman.gameWon()) {
				System.out.println("You won, press any key to quit;");
				quit = true;
				in.nextLine();
				continue;
			}
			
			String guessletter = in.nextLine();
			hangman.handleGuess(guessletter.charAt(0));
			
		}
		
		in.close();
	}
	
	public Hangman(ArrayList<String> words) {
		this.words = words;
		this.correctList = new ArrayList<Character>();
		this.wrongList = new ArrayList<Character>();
		this.step = 0;
	}
	
	void chooseWord() {
		int index = (int) (Math.random() * words.size());
		this.word = words.get(index);
		this.displayWord = new char[word.length()];
		this.wordMap = new HashMap<Character, Integer>();
		for (int i = 0; i < this.word.length(); i ++) {
			char ch = this.word.charAt(i);
			int occurance = 0;
			if (this.wordMap.containsKey(ch)) {
				occurance = this.wordMap.get(ch);
			}
			
			this.wordMap.put(ch, occurance + 1);
			this.displayWord[i] = '-';
		}
	}

	public void printHangman() {
		switch(this.step) {
			case 0: 
				this.printHead();
				break;
			case 1: 
				this.printHead();
				this.printBody();
				break;
			case 2: 
				this.printHead();
				this.printBody();
				this.printLeftArm();
				break;
			case 3:
				this.printHead();
				this.printBody();
				this.printBothArms();
				break;
			case 4:
				this.printHead();
				this.printBody();
				this.printBothArms();
				this.printLeftLeg();
				break;
			case 5:
				this.printHead();
				this.printBody();
				this.printBothArms();
				this.printBothLegs();
				break;
			case 6: 
				this.printHead();
				this.printBody();
				this.printBothArms();
				this.printBothLegs();
				this.printLeftFoot();
				break;
			case 7:
				this.printHead();
				this.printBody();
				this.printBothArms();
				this.printBothLegs();
				this.printBothFoot();
				break;
		}
	}
	
	public void printDisplayWord() {
		System.out.println("Word: " + new String(this.displayWord));
	}
	
	public void handleGuess(char guessLetter) {
		if (this.wordMap.containsKey(guessLetter)) {
			int occurance = this.wordMap.get(guessLetter);
			if (occurance > 0) {
				correctList.add(guessLetter);
				this.wordMap.put(guessLetter, occurance);
				this.setDisplayWord(guessLetter);
			}
		} else {
			wrongList.add(guessLetter);
			this.printHangman();
			this.step++;
		}
	}
	
	public boolean gameWon() {
		return this.correctList.size() == this.word.length();
	}
	
	public boolean gameOver() {
		return this.wrongList.size() == 8;
	}
	
	private void setDisplayWord(char guessLetter) {
		for (int i = 0; i < this.word.length(); i++) {
			if (guessLetter == this.word.charAt(i)) {
				this.displayWord[i] = guessLetter;
			}
		}
	}
	
	private void printHead() {
		System.out.println("----------");
		System.out.println("|        |");
		System.out.println("|        0");
	}
	
	private void printBody() {
		System.out.println("|        |");
	}
	
	private void printLeftArm() {
		System.out.println("|     --- ");
	}
	
	private void printBothArms() {
		System.out.println("|     --- ---");
	}
	
	private void printLeftLeg() {
		System.out.println("|       /");
		System.out.println("|      /");
	}
	
	private void printBothLegs() {
		System.out.println("|       / \\");
		System.out.println("|      /   \\");
		System.out.println("|");
	}
	
	private void printLeftFoot() {
		System.out.println("|  --");
	}
	
	private void printBothFoot() {
		System.out.println("|   --        --");
		System.out.println("|");
		System.out.println("----------------------");
	}
	
}
