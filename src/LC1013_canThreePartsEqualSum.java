public class LC1013_canThreePartsEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int n : A) sum += n;
        if (sum % 3 != 0) return false;
        sum = sum / 3;

        int left = 0, leftSum = A[left];
        int right = A.length - 1, rightSum = A[right];
        while (left < right) {
            if (leftSum != sum) {
                left++;
                leftSum += A[left];
            }
            if (rightSum != sum) {
                right--;
                rightSum += A[right];
            }

            if (leftSum == sum && rightSum == sum) {
                return true;
            }
        }
        return false;
    }


    public boolean canThreePartsEqualSum_2(int[] A) {
        int sum = 0;
        for (int n : A) sum += n;
        if (sum % 3 != 0) return false;
        sum = sum / 3;
        int flag = 0, s = 0;
        for (int n : A) {
            s += n;
            if (s == sum) {
                s = 0;
                flag++;
            }
        }
        return flag >= 3;
    }
}
