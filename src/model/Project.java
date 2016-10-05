package model;

import java.util.ArrayList;

public class Project {
	private String name;
	private String path;
	private boolean saved;

	public ArrayList<Schema> schemas;

	public Project() {
		this.saved = false;
	}

	public Project(String name, String path) {
		super();
		this.name = name;
		this.path = path;
		this.saved = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String newPath) {
		path = newPath;
	}

	public boolean getSaved() {
		return saved;
	}

	public void setSaved(boolean newSaved) {
		saved = newSaved;
	}

	public void save() {
		// TODO: implement
	}

	public void saveAs() {
		// TODO: implement
	}

	public ArrayList<Schema> getSchema() {
		if (schemas == null)
			schemas = new ArrayList<Schema>();
		return schemas;
	}

	public void addSchema(Schema newSchema) {
		if (newSchema == null)
			return;
		if (this.schemas == null)
			this.schemas = new ArrayList<Schema>();
		if (!this.schemas.contains(newSchema))
			this.schemas.add(newSchema);
	}

	public void removeSchema(Schema oldSchema) {
		if (oldSchema == null)
			return;
		if (this.schemas != null)
			if (this.schemas.contains(oldSchema))
				this.schemas.remove(oldSchema);
	}

	public void removeAllSchema() {
		if (schemas != null)
			schemas.clear();
	}
}