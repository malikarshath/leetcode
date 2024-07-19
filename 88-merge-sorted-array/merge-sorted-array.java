class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = 0;
        int j = 0;

        int[] ans = new int[m+n];
        int idx = 0;

        while(i < m && j < n) {
            if(nums1[i] <= nums2[j]) {
                ans[idx] = nums1[i];
                i++;
            } else {
                ans[idx] = nums2[j];
                j++;
            }
            idx++;
        }

        while(i < m) {
            ans[idx] = nums1[i];
            i++;
            idx++;
        }

        while(j < n) {
            ans[idx] = nums2[j];
            idx++;
            j++;
        }

        idx = 0;

        for(int l = 0; l < nums1.length; l++) {
            nums1[l] = ans[idx];
            idx++;
        }
        
    }
}