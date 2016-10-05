package state;

import gui.Utility;
import gui.Window;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JScrollPane;

import command.MoveElementCommand;
import model.Component;
import model.Link;
import model.Schema;
import model.Terminal;
import view.Canvas;

public class MoveState extends State {
	private int move = -1;
	MoveElementCommand command;
	
	MoveState(Schema schema) {
		super(schema);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(move != 1) {
			JScrollPane scroll = (JScrollPane) Window.getInstance().tabbedPane.getSelectedComponent();
			if (scroll != null) {
				Canvas canv = (Canvas) scroll.getViewport().getView();
				canv.getModel().getStateContainer().setSelectState();
				canv.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
				
				command = new MoveElementCommand(canv.getModel());
				ArrayList<Integer> indexes = new ArrayList<Integer>();
				ArrayList<Integer> linkIndexes = new ArrayList<Integer>();
				ArrayList<model.Point> points = new ArrayList<model.Point>();
				ArrayList<ArrayList<model.Point>> linksPointsArrayList = new ArrayList<ArrayList<model.Point>>();
			
				for (Component c: model.selectedComponents) {
					points.add(new model.Point(c.point.getX(), c.point.getY()));
					
					for (Terminal term: c.terminals) {
						if (term.getConnected() == true) {
							
							ArrayList<model.Point> linkPoints = new ArrayList<model.Point>();
							
							for (Link lnk: model.links) {
								if (lnk.dest == term || lnk.src == term) {
									linkIndexes.add(model.links.indexOf(lnk));
									for (model.Point pt: lnk.points) {
										linkPoints.add(new model.Point((int) pt.getX(), (int) pt.getY()));
									}
									linksPointsArrayList.add(linkPoints);
								}
							}
						}
					}
					
					indexes.add(model.components.indexOf(c));
				}
				
				command.oldPoints = points;
				command.movedComponents = indexes;
				command.oldLinkPoints = linksPointsArrayList;
				command.movedLinks = linkIndexes;
				
			}
		}
		
		
		move = 1;
		
		Point2D mousePos = e.getPoint();
		
		for(Component comp : model.selectedComponents){
			model.Point p = comp.getPoint();
			Point2D newPosition = (Point2D)(new Point(p.getX(), p.getY()));
			newPosition.setLocation(newPosition.getX() + mousePos.getX() - model.lastPosition.getX(),
					newPosition.getY() + mousePos.getY() - model.lastPosition.getY()); 
			
			for (Terminal term: comp.terminals) {
				if (term.getConnected() == true) {
					for (Link lnk: model.links) {
						if (lnk.dest == term) {
							model.Point endPoint = new model.Point((int) newPosition.getX(), (int) newPosition.getY());
							endPoint.setX((int) endPoint.getX() + (int) term.getRelativePosition().getX());
							endPoint.setY((int) endPoint.getY() + (int) term.getRelativePosition().getY());

							lnk.points.remove(lnk.points.size() - 2);
							model.Point ptr = lnk.points.get(lnk.points.size() - 2);
							lnk.points.remove(lnk.points.size() - 1);
							for (model.Point newPt: Utility.getElbow(ptr, endPoint)) {
								lnk.points.add(newPt);
							}
						}
						
						if (lnk.src == term) {
							model.Point startPoint = new model.Point((int) newPosition.getX(), (int) newPosition.getY());
							startPoint.setX((int) startPoint.getX() + (int) term.getRelativePosition().getX());
							startPoint.setY((int) startPoint.getY() + (int) term.getRelativePosition().getY());

							model.Point ptr = lnk.points.get(2);
							
							int i = 1;
							lnk.points.set(0, startPoint);
							for (model.Point newPt: Utility.getElbow(startPoint, ptr)) {
								lnk.points.set(i++, newPt);
							}
						}
					}
				}
			}
			
			model.updatePosition(comp, newPosition);
		}
		
		model.lastPosition = mousePos;
	}
	
	public void mouseReleased(MouseEvent e){
		model.inMotion = -1;
		move = -1;
		
		ArrayList<model.Point> points = new ArrayList<model.Point>();
		ArrayList<ArrayList<model.Point>> linksPointsArrayList = new ArrayList<ArrayList<model.Point>>();
		for (Component c: model.selectedComponents) {
			points.add(new model.Point(c.point.getX(), c.point.getY()));
			
			for (Terminal term: c.terminals) {
				if (term.getConnected() == true) {
					
					ArrayList<model.Point> linkPoints = new ArrayList<model.Point>();
					
					for (Link lnk: model.links) {
						if (lnk.dest == term || lnk.src == term) {
							for (model.Point pt: lnk.points) {
								linkPoints.add(new model.Point((int) pt.getX(), (int) pt.getY()));
							}
							linksPointsArrayList.add(linkPoints);
						}
					}
				}
			}
		}
		
		command.newPoints = points;
		command.newLinkPoints = linksPointsArrayList;
		
		model.commands.addCommand(command);
		
		JScrollPane scroll = (JScrollPane) Window.getInstance().tabbedPane.getSelectedComponent();
		if (scroll != null) {
			Canvas canv = (Canvas) scroll.getViewport().getView();
			canv.getModel().getStateContainer().setSelectState();
			canv.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
		
		model.getStateContainer().setSelectState();
	}
}
