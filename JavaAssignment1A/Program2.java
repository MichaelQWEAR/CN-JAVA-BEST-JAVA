package JavaAssignment1A;
import java.io.*;
import java.util.Random;
public class Program2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Random random = new Random();
		int gameMarkP,gameMarkE, scoreP = 0, scoreE = 0;
		int holdBallP = 1, holdBallE = 1, stateCatchP,stateCatchE, stateThrowP, stateThrowE;
		System.out.println ("Welcome to this program");
		System.out.println ("This application is a PVE turn based game");
		System.out.println ("You will choose 1 of 3 actions");
		System.out.println ("(get a ball, catch a ball, throw a ball)");
		System.out.println ("You must have the ball in your hand to pitch");
		System.out.println ("If you try to catch but the computer doesn't throw - the computer gets 1 point");
		System.out.println ("If the computer doesn't throw, but you don't catch - the computer gets 1 point");
		System.out.println ("If you try to catch and the computer throws - you will get 2 points");
		System.out.println ("The first to 5 points wins the game");
		System.out.println ("");
		System.out.println ("Games start");
		System.out.println ("");
		for(;scoreP<10;){
			stateCatchP=stateCatchE=stateThrowP=stateThrowE=0;
			if(scoreP>=5){
				System.out.println ("You Win!");
				System.out.println ("Final Score:    Player "+scoreP+"    Computer "+scoreE);
				break;
			}
			else if(scoreE>=5){
				System.out.println ("Computer Win!");
				System.out.println ("Final Score:    Player "+scoreP+"    Computer "+scoreE);
				break;
			}
			else if(scoreE==scoreP & scoreP>=5){
				System.out.println ("Draw!");
				System.out.println ("Final Score:    Player "+scoreP+"    Computer "+scoreE);
				break;
			}
			System.out.println ("Score now:    Player "+scoreP+"    Computer "+scoreE);
			System.out.println ("Which action would you like to choose?(Enter the preceding number)");
			System.out.println ("	(1) Get a ball");
			System.out.println ("	(2) Throw a ball");
			System.out.println ("	(3) Catch a ball");
			System.out.println ("The ball you are holding now ("+holdBallP+"/2)");
			System.out.println ("The ball you opponent are holding now ("+holdBallE+"/2)");
			gameMarkP = Integer.parseInt(br.readLine());
			if(holdBallE==0){
				gameMarkE=random.nextInt(2) + 1;//Generate numbers 1-2 get/catch
			}
			else if(holdBallE==2){
				gameMarkE=random.nextInt(2) + 2;//Generate numbers 2-3 catch/throw
			}
			else{
				gameMarkE=random.nextInt(3) + 1;//Generate numbers 1-3 all
			}
			switch (gameMarkE){
			case 1://get
				holdBallE++;
				System.out.println ("Computer get a ball!");
				break;
			case 2://catch
				stateCatchE=1;
				System.out.println ("Computer try to catch a ball!");
				break;
			case 3://throw
				holdBallE--;
				stateThrowE=1;
				System.out.println ("Computer throw a ball!");
				break;
			}
			switch (gameMarkP) {
			case 1://get
				holdBallP++;
				System.out.println ("You try to get a ball!");
				if(holdBallP==3){
					System.out.println ("You can't get more balls!");
					holdBallP--;
					break;
				}
				else{
					System.out.println ("You get a ball!");
				}
				break;
			case 2://throw
				holdBallP--;
				System.out.println ("You try to throw a ball!");
				if(holdBallP==(-1)){
					System.out.println ("You are out of ball!");
					holdBallP++;
					break;
				}
				else{
					stateThrowP=1;
				}
				break;
			case 3://catch
				System.out.println ("You try to catch a ball!");
				stateCatchP=1;
				break;
			default:
				System.out.println ("You entered the wrong number");
				break;

			}
			
			if(stateCatchP==1 & stateThrowE==1){
				System.out.println ("You caught the ball!");
				scoreP+=2;
				holdBallP++;
				System.out.println ("You won 2 points");
			}
			else if(stateCatchP==1 & stateThrowE==0){
				System.out.println ("You made the wrong judgment!");
				scoreE++;
				System.out.println ("Your opponent won 1 points");
			}
			else if(stateCatchP==0 & stateThrowE==1){
				System.out.println ("You didn't catch the ball!");
				scoreE++;
				System.out.println ("Your opponent won 1 points");
			}
			
			else if(stateThrowP==1 & stateCatchE==1){
				System.out.println ("The computer got your ball!");
				scoreE+=2;
				holdBallE++;
				System.out.println ("Your opponent won 2 points");
			}
			if(stateCatchE==1 & stateThrowP==0){
				System.out.println ("The computer made the wrong judgment!");
				scoreP++;
				System.out.println ("You won 1 points");
			}
			else if(stateCatchE==0 & stateThrowP==1){
				System.out.println ("your opponent didn't catch the ball!");
				scoreP++;
				System.out.println ("You won 1 points");
			}
			if(holdBallP==3){
				System.out.println ("You can't get more balls!");
				holdBallP--;
			}
		}
		
	}
}