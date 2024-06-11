package graphic_Practice.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Graphic_Sample extends JFrame implements ActionListener {

	BufferedImage img;
	MyPanel mypane;
	int h, w;
	JLabel label;
	JButton graphicOvalButton, graphicRectButton, graphicDoubleOvalButton, imageButton;

	public Graphic_Sample() {
		this.setSize(800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		// JLabelの組み込み
		label = new JLabel("Graphic Write");
		this.add(label, BorderLayout.NORTH);

		// JButtonの組み込み
		graphicOvalButton = new JButton("円を描く");
		graphicOvalButton.setSize(100, 25);
		graphicOvalButton.setLocation(20, 80);
		graphicOvalButton.addActionListener(this);

		graphicRectButton = new JButton("四角形を描く");
		graphicRectButton.setSize(100, 25);
		graphicRectButton.setLocation(200, 80);
		graphicRectButton.addActionListener(this);

		graphicDoubleOvalButton = new JButton("複雑な図形を描く");
		graphicDoubleOvalButton.setSize(100, 25);
		graphicDoubleOvalButton.setLocation(20, 260);
		graphicDoubleOvalButton.addActionListener(this);

		imageButton = new JButton("イメージ描画");
		imageButton.setSize(100, 25);
		imageButton.setLocation(200, 260);
		imageButton.addActionListener(this);

		// JPanelの組み込み
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		panel.add(graphicOvalButton);
		panel.add(graphicRectButton);
		panel.add(graphicDoubleOvalButton);
		panel.add(imageButton);
		this.add(panel, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent ev) {

		// 丸を描くボタンの処理
		if (ev.getSource() == graphicOvalButton) {
			WriteOval wo = new WriteOval();
		}

		// 四角形を描くボタンの処理
		if (ev.getSource() == graphicRectButton) {
			WriteRect wr = new WriteRect();
		}

		// 複雑な図形を描くボタンの処理
		if (ev.getSource() == graphicDoubleOvalButton) {
			WriteDoubleOval wdo = new WriteDoubleOval();
		}

		// イメージ描画ボタンの処理
		if (ev.getSource() == imageButton) {
			JFileChooser chooser = new JFileChooser();
			int res = chooser.showOpenDialog(this);
			if (res == JFileChooser.APPROVE_OPTION) {
				try {
					File openFile = chooser.getSelectedFile();
					img = ImageIO.read(openFile);
				} catch (IOException e) {
					e.printStackTrace();
					label.setText("Error...");
				}
				h = img.getHeight();
				w = img.getWidth();

			}

			// 画像を貼り付ける処理
			JFrame imgFrame = new JFrame("Image");
			imgFrame.setSize(300, 300);
			imgFrame.setLocation(w, h);
			imgFrame.getContentPane().add(mypane, BorderLayout.CENTER);
			imgFrame.setVisible(true);

		}
	}

	public class MyPanel extends JPanel {
		public MyPanel(int width, int height) {
			setSize(width, height);
		}

		public void paintComponent(Graphics image) {
			image.drawImage(img, 0, 0, this);
		}

	}
	
	class WriteOval extends JPanel {

		public void paintComponent(Graphics oval) {
			oval.setColor(Color.BLACK);
			oval.fillOval(50, 50, 100, 100);
		}
	}

	class WriteRect extends JPanel {

		public void paintComponent(Graphics rect) {
			rect.setColor(Color.BLUE);
			rect.drawRect(150, 150, 100, 100);
		}
	}

	class WriteDoubleOval extends JPanel {

		public void paintComponent(Graphics oval) {
			for (int i = 0; i < 255; i += 20) {
				oval.setColor(new Color(0, 0, 255, i));
				oval.fillOval(i, i, 100, 100);
				oval.setColor(new Color(255, 0, 0, i));
				oval.fillOval(255 - i, i, 100, 100);
			}
		}

	}

	public static void main(String[] args) {
		new Graphic_Sample();
	}

}

