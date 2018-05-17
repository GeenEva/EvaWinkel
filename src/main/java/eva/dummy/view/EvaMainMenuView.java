package eva.dummy.view;

public class EvaMainMenuView extends EvaView {

	public void printMainMenuHeader() {
		System.out.println("========= This is the main menu =========");
	}
	
	public void printAskWhatWouldYouLikeToDo() {
		System.out.println("What would you like to do:" +
				"\n1- Add a person\n2- Play a game of Paper-Rock-Scissors");
	}
	
	
}
