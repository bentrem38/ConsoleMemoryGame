package edu.wm.cs.cs301.memorygame;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.BufferedReader;

public class LeaderBoard {
	public LeaderBoard() throws FileNotFoundException {}
	public static Object ReadLB() { 
		File leaderboard = new File("./Resources/LeaderBoard.txt");
		BufferedReader r_file = null;
		try {
			r_file = new BufferedReader(new FileReader(leaderboard));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		List<String> lines = new ArrayList<String>();
		String line = null;
		try {
			while ((line = r_file.readLine()) != null) {
				lines.add(line);
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			r_file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] file_arr = lines.toArray(new String[lines.size()]);
		int i = 0;
		String[] LB = new String[3];
		for (String line1 : file_arr) {
			System.out.println(line1);
		}
		return LB;
	}
	public static int addToLB(String mode, String username, int score) {
		File leaderboard = new File("./Resources/LeaderBoard.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(leaderboard);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String filec  = "";
		while(scan.hasNextLine()) {
			filec = filec.concat(scan.nextLine() + "\n");
		}
		String[] lines = filec.split("\n");
		if (mode == "easy") {
			String[] val = lines[0].split(" ");
			Integer n = Integer.valueOf(val[2]);
			if (n > score) {
				lines[0] = "Easy: " + username + " "+ score;
			}
		} else if (mode == "normal") {
			String[] val = lines[1].split(" ");
			Integer n = Integer.valueOf(val[2]);
			if (n > score) {
				lines[1] = "Normal: " + username + " "+ score;
			}
		} else if (mode == "hard") {
			String[] val = lines[2].split(" ");
			Integer n = Integer.valueOf(val[2]);
			if (n > score) {
				lines[2] = "hard: " + username + " "+ score;
			}
		}
		try {
			StringBuilder tempv = new StringBuilder();
			for (String element: lines) {
				tempv.append(element).append("\n");
			}
			String tempv2 = tempv.toString();
			FileWriter writer = new FileWriter("./Resources/LeaderBoard.txt");
			writer.write(tempv2);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return 0;
	}
}