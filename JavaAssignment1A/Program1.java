//=================================================================
// Digit Sort Display
// Michael Yang
// 2022/4/24
// Java, neon1
//=================================================================
//Create a DigitDisplay application that prompts the user for a non-negative integer,
//Then displays each digit on a separate line - either left-to-right or right-to-left or high-to-low or low-to-high 
//according to the user's choice displayed in order. Application output should be similar to:
//Enter a positive integer: 896 (your program can handle any number of numbers - not just 3 digits)
//Which order?
//left to rightˋ
//right to left?
//high to low?
//low to high?
//your choice? 1
//Left to Right:
//8
//9
//6
//=================================================================
//I - The number entered by the user, the number of the case selected by the user
//O - Sort number of final displayed on separate lines
//P - Read and separate the digits, sort according to different cases, sort the input numbers by array(bubble sort) or reverse calculation
//=================================================================
/*List of Variables - 
 *- let intNumber represent input number (after being converted to int) 每 type integer
 *- let numberSet represent temporarily stored numbers 每 type integer
 *- let numberOut represent The final output number (also a temporary number from intNumber) 每 type integer
 *- let caseMark represent User's choice 每 type integer
 *- let round represent The number of times of the loop, which is also the number of digits in inNumber 每 type integer
 *- let round2 represent The number of loops obtained according to the number of digits, and can be used to solve the precision problem 每 type integer
 *- let intArrays represent The number of loops of the array, which is obtained by directly reading the number of digits 每 type integer 
 *- let roundArrays represent The number of digits in the sorted number output in the array 每 type integer
 *- let doubleNumber represent The number that the user entered at the beginning (in order to increase the number of digits entered) 每 type double
 *- let arraysLength represent The number of digits of the array read directly 每 type integer array
 *- let set represent Relay of intArrays to int 每 type String
 *- let strNumber represent Read relay of intNumber 每 type String
 */
package JavaAssignment1A;//package header
import java.io.*;//to access java io library
public class Program1 {//class header
	public static void main(String[] args) throws IOException {//main method
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//declare a bufferedReader object named br
		int intNumber, numberSet, numberOut, caseMark = 1, round = 0, round2, intArrays, roundArrays;
		//declare 8 variables of type integer,and set 1 variable = 1, another 1 variables = 0
		double doubleNumber;//declare 1 variable of type double
		int[] arraysLength;//declare 1 variable of type integer array
		String set, strNumber;//declare 2 variable of type String
		System.out.println ("Welcome to this program");//UFP
		System.out.println ("This is a DigitDisplay application");//UFP
		System.out.println ("You can enter a non-negative integer ");//UFP
		System.out.println ("Then display each number on a separate line");//UFP
		System.out.println ("And choose to display left-to-right or right-to-left.");//UFP
		System.out.println ("Enter a positive integer: ");//UFP
		doubleNumber = Double.parseDouble(br.readLine());//Accept input convert to integer value and store value in variable name intNumber
		do{//Start do while loop
			System.out.println ("Which order?(Enter the preceding number)");//UFP
			System.out.println ("(1)Left to right");//UFP
			System.out.println ("(2)Right to left");//UFP
			System.out.println ("(3)Low to high");//UFP
			System.out.println ("(4)High to low");//UFP
			caseMark = Integer.parseInt(br.readLine());//Accept input convert to integer value and store value in variable name caseMark
			switch (caseMark) {//Start switch case 
			case 1://case 1(Left to right)
				while(doubleNumber>10){//Start the while loop. Calculate the length of int number
					doubleNumber=doubleNumber/10;//Calculate the number that can be divided by up to several 10s (scientific notation)
					round++;//Divide by 10 to variable round by number length 
				}	//End while loop
				for(round2=0;round2<=round;round2++){//Calculate the diffeence by digit(below) 
					numberOut=(int)doubleNumber;//Use cast to integer take the first digit (current digit)
					System.out.println (numberOut);//output the number of the current digit {UFP 
					doubleNumber=(doubleNumber*10)-(numberOut)*10;//Calculate the remainder after removing the current number of digits
					if(round2==round)doubleNumber=Math.round(doubleNumber);//Solve double precision problem by round
					/*
					 * 1.23[doubleNumber]
					 * int(1.23) =1[int doubleNumber(numberOut)]
					 * (1)*10=10
					 * 1.23*10=12.3
					 * 12.3-(10)= 2.3
					 * 2.3
					 * int(2.3)=2
					 * (2)*10=20
					 * 2.3*10=23
					 * 23-20=3
					 * ...
					 */
				}	
				break;//end loop
			case 2://case 2 (Right to left)
				intNumber=(int) Math.round(doubleNumber);//Round double to int (in order to increase input characters)
				while(intNumber!=0){//start while loop
					numberSet=intNumber/10;//Make the last digit a decimal alone (123/10=12.3), because it is an int, the decimals will be eliminated
					numberSet=numberSet*10;
					numberOut=intNumber-numberSet;
					System.out.println(numberOut);//UFP
					intNumber=intNumber/10;
				}	//end while loop
				/*
				 * 123[intNumber]/10=12.3(numberSet)
				 * int(12.3)=12(numberSet)
				 * 12*10=120(numberSet)
				 * 123-120=3(numberOut)
				 * 12/10=1.2
				 * ...
				 */
				break;//end loop
			case 3: //case 3 (Low to high)
				intNumber=(int) Math.round(doubleNumber);//Round double to int (in order to increase input characters)
				strNumber = ""+intNumber;//Add a non-content string, convert the int to a string
				arraysLength = new int[strNumber.length()];//read string length
				for (intArrays = 0; intArrays < arraysLength.length; intArrays++) {//Loop through the array to set number in array
					set=""+(strNumber.charAt(intArrays));
					//The char value of the corresponding subscript can be obtained through charAt(), and converted to a int
					arraysLength[intArrays] = Integer.parseInt(set);// Use Integer.parseInt() to convert to numbers
				}//end for loop
				bubbleSort1(arraysLength);//Reference the bubbleSort1 method(low to high)
				for(roundArrays=0; roundArrays<arraysLength.length ; roundArrays++){//Loop through the array to output each digit in a row
					System.out.println(arraysLength[roundArrays]);//UFP
				}//end for loop
				break;//end loop
			case 4: //case 4 (High to low)
				intNumber=(int) Math.round(doubleNumber);//Round double to int (in order to increase input characters)
				strNumber = ""+intNumber;//Add a non-content string, convert the int to a string
				arraysLength = new int[strNumber.length()];//read string length
				for (intArrays = 0; intArrays < arraysLength.length; intArrays++) {//Loop through the array to set number in array
					set=""+(strNumber.charAt(intArrays));
					//The char value of the corresponding subscript can be obtained through charAt(), and converted to a int
					arraysLength[intArrays] = Integer.parseInt(set);// Use Integer.parseInt() to convert to numbers
				}//end for loop
				bubbleSort2(arraysLength);//Reference the bubbleSort2 method(high to low)
				for(roundArrays=0; roundArrays<arraysLength.length ; roundArrays++){//Loop through the array to output each digit in a row
					System.out.println(arraysLength[roundArrays]);//UFP
				}//end for loop
				break;//end loop
			default://wrong number enter again
				System.out.println ("You entered the wrong number");//UFP
				//restart loop
			}//end switch case
		}while(caseMark!=1 & caseMark!=2 & caseMark!=3 & caseMark!=4);//end loop(actually not in use without wrong number)
	}// closing of main method
	/*
	 *- let temp represent Temporarily stored intNumber for sorting 每 type integer
	 *- let intNumber represent array 每 type integer
	 *- let round represent Iterate over the difference of the array 每 type integer
	 */
	public static void bubbleSort1(int[] arraysLength) {//bubbleSort1 method
		int temp, intNumber, round;//declare 3 variables of type integer
		for (round = 0; round < arraysLength.length; round++) {//Loop through the array to set number in array
			for (intNumber = 0; intNumber < arraysLength.length - 1 - round; intNumber++) {//start for loop
				//In the inner loop, a maximum number is generated at the end of the array after each loop
				//That is, the maximum number does not need to be compared.
				if (arraysLength[intNumber] > arraysLength[intNumber + 1]) {//Swap the next number in the array if it is smaller than it
					temp = arraysLength[intNumber];//temporary storage
					arraysLength[intNumber] = arraysLength[intNumber + 1];
					arraysLength[intNumber + 1] = temp;
				}//end if
			}//end for loop
		}//end for loop
	}// closing of bubbleSort1 method
	/*
	 *- let temp represent Temporarily stored intNumber for sorting 每 type integer
	 *- let intNumber represent array 每 type integer
	 *- let round represent Iterate over the difference of the array 每 type integer
	 */
	public static void bubbleSort2(int[] arraysLength) {//bubbleSort2 method
		int temp, intNumber, round;//declare 3 variables of type integer
		for (round = 0; round < arraysLength.length; round++) {//Loop through the array to set number in array
			for (intNumber = 0; intNumber < arraysLength.length - 1 - round; intNumber++) {//start for loop
				//In the inner loop, a maximum number is generated at the end of the array after each loop
				//That is, the maximum number does not need to be compared.
				if (arraysLength[intNumber] < arraysLength[intNumber + 1]) {//Swap the next number in the array if it is smaller than it
					temp = arraysLength[intNumber];//temporary storage
					arraysLength[intNumber] = arraysLength[intNumber + 1];
					arraysLength[intNumber + 1] = temp;
				}//end if
			}//end for loop
		}//end for loop
	}// closing of bubbleSort2 method
}//end of class