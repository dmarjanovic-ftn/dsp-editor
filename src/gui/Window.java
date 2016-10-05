package gui;

import gui.menu.MenuBar;
import gui.palette.Palette;
import gui.palette.PaletteElement;
import gui.toolbar.Toolbar;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import controller.PaletteActions;

@SuppressWarnings("serial")
public class Window extends JFrame {

	public static final int width = 800;
	public static final int height = 640;

	private static Window instance = null;

	private Console console;
	public JTabbedPane tabbedPane;

	private Window() {
		super();
		
		this.setMinimumSize(new Dimension(800, 640));
	}

	// Singleton pattern
	public static Window getInstance() {

		if (instance == null) {
			instance = new Window();
			instance.initialize();
		}

		return instance;
	}

	private void initialize() {

		instance.setTitle("DSP Editor");
		// Set window icon
		instance.setIconImage((new ImageIcon("images/logoo.png")).getImage());
		// Quit on X button
		instance.setDefaultCloseOperation(EXIT_ON_CLOSE);

		instance.setBounds(50, 50, width, height);

		// Initialize of MenuBar
		instance.setJMenuBar(new MenuBar());
		instance.add(new Toolbar(), BorderLayout.NORTH);

		// Initialize of TabPane
		tabbedPane = new JTabbedPane();
		instance.add(tabbedPane, BorderLayout.CENTER);

		// Initialize of Palette
		createPalette();

	}

	private void createPalette() {
		String[] categories = { "Connections", "Logic gates",
				"Voltage sources", "Other" };
		ArrayList<PaletteElement> elements = new ArrayList<PaletteElement>();

		PaletteElement connectionButton = new PaletteElement("Connections", "Simple connection",
				"./images/components/comp_connection_v2.png");
		connectionButton.addActionListener(PaletteActions.addConnectionActive);
		elements.add(connectionButton);

		PaletteElement genAndButton = new PaletteElement("Logic gates",
				"AND gate", "./images/components/comp_and_v2.png");
		genAndButton.addActionListener(PaletteActions.genAndActive);
		elements.add(genAndButton);

		PaletteElement genOrButton = new PaletteElement("Logic gates",
				"OR gate", "./images/components/comp_or_v2.png");
		genOrButton.addActionListener(PaletteActions.genOrActive);
		elements.add(genOrButton);

		PaletteElement sinSourceButton = new PaletteElement("Voltage sources",
				"Sine source", "./images/components/comp_sine_v2.png");
		sinSourceButton.addActionListener(PaletteActions.sourceSineActive);
		elements.add(sinSourceButton);

		PaletteElement constSourceButton = new PaletteElement(
				"Voltage sources", "Constant source",
				"./images/components/comp_constant_v2.png");
		constSourceButton
				.addActionListener(PaletteActions.sourceConstantActive);
		elements.add(constSourceButton);

		PaletteElement genAdderButton = new PaletteElement("Other", "Adder",
				"./images/components/comp_adder_v2.png");
		genAdderButton.addActionListener(PaletteActions.genAdderActive);
		elements.add(genAdderButton);

		PaletteElement integratorButton = new PaletteElement("Other",
				"Integrator", "./images/components/comp_integrator_v2.png");
		integratorButton.addActionListener(PaletteActions.genIntegratorActive);
		elements.add(integratorButton);

		PaletteElement genGainButton = new PaletteElement("Other", "Gain",
				"./images/components/comp_gain_v2.png");
		genGainButton.addActionListener(PaletteActions.genGainActive);
		elements.add(genGainButton);

		PaletteElement genProbeButton = new PaletteElement("Other", "Probe",
				"./images/components/comp_probe_v2.png");
		genProbeButton.addActionListener(PaletteActions.genProbeActive);
		elements.add(genProbeButton);

		instance.add(new Palette(categories, elements), BorderLayout.EAST);

		// Add console
		console = new Console(
				"<html>DSP Editor v1.0 <br> Authors: <br> >> SW9 Bojan Blagojevic <br> >> SWF Dragutin Marjanovic");

		instance.add(console, BorderLayout.SOUTH);

	}
}
