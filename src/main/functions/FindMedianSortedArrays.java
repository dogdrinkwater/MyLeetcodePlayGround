package main.functions;

public class FindMedianSortedArrays {
    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     *
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * 示例 2：
     *
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * 提示：
     *
     * nums1.length == m
     * nums2.length == n
     * 0 <= m <= 1000
     * 0 <= n <= 1000
     * 1 <= m + n <= 2000
     * -106 <= nums1[i], nums2[i] <= 106
     * Related Topics
     * 数组
     * 二分查找
     * 分治
     * */
    public static void main(String[] args) {
        System.out.println(5/2);
    }

    public double findMedianSortedArrays(int[] A, int[] B) {
        int aLen = A.length;
        int bLen = B.length;
        int len = aLen + bLen;
        int aPoint = 0, bPoint = 0;
        int left = -1, right = -1;
        for (int i = 0; i <= len/2; i++) {
            left = right;
            if (aPoint < aLen && (bPoint == bLen || A[aPoint] < B[bPoint])) {
                right = A[aPoint++];
            } else {
                right = B[bPoint++];
            }
        }
        
        if (len % 2 == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }
}
