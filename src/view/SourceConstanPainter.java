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
import model.Point;
import model.SourceConstant;

public class SourceConstanPainter extends ComponentPainter {
	@Override
	public void draw(Graphics g, Point p) {
		Image img = new ImageIcon("./images/components/comp_constant_v2.png").getImage();
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(img, (int) p.getX(), (int) p.getY(), null);
	}
	
	
	@Override
	public void drawDialog(final Component component){
		final ComponentDialog dialog = new ComponentDialog(Window.getInstance(), "Component SourceConstant");
		
		JLabel jlblValue = new  JLabel("Value :");
		GridBagConstraints gbc_lblValue = new GridBagConstraints();
		gbc_lblValue.insets = new Insets(5, 7, 5, 10);
		gbc_lblValue.gridx = 0;
		gbc_lblValue.gridy = 2;
		gbc_lblValue.anchor = GridBagConstraints.WEST;
		dialog.centralPanel.add(jlblValue, gbc_lblValue);

		
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
		DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
		decimalFormat.setGroupingUsed(false);
		final JFormattedTextField jtxtValue = new JFormattedTextField(decimalFormat);		
		jtxtValue.setHorizontalAlignment(JTextField.RIGHT);
		GridBagConstraints gbc_txtValue = new GridBagConstraints();
		gbc_txtValue.anchor = GridBagConstraints.LINE_START;
		gbc_txtValue.fill = GridBagConstraints.BOTH;
		gbc_txtValue.insets = new Insets(5, 0, 5, 150);
		gbc_txtValue.gridx = 1;
		gbc_txtValue.gridy = 2;
		gbc_txtValue.gridwidth = 1;
		dialog.centralPanel.add(jtxtValue, gbc_txtValue);		
		
		// Fill fields
		dialog.textField.setText(component.getName());
		dialog.textArea.setText(component.getDescription());
		jtxtValue.setText(String.valueOf(((SourceConstant) component).getValue()));
		
		dialog.btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((SourceConstant)component).update(dialog.textField.getText(), jtxtValue.getText());
				dialog.dispose();
			}
		});
		
		dialog.setVisible(true);
		dialog.setModal(true);
	}

	
}
