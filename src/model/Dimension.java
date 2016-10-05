package model;

public class Dimension {
	private int width;
	private int height;

	public Dimension() {
	}

	public Dimension(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int newWidth) {
		width = newWidth;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int newHeight) {
		height = newHeight;
	}
}