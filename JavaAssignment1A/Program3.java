package JavaAssignment1A;
import java.io.*;//to access java io library
import java.util.Random;
public class Program3 {//class header
	public static void main(String[] args) throws IOException {//main method
		Random random = new Random();//declare a Random object named random
		int dice1, dice2, dice3, diceSum, round, roundGraph;
		//declare 6 variables of type integer
		double diceCase3 = 0, diceCase4 = 0, diceCase5 = 0, diceCase6 = 0, diceCase7 = 0, diceCase8 = 0, diceCase9 = 0, diceCase10 = 0, diceCase11 = 0, diceCase12 = 0;
		//declare 10 variables of type double,and set all variables = 0
		double caseRate3, caseRate4, caseRate5, caseRate6, caseRate7, caseRate8, caseRate9, caseRate10, caseRate11, caseRate12;
		//declare 10 variables of type double
		String graphSymbols = "¨€";//declare 1 variables of type String,and set = "¨€"
		System.out.println("Welcome to this program");//UFP
		System.out.println("This program is about simulating three four-sided dice");//UFP
		System.out.println("The three dice will be rolled 1000 times");//UFP
		System.out.println("And it will display a graph");//UFP
		System.out.println("Record the sum of each roll of the three dice");//UFP
		System.out.println("And how often this combination occurs");//UFP
		System.out.println();//UFP
		for(round=0;round<=1000;round++){//for loop to roll 1000 times
			dice1 = random.nextInt(4) + 1;//roll a dice 1-4: 1+(0¡ª¡ª3)
			dice2 = random.nextInt(4) + 1;//roll a dice 1-4: 1+(0¡ª¡ª3)
			dice3 = random.nextInt(4) + 1;//roll a dice 1-4: 1+(0¡ª¡ª3)
			diceSum = dice1 + dice2 + dice3;//the sum of 3 dices
				switch(diceSum){
				case 3://the sum of dices is 3
					diceCase3++;
					break;
				case 4://the sum of dices is 4
					diceCase4++;
					break;
				case 5://the sum of dices is 5
					diceCase5++;
					break;
				case 6://the sum of dices is 6
					diceCase6++;
					break;
				case 7://the sum of dices is 7
					diceCase7++;
					break;
				case 8://the sum of dices is 8
					diceCase8++;
					break;
				case 9://the sum of dices is 9
					diceCase9++;
					break;
				case 10://the sum of dices is 10
					diceCase10++;
					break;
				case 11://the sum of dices is 11
					diceCase11++;
					break;
				case 12://the sum of dices is 12
					diceCase12++;
					break;
				}

			//[while(true)], easy to use break to jump out of loop
		}
		caseRate3 = Math.round(diceCase3/1000*10000)/100.0;
		caseRate4 = Math.round(diceCase4/1000*10000)/100.0;
		caseRate5 = Math.round(diceCase5/1000*10000)/100.0;
		caseRate6 = Math.round(diceCase6/1000*10000)/100.0;
		caseRate7 = Math.round(diceCase7/1000*10000)/100.0;
		caseRate8 = Math.round(diceCase8/1000*10000)/100.0;
		caseRate9 = Math.round(diceCase9/1000*10000)/100.0;
		caseRate10 = Math.round(diceCase10/1000*10000)/100.0;
		caseRate11 = Math.round(diceCase11/1000*10000)/100.0;
		caseRate12 = Math.round(diceCase12/1000*10000)/100.0;
		System.out.println("3 :  came up "+caseRate3+"%");//UFP
		System.out.println("4 :  came up "+caseRate4+"%");//UFP
		System.out.println("5 :  came up "+caseRate5+"%");//UFP
		System.out.println("6 :  came up "+caseRate6+"%");//UFP
		System.out.println("7 :  came up "+caseRate7+"%");//UFP
		System.out.println("8 :  came up "+caseRate8+"%");//UFP
		System.out.println("9 :  came up "+caseRate9+"%");//UFP
		System.out.println("10:  came up "+caseRate10+"%");//UFP
		System.out.println("11:  came up "+caseRate11+"%");//UFP
		System.out.println("12:  came up "+caseRate12+"%");//UFP
		System.out.println("");//UFP
		System.out.print("3 :  ");//UFP
		for(roundGraph=0;roundGraph<caseRate3;roundGraph++){
			System.out.print(graphSymbols);
		}
		System.out.print("\n4 :  ");//UFP
		for(roundGraph=0;roundGraph<caseRate4;roundGraph++){
			System.out.print(graphSymbols);
		}
		System.out.print("\n5 :  ");//UFP
		for(roundGraph=0;roundGraph<caseRate5;roundGraph++){
			System.out.print(graphSymbols);
		}
		System.out.print("\n6 :  ");//UFP
		for(roundGraph=0;roundGraph<caseRate6;roundGraph++){
			System.out.print(graphSymbols);
		}
		System.out.print("\n7 :  ");//UFP
		for(roundGraph=0;roundGraph<caseRate7;roundGraph++){
			System.out.print(graphSymbols);
		}
		System.out.print("\n8 :  ");//UFP
		for(roundGraph=0;roundGraph<caseRate8;roundGraph++){
			System.out.print(graphSymbols);
		}
		System.out.print("\n9 :  ");//UFP
		for(roundGraph=0;roundGraph<caseRate9;roundGraph++){
			System.out.print(graphSymbols);
		}
		System.out.print("\n10:  ");//UFP
		for(roundGraph=0;roundGraph<caseRate10;roundGraph++){
			System.out.print(graphSymbols);
		}
		System.out.print("\n11:  ");//UFP
		for(roundGraph=0;roundGraph<caseRate11;roundGraph++){
			System.out.print(graphSymbols);
		}
		System.out.print("\n12:  ");//UFP
		for(roundGraph=0;roundGraph<caseRate12;roundGraph++){
			System.out.print(graphSymbols);
		}
	}
}
