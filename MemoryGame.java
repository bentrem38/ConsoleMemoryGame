package edu.wm.cs.cs301.memorygame;
import java.util.Scanner;
public class MemoryGame {//DONT CHANGE THIS LINE
	private GameBoard board;//DONT CHANGE THIS LINE
	public MemoryGame() {//DONT CHANGE THIS LINE
		int[] input4 = Welcome();
		System.out.println("Here's the current LeaderBoard! The modes remain blank if there is not a high score");
		Object LB = LeaderBoard.ReadLB();
		if (input4[2]== 1) {
			Alphabet cher = new CherAlphabet();
			GameBoard cur_b = new GameBoard(input4[0], input4[1], cher);
			cur_b.MGTurn(1, input4[0], input4[1]);
		} else if (input4[2] == 2) {
			Alphabet vai = new VaiAlphabet();
			GameBoard cur_b = new GameBoard(input4[0], input4[1], vai);
			cur_b.MGTurn(1, input4[0], input4[1]);
		}
		System.out.println("Nice Job! You beat the Memory Game!");
		Object LD = LeaderBoard.ReadLB();
		}
	
	public int[] Welcome() {
		System.out.println("Welcome to Memory Game! Correctly guess the matching set of symbols in as few turns as possible! There are 3 difficulties: \n"
				+ "easy, normal, and hard. Choose the one you want to play");
		Scanner inputs = new Scanner(System.in);
		String difficulty = inputs.nextLine();
		int row = 0;
		int col = 0;
		if (difficulty.equals("easy")) {
			row = 3;
			col = 4;
		} else if (difficulty.equals("normal")) {
			row = 4;
			col = 7;	
		}	else if  (difficulty.equals("hard")) {
			row = 7;// ꔄ || || ꔃ  ꔁ || || ꔀ |, ꔅ || || ꔄ  ꔅ || || ꔁ |
			col = 8;
		}   else {Welcome();}
		int[] ret = new int[3];
		ret[0] = row;
		ret[1] = col;
		System.out.println("Choose a language to use as symbols: Cherokee or Vai:");
		String language = inputs.nextLine();
		if (language.equals("Cherokee")) {
			ret[2] = 1;
		} else if (language.equals("Vai")) {
			ret[2] = 2;
		} else {Welcome();
		}
		System.out.println("Next, choose a username: ");
		String username = inputs.nextLine();
		return ret;
	}
}	
		

