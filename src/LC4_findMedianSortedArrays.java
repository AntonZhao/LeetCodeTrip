public class LC4_findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double res = getKthElement(nums1, nums2, midIndex + 1);
            return res;
        } else {
            int midIndex1 = totalLength / 2, midIndex2 = totalLength / 2 - 1;
            double res = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return res;
        }
    }

    private int getKthElement(int[] nums1, int[] nums2, int k) {
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */
        int len1 = nums1.length, len2 = nums2.length;
        int index_1 = 0, index_2 = 0;
        int kthElement = 0;

        while (true) {
            // 边界情况
            if (index_1 == len1) return nums2[index_2 + k - 1];
            if (index_2 == len2) return nums1[index_1 + k - 1];
            if (k == 1) return Math.min(nums1[index_1], nums2[index_2]);

            //正常情况
            int half = k / 2;
            int newIndex_1 = Math.min(index_1 + half, len1) - 1;
            int newIndex_2 = Math.min(index_2 + half, len2) - 1;
            int pivot1 = nums1[newIndex_1];
            int pivot2 = nums2[newIndex_2];
            if (pivot1 <= pivot2) {
                k -= (newIndex_1 - index_1 + 1);
                index_1 = newIndex_1 + 1;
            } else {
                k -= (newIndex_2 - index_2 + 1);
                index_2 = newIndex_2 + 1;
            }
        }
    }
}
