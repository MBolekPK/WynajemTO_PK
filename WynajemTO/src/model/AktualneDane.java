package model;

import typy.WierszNajemne;
import typy.WierszOplaty;
import java.util.ArrayList;
import java.util.Observable;
//Pomysl: w modelu BD jest metoda update, ktora po utworzeniu lokalnej listy z bd wywoluje
//np. taka konstrukcje: AktualneDane.getListaMieszkan() = listaMieszkanUtworzonaLokalnie;
//efekt: po zakonczeniu metody referencja do lokalnej listy mieszkan przestaje istniec
//a nowiutka aktualna lista trafia tutaj ;).
//Garbage Collector na cale szczescie wywali smieci w postaci starej listy.
public class AktualneDane extends Observable{
	public static ArrayList<WierszOplaty> listaOplat = null;
	public static ArrayList<WierszNajemne> listaNajemnego = null;
	public static double zaleglosciAdministrator = 0;
	public static double zaleglosciWynajmujacy = 0;
	public static double zaleglosciNajemne = 0;
	public static double zaleglosciCalkowite = 0;
	
	//public void setZaleglosciW
	//skoncz tutaj, dodaj do widoku oplat metode update, ktora najpierw
	//zaktualizuje labele statystyk a nastepnie wywola metode update dla tabeli :).
	//nastepnie zajmij sie controllerem oplat
	//controller pobiera dane z pol wprowadzania danych i dodaje je do lokalnego obiektu klasy wierszoplaty
	//na koncu wywoluje funkcje modelu bd dodajwierszoplaty.
	//model bd dodaje wiersz i wywoluje funkcje update, ktora aktualizuje WSZYSTKIE dane w bd
	//a nastepnie wywoluje metode update z klasy observable
	//klasa implementujaca interfejs observer jest okno glowne i to ono w funkcji update wywola
	//funkcje update dla widokow.
	public void updateWidokow()
	{
		setChanged();
		notifyObservers();
	}
}
