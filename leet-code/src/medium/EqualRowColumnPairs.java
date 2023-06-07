package medium;

import java.util.Arrays;

public class EqualRowColumnPairs {

    public static void main(String[] args) {
//        int[][] data = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        int[][] data = {{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};
        EqualRowColumnPairs obj = new EqualRowColumnPairs();
        System.out.println(obj.equalPairs(data));
    }

    public int equalPairs(int[][] grid) {
        int answer = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid.length; j++) {

                int[] column = getColumns(grid, j);
                int[] row = grid[i];

                if (Arrays.equals(row, column)) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private int[] getColumns(int[][] grid, int colIndex) {
        int[] column = new int[grid.length];

        for (int i = 0; i < column.length; i++) {
            column[i] = grid[i][colIndex];
        }

        return column;
    }
}
