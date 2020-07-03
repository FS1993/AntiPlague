
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;

public class Sredni extends JFrame{

	List<KrajButton> kraje;
	int wskaznik = 0;
	long populacjaSwiata = 0,
		zarazeniSwiata = 10000,
		zdrowiSwiata = 0,
		punkty = 9000;
	long czas = 0;
	boolean shiftPressed, ctrlPressed, qPressed;
	public Sredni() {
		
		
		setSize(200, 350);
		kraje = new LinkedList<KrajButton>();
		
		KrajButton polskaButton = new KrajButton(38000000, "Polska");
		kraje.add(polskaButton);
		add(polskaButton);
		
		KrajButton chinyButton = new KrajButton(1393000000, "Chiny");
		kraje.add(chinyButton);
		add(chinyButton);
		chinyButton.zarazeni = 10000;
		
		KrajButton rosjaButton = new KrajButton(1445000, "Rosja");
		kraje.add(rosjaButton);
		add(rosjaButton);
		
		KrajButton usaButton = new KrajButton(3282000, "USA");
		kraje.add(usaButton);
		add(usaButton);
		
		KrajButton brazyliaButton = new KrajButton(2095000, "Brazylia");
		kraje.add(brazyliaButton);
		add(brazyliaButton);
		
		KrajButton indieButton = new KrajButton(1353000000, "Indie");
		kraje.add(indieButton);
		add(indieButton);
		
		KrajButton japoniaButton = new KrajButton(1265000, "Japonia");
		kraje.add(japoniaButton);
		add(japoniaButton);
		
		KrajButton rpaButton = new KrajButton(5778000, "RPA");
		kraje.add(rpaButton);
		add(rpaButton);
		
		KrajButton niemcyButton = new KrajButton(8302000, "Niemcy");
		kraje.add(niemcyButton);
		add(niemcyButton);
		
		KrajButton ukButton = new KrajButton(6665000, "UK");
		kraje.add(ukButton);
		add(ukButton);
		
		//Pol¹czenia
		polskaButton.polaczenia.put("Autokary", niemcyButton);
		polskaButton.polaczenia.put("Samochody", ukButton);
		polskaButton.polaczenia.put("Poci¹gi", rosjaButton);
		
		niemcyButton.polaczenia.put("Autokary", polskaButton);
		niemcyButton.polaczenia.put("Samoloty", usaButton);
		niemcyButton.polaczenia.put("Samochody", rosjaButton);
		
		rosjaButton.polaczenia.put("Samochody", niemcyButton);
		rosjaButton.polaczenia.put("Poci¹gi", polskaButton);
		rosjaButton.polaczenia.put("Autokary", chinyButton);
		
		ukButton.polaczenia.put("Samochody", polskaButton);
		ukButton.polaczenia.put("Statki", usaButton);
		ukButton.polaczenia.put("Samoloty", chinyButton);
		
		chinyButton.polaczenia.put("Samoloty", ukButton);
		chinyButton.polaczenia.put("Autokary", rosjaButton);
		chinyButton.polaczenia.put("Poci¹gi", indieButton);
		
		usaButton.polaczenia.put("Samoloty", niemcyButton);
		usaButton.polaczenia.put("Statki", ukButton);
		usaButton.polaczenia.put("Samochody", brazyliaButton);
		
		indieButton.polaczenia.put("Poci¹gi", chinyButton);
		indieButton.polaczenia.put("Autokary", japoniaButton);
		indieButton.polaczenia.put("Samoloty", rpaButton);
		
		rpaButton.polaczenia.put("Samoloty", indieButton);
		rpaButton.polaczenia.put("Statki", brazyliaButton);
		rpaButton.polaczenia.put("Samochody", japoniaButton);
		
		brazyliaButton.polaczenia.put("Statki", rpaButton);
		brazyliaButton.polaczenia.put("Samochody", usaButton);
		brazyliaButton.polaczenia.put("Poci¹gi", japoniaButton);
		
		japoniaButton.polaczenia.put("Poci¹gi", brazyliaButton);
		japoniaButton.polaczenia.put("Samochody", rpaButton);
		japoniaButton.polaczenia.put("Autokary", indieButton);
		
		
		
		
		JTextField zarazeniTextField = new JTextField("Zara¿eni:   "+zarazeniSwiata);
		add(zarazeniTextField);
		zarazeniTextField.setEditable(false);
		
		for (KrajButton kraj : kraje) {
			populacjaSwiata += kraj.populacja;
		}
		zdrowiSwiata = populacjaSwiata - 10000;
		
		JTextField populacjaTextField = new JTextField("Populacja: "+populacjaSwiata);
		add(populacjaTextField);
		populacjaTextField.setEditable(false);
		
		JTextField punktyTextField = new JTextField("Punkty: "+ punkty);
		add(punktyTextField);
		punktyTextField.setEditable(false);
		
		JTextField licznikTextField = new JTextField("Czas: 0h 0m 0s");
		add(licznikTextField);
		licznikTextField.setEditable(false);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//Inicalizacja krajFrame-ów
		KrajFrameSredni polska = new KrajFrameSredni("Polska", polskaButton, kraje, this, zarazeniTextField, punktyTextField);
		polska.setVisible(false);
		polska.setDefaultCloseOperation(HIDE_ON_CLOSE);
		polska.setLocation(50, 50);
		
		KrajFrameSredni chiny = new KrajFrameSredni("Chiny", chinyButton, kraje, this, zarazeniTextField, punktyTextField);
		chiny.setVisible(false);
		chiny.setDefaultCloseOperation(HIDE_ON_CLOSE);
		chiny.setLocation(240, 50);
		
		KrajFrameSredni rosja = new KrajFrameSredni("Rosja", rosjaButton, kraje, this, zarazeniTextField, punktyTextField);
		rosja.setVisible(false);
		rosja.setDefaultCloseOperation(HIDE_ON_CLOSE);
		rosja.setLocation(430, 50);
		
		KrajFrameSredni usa = new KrajFrameSredni("USA", usaButton, kraje, this, zarazeniTextField, punktyTextField);
		usa.setVisible(false);
		usa.setDefaultCloseOperation(HIDE_ON_CLOSE);
		usa.setLocation(860, 50);
		
		KrajFrameSredni brazylia = new KrajFrameSredni("Brazylia", brazyliaButton, kraje, this, zarazeniTextField, punktyTextField);
		brazylia.setVisible(false);
		brazylia.setDefaultCloseOperation(HIDE_ON_CLOSE);
		brazylia.setLocation(1060, 50);
		
		KrajFrameSredni indie = new KrajFrameSredni("Indie", indieButton, kraje, this, zarazeniTextField, punktyTextField);
		indie.setVisible(false);
		indie.setDefaultCloseOperation(HIDE_ON_CLOSE);
		indie.setLocation(1260, 50);
		
		KrajFrameSredni japonia = new KrajFrameSredni("Japonia", japoniaButton, kraje, this, zarazeniTextField, punktyTextField);
		japonia.setVisible(false);
		japonia.setDefaultCloseOperation(HIDE_ON_CLOSE);
		japonia.setLocation(50, 400);
		
		KrajFrameSredni rpa = new KrajFrameSredni("RPA", rpaButton, kraje, this, zarazeniTextField, punktyTextField);
		rpa.setVisible(false);
		rpa.setDefaultCloseOperation(HIDE_ON_CLOSE);
		rpa.setLocation(240, 400);
		
		KrajFrameSredni niemcy = new KrajFrameSredni("Niemcy", niemcyButton, kraje, this, zarazeniTextField, punktyTextField);
		niemcy.setVisible(false);
		niemcy.setDefaultCloseOperation(HIDE_ON_CLOSE);
		niemcy.setLocation(430, 400);
		
		KrajFrameSredni uk = new KrajFrameSredni("Wielka Brytania", ukButton, kraje, this, zarazeniTextField, punktyTextField);
		uk.setVisible(false);
		uk.setDefaultCloseOperation(HIDE_ON_CLOSE);
		uk.setLocation(860, 400);
		
		polskaButton.addActionListener(new ActionListener(){
 		 	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(polska.isVisible()) {
					polska.setVisible(false);
				}
				else {
					polska.setVisible(true);
				}
			}
 		});
		
		chinyButton.addActionListener(new ActionListener(){
 		 	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chiny.isVisible()) {
					chiny.setVisible(false);
				}
				else {
					chiny.setVisible(true);
				}
			}
 		});
		
		rosjaButton.addActionListener(new ActionListener(){
 		 	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rosja.isVisible()) {
					rosja.setVisible(false);
				}
				else {
					rosja.setVisible(true);
				}
			}
 		});
		
		usaButton.addActionListener(new ActionListener(){
 		 	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(usa.isVisible()) {
					usa.setVisible(false);
				}
				else {
					usa.setVisible(true);
				}
			}
 		});
		
		brazyliaButton.addActionListener(new ActionListener(){
 		 	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(brazylia.isVisible()) {
					brazylia.setVisible(false);
				}
				else {
					brazylia.setVisible(true);
				}
			}
 		});
		
		indieButton.addActionListener(new ActionListener(){
 		 	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(indie.isVisible()) {
					indie.setVisible(false);
				}
				else {
					indie.setVisible(true);
				}
			}
 		});
		
		rpaButton.addActionListener(new ActionListener(){
 		 	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rpa.isVisible()) {
					rpa.setVisible(false);
				}
				else {
					rpa.setVisible(true);
				}
			}
 		});
		
		japoniaButton.addActionListener(new ActionListener(){
 		 	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(japonia.isVisible()) {
					japonia.setVisible(false);
				}
				else {
					japonia.setVisible(true);
				}
			}
 		});
		
		niemcyButton.addActionListener(new ActionListener(){
 		 	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(niemcy.isVisible()) {
					niemcy.setVisible(false);
				}
				else {
					niemcy.setVisible(true);
				}
			}
 		});
		
		ukButton.addActionListener(new ActionListener(){
 		 	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(uk.isVisible()) {
					uk.setVisible(false);
				}
				else {
					uk.setVisible(true);
				}
			}
 		});
		
		
		polskaButton.addKeyListener((KeyListener) new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == 17) {
					ctrlPressed = true;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
	
				if(e.getKeyCode() == 17) {
					ctrlPressed = false;
				}
			}
			
		});
		
		polskaButton.addKeyListener((KeyListener) new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == 16) {
					shiftPressed = true;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
	
				if(e.getKeyCode() == 16) {
					shiftPressed = false;
				}
			}
			
		});
		
		polskaButton.addKeyListener((KeyListener) new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == 81) {
					qPressed = true;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
	
				if(e.getKeyCode() == 81) {
					qPressed = false;
				}
			}
			
		});
			
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		Thread wirus = new Thread(() -> {while(zarazeniSwiata < populacjaSwiata) {
											for(KrajButton kraj : kraje ) {
												if(kraj.polaczenia != null) {	//!kraj.polaczenia.values().isEmpty()					
													for (KrajButton kraj2 : kraj.polaczenia.values()){
														if(kraj2.zarazeni != 0) {
															if(kraj.zarazeni < kraj.populacja) {
																kraj.zarazeni+=10000;
																zarazeniSwiata+=10000;
																zarazeniTextField.setText("Zara¿eni:   "+zarazeniSwiata);
															}
															else {
																kraj.zarazeni = kraj.populacja;
															}
														}
													}
												}
												
											}
											try {
												Thread.sleep(Duration.ofSeconds(5).toMillis());
											} catch (InterruptedException e) {
												e.printStackTrace();
											}
										}
										});
		wirus.start();
		
		Timer licznik = new Timer(1000, new ActionListener() {
			int sekundy = 0,
				minuty = 0,
				godziny = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				sekundy+=1;
				czas +=1;
				licznikTextField.setText("Czas: "+godziny+"h "+minuty+"m "+sekundy+"s");
				if(sekundy == 60) {
					minuty+=1;
					sekundy = 0;
					licznikTextField.setText("Czas: "+godziny+"h "+minuty+"m "+sekundy+"s");
				}
				if(minuty == 60) {
					minuty = 0;
					godziny+=1;
					licznikTextField.setText("Czas: "+godziny+"h "+minuty+"m "+sekundy+"s");
				}
			}
			
		});
		
		licznik.start();
		Thread glowny = new Thread(()->{
			System.out.println("W¹tek dzia³a");
			while(true) {
				if(ctrlPressed == true && shiftPressed == true && qPressed == true) {
					this.setVisible(false);
					polska.setVisible(false);
					chiny.setVisible(false);
					usa.setVisible(false);
					rosja.setVisible(false);
					brazylia.setVisible(false);
					indie.setVisible(false);
					japonia.setVisible(false);
					uk.setVisible(false);
					niemcy.setVisible(false);
					rpa.setVisible(false);
					wirus.stop();
					licznik.stop();
					SwingUtilities.invokeLater(()->new MenuGlowne());
					break;
				}
				int suma = 0;
				for (KrajButton kraj : kraje) {
					suma += kraj.wskaznik;
				}
				if((zarazeniSwiata >= populacjaSwiata) || 
						suma == 10				
						||
						(zarazeniSwiata <= 0) ) {
					long wynik = 2*(populacjaSwiata - zarazeniSwiata)/(czas);
					SwingUtilities.invokeLater(()->new WynikPrompt(wynik));
					
					break;
				}
			}
		});
		glowny.start();
	}
}

