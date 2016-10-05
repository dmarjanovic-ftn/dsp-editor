package view;

import gui.Window;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Component;
import model.GenProbe;
import model.Point;

public class GenProbePainter extends ComponentPainter {
	@Override
	public void draw(Graphics g, Point p) {
		Image img = new ImageIcon("./images/components/comp_probe_v2.png").getImage();
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(img, (int) p.getX(), (int) p.getY(), null);
	}
	
	@Override
	public void drawDialog(final Component component){
		final ComponentDialog dialog = new ComponentDialog(Window.getInstance(), "Component GenProbe");
		
		JLabel jlbladdr = new  JLabel("Address :");
		GridBagConstraints gbc_lbladdr = new GridBagConstraints();
		gbc_lbladdr.insets = new Insets(5, 7, 5, 10);
		gbc_lbladdr.gridx = 0;
		gbc_lbladdr.gridy = 2;
		gbc_lbladdr.anchor = GridBagConstraints.WEST;
		dialog.centralPanel.add(jlbladdr, gbc_lbladdr);

		
		final JTextField jtxtAddr = new JTextField();		
		GridBagConstraints gbc_txtAddr = new GridBagConstraints();
		gbc_txtAddr.anchor = GridBagConstraints.LINE_START;
		gbc_txtAddr.fill = GridBagConstraints.BOTH;
		gbc_txtAddr.insets = new Insets(5, 0, 5, 7);
		gbc_txtAddr.gridx = 1;
		gbc_txtAddr.gridy = 2;
		gbc_txtAddr.gridwidth = 1;
		dialog.centralPanel.add(jtxtAddr, gbc_txtAddr);		
		
		// Fill fields
		dialog.textField.setText(component.getName());
		dialog.textArea.setText(component.getDescription());
		jtxtAddr.setText(String.valueOf(((GenProbe) component).getAddress()));
		
		dialog.btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((GenProbe)component).update(dialog.textField.getText(), jtxtAddr.getText());
				dialog.dispose();
			}
		});
		
		dialog.setVisible(true);
		dialog.setModal(true);
	}
}
