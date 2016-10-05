package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import model.Schema;
import view.Canvas;

public class Controller implements MouseListener, MouseMotionListener {
	private Schema schema;
	private Canvas view;

	public void setSchema(Schema s) {
		this.schema = s;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		schema.getStateContainer().getCurrentState().mouseClicked(e);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		schema.getStateContainer().getCurrentState().mouseDragged(e);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent e) {
		schema.getStateContainer().getCurrentState().mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		schema.getStateContainer().getCurrentState().mouseReleased(e);
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {}
	
	public Canvas getView() {
		return view;
	}

	public void setView(Canvas view) {
		this.view = view;
	}

	public Schema getSchema() {
		return schema;
	}

}