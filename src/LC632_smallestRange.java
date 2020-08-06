import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC632_smallestRange {




    // 第二种：使用小顶堆优化
    public int[] smallestRange_KPointer_PriorityQueue(List<List<Integer>> nums) {
        int k = nums.size();
        int[] index_list = new int[k];
        int left_range = 0, right_range = Integer.MAX_VALUE;
        int min_range = right_range - left_range;

        // 小顶堆维护每个数组的最小值
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer index1, Integer index2) {
                return nums.get(index1).get(index_list[index1]) - nums.get(index2).get(index_list[index2]);
            }
        });

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            minHeap.offer(i);
            max = Math.max(max, nums.get(i).get(0)); // 获取当前序列的最大值
        }

        while (true) {
            Integer min_index = minHeap.poll(); // 获取当前最小值的队列序号
            int cur_range = max - nums.get(min_index).get(index_list[min_index]); // 进行比较，看是否有更小区间
            if (cur_range < min_range) {
                right_range = max;
                left_range = nums.get(min_index).get(index_list[min_index]);
                min_range = cur_range;
            }
            index_list[min_index]++; // 这个被看的数组的指针增加，当有到终点的指针就跳出循环
            if (index_list[min_index] == nums.get(min_index).size()) {
                break;
            }
            minHeap.offer(min_index); // 刚才出去的再次入堆，堆自动调整结构
            max = Math.max(max, nums.get(min_index).get(index_list[min_index])); // 更新最大值
        }

        return new int[]{left_range, right_range};
    }

    // 第一种：使用两个数组记录 index 和 对应的元素值，每次都需要遍历找大小
    public int[] smallestRange_kPointer(List<List<Integer>> nums) {
        int k = nums.size();
        int[] index_list = new int[k];
        int[] elem_list = new int[k];

        for (int i = 0; i < k; i++) {
            elem_list[i] = nums.get(i).get(index_list[i]); // elem 和 index 相对应
        }
        int[] temp = getMinAndMax(elem_list);
        int min_value = temp[0]; // 左边范围
        int max_value = temp[1]; // 右边范围
        int min_index = temp[2]; // 当前最小值在第几个数组

        while (true) {
            temp = getMinAndMax(elem_list);
            int curMinValue = temp[0];
            int curMaxValue = temp[1];
            min_index = temp[2];
            if (curMaxValue - curMinValue < max_value - min_value) {
                min_value = curMinValue;
                max_value = curMaxValue;
            }

            //  如果第min_index个数组还在范围内，则继续找，否则就退出
            if (index_list[min_index] < nums.get(min_index).size() - 1) {
                index_list[min_index]++;
                elem_list[min_index] = nums.get(min_index).get(index_list[min_index]);
            } else {
                break;
            }
        }

        int[] res = new int[]{min_value, max_value};
        return res;
    }

    private int[] getMinAndMax(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int min_index = -1;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < min) {
                min = nums[i];
                min_index = i;
            }
        }

        int[] res = new int[3];
        res[0] = min;
        res[1] = max;
        res[2] = min_index;
        return res;
    }

    public static void main(String[] args) {

    }
}
