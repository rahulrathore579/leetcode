class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int x:nums){
            total+=x;
        }
        if(total%2!=0){
            return false;
        }
        int target=total/2;
        int[][] dp=new int[nums.length][total+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        return subsetSum(0, target, nums, dp);
    }

    public static boolean subsetSum(int i, int target, int[] arr, int[][] dp){
        if(target==0){
            return true;
        }
        if(i==arr.length){
            return false;
        }
        if(dp[i][target]!=-1){
            return dp[i][target]==1;
        }
        boolean nottake=subsetSum(i+1,target, arr, dp);
        boolean take=false;
        if(arr[i]<=target){
            take=subsetSum(i+1,target-arr[i], arr, dp);
        }
        dp[i][target]=(take || nottake) ? 1:0;
        return take || nottake;
    }
}