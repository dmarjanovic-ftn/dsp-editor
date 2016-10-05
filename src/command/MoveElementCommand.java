package command;

import java.util.ArrayList;

import model.Point;
import model.Schema;

public class MoveElementCommand implements Command {

	private Schema model;
	public ArrayList<Integer> movedComponents;
	public ArrayList<Point> oldPoints;
	public ArrayList<Point> newPoints;
	
	public ArrayList<Integer> movedLinks;
	public ArrayList<ArrayList<Point>> oldLinkPoints;
	public ArrayList<ArrayList<Point>> newLinkPoints;
	
	public MoveElementCommand(Schema model) {
		this.model = model;
	}
	
	@Override
	public void execute() {
		for (int i = 0; i < movedComponents.size(); ++i) {
			model.components.get(movedComponents.get(i)).setPoint(newPoints.get(i));
		}
		
		for (int i = 0; i < movedLinks.size(); ++i) {
			model.links.get(movedLinks.get(i)).points = newLinkPoints.get(i);
		}
		
		model.notifyAllObservers();

	}

	@Override
	public void unexecute() {
		for (int i = 0; i < movedComponents.size(); ++i) {
			model.components.get(movedComponents.get(i)).setPoint(oldPoints.get(i));
		}
		
		for (int i = 0; i < movedLinks.size(); ++i) {
			model.links.get(movedLinks.get(i)).points = oldLinkPoints.get(i);
		}
		
		model.notifyAllObservers();
	}

}
