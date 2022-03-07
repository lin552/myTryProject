package LeetCode.Array.Array2;

/**
 * 重塑矩阵
 */
public class Solution6 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        //数组的长度
        int m = mat.length;
        //下标为0的都是第一列，计算第一列的长度
        int n = mat[0].length;
        //reshape操作不可行，输出原矩形
        //只有行列相乘总数能对上才能变换
        if (m * n != r * c) {
            return mat;
        }
        //创建一个r行c列的数组
        int[][] ans = new int[r][c];
        for (int i = 0; i < m * n; ++i) {
            ans[i / c][i % c] = mat[i / n][i % n];
        }
        return ans;
    }
}
