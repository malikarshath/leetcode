class Solution {
    public int minInsertions(String s) {

        int insertionCount = 0;
        int left = 0;
        int right = 0;

        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '(') {
                if(left >= right && right != 0) { // (()
                    left--;
                    right--;
                    insertionCount++;
                } else if(right == 1 && left  == 0) { // )
                    insertionCount += 2;
                    right--;
                }
                left++;
            } else {
               right++;
               if(right > 1) {
                if(left == 0 && right == 2) { // ))
                    right -= 2;
                    insertionCount++;
                } else { // ())
                    left--;
                    right -= 2;
                }
               }

            }
        }

        if(left >= right) { // ((())  ()
            insertionCount += (left * 2) - right;
        } else if(right == 1 && left  == 0) { // )
            insertionCount += 2;
        }


        return insertionCount; // 
    }
}