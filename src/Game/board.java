/*
 * Board is an 8*8 double array. 
 * printBoard method print string borad;
 * fill board: fills empty board with pieces;
 * 
 */

package Game;
import Pieces.*;
public class board {
	public static Piece [][] board=new Piece [8][8];
	public static void fillBoard() {

		for (int x = 0; x < 8; x++) {
			board[1][x]=new pawn(true);
			board[6][x]=new pawn(false);
			

			board[2][x]=new space();
			board[3][x]=new space();
			board[4][x]=new space();
			board[5][x]=new space();
			
		}

		 

		board[0][0]=new rook(true);
		board[0][7]=new rook(true);
		board[7][0]=new rook(false);
		board[7][7]=new rook(false);
	
		board[0][1]=new knight(true);
		board[0][6]=new knight(true);
		board[7][6]=new knight(false);
		board[7][1]=new knight(false);
		
		
		board[0][2]=new bishop(true);
		board[0][5]=new bishop(true);
		board[7][2]=new bishop(false);
		board[7][5]=new bishop(false);
		
		
		board[0][3]=new queen(true);
		board[7][3]=new queen(false);
		board[0][4]=new king(true);
		board[7][4]=new king(false);
		
	}
	public static void printBoard(Piece [][]chessBoard) {
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
			System.out.print((chessBoard[i][j]).getPieceCharacter()+" ");
			
			}
			System.out.println();
		}
		
	}
	

}
