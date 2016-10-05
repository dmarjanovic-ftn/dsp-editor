package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

import model.Component;

public abstract class ComponentPainter extends ElementPainter {

	public abstract void draw(Graphics g, model.Point p);
	
	public abstract void drawDialog(Component component);

	public boolean isComponentAt(Point p, Component component) {
		Rectangle2D rect = new Rectangle2D.Double();
		int x = (int) component.getPoint().getX();
		int y = (int) component.getPoint().getY();
		int w = 64;
		int h = 64;
		
		// Zamjena rotacije
		double r = 0;

		Point position;
		Dimension d;

		r /= Math.PI;

		if (Math.abs(r - Math.round(r)) < 0.1) {
			position = new Point(x, y);
			d = new Dimension(w, h);
		} else {
			position = new Point(x + w / 2 - h / 2, y + h / 2 - w / 2);
			d = new Dimension(h, w);
		}

		rect.setRect(position.getX(), position.getY(), d.getWidth(), d.getHeight());
		
		return rect.contains(p);
	}
}