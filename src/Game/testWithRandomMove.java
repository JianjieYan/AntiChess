/*
 * This main method calls test() i times; test() run the game until its end 1000 times
 * and return number of victories;
 */


package Game;
import bot.*;
import java.util.Random;
public class testWithRandomMove {
	public static void main(String[]args) {
		int temp=0;
		for(int i=0;i<20;i++) {
				temp=test();
				
				System.out.println("Bot win count: "+temp);
		}
		
		
	}
	public static int count=0;
	
	public static int test() {

        Random rand = new Random(); 
        
        //This section is used to find board and piece values
        
        //simpleBot.PAWN=rand.nextInt(5 + 5) - 5;
        //System.out.print(simpleBot.PAWN);
     
        
      
      /*  for(int j=0;j<64;j++) {
        	simpleBot.rook[j]=rand.nextInt(10 + 10) - 10;
    		System.out.print(simpleBot.rook[j]+",");
			
		}System.out.println();*/
		
        
		int count1=0;
		for(int i=0;i<100;i++) {
			count=0;
			board.fillBoard();
			Compile.chessBoard=board.board;
			while(gameFinish.finish(Compile.chessBoard)==false) {
				
				count++;
				
				String s=simpleBot.bestMove(Compile.chessBoard);
				if(s!="") {
					Compile.movePiece(s);
				}else {
					Compile.movePiece("0000");
				}

				if(possibleMoves.black(Compile.chessBoard)!="") {
					
					if(possibleMoves.forcedCaptureBlack(Compile.chessBoard)=="") {
					String [] move=possibleMoves.black(Compile.chessBoard).split(" ");
		
						
					if(move.length==0) {
						Compile.movePiece("0000");
					}else {
						
						Compile.movePiece(move[rand.nextInt(move.length)]);
					}
					
					}else {
			 
					String [] move=possibleMoves.forcedCaptureBlack(Compile.chessBoard).split(" ");
					if(move.length==0) {
						Compile.movePiece("0000");
					}else {
						Compile.movePiece(move[rand.nextInt(move.length)]);
					}
				}
					
				}
				else {
					Compile.movePiece("0000");
				}
			if(count>300) {
				break;
			}
			}
			if(gameFinish.countWhitePiece(Compile.chessBoard)==0) {
				count1++;
			}
			
		}
		return count1;
	}
}
