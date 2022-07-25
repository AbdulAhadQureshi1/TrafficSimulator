package statistics;

public class ShortestPath {
    static boolean[][] visited;

    // Check if it is possible to go to (x, y) from the
    // current position. The function returns false if the
    // cell has value 0 or already visited
    static boolean isSafe(String[][] mat, boolean[][] visited,
                          int x, int y)
    {
        return (x >= 0 && x < mat.length && y >= 0
                && y < mat[0].length && mat[x][y] != "x"
                && !visited[x][y]);
    }

    static int findShortestPath(String[][] mat, int i, int j,
                                int x, int y, int min_dist,
                                int dist)
    {

        if (i == x && j == y) {
            min_dist = Math.min(dist, min_dist);
            return min_dist;
        }

        // set (i, j) cell as visited
        visited[i][j] = true;
        // go to the bottom cell
        if (isSafe(mat, visited, i + 1, j)) {
            min_dist = findShortestPath(mat, i + 1, j, x, y,
                    min_dist, dist + 1);
        }
        // go to the right cell
        if (isSafe(mat, visited, i, j + 1)) {
            min_dist = findShortestPath(mat, i, j + 1, x, y,
                    min_dist, dist + 1);
        }
        // go to the top cell
        if (isSafe(mat, visited, i - 1, j)) {
            min_dist = findShortestPath(mat, i - 1, j, x, y,
                    min_dist, dist + 1);
        }
        // go to the left cell
        if (isSafe(mat, visited, i, j - 1)) {
            min_dist = findShortestPath(mat, i, j - 1, x, y,
                    min_dist, dist + 1);
        }
        // backtrack: remove (i, j) from the visited matrix
        visited[i][j] = false;
        return min_dist;
    }

    // Wrapper over findShortestPath() function
    static int findShortestPathLength(String[][] mat,
                                      int[] src, int[] dest)
    {
        if (mat.length == 0 || mat[src[0]][src[1]] == "x"
                || mat[dest[0]][dest[1]] == "x")
            return -1;

        int row = mat.length;
        int col = mat[0].length;

        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                visited[i][j] = false;
        }

        int dist = Integer.MAX_VALUE;
        dist = findShortestPath(mat, src[0], src[1],
                dest[0], dest[1], dist, 0);

        if (dist != Integer.MAX_VALUE)
            return dist;
        return -1;
    }
}
