package controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.NumberFormatException;

import typy.WierszOplaty;
import widok_wprowadzanie_danych.WidokWprowadzanieDanychOplaty;
import model.ModelBD;

public class ControllerWprowadzanieDanychOplaty implements ActionListener{
	WidokWprowadzanieDanychOplaty wwdo;
	ModelBD modelBD;
	
	public void actionPerformed(ActionEvent e){
		boolean sprawdzenie = false;
		if(e.getActionCommand() == "Ok")
		{
			
			if (wwdo.getTextFieldData().getText().equals("")||
				wwdo.getTextFieldOpis().getText().equals("")||
				wwdo.getTextFieldTerminPlatnosci().getText().equals("")||
				wwdo.getTextFieldNrFaktury().getText().equals("")||
			   (wwdo.getCheckBoxStanAdministrator().isSelected()&&
				wwdo.getTextFieldDataOplaceniaAdministrator().getText().equals(""))||
			   (wwdo.getCheckBoxStanWynajmujacy().isSelected()&&
			    wwdo.getTextFieldDataOplaceniaWynajmujacy().getText().equals("")))
			{
				wwdo.pokazOknoDialogoweBD();
				sprawdzenie = true;
			}
			if(!sprawdzenie)
			{
			try{
				double d = Double.parseDouble(wwdo.getTextFieldKwota().getText());
				}catch(NumberFormatException ex){
				wwdo.pokazOknoDialogoweND();
				sprawdzenie = true;
				}
			}
			
			if(!sprawdzenie)
			{
				Boolean nowy = false;
				
				if(wwdo.getTextFieldId().getText().equals("")){
					nowy = true;
				}
				
			WierszOplaty wo = new WierszOplaty(
					 0,
					 wwdo.getTextFieldData().getText(),
					 wwdo.getTextFieldOpis().getText(),
					 wwdo.getTextFieldTerminPlatnosci().getText(),
					 wwdo.getTextFieldNrFaktury().getText(),
					 Double.parseDouble(wwdo.getTextFieldKwota().getText()),
					 wwdo.getCheckBoxStanAdministrator().isSelected(),
					 wwdo.getTextFieldDataOplaceniaAdministrator().getText(),
					 wwdo.getCheckBoxStanAdministrator().isSelected(),
					 wwdo.getTextFieldDataOplaceniaWynajmujacy().getText()
					 );
			if (nowy){
				modelBD.dodajOplate(wo);
				wwdo.dispose();
			}
			else{
				wo.setId(Integer.parseInt(wwdo.getTextFieldId().getText()));
				modelBD.modyfikujOplate(wo);
				wwdo.dispose();
			}
			}
			
		}
	}
	
	public void addView(WidokWprowadzanieDanychOplaty wwdo){
		this.wwdo=wwdo;
	}
	public void addModel(ModelBD modelBD){
		this.modelBD = modelBD;
	}
}
