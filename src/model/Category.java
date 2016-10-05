package model;

import java.util.ArrayList;

public class Category {
	private String name;
	private String description;
	public ArrayList<Component> components;

	public Category() {
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
	}

	public void removeComponent(Component oldComponent) {
		if (oldComponent == null)
			return;
		if (this.components != null)
			if (this.components.contains(oldComponent))
				this.components.remove(oldComponent);
	}

	public void removeAllComponent() {
		if (components != null)
			components.clear();
	}

}