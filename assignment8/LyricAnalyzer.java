import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class LyricAnalyzer { // score 4
	private HashMap<String, ArrayList<Integer>> map;
	private int numberOfWords;
	
	public void read(File file) {
		try {
			Scanner input = new Scanner(file);
			int startIndex = 0;
			while (input.hasNextLine()) {
				String[] words = input.nextLine().trim().split(" ");
				for (int i = 1; i <= words.length; i++) {
					this.add(words[i], words.length == i? -(startIndex + i) : (startIndex + i));
				}
				
				startIndex += words.length;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void add(String lyricWord, int wordPosition) {
		ArrayList<Integer> position = map.get(lyricWord);
		if (position == null) {
			position = new ArrayList<Integer>();
			this.map.put(lyricWord, position);
		}
		
		this.numberOfWords++;
		position.add(wordPosition);
	}
	
	public void displayWords() {
		String[] words = new String[this.map.keySet().size()];
		words = this.map.keySet().toArray(words);
		Arrays.sort(words);
		for(String word : words) {
			StringBuilder sb = new StringBuilder();
			List<Integer> positions = this.map.get(word);
			for (int i = 0; i < positions.size(); i ++) {
				sb.append(positions.get(i));
				if (i != positions.size() -1) {
					sb.append(",");	
				}
			}
			
			System.out.println(word + ": " + sb.toString());
		}
	}
	
	public void writeLyrics(File file) {
		String[] lyrics = new String[this.numberOfWords + 1];
		for (String word: this.map.keySet()) {
			for (int position: this.map.get(word)) {
				lyrics[Math.abs(position)] = word + (position < 0 ? "\n" : "");
			}
		}
		
		for (String word : lyrics) {
			System.out.print(word);
		}
	}
	
	public int count() {
		return this.numberOfWords;
	}
	
	public String mostFrequentWord() {
		int frequency = 0;
		String mostFrequentWord = "";
		for(String word: this.map.keySet()) {
			if (frequency < this.map.get(word).size()) {
				frequency = this.map.get(word).size();
				mostFrequentWord = word;
			}
		}
		
		return mostFrequentWord;
	}
}
