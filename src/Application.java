import logic.Grid;
import presenter.Game;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(3,new Grid(7));
       game.start();
        System.out.println("ALL BATTLESHIPS DESTROYED !!");
    }
}
