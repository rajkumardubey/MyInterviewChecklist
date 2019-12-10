package self.learning.interview.coding;

public class LargestLand {

    private final static int[] ROW_DELTA = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    private final static int[] COLUMN_DELTA = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

    public static void main(String[] args) {
        final int[][] input = {{0, 0, 1, 1, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1}};

        System.out.println("Size of largest Region: " + largestRegion(input));
    }

    private static int largestRegion(int[][] input) {
        final int rowCount = input.length;
        final int columnCount = input[0].length;

        final boolean[][] visited = new boolean[rowCount][columnCount];

        int maxArea = 0;
        int regionArea;
        int regionCount = 0;
        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < columnCount; c++) {

                if (input[r][c] == 1 && !visited[r][c]) {
                    regionCount++;

                    regionArea = 0;
                    dfs(input, visited, r, c, rowCount, columnCount, regionArea);

                    maxArea = Math.max(maxArea, regionArea);
                }
            }
        }

        System.out.println("Total Region Found: " + regionCount);

        return maxArea;
    }

    private static void dfs(final int[][] input, final boolean[][] visited,
                           final int presentRow, final int presentColumn,
                           final int totalRowCount, final int totalColumnCount,
                           Integer area) {
        visited[presentRow][presentColumn] = true;

        int index = 0;
        while (index < 8) {
            if (isSafe(input, visited, presentRow, presentColumn, totalRowCount, totalColumnCount)) {
                dfs(input, visited, presentRow + ROW_DELTA[index],
                        presentColumn + COLUMN_DELTA[index], totalRowCount, totalColumnCount, area++);
            }
            index++;
        }
    }

    private static boolean isSafe(final int[][] input, final boolean[][] visited,
                                  final int presentRow, final int presentColumn,
                                  final int totalRowCount, final int totalColumnCount) {
        return presentRow >= 0 && presentRow < totalRowCount
                && presentColumn >= 0 && presentColumn < totalColumnCount
                && input[presentRow][presentColumn] == 1
                && !visited[presentRow][presentColumn];
    }


}
