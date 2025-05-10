package edu.wm.cs.cs301.memorygame;

public class CharacterGamePiece implements GamePiece {
	private final Character symbol;
	private boolean visible;
	public CharacterGamePiece(char s) { //DONT CHANGE THIS LINE
		this.symbol = s; //DONT CHANGE THIS LINE
		this.visible = false;
	}
	@Override
	public Character getSymbol() {//DONT CHANGE THIS LINE
		
		return symbol;
	}
	@Override
	public void setVisible(boolean v) {//DONT CHANGE THIS LINE
		this.visible = v;
	}
	@Override
	public boolean isvisible() {//DONT CHANGE THIS LINE
		return visible;
	}
	@Override
	public boolean equals(GamePiece other) {//DONT CHANGE THIS LINE
		if (this == other) {
			return true;
		} else {
			return false;
		}
	}
	
}
