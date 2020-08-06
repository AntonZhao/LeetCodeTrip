import java.net.Socket;
import java.util.*;

public class LC350_intersect {
    public int[] intersect1(int[] nums1, int[] nums2) {
        int[] longNums, shortNums;
        if (nums1.length > nums2.length) {
            longNums = nums1;
            shortNums = nums2;
        } else {
            longNums = nums2;
            shortNums = nums1;
        }
        List<Integer> res = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) != 0) {
                res.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        Socket socket = new Socket();
        int[] ress = new int[res.size()];
        for (int i = 0; i < ress.length; i++) {
            ress[i] = res.get(i);
        }
        return ress;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i != nums1.length && j != nums2.length) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            }
        }

        int[] ress = new int[res.size()];
        for (int k = 0; k < ress.length; k++) {
            ress[k] = res.get(k);
        }
        return ress;
    }

}
