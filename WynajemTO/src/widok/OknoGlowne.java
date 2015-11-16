package widok;

import javax.swing.JTabbedPane;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.util.Observer;
import java.util.Observable;

public class OknoGlowne extends JFrame implements Observer{
	
	JTabbedPane cards;
	WidokOplaty widokOplaty;
	WidokNajemne widokNajemne;
	
	public OknoGlowne()
	{
		super("Wynajem");
		initComponents();
	}
	
	private void initComponents()
	{
		JScrollPane WidokGlowny = new JScrollPane();
		cards = new JTabbedPane();
		WidokGlowny.setViewportView(cards);
		
		widokOplaty = new WidokOplaty();
		widokNajemne = new WidokNajemne();
		widokOplaty.dodajOknoGlowne(this);
		cards.addTab("Oplaty", null, widokOplaty, "Wyswietl, dodaj, edytuj, archiwizuj oplaty");
		cards.addTab("Najemne", null, widokNajemne, "Wyswietl, dodaj, edytuj, archiwizuj najemne");
		
		add(WidokGlowny);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public void update(Observable o, Object x)
	{		
		widokOplaty.update();
		widokNajemne.update();
	}
	
	public WidokOplaty getWidokOplaty(){
		return widokOplaty;
	}
	
	public WidokNajemne getWidokNajemne(){
		return widokNajemne;
	}
}
