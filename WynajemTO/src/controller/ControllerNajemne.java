package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import widok.WidokNajemne;
import typy.WierszNajemne;
import model.ModelBD;

public class ControllerNajemne implements ActionListener{
	WidokNajemne widokNajemne;
	ModelBD modelBD;
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("Dodaj"))
		{
			WierszNajemne wn = new WierszNajemne();
			wn = null;
			widokNajemne.oknoWprowadzaniaDanychNajemne(wn);
		}
		else if(e.getActionCommand().equals("Modyfikuj"))
		{
			if (widokNajemne.getTable().getSelectedRow() == -1){
				widokNajemne.nieWybranoPozycji();
			}else
			{
			int row = widokNajemne.getTable().getSelectedRow();
			WierszNajemne wn = new WierszNajemne((int)widokNajemne.getTable().getValueAt(row, 0),
											   (String)widokNajemne.getTable().getValueAt(row, 1),
											   (String)widokNajemne.getTable().getValueAt(row, 2),
											   (String)widokNajemne.getTable().getValueAt(row, 3),
											   (Double)widokNajemne.getTable().getValueAt(row, 4),
											   (Boolean)widokNajemne.getTable().getValueAt(row, 5),
											   ((String)widokNajemne.getTable().getValueAt(row, 6)==null?"":(String)widokNajemne.getTable().getValueAt(row, 6)));
			widokNajemne.oknoWprowadzaniaDanychNajemne(wn);
			}
		}
		else if(e.getActionCommand().equals("Usun"))
		{
			
			if (widokNajemne.getTable().getSelectedRow() == -1){
				widokNajemne.nieWybranoPozycji();
			}else
			{
				modelBD.usunNajemne((int)widokNajemne.getTable().getValueAt((widokNajemne.getTable().getSelectedRow()),0));
			}
		}
	}
	
public void addView(WidokNajemne widokNajemne){
	this.widokNajemne = widokNajemne;
}
public void addModel(ModelBD modelBD){
	this.modelBD = modelBD;
}
//do tabeli: jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
}

