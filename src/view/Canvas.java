package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.Component;
import model.Link;
import model.Schema;
import controller.Controller;

@SuppressWarnings("serial")
public class Canvas extends JPanel implements Observer {
	private Schema model;
	private enum SelectionPoints {EAST, WEST, SOUTH, NORTH, NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST };
	public Point2D lastPosition;
	
	
	public Canvas(Controller c) {
		this.addMouseListener(c);
		this.addMouseMotionListener(c);
		initialize();
	}

	public void initialize() {
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(3000, 10000));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		if (model.components != null) {
			for (Component comp : model.components) {
				if (comp.status == true) {
					comp.componentPainter.draw(g2, comp.getPoint());
				}
			}
		}
		
		for(Component comp: model.selectedComponents){
			if (comp.status == true)
				drawSelection(g2, comp);
		}
		
		if(model.startCorner != null && model.endCorner != null){
			((Graphics2D) g).setStroke(new BasicStroke((float) 1, BasicStroke.CAP_SQUARE,
					BasicStroke.JOIN_BEVEL, 1f, new float[] { 3f, 6f }, 0));
			Rectangle rect= new Rectangle(model.startCorner);
			rect.add(model.endCorner);
			g.drawRect(rect.x, rect.y, rect.width, rect.height);	
		}
		
		
		if (model.links != null) {
			for (Link link : model.links) {
				if (link.status == true) {
					for (int i = 0; i < link.points.size() - 1; ++i) {
						// model.Point pnt = link.points.get(i).get;
						link.linkPainter.draw(g2, new model.Point((int) link.points.get(i).getX(), (int) link.points.get(i).getY()), new model.Point((int) link.points.get(i+1).getX(), (int) link.points.get(i+1).getY()));
					}
				}
			}
		}
	}
	
	

	private Point2D getSelectPoint(Point2D topLeft, Dimension2D size,
			SelectionPoints handlePosition) {
		double x = 0, y = 0;


		if (handlePosition == SelectionPoints.NORTHWEST
				|| handlePosition == SelectionPoints.NORTH
				|| handlePosition == SelectionPoints.NORTHEAST) {
			y = topLeft.getY();
		}
		if (handlePosition == SelectionPoints.EAST || handlePosition == SelectionPoints.WEST) {
			y = topLeft.getY() + size.getHeight() / 2;
		}
		if (handlePosition == SelectionPoints.SOUTHWEST
				|| handlePosition == SelectionPoints.SOUTH
				|| handlePosition == SelectionPoints.SOUTHEAST) {
			y = topLeft.getY() + size.getHeight();
		}

		if (handlePosition == SelectionPoints.NORTHWEST || handlePosition == SelectionPoints.WEST
				|| handlePosition == SelectionPoints.SOUTHWEST) {
			x = topLeft.getX();
		}
		if (handlePosition == SelectionPoints.NORTH || handlePosition == SelectionPoints.SOUTH) {
			x = topLeft.getX() + size.getWidth() / 2;
		}

		if (handlePosition == SelectionPoints.NORTHEAST || handlePosition == SelectionPoints.EAST
				|| handlePosition == SelectionPoints.SOUTHEAST) {
			x = topLeft.getX() + size.getWidth();
		}

		return new Point2D.Double(x, y);

	}

	
	public void drawSelection(Graphics2D g, Component selected){
		g.setStroke(new BasicStroke((float) 1, BasicStroke.CAP_SQUARE,
				BasicStroke.JOIN_BEVEL, 1f, new float[] { 3f, 6f }, 0));
		g.setPaint(Color.BLACK);

		
		int x = (int) selected.getPoint().getX();
		int y = (int) selected.getPoint().getY();
		
		int w = 64;
		int h = 64;
		// Rotacija
		double r = 0;

		Point2D pos;
		Dimension d;

		r /= Math.PI;

		if (Math.abs(r - Math.round(r)) < 0.1) {
			pos = new Point(x, y);
			d = new Dimension(w, h);
		} else {
			pos = new Point(x + w / 2 - h / 2, y + h / 2 - w / 2);
			d = new Dimension(h, w);
		}

		g.drawRect((int) pos.getX(), (int) pos.getY(), d.width,d.height);

		Point2D selectPosition;

		for (SelectionPoints direction : SelectionPoints.values()) {
			double pointSize = 5;
			selectPosition = getSelectPoint(pos, d, direction);
			g.fill(new Rectangle2D.Double(selectPosition.getX() - pointSize / 2, selectPosition
					.getY() - pointSize / 2, pointSize, pointSize));
		}
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}

	public Schema getModel() {
		return model;
	}

	public void setModel(Schema model) {
		this.model = model;
	}
}
