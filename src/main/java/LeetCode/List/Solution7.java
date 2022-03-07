package LeetCode.List;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 */
public class Solution7 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        //所有的遍历都是++都是为了保证从第一个开始
        for (int i = 0; i < numRows; ++i) {
            //将每一层都单独存错在List中
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                //第一个和最后一个都是1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            //把每一行再加入到最后的大集合中
            ret.add(row);
        }
        return ret;
    }
}
