class Solution {
    public int findPeakElement(int[] nums) {
        
        int n = nums.length;
        int s = 0;
        int e = n - 1;

        while(s <= e) {
            int mid = ((e - s) / 2) + s;

            long prev = mid - 1 >= 0 ? nums[mid - 1] : Integer.MIN_VALUE - 1L;
            long after = mid + 1 < n ? nums[mid + 1] : Integer.MIN_VALUE - 1L;


            long midVal = nums[mid];

            //System.out.println(prev + "  "+midVal+"  "+after);

            if(midVal > prev && midVal > after) {
                return mid;
            }

            if(midVal > prev && midVal < after) {
                s = mid + 1;
            } else if(midVal < prev && midVal > after) {
                e = mid - 1;
            } else {
                e = mid - 1;
            }
        }

        return -1;
    }
}