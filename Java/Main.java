public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        Solution test = new Solution();
        double ans = test.findMedianSortedArrays(nums1, nums2);
        System.out.println(ans);
    }
}
