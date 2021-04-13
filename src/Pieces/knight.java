package Pieces;

public class knight extends Piece{
	public knight (boolean b) 
	{
	this.iswhite=b;
	}
	public boolean getColor() {
		return iswhite;
	}
	@Override
	public String getPieceCharacter() {
		if (iswhite==false) {
			return "N";
		} else {
			return "n";
		}
	}
}

