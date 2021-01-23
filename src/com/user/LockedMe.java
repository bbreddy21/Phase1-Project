package com.user;

import java.io.*;
import java.util.*;

import com.business.operations.BusinessLevelOperations;

public class LockedMe {

	public static void main(String[] args) {

		userScreen();
		try {
			userOptions();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void userScreen() {
		System.out.println("Application Name : LOCKEDME.COM \n");
		System.out.println("Developer : Bramhaiah B Redddy \n");
	}

	public static void userOptions() throws FileNotFoundException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		BusinessLevelOperations obj = new BusinessLevelOperations();
		int option;
		System.out.println("*** Welcome to LockedMe.com****: \n");
		do {
			System.out.println("Enter your choice of action: \n");
			System.out.println("\t1. List all files in ascending order \n");
			System.out.println("\t2. Business-level operations \n");
			System.out.println("\t3. Quit from application \n");

			option = sc.nextInt();
			switch (option) {
			case 1:
				obj.showAllFiles();
				break;
			case 2:
				int ch;
				do {
					System.out.println("Enter your choice Business Action");
					System.out.println("\t1. Add a file and its content to a directory");
					System.out.println("\t2. Delete a file from a directory");
					System.out.println("\t3. Search a file and showing content");
					System.out.println("\t4. Exit to Main Options");

					ch = sc.nextInt();
					switch (ch) {
					case 1:
						obj.addFile();
						break;
					case 2:
						obj.deleteFile();
						break;
					case 3:
						obj.searchFile();
						break;
					case 4:
						System.out.println("Exited from the Business Level operations...");
						System.out.println("---------------------------------\n");
						break;
					default:
						System.out.println("Invalid Choice");
						break;
					}
				} while (ch != 4);
				break;
			case 3:
				System.out.println("Exiting from the app...");
				break;
			default:
				System.out.println("Invalid Option");
			}

			// System.out.println("Press 0 to continue");
		} while (option != 3);

	}
}
