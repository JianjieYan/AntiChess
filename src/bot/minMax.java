/*
 * THis bot goes 4 steps inside and use different values;
 * it is slow sometimes but works better than other one; 
 * The idea of putting position values is not so good, but too late to make another one;
 * 
 */
package bot;
import Game.*;
import Pieces.*;
public class minMax {
	public static Piece chessBoard[][]=Compile.chessBoard;
	public static   int PAWN=-1;
	public static   int ROOK=2;
	public static   int KNIGHT=1;
	public static   int BISHOP=2;
	public static   int QUEEN=-2;
	public  static  int KING=3;
	  private static final int[] pawn= {
			  0,   0,   0,   0,   0,   0,   0,   0,
			  0,   0,   0,   0,   0,   0,   0,   0,
			  0,   0,   1,   1,   1,   1,   0,   0,
			 -5,   3,   2,   2,   2,   2,   2,  -5,
			  4,   4,   5,   3,   3,   5,   0,   4,
			  9,   8,  10,   8,   8,  12,   8,   9,
			  10, 15,  15,  15,  15,  15,  15,  10,
			  0,   0,   0,   0,   0,   0,   0,   0
		};

		private static final int[] knight= {
			10,  10,  10,   10,   10,   10,  10,  10,
			10,   0,   0,    0,    0,    0,   0,  10,
			10,   0,  -5,   -5,   -5,   -5,   0,  10,
			10,   0,  -5,  -10,  -10,   -5,   0,  10,
			10,   0,  -5,  -10,  -10,   -5,   0,  10,
			10,   0,  -5,   -5,   -5,   -5,   0,  10,
			10,   0,   0,    0,    0,    0,   0,  10,
			10,  20,  10,   10,   10,   10,  20,  10
		};
		private static final int[] bishop= {
			10,  10,  10,  10,  10,  10,  10,  10,
			10,   0,   0,   0,   0,   0,   0,  10,
			10,   0,  -5,  -5,  -5,  -5,   0, 10,
			10,   0,  -5, -10, -10,  -5,   0, 10,
			10,   0,  -5, -10, -10,  -5,   0, 10,
			10,   0,  -5,  -5,  -5,  -5,   0, 10,
			10,   0,   0,   0,   0,   0,   0, 10,
			10,  10,  20,  10,  10,  20,  10, 10
		};

		private static final int[] queen= {
			-10,  -10,  -10,  -10,  -10,  -10,  -10,  -10,
			0,    -5,   -5,   -5,   -5,   -5,   -5,   0,
			0,    -5,  -15,  -15,  -15,  -15,   -5,   0,
			0,    -5,  -15,  -20,  -20,  -15,   -5,   0,
			0,    -5,  -15,  -20,  -20,  -15,   -5,   0,
			0,    -5,  -15,  -15,  -15,  -15,   -5,   0,
			0,    -5,   -5,   -5,   -5,   -5,   -5,   0,
			0,     0,    0,   20,    0,    0,    0,   0
		};
		private static final int[] king= {
			     -40, -40, -40, -40, -40, -40, -40, -40,
			     -40, -40, -40, -40, -40, -40, -40, -40,
			     -40, -40, -40, -40, -40, -40, -40, -40,
			     -40, -40, -40, -40, -40, -40, -40, -40,
			     -40, -40, -40, -40, -40, -40, -40, -40,
			     -40, -40, -40, -40, -40, -40, -40, -40,
			     -20, -20, -20, -20, -20, -20, -20, -20,
			     0,  20,  40, -20,   0, -20,  40,  20
			     };
		private static final int[] flip= {
				 56,  57,  58,  59,  60,  61,  62,  63,
				 48,  49,  50,  51,  52,  53,  54,  55,
				 40,  41,  42,  43,  44,  45,  46,  47,
				 32,  33,  34,  35,  36,  37,  38,  39,
				 24,  25,  26,  27,  28,  29,  30,  31,
				 16,  17,  18,  19,  20,  21,  22,  23,
				  8,   9,  10,  11,  12,  13,  14,  15,
				  0,   1,   2,   3,   4,   5,   6,   7
			};
	
	public static void main(String [] args) throws InterruptedException {
		
		board.fillBoard();
	}
	public static String bestMove(Piece [][] chessBoard) {//White
		String s="";

		
		if(possibleMoves.white(chessBoard)!="") {//white has movements
			
			if(possibleMoves.forcedCaptureWhite(chessBoard)!="") {//if there is forced capture for white
				s=s+firstLayer(chessBoard,possibleMoves.forcedCaptureWhite(chessBoard));
			}
			else {//no forced move for white, pass all possible white moves;
				s=s+firstLayer(chessBoard,possibleMoves.white(chessBoard));
			}
		}
		if(s=="") {
			return "0000";
			
		}

		return s;
		
	}
	
	public static String firstLayer(Piece [][]chessBoard,String moves) {//make move for White
		String [] movements=moves.split(" ");
		int x=0;
		int max=-99999;
		int index=0;
		for(int i=0;i<movements.length;i++) {
			
			Compile.movePiece(movements[i].substring(0, 4));//White Moves
			//after white move, now pass moves for black;
			if(possibleMoves.black(chessBoard)!="") {
				
				if(possibleMoves.forcedCaptureBlack(chessBoard)!="") {
					x=secondLayer(chessBoard, possibleMoves.forcedCaptureBlack(chessBoard));
				}
				else {
					x=secondLayer(chessBoard,possibleMoves.black(chessBoard));
				}
				
				if(x>=max) {
					max=x;
					index=i;
				}
				
			}
			Compile.undoMoveWhite();
		}
		if(movements.length==0) {
			return "0000";
		}
		return movements[index].substring(0,4);
		
	}
	
	public static int secondLayer(Piece chessBoard [][],String moves) {
		String [] movements=moves.split(" ");
	
		int s=0;

		int min=99999999;
		
		for(int i=0;i<movements.length;i++) {

			Compile.movePiece(movements[i].substring(0, 4));//black move;
			//pass white movements to next layer;
			if(possibleMoves.white(chessBoard)!="") {
				if(possibleMoves.forcedCaptureWhite(chessBoard)!="") {
					s=thirdLayer(chessBoard,possibleMoves.forcedCaptureWhite(chessBoard));					
				}
				else {
					s=thirdLayer(chessBoard,possibleMoves.white(chessBoard));
				}
				
			}
			else {
				Compile.undoMoveBlack();

				return -500;
			
			}
				if(s<=min) {
					min=s;
				}
			Compile.undoMoveBlack();

			
		}
	
		return s;
	}
	public static int thirdLayer(Piece chessBoard [][],String moves) {
		
		String [] movements=moves.split(" ");
		int s=0;
		int max=-9999999;
		
		for(int i=0;i<movements.length;i++) {
			
			Compile.movePiece(movements[i].substring(0, 4));//white moves
			//pass moves for black;
			if(possibleMoves.black(chessBoard)!="") {
				if(possibleMoves.forcedCaptureBlack(chessBoard)!="") {
					s=forthLayer(chessBoard, possibleMoves.forcedCaptureBlack(chessBoard));
				}
				else
				{
					s=forthLayer(chessBoard, possibleMoves.black(chessBoard));
				}
			}else {
				Compile.undoMoveWhite();
				return 1000;
			}
				if(s>=max) {
					max=s;
				}
			
			Compile.undoMoveWhite();
		}
		
		return s;
	}
	public static int forthLayer(Piece chessBoard [][],String moves) {
		String [] movements=moves.split(" ");
			
		int min=99999999;

		for(int i=0;i<movements.length;i++) {
			
			Compile.movePiece(movements[i].substring(0, 4));//black moves
			
			if(getBoardScores(chessBoard)<=min) {
				min=getBoardScores(chessBoard);
			}

			Compile.undoMoveBlack();
		}
		
		return min;
	}
	public static int getBoardScores(Piece board[][]) {
		int scores=0;
		
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				scores=scores+getPieceScore(board[i][j].getPieceCharacter(), i ,j);
			}
		}
		return scores;
	}
	public static int getPieceScore(String c, int i,int j) {
		
		if(c=="p") {
			return PAWN+pawn[flip[i*8+j]];
			
		}
		else if(c=="P") {
			return PAWN+pawn[i*8+j];		}
		
		else if(c=="n") {
			return KNIGHT+knight[flip[i*8+j]];

		}
		else if(c=="N") {
			return KNIGHT+knight[i*8+j];

		}
		
		else if(c=="k") {
			return KING+king[flip[i*8+j]];

		}
		else if(c=="K") {
			return KING+king[i*8+j];

		}
		
		else if(c=="b") {
			return BISHOP+bishop[flip[i*8+j]];

		}
		else if(c=="B") {
			return BISHOP+bishop[i*8+j];

		}
		
		else if(c=="q") {
			return QUEEN+queen[flip[i*8+j]];

		}
		else if(c=="Q") {
			return QUEEN+queen[i*8+j];

		}
		else if(c=="r") {
			return ROOK;
		}
		else if(c=="R") {
			return ROOK;
		}
		else {
			return 0;
		}
	}
	
}
