/*
 * Play game against bot here;
 * Contains methods: Move Piece and Undo Move; eg: 6050 is moving whatever piece in board[6][0] to board[5][0];
 * There are restriction of the movements, it is done by legalMove check;
 * Ui() simulate GUI board game, move piece with mouse click and mouse release;
 
 * @author Jianjie Yan
 * @version: 01/04/2020;
 */
package Game;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import Pieces.*;
import bot.*;
public class Compile {
	
	 static JFrame f=new JFrame("Chess Tutorial");
	public static ArrayList<String> historyMovesWhite=new ArrayList<String>();
	public static ArrayList<String> historyMovesBlack=new ArrayList<String>();
	public static Piece [][]chessBoard=new Piece[8][8];
	public static int count=0;
	public static int round=0;
	public static void main(String[]args) {
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		board.fillBoard();
		chessBoard=board.board;
		 Ui();
		board.printBoard(chessBoard);
	}
	public static void Ui() {//swing ui;
		ui ui=new ui();
        f.add(ui);
        f.setSize(500, 500);
        f.setVisible(true);
	}
	
	
	public static void  movePiece (String m)
	{
		
		String num[]=new String[5];
		num=m.split("(?!^)");
		
		int i=Integer.parseInt(num[0]);
		int j=Integer.parseInt(num[1]);
		int k=Integer.parseInt(num[2]);
		int l=Integer.parseInt(num[3]);
		String pieceCaptured=chessBoard[k][l].getPieceCharacter();
		
		
		if(chessBoard[i][j].getPieceCharacter().equals("p")&&j!=l&&pieceCaptured.equals("-")) {
			chessBoard[i][l]=new space();
			historyMovesWhite.add(m+"e");
		}
		else if(chessBoard[i][j].getPieceCharacter().equals("P")&&j!=l&&pieceCaptured.equals("-")) {
			chessBoard[i][l]=new space();
			historyMovesBlack.add(m+"e");
			
		} 
		
		else if(Character.isUpperCase(chessBoard[i][j].getPieceCharacter().charAt(0))) {
			historyMovesBlack.add(m+pieceCaptured);
		}else{
			historyMovesWhite.add(m+pieceCaptured);
			
		}
		chessBoard[k][l]=chessBoard[i][j];
		chessBoard[i][j]=new space();
		
		

	}
	
	
	
	public static void undoMoveWhite() {
		if(historyMovesWhite.size()==0) {
			System.out.println("no back move for white player");
		}
		else {
		String move=historyMovesWhite.get(historyMovesWhite.size()-1);
		String num[]=move.split("(?!^)");
		
		int i=Integer.parseInt(num[0]);
		int j=Integer.parseInt(num[1]);
		int k=Integer.parseInt(num[2]);
		int l=Integer.parseInt(num[3]);
		
		
		
		chessBoard[i][j]=chessBoard[k][l];
		
		if(num[4].equals("e")) {
			 chessBoard[k][l]=new space();
			 chessBoard[i][l]=new pawn(false);
			
		}
		else if(num[4].equals("P")) {
			
			 chessBoard[k][l]=new pawn(false);
		}
		else if(num[4].equals("K")) {
			chessBoard[k][l]=new king(false);
		}
		else if(num[4].equals("N")) {
			chessBoard[k][l]=new knight(false);
		}
		else if(num[4].equals("R")) {
			chessBoard[k][l]=new rook(false);
		}
		else if(num[4].equals("B")) {
			chessBoard[k][l]=new bishop(false);
		}
		else if(num[4].equals("Q")) {
			chessBoard[k][l]=new queen(false);
		}
		else{
			chessBoard[k][l]=new space();
		}
		//System.out.println(historyMoves.get(historyMoves.size()-1));
		historyMovesWhite.remove(historyMovesWhite.size()-1);
		}
	}
	public static void undoMoveBlack() {
		
		if(historyMovesBlack.size()==0) {
			System.out.println("no back move for black player");
		}
		else {
		String move=historyMovesBlack.get(historyMovesBlack.size()-1);
		String num[]=move.split("(?!^)");

		int i=Integer.parseInt(num[0]);
		int j=Integer.parseInt(num[1]);
		int k=Integer.parseInt(num[2]);
		int l=Integer.parseInt(num[3]);
		chessBoard[i][j]=chessBoard[k][l];
		
		if(num[4].equals("e")) {
			 chessBoard[k][l]=new space();
			 chessBoard[i][l]=new pawn(true);
			
		}
		else if(num[4].equals("p")) {
			
			 chessBoard[k][l]=new pawn(true);
		}
		else if(num[4].equals("k")) {
			chessBoard[k][l]=new king(true);
		}
		else if(num[4].equals("n")) {
			chessBoard[k][l]=new knight(true);
		}
		else if(num[4].equals("r")) {
			chessBoard[k][l]=new rook(true);
		}
		else if(num[4].equals("b")) {
			chessBoard[k][l]=new bishop(true);
		}
		else if(num[4].equals("q")) {
			chessBoard[k][l]=new queen(true);
		}
		else{
			chessBoard[k][l]=new space();
		}
		//System.out.println(historyMoves.get(historyMoves.size()-1));
		 historyMovesBlack.remove(historyMovesBlack.size()-1);
		}
	}


}
