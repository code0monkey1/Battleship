package logic;

import java.util.ArrayList;
import java.util.Random;

public class DotCom {

    private ArrayList<Pair> pairs;
    private boolean isAlive;
    private int maxXIndex;
    private int maxYIndex;
    private String name;
    private static int index;

    public DotCom(int maxIndex) {
        isAlive = true;
        pairs = new ArrayList<>();
        this.maxXIndex = maxIndex - 3;
        this.maxYIndex = maxIndex;

        name = "Boat " + index;
        index++;
        populateArray();
    }

    private int generateRandomIndex(int maxIndex) {
        Random random = new Random();
        return random.nextInt(maxIndex);

    }

    private void populateArray() {
        int xAxis = generateRandomIndex(maxXIndex);
        int yAxis = generateRandomIndex(maxYIndex);
        int size = 1 + generateRandomIndex(3);

        for (int i = 0; i < size; i++) {
            pairs.add(new Pair(xAxis + i, yAxis, name));
        }

    }

    public ArrayList<Pair> getPairs() {
        return pairs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DotCom dotCom = (DotCom) o;

        for (int i = 0; i < dotCom.pairs.size(); i++) {
            if (this.pairs.contains(dotCom.pairs.get(i))) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "DotCom{" +
                "pairs=" + pairs +
                '}';
    }

    @Override
    public int hashCode() {
        return pairs != null ? pairs.hashCode() : 0;
    }

    private void checkIfAlive() {
        for (Pair pair : pairs) {
            if (pair.isAlive()) {
                return;
            }
        }
        isAlive = false;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        if (isAlive) checkIfAlive();

        return isAlive;
    }

    public boolean isUnique(DotCom dotCom) {
        return !this.equals(dotCom);
    }

}
