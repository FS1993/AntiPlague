
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

public class KrajButton extends JButton {

	int populacja,
		zarazeni,
		zdrowi,
		wskaznik;
	String nazwa;
	Map<String, KrajButton> polaczenia;
	
	
	public KrajButton(int populacja, String nazwa) {
		super(nazwa);
		this.wskaznik = 0;
		this.populacja = populacja;
		this.nazwa = nazwa;
		this.zdrowi = populacja;
		this.zarazeni = 0;
		this.polaczenia = new HashMap<String, KrajButton>();
	}
	
}
