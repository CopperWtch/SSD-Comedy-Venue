package main;

import java.awt.EventQueue;

import controller.BoxOfficeController;
import view.GUI_BoxOffice;


public class Main {
	/**
	 * Launch the application.
	 */
	
	static BoxOfficeController controller;

	public static void main(String[] args) {
		
		controller = new BoxOfficeController();
		controller.showView();
	}

}
