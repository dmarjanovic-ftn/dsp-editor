package state;

import java.awt.event.MouseEvent;

import model.Schema;

public abstract class State {
	
	protected Schema model;
	
	State (Schema schema) {
		this.model = schema;
	}
	
	public void mousePressed(MouseEvent e) {}

	public void mouseDragged(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseMoved(MouseEvent e) {}

	public void mouseClicked(MouseEvent e) {}

	public Schema getModel() {
		return model;
	}

	public void setModel(Schema model) {
		this.model = model;
	}

}