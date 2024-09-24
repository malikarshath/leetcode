class Solution {
    public int[][] merge(int[][] intervals) {


        Arrays.sort(intervals, (first, second) -> {
            if(first[0] < second[0]) {
                return -1;
            } else if(first[0] > second[0]) {
                return 1;
            }

            return 0;
        });
        
        int a1 = intervals[0][0];
        int b1 = intervals[0][1];

        ArrayList<int[]> ans = new ArrayList<>();

        for(int i = 1; i < intervals.length; i++) {

            int a2 = intervals[i][0];
            int b2 = intervals[i][1];

            if(a2 <= b1) {
                b1 = Math.max(b1, b2);
            } else {
                int[] intervalArr = new int[2];
                intervalArr[0] = a1;
                intervalArr[1] = b1;
                ans.add(intervalArr);
                a1 = a2;
                b1 = b2;
            }
        }

        int[] intervalArr1 = new int[2];
        intervalArr1[0] = a1;
        intervalArr1[1] = b1;
        ans.add(intervalArr1);

        int[][] finalArr = ans.toArray(new int[ans.size()][]);

        return finalArr;
        
    }
}