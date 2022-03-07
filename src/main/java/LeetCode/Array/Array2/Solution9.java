package LeetCode.Array.Array2;

/**
 * 矩阵置零
 */
public class Solution9 {

    /**
     * 使用标记数组
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        //用两个标记数组，来记录是否有0出现
        boolean[] row = new boolean[m]; //m行
        boolean[] col = new boolean[n]; //n列
        //通过遍历，发现有0出现，则在数组中标记
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        //再遍历一次，如果发现任意行或列为0时，将对应元素置0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 使用两个标记变量
     * 使用原本数组的第一行和第一列来标记是否出现0
     * @param matrix
     */
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        //两个标记变量
        boolean flagCol0 = false, flagRow0 = false;

        //遍历第一列
        //如果有出现0 标记为则为true
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }

        //遍历第一行
        //如果有出现0,标记为则为true
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }

        //舍弃第一列和第一列进行遍历
        //如果发现有0 将第一行和第一列中对应的置0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        //舍弃第一列和第一列进行遍历
        //通过第一行第一列的结果 （如果第一行或是第一列有出现0）
        //把对应行对应列的都置0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //通过标志位，将对应行列置0
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
    }

    /**
     * 使用一个标记变量
     * @param matrix
     */
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false;

        //遍历数组
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                //标记第一列中出现0的
                flagCol0 = true;
            }
            //从第二列开始遍历
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    //如果出现0 就把第一行和第一列中的 置0
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        //从最后一行开始遍历
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }
    }
}
