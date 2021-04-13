package bot;
import Game.*;
import Pieces.*;
public class fenReader {

	public static Piece[][] fenToBoard(String fen){
		
		
		Piece chessBoard[][]=board.board;
		for(int i=0;i<64;i++) {
			chessBoard[i/8][i%8]=new space();
		}
		String [] temp=fen.split("(?!^)");
		/*for(int i=0;i<fen.length();i++) {
			System.out.println(temp[i]);
			
		}*/
		int n=0;
		for(int i=0;i<fen.length();i++) {
			
			
			if(temp[i].equals("p")) {
				
				chessBoard[n/8][n%8]=new pawn(true);
				n++;
			}
			else if(temp[i].equals("k")) {
				
				chessBoard[n/8][n%8]=new king(true);
				n++;
			}
			else if(temp[i].equals("/")) {	
			}
			
			else if(temp[i].equals("q")) {
				
				chessBoard[n/8][n%8]=new queen(true);
				n++;
			}
			
			else if(temp[i].equals("r")) {
				
				chessBoard[n/8][n%8]=new rook(true);
				n++;
			}
			
			else if(temp[i].equals("n")) {
				
				chessBoard[n/8][n%8]=new knight(true);
				n++;
			}
			else if(temp[i].equals("b")) {
				
				chessBoard[n/8][n%8]=new bishop(true);
				n++;
			}
			
			
			//Black
			else if(temp[i].equals("K")) {
				
				chessBoard[n/8][n%8]=new king(false);
				n++;
			}
			
			else if(temp[i].equals("P")) {
				
				chessBoard[n/8][n%8]=new pawn(false);
				n++;
			}
			
			else if(temp[i].equals("Q")) {
				
				chessBoard[n/8][n%8]=new queen(false);
				n++;
			}
			
			else if(temp[i].equals("R")) {
				
				chessBoard[n/8][n%8]=new rook(false);
				n++;
			}
			
			else if(temp[i].equals("N")) {
				
				chessBoard[n/8][n%8]=new knight(false);
				n++;
			}
			else if(temp[i].equals("B")) {
				
				chessBoard[n/8][n%8]=new bishop(false);
				n++;
			}
			else {
				n=n+Integer.parseInt(temp[i]);
				
			}
			
			
		}
		return chessBoard ;
	}
}
