package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.Point;

public abstract class Utility {
	
	// Funckija koja kreira header button u konzoli
	public static JButton getConsoleButton(String imagePath, int size) {
		JButton btn = new JButton(new ImageIcon(((new ImageIcon(imagePath + ".png").getImage().getScaledInstance(size, size, java.awt.Image.SCALE_SMOOTH)))));
		
		btn.setPreferredSize(new Dimension(20, 20));
		btn.setMargin(new Insets(0, 0, 0, 0));
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn.setBorder(null);
		btn.setBackground(new Color(15, 15, 15));
		
		btn.setRolloverIcon(new ImageIcon(((new ImageIcon(imagePath + "_.png").getImage().getScaledInstance(size, size, java.awt.Image.SCALE_SMOOTH)))));
		return btn;
	}
	
	// Funkcija koja za dvije zadate tacke vraca lakat izmedju te dvije tacke.
	// Odnosno, pravi vezu izmedju te dvije tacke, s tim da budu pod pravim uglom.
	public static ArrayList<Point> getElbow (Point p1, Point p2) {
		ArrayList<Point> points = new ArrayList<Point>();
		
		Point p3 = new Point();
		p3.setX((int) p2.getX());
		p3.setY((int) p2.getY());
		
		if (Math.abs(p1.getX() - p2.getX()) > Math.abs(p1.getY() - p2.getY())) {
			p2.setY((int) p1.getY());
		}
		else {
			p2.setX((int) p1.getX());
		}
		
		points.add(p2);
		points.add(p3);
		
		return points;
	}

	public static model.Point getStraightLine(model.Point point, model.Point pt) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
