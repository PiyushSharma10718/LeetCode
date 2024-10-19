class lc_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums3 = new int[m+n];
        int i=0, j=0, k=0;
        while(i < m && j < n)
        {
            if(nums1[i] <= nums2[j]){
                nums3[k++] = nums1[i++];
            }else
            {
                nums3[k++] = nums2[j++];
            }
        }

        while(i < m)
        {
            nums3[k++] = nums1[i++];
        }
        
        while(j < n)
        {
            nums3[k++] = nums2[j++];
        }

        int totalLength = nums3.length;
        // int totalLength = m + n;
        if(totalLength % 2 == 1)
        {
            return nums3[totalLength / 2];
        }else{
            int mid1 = totalLength / 2;
            int mid2 = mid1 - 1;
            return (nums3[mid1] + nums3[mid2]) / 2.0;
        }
    }
    public static void main(String[] args) {
        lc_4 obj = new lc_4();
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {6,7,8,9,10,11,12,13,14,15,16,17};
        double res = obj.findMedianSortedArrays(arr1, arr2);
        System.out.println(res);
    }
}
