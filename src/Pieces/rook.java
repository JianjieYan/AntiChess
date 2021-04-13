package Pieces;

public class rook extends Piece{
	public rook (boolean b) 
	{
	this.iswhite=b;
	}
	public boolean getColor() {
		return iswhite;
	}
	@Override
	public String getPieceCharacter() {
		if (iswhite==false) {
			return "R";
		} else {
			return "r";
		}
	}
}
