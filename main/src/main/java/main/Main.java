package main;
/**
 * <h1>The  Main Class</h1>
 * 
 * @author Guillaume-Muller
 * @version 2.0
 */
import controller.GameController;
import controller.IController;
import model.Grid;
import model.ITronModel;
import model.TronModel;
import view.Frame;
import view.IView;

public abstract class Main {

    public static void main(final String[] args) {
    	// we load the model
    	final ITronModel model = new TronModel();
    	//we load the grid
    	model.setGrid(new Grid());
    	//we load the View with the model
    	final IView view = new Frame(model);	
    	//we load the controller
    	IController game = new GameController(model, view);
    	//we start the game
    	game.play();
    	
    }

}
