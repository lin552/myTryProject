package LeetCode.Array.Array2;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1020 飞地的数量
 *
 */
public class Solution28 {
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int m, n;
    private boolean[][] visited;

    /**
     * 深度优先搜索
     * @param grid
     * @return
     */
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }
        for (int j = 0; j < n - 1; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }
        int enclaves = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    enclaves++;
                }
            }
        }
        return enclaves;
    }

    public void dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0 || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        for (int[] dir : dirs
        ) {
            dfs(grid, row + dir[0], col + dir[1]);
        }
    }

    /**
     * 广度优先搜索
     * @param grid
     * @return
     */
    public int numEnclaves1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                visited[i][0] = true;
                queue.offer(new int[]{i, 0});
            }
            if (grid[i][n - 1] == 1) {
                visited[i][n - 1] = true;
                queue.offer(new int[]{i, n - 1});
            }
        }
        for (int j = 0; j < n - 1; j++) {
            if (grid[0][j] == 1) {
                visited[0][j] = true;
                queue.offer(new int[]{0, j});
            }
            if (grid[m - 1][j] == 1) {
                visited[m - 1][j] = true;
                queue.offer(new int[]{m - 1, j});
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int currRow = cell[0], currCol = cell[1];
            for (int[] dir : dirs
            ) {
                int nextRow = currRow + dir[0], nextCol = currCol + dir[1];
                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] == 1
                        && !visited[nextRow][nextCol]
                ) {
                    visited[nextRow][nextCol] = true;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }
        int enclaves = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    enclaves++;
                }
            }
        }
        return enclaves;
    }

    /**
     * 并查集
     * @param grid
     * @return
     */
    public int numEnclaves2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int index = i * n + j;
                    if (j + 1 < n && grid[i][j + 1] == 1) {
                        uf.union(index, index + 1);
                    }
                    if (i + 1 < m && grid[i + 1][j] == 1) {
                        uf.union(index, index + n);
                    }
                }
            }
        }
        int enclaves = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (grid[i][j] == 1 && !uf.isOnEdge(i * n + j)) {
                    enclaves++;
                }
            }
        }
        return enclaves;
    }

    class UnionFind {
        private int[] parent;
        private boolean[] onEdge;
        private int[] rank;

        public UnionFind(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            parent = new int[m * n];
            onEdge = new boolean[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        int index = i * n + j;
                        parent[index] = index;
                        if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                            onEdge[index] = true;
                        }
                    }
                }
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                    onEdge[rootx] |= onEdge[rooty];
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rooty] = rootx;
                    onEdge[rootx] |= onEdge[rooty];
                    rank[rootx]++;
                }
            }
        }

        public boolean isOnEdge(int i) {
            return onEdge[find(i)];
        }
    }

}
