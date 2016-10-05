package gui.toolbar;

import javax.swing.ImageIcon;
import javax.swing.JToolBar;

import controller.Actions;

@SuppressWarnings("serial")
public class Toolbar extends JToolBar {
	@SuppressWarnings("unused")
	public Toolbar() {
		
		// New
		ToolbarButton newScheme = new ToolbarButton(this, new ImageIcon("images/toolbar/page_add.png"), 
				Actions.newDiagram, "Add new scheme to project");
		
		// Open
		ToolbarButton openScheme = new ToolbarButton(this, new ImageIcon("images/toolbar/folder_page.png"), 
				null, "Open existing scheme");
		
		// Save
		ToolbarButton saveScheme = new ToolbarButton(this, new ImageIcon("images/toolbar/disk.png"), 
				null, "Save scheme");
		
		// Save as...
		ToolbarButton saveSchemeAs = new ToolbarButton(this, new ImageIcon("images/toolbar/save_as.png"), 
				null, "Save scheme as");
		
		this.addSeparator();
		
		// Select
		ToolbarButton select = new ToolbarButton(this, new ImageIcon("images/toolbar/select.png"), 
				Actions.selection , "Select element(s)");
		
		// Rotate left
		ToolbarButton rotateLeft = new ToolbarButton(this, new ImageIcon("images/toolbar/arrow_rotate_anticlockwise.png"), 
				null, "Rotate left");
		
		// Rotate right
		ToolbarButton rotateRight = new ToolbarButton(this, new ImageIcon("images/toolbar/arrow_rotate_clockwise.png"), 
				null, "Rotate right");
		
		// Erase element
		ToolbarButton erase = new ToolbarButton(this, new ImageIcon("images/toolbar/delete.png"), 
				Actions.deleteElem, "Delete element(s)");
		
		this.addSeparator();
		
		// Zoom in
		ToolbarButton undo = new ToolbarButton(this, new ImageIcon("images/toolbar/arrow_undo.png"), 
				Actions.undo, "Undo");
				
		// Zoom out
		ToolbarButton redo = new ToolbarButton(this, new ImageIcon("images/toolbar/arrow_redo.png"), 
				Actions.redo, "Redo");
		
		// Zoom in
		ToolbarButton zoomIn = new ToolbarButton(this, new ImageIcon("images/toolbar/magnifier_zoom_in.png"), 
				null, "Zoom in");
		
		// Zoom out
		ToolbarButton zoomOut = new ToolbarButton(this, new ImageIcon("images/toolbar/magnifier_zoom_out.png"), 
				null, "Zoom out");
		
		// Fit to screen
		ToolbarButton fitToScreen = new ToolbarButton(this, new ImageIcon("images/toolbar/zoom_fit.png"), 
				null, "Fit to screen");

		this.addSeparator();
		
		// Export to .pdf
		ToolbarButton exportToPDF = new ToolbarButton(this, new ImageIcon("images/toolbar/file_extension_pdf.png"), 
				null, "Export to .pdf");
		
		// Compile
		ToolbarButton compile = new ToolbarButton(this, new ImageIcon("images/toolbar/cog.png"), 
				null, "Compile and generate code");
		
		// Show/Hide console
		ToolbarButton console = new ToolbarButton(this, new ImageIcon("images/toolbar/application_osx_terminal.png"), 
				null, "Show/hide console");
		
		this.setOrientation(HORIZONTAL);
		this.setFloatable(false);
	}
}
