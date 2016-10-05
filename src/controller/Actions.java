package controller;

import gui.Window;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;

import command.DeleteElementCommand;
import model.Component;
import model.Schema;
import view.Canvas;

public abstract class Actions {

	@SuppressWarnings("serial")
	public static AbstractAction newDiagram = new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JTabbedPane tabs = Window.getInstance().tabbedPane;
			
			Controller controller = new Controller();
			Schema model = new Schema();
			Canvas view = new Canvas(controller);

			model.addObserver(view);
			view.setModel(model);
			controller.setSchema(model);
			controller.setView(view);

			JScrollPane scroll = new JScrollPane(view);

			JScrollBar verticalScrollBar = new JScrollBar();
			scroll.setVerticalScrollBar(verticalScrollBar);

			JScrollBar horizontalScrollBar = new JScrollBar();
			horizontalScrollBar.setOrientation(java.awt.Adjustable.HORIZONTAL);
			scroll.setHorizontalScrollBar(horizontalScrollBar);

			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

			
			tabs.add(scroll, "Untitled " + (tabs.getTabCount() + 1));
			if (tabs.getTabCount() != 1) {
				tabs.setSelectedIndex(tabs.getTabCount() - 1);
			}
		}
	};

	@SuppressWarnings("serial")
	public static AbstractAction deleteElem = new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent e) {

			JScrollPane scroll = (JScrollPane) Window.getInstance().tabbedPane.getSelectedComponent();
			
			if (scroll != null) {
				Canvas canv = (Canvas) scroll.getViewport().getView();
				ArrayList<Integer> indexes = new ArrayList<Integer>();
				
				for (Component c: canv.getModel().selectedComponents) {
					indexes.add(canv.getModel().components.indexOf(c));
				}
				
				DeleteElementCommand command = new DeleteElementCommand(canv.getModel(), indexes);
				canv.getModel().commands.addCommand(command);
			}
		}	
	};

	@SuppressWarnings("serial")
	public static AbstractAction selection = new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JScrollPane scroll = (JScrollPane) Window.getInstance().tabbedPane
					.getSelectedComponent();
			if (scroll != null) {
				Canvas canv = (Canvas) scroll.getViewport().getView();
				canv.getModel().getStateContainer().setSelectState();
				canv.setCursor(Cursor
						.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		}
	};
	
	@SuppressWarnings("serial")
	public static AbstractAction undo = new AbstractAction() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JScrollPane scroll = (JScrollPane) Window.getInstance().tabbedPane
					.getSelectedComponent();
			if (scroll != null) {
				Canvas canv = (Canvas) scroll.getViewport().getView();
				canv.getModel().commands.undoCommand();
			}
		}
	};
	
	@SuppressWarnings("serial")
	public static AbstractAction redo = new AbstractAction() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JScrollPane scroll = (JScrollPane) Window.getInstance().tabbedPane
					.getSelectedComponent();
			if (scroll != null) {
				Canvas canv = (Canvas) scroll.getViewport().getView();
				canv.getModel().commands.redoCommand();
			}
		}
	};
}