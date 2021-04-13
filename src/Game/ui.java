/*
 * Swing Ui for playing with bot;
 * Ui doesnt end itself whem game finish, only for testing;
 */
package Game;
import bot.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Pieces.pawn;
import Pieces.queen;
import Pieces.space; 
public class ui extends JPanel implements MouseListener, MouseMotionListener{
    static int mouseX, mouseY, newMouseX, newMouseY;
    static int squareSize=32;
    static int round=0;
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.yellow);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        for (int i=0;i<64;i+=2) {
            g.setColor(new Color(255,200,100));
            g.fillRect((i%8+(i/8)%2)*squareSize, (i/8)*squareSize, squareSize, squareSize);
            g.setColor(new Color(150,50,30));
            g.fillRect(((i+1)%8-((i+1)/8)%2)*squareSize, ((i+1)/8)*squareSize, squareSize, squareSize);
        }
        Image chessPiecesImage;
        chessPiecesImage=new ImageIcon("./ChessPieces.png").getImage();
        for (int i=0;i<64;i++) {
            int j=-1,k=-1;
            switch (Compile.chessBoard[i/8][i%8].getPieceCharacter()) {
                case "p": j=5; k=0;
                    break;
                case "P": j=5; k=1;
                    break;
                case "r": j=2; k=0;
                    break;
                case "R": j=2; k=1;
                    break;
                case "n": j=4; k=0;
                    break;
                case "N": j=4; k=1;
                    break;
                case "b": j=3; k=0;
                    break;
                case "B": j=3; k=1;
                    break;
                case "q": j=1; k=0;
                    break;
                case "Q": j=1; k=1;
                    break;
                case "k": j=0; k=0;
                    break;
                case "K": j=0; k=1;
                    break;
            }
            if (j!=-1 && k!=-1) {
                g.drawImage(chessPiecesImage, (i%8)*squareSize, (i/8)*squareSize, (i%8+1)*squareSize, (i/8+1)*squareSize, j*64, k*64, (j+1)*64, (k+1)*64, this);
            }
        }
        
    }
    @Override
    public void mouseMoved(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getX()<8*squareSize &&e.getY()<8*squareSize) {
            //if inside the board
            mouseX=e.getX();
            mouseY=e.getY();
          
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getX()<8*squareSize &&e.getY()<8*squareSize) {
            newMouseX=e.getX();
            newMouseY=e.getY();
            if (e.getButton()==MouseEvent.BUTTON1) {
                String dragMove;
                    dragMove=""+mouseY/squareSize+mouseX/squareSize+newMouseY/squareSize+newMouseX/squareSize+Compile.chessBoard[newMouseY/squareSize][newMouseX/squareSize].getPieceCharacter();
                
               
                	String userPosibilities=possibleMoves.black(Compile.chessBoard);
                	String userPosibilities2=possibleMoves.white(Compile.chessBoard);
                	String temp=possibleMoves.forcedCaptureBlack(Compile.chessBoard);
                	String temp2=possibleMoves.forcedCaptureWhite(Compile.chessBoard);
                	if(round%2==0){//Black Moves
                		System.out.println(userPosibilities);

                		System.out.println(temp);
            			String [] drag=dragMove.split("(?!^)");
                		if(temp==""&&userPosibilities.contains(dragMove)) {
                			Compile.movePiece(dragMove);
                            round++;
                            //pawn promotion
                        
                        
                			}
                		else if(temp!=""&&temp.contains(dragMove)) {
                			Compile.movePiece(dragMove);
                            round++;
                			
                		}
                		//pawn promotion
                		if(Compile.chessBoard[Integer.parseInt(drag[2])][Integer.parseInt(drag[3])].getPieceCharacter().equals("P")&&Integer.parseInt(drag[2])==0) {

                			Compile.chessBoard[Integer.parseInt(drag[2])][Integer.parseInt(drag[3])]=new queen(false);
                		}
            			if(Compile.chessBoard[Integer.parseInt(drag[2])][Integer.parseInt(drag[3])].getPieceCharacter().equals("P")&&Integer.parseInt(drag[2])==7) {

                			Compile.chessBoard[Integer.parseInt(drag[2])][Integer.parseInt(drag[3])]=new queen(false);
                		}
            			
                		
                	}
                	//PVB;	
                	else if(round%2!=0) {
            			String s=minMax.bestMove(Compile.chessBoard);
            			Compile.movePiece(s);
            			System.out.println(s);
            			//Pawn promotion	
            			String [] drag=s.split("(?!^)");
                		if(Compile.chessBoard[Integer.parseInt(drag[2])][Integer.parseInt(drag[3])].getPieceCharacter().equals("p")&&Integer.parseInt(drag[2])==7) {
                			Compile.chessBoard[Integer.parseInt(drag[2])][Integer.parseInt(drag[3])]=new queen(true);
                		}
                		if(Compile.chessBoard[Integer.parseInt(drag[2])][Integer.parseInt(drag[3])].getPieceCharacter().equals("P")&&Integer.parseInt(drag[2])==0) {
                			Compile.chessBoard[Integer.parseInt(drag[2])][Integer.parseInt(drag[3])]=new queen(false);
                		}
            			round++;
            		}
               
                	else if(round%2!=0){//White Moves
                        //if valid move
                        String [] drag=dragMove.split("(?!^)");

                		if(temp2==""&&userPosibilities2.contains(dragMove)) {

                   		 Compile.movePiece(dragMove);
                            round++;
                            
                            
                		
                			}
                		else if(temp2!=""&&temp2.contains(dragMove)) {
                			Compile.movePiece(dragMove);
                			round++;
                		}
                		//pawn promotion
                		if(Compile.chessBoard[Integer.parseInt(drag[2])][Integer.parseInt(drag[3])].getPieceCharacter().equals("p")&&Integer.parseInt(drag[2])==7) {
                			
                			Compile.chessBoard[Integer.parseInt(drag[2])][Integer.parseInt(drag[3])]=new queen(true);
                			
                		}if(Compile.chessBoard[Integer.parseInt(drag[2])][Integer.parseInt(drag[3])].getPieceCharacter().equals("P")&&Integer.parseInt(drag[2])==7) {

                			Compile.chessBoard[Integer.parseInt(drag[2])][Integer.parseInt(drag[3])]=new queen(true);
                		}
                	
                	}
            }    	
            
            repaint();   
            
            }
        }
        
 
    
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseDragged(MouseEvent e) {
    	
    }
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}