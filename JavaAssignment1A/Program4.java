package JavaAssignment1A;
import java.io.*;
public class Program4 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//declare a bufferedReader object named br
		int caseMark;
		String repeatMark = "null";
		final String ENCORE = "encore", QUIT = "end";
		try {
			System.out.println("Welcome to this program");
			System.out.println("This program is a menu");
			System.out.println("This menu can be selected to use among three programs");
			while(!repeatMark.equals(QUIT)){
				System.out.println("MAIN MENU");
				System.out.println("(1) Sort Digit Display");
				System.out.println("(2) Turn Based Ball Game");
				System.out.println("(3) 1000 times 3 4-sided dice");
				System.out.println("");
				System.out.println("Which order?(Enter the preceding number)");//UFP
				caseMark = Integer.parseInt(br.readLine());
				switch(caseMark){
				case 1:
					do{
						Program1.main(args);
						System.out.println("Do you want to repeat this program again?");
						System.out.println("Type \""+ENCORE+"\" if you want");
						System.out.println("Or you could type \""+QUIT+"\" to end this program");
						System.out.println("You could also enter anything else to continue");
						repeatMark = br.readLine();
					}while(repeatMark.equals(ENCORE));
					break;
				case 2:
					do{
						Program2.main(args);
						System.out.println("Do you want to repeat this program again?");
						System.out.println("Type \""+ENCORE+"\" if you want");
						System.out.println("Or you could type \""+QUIT+"\" to end this program");
						System.out.println("You could also enter anything else to continue");
						repeatMark = br.readLine();
					}while(repeatMark.equals(ENCORE));
					break;
				case 3:
					do{
						Program3.main(args);
						System.out.println("Do you want to repeat this program again?");
						System.out.println("Type \""+ENCORE+"\" if you want");
						System.out.println("Or you could type \""+QUIT+"\" to end this program");
						System.out.println("You could also enter anything else to continue");
						repeatMark = br.readLine();
					}while(repeatMark.equals(ENCORE));
					break;
				default://wrong number enter again
					System.out.println ("You entered the wrong number");//UFP
					break;//restart loop
				}
			}//end loop(actually not in use without wrong number)
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("This is the end of this program");
	}
}
