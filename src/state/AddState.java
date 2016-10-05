package state;

import gui.Utility;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import command.AddElementCommand;
import model.Component;
import model.GenAdder;
import model.GenAnd;
import model.GenGain;
import model.GenIntegrator;
import model.GenOr;
import model.GenProbe;
import model.Link;
import model.Schema;
import model.SourceConstant;
import model.SourceSine;
import model.Terminal;
import model.Terminal.TerminalType;
import view.ElementPainter;
import view.GenAdderPainter;
import view.GenAndPainter;
import view.GenGainPainter;
import view.GenIntegratorPainter;
import view.GenOrPainter;
import view.GenProbePainter;
import view.LinkPainter;
import view.SourceConstanPainter;
import view.SourceSinPainter;

public class AddState extends State {
	private Map<Class<?>, ElementPainter> painters;
	
	private Link link;
	private boolean linkStarted;

	public enum ComponentType {ADDER, INTEGRATOR, SINE, CONSTATNT, AND, OR, GAIN, PROBE, CONNECTION};
	private ComponentType activeButton;
	
	AddState(Schema schema) {
		super(schema);
		initializePainters();
	}
	
	private void initializePainters() {
		painters = new HashMap<Class<?>, ElementPainter>();
		painters.put(GenAdder.class, new GenAdderPainter());
		painters.put(GenIntegrator.class, new GenIntegratorPainter());
		painters.put(SourceSine.class, new SourceSinPainter());
		painters.put(SourceConstant.class, new SourceConstanPainter());
		painters.put(GenAnd.class, new GenAndPainter());
		painters.put(GenOr.class, new GenOrPainter());
		painters.put(GenGain.class, new GenGainPainter());
		painters.put(GenProbe.class, new GenProbePainter());
		painters.put(Link.class, new LinkPainter());
	}

	public ComponentType getActiveButton() {
		return activeButton;
	}

	public void setActiveButton(ComponentType activeButton) {
		this.activeButton = activeButton;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		switch(activeButton){
			case ADDER: {
				Point p = e.getPoint();
				ArrayList<model.Point> points = new ArrayList<model.Point>();
				points.add(new model.Point((int) p.getX(), (int) p.getY()));
				AddElementCommand command = new AddElementCommand(model, points, ComponentType.ADDER, painters.get(GenAdder.class));
				model.commands.addCommand(command);

				break;
			}
			
			case INTEGRATOR: {
				Point p = e.getPoint();
				ArrayList<model.Point> points = new ArrayList<model.Point>();
				points.add(new model.Point((int) p.getX(), (int) p.getY()));
				AddElementCommand command = new AddElementCommand(model, points, ComponentType.INTEGRATOR, painters.get(GenIntegrator.class));
				model.commands.addCommand(command);

				break;
			}	
			
			case SINE: {
				Point p = e.getPoint();
				ArrayList<model.Point> points = new ArrayList<model.Point>();
				points.add(new model.Point((int) p.getX(), (int) p.getY()));
				AddElementCommand command = new AddElementCommand(model, points, ComponentType.SINE, painters.get(SourceSine.class));
				model.commands.addCommand(command);
				
				break;
			}
			
			case CONSTATNT: {
				Point p = e.getPoint();
				ArrayList<model.Point> points = new ArrayList<model.Point>();
				points.add(new model.Point((int) p.getX(), (int) p.getY()));
				AddElementCommand command = new AddElementCommand(model, points, ComponentType.CONSTATNT, painters.get(SourceConstant.class));
				model.commands.addCommand(command);
				
				break;
			}
			
			case AND: {
				Point p = e.getPoint();
				ArrayList<model.Point> points = new ArrayList<model.Point>();
				points.add(new model.Point((int) p.getX(), (int) p.getY()));
				AddElementCommand command = new AddElementCommand(model, points, ComponentType.AND, painters.get(GenAnd.class));
				model.commands.addCommand(command);
				
				break;
			}
			
			case OR: {
				Point p = e.getPoint();
				ArrayList<model.Point> points = new ArrayList<model.Point>();
				points.add(new model.Point((int) p.getX(), (int) p.getY()));
				AddElementCommand command = new AddElementCommand(model, points, ComponentType.OR, painters.get(GenOr.class));
				model.commands.addCommand(command);
				
				break;
			}
			
			case GAIN: {
				Point p = e.getPoint();
				ArrayList<model.Point> points = new ArrayList<model.Point>();
				points.add(new model.Point((int) p.getX(), (int) p.getY()));
				AddElementCommand command = new AddElementCommand(model, points, ComponentType.GAIN, painters.get(GenGain.class));
				model.commands.addCommand(command);
				
				break;
			}
			
			case PROBE:{
				Point p = e.getPoint();
				ArrayList<model.Point> points = new ArrayList<model.Point>();
				points.add(new model.Point((int) p.getX(), (int) p.getY()));
				AddElementCommand command = new AddElementCommand(model, points, ComponentType.PROBE, painters.get(GenProbe.class));
				model.commands.addCommand(command);
				
				break;
			}
			
			case CONNECTION: {
				if (e.getButton() == MouseEvent.BUTTON3) {
					if (linkStarted == true) {
						linkStarted = false;
						model.links.get(model.links.size() - 1).src.setConnected(false);
						model.links.remove(model.links.size() - 1);
						model.notifyAllObservers();
					}		
					return;
				}
				
				Point p = e.getPoint();
				boolean a = true;
				
				int position = model.getElementAtPosition(p);
				
				if (position != -1 && !linkStarted) {
					
					boolean q = false;
					Component comp = model.components.get(position);
					for (Terminal term: comp.terminals) {
						if (term.getType() == TerminalType.OUTPUT && term.getConnected() == false) {
							q = true;
							break;
						}
					}
					
					if (q) {
						a = false;
	
						linkStarted = true;
						link = new Link();
						link.setLinkPainter(new LinkPainter());
						link.points = new ArrayList<model.Point>();
						model.addLink(link);
						model.Point pt = new model.Point((int) comp.getPoint().getX(), (int) comp.getPoint().getY());
						for (Terminal term: comp.terminals) {
							if (term.getType() == TerminalType.OUTPUT && term.getConnected() == false) {
								term.setConnected(true);
								model.links.get(model.links.size() - 1).src = term;
								pt.setX((int) pt.getX() + (int) term.getRelativePosition().getX());
								pt.setY((int) pt.getY() + (int) term.getRelativePosition().getY());
							}
						}
						link.points.add(pt);
						model.addLink(link);
					}
				}
				
				if (linkStarted && position == -1) {
					model.Point pt = new model.Point((int) p.getX(), (int) p.getY());
					ArrayList<model.Point> points = Utility.getElbow(link.points.get(link.points.size() - 1), pt);
					for (model.Point pts: points) {
						link.addPoint(pts);
						model.links.get(model.links.size()-1).addPoint(pts);
					}
					model.notifyAllObservers();
				}
				
				if (position != -1 && linkStarted && a) {
					Component comp = model.components.get(position);
					
					boolean q = false;
					for (Terminal term: comp.terminals) {
						if (term.getType() == TerminalType.INPUT && term.getConnected() == false) {
							q = true;
							break;
						}
					}
							
					if (q) {
						linkStarted = false;
						model.Point pt = new model.Point((int) comp.getPoint().getX(), (int) comp.getPoint().getY());
						for (Terminal term: comp.terminals) {
							if (term.getType() == TerminalType.INPUT && term.getConnected() == false) {
								term.setConnected(true);
								pt.setX((int) pt.getX() + (int) term.getRelativePosition().getX());
								pt.setY((int) pt.getY() + (int) term.getRelativePosition().getY());
								model.links.get(model.links.size() - 1).dest = term;
								break;
							}
						}
	
						ArrayList<model.Point> points = Utility.getElbow(link.points.get(link.points.size() - 1), pt);
						for (model.Point pts: points) {
							model.links.get(model.links.size()-1).addPoint(pts);
						}
						
						AddElementCommand command = new AddElementCommand(model, link);
						model.commands.addCommand(command);
						
						model.notifyAllObservers();
					}
				}
				break;
			}	
			
		default:
			break;	
		}
	}

	public boolean isLinkStarted() {
		return linkStarted;
	}

	public void setLinkStarted(boolean linkStarted) {
		this.linkStarted = linkStarted;
	}
}
