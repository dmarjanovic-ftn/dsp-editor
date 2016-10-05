package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
	
	@SuppressWarnings("unused")
	public MenuBar() {
		JMenu file = createMenuOption(this, "File", KeyEvent.VK_F);
		JMenu edit = createMenuOption(this, "Edit", KeyEvent.VK_E);
		
		// First null value represents icon, second null value represents action
		MenuItem newProject = new MenuItem(file, "New project", null, null, KeyEvent.VK_P,
				KeyEvent.VK_P, ActionEvent.CTRL_MASK + ActionEvent.ALT_MASK);
	}
	
	private static JMenu createMenuOption(JComponent superMenu, String optionText, int mnemonic) {
		JMenu menu = new JMenu(optionText);
		menu.setMnemonic(mnemonic);
		superMenu.add(menu);
		return menu;
	}
}
