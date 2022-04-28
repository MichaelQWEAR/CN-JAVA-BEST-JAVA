package JavaAssignment1A;
import java.io.*;//to access java io library
import java.util.Random;
public class Program3 {//class header
	public static void main(String[] args) throws IOException {//main method
		Random random = new Random();
		int dice1, dice2, dice3, diceSum, round, comboTtl = 0, roundGraph;
		double diceCase3 = 0, diceCase4 = 0, diceCase5 = 0, diceCase6 = 0, diceCase7 = 0, diceCase8 = 0, diceCase9 = 0, diceCase10 = 0, diceCase11 = 0, diceCase12 = 0;
		double caseRate3, caseRate4, caseRate5, caseRate6, caseRate7, caseRate8, caseRate9, caseRate10, caseRate11, caseRate12;
		String graphSymbols = "█";
		System.out.println("Welcome to this program");
		System.out.println("This program is about simulating three four-sided dice");
		System.out.println("The three dice will be rolled 1000 times");
		System.out.println("And it will display a graph");
		System.out.println("Record the sum of each roll of the three dice");
		System.out.println("And how often this combination occurs");
		System.out.println();
		for(round=0;round<=1000;round++){
			comboTtl++;
			dice1 = random.nextInt(4) + 1;
			dice2 = random.nextInt(4) + 1;
			dice3 = random.nextInt(4) + 1;
			diceSum = dice1 + dice2 + dice3;
			do{
				switch(diceSum){
				case 3:
					diceCase3++;
					break;
				case 4:
					diceCase4++;
					break;
				case 5:
					diceCase5++;
					break;
				case 6:
					diceCase6++;
					break;
				case 7:
					diceCase7++;
					break;
				case 8:
					diceCase8++;
					break;
				case 9:
					diceCase9++;
					break;
				case 10:
					diceCase10++;
					break;
				case 11:
					diceCase11++;
					break;
				case 12:
					diceCase12++;
					break;
				}
			}while(diceSum!=3 & diceSum!=4 & diceSum!=5 & diceSum!=6 & diceSum!=7 & diceSum!=8 & diceSum!=9 & diceSum!=10 & diceSum!=11 & diceSum!=12);
		}
		caseRate3 = Math.round(diceCase3/comboTtl*10000)/100.0;
		caseRate4 = Math.round(diceCase4/comboTtl*10000)/100.0;
		caseRate5 = Math.round(diceCase5/comboTtl*10000)/100.0;
		caseRate6 = Math.round(diceCase6/comboTtl*10000)/100.0;
		caseRate7 = Math.round(diceCase7/comboTtl*10000)/100.0;
		caseRate8 = Math.round(diceCase8/comboTtl*10000)/100.0;
		caseRate9 = Math.round(diceCase9/comboTtl*10000)/100.0;
		caseRate10 = Math.round(diceCase10/comboTtl*10000)/100.0;
		caseRate11 = Math.round(diceCase11/comboTtl*10000)/100.0;
		caseRate12 = Math.round(diceCase12/comboTtl*10000)/100.0;
		System.out.println("3 :  came up "+caseRate3+"%");
		System.out.println("4 :  came up "+caseRate4+"%");
		System.out.println("5 :  came up "+caseRate5+"%");
		System.out.println("6 :  came up "+caseRate6+"%");
		System.out.println("7 :  came up "+caseRate7+"%");
		System.out.println("8 :  came up "+caseRate8+"%");
		System.out.println("9 :  came up "+caseRate9+"%");
		System.out.println("10:  came up "+caseRate10+"%");
		System.out.println("11:  came up "+caseRate11+"%");
		System.out.println("12:  came up "+caseRate12+"%");
		System.out.println("");
		System.out.print("3 :  ");
		for(roundGraph=0;roundGraph<caseRate3;roundGraph++){
			System.out.print(graphSymbols);//输出结果 █
		}
		System.out.print("\n4 :  ");
		for(roundGraph=0;roundGraph<caseRate4;roundGraph++){
			System.out.print(graphSymbols);//输出结果 █
		}
		System.out.print("\n5 :  ");
		for(roundGraph=0;roundGraph<caseRate5;roundGraph++){
			System.out.print(graphSymbols);//输出结果 █
		}
		System.out.print("\n6 :  ");
		for(roundGraph=0;roundGraph<caseRate6;roundGraph++){
			System.out.print(graphSymbols);//输出结果 █
		}
		System.out.print("\n7 :  ");
		for(roundGraph=0;roundGraph<caseRate7;roundGraph++){
			System.out.print(graphSymbols);//输出结果 █
		}
		System.out.print("\n8 :  ");
		for(roundGraph=0;roundGraph<caseRate8;roundGraph++){
			System.out.print(graphSymbols);//输出结果 █
		}
		System.out.print("\n9 :  ");
		for(roundGraph=0;roundGraph<caseRate9;roundGraph++){
			System.out.print(graphSymbols);//输出结果 █
		}
		System.out.print("\n10:  ");
		for(roundGraph=0;roundGraph<caseRate10;roundGraph++){
			System.out.print(graphSymbols);//输出结果 █
		}
		System.out.print("\n11:  ");
		for(roundGraph=0;roundGraph<caseRate11;roundGraph++){
			System.out.print(graphSymbols);//输出结果 █
		}
		System.out.print("\n12:  ");
		for(roundGraph=0;roundGraph<caseRate12;roundGraph++){
			System.out.print(graphSymbols);//输出结果 █
		}
	}
}
