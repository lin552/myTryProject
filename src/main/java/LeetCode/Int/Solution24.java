package LeetCode.Int;

import java.util.ArrayList;
import java.util.List;

/**
 * 最简分数
 */
public class Solution24 {

    public List<String> simplifiedFractions(int n) {
        //新建一个List 用于结果返回
        List<String> ans = new ArrayList<>();
        //双重遍历 外部从2开始遍历 内部从1开始遍历 始终保持内部比外部小
        for (int denominator = 2; denominator <= n; denominator++) {
            for (int numerator = 1; numerator < denominator; numerator++) {
                //判断是否符合最简分数要求 两个数的最大公约数== 1

                if (gcb(numerator, denominator) == 1) {
                    ans.add(numerator + "/" + denominator);
                }
            }
        }
        return ans;
    }

    //求最大公约数
    private int gcb(int a, int b) {
        return b != 0 ? gcb(b, a % b) : a;
    }
}
