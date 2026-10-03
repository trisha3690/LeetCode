class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //check for empty inputs
        if(strs == null || strs.length==0) return new ArrayList<>();
        Map <String, List<String>> frequencyStringMap = new HashMap<>();
        for(String str : strs) {
            String frequencyString = getFrequencyString(str);
            //If the frequency string is present add the string to the list
            if (frequencyStringMap.containsKey(frequencyString)){
                frequencyStringMap.get(frequencyString).add(str);
            } else {
                //else create a new list
                List<String> strList = new ArrayList<>();
                strList.add(str);
                frequencyStringMap.put(frequencyString, strList);
            }
        }
        return new ArrayList(frequencyStringMap.values());
    }
    private String getFrequencyString(String str){
        //Frequrncy buckets
        int[] freq = new int[26];
        //Iterate over each character
        for (char c : str.toCharArray()) {
            freq [c - 'a']++;
        }
        //Start creating the frequency string
        StringBuilder frequencyString = new StringBuilder("");
        char c = 'a';
        for (int i : freq) {
            frequencyString.append(c);
            frequencyString.append(i);
            c++;
        }
        return frequencyString.toString();
    }
} // T.C = O(nk) S.C = O(nk)  n is number of string in strs and k is max length if any string