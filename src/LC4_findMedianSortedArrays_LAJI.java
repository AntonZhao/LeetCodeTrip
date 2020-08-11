public class LC4_findMedianSortedArrays_LAJI {
    /**
     * 好吧，我写了个垃圾
     * 复杂度 m+n
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length_1 = nums1.length;
        int length_2 = nums2.length;

        if (length_1 == 0 || length_2 == 0) {
            int[] nums = length_1 == 0 ? nums2 : nums1;
            int len = nums.length;
            if (len % 2 == 0) {
                double res = nums[len / 2 - 1] + nums[len / 2];
                return res / 2;
            } else {
                return (double) nums[len / 2];
            }
        }

        if (length_1 == 1 && length_2 == 1) {
            double res = 0;
            res = nums1[0] + nums2[0];
            return res / 2;
        }

        int mid_position = (length_1 + length_2) / 2;
        int mid_count = 0;
        if ((length_1 + length_2) % 2 == 0) {
            mid_count = 2;
        } else {
            mid_count = 1;
        }

        int pointer_1 = 0, pointer_2 = 0;
        int counter = 0;
        while (pointer_1 < length_1 || pointer_2 < length_2) {

            int n1 = pointer_1 < length_1 ? nums1[pointer_1] : Integer.MAX_VALUE;
            int n2 = pointer_2 < length_2 ? nums2[pointer_2] : Integer.MAX_VALUE;

            if (n1 < n2) {
                pointer_1++;
            } else {
                pointer_2++;
            }
            counter++;

            if (counter == mid_position) break;
        }

        if (mid_count == 1) {
            if (pointer_1 == length_1) return (double) nums2[pointer_2];
            if (pointer_2 == length_2) return (double) nums1[pointer_1];
            return (double) Math.min(nums1[pointer_1], nums2[pointer_2]);
        } else {
            // 这种情况，就是从当前的指针位置选取个更小的，再从当前指针的上一个再选个更小的
            // 如果位置不合法，就变成MAX
            double res = 0;
            int n1 = pointer_1 < length_1 ? nums1[pointer_1] : Integer.MAX_VALUE;
            int n2 = pointer_2 < length_2 ? nums2[pointer_2] : Integer.MAX_VALUE;
            res += Math.min(n1, n2);
            n1 = pointer_1 - 1 >= 0 ? nums1[pointer_1 - 1] : Integer.MIN_VALUE;
            n2 = pointer_2 - 1 >= 0 ? nums2[pointer_2 - 1] : Integer.MIN_VALUE;
            res += Math.max(n1, n2);
            return res / 2;
        }
    }

    public static void main(String[] args) {
        LC4_findMedianSortedArrays_LAJI ll = new LC4_findMedianSortedArrays_LAJI();
//        int[] nums1 = new int[]{1, 2};
//        int[] nums2 = new int[]{-1, 3};
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{2, 3, 4};
        System.out.println(ll.findMedianSortedArrays(nums1, nums2));
    }
}
