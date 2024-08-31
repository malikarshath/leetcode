class Solution {
    public int hIndex(int[] citations) {
        //Arrays.sort(citations, Collections.reverseOrder());
        Arrays.sort(citations);

        int n = citations.length;
        int l = 0, r = n - 1;

        while(l < r) {
            int temp = citations[l];
            citations[l] = citations[r];
            citations[r] = temp;
            l++;
            r--;
        }

        int ans = 0;

        // for(int i = 0; i <= n; i++) {
        //     int freq = 0;
        //     for(int j = 0; j < n; j++) {
        //         if(citations[j] >= i) {
        //             freq = n - j;
        //             break;
        //         }
        //     }
        //     if(freq >= i) {
        //         ans = i;
        //     }

        // }

        for(int i = 0; i < n; i++) {

            int hIndex = i + 1;

            if(citations[i] >= hIndex) { // 0 1 3 6 5
                ans = hIndex;
            }
        }

    

        return ans;
        
    }
}  