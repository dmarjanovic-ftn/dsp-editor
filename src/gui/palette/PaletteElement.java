package gui.palette;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class PaletteElement extends JButton {
	
	private String componentCategory;
	private String componentName;

	public PaletteElement(String componentCategory, String componentName, String imageIconPath) {
		super();
		
		ImageIcon img = new ImageIcon(((new ImageIcon(imageIconPath).getImage().getScaledInstance(48, 48, java.awt.Image.SCALE_SMOOTH))));
		this.setIcon(img);
		
		this.componentCategory = componentCategory;
		this.componentName = componentName;
		
		this.setPreferredSize(new Dimension(48, 48));
		this.setMargin(new Insets(0, 0, 0, 0));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setBorder(null);
		this.setBackground(new Color(238, 238, 238));
	}
	
	public String getComponentCategory() {
		return componentCategory;
	}

	public void setComponentCategory(String componentCategory) {
		this.componentCategory = componentCategory;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

}
