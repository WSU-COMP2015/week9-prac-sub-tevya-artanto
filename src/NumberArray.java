/*
 * Student ID: 22178991
 * Name: Tevya Artanto
 * Campus: WSUI Surabaya
 * Tutor Name: Professor Aamir Shahzad
 * Class Day: Monday
 * Class Time: 11-1 PM
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

public class NumberArray {

	static Scanner kb = new Scanner(System.in);
	
	public static void main(String[] args) {
		/** Tracks action selected by user */
		int action = 0;
		/** Stores relative address of file to be read */
		String fileName = "./txtFiles/numbers.txt";
		/** Creates array using data in file */
		int[] array = createArray(fileName);
		/** Informs user of possible actions */
		actions();
		/** Takes user input for action */
		action = kb.nextInt();
		while (action != 5) {
			/** Sums up array elements and prints result */
			if (action == 1) {
				System.out.println("The sum of the array elements is " + sum(array));
				/** Prompts user for the next action*/
				actions();
				action = kb.nextInt();
			/** Averages array elements and prints result */
			} else if (action == 2) {
				System.out.println("The average value of the array elements is " + average(array));
				/** Prompts user for the next action*/
				actions();
				action = kb.nextInt();
			/** Prints array elements on screen */
			} else if (action == 3) {
				arrayPrintScreen(array);
				/** Prompts user for the next action*/
				actions();
				action = kb.nextInt();
			/** Outputs array to file */
			} else if (action == 4) {
				arrayToFile(array);
				/** Prompts user for the next action*/
				actions();
				action = kb.nextInt();
			/** Error message when user enters any other number */
			} else {
				System.out.println("Invalid command.");
				/** Prompts user for the next action*/
				actions();
				action = kb.nextInt();
			}
		}
	}
	
	/*
	 * Descriptor of actions user can take.
	 */
	public static void actions() {
		System.out.println("Press [1] to calculate the sum of the array.");
		System.out.println("Press [2] to calculate the average of the array.");
		System.out.println("Press [3] to output the contents of the array to the screen.");
		System.out.println("Press [4] to output the contents of the array to numbersoutput.txt.");
		System.out.println("Press [5] to exit.");
	}
	
	/*
	 * Creates array
	 */
	public static int[] createArray(String input) {
		/** Stores integer value */
		int data = 0;
		
		/** Checks whether file exists*/
		try {
			File myFile = new File(input);
			Scanner inputFile = new Scanner(myFile);
			int[] array = new int[100];
			int count = 0;
			
			/** Reads data from file */
			while (inputFile.hasNext() && count < 100) {
				/** Reads integer value */
				data = inputFile.nextInt();
				array[count] = data;
				count++;
			}
			inputFile.close();
			return array;
			
		/** Throws error when file does not exist */
		} catch (IOException e) {
			System.out.println("Error with file");
			return null;
		}

	}
	
	/*
	 * Sums up the values of the array elements.
	 */
	public static int sum(int[] array) {
		/** Stores total value of array elements */
		int total = 0;
		/** Loops through array and stores current sum */
		for (int i = 0; i < array.length; i++) {
			total += array[i];
		}
		/** Returns current sum */
		return total;
	}
	
	/*
	 * Averages the values of the array elements.
	 */
	public static int average(int[] array) {
		/** Recursive function, calculates sum and initially stores in average */
		int average = sum(array);
		/** Calculates average by dividing by array length and returns the result */
		return average/array.length;
	}

	/*
	 * Prints the elements of an array onto the screen
	 */
	public static void arrayPrintScreen(int[] array) {
		/** Loops through array and prints every element */
		for (int i = 0; i < array.length; i++) {
			/** Breaks when a null value is encountered */
			if (array[i] == 0) {
				break;
			}
			/** Prints each element as a line on the console */
			System.out.println(array[i]);
		}
	}
	
	/*
	 * Prints the elements of an array onto a file named numberoutput.txt
	 */
	public static void arrayToFile(int[] array) {
		try {
			PrintWriter outFile = new PrintWriter("./txtFiles/numberoutput.txt");
			for (int i = 0; i < array.length; i++) {
				/** Breaks when a null value is encountered */
				if (array[i] == 0) {
					break;
				}
				/** Prints each element as a line in the file */
				outFile.println(array[i]);
			}
			outFile.close();
		/** Error message when file is faulty */
		} catch (IOException e) {
			System.out.println("Error with file");
		}
	}
}
