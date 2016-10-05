package state;

import model.Schema;

public class StateContainer {
	private State currentState;
	private Schema model;

	private SelectState selectState;
	private AddState addingState;
	private MoveState moveState;
	
	public StateContainer(Schema schema) {
		model = schema;
		
		selectState = new SelectState(schema);
		addingState = new AddState(schema);
		moveState = new MoveState(schema);
		
		currentState = selectState;
	}

	
	public Schema getModel() {
		return model;
	}

	public void setModel(Schema model) {
		this.model = model;
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setSelectState() {
		this.currentState = selectState;
		
		if (addingState.isLinkStarted()) {
			addingState.setLinkStarted(false);
			
			if (model.links.size() > 0) {
				model.links.get(model.links.size() - 1).src.setConnected(false);
				model.links.remove(model.links.size() - 1);
			}
			model.notifyAllObservers();
		}
	}
	
	public void setMoveState() {
		this.currentState = moveState;
		
		if (addingState.isLinkStarted()) {
			addingState.setLinkStarted(false);
			
			if (model.links.size() > 0) {
				model.links.get(model.links.size() - 1).src.setConnected(false);
				model.links.remove(model.links.size() - 1);
			}
			model.notifyAllObservers();
		}
		
	}
	
	public void setAddingState(AddState.ComponentType type) {
		this.currentState = addingState;
		
		if (addingState.isLinkStarted()) {
			addingState.setLinkStarted(false);
			
			if (model.links.size() > 0) {
				model.links.get(model.links.size() - 1).src.setConnected(false);
				model.links.remove(model.links.size() - 1);
			}
			model.notifyAllObservers();
		}
		
		addingState.setActiveButton(type);
	}
}
