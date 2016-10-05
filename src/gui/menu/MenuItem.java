package gui.menu;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JMenu;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class MenuItem extends AbstractAction {
	
	private Action action;
	
	public MenuItem(JMenu menu, String name, Icon icon, Action ac, int mn, int ke, int ae) {
		super(name, icon);
		action = ac;
		putValue(Action.MNEMONIC_KEY, mn);
		putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(ke, ae));
		menu.add(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (action != null) {
			action.actionPerformed(e);
		}
	}
	
}
