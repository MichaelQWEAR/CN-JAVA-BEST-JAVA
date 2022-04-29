package JavaAssignment1A;
import java.io.*;//package header
import java.util.Random;//to access java io library
public class Program2 {//class header
	public static void main(String[] args) throws IOException {//main method
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//declare a bufferedReader object named br
		Random random = new Random();//declare a Random object named random
		int gameMarkP,gameMarkE, scoreP = 0, scoreE = 0;
		//declare 4 variables of type integer,and set 2 variables = 0
		int holdBallP = 1, holdBallE = 1, stateCatchP, stateCatchE, stateThrowP, stateThrowE;
		//declare 6 variables of type integer,and set 2 variables = 1
		System.out.println ("Welcome to this program");//UFP
		System.out.println ("This application is a PVE turn based game");//UFP
		System.out.println ("You will choose 1 of 3 actions");//UFP
		System.out.println ("(get a ball, catch a ball, throw a ball)");//UFP
		System.out.println ("You must have the ball in your hand to pitch");//UFP
		System.out.println ("If you try to catch but the computer doesn't throw - the computer gets 1 point");//UFP
		System.out.println ("If the computer doesn't throw, but you don't catch - the computer gets 1 point");//UFP
		System.out.println ("If you try to catch and the computer throws - you will get 2 points");//UFP
		System.out.println ("The first to 5 points wins the game");//UFP
		System.out.println ("");//UFP
		System.out.println ("Games start");//UFP
		System.out.println ("");//UFP
		for(;scoreP<10;){//[for(true)], easy to use break to jump out of loop
			stateCatchP=stateCatchE=stateThrowP=stateThrowE=0;//reset variables
			if(scoreP>=5){//Judge the player's score (5 points is win)
				System.out.println ("You Win!");//UFP
				System.out.println ("Final Score:    Player "+scoreP+"    Computer "+scoreE);//UFP
				break;//Exit the loop and end the program
			}
			else if(scoreE>=5){//Judge the computer's score (5 points is win)
				System.out.println ("Computer Win!");//UFP
				System.out.println ("Final Score:    Player "+scoreP+"    Computer "+scoreE);//UFP
				break;//Exit the loop and end the program
			}
			else if(scoreE==scoreP & scoreP==5){//2 sides draw (5 points at the same time)
				System.out.println ("Draw!");//UFP
				System.out.println ("Final Score:    Player "+scoreP+"    Computer "+scoreE);//UFP
				break;//Exit the loop and end the program
			}
			System.out.println ("Score now:    Player "+scoreP+"    Computer "+scoreE);//UFP
			System.out.println ("Which action would you like to choose?(Enter the preceding number)");//UFP
			System.out.println ("	(1) Get a ball");//UFP
			System.out.println ("	(2) Throw a ball");//UFP
			System.out.println ("	(3) Catch a ball");//UFP
			System.out.println ("The ball you are holding now ("+holdBallP+"/2)");//UFP
			System.out.println ("The ball you opponent are holding now ("+holdBallE+"/2)");//UFP
			gameMarkP = Integer.parseInt(br.readLine());
			if(holdBallE==0){//random computer action, you can't throw the ball without the ball
				gameMarkE=random.nextInt(2) + 1;//Generate numbers 1-2 get/catch
			}//end if
			else if(holdBallE==2){//random computer action, no more balls when the ball is full
				gameMarkE=random.nextInt(2) + 2;//Generate numbers 2-3 catch/throw
			}//end if
			else{//random computer action
				gameMarkE=random.nextInt(3) + 1;//Generate numbers 1-3 all
			}//end if
			switch (gameMarkE){//choose computer action by case
			case 1://get
				holdBallE++;//Computer-owned ball +1
				System.out.println ("Computer get a ball!");//UFP
				break;//Jump out of Switch/case
			case 2://catch
				stateCatchE=1;//The computer catch state is 1 (0: FALSE, 1: TRUE)
				System.out.println ("Computer try to catch a ball!");//UFP
				break;//Jump out of Switch/case
			case 3://throw
				holdBallE--;//Computer-owned ball -1
				stateThrowE=1;//The computer throw state is 1
				System.out.println ("Computer throw a ball!");//UFP
				break;//Jump out of Switch/case
			}//end switch/case
			switch (gameMarkP) {//player makes a choice
			case 1://get
				holdBallP++;//Player-owned ball +1
				System.out.println ("You try to get a ball!");//UFP
				if(holdBallP==3){//no more balls when the ball is full
					System.out.println ("You can't get more balls!");//UFP
					holdBallP--;//Player-owned ball -1
					break;//Jump out of Switch/case
				}//end if
				else{//if the ball wasn't full
					System.out.println ("You get a ball!");//UFP
				}//end else
				break;//Jump out of Switch/case
			case 2://throw
				holdBallP--;//Player-owned ball -1
				System.out.println ("You try to throw a ball!");//UFP
				if(holdBallP==(-1)){//you can't throw the ball without the ball
					System.out.println ("You are out of ball!");//UFP
					holdBallP++;
					break;//Jump out of Switch/case
				}//end if
				else{//you are not out of ball
					stateThrowP=1;////The player throw state is 1
				}//end else
				break;//Jump out of Switch/case
			case 3://catch
				System.out.println ("You try to catch a ball!");//UFP
				stateCatchP=1;////The player catch state is 1
				break;//Jump out of Switch/case
			default:
				System.out.println ("You entered the wrong number");//UFP
				break;//Jump out of Switch/case

			}//end switch/case

			if(stateCatchP==1 & stateThrowE==1){//computer throw, and player catch the ball, player win
				System.out.println ("You caught the ball!");//UFP
				scoreP+=2;//player win 2 points
				holdBallP++;//player catch the ball so u could use that ball to throw    Player-owned ball +1
				System.out.println ("You won 2 points");//UFP
			}//end if
			else if(stateCatchP==1 & stateThrowE==0){//player try to catch the ball, but computer didn't throw the ball, computer win
				System.out.println ("You made the wrong judgment!");//UFP
				scoreE++;//computer win 1 point
				System.out.println ("Your opponent won 1 points");//UFP
			}//end else if
			else if(stateCatchP==0 & stateThrowE==1){//computer throw, but player didn't catch the ball, computer win
				System.out.println ("You didn't catch the ball!");//UFP
				scoreE++;//computer win 1 point
				System.out.println ("Your opponent won 1 points");//UFP
			}//end else if
			else if(stateThrowP==1 & stateCatchE==1){//player throw, and computer catch the ball, computer win
				System.out.println ("The computer got your ball!");//UFP
				scoreE+=2;//computer win 2 points
				holdBallE++;//computer catch the ball so could use that ball to throw  Computer-owned ball +1
				System.out.println ("Your opponent won 2 points");//UFP
			}//end else if
			if(stateCatchE==1 & stateThrowP==0){//computer try to catch the ball, but player didn't throw the ball, player win
				//Why not use else if is because both sides may choose to catch or throw the ball at the same time
				System.out.println ("The computer made the wrong judgment!");//UFP
				scoreP++;//player win 1 point
				System.out.println ("You won 1 points");//UFP
			}//end if
			else if(stateCatchE==0 & stateThrowP==1){//player throw the ball, and computer didn't catch the ball, player win
				System.out.println ("your opponent didn't catch the ball!");//UFP
				scoreP++;//player win 1 point
				System.out.println ("You won 1 points");//UFP
			}//end else if
			if(holdBallP==3){//no more balls when the ball is full
				System.out.println ("You can't get more balls!");//UFP
				holdBallP--;//player-owned ball -1
			}//end if
			else if(holdBallE==3){//no more balls when the ball is full
				System.out.println ("Your opponent can't get more balls!");//UFP
				holdBallE--;//computer-owned ball -1
			}//end else if
		}//end for loop
	}// closing of main method
}//end of class