package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.BoxOfficeController;

/**
 * Main
 * The main class responsible for launching
 * the application. 
 * This class creates the controller and uses it to 
 * show the UI
 * 
 * @author Sarah Bulk
 * @version 1.0
 * @since 19.05.2015
 */
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
