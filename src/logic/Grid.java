package logic;

import java.util.ArrayList;

public class Grid {

    String grid[][];
    private int size;

    public Grid(int size) {

        this.size = size;
        grid = new String[size][size];
        fillGrid();
    }


    public void fillGrid() {
        for (int i = 0; i < grid.length; i++) {

            for (int k = 0; k < grid[i].length; k++) {
                grid[i][k] = "*";
            }
        }

    }

    public int getSize() {
        return size;
    }

    public String[][] getGrid() {
        return grid;
    }

    public void displayGrid() {
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(String.format("%10s||", grid[i][j]));
            }
            System.out.println();
        }
    }
}
