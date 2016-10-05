package command;

import java.util.ArrayList;

import state.AddState.ComponentType;
import view.ElementPainter;
import view.ComponentPainter;
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

public class AddElementCommand implements Command {
	
	private Schema model;
	private Component component;
	private Link link;
	private ArrayList<model.Point> points; 
	private ComponentType elementType;
	private ElementPainter painter;
	private int index;
	
	public AddElementCommand(Schema model, ArrayList<model.Point> points, ComponentType componentType, ElementPainter painter) {
		this.model = model;
		this.component = null;
		this.link = null;
		this.points = points;
		this.elementType = componentType;
		this.painter = painter;
		this.index = -1;
	}
	
	public AddElementCommand(Schema model, Link link) {
		this.model = model;
		this.component = null;
		this.link = link;
		this.elementType = ComponentType.CONNECTION;
		this.index = -1;
	}

	@Override
	public void execute() {
		
		if (index == -1) {
			switch(elementType) {
			case ADDER: {
				component = new GenAdder();
				Terminal term1 = new Terminal(0, TerminalType.INPUT, new model.Point(3, 18));
				Terminal term2 = new Terminal(1, TerminalType.INPUT, new model.Point(3, 51));
				Terminal term3 = new Terminal(2, TerminalType.OUTPUT, new model.Point(63, 33));
				component.componentPainter = (ComponentPainter) painter;
				component.setPoint(points.get(0));
				component.addTerminal(term1);
				component.addTerminal(term2);
				component.addTerminal(term3);
		
				model.addComponent(component);
				break;
			}
			
			case INTEGRATOR: {
				component = new GenIntegrator("Gen integrator name", "Description of genIntegrator", 0.0);
				Terminal term1 = new Terminal(0, TerminalType.INPUT, new model.Point(3, 32));
				Terminal term2 = new Terminal(1, TerminalType.OUTPUT, new model.Point(63, 32));
				component.componentPainter = (ComponentPainter) painter;
				component.setPoint(points.get(0));
				component.addTerminal(term1);
				component.addTerminal(term2);
				
				model.addComponent(component);
				break;
			}	
			
			case SINE: {
				component = new SourceSine();
				Terminal term = new Terminal(0, TerminalType.OUTPUT, new model.Point(61, 32));
				component.componentPainter = (ComponentPainter) painter;
				component.setPoint(points.get(0));
				component.addTerminal(term);
	
				model.addComponent(component);
				break;
			}
			
			case CONSTATNT: {
				component = new SourceConstant();
				Terminal term = new Terminal(0, TerminalType.OUTPUT, new model.Point(61, 32));
				component.componentPainter = (ComponentPainter) painter;
				component.setPoint(points.get(0));
				component.addTerminal(term);
	
				model.addComponent(component);
				break;
			}
			
			case AND: {
				component = new GenAnd();
				Terminal term1 = new Terminal(0, TerminalType.INPUT, new model.Point(3, 22));
				Terminal term2 = new Terminal(1, TerminalType.INPUT, new model.Point(3, 44));
				Terminal term3 = new Terminal(2, TerminalType.OUTPUT, new model.Point(63, 32));
				component.componentPainter = (ComponentPainter) painter;
				component.setPoint(points.get(0));
				component.addTerminal(term1);
				component.addTerminal(term2);
				component.addTerminal(term3);
				
				model.addComponent(component);
				break;
			}
			 
			case OR: {
				component = new GenOr();
				Terminal term1 = new Terminal(0, TerminalType.INPUT, new model.Point(3, 23));
				Terminal term2 = new Terminal(1, TerminalType.INPUT, new model.Point(3, 43));
				Terminal term3 = new Terminal(2, TerminalType.OUTPUT, new model.Point(63, 33));
				component.componentPainter = (ComponentPainter) painter;
				component.setPoint(points.get(0));
				component.addTerminal(term1);
				component.addTerminal(term2);
				component.addTerminal(term3);
				
				model.addComponent(component);
				break;
			}
			
			case GAIN: {
				component = new GenGain();
				Terminal term1 = new Terminal(0, TerminalType.INPUT, new model.Point(3, 22));
				Terminal term2 = new Terminal(1, TerminalType.INPUT, new model.Point(3, 42));
				Terminal term3 = new Terminal(2, TerminalType.OUTPUT, new model.Point(63, 32));
				component.componentPainter = (ComponentPainter) painter;
				component.setPoint(points.get(0));
				component.addTerminal(term1);
				component.addTerminal(term2);
				component.addTerminal(term3);
				
				model.addComponent(component);
				break;
			}
			
			case PROBE: {
				component = new GenProbe();
				Terminal term = new Terminal(0, TerminalType.INPUT, new model.Point(3, 32));
				component.componentPainter = (ComponentPainter) painter;
				component.setPoint(points.get(0));
				component.addTerminal(term);
				
				model.addComponent(component);
				break;
			}

			default:
				break;	
			}
			
			if (component != null) {
				index = model.components.indexOf(component);
			}
			else if (link != null) {
				index = model.links.indexOf(link);
			}
		}
		else {
			if (component != null) {
				model.components.get(index).status = true;
			}
			else if (link != null) {
				model.links.get(index).status = true;
				link.dest.setConnected(true);
				link.src.setConnected(true);
			}
			
			model.notifyAllObservers();
		}
	}

	@Override
	public void unexecute() {
		
		if (component != null) {
			model.components.get(index).status = false;
		}
		
		if (link != null) {
			link.dest.setConnected(false);
			link.src.setConnected(false);
			model.links.get(index).status = false;
		}
		
		model.notifyAllObservers();
	}

}
