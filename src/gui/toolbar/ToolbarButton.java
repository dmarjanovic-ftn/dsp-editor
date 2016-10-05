package gui.toolbar;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JToolBar;

@SuppressWarnings("serial")
public class ToolbarButton extends AbstractAction{

	private Action action;

	public ToolbarButton(JToolBar tb, Icon icon, Action ac, String text) {
		super(null, icon);
		putValue(Action.SHORT_DESCRIPTION, text);
		action = ac;
		tb.add(this);
	}
	
	public ToolbarButton(String text, Action ac, String text_) {
		super(text);
		putValue(Action.SHORT_DESCRIPTION, text_);
		action = ac;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (action!=null) {
			if(action.isEnabled()) {
				action.actionPerformed(e);
				this.setEnabled(true);
			} else {
				this.setEnabled(false);
			}
		} 
	}

}
