class MedianFinder {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    public MedianFinder() {
        max = new  PriorityQueue<>(Collections.reverseOrder());
        min = new  PriorityQueue<>();

        
    }
    
    public void addNum(int num) {
        if(max.isEmpty() || num < max.peek()) {
            max.add(num);
        } else {
            min.add(num);
        }

        int diff = max.size() - min.size();

        if(diff == -1) {
            max.add(min.poll());
        } else if(diff == 2) {
            min.add(max.poll());
        }

    }
    
    public double findMedian() {
        int diff = max.size() - min.size();

        if(diff == 0) {
            return ((double)max.peek() + min.peek()) / 2;
        } else if(diff == 1) {
            return (double)max.peek();
        }

        return 0.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */