
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PoziomTrudnosci extends JFrame {

	public PoziomTrudnosci() {
		
		super("Poziom Trudnoœci");
		JButton latwy = new JButton("£atwy");
		JButton sredni = new JButton("Œredni");
		JButton trudny = new JButton("Trudny");
		setSize(280, 150);
 		setLayout(new GridLayout(3, 1));
 		latwy.addActionListener(new ActionListener(){
 		 	
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(()-> new Latwy());
				setVisible(false);
			}
 		});
 		
 		sredni.addActionListener(new ActionListener(){
 		 	
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(()-> new Sredni());
				setVisible(false);
			}
 		});
 		
 		trudny.addActionListener(new ActionListener(){
 		 	
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(()-> new Trudny());
				setVisible(false);
			}
 		});
 		add(latwy);
 		add(sredni);
 		add(trudny);
 		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
}
