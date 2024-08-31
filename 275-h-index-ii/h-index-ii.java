class Solution {
    public int hIndex(int[] citations) {

        int n = citations.length;

        int s = 0;
        int e = n - 1;

        int ans = 0;

        while(s <= e) {
            int mid = (s + e) / 2;

            int hIndex = n - mid;

            if(hIndex <= citations[mid]) {
                ans = hIndex;
                e = mid - 1;
            } else if(hIndex > citations[mid]) {
                s = mid + 1;
            }
        }

        return ans;
        
    }
}