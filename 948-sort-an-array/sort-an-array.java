class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        merge(0, n - 1, nums);
        return nums;
    }

    public void merge(int s, int e, int[] nums) {
        if(s >= e) {
            return;
        }

        int mid = ((e - s) / 2) + s;
        merge(s, mid, nums);
        merge(mid + 1, e, nums);

        mergeSort(s, mid, e, nums);
    }

    public void mergeSort(int s, int mid, int e, int[] nums) {
        int n = mid - s + 1;
        int m = e - mid;

        int[] left = new int[n];
        int[] right = new int[m];
        int idx = 0;

        for(int i = s; i <= mid; i++) {
            left[idx] = nums[i];
            idx++;
        }

        idx = 0;

        for(int i = mid + 1; i <= e; i++) {
            right[idx] = nums[i];
            idx++;
        }

        int l = 0;
        int r = 0;
        idx = s;

        while(l < n && r < m) {
            if(left[l] <= right[r]) {
                nums[idx] = left[l];
                l++;
            } else {
                nums[idx] = right[r];
                r++;
            }
            idx++;
        }

        while(l < n) {
            nums[idx] = left[l];
            l++;
            idx++;
        }

        while(r < m) {
            nums[idx] = right[r];
            r++;
            idx++;
        }
    }
}