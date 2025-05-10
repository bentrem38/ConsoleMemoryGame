package edu.wm.cs.cs301.memorygame;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GameBoard {//DONT CHANGE THIS LINE
	private final GamePiece[][] board;//DONT CHANGE THIS LINE
	public GameBoard(int rows, int cols, Alphabet a) {//DONT CHANGE THIS LINE
		this.board = new GamePiece[rows][cols];
		int j = 0;
		Character[] list = Boardstring(rows, cols, a);
		for (int i = 0; i < rows; i++) {
			for (int k = 0; k < cols; k++) {
				board[i][k] = new CharacterGamePiece(list[j]);
				j++;
			}
		}
	} 
	public GamePiece[][] getBoard() {
		return board;
	}
	public Character[] Boardstring(int row, int col, Alphabet a) {
	    int num_of_l;

	    if (row == 3) {
	        num_of_l = 6;
	    } else if (row == 4) {
	        num_of_l = 14;
	    } else if (row == 7) {
	        num_of_l = 28;
	    } else {
	        throw new IllegalArgumentException("Invalid row value: " + row);
	    }
	    char[] alpha = a.toCharArray();
	    Character[] n_alpha = new Character[num_of_l*2];
	    for (int i=0; i < num_of_l; i++) {
	    	n_alpha[i*2] = alpha[i];
	    	n_alpha[i*2+1] = alpha[i];
	    }
	    List<Character> o_alpha = Arrays.asList(n_alpha);
	    Collections.shuffle(o_alpha);
	    o_alpha.toArray(n_alpha);
	    return n_alpha;
	} 
	public static void outputGameBoard(int row, int col, GamePiece[][] brd) {
		String output = "";
		String output2 = "";
		for (int i = 0; i < col; i++) {
			output += i + "       ";
		}
        System.out.print("     " + output);
        for (int i = 0; i< col; i++) {
        	output2 += "=======";
        }
        System.out.print("\n   " + output2 + "\n");
        												
        for (int i = 0; i < row; i++) {
            System.out.print((i) + " ");
            for (int j = 0; j < col; j++) {
            	if (brd[i][j].isvisible() == true) {
            		try {
            			PrintStream sysout = new PrintStream(System.out, true, "UTF-8");
            			sysout.print("|| " + brd[i][j].getSymbol() + " || ");
            		} catch (UnsupportedEncodingException e) {
            			e.printStackTrace();
            		} 
            	} else { System.out.print("|| ? || ");
            }
           }
            System.out.println("\n   " + output2);

            if (i < row - 1) {
            	String output3 = "";
                for (int k = 0; k< col; k++) {
                	output3 += "========";
                output3 += "\n";
                }
            }
        }
	}
	GamePiece[][] MGTurn(int turn, int row, int col) {
		outputGameBoard(row, col, this.board);
		System.out.println("Turn:" + turn + " Chooose a tile to guess [a b] or type 'quit' to exit MemoryGame");
		Scanner guess = new Scanner(System.in);
		String input1 = guess.nextLine();
		if (input1.equals("quit")) {
        	for (int j = 0; j < row; j++) {
        	
    			for (int k = 0; k < col; k++) {
    				this.board[j][k].setVisible(true);
    			}}
        	System.out.println("This was your Memory Game Puzzle!/n");
        	outputGameBoard(row, col, this.board);
        	System.exit(0);
		} else if (input1.length() == 3) {
			int g1_row = Integer.parseInt(input1.substring(0,1));
			int g1_col = Integer.parseInt(input1.substring(2));
			this.board[g1_row][g1_col].setVisible(true);
			outputGameBoard(row, col, this.board);
			System.out.println("Turn:" + turn + " Chooose a tile to guess [a b] or type 'quit' to exit MemoryGame");
			String input2 = guess.nextLine();
			int j = 0;
	        if (input2.equals("quit")) {
	        	for (j = 0; j < row; j++) {
	        	
	    			for (int k = 0; k < col; k++) {
	    				this.board[j][k].setVisible(true);
	    			}}
	    		System.out.println("This was your Memory Game Puzzle!/n");
	        	outputGameBoard(row, col, this.board);
	        	System.exit(0);
	        } else if (input2.length() == 3) {
	            int g2_row = Integer.parseInt(input2.substring(0, 1));
	            int g2_col = Integer.parseInt(input2.substring(2));
	            this.board[g2_row][g2_col].setVisible(true);
	            if (this.board[g1_row][g1_col].getSymbol().equals(this.board[g2_row][g2_col].getSymbol())) {
	            	System.out.println("Nice!! You found a match!");
	            	for (int i=0;i<row;i++) {
	            		for (j=0;j<col;j++) {
	            			if (this.board[i][j].isvisible() == true) { 
	            			} else if (this.board[i][j].isvisible() == false) {
	            				return MGTurn(turn+1, row, col);
	            			}
	            		}
	            	}
	            return this.board;
	            } else {
	            	outputGameBoard(row, col, this.board);
	            	System.out.println("Unfortunately that wasn't a match. Try again!");
	            	this.board[g1_row][g1_col].setVisible(false);
                    this.board[g2_row][g2_col].setVisible(false);
                    return MGTurn(turn+1, row, col);
					}
				}
	        return MGTurn(turn+1, row, col);
			} 
		return this.board;
	}
}

