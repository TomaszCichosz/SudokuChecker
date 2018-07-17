public class Main {

    public static void main(String[] args) {
        System.out.println(Sudoku.check(Sudoku.stringToTwoDimensionalArray(Sudoku.readFromFile("correctSudoku"))));
        System.out.println(Sudoku.check(Sudoku.stringToTwoDimensionalArray(Sudoku.readFromFile("sudokuWithColumnError"))));
        System.out.println(Sudoku.check(Sudoku.stringToTwoDimensionalArray(Sudoku.readFromFile("sudokuWithRowError"))));
    }
}
