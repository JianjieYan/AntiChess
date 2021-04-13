/*
 * Check if the game has finished;
 * draw method not complete here, use with a counter for number of rounds;
 */
package Game;
import java.util.ArrayList;
import Pieces.*;

public class gameFinish {
	
	
	public static boolean finish(Piece board[][]) {
		if(drawCheck(board)==true||winCheckBlack(board)==true||winCheckWhite(board)==true) {
			return true;
		}
		return false;
	}
	public static boolean drawCheck(Piece board[][]) {
		String s="";
		//strings to store index of same colored squares;
		String colorBlocks1="01 03 05 07 10 12 14 16 21 23 25 27 30 32 34 36 41 43 45 47 50 52 54 56 61 63 65 67 70 72 74 76";
		String colorBlocks2="02 04 06 08 11 13 15 17 22 24 26 28 31 33 35 37 42 44 46 48 51 53 55 57 62 64 66 68 71 73 75 77";
		
		ArrayList<String> listforB=new ArrayList<String>();
		ArrayList<String> listforb=new ArrayList<String>();
		ArrayList<String> listforP=new ArrayList<String>();
		ArrayList<String> listforp=new ArrayList<String>();
//count store how many bishop in the game for 2 colors
		int count1=0,count2=0;
		for(int i=0;i<64;i++) {
			//if there are pieces apart from pawns and bishops left in the board, then its not draw
				if(board[i/8][i%8].getPieceCharacter()!="p"|board[i/8][i%8].getPieceCharacter()!="P"|board[i/8][i%8].getPieceCharacter()!="b"|board[i/8][i%8].getPieceCharacter()!="B") {	
					return false;}
				//String s stores the possible moves of 2 colored pawns. and add index of pawns into list
				if(board[i/8][i%8].getPieceCharacter()=="P") {
					listforP.add(""+(i/8)+(i%8));
					s=s+possibleMoves.posibleP(i, board);
				}
				if(board[i/8][i%8].getPieceCharacter()=="p") {
					listforp.add(""+(i/8)+(i%8));
					s=s+possibleMoves.posiblep(i, board);					
				}
				//count the bishops on 2 sides, and add the index into list. eg 72 75
				if(board[i/8][i%8].getPieceCharacter()=="b") {
					count1++;
					listforb.add(""+(i/8)+(i%8));	
				}
				if(board[i/8][i%8].getPieceCharacter()=="B") {
					count2++;
					listforB.add(""+(i/8)+(i%8));
					}			
		}
		//if pawns are not locked, then not a draw straight away
		if(s!="") {
			return false;
			}
	//here pawns have no movements. and only 1 bishop on each side;
		if(count1==1&&count2==1) {
			//check if those 2 bishops are in the same color blocks. if they are, then not draw.
			if(colorBlocks1.contains(listforb.get(0))&&colorBlocks1.contains(listforB.get(0))) {
				return false;
			}
			if(colorBlocks2.contains(listforb.get(0))&&colorBlocks2.contains(listforB.get(0))) {
				return false;
			}
			//loop through the pawn positions as there might be more than one pawn left on both sides
			//but bishop will be one on both sides
			for(int i=0;i<listforp.size();i++) {//check if black bishop and white pawns are in same color blocks.
				if(colorBlocks1.contains(listforp.get(i))&&colorBlocks1.contains(listforB.get(0))) {
					return false;
				}
				if(colorBlocks2.contains(listforp.get(i))&&colorBlocks2.contains(listforB.get(0))) {
					return false;
				}
			}
			for(int i=0;i<listforP.size();i++) {//opposite.
				if(colorBlocks1.contains(listforP.get(i))&&colorBlocks1.contains(listforb.get(0))) {
					return false;
					}
				if(colorBlocks2.contains(listforP.get(i))&&colorBlocks2.contains(listforb.get(0))) {
					return false;
					}
				}
			}
		return true;
		}
	
	public static boolean winCheckWhite(Piece [][]board) {
		
		if(countWhitePiece(board)==0) {
			return true;
		}
		else
		return false;
	}
	public static boolean winCheckBlack(Piece [][]board) {
		
			if(countBlackPiece(board)==0) {
				return true;
			}
			else
				return false;
	}
	
	public static int countWhitePiece (Piece [][] board){
		int count=0;
		for(int i=0;i<8;i++){

			for(int j=0;j<8;j++){
				
				if(Character.isLowerCase(board[i][j].getPieceCharacter().charAt(0))){
					count++;				
				}
				
			}
		}
				return count;
		
	}
	
	public static int countBlackPiece (Piece [][] chessBoard){
		int count=0;
		for(int i=0;i<8;i++){

			for(int j=0;j<8;j++){
				
				if(Character.isUpperCase(chessBoard[i][j].getPieceCharacter().charAt(0))){
					count++;				
				}
				
			}
		}
				return count;
		
	}

}



