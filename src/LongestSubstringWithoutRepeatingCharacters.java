import java.util.HashMap;

/**
 * Created by Lx on 2015/11/26.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /*
    基本思想，对字符串用两个游标j,i分别表示最长子字符串的开头字符和结尾字符，用hashmap将字符作为key，游标作为value，
    若i扫描到的字符在map中即在字符串中出现了相同的字符，则让j
    * */
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;

        int result = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0,j = 0;i < s.length();i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(map.get(s.charAt(i)) + 1,j);//防止j又重新回到了之前j取过的值
            }

            map.put(s.charAt(i),i);
            result = Math.max(result,i - j + 1);
        }
        return result;
    }

//    public static void main(String[] args){
//        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
//        System.out.println(l.lengthOfLongestSubstring("abba"));
//    }
}
