package gui.palette;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;

@SuppressWarnings("serial")
public class Palette extends JPanel {

	public Palette(String[] categories, ArrayList<PaletteElement> elements) {
		super();
		
		this.setLayout(new GridBagLayout());
		JPanel searchPanel = new JPanel();
		
		JTextField searchText = new JTextField();
		searchText.setPreferredSize(new Dimension(76, 20));
		searchPanel.add(searchText);
		
		JButton search = new JButton(new ImageIcon(((new ImageIcon("./images/other/search.png").getImage().getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH)))));
		
		search.setPreferredSize(new Dimension(20, 20));
		search.setMargin(new Insets(2, 2, 2, 2));
		search.setBackground(new Color(238, 238, 238));
		search.setBorder(null);
		search.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		searchPanel.add(search);
		this.add(searchPanel, 
				new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
		
		int row = 1;
		int column  = 0;
		for (String category: categories) {
			JPanel categoryNamePanel = new JPanel();
			categoryNamePanel.setBackground(new Color(200, 221, 242));
			categoryNamePanel.setBorder(new CompoundBorder(
			    BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(99, 130, 191)), 
			    BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(255, 255, 255))));
			
			JLabel categoryName = new JLabel(category);
			categoryName.setForeground(new Color(51, 51, 51));
			categoryNamePanel.add(categoryName);
			this.add(categoryNamePanel,
					new GridBagConstraints(0, row, 3, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 0, 0), 0, 0));
			
			row += 1;
			for (PaletteElement element: elements) {
				if (element.getComponentCategory().equals(category)) {
					// Add real component in tool box
					this.add(element, 
							new GridBagConstraints(column, row, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(1, 1, 1, 1), 0, 0));
					
					if (1 == column) {
						column = 0;
						row += 1;
					}
					else {
						column = 1;
					}
				}
			}
			column = 0;
			row += 1;		
		}
	}
	
}
