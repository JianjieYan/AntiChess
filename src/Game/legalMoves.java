/*
 * check if the move is legal move.
 * white and black are seperated;
 */
package Game;
import Pieces.*;
public class legalMoves {
	public static boolean white(String move,Piece [][]board) {
		
		if(possibleMoves.forcedCaptureWhite(board)==""&&possibleMoves.white(board).contains(move)) {
				return true;
		}
		if(possibleMoves.forcedCaptureWhite(board)!=""&&possibleMoves.forcedCaptureWhite(board).contains(move)) {
			return true;
	}
		else
		return false;
		
	}
	
	public static boolean black(String move,Piece [][]board) {
		
		if(possibleMoves.forcedCaptureBlack(board)==""&&possibleMoves.black(board).contains(move)) {
				return true;
		}
		if(possibleMoves.forcedCaptureBlack(board)!=""&&possibleMoves.forcedCaptureBlack(board).contains(move)) {
			return true;
	}
		else
		return false;
		
	}	
	
}
