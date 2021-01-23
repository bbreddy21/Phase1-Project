package com.business.operations;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import com.business.*;

public class BusinessLevelOperations implements FileInterface {
	List<String> retrieve = new ArrayList<String>();
	File[] files = new File("/Users/bbreddy/LockedMe.com-App-master").listFiles();

	@Override
	public void showAllFiles() {
		List<Path> x;
		try {
			x = Files.list(Paths.get("/Users/bbreddy/LockedMe.com-App-master")).filter(p -> Files.exists(p))
					.map(s -> s.getFileName()).sorted().collect(Collectors.toList());
			x.forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void addFile() {
		// TODO Auto-generated method stub
		System.out.println("Enter the file to add:");
		// sc.next();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String filename = scan.nextLine();
		File file = new File(filename);
		try {
			if (file.createNewFile()) {
				System.out.println(filename + " file is successfully added to the directory");
				Desktop.getDesktop().edit(file);
			} else {
				System.out.println("This file is already present in the directory");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteFile() {
		// TODO Auto-generated method stub
		System.out.println("Enter the file to delete:");
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String filename = scan.nextLine();
		File F = new File(filename);
		if (F.delete())
			System.out.println(filename + " got Deleted Successfully");
		else
			System.out.println("File Not Found in the Directory");
		
	}

	@Override
	public void searchFile() {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			File directory = new File("/Users/bbreddy/LockedMe.com-App-master");
			System.out.println("Enter the file to search:");
			String fileName = scan.nextLine();
			File[] files = directory.listFiles();
			int flag = 0;
			for (File file : files) {
				String name = file.getName();
				if (name.equals(fileName)) {
					File f = new File(fileName);
					@SuppressWarnings("resource")
					Scanner scanner = new Scanner(f);
					while (scanner.hasNextLine()) {
						System.out.println(scanner.nextLine());
					}
					flag = 1;
					
				}
			}
			if (flag == 0) {
				System.out.println("File not found");
			}
			

		} catch (FileNotFoundException ex) {
			System.out.println("file not found");
		}
		

	}

}
