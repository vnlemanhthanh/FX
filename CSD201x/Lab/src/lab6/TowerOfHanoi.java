package lab6;

public class TowerOfHanoi {
    private static int numOfMoves = 0;

    public void move(int numberOfDiscs, char from, char to, char inter) {
        if (numberOfDiscs == 1) {
            System.out.println("Moving disc 1 forom " + from + " to " + to);
            numOfMoves++;
        }
        if (numberOfDiscs != 1) {
            move(numberOfDiscs - 1, from, inter, to);
            System.out.println("Moving disc " + numberOfDiscs + " from " + from + " to " + to);
            numOfMoves++;
            move(numberOfDiscs - 1, inter, to, from);
        }
    }

    public static void main(String[] args) {
        TowerOfHanoi toh = new TowerOfHanoi();
        toh.move(5, 'A', 'C', 'B');
        System.out.println("Number of moves: " + numOfMoves);
    }
}
