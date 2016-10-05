package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Console extends JPanel {
	
	private String text;
	
	Console(String text) {
		
		this.text = text;
		
		this.setBackground(new Color(15, 15, 15));
		this.setLayout(new GridBagLayout());
		
		JPanel consoleHeader = new JPanel();
		consoleHeader.setBackground(new Color(15, 15, 15));
		consoleHeader.setLayout(new FlowLayout(FlowLayout.RIGHT));
		consoleHeader.setPreferredSize(new Dimension(640, 20));
		consoleHeader.setBorder(new EmptyBorder(-5, 0, -5, -5));

		JButton btn1 = Utility.getConsoleButton("./images/console/bullet_go", 20);
		JButton btn2 = Utility.getConsoleButton("./images/console/resultset_next", 20);
		JButton btn3 = Utility.getConsoleButton("./images/console/update", 14);
		JButton btn4 = Utility.getConsoleButton("./images/console/stop", 14);
		JButton btn5 = Utility.getConsoleButton("./images/console/cross", 14);
		
		consoleHeader.add(btn1);
		consoleHeader.add(btn2);
		consoleHeader.add(btn3);
		consoleHeader.add(btn4);
		consoleHeader.add(btn5);
		
		
		JPanel textPanel = new JPanel();
		textPanel.setBackground(new Color(15, 15, 15));
		textPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel consoleText = new JLabel(this.text);
		consoleText.setForeground(new Color(255, 255, 255));
		consoleText.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		JTextField consoleField = new JTextField(" >> ");
		consoleField.setBackground(new Color(15, 15, 15));
		consoleField.setForeground(new Color(255, 255, 255));
		consoleField.setBorder(null);
		consoleField.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		textPanel.add(consoleText);
		
		this.add(consoleHeader, 
				new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 0, 0), 0, 0));
		
		this.add(textPanel,
				new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 0, 0), 0, 0));
		
		this.add(consoleField,
				new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 0, 0), 0, 0));
		
	}
	
}
