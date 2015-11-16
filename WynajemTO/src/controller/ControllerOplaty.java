package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import widok.WidokOplaty;
import typy.WierszOplaty;
import model.ModelBD;

public class ControllerOplaty implements ActionListener{
	WidokOplaty widokOplaty;
	ModelBD modelBD;
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("Dodaj"))
		{
			WierszOplaty wo = new WierszOplaty();
			wo = null;
			widokOplaty.oknoWprowadzaniaDanychOplaty(wo);
		}
		else if(e.getActionCommand().equals("Modyfikuj"))
		{
			if (widokOplaty.getTable().getSelectedRow() == -1){
				widokOplaty.nieWybranoPozycji();
			}else
			{
			int row = widokOplaty.getTable().getSelectedRow();
			WierszOplaty wx = new WierszOplaty((int)widokOplaty.getTable().getValueAt(row, 0),
											   (String)widokOplaty.getTable().getValueAt(row, 1),
											   (String)widokOplaty.getTable().getValueAt(row, 2),
											   (String)widokOplaty.getTable().getValueAt(row, 3),
											   (String)widokOplaty.getTable().getValueAt(row, 4),
											   (Double)widokOplaty.getTable().getValueAt(row, 5),
											   (Boolean)widokOplaty.getTable().getValueAt(row, 6),
											   (widokOplaty.getTable().getValueAt(row, 7)==null?"":(String)widokOplaty.getTable().getValueAt(row, 7)),
											   (Boolean)widokOplaty.getTable().getValueAt(row, 8),
											   (widokOplaty.getTable().getValueAt(row, 9)==null?"":(String)widokOplaty.getTable().getValueAt(row, 9))
											   );
			widokOplaty.oknoWprowadzaniaDanychOplaty(wx);
			}
		}
		else if(e.getActionCommand().equals("Usun"))
		{
			if (widokOplaty.getTable().getSelectedRow() == -1){
			widokOplaty.nieWybranoPozycji();
			}else{
				modelBD.usunOplate((int)(widokOplaty.getTable().getValueAt((widokOplaty.getTable().getSelectedRow()),0)));
			}
			{
		}	
		}
	}
	
public void addView(WidokOplaty widokOplaty){
	this.widokOplaty = widokOplaty;
}
public void addModel(ModelBD modelBD){
	this.modelBD = modelBD;
}
//do tabeli: jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
}
