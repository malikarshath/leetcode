class Solution {
    public int maxDistance(int[] position, int m) {

        Arrays.sort(position);
        int n = position.length;
        
        int min = Integer.MAX_VALUE;

        for(int i = 1; i < position.length; i++) {
            min = Math.min(min, Math.abs(position[i] - position[i - 1]));
        }

        int max = position[n - 1] - position[0];

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