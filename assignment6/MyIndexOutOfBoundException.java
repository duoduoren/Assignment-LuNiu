package assignment6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MyIndexOutOfBoundException extends Exception{ // score 2
	int lowerBound;
	int upperBound;
	int currentIndex;
	
	public MyIndexOutOfBoundException(
			int lowerBound, 
			int upperBound, 
			int currentIndex) {
		super("Error Message: Index: "
				+ currentIndex + 
				", but LowerBound: " 
				+ lowerBound + 
				", Upper bound: " + upperBound);
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.currentIndex = currentIndex;
		
	}
	
	public String toString() {
		return "Eorror Message: Index: "
				+ this.currentIndex + 
				", but LowerBound: " 
				+ this.lowerBound + 
				", Upper bound: " + this.upperBound;
	} 
	// 1
	public static void main(String[] args) {
		
		try {
			throw new MyIndexOutOfBoundException(0, 9, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 2
    public static void parse(File file) throws IOException { // score 1
        RandomAccessFile input = null;
        String line = null;
        
        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
              if (input != null) {
                input.close();
              }
          }
    } 
}

