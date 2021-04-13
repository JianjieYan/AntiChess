package Pieces;

public class king extends Piece{
	public king (boolean b) 
	{
	this.iswhite=b;
	}
	public boolean getColor() {
		return iswhite;
	}
	@Override
	public String getPieceCharacter() {
		if (iswhite==false) {
			return "K";
		} else {
			return "k";
		}
	}
}
