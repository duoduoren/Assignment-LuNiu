/* Need To improve
 * Score 15
 * your project compiles but gives null pointer exception and doesn't produce desired output
 */
import java.util.Scanner;

public class GameDriver {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Game game = new Game(4);
        while(true)
        {
            game.playAGame();
            String input = scan.next();
            if (!input.equalsIgnoreCase("Y"))
            {
            		break;
            }

            game = new Game(4);
        }
	}
}
