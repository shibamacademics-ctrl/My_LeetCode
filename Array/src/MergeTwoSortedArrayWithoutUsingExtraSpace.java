import java.util.Arrays;

public class MergeTwoSortedArrayWithoutUsingExtraSpace {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;          // Last valid element in nums1
        int j = n - 1;          // Last element in nums2
        int k = m + n - 1;      // Last position in nums1

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }


        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
    public static void main(String[] args) {
        int ar1[] = {1,2,3,0,0,0};
        int ar2[] = {2,5,6};
        int m = 3;
        int n = 3;
        System.out.println("Array 1 is:"+Arrays.toString(ar1));
        System.out.println("Array 1 is:"+Arrays.toString(ar2));
        merge(ar1,m,ar2,n);
        System.out.println("After merging array is:"+Arrays.toString(ar1));
    }
}
