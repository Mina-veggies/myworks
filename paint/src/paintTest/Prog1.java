package paintTest;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Prog1 {
	static int w = 800, h = 600;
	
	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		JFrame frame = new JFrame("お絵かきアプリ");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(w, h);
		frame.setLocationRelativeTo(null);
		
		PaintCanvas canvas = new PaintCanvas();
		
		JPanel pane = new JPanel();
		frame.getContentPane().add(pane, BorderLayout.CENTER);
		JPanel paneB = new JPanel();
		frame.getContentPane().add(pane, BorderLayout.NORTH);
		
		canvas.setPreferredSize(new Dimension(w, h));
		pane.add(canvas);
		
		/*　追加　*/
		JButton clear = new JButton("CLEAR");
		clear.addActionListener(new ClearListener(canvas));
		paneB.add(clear);
		
		JSlider slider = new JSlider(1, 50, 1);
		slider.addChangeListener(new SliderListener(canvas));
		paneB.add(slider);
		
		String[] combodata = { "BLACK", "RED", "BLUE", "GREEN" };
		JComboBox combo = new JComboBox(combodata);
		combo.addActionListener(new ComboListener(canvas));
		paneB.add(combo);
		
		frame.setVisible(true);
	}
	
	static class PaintCanvas extends Canvas implements MouseListener, MouseMotionListener {
		
		private BufferedImage cImage = null;
		private Graphics2D g2d;
		
		private int x, y, xx, yy;
		
		private int type;
		
		public int width = 1;
		
		public Color c = Color.black;
		
		public PaintCanvas() {
			
			x = -1;
			y = -1;
			xx = -1;
			yy = -1;
			type = 0;
			
			addMouseListener(this);
			addMouseMotionListener(this);
			
			setBackground(Color.white);
			
			cImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
			g2d = (Graphics2D) cImage.getGraphics();
			
			g2d.setColor(Color.WHITE);
			g2d.fillRect(0, 0, w, h);
			
			repaint();
		}
		
		public void clear() {
			g2d.setColor(Color.WHITE);
			g2d.fillRect(0, 0, w, h);
			repaint();
		}
		
		public void setStroke(int n) {
			width = n;
		}
		
		public void setColorCombo(String color) {
			if(color.equals("BLACK")) {
				c = Color.black;
			}else if (color.equals("RED")) {
				c = Color.red;
			}else if(color.equals("BLUE")) {
				c = Color.blue;
			}else if(color.equals("GREEN")) {
				c = Color.green;
			}
		}
		
		public void paint(Graphics g) {
			
			if(type == 1) {
				if(x >= 0 && y >= 0 && xx >= 0 && yy >= 0) {
					BasicStroke stroke = new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
					g2d.setStroke(stroke);
					g2d.setColor(c);
					g2d.drawLine(xx, yy, x, y);
				}
			}else if(type == 2) {
				if(x >= 0 && y >= 0 && xx >= 0 && yy >= 0) {
					BasicStroke stroke = new BasicStroke(50.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
					g2d.setStroke(stroke);
					g2d.setColor(Color.white);
					g2d.drawLine(xx, yy, x, y);
				}
			}
			g.drawImage(cImage, 0, 0, null);
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			if((e.getModifiers() & MouseEvent.BUTTON1_MASK) != 0) {
				type = 1;
			}
			if((e.getModifiers() & MouseEvent.BUTTON2_MASK) != 0) {
			}
			if((e.getModifiers() & MouseEvent.BUTTON3_MASK) != 0) {
				type = 2;
			}
			
			xx = x;
			yy = y;
			
			Point point = e.getPoint();
			x = point.x;
			y = point.y;
			
			repaint();
		}
		
		@Override
		public void mouseMoved(MouseEvent e) {
			x = -1;
			y = -1;
			xx = -1;
			yy = -1;
			type = 0;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			Point point = e.getPoint();
			x = point.x;
			y = point.y;
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
	
	static class ClearListener implements ActionListener {
		
		PaintCanvas canvas;
		
		public ClearListener(PaintCanvas canvas) {
			super();
			this.canvas = canvas;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.clear();
		}
	}
	
	static class SliderListener implements ChangeListener {
		
		PaintCanvas canvas;
		
		public SliderListener(PaintCanvas canvas) {
			super();
			this.canvas = canvas;
		}
		
		@Override
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider) e.getSource();
			int fps = (int) source.getValue();
			canvas.setStroke(fps);
		}
	}
	
	static class ComboListener implements ActionListener {
		
		PaintCanvas canvas;
		
		public ComboListener(PaintCanvas canvas) {
            super();
            this.canvas = canvas;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox source = (JComboBox) e.getSource();
            String color = (String) source.getSelectedItem();
            canvas.setColorCombo(color);
        }

    }

}
