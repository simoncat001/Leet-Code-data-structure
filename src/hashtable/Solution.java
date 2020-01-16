package hashtable;

import java.util.*;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        int [] arr = new int[26];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int len = s.length();
        for(int i = 0; i<len; i++){
            arr[sArr[i]-'a']++;
        }
        for(int i = 0; i<len; i++){
            if( arr[tArr[i]-'a']<0){
                return false;
            }
            arr[tArr[i]-'a']--;
        }
        for(int i = 0; i<26;i++){
            if(arr[i]!=0){
                return false;
            }
        }
        return true;
    }
    
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> stringListHashMap = new HashMap<>();
        for(String x: strs){
            char[] chars = x.toCharArray();
            Arrays.sort(chars);
            if (stringListHashMap.containsKey(String.valueOf(chars))){
                List<String> temp = stringListHashMap.get(String.valueOf(chars));
                temp.add(x);
            }else {
                stringListHashMap.put(String.valueOf(chars), new ArrayList<>());
                stringListHashMap.get(String.valueOf(chars)).add(x);
            }
        }
        return new ArrayList<>(stringListHashMap.values());
    }
    
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> stringListHashMap = new HashMap<>();
        for(String x: strs){
            char[] chars = x.toCharArray();
            char [] count = new char[26];
            if (stringListHashMap.containsKey(String.valueOf(chars))){
                List<String> temp = stringListHashMap.get(String.valueOf(chars));
                temp.add(x);
            }else {
                stringListHashMap.put(String.valueOf(chars), new ArrayList<>());
                stringListHashMap.get(String.valueOf(chars)).add(x);
            }
        }
        return new ArrayList<>(stringListHashMap.values());
    }
}
