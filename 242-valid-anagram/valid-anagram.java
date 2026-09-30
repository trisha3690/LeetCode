class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] count = new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for(int num : count){
            if(num != 0) return false;
        }
        return true;
    }
} //T.C=O(n) S.C=O(1)
/*
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer>map = new HashMap<>();
        if(s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++){
          char sc = s.charAt(i);
          char st = t.charAt(i);
          map.put(sc,map.getOrDefault(sc,0) + 1);
          map.put(st,map.getOrDefault(st,0) - 1);
        }
        for(int num : map.values()){
            if(num!=0) return false;
        }
        return true;
    }
} //T.C=O(n) S.C=O(K),K is the number of distinct characters
*/
