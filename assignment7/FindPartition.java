package assignment7;

// 5.
public class FindPartition {
  public boolean findPartition (int[] nums) {
     int sum=0;  
     for (int num:nums) sum+= num;
     if(sum % 2 == 1) {
    	 	return false;
     } else {  
        sum /=2;
        int n=nums.length;  
        int dp[][]=new int[n][sum + 1];
        for(int i=nums[0];i<=sum;i++){
             dp[0][i] = nums[0];
        }
        
        for(int i=1;i<n;i++){  
            for(int j=nums[i];j<=sum;j++){  
                dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-nums[i]]+nums[i]);  
            }  
        }  
        
        if(dp[n-1][sum]==sum) 
            return true;  
        else
            return false;  
     }  
  }
  
  public static void main(String[] args) {	  
	  System.out.println(new FindPartition().findPartition(new int[] {1, 5, 11, 5}));
  }
}
