package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.BoxOfficeController;

public class Main {
	/**
	 * Launch the application.
	 */

	static BoxOfficeController controller;

	public static void main(String[] args) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}

		controller = new BoxOfficeController();
		controller.showView();
	}

}
