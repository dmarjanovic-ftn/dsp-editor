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
import model.GenIntegrator;
import model.Point;

public class GenIntegratorPainter extends ComponentPainter {
	@Override
	public void draw(Graphics g, Point p) {
		Image img = new ImageIcon("./images/components/comp_integrator_v2.png").getImage();
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(img, (int) p.getX(), (int) p.getY(), null);
	}
	
	@Override
	public void drawDialog(final Component component){
		final ComponentDialog dialog = new ComponentDialog(Window.getInstance(), "Component Integrator");
		
		JLabel jlblInit = new  JLabel("Initial value :");
		GridBagConstraints gbc_lblInit = new GridBagConstraints();
		gbc_lblInit.insets = new Insets(5, 7, 5, 10);
		gbc_lblInit.gridx = 0;
		gbc_lblInit.gridy = 2;
		gbc_lblInit.anchor = GridBagConstraints.WEST;
		dialog.centralPanel.add(jlblInit, gbc_lblInit);

		
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
		DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
		decimalFormat.setGroupingUsed(false);
		final JFormattedTextField jtxtInit = new JFormattedTextField(decimalFormat);		
		jtxtInit.setHorizontalAlignment(JTextField.RIGHT);
		GridBagConstraints gbc_txtInit = new GridBagConstraints();
		gbc_txtInit.anchor = GridBagConstraints.LINE_START;
		gbc_txtInit.fill = GridBagConstraints.BOTH;
		gbc_txtInit.insets = new Insets(5, 0, 5, 150);
		gbc_txtInit.gridx = 1;
		gbc_txtInit.gridy = 2;
		gbc_txtInit.gridwidth = 1;
		dialog.centralPanel.add(jtxtInit, gbc_txtInit);		
		
		// Fill fields
		dialog.textField.setText(component.getName());
		dialog.textArea.setText(component.getDescription());
		jtxtInit.setText(String.valueOf(((GenIntegrator) component).getInitValue()));
		
		dialog.btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((GenIntegrator)component).update(dialog.textField.getText(), jtxtInit.getText());
				dialog.dispose();
			}
		});
		
		dialog.setVisible(true);
		dialog.setModal(true);
	}
}
