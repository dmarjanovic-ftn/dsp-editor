package model;

public class Terminal {
	public enum TerminalType {
		INPUT, OUTPUT
	};

	private int terminalNo;
	private TerminalType type;
	public boolean connected;
	private Point relativePosition;

	public Terminal() {
		this.connected = false;
	}

	public Terminal(int terminalNo, TerminalType type, Point relativePosition) {
		super();
		this.terminalNo = terminalNo;
		this.type = type;
		this.setRelativePosition(relativePosition);
		this.connected = false;
	}

	public int getTerminalNo() {
		return terminalNo;
	}

	public void setTerminalNo(int newTerminalNo) {
		terminalNo = newTerminalNo;
	}

	public TerminalType getType() {
		return type;
	}

	public void setType(TerminalType newType) {
		type = newType;
	}

	public boolean getConnected() {
		return connected;
	}

	public void setConnected(boolean newConnected) {
		connected = newConnected;
	}

	public Point getRelativePosition() {
		return relativePosition;
	}

	public void setRelativePosition(Point relativePosition) {
		this.relativePosition = relativePosition;
	}

}