class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if(n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int fal = (n + m + 1)/ 2;
        int s = 0;
        int e = n;

        while(s <= e) {
            int p1 = (s + e) / 2;
            int p2 = fal - p1;

            int l1 = p1 - 1 >= 0 ? nums1[p1 - 1] : Integer.MIN_VALUE; 
            int l2 = p2 - 1 >= 0 ? nums2[p2 - 1] : Integer.MIN_VALUE; 
            int r1 = p1 < n ? nums1[p1] : Integer.MAX_VALUE;
            int r2 = p2 < m ? nums2[p2] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1) {
                double maxval = Math.max(l1, l2);
                double minval = Math.min(r1, r2);

                if((n + m)% 2 == 0) {
                    return (minval + maxval) * 0.5;
                } 
                return maxval;
            } else if(l1 > r2) {
                e = p1  - 1;
            } else if(l2 > r1) {
                s = p1 + 1;
            }
        }

        return 0;
    }
}