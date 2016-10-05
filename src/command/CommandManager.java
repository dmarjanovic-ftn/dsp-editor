package command;

import java.util.Stack;

public class CommandManager {
	
	private Stack<Command> commandsUndo = new Stack<Command>();
	private Stack<Command> commandsRedo = new Stack<Command>();
	
	public void addCommand(Command command) {
		command.execute();
		commandsRedo.clear();
		commandsUndo.push(command);
	}
	
	public void undoCommand() {
		if (commandsUndo.size() > 0) {
			Command command = commandsUndo.pop();

			command.unexecute();
			
			commandsRedo.push(command);
		}
	}
	
	public void redoCommand() {
		if (commandsRedo.size() > 0) {
			Command command = commandsRedo.pop();
			
			command.execute();
			
			commandsUndo.push(command);
		}
	}

}
