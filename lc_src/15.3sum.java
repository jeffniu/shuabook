class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length < 3) return result;
		Arrays.sort(nums);
		for (int i = 0; i <= nums.length-3; i++) {
			while(i > 0 && i < nums.length && nums[i] == nums[i-1]) i++;
			if (i > nums.length-3) break;
			int two = 0 - nums[i];
			int j = i+1;
			int k = nums.length-1;
			while (j < k) {
				while (j > i+1 && j < k && nums[j] == nums[j-1]) j++;
				while (k < nums.length-1 && k > j && nums[k] == nums[k+1]) k--;
				if (j == k) break;
				int sum = nums[j] + nums[k];
				if (sum == two) {
					addResult(result, nums, i, j, k);	
					//I forget change j, k after add result;
					j++;
					k--;
				} else if (sum < two) {
					j++;
				} else {
					k--;
				}
			}
		}
		return result;
    }
	
	private void addResult(List<List<Integer>> result, int[] nums, int i, int j, int k) {
		List<Integer> triple = new ArrayList<>();
		triple.add(nums[i]);
		triple.add(nums[j]);
		triple.add(nums[k]);
		result.add(triple);
	}
}
