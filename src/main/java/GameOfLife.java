import java.util.LinkedList;
import java.util.Random;

public class GameOfLife {
    LinkedList<String> cells = new LinkedList<>();
    int count = 109;
    Random random = new Random();

    void randomCells() {
        for (int i = 0; i < count; ++i) {
            if (i == 10 || i == 21 || i == 32 || i == 43 || i == 54 || i == 65 || i == 76 || i == 87 || i == 98 || i == 109) {
                cells.add("\n");
            } else {
                cells.add("+");
            }
        }
        for (int i = 0; i < 50; ++i) {
            int randomIndex = random.nextInt(109);
            if (randomIndex == 10 || randomIndex == 21 || randomIndex == 32 || randomIndex == 43 || randomIndex == 54 || randomIndex == 65 || randomIndex == 76 || randomIndex == 87 || randomIndex == 98 || randomIndex == 109) {
                cells.add("\n");
            } else {
                cells.set(randomIndex, "#");
            }
        }
    }
    boolean lifeValidator(int index) {
        int lifeCounter = 0, deathCounter = 0;
        String alive = "#";
        boolean returner;
        int[] outterIndex = {index - 1, index + 10, index + 11, index + 12, index + 1, index - 10, index - 11, index - 12};
        for (int value : outterIndex) {
            if (value > 0 && value < 109 && cells.get(value).equals(alive)) {
                ++lifeCounter;
                ++deathCounter;
            }
        }
        if (lifeCounter == 2 || lifeCounter == 3 || deathCounter == 3) {
            returner = true;
        } else {
            returner = false;
        }
        return returner;
    }
    void nextGeneration() {
        String alive = "#", dead = "+";
        for (int i = 0; i < count; ++i) {
            if (cells.get(i).equals(alive)) {
                if (!lifeValidator(i)) {
                    cells.set(i, dead);
                }
            } else if (cells.get(i).equals(dead)) {
                if (lifeValidator(i)) {
                    cells.set(i, alive);
                }
            }
        }
    }
    void print() {
        for (int i = 0; i < count; ++i)
            System.out.print(cells.get(i));
        System.out.println("\n................................");
    }
}