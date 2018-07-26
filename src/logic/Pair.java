package logic;

public class Pair {
    private int x;
    private int y;
    private String name;
    private boolean isAlive;

    public Pair(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.isAlive = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (x != pair.x) return false;
        return y == pair.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public void kill() {
        isAlive = false;
        name = "DEAD!!";
    }

    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' +
                '}';
    }
}
