package self.learning.interview.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class SpiralMatrix {
    private enum Direction {LEFT, DOWN, RIGHT, UP}

    public static void main(String[] args) {
        //int[][] matrix = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}};
        // int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] matrix = {{1}, {2}, {3}, {4}, {5}};

        final int ROW_NUM = matrix.length;
        final int COLUMN_NUM = matrix[0].length;
        spiralPrint(matrix, ROW_NUM, COLUMN_NUM);
    }

    private static void spiralPrint(int[][] matrix, final int m, final int n) {
        int top = 0, bottom = m - 1, left = 0, right = n - 1;

        final List<Integer> spiral = new ArrayList<>();
        Direction direction = Direction.LEFT;

        while (top <= bottom && left <= right) {

            switch (direction) {
                case LEFT:
                    top = printTopRow(matrix, top, left, right, spiral);
                    direction = Direction.DOWN;
                    break;

                case DOWN:
                    right = printRightColumn(matrix, top, bottom, right, spiral);
                    direction = Direction.RIGHT;
                    break;

                case RIGHT:
                    bottom = printBottomRow(matrix, bottom, left, right, spiral);
                    direction = Direction.UP;
                    break;

                case UP:
                    left = getPrintLeftColumn(matrix, top, bottom, left, spiral);
                    direction = Direction.LEFT;
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + direction);
            }
        }

        System.out.println(Arrays.toString(spiral.toArray()));
    }

    private static int getPrintLeftColumn(final int[][] matrix, final int top,
                                          final int bottom, final int left, final List<Integer> spiral) {
        IntStream.range(top, bottom + 1)
                .boxed()
                .sorted(Collections.reverseOrder())
                .forEach(index -> spiral.add(matrix[index][left]));
        return left + 1;
    }

    private static int printRightColumn(final int[][] matrix, final int top,
                                        final int bottom, final int right,
                                        final List<Integer> spiral) {
        IntStream.range(top, bottom + 1)
                .forEach(index -> spiral.add(matrix[index][right]));
        return right - 1;
    }

    private static int printTopRow(final int[][] matrix, final int top,
                                   final int left, final int right,
                                   final List<Integer> spiral) {
        IntStream.range(left, right + 1)
                .forEach(index -> spiral.add(matrix[top][index]));
        return top + 1;
    }

    private static int printBottomRow(final int[][] matrix, final int bottom,
                                      final int left, final int right,
                                      final List<Integer> spiral) {
        IntStream.range(left, right + 1)
                .boxed()
                .sorted(Collections.reverseOrder())
                .forEach(index -> spiral.add(matrix[bottom][index]));
        return bottom - 1;
    }


}
