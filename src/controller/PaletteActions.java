package controller;

import gui.Window;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JScrollPane;

import state.AddState;
import view.Canvas;

public abstract class PaletteActions {
	@SuppressWarnings("serial")
	public static AbstractAction sourceSineActive = new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JScrollPane scroll = (JScrollPane) Window.getInstance().tabbedPane
					.getSelectedComponent();
			if (scroll != null) {
				Canvas canv = (Canvas) scroll.getViewport().getView();
				canv.getModel().getStateContainer().setAddingState(AddState.ComponentType.SINE);
				
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Image image = toolkit
						.getImage("./images/components/comp_sine_v2.png");
				Cursor c = toolkit.createCustomCursor(image,
						new Point(canv.getX(), canv.getY()), "img");
				canv.setCursor(c);
			}
		}
	};

	@SuppressWarnings("serial")
	public static AbstractAction genProbeActive = new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JScrollPane scroll = (JScrollPane) Window.getInstance().tabbedPane
					.getSelectedComponent();
			if (scroll != null) {
				Canvas canv = (Canvas) scroll.getViewport().getView();
				canv.getModel().getStateContainer().setAddingState(AddState.ComponentType.PROBE);

				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Image image = toolkit
						.getImage("./images/components/comp_probe_v2.png");
				Cursor c = toolkit.createCustomCursor(image,
						new Point(canv.getX(), canv.getY()), "img");
				canv.setCursor(c);
			}
		}
	};

	@SuppressWarnings("serial")
	public static AbstractAction genGainActive = new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JScrollPane scroll = (JScrollPane) Window.getInstance().tabbedPane
					.getSelectedComponent();
			if (scroll != null) {
				Canvas canv = (Canvas) scroll.getViewport().getView();
				canv.getModel().getStateContainer().setAddingState(AddState.ComponentType.GAIN);

				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Image image = toolkit
						.getImage("./images/components/comp_gain_v2.png");
				Cursor c = toolkit.createCustomCursor(image,
						new Point(canv.getX(), canv.getY()), "img");
				canv.setCursor(c);
			}
		}
	};

	@SuppressWarnings("serial")
	public static AbstractAction genAndActive = new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JScrollPane scroll = (JScrollPane) Window.getInstance().tabbedPane
					.getSelectedComponent();
			if (scroll != null) {
				Canvas canv = (Canvas) scroll.getViewport().getView();
				canv.getModel().getStateContainer().setAddingState(AddState.ComponentType.AND);

				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Image image = toolkit
						.getImage("./images/components/comp_and_v2.png");
				Cursor c = toolkit.createCustomCursor(image,
						new Point(canv.getX(), canv.getY()), "img");
				canv.setCursor(c);
			}
		}
	};

	@SuppressWarnings("serial")
	public static AbstractAction genOrActive = new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JScrollPane scroll = (JScrollPane) Window.getInstance().tabbedPane
					.getSelectedComponent();
			if (scroll != null) {
				Canvas canv = (Canvas) scroll.getViewport().getView();
				canv.getModel().getStateContainer().setAddingState(AddState.ComponentType.OR);

				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Image image = toolkit
						.getImage("./images/components/comp_or_v2.png");
				Cursor c = toolkit.createCustomCursor(image,
						new Point(canv.getX(), canv.getY()), "img");
				canv.setCursor(c);
			}
		}
	};

	@SuppressWarnings("serial")
	public static AbstractAction genAdderActive = new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JScrollPane scroll = (JScrollPane) Window.getInstance().tabbedPane
					.getSelectedComponent();
			if (scroll != null) {
				Canvas canv = (Canvas) scroll.getViewport().getView();
				canv.getModel().getStateContainer().setAddingState(AddState.ComponentType.ADDER);

				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Image image = toolkit
						.getImage("./images/components/comp_adder_v2.png");
				Cursor c = toolkit.createCustomCursor(image,
						new Point(canv.getX(), canv.getY()), "img");
				canv.setCursor(c);
			}
		}
	};

	@SuppressWarnings("serial")
	public static AbstractAction genIntegratorActive = new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JScrollPane scroll = (JScrollPane) Window.getInstance().tabbedPane
					.getSelectedComponent();
			if (scroll != null) {
				Canvas canv = (Canvas) scroll.getViewport().getView();
				canv.getModel().getStateContainer().setAddingState(AddState.ComponentType.INTEGRATOR);

				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Image image = toolkit
						.getImage("./images/components/comp_integrator_v2.png");
				Cursor c = toolkit.createCustomCursor(image,
						new Point(canv.getX(), canv.getY()), "img");
				canv.setCursor(c);
			}
		}
	};

	@SuppressWarnings("serial")
	public static AbstractAction sourceConstantActive = new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JScrollPane scroll = (JScrollPane) Window.getInstance().tabbedPane
					.getSelectedComponent();
			if (scroll != null) {
				Canvas canv = (Canvas) scroll.getViewport().getView();
				canv.getModel().getStateContainer().setAddingState(AddState.ComponentType.CONSTATNT);

				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Image image = toolkit
						.getImage("./images/components/comp_constant_v2.png");
				Cursor c = toolkit.createCustomCursor(image,
						new Point(canv.getX(), canv.getY()), "img");
				canv.setCursor(c);
			}
		}
	};
	
	@SuppressWarnings("serial")
	public static AbstractAction addConnectionActive = new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JScrollPane scroll = (JScrollPane) Window.getInstance().tabbedPane
					.getSelectedComponent();
			if (scroll != null) {
				Canvas canv = (Canvas) scroll.getViewport().getView();
				canv.getModel().getStateContainer().setAddingState(AddState.ComponentType.CONNECTION);

				canv.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		}
	};
}
