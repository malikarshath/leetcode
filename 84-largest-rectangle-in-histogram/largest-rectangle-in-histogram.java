class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = nsl(heights);
        int[] right = nsr(heights);
        int maxArea = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public int[] nsl(int[] heights) {
        int n = heights.length;
        int[] nsl = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && heights[i] <= heights[st.peek()] ) {
                st.pop();
            }
            if(st.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = st.peek();
            }
            st.add(i);  
        }

        return nsl;
    }

    public int[] nsr(int[] heights) {
        int n = heights.length;
        int[] nsr = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && heights[i] <= heights[st.peek()] ) {
                st.pop();
            }
            if(st.isEmpty()) {
                nsr[i] = n;
            } else {
                nsr[i] = st.peek();
            }
            st.add(i);  
        }
        
        //reverse(nsr);
        return nsr;
    }

    public void reverse(int[] arr) {
        int i = 0;
        int j = arr.length -1;

        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}