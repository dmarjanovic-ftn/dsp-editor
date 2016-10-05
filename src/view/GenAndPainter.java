package view;

import gui.Window;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import model.Component;
import model.Point;

public class GenAndPainter extends ComponentPainter {
	@Override
	public void draw(Graphics g, Point p) {
		Image img = new ImageIcon("./images/components/comp_and_v2.png").getImage();
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(img, (int) p.getX(), (int) p.getY(), null);
	}
	
	@Override
	public void drawDialog(final Component component){
		final ComponentDialog dialog = new ComponentDialog(Window.getInstance(), "Component And");
		
		dialog.textField.setText(component.getName());
		dialog.textArea.setText(component.getDescription());
		
		dialog.btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				component.update(dialog.textField.getText());
				dialog.dispose();
			}
		});
		
		
		dialog.setVisible(true);
		dialog.setModal(true);
	}
}
