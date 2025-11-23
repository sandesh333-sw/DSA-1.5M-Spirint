public class HouseRobber {
    public static int houseRobber(int[] nums){
      // If there is only one element then, return it
      if(nums.length < 2){
          return nums[0];
      }  
      // Create an array to store maxLoot
      int[] dp = new int[nums.length];

      // Memoize first two values in dp
      dp[0] = nums[0];
      dp[1] = Math.max(nums[0],nums[1]);

      // Loop to iterate and calculate the rest of the loot
      for(int i=2; i<nums.length; i++){
          dp[i] = Math.max(dp[i-2]+ nums[i], dp[i-1]);
      }
      return dp[nums.length-1];

    }

    public static void main(String args[]){
        int[] numbers = {2,7,3,1,4,2,1,8};
        System.out.println(houseRobber(numbers));
    }
}