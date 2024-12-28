class Solution {
    public int longestConsecutive(int[] nums) {
        
        Map<Integer, Pair> freqMap = new HashMap<>();
        int maxLength = 0;
        for(int num : nums) {
            freqMap.put(num, new Pair(num + 1, 1));
        }

        for(Integer key: freqMap.keySet()) {
            int length = 0;
            if(!freqMap.containsKey(key - 1)) {
                int currKey = key;
                while(freqMap.containsKey(currKey)) {
                    Pair currPair = freqMap.get(currKey);
                    currKey = currPair.key;
                    length += currPair.freq;
                }
            }

            maxLength = Math.max(maxLength, length);

        }

        return maxLength;
    }

    public class Pair {
        int key, freq;

        Pair(int key, int freq) {
            this.key = key;
            this.freq = freq;
        }
    }
}