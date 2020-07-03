
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

public class KrajFrameSredni extends JFrame {
	
	private Component KrajFrameSredni;
	int kryterium1 = 0,
		kryterium2 = 0,
		kryterium3 = 0;
		
	
	public KrajFrameSredni(String nazwa, KrajButton kraj, List<KrajButton> kraje, Sredni poziomSredni, JTextField zarazeniTextField, JTextField punktyTextField) {
		
		super(nazwa);
		JTextField zarazeniKrajuTextField = new JTextField("Zara¿eni:   "+kraj.zarazeni);
		JTextField populacjaKrajuTextField = new JTextField("Populacja: "+kraj.populacja);
		JButton ulepszenie1 = new JButton("Skorzystaj z dotacji");
		JButton ulepszenie2 = new JButton("Kup leki");
		JButton ulepszenie3 = new JButton("Kup szczepionkê");
		JButton ulepszenie4 = new JButton("Œcis³a kwarantanna");
		JButton ulepszenie5 = new JButton("Zamknij szko³y");
		JButton ulepszenie6 = new JButton("Zamknij restauracje");
		JButton ulepszenie7 = new JButton("Kampania informacyjna");
		JButton ulepszenie8 = new JButton("Zatrudnij lekarzy");
		JButton ulepszenie9 = new JButton("Inne restrykcje");
		add(ulepszenie1);
		add(ulepszenie2);
		add(ulepszenie3);
		add(ulepszenie4);
		add(ulepszenie5);
		add(ulepszenie6);
		add(ulepszenie7);
		add(ulepszenie8);
		add(ulepszenie9);
		ulepszenie1.createToolTip();
		ulepszenie1.setToolTipText("Korzystasz z miêdzynarodowej pomocy i zyskujesz œrodki na wyleczenie 1000 zara¿onych. Odnawialne ulepszenie. Koszt 0.");
		ulepszenie2.createToolTip();
		ulepszenie2.setToolTipText("Kupujesz leki na zwalczenie wirusa. Leczy 500 osób co 10 sekund. Koszt 3000.");
		ulepszenie3.createToolTip();
		ulepszenie3.setToolTipText("Kupujesz szczepionkê na wirusa. Leczy 1000 osób co 10 sekund. Koszt 5000");
		ulepszenie4.createToolTip();
		ulepszenie4.setToolTipText("Kwarantanna zapobiega rozprzestrzenianiu siê wirusa wewn¹trz kraju. Tempo zara¿eñ zmniejsza siê o 1000. Koszt 9000.");
		ulepszenie5.createToolTip();
		ulepszenie5.setToolTipText("Zamknij szko³y i rozpocznij zdalne naucznie. Koszt 10000.");
		ulepszenie6.createToolTip();
		ulepszenie6.setToolTipText("Zamknij restauracje i daj pracê kurierom rozwo¿¹cym jedzenie. Koszt 10000.");
		ulepszenie7.createToolTip();
		ulepszenie7.setToolTipText("Poinformuj obywateli o skali zagro¿enia epidemiologicznego. Koszt 10000.");
		ulepszenie8.createToolTip();
		ulepszenie8.setToolTipText("Zatrudnij dodatkowych lekarzy do walki z wirusem. Koszt 10000.");
		ulepszenie9.createToolTip();
		ulepszenie9.setToolTipText("Wprowadz inne obostrzenia.");
		
		JTextField transport1TextField = new JTextField("Po³¹czenie 1 - aktywne");
		JTextField transport2TextField = new JTextField("Po³¹czenie 2 - aktywne");
		JTextField transport3TextField = new JTextField("Po³¹czenie 3 - aktywne");
		add(transport1TextField);
		add(transport2TextField);
		add(transport3TextField);
		transport1TextField.setEditable(false);
		transport2TextField.setEditable(false);
		transport3TextField.setEditable(false);
		
		add(zarazeniKrajuTextField);
		zarazeniKrajuTextField.setEditable(false);
		
		add(populacjaKrajuTextField);
		populacjaKrajuTextField.setEditable(false);
		Thread glowny = new Thread(()->{
			while(poziomSredni.zarazeniSwiata < poziomSredni.populacjaSwiata && poziomSredni.zarazeniSwiata > 0 ) {
				zarazeniKrajuTextField.setText("Zara¿eni:   "+kraj.zarazeni);
				if(kryterium1 == 2) {
					if(kraj.polaczenia.containsKey("Poci¹gi")) {
						kraj.polaczenia.remove("Poci¹gi");
						transport1TextField.setText("Po³aczenie 1 - wy³¹czone");
						kryterium1+=1;
					}
					else if (kraj.polaczenia.containsKey("Samoloty")) {
						kraj.polaczenia.remove("Samoloty");
						transport1TextField.setText("Po³aczenie 1 - wy³¹czone");
						kryterium1+=1;
					}
					else if (kraj.polaczenia.containsKey("Statki")) {
						kraj.polaczenia.remove("Statki");
						transport1TextField.setText("Po³aczenie 1 - wy³¹czone");
						kryterium1+=1;
					}
					else if (kraj.polaczenia.containsKey("Autokary")) {
						kraj.polaczenia.remove("Autokary");
						transport1TextField.setText("Po³aczenie 1 - wy³¹czone");
						kryterium1+=1;
					}
					else if (kraj.polaczenia.containsKey("Samochody")) {
						kraj.polaczenia.remove("Samochody");
						transport1TextField.setText("Po³aczenie 1 - wy³¹czone");
						kryterium1+=1;
					}
				}
				if(kryterium2 == 2) {
					if(kraj.polaczenia.containsKey("Poci¹gi")) {
						kraj.polaczenia.remove("Poci¹gi");
						transport2TextField.setText("Po³aczenie 2 - wy³¹czone");
						kryterium2+=1;
					}
					else if (kraj.polaczenia.containsKey("Samoloty")) {
						kraj.polaczenia.remove("Samoloty");
						transport2TextField.setText("Po³aczenie 2 - wy³¹czone");
						kryterium2+=1;
					}
					else if (kraj.polaczenia.containsKey("Statki")) {
						kraj.polaczenia.remove("Statki");
						transport2TextField.setText("Po³aczenie 2 - wy³¹czone");
						kryterium2+=1;
					}
					else if (kraj.polaczenia.containsKey("Autokary")) {
						kraj.polaczenia.remove("Autokary");
						transport2TextField.setText("Po³aczenie 2 - wy³¹czone");
						kryterium2+=1;
					}
					else if (kraj.polaczenia.containsKey("Samochody")) {
						kraj.polaczenia.remove("Samochody");
						transport2TextField.setText("Po³aczenie 2 - wy³¹czone");
						kryterium2+=1;
					}
				}
				if(kryterium3 == 2) {
					if(kraj.polaczenia.containsKey("Poci¹gi")) {
						kraj.polaczenia.remove("Poci¹gi");
						transport3TextField.setText("Po³aczenie 3 - wy³¹czone");
						kryterium3+=1;
					}
					else if (kraj.polaczenia.containsKey("Samoloty")) {
						kraj.polaczenia.remove("Samoloty");
						transport3TextField.setText("Po³aczenie 3 - wy³¹czone");
						kryterium3+=1;
					}
					else if (kraj.polaczenia.containsKey("Statki")) {
						kraj.polaczenia.remove("Statki");
						transport3TextField.setText("Po³aczenie 3 - wy³¹czone");
						kryterium3+=1;
					}
					else if (kraj.polaczenia.containsKey("Autokary")) {
						kraj.polaczenia.remove("Autokary");
						transport3TextField.setText("Po³aczenie 3 - wy³¹czone");
						kryterium3+=1;
					}
					else if (kraj.polaczenia.containsKey("Samochody")) {
						kraj.polaczenia.remove("Samochody");
						transport3TextField.setText("Po³aczenie 3 - wy³¹czone");
						kryterium3+=1;
					}
				}
				if(kryterium1 == 3 && kryterium2 == 3 && kryterium3 == 3) {
					kraj.wskaznik = 1;
					kraj.polaczenia = null;
					
					break;
					
				}
			}
		});
		glowny.start();
		
		Thread leki = new Thread(()->{
			while(poziomSredni.zarazeniSwiata <= poziomSredni.populacjaSwiata && poziomSredni.zarazeniSwiata >= 0 ) {
				poziomSredni.punkty+= 500;
				punktyTextField.setText("Punkty: "+poziomSredni.punkty);
				if(poziomSredni.zarazeniSwiata > 0)
					poziomSredni.zarazeniSwiata-=500;
				if(kraj.zarazeni > 0)
					kraj.zarazeni-=500;
				zarazeniTextField.setText("Zara¿eni: " + poziomSredni.zarazeniSwiata);
				zarazeniKrajuTextField.setText("Zara¿eni: " + kraj.zarazeni);
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		Thread wirusWew = new Thread(()->{
			while(poziomSredni.zarazeniSwiata < poziomSredni.populacjaSwiata && poziomSredni.zarazeniSwiata > 0 ) {
				if(kraj.zarazeni > 0) {
					kraj.zarazeni+=10000;
					zarazeniKrajuTextField.setText("Zara¿eni:   "+kraj.zarazeni);
					if (kraj.zarazeni >= kraj.populacja) {
						kraj.zarazeni = kraj.populacja;
					}
				}
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		wirusWew.start();
		
		
		
		Thread szczepionka = new Thread(()->{
			while(poziomSredni.zarazeniSwiata <= poziomSredni.populacjaSwiata && poziomSredni.zarazeniSwiata >= 0 ) {
				poziomSredni.punkty+= 1000;
				punktyTextField.setText("Punkty: "+poziomSredni.punkty);
				if(poziomSredni.zarazeniSwiata > 0)
					poziomSredni.zarazeniSwiata-=1000;
				if(kraj.zarazeni > 0)
					kraj.zarazeni-=1000;
				zarazeniTextField.setText("Zara¿eni: " + poziomSredni.zarazeniSwiata);
				zarazeniKrajuTextField.setText("Zara¿eni: " + kraj.zarazeni);
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		ulepszenie1.addActionListener(new ActionListener(){
		 		 	
					@Override
					public void actionPerformed(ActionEvent e) {
						poziomSredni.punkty+= 1000;
						punktyTextField.setText("Punkty: "+poziomSredni.punkty);
						poziomSredni.zarazeniSwiata-=1000;
						kraj.zarazeni-=1000;
						zarazeniTextField.setText("Zara¿eni: " + poziomSredni.zarazeniSwiata);
						zarazeniKrajuTextField.setText("Zara¿eni: " + kraj.zarazeni);
						Thread cooldown = new Thread(()->{ 
							ulepszenie1.setEnabled(false);
							try {
								Thread.sleep(10000);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
							ulepszenie1.setEnabled(true);
						});
						cooldown.start();
						
					}
		 		});
		
		ulepszenie2.addActionListener(new ActionListener(){
 		 	
			

			@Override
			public void actionPerformed(ActionEvent e) {
				if (poziomSredni.punkty >= 3000) {
					poziomSredni.punkty-=3000;
					leki.start();
					ulepszenie2.setEnabled(false);
				}
				else {
					JOptionPane.showMessageDialog(KrajFrameSredni, "Brakuje ci punktów, ¿eby kupiæ to ulepszenie.", "Brak punktów", JOptionPane.WARNING_MESSAGE);
				}
			}
 		});
		
		ulepszenie3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if (poziomSredni.punkty >= 5000) {
					poziomSredni.punkty-=5000;
					szczepionka.start();
					ulepszenie3.setEnabled(false);
				}
				else {
					JOptionPane.showMessageDialog(KrajFrameSredni, "Brakuje ci punktów, ¿eby kupiæ to ulepszenie.", "Brak punktów", JOptionPane.WARNING_MESSAGE);
				}
			}
 		});
		
		ulepszenie4.addActionListener(new ActionListener(){
 		 	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (poziomSredni.punkty >= 9000) {
					poziomSredni.punkty-=9000;
					punktyTextField.setText("Punkty: "+poziomSredni.punkty);
					wirusWew.stop();
					ulepszenie4.setEnabled(false);
					kryterium1+=1;
				}
				else {
					JOptionPane.showMessageDialog(KrajFrameSredni, "Brakuje ci punktów, ¿eby kupiæ to ulepszenie.", "Brak punktów", JOptionPane.WARNING_MESSAGE);
				}
			}
 		});
		
		ulepszenie5.addActionListener(new ActionListener(){
 		 	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (poziomSredni.punkty >= 10000) {
					poziomSredni.punkty-=10000;
					punktyTextField.setText("Punkty: "+poziomSredni.punkty);
					ulepszenie5.setEnabled(false);
					kryterium1+=1;
				}
				else {
					JOptionPane.showMessageDialog(KrajFrameSredni, "Brakuje ci punktów, ¿eby kupiæ to ulepszenie.", "Brak punktów", JOptionPane.WARNING_MESSAGE);
				}
			}
 		});
		
		ulepszenie6.addActionListener(new ActionListener(){
 		 	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (poziomSredni.punkty >= 10000) {
					poziomSredni.punkty-=10000;
					punktyTextField.setText("Punkty: "+poziomSredni.punkty);
					ulepszenie6.setEnabled(false);
					kryterium2+=1;
				}
				else {
					JOptionPane.showMessageDialog(KrajFrameSredni, "Brakuje ci punktów, ¿eby kupiæ to ulepszenie.", "Brak punktów", JOptionPane.WARNING_MESSAGE);
				}
			}
 		});
		
		ulepszenie7.addActionListener(new ActionListener(){
 		 	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (poziomSredni.punkty >= 10000) {
					poziomSredni.punkty-=10000;
					punktyTextField.setText("Punkty: "+poziomSredni.punkty);
					ulepszenie7.setEnabled(false);
					kryterium2+=1;
				}
				else {
					JOptionPane.showMessageDialog(KrajFrameSredni, "Brakuje ci punktów, ¿eby kupiæ to ulepszenie.", "Brak punktów", JOptionPane.WARNING_MESSAGE);
				}
			}
 		});
		
		ulepszenie8.addActionListener(new ActionListener(){
 		 	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (poziomSredni.punkty >= 10000) {
					poziomSredni.punkty-=10000;
					punktyTextField.setText("Punkty: "+poziomSredni.punkty);
					ulepszenie8.setEnabled(false);
					kryterium3+=1;
				}
				else {
					JOptionPane.showMessageDialog(KrajFrameSredni, "Brakuje ci punktów, ¿eby kupiæ to ulepszenie.", "Brak punktów", JOptionPane.WARNING_MESSAGE);
				}
			}
 		});
		
		ulepszenie9.addActionListener(new ActionListener(){
 		 	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (poziomSredni.punkty >= 10000) {
					poziomSredni.punkty-=10000;
					punktyTextField.setText("Punkty: "+poziomSredni.punkty);
					ulepszenie9.setEnabled(false);
					kryterium3+=1;
				}
				else {
					JOptionPane.showMessageDialog(KrajFrameSredni, "Brakuje ci punktów, ¿eby kupiæ to ulepszenie.", "Brak punktów", JOptionPane.WARNING_MESSAGE);
				}
			}
 		});
		
		
		
		
		setSize(200, 450);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
	}
}
