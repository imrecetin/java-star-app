package com.star;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		int number;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Number of Digits: ");
		number = scanner.nextInt();
		for (int i = 0; i <= number; i++) {
			for (int k = 0; k < number - i; k++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * i - 1; j++) {
				System.out.print("*");
			}
			System.out.print("n");
		}

	}
}
