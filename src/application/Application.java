package application;

import gui.Window;

/**
 * DSP Editor
 * 
 * @author SW9 Bojan Blagojevic
 * @author SWF Dragutin Marjanovic
 *
 * @version 1.0
 * 
 */

public class Application {

	public static void main(String[] args) {

		Window mainWindow = Window.getInstance();
		mainWindow.setVisible(true);
	}
}
