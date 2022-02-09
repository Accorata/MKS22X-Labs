//*RecursionClasswork X for commits
public class Recursion {
  public static boolean partialSum(int[] ary, int target){
    return partialSum(ary, target, 0, 0);
  }
  public static boolean partialSum(int start, int[] ary, int target){
    return partialSum(ary, target, 0, start);
  }
  public static boolean partialSum(int[] ary, int target, int sum, int index){
    if (sum == target) return true;
    if (index >= ary.length) return false;
    return partialSum(ary, target, sum+ary[index], index+1) || partialSum(ary, target, sum, index+1);
  }
  public static boolean splitArray(int[] ary){
    return splitArray(ary, 0, 0, 0);
  }
  public static boolean splitArray(int[] ary, int sum1, int sum2, int index){
    if (index == ary.length) return sum1 == sum2;
    return splitArray(ary, sum1+ary[index], sum2, index+1) || splitArray(ary, sum1, sum2+ary[index], index+1);
  }
  public static String intToString (int num, int index){
    String ans = "";
    String[] nums = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    if (index == 0) return nums[num%10];
//Set ans to other stuff based on index and num
    return ans + intToString(num, index-1);
  }
  public static boolean groupSum6(int start, int[] nums, int target) {
    return groupSum6(nums, target, 0, start);
  }
  public static boolean groupSum6(int[] nums, int target, int sum, int index){
    if (index >= nums.length) return sum == target;
    if (nums[index] == 6) return groupSum6(nums, target, sum+6, index+1);
    return groupSum6(nums, target, sum+nums[index], index+1) || groupSum6(nums, target, sum, index+1);
  }
  public static boolean groupNoAdj(int start, int[] nums, int target) {
    return groupNoAdj(nums, target, 0, start, false);
  }
  public static boolean groupNoAdj(int[] nums, int target, int sum, int index, boolean added){
    if (index >= nums.length) return sum == target;
    if (added) return groupNoAdj(nums, target, sum, index+1, false);
    return groupNoAdj(nums, target, sum+nums[index], index+1, true) || groupNoAdj(nums, target, sum, index+1, false);
  }
}
