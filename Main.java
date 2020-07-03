
import java.awt.Component;

import javax.swing.*;

public class Main {

	private static final Component MenuGlowne = null;

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(()->new MenuGlowne());
		
		JOptionPane.showMessageDialog(MenuGlowne, "Witaj w grze Koronawirus AntiPlague!\n"  
										+ "- Gra polega na powstrzymaniu rozprzestrzenianiu si� wirusa w 10 krajach.\n"
										+ "- Post�powanie wirusa mo�na zatrzyma� przez wykupowanie ulepsze�, kt�re wy��czaj� drogi rozsprzestrzeniania si� wirusa.\n" 
										+ "- Ulepszenia kupuje si� za punkty. Gracz startuje z 9000 punktami. Punkty mo�na uzyska� przez dotacje lub leczenie ludzi przez leki i szczepionki.\n"  
										+ "- Gra ko�czy si�, kiedy wirus zainfekuje ca�y �wiat, wszyscy ludze zostan� wyleczeni albo kiedy wszystkie drogi transportu zostan� wy��czone.\n" 
										+ "- Po zako�czeniu gry gracz podaje swoj� nazw� i jego wynik zapisywany jest w lokalnym rankingu.\n"
										+ "- Ostateczny wynik liczony jest wed�ug formu�y: PT * liczba ludzi zdrowych / czas, gdzie PT to odpowiednio: �atwy = 1.0, �redni = 2.0, trudny = 3.0.\n"
										+ "- Ctrl+Shift+Q aby wy��czy� gr� i wr�ci� do menu g�ownego.", "Informacje", JOptionPane.PLAIN_MESSAGE);
	}

}
