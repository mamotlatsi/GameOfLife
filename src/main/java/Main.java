public class Main {
    public static void main(String[] args) {
        GameOfLife hello = new GameOfLife();
        hello.randomCells();
        hello.print();
        hello.nextGeneration();
        hello.print();

    }
}
