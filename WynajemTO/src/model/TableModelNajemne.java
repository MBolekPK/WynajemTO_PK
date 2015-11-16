package model;

import javax.swing.table.DefaultTableModel;

import typy.WierszNajemne;

public class TableModelNajemne extends DefaultTableModel {

	private String[] columnNames = {"Id",
			"Data",
			"Opis",
			"Termin platnosci",
			"Kwota",
			"Stan",
			"Data Oplacenia"		
};

Class types[] = new Class[] {Integer.class, String.class, String.class, String.class,
							Double.class, Boolean.class, String.class}; //zmien tutaj

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
	for (WierszNajemne wn : AktualneDane.listaNajemnego)
	{
	Object [] wiersz = new Object [] {wn.getId(), wn.getData(), wn.getOpis(), wn.getTerminPlatnosci(),
			   wn.getKwota(), wn.getStan(), wn.getDataOplacenia()};
	addRow(wiersz);
	}
	
	this.fireTableDataChanged();
}

}
