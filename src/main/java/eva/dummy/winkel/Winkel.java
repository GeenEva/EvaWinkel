package eva.dummy.winkel;

import eva.dummy.EvaMainMenu;
import eva.dummy.controller.*;
import eva.dummy.domain.*;
import eva.dummy.view.*;


public class Winkel {
	public static void main(String[] args) {
		EvaView evaMainMenuView = new EvaMainMenuView();
		EvaMainMenu evaMainMenu = new EvaMainMenu();
		EvaView evaPersonView = new EvaPersonView();
		
		//PolyMorphism: the MainMenuController constructor can take both menuview and personview
		EvaMainMenuController evaMainMenuController = new EvaMainMenuController(evaPersonView, evaMainMenu);
	
	
	}
}
