package Pieces;

public class queen extends Piece{
	public queen (boolean b) 
	{
	this.iswhite=b;
	}
	public boolean getColor() {
		return iswhite;
	}
	@Override
	public String getPieceCharacter() {
		if (iswhite==false) {
			return "Q";
		} else {
			return "q";
		}
	}
}
