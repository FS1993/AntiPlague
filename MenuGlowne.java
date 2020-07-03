
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
		JButton rozpocznijGre = new JButton("Rozpocznij grê");
		JButton informacje = new JButton("Informacje");
		JButton ranking = new JButton("Ranking");
		JButton wyjscie = new JButton("Wyjœcie");
		setSize(350, 200);
 		setLocation(50,50);
 		setLayout(new GridLayout(4, 1));
 		
 		informacje.addActionListener(new ActionListener(){
 	
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MenuGlowne, "Witaj w grze Koronawirus AntiPlague!\n"
						+ "- Gra polega na powstrzymaniu rozprzestrzenianiu siê wirusa w 10 krajach.\n"
						+ "- Postêpowanie wirusa mo¿na zatrzymaæ przez wykupowanie ulepszeñ, które wy³¹czaj¹ drogi rozsprzestrzeniania siê wirusa.\n"
						+ "- Ulepszenia kupuje siê za punkty. Gracz startuje z 9000 punktami. Punkty mo¿na uzyskaæ przez dotacje lub leczenie ludzi przez leki i szczepionki.\n"
						+ "- Gra koñczy siê, kiedy wirus zainfekuje ca³y œwiat, wszyscy ludze zostan¹ wyleczeni albo kiedy wszystkie drogi transportu zostan¹ wy³¹czone.\n"
						+ "- Po zakoñczeniu gry gracz podaje swoj¹ nazwê i jego wynik zapisywany jest w lokalnym rankingu.\n"
						+ "- Ostateczny wynik liczony jest wed³ug formu³y: PT * liczba ludzi zdrowych / czas, gdzie PT to odpowiednio: ³atwy = 1.0, œredni = 2.0, trudny = 3.0.\n"
						+ "- Ctrl+Shift+Q aby wy³¹czyæ grê i wróciæ do menu g³ownego.", "Informacje", JOptionPane.PLAIN_MESSAGE);
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
