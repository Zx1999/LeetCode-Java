class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] arr = new int[m+n];
        int i = 0, j = 0, cur = 0;
        while(i < m && j < n) {
            if(nums1[i] < nums2[j]) {
                arr[cur] = nums1[i];
                i++;
            } else {
                arr[cur] = nums2[j];
                j++;
            }
            cur++;
        }
        while(i < m) {
            arr[cur++] = nums1[i++];
        }
        while(j < n) {
            arr[cur++] = nums2[j++];
        }
        if((m+n)%2 == 1) {
            return arr[(m+n-1)/2];
        } else {
            return (arr[(m+n-1)/2] + arr[(m+n-1)/2 + 1])/2;
        }
    }
}