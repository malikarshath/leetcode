#Sort the array using insertion sort

class Solution:
    def insert(self, alist, index, n):
        #code here
        while index>0 and alist[index]<alist[index-1]:
            temp = alist[index-1]
            alist[index-1] = alist[index]
            alist[index] = temp
            index -= 1
            
        
    #Function to sort the list using insertion sort algorithm.    
    def insertionSort(self, alist, n):
        #code here
        for i in range(0,n):
            self.insert(alist,i,n)

#{ 
 # Driver Code Starts
if __name__=="__main__":
    t=int(input())
    for i in range(t):
        n=int(input())
        arr=list(map(int,input().split()))
    
        Solution().insertionSort(arr,n)
    
        for i in range(n):
            print(arr[i],end=" ")
    
        print()
# } Driver Code Ends