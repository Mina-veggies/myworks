package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestFrame extends JFrame {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("ネコチャン");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//	window size(wi, hi)
		frame.setSize(600, 85);
		
		//	レイアウトを設定
		frame.setLayout(new BorderLayout());
		
		//	null:window center
		frame.setLocationRelativeTo(null);
		
		JPanel p = new JPanel();
		
		JButton button = new JButton("ネコ");
		button.setBackground(Color.darkGray);
		button.setForeground(Color.white);
		button.addActionListener(e -> {
			System.out.println("ネコチャン");
		});
		
		JButton button2 = new JButton("ネコ2");
		button2.setBackground(Color.lightGray);
		button2.addActionListener(e -> {
			System.out.println("ネコチャン……");
		});
		
		JButton button3 = new JButton("ネコ3");
		button3.setBackground(Color.gray);
		button3.addActionListener(e -> {
			System.out.println("カワイイ");
		});
		
	    JButton button4 = new JButton("ネコ4");
	    button4.setBackground(Color.white);
	    button4.addActionListener(e -> {
	    	System.out.println("ニャーン");
	    });
	    
	    JLabel label1 = new JLabel("ネコチャン：やさしい");

	    p.add(label1);
	    
		//	ボタンを表示
		p.add(button);
		p.add(button2);
		p.add(button3);
		p.add(button4);
		
		frame.getContentPane().add(p, BorderLayout.CENTER);
		frame.setVisible(true);		//true 表示
	}
}
	
//	public void actionPerformed(ActionEvent e){
//	    JLabel label = new JLabel("Push A Button");
//	    JOptionPane.showMessageDialog(this, label);

