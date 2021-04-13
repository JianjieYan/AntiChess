/*
 *Bot failed 
 */


package bot;
import Game.*;
import Pieces.*;
import java.util.ArrayList;
public class AlphaBeta {
	public static int alpha=0;

	public static int beta=0;
	
	public static String getMove(int depth,int player, Piece [][]board) {
		int temp2=0;
		int temp3=0;
		alpha=99999999;
		beta=-999999999;
		
		String [] movesB=possibleMoves.black(board).split(" ");
		String [] movesW=possibleMoves.white(board).split(" ");
		String [] movesFB=possibleMoves.forcedCaptureBlack(board).split(" ");

		String [] movesFW=possibleMoves.forcedCaptureWhite(board).split(" ");
		String s=possibleMoves.white(board)+possibleMoves.black(board);
		ArrayList <String> list=new ArrayList<String>();
		if(depth==4) {
			return ""+simpleBot.getBoardScores(board);
			
		}
		
				
				if(player%2==0) {//black min
						
					for(int i=0;i<movesB.length;i++) {
							if(possibleMoves.forcedCaptureBlack(board)=="") {
							Compile.movePiece(movesB[i].substring(0,4));
							String temp=getMove(depth+1,player+1,board);
							temp2=Integer.parseInt(temp);
							if(temp2<=alpha) {alpha=temp2;}
							
							Compile.undoMoveBlack();
							}
							else
							{
								Compile.movePiece(movesFB[i].substring(0,4));
								String temp=getMove(depth+1,player+1,board);
								temp2=Integer.parseInt(temp);
								if(temp2<=alpha) {alpha=temp2;}
								
								Compile.undoMoveBlack();
							}
							
							
					}		
					return alpha+"";
				}
				if(player%2!=0) {//White
					for(int i=0;i<movesW.length;i++) {
						if(possibleMoves.forcedCaptureWhite(board)=="") {
						Compile.movePiece(movesW[i].substring(0,4));
						String temp=getMove(depth+1,player+1,board);
						temp3=Integer.parseInt(temp);
						if(temp3>=beta) {beta=temp3;}
						Compile.undoMoveWhite();
						}
						else
						{
							Compile.movePiece(movesFW[i].substring(0,4));
							String temp=getMove(depth+1,player+1,board);
							temp3=Integer.parseInt(temp);
							if(temp3>=beta) {beta=temp3;}
							Compile.undoMoveWhite();
						}
						
						
						
						
					}
			
					return beta+"";
			}
				
			
		
		
		
		return "";
		
	}

}
