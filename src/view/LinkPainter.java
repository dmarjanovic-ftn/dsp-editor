package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import model.Point;

public class LinkPainter extends ElementPainter {

	public void draw(Graphics g, Point p1, Point p2) {
		Graphics2D g2d = (Graphics2D) g;

		g2d.setStroke(new BasicStroke(2f));
		g2d.setColor(new Color(67, 143, 198));
		
		g2d.drawLine((int) p1.getX(), (int) p1.getY(), (int) p2.getX(), (int) p2.getY());
	}

}
