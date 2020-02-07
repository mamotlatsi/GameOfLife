public class Main {
    public static void main(String[] args) {
        GameOfLife bello = new GameOfLife();
        bello.randomCells();
        bello.print();
        bello.nextGeneration();
        bello.print();
    }
}
