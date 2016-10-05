package view;

import gui.Window;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Component;
import model.GenGain;
import model.Point;

public class GenGainPainter extends ComponentPainter {

	@Override
	public void draw(Graphics g, Point p) {
		Image img = new ImageIcon("./images/components/comp_gain_v2.png").getImage();
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(img, (int) p.getX(), (int) p.getY(), null);
	}

	
	@Override
	public void drawDialog(final Component component){
		final ComponentDialog dialog = new ComponentDialog(Window.getInstance(), "Component Gain");
		
		JLabel jlblGain = new  JLabel("Gain :");
		GridBagConstraints gbc_lblGain = new GridBagConstraints();
		gbc_lblGain.insets = new Insets(5, 7, 5, 10);
		gbc_lblGain.gridx = 0;
		gbc_lblGain.gridy = 2;
		gbc_lblGain.anchor = GridBagConstraints.WEST;
		dialog.centralPanel.add(jlblGain, gbc_lblGain);

		
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
		DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
		decimalFormat.setGroupingUsed(false);
		final JFormattedTextField jtxtGain = new JFormattedTextField(decimalFormat);		
		jtxtGain.setHorizontalAlignment(JTextField.RIGHT);
		GridBagConstraints gbc_txtGain = new GridBagConstraints();
		gbc_txtGain.anchor = GridBagConstraints.LINE_START;
		gbc_txtGain.fill = GridBagConstraints.BOTH;
		gbc_txtGain.insets = new Insets(5, 0, 5, 150);
		gbc_txtGain.gridx = 1;
		gbc_txtGain.gridy = 2;
		gbc_txtGain.gridwidth = 1;
		dialog.centralPanel.add(jtxtGain, gbc_txtGain);		
		
		//fill fields
		dialog.textField.setText(component.getName());
		dialog.textArea.setText(component.getDescription());
		jtxtGain.setText(String.valueOf(((GenGain) component).getGain()));
		
		dialog.btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((GenGain)component).update(dialog.textField.getText(), jtxtGain.getText());
				dialog.dispose();
			}
		});
		
		dialog.setVisible(true);
		dialog.setModal(true);
	}
}
