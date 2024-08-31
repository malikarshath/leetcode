class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;

        int ans = 0;

        //Map<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i <= n; i++) {
            int freq = 0;
            for(int j = 0; j < n; j++) {
                if(citations[j] >= i) {
                    freq = n - j;
                    break;
                }
            }
            if(freq >= i) {
                ans = i;
            }
            //mp.put(i, freq);

        }


        if(n == 1 && citations[0] >= 1) {
            return 1;
        }


        // for(int i = 0; i < n; i++) {

        //     if(n - i == citations[i]) {
        //         ans = n - i;
        //     } else if(n - i > citations[i]) {
        //         ans = citations[i];
        //     }
        // }

        return ans;
        
    }
}  