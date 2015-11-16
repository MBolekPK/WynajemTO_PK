package widok;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JComboBox;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.ControllerWprowadzanieDanychOplaty;
import model.TableModelOplaty;
import typy.WierszNajemne;
import typy.WierszOplaty;
import widok_wprowadzanie_danych.WidokWprowadzanieDanychNajemne;
import widok_wprowadzanie_danych.WidokWprowadzanieDanychOplaty;
import model.AktualneDane;
import model.ModelBD;

public class WidokOplaty extends javax.swing.JPanel{
	private ModelBD modelBD;
	//Tutaj stale dla GridBagLayout
	final static boolean shouldFill = true;
	final static boolean shouldWeightX = true;
	//----------------------------

	private JButton dodajOplate;
	private JButton usunOplate;
	private JButton modyfikujOplate;
	private JButton archiwizujOplate;
	private JTable tabelaOplat;
	private JLabel zaleglosciAdministrator;
	private JLabel zaleglosciWynajmujacy;
	
	private ActionListener oknoDialogoweController;
	private JFrame oknoGlowne;
	
	public WidokOplaty(){
	setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	
	dodajOplate = new JButton("Dodaj");
	usunOplate = new JButton("Usun");
	modyfikujOplate = new JButton("Modyfikuj");
	archiwizujOplate = new JButton("Archiwizuj");
	
	Box przyciski = Box.createVerticalBox();
	przyciski.add(dodajOplate);
	przyciski.add(usunOplate);
	przyciski.add(modyfikujOplate);
	przyciski.add(archiwizujOplate);
	
	przyciski.setBorder(new TitledBorder("Menu"));
	
	tabelaOplat = new JTable(new TableModelOplaty());
	
	JScrollPane tabelaOplatScrollPane = new JScrollPane(tabelaOplat, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	tabelaOplatScrollPane.setViewportView(tabelaOplat);
	tabelaOplat.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	tabelaOplatScrollPane.setBorder(new TitledBorder("Tabela oplat"));
	
	for(int x = 0, y = tabelaOplat.getColumnCount(); x < y; x++)
	{
	  tabelaOplat.getColumnModel().getColumn(x).setPreferredWidth(80);
	}
	
	JPanel statystykiOplaty = new JPanel(new GridLayout(2, 2));
	JLabel zaleglosciAdministratorLabel = new JLabel("Zaleglosci - Administrator");
	zaleglosciAdministrator = new JLabel("0");
	JLabel zaleglosciWynajmujacyLabel = new JLabel("Zaleglosci - Wynajmujacy");
	zaleglosciWynajmujacy = new JLabel("0");
	
	statystykiOplaty.add(zaleglosciAdministratorLabel);
	statystykiOplaty.add(zaleglosciWynajmujacyLabel);
	statystykiOplaty.add(zaleglosciAdministrator);
	statystykiOplaty.add(zaleglosciWynajmujacy);
	
	statystykiOplaty.setBorder(new TitledBorder("Statystyki"));
	
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
		add(tabelaOplatScrollPane, c);
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
		add(statystykiOplaty, c);
	}
	public JTable getTable(){
		return this.tabelaOplat;
	}
	public void oknoWprowadzaniaDanychOplaty(WierszOplaty wO){
		WidokWprowadzanieDanychOplaty owdo = new WidokWprowadzanieDanychOplaty(oknoGlowne, wO, modelBD);
	}
	
	public void dodajOknoGlowne(JFrame oknoGlowne){
		this.oknoGlowne = oknoGlowne;
	}
	
	public void addController(ActionListener controller){
		dodajOplate.addActionListener(controller);
		usunOplate.addActionListener(controller);
		modyfikujOplate.addActionListener(controller);
	}
	public void addControllerWidokWprowadzania(ActionListener oknoDialogoweController){
		this.oknoDialogoweController = oknoDialogoweController;
	}
	public void addModel(ModelBD modelBD){
		this.modelBD = modelBD;
	}
	
	public void nieWybranoPozycji(){
		JOptionPane.showMessageDialog(this.oknoGlowne, "Nie wybrano zadnej pozycji.");
	}
	public void update(){
		((TableModelOplaty)(tabelaOplat.getModel())).update();
		zaleglosciAdministrator.setText(String.valueOf(AktualneDane.zaleglosciAdministrator));
		zaleglosciWynajmujacy.setText(String.valueOf(AktualneDane.zaleglosciWynajmujacy));
		
	}
}
