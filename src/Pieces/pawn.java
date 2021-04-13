package Pieces;



public class pawn extends Piece{
	public pawn (boolean b) 
	{
	this.iswhite=b;
	}
	public boolean getColor() {
		return iswhite;
	}
	@Override
	public String getPieceCharacter() {
		if (iswhite==false) {
			return "P";
		} else {
			return "p";
		}
	}
}
