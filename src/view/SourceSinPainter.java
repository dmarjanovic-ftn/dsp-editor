package view;

import gui.Window;

import java.awt.Dimension;
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
import model.SourceSine;

public class SourceSinPainter extends ComponentPainter {
	@Override
	public void draw(Graphics g, Point p) {
		Image img = new ImageIcon("./images/components/comp_sine_v2.png").getImage();
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(img, (int) p.getX(), (int) p.getY(), null);
	}
	
	
	@Override
	public void drawDialog(final Component component){
		final ComponentDialog dialog = new ComponentDialog(Window.getInstance(), "Component SourceSine");
		
		// Amplitude field
		JLabel jlblAmplitude = new  JLabel("Amplitude :");
		GridBagConstraints gbc_lblAmplitude = new GridBagConstraints();
		gbc_lblAmplitude.insets = new Insets(5, 7, 5, 10);
		gbc_lblAmplitude.gridx = 0;
		gbc_lblAmplitude.gridy = 2;
		gbc_lblAmplitude.anchor = GridBagConstraints.WEST;
		dialog.centralPanel.add(jlblAmplitude, gbc_lblAmplitude);

		
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
		DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
		decimalFormat.setGroupingUsed(false);
		final JFormattedTextField jtxtAmplitude = new JFormattedTextField(decimalFormat);		
		jtxtAmplitude.setHorizontalAlignment(JTextField.RIGHT);
		GridBagConstraints gbc_txtAmplitude = new GridBagConstraints();
		gbc_txtAmplitude.anchor = GridBagConstraints.LINE_START;
		gbc_txtAmplitude.fill = GridBagConstraints.BOTH;
		gbc_txtAmplitude.insets = new Insets(5, 0, 5, 150);
		gbc_txtAmplitude.gridx = 1;
		gbc_txtAmplitude.gridy = 2;
		gbc_txtAmplitude.gridwidth = 1;
		dialog.centralPanel.add(jtxtAmplitude, gbc_txtAmplitude);		

		// Offset field
		JLabel jlblOffset = new  JLabel("Offset :");
		GridBagConstraints gbc_lblOffset = new GridBagConstraints();
		gbc_lblOffset.insets = new Insets(5, 7, 5, 10);
		gbc_lblOffset.gridx = 0;
		gbc_lblOffset.gridy = 3;
		gbc_lblOffset.anchor = GridBagConstraints.WEST;
		dialog.centralPanel.add(jlblOffset, gbc_lblOffset);

		
		final JFormattedTextField jtxtOffset = new JFormattedTextField(decimalFormat);		
		jtxtOffset.setHorizontalAlignment(JTextField.RIGHT);
		GridBagConstraints gbc_txtOffset = new GridBagConstraints();
		gbc_txtOffset.anchor = GridBagConstraints.LINE_START;
		gbc_txtOffset.fill = GridBagConstraints.BOTH;
		gbc_txtOffset.insets = new Insets(5, 0, 5, 150);
		gbc_txtOffset.gridx = 1;
		gbc_txtOffset.gridy = 3;
		dialog.centralPanel.add(jtxtOffset, gbc_txtOffset);		


		// Frequency field
		JLabel jlblFrequency = new  JLabel("Frequency :");
		GridBagConstraints gbc_lblFrequency = new GridBagConstraints();
		gbc_lblFrequency.insets = new Insets(5, 7, 5, 10);
		gbc_lblFrequency.gridx = 0;
		gbc_lblFrequency.gridy = 4;
		gbc_lblFrequency.anchor = GridBagConstraints.WEST;
		dialog.centralPanel.add(jlblFrequency, gbc_lblFrequency);

		
		final JFormattedTextField jtxtFrequency = new JFormattedTextField(decimalFormat);		
		jtxtFrequency.setHorizontalAlignment(JTextField.RIGHT);
		GridBagConstraints gbc_txtFrequency = new GridBagConstraints();
		gbc_txtFrequency.anchor = GridBagConstraints.LINE_START;
		gbc_txtFrequency.fill = GridBagConstraints.BOTH;
		gbc_txtFrequency.insets = new Insets(5, 0, 5, 150);
		gbc_txtFrequency.gridx = 1;
		gbc_txtFrequency.gridy = 4;
		dialog.centralPanel.add(jtxtFrequency, gbc_txtFrequency);		


		// Phase field
		JLabel jlblPhase = new  JLabel("Phase :");
		GridBagConstraints gbc_lblPhase = new GridBagConstraints();
		gbc_lblPhase.insets = new Insets(5, 7, 5, 10);
		gbc_lblPhase.gridx = 0;
		gbc_lblPhase.gridy = 5;
		gbc_lblPhase.anchor = GridBagConstraints.WEST;
		dialog.centralPanel.add(jlblPhase, gbc_lblPhase);

		
		final JFormattedTextField jtxtPhase = new JFormattedTextField(decimalFormat);		
		jtxtPhase.setHorizontalAlignment(JTextField.RIGHT);
		GridBagConstraints gbc_txtPhase = new GridBagConstraints();
		gbc_txtPhase.anchor = GridBagConstraints.LINE_START;
		gbc_txtPhase.fill = GridBagConstraints.BOTH;
		gbc_txtPhase.insets = new Insets(5, 0, 5, 150);
		gbc_txtPhase.gridx = 1;
		gbc_txtPhase.gridy = 5;
		dialog.centralPanel.add(jtxtPhase, gbc_txtPhase);		

		dialog.setMinimumSize(new Dimension(370, 340));
		
		// Fill fields
		dialog.textField.setText(component.getName());
		dialog.textArea.setText(component.getDescription());
		jtxtAmplitude.setText(String.valueOf(((SourceSine) component).getAmplitude()));
		jtxtOffset.setText(String.valueOf(((SourceSine) component).getOffset()));
		jtxtFrequency.setText(String.valueOf(((SourceSine) component).getFrequency()));
		jtxtPhase.setText(String.valueOf(((SourceSine) component).getPhase()));
		
		
		dialog.btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((SourceSine)component).update(dialog.textField.getText(), jtxtAmplitude.getText(), jtxtOffset.getText(), jtxtFrequency.getText() , jtxtPhase.getText());
				dialog.dispose();
			}
		});
		
		dialog.setVisible(true);
		dialog.setModal(true);
	}
}