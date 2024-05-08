package graphic_Practice.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graphic_Sample extends JFrame{
	
	public Graphic_Sample() {
		this.setSize(800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyPanel p = new MyPanel();
		this.add(p, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Graphic_Sample();
	}

}

class MyPanel extends JPanel{
	
	public void paintComponent(Graphics oval) {
		oval.setColor(Color.BLACK);
		oval.fillOval(50, 50, 100, 100);
	}
	
	public void paintComponent1(Graphics rect) {
		rect.setColor(Color.BLUE);
		rect.drawRect(150, 150, 100, 100);
	}
	
	public void paintDoubleOvalComponent(Graphics oval) {
		for(int i = 0; i < 255; i += 20) {
			oval.setColor(new Color(0, 0, 255,i));
			oval.fillOval(i, i, 100, 100);
			oval.setColor(new Color(255, 0, 0, i));
			oval.fillOval(255 - i, i, 100, 100);
		}
	}
	
}