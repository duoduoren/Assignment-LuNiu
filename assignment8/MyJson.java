/* Good WOrk
* Total score 10
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.Gson;

class Vehicle{

    String id;
    String webId;
    Category category;
    Year year;
    String make;
    String model;
    String trim;
    String type;
    double price;
    URL photo;

    Vehicle(String[] arr){
        this.id = arr[0];
        this.webId = arr[1];
        this.category = Category.getCategory(arr[2].toLowerCase());
        this.year = Year.parse(arr[3]);
        this.make = arr[4];
        this.model = arr[5];
        this.trim = arr[6];
        this.type = arr[7];
        this.price = Double.parseDouble(arr[8]);
        try {
            this.photo = new URL(arr[9]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}

enum Category{
    NEW , USED, CERTIFIED;

    public static Category getCategory(String cat){
       switch (cat){
           case "used": return USED;
           case "new": return NEW;
           case "certified": return CERTIFIED;
           default: throw new IllegalArgumentException();
       }
    }

    @Override
    public String toString() {
        switch (this){
            case NEW: return "NEW";
            case USED: return "USED";
            case CERTIFIED: return "CERTIFIED";
            default: throw new IllegalArgumentException();
        }
    }
}

public class MyJson {
	
	public static void main(String[] args) throws IOException{
	    File file = new File("Question3_camino.txt");
	    ArrayList<Vehicle> vehicles = readAndGetVehicles(file);
	    String s = getJsonString(vehicles);
	    writeToFile(s, file.getParent());
	}
	
	private static ArrayList<Vehicle> readAndGetVehicles(File file) throws FileNotFoundException, IOException {
		Scanner input = new Scanner(file);
		input.nextLine();
		ArrayList<Vehicle> listOfVehicle = new ArrayList<Vehicle>();
		while (input.hasNextLine()) {
			String line = input.nextLine();
			String[] vehicle = line.split("~");
			listOfVehicle.add(new Vehicle(vehicle));
		}
		
		return listOfVehicle;
	}
	
	public static String getJsonString(ArrayList<Vehicle> vehicles) {
		return new Gson().toJson(vehicles);
		
	}
	
	public static void writeToFile(String inputToWrite, String filePath) throws IOException {
		   FileWriter writer = new FileWriter(filePath);
		   writer.write(inputToWrite);
		   writer.close();
	}
}
