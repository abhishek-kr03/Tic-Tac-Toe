package com.game;

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

class HumanPlayer{
	
	String name;
	char mark;
	
	public HumanPlayer(String name, char mark) {
		super();
		this.name = name;
		this.mark = mark;
	}
	
	boolean isValidMove(int row, int column) {
		
		if(row >= 0 && row <= 2 && column >= 0 && column <= 2) {
			
			if(TicTacToe.board[row][column] == ' ') {
				return true;
			}
		}
		return false;
	}
	
	void makeMove() {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int row;
		int column;
		do {
			System.out.println("Enter the Row");
			row = scan.nextInt();
			System.out.println("Enter the Column");
			column = scan.nextInt();
		} while (!isValidMove(row, column));
		
		TicTacToe.placeMark(row, column, mark);
		
	}
}

public class LaunchGame {
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		TicTacToe t = new TicTacToe();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the P1 name");
		String player1 = scan.next();
		System.out.println("Enter the P2 name");
		String player2 = scan.next();
//		scan.nextLine();
		
		HumanPlayer p1 = new HumanPlayer(player1, 'X');
		HumanPlayer p2 = new HumanPlayer(player2, 'O');
		
		HumanPlayer cp;
		cp = p1;
		
		TicTacToe.displayBoard();
		
		
		while(true) {

			System.out.println(cp.name + "'s Turn");
			cp.makeMove();
			TicTacToe.displayBoard();
			if(TicTacToe.checkRowWin() || TicTacToe.checkColWin() || TicTacToe.checkDiagWin()) {
				System.out.println(cp.name + " Won");
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
}
