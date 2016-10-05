package model;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Observable;

import command.CommandManager;

import state.StateContainer;

public class Schema extends Observable {
	private String name;
	private boolean valid;
	private StateContainer stateContainer;

	public ArrayList<Component> components;
	public ArrayList<Component> selectedComponents;
	public ArrayList<Link> links;
	public Point2D lastPosition;
	public int inMotion;
	public Point startCorner;
	public Point endCorner;
	
	public CommandManager commands = new CommandManager();
	
	public Schema() {
		this.stateContainer = new StateContainer(this);
		this.components = new ArrayList<Component>();
		this.links = new ArrayList<Link>();
		this.selectedComponents = new ArrayList<Component>();
	}

	public Schema(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

	public boolean getValid() {
		return valid;
	}

	public void setValid(boolean newValid) {
		valid = newValid;
	}

	public StateContainer getStateContainer() {
		return stateContainer;
	}

	public void setStateContainer(StateContainer stateContainer) {
		this.stateContainer = stateContainer;
	}
	
	public void validate() {
		// TODO: implement
	}

	public void generateCode() {
		// TODO: implement
	}

	public void compilation() {
		// TODO: implement
	}

	public ArrayList<Component> getComponents() {
		if (components == null)
			components = new ArrayList<Component>();
		return components;
	}

	public void addComponent(Component newComponent) {
		if (newComponent == null)
			return;
		if (this.components == null)
			this.components = new ArrayList<Component>();
		if (!this.components.contains(newComponent))
			this.components.add(newComponent);
			this.selectedComponents.clear();
			this.selectedComponents.add(newComponent);
			setChanged();
			notifyObservers();
	}

	public void removeComponent(Component oldComponent) {
		if (oldComponent == null)
			return;
		if (this.components != null)
			if (this.components.contains(oldComponent))
				this.components.remove(oldComponent);
				setChanged();
				notifyObservers();	
	}

	public void removeAllComponent() {
		if (components != null)
			components.clear();
			setChanged();
			notifyObservers();
	}
	
	public void addLink(Link newLink) {
		setChanged();
		notifyObservers();
		if (newLink == null)
			return;
		if (this.links == null)
			this.links = new ArrayList<Link>();
		if (!this.links.contains(newLink))
			this.links.add(newLink);
	}

	private int getElementsCount() {
		if(components!=null){
			return components.size();
		}
		return 0;
	}

	public Component getComponentAt(int index) {
		return components.get(index);
	}

	public int getElementAtPosition(java.awt.Point point) {
		for (int i = getElementsCount() - 1; i >= 0; i--) {
			Component component = getComponentAt(i);
			if (component.getComponentPainter().isComponentAt(point, component)) {
				return i;
			}
		}
		return -1;
	}
	
	public void notifyAllObservers() {
		setChanged();
		notifyObservers();
	}
	
	public void updatePosition(Component comp, Point2D point){
		model.Point p = comp.getPoint();
		p.setX((int) point.getX());
		p.setY((int) point.getY());
		setChanged();
		notifyObservers();
	}

}