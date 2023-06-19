#User function Template for python3

class Solution:
    #Function to sort a list using quick sort algorithm.
    def quickSort(self,arr,low,high):
        # code here
        if low < high:
            partition = self.partition(arr,low,high)
            self.quickSort(arr,low,partition-1)
            self.quickSort(arr,partition+1,high)
            
    
    def partition(self,arr,low,high):
        # code here
        pivot = arr[low]
        i = low
        j = high
        while i<j:
            while arr[i] <= pivot and i <= high-1:
                i +=1
            while arr[j] > pivot and j >= low+1:
                j -= 1
            if i < j:
                temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
        temp = arr[low]
        arr[low] = arr[j]
        arr[j] = temp
        return j


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == "__main__":
    t=int(input())
    for i in range(t):
        n=int(input())
        arr=list(map(int,input().split()))
        Solution().quickSort(arr,0,n-1)
        for i in range(n):
            print(arr[i],end=" ")
        print()

# } Driver Code Ends