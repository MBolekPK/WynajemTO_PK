package widok;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.JFrame;

import typy.WierszNajemne;
import widok_wprowadzanie_danych.WidokWprowadzanieDanychNajemne;
import model.AktualneDane;
import model.TableModelNajemne;
import model.ModelBD;

public class WidokNajemne extends JPanel{
		ModelBD modelBD;
	//Tutaj stale dla GridBagLayout
		final static boolean shouldFill = true;
		final static boolean shouldWeightX = true;
		//----------------------------

		private JButton dodajNajemne;
		private JButton usunNajemne;
		private JButton modyfikujNajemne;
		private JButton archiwizujNajemne;
		private JTable tabelaNajemnego;
		private JLabel zaleglosciNajemne;
		private JLabel zaleglosciCalkowite;
		
		private JFrame oknoGlowne;
		
		public WidokNajemne(){
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		dodajNajemne = new JButton("Dodaj");
		usunNajemne = new JButton("Usun");
		modyfikujNajemne = new JButton("Modyfikuj");
		archiwizujNajemne = new JButton("Archiwizuj");
		
		Box przyciski = Box.createVerticalBox();
		przyciski.add(dodajNajemne);
		przyciski.add(usunNajemne);
		przyciski.add(modyfikujNajemne);
		przyciski.add(archiwizujNajemne);
		
		przyciski.setBorder(new TitledBorder("Menu"));
		
		tabelaNajemnego = new JTable(new TableModelNajemne());
		
		JScrollPane tabelaNajemnegoScrollPane = new JScrollPane(tabelaNajemnego, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tabelaNajemnego.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabelaNajemnegoScrollPane.setViewportView(tabelaNajemnego);
		
		for(int x = 0, y = tabelaNajemnego.getColumnCount(); x < y; x++)
		{
		  tabelaNajemnego.getColumnModel().getColumn(x).setPreferredWidth(100);
		}
		
		tabelaNajemnegoScrollPane.setBorder(new TitledBorder("Tabela najemnego"));
		
		JPanel statystykiNajemne = new JPanel(new GridLayout(2, 2));
		JLabel zaleglosciNajemneLabel = new JLabel("Zaleglosci - Najemne");
		zaleglosciNajemne = new JLabel("0");
		JLabel zaleglosciCalkowiteLabel = new JLabel("Zaleglosci - Calkowite");
		zaleglosciCalkowite = new JLabel("0");
		
		statystykiNajemne.add(zaleglosciNajemneLabel);
		statystykiNajemne.add(zaleglosciCalkowiteLabel);
		statystykiNajemne.add(zaleglosciNajemne);
		statystykiNajemne.add(zaleglosciCalkowite);
		
		statystykiNajemne.setBorder(new TitledBorder("Statystyki"));
		
		//Dodaje elementy do menagera widoku oplat.
			if (shouldFill) {
			    c.fill = GridBagConstraints.HORIZONTAL;
			    }
			if (shouldWeightX) {
			    c.weightx = 0.5;
			    }
			//dodaje tabele
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 1;
			c.gridy = 0;
			c.gridwidth = 4;
			c.gridheight = 3;
			add(tabelaNajemnegoScrollPane, c);
			//dodaje przyciski
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridy = 0;
			c.gridwidth = 1;
			c.gridheight = 3;
			add(przyciski, c);
			//dodaje statystyki
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridy = 3;
			c.gridwidth = 5;
			add(statystykiNajemne, c);
		}
		public JTable getTable(){
			return this.tabelaNajemnego;
		}
		public void oknoWprowadzaniaDanychNajemne(WierszNajemne wN){
			WidokWprowadzanieDanychNajemne owdn = new WidokWprowadzanieDanychNajemne(oknoGlowne, wN, modelBD);
		}
		public void dodajOknoGlowne(JFrame oknoGlowne){
			this.oknoGlowne = oknoGlowne;
		}
		public void addController(ActionListener controller){
			dodajNajemne.addActionListener(controller);
			usunNajemne.addActionListener(controller);
			modyfikujNajemne.addActionListener(controller);
		}
		public void addModel(ModelBD modelBD){
			this.modelBD = modelBD;
		}
		public void nieWybranoPozycji(){
			JOptionPane.showMessageDialog(this.oknoGlowne, "Nie wybrano zadnej pozycji.");
		}
		public void update(){
			((TableModelNajemne)(tabelaNajemnego.getModel())).update();
			zaleglosciNajemne.setText(String.valueOf(AktualneDane.zaleglosciNajemne));
			zaleglosciCalkowite.setText(String.valueOf(AktualneDane.zaleglosciCalkowite));
			
		}
}
