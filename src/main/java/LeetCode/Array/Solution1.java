package LeetCode.Array;

/**
 * 最大子数组和
 */
public class Solution1 {

    public static void main(String[] args) {
        int[] list = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("最大和 " + maxSubArray(list));
    }

    /**
     * 动态规划
     * 时间复杂度：O(n)，其中 n 为 nums 数组的长度。我们只需要遍历一遍数组即可求得答案。
     * 空间复杂度：O(1)。我们只需要常数空间存放若干变量。
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            //pre来维护对于当前f(i)的f(i-1)的值是多少
            pre = Math.max(pre + x, x); //判断f(i-1)是否要加到当前数上
            maxAns = Math.max(maxAns, pre); //获取最大值
        }
        return maxAns;
    }

    /**
     * dp[i]: 表示以第i个字符结束的最长子序列的 **和**
     *        这个 dp 有效性的证明:
     *        1) 如果存在一个最大和的子序列.那它一定是以某一个 `i` 的下标字符作为结束的.
     *        2) 换言之,最终的答案一定是在这个数组里面.
     * dp[0]: 初始化, 第一个元素一定是它本身.一是一定要包含自己,另外是当前只有它自己.
     *               以 nums[0] 结束的字符子串只有一个char.  即: dp[0]=nums[0]. (即 sub[0,0])
     * 递归公式:
     * dp[i]= dp[i-1] > 0 ? dp[i-1]+nums[i] : nums[i];
     *        解释:
     *        1) 如果前面的以 `i-1`结束的子序列的值为负. 即 dp[i-1] <= 0 , 那么当前 dp 值直接取当前元素即可.(即使当前元素为负).
     *        因为前面的子序列是一个负数.加到一起只会更小.
     *        对于为什么一定取当前的数字.是因为根据定义.这个值一定是需要以`i`这个下标的字符结束的.
     *        2) 如果之前的不是负值. 这个就很好理解了.不是负的那加到一起就好了.
     *
     */
    public static int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1;i<nums.length;i++ ){
            dp[i]= dp[i-1] > 0 ? dp[i-1]+nums[i] : nums[i];
        }

        int maxDpValue = dp[0];
        for(int i=1;i<dp.length;i++){
            maxDpValue = Math.max(maxDpValue,dp[i]);
        }

        return maxDpValue;
    }



    /**
     * 贪心法
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        //类似寻找最大最小值得题目，初始值一定要定义成理论上的最小最大值
        int result = Integer.MIN_VALUE;
        int numSize = nums.length;
        int sum = 0;
        for (int i = 0; i < numSize; i++) {
            sum += nums[i];
            result = Math.max(result, sum);
            //如果sum<0,重新开始找子序串
            if (sum < 0) {
                sum = 0;
            }
        }
        return result;
    }

    /**
     * 分治法：线段树
     * @param nums
     * @return
     */
    public static int maxSubArray3(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int len = nums.length;
        return getInfo(nums, 0, len - 1).mSum;
    }

    static class wtevTree {
        int lSum;//以左区间为端点的最大子段和
        int rSum;//以右区间为端点的最大子段和
        int iSum;//区间所有书的和
        int mSum;//该区间的最大字段和

        public wtevTree(int l, int r, int i, int m) {
            this.lSum = l;
            this.rSum = r;
            this.iSum = i;
            this.mSum = m;
        }
    }

    //通过既有的属性，计算上一层的属性，一步步往上返回，获得线段树
    public static wtevTree pushUp(wtevTree leftT, wtevTree rightT) {
        //新子段的lSum等于左区间的lSum或是左区间的 区间和 加上右区间的lSum
        int l = Math.max(leftT.lSum, leftT.iSum + rightT.lSum);
        //新子段的rSum等于右区间的rSum或者右区间的 区间和 加上左区间的rSum
        int r = Math.max(leftT.rSum + rightT.iSum, rightT.rSum);
        //新子段的区间和等于左右区间的区间和之和
        int i = leftT.iSum + rightT.iSum;
        //新子段的最大子段和，其子段有可能穿过左右区间,或左区间，或右区间
        int m = Math.max(leftT.rSum + rightT.lSum, Math.max(leftT.mSum, rightT.mSum));
        return new wtevTree(l, r, i, m);
    }

    //递归建立和获得输入区间所有子段的结构
    public static wtevTree getInfo(int[] nums, int left, int right) {
        if (left == right) { //若区间长度为1，其四个子段均为其值
            return new wtevTree(nums[left], nums[left], nums[left], nums[left]);
        }
        int mid = (left + right) >> 1; //获得中间点mid，右移一位相当于除以2，运算最快
        wtevTree leftT = getInfo(nums, left, mid);
        wtevTree rightT = getInfo(nums, mid + 1, right);//mid+1，左右区间没有交集
        return pushUp(leftT, rightT); //递归结束后，做最后一次合并
    }




}
