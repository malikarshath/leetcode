class Solution {
    public int maxDistance(int[] position, int m) {

        Arrays.sort(position);
        
        int min = Integer.MAX_VALUE;

        int minVal = position[0];
        int maxVal = position[0];

        for(int i = 1; i < position.length; i++) {
            min = Math.min(min, Math.abs(position[i] - position[i - 1]));
            minVal = Math.min(minVal, position[i]);
            maxVal = Math.max(maxVal, position[i]);
        }

        int max = maxVal - minVal;

        int s = min;
        int e = max;

        int ans = -1;

        while(s <= e) {
            int mid = ((e - s) / 2) + s;

            if(check(position, mid, m)) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return ans;
    }

    public boolean check(int[] arr, int mid, int m) {
        int lastIndex = 0;
        int balls = 1;

        for(int i = 1; i < arr.length; i++) {
            if(Math.abs(arr[i] - arr[lastIndex]) >= mid) {
                balls++;
                lastIndex = i;
            }
        }

        if(balls >= m) {
            return true;
        }

        return false;
    }
}