public class trap42 {
    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        int maxLeft = 0, maxRight = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxLeft)
                    maxLeft = height[left];
                else
                    res += maxLeft - height[left];
                left++;
            }else {
                if (height[right] >= maxRight)
                    maxRight = height[right];
                else
                    res += maxRight - height[right];
            }
        }
        return res;
    }

//    public static int trap(int[] height) {
//        int max = getMax(height);
//        int sum = 0;
//        for (int i = 1; i <= max; i++) {
//            boolean isStart = false;
//            int temp = 0;
//            for (int j = 0; j < height.length; j++) {
//                if (isStart && height[j] < i) {
//                    temp++;
//                }
//
//                if (height[j] >= i) {
//                    sum += temp;
//                    temp = 0;
//                    isStart = true;
//                }
//            }
//        }
//        return sum;
//    }
//
//    private static int getMax(int[] height) {
//        int max = 0;
//        for (int i = 0; i < height.length; i++) {
//            max = Math.max(max, height[i]);
//        }
//        return max;
//    }
}
