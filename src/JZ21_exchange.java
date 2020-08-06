import java.util.HashMap;

public class JZ21_exchange {
    // 创建新数组 TC:O(N) SC:O(N)
    public int[] exchange(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int odd = 0, even = len - 1;
        for (int x : nums) {
            if (x % 2 == 0) {
                res[even--] = x;
            } else {
                res[odd++] = x;
            }
        }
        return res;
    }

    // 双指针 TC:O(N) SC:O(1)
    public int[] exchange_2(int[] nums) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left < right) {
            if (nums[left] % 2 != 0) {
                left++;
                continue;
            }
            if (nums[right] % 2 == 0) {
                right--;
                continue;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("11",1);
        String s = "sss";

        System.out.println(hello.class);
        System.out.println(JZ21_exchange.class);
        System.out.println(clazz.class);
        System.out.println(staticClass.class);
        System.out.println(staticClass.ccc.class);

        System.out.println(test(1,2,"232"));
    }

    interface hello{
        String sayHello(String s);
    }

    class clazz{
        public clazz() {
        }
    }

    static class staticClass{
        public staticClass() {
        }

        static class ccc{

        }
    }

    public static <T> String test(T ... input) {
        for (T t : input) {
            if (t instanceof Integer) {
                System.out.println("Interger : " + t);
            } else if (t instanceof Long) {
                System.out.println("Long : " + t);
            } else if (t instanceof String) {
                System.out.println("String : " + t);
            }
        }
        return "done";
    }


}
