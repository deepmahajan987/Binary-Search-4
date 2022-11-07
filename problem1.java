package s30.Binary-Search-4;

public class problem1 {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            //TC:- O(n2logn1)
            //SC:- O(1)
            if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
                return new int[] {};
            }
            
            int n1 = nums1.length;
            int n2 = nums2.length;
            
            if(n2 < n1){
                return intersect(nums2, nums1);
            }
            
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            List<Integer> result = new ArrayList<>();
            
            int low = 0;
            for(int i = 0; i < n1; i++){
                int bsIndex = binarySearch(nums2, low, n2 - 1 , nums1[i]);
                if(bsIndex != -1){
                    low  = bsIndex + 1;
                    result.add(nums1[i]);
                }
            }
            
            int[] ans = new int[result.size()];
            for(int i = 0 ; i < result.size() ; i++){
                ans[i] = result.get(i);
            }
            
            return ans;
            
        }
        public int binarySearch(int[] nums, int low, int high, int target){
            while(low <= high){
                
                int mid = low + (high - low)/2;
                
                if( nums[mid] == target){
                    if(mid == low || nums[mid - 1] < nums[mid]){
                        return mid;
                    }
                    high = mid - 1;
                }else if(target < nums[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            
            return -1;
        }
    }
}
