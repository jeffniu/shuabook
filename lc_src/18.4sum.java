class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length < 4) return result; 
		Arrays.sort(nums);
		for (int i = 0; i <= nums.length-4; i++) {
			while (i > 0 && i < nums.length && nums[i] == nums[i-1]) i++;
			if (i > nums.length-4) break;
			for (int j = i+1; j <= nums.length-3; j++) {
				while (j > i+1 && j <= nums.length-3 && nums[j] == nums[j-1]) j++;
				if (j > nums.length-3) break;
				int k = j+1;
				int l = nums.length-1;
				int t = target - nums[i] - nums[j];
				while (k < l) {
					while (k > j+1 && k < l && nums[k] == nums[k-1]) k++;
					while (l < nums.length-1 && l > k && nums[l] == nums[l+1]) l--;
					if (k == l) break;
					int sum = nums[k] + nums[l];
					if (sum == t) {
						List<Integer> arr = new ArrayList<>();
						arr.add(nums[i]);
						arr.add(nums[j]);
						arr.add(nums[k]);	
						arr.add(nums[l]);
						result.add(arr);
						k++;
						l--;	
					} else if (sum < t) {
						k++;
					} else {
						l--;
					}
				}
			}
		}
		return result;
    }
}
