package com.game;

import java.util.Random;
import java.util.Scanner;

class TicTacToe {
	
	static char[][] board;
	
	public TicTacToe() {
		board = new char[3][3];
		initBoard();
	}
	
	static void initBoard() {
		for (int i=0 ; i<board.length ; i++) {
			for (int j=0 ; j<board[i].length ; j++) {
				board[i][j] = ' ';
			}
		}
	}
	
	static void displayBoard() {
		
		System.out.println(" -------------");
		
		for (int i=0 ; i<board.length ; i++) {
			System.out.print(" | ");
			for (int j=0 ; j<board[i].length ; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println(" -------------");
		}
	}
	
	static void placeMark(int row, int column, char mark) {
		
		if(row >= 0 && row <= 2 && column >=0 && column <= 2) {			
			board[row][column] = mark;
		}else {
			System.out.println("Invalid Position");
		}
	}
	
	static boolean checkColWin() {
		for(int j=0 ; j<=2 ; j++) {
			if(board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
				return true;
			}
		}
		return false;
	}

	static boolean checkRowWin() {
		for(int i=0 ; i<=2 ; i++) {
			if(board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return true;
			}
		}
		return false;
	}

	static boolean checkDiagWin() {
		if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2] ||
			board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			return true;
		}
		return false;
	}
}



abstract class Player{
	
	String name;
	char mark;
	
	abstract void makeMove();
	
	boolean isValidMove(int row, int column) {
		if(row >= 0 && row <= 2 && column >= 0 && column <= 2) {
			if(TicTacToe.board[row][column] == ' ') {
				return true;
			}
		}
		return false;
	}
	
	static boolean checkDraw() {
	    for (int i = 0; i < TicTacToe.board.length; i++) {
	        for (int j = 0; j < TicTacToe.board[i].length; j++) {
	            if (TicTacToe.board[i][j] == ' ') {
	                return false;
	            }
	        }
	    }
	    return true;
	}
}

class HumanPlayer extends Player{
		
	public HumanPlayer(String name, char mark) {
		super();
		this.name = name;
		this.mark = mark;
	}
	
	void makeMove() {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int row = -1;
		int column = -1;
		do {
			System.out.println("Please enter the row (0, 1, or 2) where you want to place your mark:");
	        row = scan.nextInt();
	        System.out.println("Please enter the column (0, 1, or 2) where you want to place your mark:");
	        column = scan.nextInt();
	        
	        if (!isValidMove(row, column)) {
	            System.out.println("Invalid move, Please enter a valid row and column.");
			}
		} while (!isValidMove(row, column));
		
		TicTacToe.placeMark(row, column, mark);		
	}
}


class AIPlayer extends Player{
	
	public AIPlayer(String name, char mark) {
		super();
		this.name = name;
		this.mark = mark;
	}
	
	void makeMove() {
		
		@SuppressWarnings({ "resource", "unused" })
		Scanner scan = new Scanner(System.in);
		int row;
		int column;
		do {
			Random random = new Random();
			row = random.nextInt(3);
			column = random.nextInt(3);
		} while (!isValidMove(row, column));
		
		TicTacToe.placeMark(row, column, mark);		
	}	
}


public class LaunchGame {
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		TicTacToe t = new TicTacToe();
		
		Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe! \n");
        
        System.out.println("Please select a game mode: \nPress 1 for Player vs Player \nPress 2 for Player vs Computer");
        int gameMode = scan.nextInt();

        Player cp;
        
        //For Human Players
        if (gameMode == 1) {
	        System.out.println("\nPlease enter the name of Player 1:");
	        String player1 = scan.next();
	        System.out.println("Now, please enter the name of Player 2:");
	        String player2 = scan.next();
	
	        HumanPlayer p1 = new HumanPlayer(player1, 'X');
	        HumanPlayer p2 = new HumanPlayer(player2, 'O');
	
	        cp = p1;
	
	        TicTacToe.displayBoard();
	
	        while (true) {
	            System.out.println(cp.name + ", it's your turn! Make your move.");
	            cp.makeMove();
	            TicTacToe.displayBoard();
	
	            if (TicTacToe.checkRowWin() || TicTacToe.checkColWin() || TicTacToe.checkDiagWin()) {
	                System.out.println("Congratulations " + cp.name + "! You have won the game!");
	                break;
	            } else if (HumanPlayer.checkDraw()) {
	                System.out.println("Game Over - It's a tie!");
	                break;
				}else {
					if(cp == p1) {
						cp = p2;
					}else {
						cp = p1;
					}
				}
			}
        }
        
        //For AI Player
        else if (gameMode == 2) {
        	System.out.println("\nPlease enter your name:");
	        String player1 = scan.next();
	
	        HumanPlayer p1 = new HumanPlayer(player1, 'X');
	        AIPlayer p2 = new AIPlayer("BOB", 'O');
	
	        cp = p1;
	
	        TicTacToe.displayBoard();
	
	        while (true) {
	        	if(cp == p1) {	
	        		System.out.println(cp.name + ", it's your turn! Make your move.");
	        	}else {
	        		System.out.println(cp.name + ": Here is my move.");
	        	}
	        	
	            cp.makeMove();
	            TicTacToe.displayBoard();
	
	            if (TicTacToe.checkRowWin() || TicTacToe.checkColWin() || TicTacToe.checkDiagWin()) {
	                System.out.println("Congratulations " + cp.name + "! You have won the game!");
	                break;
	            } else if (AIPlayer.checkDraw()) {
	                System.out.println("Game Over - It's a tie!");
	                break;
				}else {
					if(cp == p1) {
						cp = p2;
					}else {
						cp = p1;
					}
				}
			}
        } else {
            System.out.println("Invalid selection. Please restart the game and choose a valid mode.");
        }
	}
}
