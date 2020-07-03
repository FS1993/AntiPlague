
import java.util.Comparator;
import java.util.List;

import javax.swing.*;


public class Ranking extends JFrame{

	public Ranking(List<Wynik> wyniki) {
		
		wyniki.sort(Comparator.comparingLong(Wynik::getWynik).reversed());
		
		String[] kolumny = {"Imiê", "Wynik"};
		Object[][] wynikiTab = new Object[wyniki.size()][2];
		int i = 0;
		for (Wynik wynik : wyniki) {
			wynikiTab[i][0]=wynik.uzytkownik;
			wynikiTab[i][1]=wynik.getWynik();
			i++;
		}
		
		JTable tablica = new JTable(wynikiTab, kolumny);
		JScrollPane jScrollPane = new JScrollPane(tablica);
		tablica.setEnabled(false);
		add(jScrollPane);
		setSize(200, 200);
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
