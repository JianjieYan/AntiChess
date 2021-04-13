package Pieces;

public class bishop extends Piece{
	public bishop (boolean b) 
	{
	this.iswhite=b;
	}
	public boolean getColor() {
		return iswhite;
	}
	@Override
	public String getPieceCharacter() {
		if (iswhite==false) {
			return "B";
		} else {
			return "b";
		}
	}
}
