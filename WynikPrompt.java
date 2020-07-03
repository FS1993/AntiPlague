
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;

public class WynikPrompt extends JFrame{

	String nazwa;
	List<Wynik> wyniki, wyniki2;
	public WynikPrompt(long wynik) {
		
		super("KONIEC GRY");
		wyniki = new LinkedList<>();
		wyniki2 = new ArrayList<>();
		JTextField wynikPrompt = new JTextField("Tutaj wpisz swoje imiê");
		add(wynikPrompt);
		JButton ok = new JButton("OK");
		add(ok);
		setVisible(true);
		setSize(250, 80);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		ok.addActionListener(new ActionListener(){
 		
			@Override
			public void actionPerformed(ActionEvent e) {
				nazwa = wynikPrompt.getText();
				setVisible(false);
				Wynik wynikObject = new Wynik();
				wynikObject.uzytkownik = nazwa;
				wynikObject.setWynik(wynik);
				try {
			         FileOutputStream fileOut =
			         new FileOutputStream("ranking.dat", true);
			         ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         out.writeObject(wynikObject);
			         out.close();
			         fileOut.close();
			      } catch (IOException i) {
			         i.printStackTrace();
			      }
				//zródlo: https://stackoverflow.com/questions/27409718/java-reading-multiple-objects-from-a-file-as-they-were-in-an-array
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
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
				//koniec informacji z powy¿szego zród³a.
			    SwingUtilities.invokeLater(()-> new Ranking(wyniki));
			    
			}
 		});
	}
}
