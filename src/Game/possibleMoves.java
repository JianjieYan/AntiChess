/*
 * Contains various methods:
 * White: return possible moves for White pieces
 * Black: return possible moves for Black pieces
 * forcedCaptureBlack: return forced capture for Black player
 * forcedCaptureWhite: return forced capture for White player
 */
package Game;
import Pieces.*;
public class possibleMoves {
	
	public static String white(Piece[][]chessBoard) {
	      String list="";
	      for (int i=0; i<64; i++) {
	          switch (chessBoard[i/8][i%8].getPieceCharacter()) {
	              case "r": list+=posibler(i,chessBoard);
	                  break;
	              case "n": list+=posiblek(i,chessBoard);
	                  break;
	              case "b": list+=posibleb(i,chessBoard);
	                  break;
	              case "q": list+=posibleq(i,chessBoard);
	                  break;
	              case "p": list+=posiblep(i,chessBoard);
              break;
	              case "k": list+=posiblea(i,chessBoard);
	                break;
	             
	                 
	          }
	      }
	      return list;
	  }
	
	public static String black(Piece [][]chessBoard) {
	      String list="";
	      for (int i=0; i<64; i++) {
	          switch (chessBoard[i/8][i%8].getPieceCharacter()) {
	              case "R": list+=posibleR(i,chessBoard);
	                  break;
	              case "N": list+=posibleK(i,chessBoard);
	                  break;
	              case "B": list+=posibleB(i,chessBoard);
	                  break;
	              case "Q": list+=posibleQ(i,chessBoard);
	                  break;
	              case "P": list+=posibleP(i,chessBoard);
              break;
	              case "K": list+=posibleA(i,chessBoard);
                break;
	             
	                 
	          }
	      }
	      
			
	      return list;
	  }
	
	public static String forcedCaptureWhite(Piece [][] board){
		
			String movements=white(board);
		
			String movements2[]=movements.split(" ");
			
			String movements3="";

			for(int i=0;i<movements2.length;i++){

				if(!movements2[i].contains("-")){
					movements3+=movements2[i]+" ";
					}
			}
			return movements3;
	}
	
	public static String forcedCaptureBlack(Piece[][]board){
		//check if there is forced movement
			String movements=black(board);
			
			String movements2[]=movements.split(" ");
				
			String movements3="";

			for(int i=0;i<movements2.length;i++){

				if(!movements2[i].contains("-")){
					movements3+=movements2[i]+" ";
		}
		}
			return movements3;
			
			}
	
	public static String posibleP(int i,Piece [][]chessBoard) {
		String list="";
      int r=i/8, c=i%8;
      
      
      for (int j=-1; j<=1; j+=2) {
    	  
    	  
    	  try {//capture
              if (r==3&&chessBoard[r][c+j].getPieceCharacter().equals("p")) {
            	  
            	
            		  if(Compile.historyMovesWhite.get(Compile.historyMovesWhite.size()-1).contains(""+(r-2)+(c+j)+r+(c+j)+"-"))
            			  list=list+r+c+(r-1)+(c+j)+"-"+" ";
            	
            	  
            	   
              }
          } catch (Exception e) {}
    	  
    	  
          try {//capture
              if (Character.isLowerCase(chessBoard[r-1][c+j].getPieceCharacter().charAt(0))) {
               
                      list=list+r+c+(r-1)+(c+j)+chessBoard[r-1][c+j].getPieceCharacter()+" ";
                  
              }
          } catch (Exception e) {}
          
      }
      try {//move one up
          if ("-".equals(chessBoard[r-1][c].getPieceCharacter())) {
             
                  list=list+r+c+(r-1)+c+chessBoard[r-1][c].getPieceCharacter()+" ";
              
          }
      } catch (Exception e) {}
      
      try {//move two up
          if ("-".equals(chessBoard[r-1][c].getPieceCharacter()) && "-".equals(chessBoard[r-2][c].getPieceCharacter()) && i>=48 ) {
             

                  list=list+r+c+(r-2)+c+chessBoard[r-2][c].getPieceCharacter()+" ";
          }
      } catch (Exception e) {}
      
      return list;
      
  }
	
	public static String posibleA(int i,Piece [][]chessBoard) {
        String list="", oldPiece;
        int r=i/8, c=i%8;
        for (int j=0; j<9; j++) {
            if (j!=4) {
                try {
                    if (Character.isLowerCase(chessBoard[r-1+j/3][c-1+j%3].getPieceCharacter().charAt(0)) || "-".equals(chessBoard[r-1+j/3][c-1+j%3].getPieceCharacter())) {
                        oldPiece=chessBoard[r-1+j/3][c-1+j%3].getPieceCharacter();
                     
                        
                            list=list+r+c+(r-1+j/3)+(c-1+j%3)+oldPiece+" ";
                        
                        
                    }
                } catch (Exception e) {}
            }
        }
      
        return list;
    }
	  public static String posibleR(int i,Piece [][]chessBoard) {
	      String list="";
	      int r=i/8, c=i%8;
	      int temp=1;
	      for (int j=-1; j<=1; j+=2) {
	          try {
	              while("-".equals(chessBoard[r][c+temp*j].getPieceCharacter()))
	              {
	                  
	                 
	                      list=list+r+c+r+(c+temp*j)+chessBoard[r][c+temp*j].getPieceCharacter()+" ";
	                  
	           
	                  temp++;
	              }
	              if (Character.isLowerCase(chessBoard[r][c+temp*j].getPieceCharacter().charAt(0))) {
	      
	                      list=list+r+c+r+(c+temp*j)+chessBoard[r][c+temp*j].getPieceCharacter()+" ";
	              
	              }
	          } catch (Exception e) {}
	          temp=1;
	          try {
	              while("-".equals(chessBoard[r+temp*j][c].getPieceCharacter()))
	              {
	                  
	                
	                      list=list+r+c+(r+temp*j)+c+chessBoard[r+temp*j][c].getPieceCharacter()+" ";
	                  
	               
	                  temp++;
	              }
	              if (Character.isLowerCase(chessBoard[r+temp*j][c].getPieceCharacter().charAt(0))) {
	                
	                
	                      list=list+r+c+(r+temp*j)+c+chessBoard[r+temp*j][c].getPieceCharacter()+" ";
	                  
	                 
	              }
	          } catch (Exception e) {}
	          temp=1;
	      }
	      return list;
	  }
	  public static String posibleK(int i,Piece [][]chessBoard) {
	      String list="";
	      int r=i/8, c=i%8;
	      for (int j=-1; j<=1; j+=2) {
	          for (int k=-1; k<=1; k+=2) {
	              try {
	                  if (Character.isLowerCase(chessBoard[r+j][c+k*2].getPieceCharacter().charAt(0)) || "-".equals(chessBoard[r+j][c+k*2].getPieceCharacter())) {
	                      
	                    
	                          list=list+r+c+(r+j)+(c+k*2)+chessBoard[r+j][c+k*2].getPieceCharacter()+" ";
	                    
	                  }
	              } catch (Exception e) {}
	              try {
	                  if (Character.isLowerCase(chessBoard[r+j*2][c+k].getPieceCharacter().charAt(0)) || "-".equals(chessBoard[r+j*2][c+k].getPieceCharacter())) {
	                     
	                    
	                          list=list+r+c+(r+j*2)+(c+k)+chessBoard[r+j*2][c+k].getPieceCharacter()+" ";
	                      
	                  
	                  }
	              } catch (Exception e) {}
	          }
	      }
	      return list;
	  }
	  public static String posibleB(int i,Piece [][]chessBoard) {
	      String list="";
	      int r=i/8, c=i%8;
	      int temp=1;
	      for (int j=-1; j<=1; j+=2) {
	          for (int k=-1; k<=1; k+=2) {
	              try {
	                  while("-".equals(chessBoard[r+temp*j][c+temp*k].getPieceCharacter()))
	                  {
	                      
	                   
	                          list=list+r+c+(r+temp*j)+(c+temp*k)+chessBoard[r+temp*j][c+temp*k].getPieceCharacter()+" ";
	                     
	                      temp++;
	                  }
	                  if (Character.isLowerCase(chessBoard[r+temp*j][c+temp*k].getPieceCharacter().charAt(0))) {
	                   
	                     
	                          list=list+r+c+(r+temp*j)+(c+temp*k)+chessBoard[r+temp*j][c+temp*k].getPieceCharacter()+" ";
	                      
	                  }
	              } catch (Exception e) {}
	              temp=1;
	          }
	      }
	      return list;
	  }
	  public static String posibleQ(int i,Piece [][]chessBoard) {
	      String list="";
	      int r=i/8, c=i%8;
	      int temp=1;
	      for (int j=-1; j<=1; j++) {
	          for (int k=-1; k<=1; k++) {
	              if (j!=0 || k!=0) {
	                  try {
	                      while("-".equals(chessBoard[r+temp*j][c+temp*k].getPieceCharacter()))
	                      {
	                         
	                        
	                              list=list+r+c+(r+temp*j)+(c+temp*k)+chessBoard[r+temp*j][c+temp*k].getPieceCharacter()+" ";
	                          
	                          
	                          temp++;
	                      }
	                      if (Character.isLowerCase(chessBoard[r+temp*j][c+temp*k].getPieceCharacter().charAt(0))) {
	                          
	                              list=list+r+c+(r+temp*j)+(c+temp*k)+chessBoard[r+temp*j][c+temp*k].getPieceCharacter()+" ";
	                          
	                        
	                      }
	                  } catch (Exception e) {}
	                  temp=1;
	              }
	          }
	      }
	      return list;
	  }
	
	public static String posiblep(int i,Piece[][]chessBoard) {
		String list="";
    int r=i/8, c=i%8;
    
    
    
   
    
    for (int j=-1; j<=1; j+=2) {
    	
    	 
  	  try {//capture
            if (r==4&&chessBoard[r][c+j].getPieceCharacter().equals("P")) {
          	  
          	
          		  if(Compile.historyMovesBlack.get(Compile.historyMovesBlack.size()-1).contains(""+(r+2)+(c+j)+r+(c+j)+"s"))
          			  list=list+r+c+(r+1)+(c+j)+"-"+" ";
          	
          	  
          	   
            }
        } catch (Exception e) {}
  	  
  	  
    	 try {//capture
             if (r==4&&chessBoard[r][c+j].getPieceCharacter().equals("P")) {
           	  if(Compile.historyMovesBlack.contains((r+2)+(c+j)+r+(c+j)+"s")==true) {
                 list=list+r+c+(r+1)+(c+j)+"e"+" ";
           	  }
             }
         } catch (Exception e) {}
        try {//capture
            if (Character.isUpperCase(chessBoard[r+1][c+j].getPieceCharacter().charAt(0))) {
             
                    list=list+r+c+(r+1)+(c+j)+chessBoard[r+1][c+j].getPieceCharacter()+" ";
                
            }
        } catch (Exception e) {}
        
    }
    try {//move one wod
        if ("-".equals(chessBoard[r+1][c].getPieceCharacter())) {
           
                list=list+r+c+(r+1)+c+chessBoard[r+1][c].getPieceCharacter()+" ";
            
        }
    } catch (Exception e) {}
    
    try {//move two up
        if ("-".equals(chessBoard[r+1][c].getPieceCharacter()) && "-".equals(chessBoard[r+2][c].getPieceCharacter())  && i<16) {
           

                list=list+r+c+(r+2)+c+chessBoard[r+2][c].getPieceCharacter()+" ";
        }
    } catch (Exception e) {}
    
    
    
    
    return list;
    
}
	public static String posiblea(int i,Piece[][]chessBoard) {
      String list="", oldPiece;
      int r=i/8, c=i%8;
      for (int j=0; j<9; j++) {
          if (j!=4) {
              try {
                  if (Character.isUpperCase(chessBoard[r-1+j/3][c-1+j%3].getPieceCharacter().charAt(0)) || "-".equals(chessBoard[r-1+j/3][c-1+j%3].getPieceCharacter())) {
                      oldPiece=chessBoard[r-1+j/3][c-1+j%3].getPieceCharacter();
                   
                      
                          list=list+r+c+(r-1+j/3)+(c-1+j%3)+oldPiece+" ";
                      
                      
                  }
              } catch (Exception e) {}
          }
      }
    
      return list;
  }
	  public static String posibler(int i,Piece[][]chessBoard) {
	      String list="";
	      int r=i/8, c=i%8;
	      int temp=1;
	      for (int j=-1; j<=1; j+=2) {
	          try {
	              while("-".equals(chessBoard[r][c+temp*j].getPieceCharacter()))
	              {
	                  
	                 
	                      list=list+r+c+r+(c+temp*j)+chessBoard[r][c+temp*j].getPieceCharacter()+" ";
	                  
	           
	                  temp++;
	              }
	              if (Character.isUpperCase(chessBoard[r][c+temp*j].getPieceCharacter().charAt(0))) {
	      
	                      list=list+r+c+r+(c+temp*j)+chessBoard[r][c+temp*j].getPieceCharacter()+" ";
	              
	              }
	          } catch (Exception e) {}
	          temp=1;
	          try {
	              while("-".equals(chessBoard[r+temp*j][c].getPieceCharacter()))
	              {
	                  
	                
	                      list=list+r+c+(r+temp*j)+c+chessBoard[r+temp*j][c].getPieceCharacter()+" ";
	                  
	               
	                  temp++;
	              }
	              if (Character.isUpperCase(chessBoard[r+temp*j][c].getPieceCharacter().charAt(0))) {
	                
	                
	                      list=list+r+c+(r+temp*j)+c+chessBoard[r+temp*j][c].getPieceCharacter()+" ";
	                  
	                 
	              }
	          } catch (Exception e) {}
	          temp=1;
	      }
	      return list;
	  }
	  public static String posiblek(int i,Piece[][]chessBoard) {
	      String list="";
	      int r=i/8, c=i%8;
	      for (int j=-1; j<=1; j+=2) {
	          for (int k=-1; k<=1; k+=2) {
	              try {
	                  if (Character.isUpperCase(chessBoard[r+j][c+k*2].getPieceCharacter().charAt(0)) || "-".equals(chessBoard[r+j][c+k*2].getPieceCharacter())) {
	                      
	                    
	                          list=list+r+c+(r+j)+(c+k*2)+chessBoard[r+j][c+k*2].getPieceCharacter()+" ";
	                    
	                  }
	              } catch (Exception e) {}
	              try {
	                  if (Character.isUpperCase(chessBoard[r+j*2][c+k].getPieceCharacter().charAt(0)) || "-".equals(chessBoard[r+j*2][c+k].getPieceCharacter())) {
	                     
	                    
	                          list=list+r+c+(r+j*2)+(c+k)+chessBoard[r+j*2][c+k].getPieceCharacter()+" ";
	                      
	                  
	                  }
	              } catch (Exception e) {}
	          }
	      }
	      return list;
	  }
	  public static String posibleb(int i,Piece[][]chessBoard) {
	      String list="";
	      int r=i/8, c=i%8;
	      int temp=1;
	      for (int j=-1; j<=1; j+=2) {
	          for (int k=-1; k<=1; k+=2) {
	              try {
	                  while("-".equals(chessBoard[r+temp*j][c+temp*k].getPieceCharacter()))
	                  {
	                      
	                   
	                          list=list+r+c+(r+temp*j)+(c+temp*k)+chessBoard[r+temp*j][c+temp*k].getPieceCharacter()+" ";
	                     
	                      temp++;
	                  }
	                  if (Character.isUpperCase(chessBoard[r+temp*j][c+temp*k].getPieceCharacter().charAt(0))) {
	                   
	                     
	                          list=list+r+c+(r+temp*j)+(c+temp*k)+chessBoard[r+temp*j][c+temp*k].getPieceCharacter()+" ";
	                      
	                  }
	              } catch (Exception e) {}
	              temp=1;
	          }
	      }
	      return list;
	  }
	  public static String posibleq(int i,Piece[][]chessBoard) {
	      String list="";
	      int r=i/8, c=i%8;
	      int temp=1;
	      for (int j=-1; j<=1; j++) {
	          for (int k=-1; k<=1; k++) {
	              if (j!=0 || k!=0) {
	                  try {
	                      while("-".equals(chessBoard[r+temp*j][c+temp*k].getPieceCharacter()))
	                      {
	                         
	                        
	                              list=list+r+c+(r+temp*j)+(c+temp*k)+chessBoard[r+temp*j][c+temp*k].getPieceCharacter()+" ";
	                          
	                          
	                          temp++;
	                      }
	                      if (Character.isUpperCase(chessBoard[r+temp*j][c+temp*k].getPieceCharacter().charAt(0))) {
	                          
	                              list=list+r+c+(r+temp*j)+(c+temp*k)+chessBoard[r+temp*j][c+temp*k].getPieceCharacter()+" ";
	                          
	                        
	                      }
	                  } catch (Exception e) {}
	                  temp=1;
	              }
	          }
	      }
	      return list;
	  }
	

}
