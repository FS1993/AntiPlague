
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;


public class MenuGlowne extends JFrame {

	Component MenuGlowne;
	List<Wynik> wyniki;
	
	public MenuGlowne() {
		super("Koronawirus AntiPlague");
		wyniki = new LinkedList<>();
		JButton rozpocznijGre = new JButton("Rozpocznij gr�");
		JButton informacje = new JButton("Informacje");
		JButton ranking = new JButton("Ranking");
		JButton wyjscie = new JButton("Wyj�cie");
		setSize(350, 200);
 		setLocation(50,50);
 		setLayout(new GridLayout(4, 1));
 		
 		informacje.addActionListener(new ActionListener(){
 	
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MenuGlowne, "Witaj w grze Koronawirus AntiPlague!\n"
						+ "- Gra polega na powstrzymaniu rozprzestrzenianiu si� wirusa w 10 krajach.\n"
						+ "- Post�powanie wirusa mo�na zatrzyma� przez wykupowanie ulepsze�, kt�re wy��czaj� drogi rozsprzestrzeniania si� wirusa.\n"
						+ "- Ulepszenia kupuje si� za punkty. Gracz startuje z 9000 punktami. Punkty mo�na uzyska� przez dotacje lub leczenie ludzi przez leki i szczepionki.\n"
						+ "- Gra ko�czy si�, kiedy wirus zainfekuje ca�y �wiat, wszyscy ludze zostan� wyleczeni albo kiedy wszystkie drogi transportu zostan� wy��czone.\n"
						+ "- Po zako�czeniu gry gracz podaje swoj� nazw� i jego wynik zapisywany jest w lokalnym rankingu.\n"
						+ "- Ostateczny wynik liczony jest wed�ug formu�y: PT * liczba ludzi zdrowych / czas, gdzie PT to odpowiednio: �atwy = 1.0, �redni = 2.0, trudny = 3.0.\n"
						+ "- Ctrl+Shift+Q aby wy��czy� gr� i wr�ci� do menu g�ownego.", "Informacje", JOptionPane.PLAIN_MESSAGE);
			}
 		});
 		
 		rozpocznijGre.addActionListener(new ActionListener(){
 		 	
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(()->new PoziomTrudnosci());
				setVisible(false);
				

			}
 		});
 		
 		ranking.addActionListener(new ActionListener(){
 		 	
			@Override
			public void actionPerformed(ActionEvent e) {
				FileInputStream fileIn;
				try {
					fileIn = new FileInputStream("ranking.dat");
					
					boolean isExist = true;

				    while(isExist){
				    	ObjectInputStream ois = new ObjectInputStream(fileIn);
				        if(fileIn.available() != 0){
				         Wynik w = (Wynik) ois.readObject();    
				         wyniki.add(w);
				        }
				        else{
				        isExist =false;
				        }
				    }
				} catch (FileNotFoundException e2) {
		
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					
				}
				SwingUtilities.invokeLater(()-> new Ranking(wyniki));
			}
 		});
 		
 		wyjscie.addActionListener(new ActionListener(){
 		 	
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
 		});
 		
		add(rozpocznijGre);
		add(informacje);
		add(ranking);
		add(wyjscie);
		
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	
	}
}
