package model;

import java.util.ArrayList;

import view.ComponentPainter;
import view.ElementPainter;

public abstract class Component {
	public enum Orientation {
		EAST, WEST, NORTH, SOUTH
	};

	public boolean status;
	
	protected String name;
	protected String description;
	protected Orientation orientation;
	protected Category category;

	public ArrayList<Terminal> terminals;
	public Dimension dimension;
	public Point point;

	public ComponentPainter componentPainter;

	public Component() {
		this.orientation = Orientation.EAST;
		this.terminals = new ArrayList<Terminal>();
		this.status = true;
	}

	public Component(String name, String description) {
		super();
		this.name = name;
		this.description = description;
		this.status = true;
	}
	
	public ComponentPainter getComponentPainter() {
		return componentPainter;
	}

	public void setComponentPainter(ElementPainter elementPainter) {
		this.componentPainter = (ComponentPainter) elementPainter;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String newDescription) {
		description = newDescription;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation newOrientation) {
		orientation = newOrientation;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public ArrayList<Terminal> getTerminals() {
		if (terminals == null)
			terminals = new ArrayList<Terminal>();
		return terminals;
	}

	public void addTerminal(Terminal newTerminal) {
		if (newTerminal == null)
			return;
		if (this.terminals == null)
			this.terminals = new ArrayList<Terminal>();
		if (!this.terminals.contains(newTerminal))
			this.terminals.add(newTerminal);
	}

	public void removeTerminal(Terminal oldTerminal) {
		if (oldTerminal == null)
			return;
		if (this.terminals != null)
			if (this.terminals.contains(oldTerminal))
				this.terminals.remove(oldTerminal);
	}

	public void removeAllTerminals() {
		if (terminals != null)
			terminals.clear();
	}
	
	
	public void update(String name){
		if(!name.equals("")){
			this.name = name;
		}
	}
}