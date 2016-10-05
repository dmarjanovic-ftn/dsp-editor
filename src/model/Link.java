package model;

import java.util.ArrayList;

import view.LinkPainter;

public class Link {
	public enum LineTypes {
		SOLID, DOTTED, DASH
	};

	private LineTypes linkType;
	public LinkPainter linkPainter;

	public Terminal src;
	public Terminal dest;
	public ArrayList<Point> points;
	
	public boolean status;

	public Link() {
		this.status = true;
	}

	
	public Link(LineTypes linkType, Terminal src, Terminal dest) {
		super();
		this.linkType = linkType;
		this.src = src;
		this.src.connected = true;
		this.dest = dest;
		this.dest.connected = true;
		this.status = true;
	}

	public LineTypes getLinkType() {
		return linkType;
	}

	public void setLinkType(LineTypes newLinkType) {
		linkType = newLinkType;
	}

	public void addSrc(Terminal source) {
		// TODO: implement
	}

	public void addDest(Terminal destination) {
		// TODO: implement
	}

	public void removeSrc(Terminal source) {
		// TODO: implement
	}

	public void removeDest(Terminal destination) {
		// TODO: implement
	}

	public ArrayList<Point> getPoints() {
		if (points == null)
			points = new ArrayList<Point>();
		return points;
	}

	public void addPoint(Point newPoint) {
		if (newPoint == null)
			return;
		if (this.points == null)
			this.points = new ArrayList<Point>();
		if (!this.points.contains(newPoint))
			this.points.add(newPoint);
	}

	public void removePoint(Point oldPoint) {
		if (oldPoint == null)
			return;
		if (this.points != null)
			if (this.points.contains(oldPoint))
				this.points.remove(oldPoint);
	}

	public void removeAllPoint() {
		if (points != null)
			points.clear();
	}


	public LinkPainter getLinkPainter() {
		return linkPainter;
	}


	public void setLinkPainter(LinkPainter linkPainter) {
		this.linkPainter = linkPainter;
	}
	
}