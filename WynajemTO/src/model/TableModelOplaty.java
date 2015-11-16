package model;

import javax.swing.table.DefaultTableModel;

import model.AktualneDane;
import typy.WierszOplaty;

public class TableModelOplaty extends DefaultTableModel {	
	private String[] columnNames = {"Id", //zmien tutaj
			"Data",
			"Opis",
			"Termin platnosci",
			"Nr faktury",
			"Kwota",
			"Stan-Administrator",
			"Data Oplacenia - A.",
			"Stan-Wynajmujacy",
			"Data Oplacenia - W"
};

Class types[] = new Class[] {Integer.class, String.class, String.class, String.class, String.class,
							Double.class, Boolean.class, String.class, 
							 Boolean.class, String.class}; //zmien tutaj

@Override
public int getColumnCount() {
	return columnNames.length;
}
@Override
public String getColumnName(int col) {
	return columnNames[col];
}
@Override
public Class getColumnClass(int c) {
	return types[c];
}
@Override
public boolean isCellEditable(int row, int column) {
    return false;
 }

public void update(){
	this.setRowCount(0);
	
	for (WierszOplaty wo : AktualneDane.listaOplat)
	{
	Object [] wiersz = {wo.getId(), wo.getData(), wo.getOpis(), wo.getTerminPlatnosci(), wo.getNrFaktury(),
			   wo.getKwota(), wo.getStanAdministrator(), wo.getDataOplaceniaAdministrator(),
			   wo.getStanWynajmujacy(), wo.getDataOplaceniaWynajmujacy()};
	this.addRow(wiersz);
	}

	this.fireTableDataChanged();
}

}
