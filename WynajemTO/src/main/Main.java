package main;

import glue.Inicjalizacja;

public class Main{
	public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	Inicjalizacja start = new Inicjalizacja();
            }
        });
	}
}
