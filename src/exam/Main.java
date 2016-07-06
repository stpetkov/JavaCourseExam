package exam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

class Matrix {
	public int[] DimensionConvert(int first[][]) {
		int c = 0;
		int arr[] = new int[first.length * first.length];
		for (int i = 0; i < first.length; i++) {
			for (int j = 0; j < first[i].length; j++) {
				arr[c] = first[j][i] * c;
				c++;
			}
		}
		return arr;
	}

	public int[][] DimensionConvert(int second[]) {
		int c = 0;
		int arr1 = (int) Math.sqrt(second.length);
		int check[][] = new int[arr1][arr1];
		for (int i = 0; i < arr1; i++) {
			for (int j = 0; j < arr1; j++) {
				check[j][i] = second[c] * c;
				c++;
			}
		}
		return check;
	}

}

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int newArr1[][] = null;
		int newArr[] = null;
		Matrix arr = new Matrix();
		int choice = -1, n;
		System.out.println("1. From one Dimension -> Two Dimension");
		System.out.println("2. From two Dimension -> One Dimension");
		System.out.print("Select option (1 or 2)");
		choice = in.nextInt();
		System.out.println("Your choice is ---> (" + choice + ")");

		String path = "Matrix.txt";
		switch (choice) {
		case 1:
			do {
				System.out.print("Enter the size of the side from(2-9): ");
				n = in.nextInt();
			} while (n < 2 || n > 9);
			System.out.println("Input array elements");
			newArr = new int[n * n];
			for (int i = 0; i < n * n; i++) {
				newArr[i] = in.nextInt();
			}
			newArr1 = arr.DimensionConvert(newArr);

			try {
				FileWriter fileWriter = new FileWriter(path);
				BufferedWriter writer = new BufferedWriter(fileWriter);

				for (int i = 0; i < newArr1.length; i++) {
					for (int j = 0; j < newArr1[i].length; j++) {
						writer.write(Integer.toString(newArr1[i][j]) + " ");
					}
					writer.newLine();
				}
				writer.close();
			} catch (IOException e) {
				System.out.println("Error while saving in file." + e.getMessage());
				e.printStackTrace();
			}
			System.out.println("Writing in file is success.");

			/*
			 * Place to save file
			 * 
			 */
			break;
		case 2:
			do {
				System.out.print("Enter the size of the side from(2-9): ");
				n = in.nextInt();
			} while (n < 2 || n > 9);
			System.out.println("Input array elements");
			newArr1 = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					newArr1[i][j] = in.nextInt();
				}
			newArr = arr.DimensionConvert(newArr1);

			try {
				FileWriter fileWriter = new FileWriter(path);
				BufferedWriter writer = new BufferedWriter(fileWriter);

				for (int i = 0; i < newArr.length; i++) {
					writer.write(Integer.toString(newArr[i]) + " ");
					writer.newLine();
				}
				writer.close();
			} catch (IOException e) {
				System.out.println("Error while saving in file." + e.getMessage());
				e.printStackTrace();
			}
			System.out.println("Writing in file is success.");
			break;
		default:
			System.out.print("Wrong Number !");
		}
		if (newArr1 != null && newArr != null) {
			System.out.println("One Dimensional Array : ");
			for (int i = 0; i < newArr.length; i++) {
				System.out.print(newArr[i] + " ");
			}
			System.out.println();
			System.out.println("Two Dimensional Array : ");
			for (int i = 0; i < newArr1.length; i++) {
				for (int j = 0; j < newArr1[i].length; j++) {
					System.out.print(newArr1[i][j] + " ");
				}
				System.out.println();
			}
			in.close();
		}

	}
}