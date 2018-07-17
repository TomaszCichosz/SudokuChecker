import java.io.BufferedReader;
import java.io.IOException;

public class Sudoku {

    public static int[][] stringToTwoDimensionalArray(String sudokuString) {
        char[] sudokuChars = sudokuString.replaceAll("\\n", "").toCharArray();
        int index = 0;
        int[][] sudoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Character.getNumericValue(sudokuChars[index]);
                index++;
            }
        }
        return sudoku;
    }

    public static boolean check(int[][] sudoku) {
        return checkRowsAndColumns(sudoku) && check3x3Square(sudoku, 0, 0)
        && check3x3Square(sudoku, 0, 3)
        && check3x3Square(sudoku, 0, 6) && check3x3Square(sudoku, 3, 0)
        && check3x3Square(sudoku, 3, 3) && check3x3Square(sudoku, 3, 6)
        && check3x3Square(sudoku, 6, 0) && check3x3Square(sudoku, 6, 3)
        && check3x3Square(sudoku, 6, 6);
    }

    private static boolean check3x3Square(int[][] sudoku, int rowIndex, int columnIndex) {
        for (int k = rowIndex; k < 3 + rowIndex; k++) {
            for (int l = columnIndex; l < 3 + columnIndex; l++) {

                for (int i = rowIndex; i < rowIndex + 3; i++) {
                    for (int j = columnIndex; j < columnIndex + 3; j++) {
                        if (k != i && l != j) {
                            if (sudoku[k][l] == sudoku[i][j] && sudoku[i][j] != 0) {
                                return false;
                            }
                        }
                    }
                }

            }
        }
        return true;
    }

    private static boolean checkRowsAndColumns(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = j + 1; k < 9; k++) {
                    if (!columnCondition(sudoku, i, j, k) || !rowCondition(sudoku, i, j, k)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean columnCondition(int[][] sudoku, int i, int j, int k) {
        return !(sudoku[j][i] == sudoku[k][i] && sudoku[k][i] != 0);
    }

    private static boolean rowCondition(int[][] sudoku, int i, int j, int k) {
        return !(sudoku[i][j] == sudoku[i][k] && sudoku[i][k] != 0);
    }

    public static String readFromFile(String fileName) {
        BufferedReader br;
        String allLines = "";
        try {
            br = new BufferedReader(new java.io.FileReader(fileName));
            String nextLine = br.readLine();
            allLines += nextLine;
            while (nextLine != null) {
                nextLine = br.readLine();
                if (nextLine != null) {
                    allLines += "\n" + nextLine;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allLines;
    }
}
