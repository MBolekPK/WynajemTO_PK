package controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.NumberFormatException;

import typy.WierszNajemne;
import widok_wprowadzanie_danych.WidokWprowadzanieDanychNajemne;
import model.ModelBD;

public class ControllerWprowadzanieDanychNajemne implements ActionListener{
	WidokWprowadzanieDanychNajemne wwdn;
	ModelBD modelBD;
	
	public void actionPerformed(ActionEvent e){
		boolean sprawdzenie = false;
		if(e.getActionCommand() == "Ok")
		{
			
			if (wwdn.getTextFieldData().getText().equals("")||
				wwdn.getTextFieldOpis().getText().equals("")||
				wwdn.getTextFieldTerminPlatnosci().getText().equals("")||
			   (wwdn.getCheckBoxStan().isSelected()&&
				wwdn.getTextFieldDataOplacenia().getText().equals("")))
			{
				wwdn.pokazOknoDialogoweBD();
				sprawdzenie = true;
			}
			
			try{
				Double.parseDouble(wwdn.getTextFieldKwota().getText());
			}
			catch(NumberFormatException ex){
				wwdn.pokazOknoDialogoweND();
				sprawdzenie = true;
			}
			
			if(!sprawdzenie)
			{
				Boolean nowy = false;
				
				if(wwdn.getTextFieldId().getText().equals("")){
					nowy = true;
				}
				
			WierszNajemne wn = new WierszNajemne(
					 0,
					 wwdn.getTextFieldData().getText(),
					 wwdn.getTextFieldOpis().getText(),
					 wwdn.getTextFieldTerminPlatnosci().getText(),
					 Double.parseDouble(wwdn.getTextFieldKwota().getText()),
					 wwdn.getCheckBoxStan().isSelected(),
					 wwdn.getTextFieldDataOplacenia().getText()
					 );		
			if (nowy){
				modelBD.dodajNajemne(wn);
				wwdn.dispose();
			}
			else{
				wn.setId(Integer.parseInt(wwdn.getTextFieldId().getText()));
				modelBD.modyfikujNajemne(wn);
				wwdn.dispose();
			}
			}
			
		}
	}
	
	public void addView(WidokWprowadzanieDanychNajemne wwdn){
		this.wwdn = wwdn;
	}
	public void addModel(ModelBD modelBD){
		this.modelBD = modelBD;
	}
}
