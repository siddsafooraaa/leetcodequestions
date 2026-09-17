class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int size = m + n;
        int idx1 = size / 2 - 1;
        int idx2 = size / 2;
        int el1 = -1;
        int el2 = -1;
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                if (k == idx1)
                    el1 = nums1[i];
                if (k == idx2)
                    el2 = nums1[i];
                i++;
            } else {
                if (k == idx1)
                    el1 = nums2[j];

                if (k == idx2)
                    el2 = nums2[j];

                j++;
            }

            k++;
        }

        while (i < m) {

            if (k == idx1)
                el1 = nums1[i];

            if (k == idx2)
                el2 = nums1[i];

            i++;
            k++;
        }

        while (j < n) {

            if (k == idx1)
                el1 = nums2[j];

            if (k == idx2)
                el2 = nums2[j];

            j++;
            k++;
        }

        if (size % 2 == 1)
            return el2;

        return (el1 + el2) / 2.0;
    }
}
