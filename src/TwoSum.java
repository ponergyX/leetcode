import sun.applet.Main;

import java.util.HashMap;

/**
 * Created by Lx on 2015/11/24.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
     /* 自己实现，O（n2)代价
        int[] result = {0,0};

        for(int i = 0;i < nums.length;i++){
            for (int j = i + 1;j < nums.length;j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                }
            }
        }
        return result;*/

        //hashmap，O(n)复杂度
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(target - nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i + 1;
                return result;
            }
            map.put(nums[i],i + 1);
        }
        return result;
    }
}
