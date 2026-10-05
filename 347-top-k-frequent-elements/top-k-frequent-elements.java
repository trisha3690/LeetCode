class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Count the frequency of each number
        HashMap<Integer, Integer>map = new HashMap<>();
        for ( int num : nums) {
            map.put(num,map.getOrDefault(num, 0)+ 1);
        }
        // Create buckets
        // Index = frequency
        // Maximun possible frequency = nums.length
        List<Integer>[] buckets = new ArrayList[nums.length+1];
        // Put each number into its frequency bucket
        for ( int num : map.keySet()) {
            int frequency = map.get(num);
            // Create the list if it doesn't exist
            if (buckets[frequency]==null){
                buckets[frequency]=new ArrayList<>();
            }
            //Add the number to the bucket
            buckets[frequency].add(num);
        }
        // Store the top k frequent elements
        int[] result = new int[k];
        int index = 0;
        // Start from the highest frequency
        for(int frequency=buckets.length-1;frequency>=0 && index<k;frequency--){
            // If this frequency has some numbers
            if(buckets[frequency]!=null){
                // Add those numbers to result
                for(int num : buckets[frequency]){
                    result[index] = num;
                    index++;
                    // Stop when we get k elements
                    if(index == k) {
                        break;
                    }
                }
            }
        }
        return result;
    }
} //T.C = O(n)  S.C = O(n)