class Solution {
    public int longestConsecutive(int[] nums) {
        

        Map<Integer, Pair> mp = new HashMap<>();
        for(int num : nums) {
            if(mp.containsKey(num)) {
                Pair curr = mp.get(num);
                Pair newPair = new Pair(num + 1, curr.freq + 1);
            } else {
                mp.put(num, new Pair(num + 1, 1));
            }
        }

        int max = 0;

        for(int num : nums) {

            int length = 0;
            int key = num;
            if(!mp.containsKey(key - 1)) {
                while(mp.containsKey(key)) {
                    Pair curr = mp.get(key);
                    int freq = curr.freq;
                    int nextNum = curr.nextNum;
                    length += freq;
                    key = nextNum;
                }
            }
            
            max = Math.max(max, length);
        }

        return max;
    }

    class Pair {
        int nextNum , freq;

        Pair(int n, int f) {
            this.nextNum = n;
            this.freq = f;
        }
    }
}