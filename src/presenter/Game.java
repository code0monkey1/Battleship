package presenter;

import logic.DotCom;
import logic.Grid;
import logic.Pair;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private Grid grid;
    private int howManyDotComs;
    private ArrayList<DotCom> dotComs;

    public Game(int howManyDotComs, Grid grid) {

        this.howManyDotComs = howManyDotComs;
        this.grid = grid;
        dotComs = new ArrayList<>();
    }

    public void start() {
        System.out.println("------------------------------------");
        System.out.println("WELCOME TO THE GAME OF BATTLESHIP");
        System.out.println("------------------------------------");
        while (dotComs.size() < howManyDotComs) {

            DotCom dotCom = new DotCom(grid.getSize());
            if (isUnique(dotCom)) dotComs.add(dotCom);
        }
        Scanner scanner = new Scanner(System.in);
        while (keepPlaying()) {

            System.out.println("Take a chance : ");
            System.out.println("____________________");
            System.out.println("Specify the x axis : max_number :" + grid.getSize());
            int x = scanner.nextInt();
            System.out.println("Specify the y axis : max_number :" + grid.getSize());
            int y = scanner.nextInt();
            playerChoice(x, y);
            fillGridWithDotComIndices();
            grid.displayGrid();

        }
    }

    public boolean keepPlaying() {

        for (DotCom dotCom : dotComs) {
            if (dotCom.isAlive()) return true;
        }
        return false;
    }

    public boolean isUnique(DotCom dotCom) {
        for (DotCom dotCom1 : dotComs) {
            if (dotCom1.isAlive()) {
                if (!dotCom.isUnique(dotCom1)) return false;
            }
        }

        return true;
    }

    private void fillGridWithDotComIndices() {

        String myGrid[][] = grid.getGrid();
        for (DotCom dotCom1 : dotComs) {
            ArrayList<Pair> pairList = dotCom1.getPairs();
            for (Pair pair : pairList) {
                myGrid[pair.getX()][pair.getY()] = pair.getName();
            }
        }

    }

    public void playerChoice(int x, int y) {

        for (DotCom dotCom1 : dotComs) {
            ArrayList<Pair> pairList = dotCom1.getPairs();
            for (Pair pair : pairList) {
                if (pair.getX() == x && pair.getY() == y) {
                    pair.kill();
                }
            }
        }

    }
}
