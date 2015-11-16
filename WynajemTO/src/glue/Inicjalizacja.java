package glue;

import widok.OknoGlowne;
import model.ModelBD;
import model.AktualneDane;
import widok.WidokNajemne;
import widok.WidokOplaty;
import widok_wprowadzanie_danych.WidokWprowadzanieDanychOplaty;
import widok_wprowadzanie_danych.WidokWprowadzanieDanychNajemne;
import controller.ControllerOplaty;
import controller.ControllerNajemne;
import controller.ControllerWprowadzanieDanychNajemne;
import controller.ControllerWprowadzanieDanychOplaty;

import controller.ControllerOplaty;

public class Inicjalizacja {
	public Inicjalizacja()
	{
		OknoGlowne OG = new OknoGlowne();
		ControllerOplaty controllerOplaty = new ControllerOplaty();
		ControllerNajemne controllerNajemne = new ControllerNajemne();
		ModelBD modelBD = new ModelBD();
		controllerOplaty.addView(OG.getWidokOplaty());
		controllerNajemne.addView(OG.getWidokNajemne());
		controllerOplaty.addModel(modelBD);
		controllerNajemne.addModel(modelBD);
		OG.getWidokOplaty().addController(controllerOplaty);
		OG.getWidokNajemne().addController(controllerNajemne);
		
		OG.getWidokNajemne().dodajOknoGlowne(OG);
		OG.getWidokOplaty().dodajOknoGlowne(OG);
		
		OG.getWidokNajemne().addModel(modelBD);
		OG.getWidokOplaty().addModel(modelBD);
		
		modelBD.addObserver(OG);
		
		modelBD.start();
	}
}
