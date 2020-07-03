
import java.awt.Component;

import javax.swing.*;

public class Main {

	private static final Component MenuGlowne = null;

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(()->new MenuGlowne());
		
		JOptionPane.showMessageDialog(MenuGlowne, "Witaj w grze Koronawirus AntiPlague!\n"  
										+ "- Gra polega na powstrzymaniu rozprzestrzenianiu siê wirusa w 10 krajach.\n"
										+ "- Postêpowanie wirusa mo¿na zatrzymaæ przez wykupowanie ulepszeñ, które wy³¹czaj¹ drogi rozsprzestrzeniania siê wirusa.\n" 
										+ "- Ulepszenia kupuje siê za punkty. Gracz startuje z 9000 punktami. Punkty mo¿na uzyskaæ przez dotacje lub leczenie ludzi przez leki i szczepionki.\n"  
										+ "- Gra koñczy siê, kiedy wirus zainfekuje ca³y œwiat, wszyscy ludze zostan¹ wyleczeni albo kiedy wszystkie drogi transportu zostan¹ wy³¹czone.\n" 
										+ "- Po zakoñczeniu gry gracz podaje swoj¹ nazwê i jego wynik zapisywany jest w lokalnym rankingu.\n"
										+ "- Ostateczny wynik liczony jest wed³ug formu³y: PT * liczba ludzi zdrowych / czas, gdzie PT to odpowiednio: ³atwy = 1.0, œredni = 2.0, trudny = 3.0.\n"
										+ "- Ctrl+Shift+Q aby wy³¹czyæ grê i wróciæ do menu g³ownego.", "Informacje", JOptionPane.PLAIN_MESSAGE);
	}

}
