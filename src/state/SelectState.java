package state;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import model.Component;
import model.Schema;

public class SelectState extends State {

	public SelectState(Schema schema) {
		super(schema);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		model.selectedComponents.clear();
		Point point = e.getPoint();
		int position = model.getElementAtPosition(point);
		if(position != -1){
			Component element = model.getComponentAt(position);
			model.selectedComponents.add(element);
		}
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		Point point = e.getPoint();
		int position = model.getElementAtPosition(point);
		model.inMotion = position;
		model.lastPosition = point;
		model.startCorner = point;
		model.endCorner = point;

		if (position == -1) {
			model.selectedComponents.clear();
		} else if (e.getButton() == 1) {
			if (e.getClickCount() == 2) {
				Component element = model.getComponentAt(position);
				element.componentPainter.drawDialog(element);
			}
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Point point = e.getPoint();
		int position = model.getElementAtPosition(point);
		if (position != -1 && model.selectedComponents.size() != 0) {
			if( model.selectedComponents.contains(model.getComponentAt(position))){
				model.getStateContainer().setMoveState();
			}
			else{
				model.selectedComponents.clear();
			}
		} else {
			model.endCorner = point;
			model.notifyAllObservers();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Rectangle rect = new Rectangle(model.startCorner);
		rect.add(model.endCorner);

		for (Component comp : model.components) {
			model.Point p = comp.getPoint();
			if (rect.intersects(new Rectangle(p.getX(), p.getY(), 64, 64))) {
				model.selectedComponents.add(comp);
			}
		}

		model.endCorner = null;
		model.startCorner = null;
		model.notifyAllObservers();
	}

}
