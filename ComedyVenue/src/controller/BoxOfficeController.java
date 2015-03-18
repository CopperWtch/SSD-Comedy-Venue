package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.GUI_BoxOffice;

public class BoxOfficeController {

	private GUI_BoxOffice _view;
	//attr for model
	
	
	public BoxOfficeController()
	{
		this._view = new GUI_BoxOffice();
		
		addListener();
	}
	
	public void showView(){
        this._view.setVisible(true);
    }

	
	/**
	 * View is introduced to the Listeners
	 * to enable communication with controller
     */
	private void addListener() {
		// TODO Auto-generated method stub
		this._view.setBookingsListener(new BookingsListener());
	}
	
	 /**
     * Inneren Listener Klassen implementieren das Interface ActionListener
     *
     * 1: Hier wird erst der eingegebene Wert aus der View geholt
     * 2: Der Wert wird dem Model �bergeben und die Wurzel berechnet
     * 3: Die berechnete Wurzel wird aus dem Model geladen und
     * 4: Wieder der View zum Darstellen �bergeben
     *
     * TODO : check for errors
     */
    class BookingsListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
          //get values from view: value = (_view.getWhatever())
          //use values to perform the needed action (_model.DoWhatever(value))
          //update view _view.setWhatever(....)
        }
    }

}
