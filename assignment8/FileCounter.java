import java.io.IOException;
import java.util.Scanner;

public class FileCounter { // score 3
	   private int characterCount, wordCount, lineCount;
	   
	   public FileCounter(){
		   
	   }

	   /**
	      Processes an input source and adds its character, word, and line
	      counts to the respective variables.
	      @param in the scanner to process
	   */
	   public void read(Scanner in) throws IOException {
		   while (in.hasNextLine()) {
			   String line = in.nextLine().trim();
			   this.characterCount += line.replace(" ", "").length();
			   this.wordCount += line.split(" ").length;
			   this.lineCount++;
		   }
	   }
	   
	   public int getCharacterCount() {
		   return this.characterCount;
	   }
	   
	   public int getWordCount() {
		   return this.wordCount;
	   }
	   
	   public int getLineCount() {
		   return this.lineCount;
	   }
}
