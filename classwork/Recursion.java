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
  public static boolean splitOdd10(int[] nums) {
    return splitOdd10(nums, 0, 0, 0);
  }
  public static boolean splitOdd10(int[] nums, int sum1, int sum2, int index){
    if (index == nums.length) return (sum1 % 10 == 0) && (sum2 % 2 == 1);
    return splitOdd10(nums, sum1+nums[index], sum2, index+1) || splitOdd10(nums, sum1, sum2+nums[index], index+1);
  }
  public static boolean split53(int[] nums) {
    return split53(nums, 0, 0, 0);
  }
  public static boolean split53(int[] nums, int sum1, int sum2, int index){
    if (index == nums.length) return sum1 == sum2;
    if (nums[index] % 5 == 0) return split53(nums, sum1+nums[index], sum2, index+1);
    if (nums[index] % 3 == 0) return split53(nums, sum1, sum2+nums[index], index+1);
    return split53(nums, sum1+nums[index], sum2, index+1) || split53(nums, sum1, sum2+nums[index], index+1);
  }
  public static boolean groupSum5(int start, int[] nums, int target) {
    return groupSum5(nums, target, 0, start, false);
  }
  public static boolean groupSum5(int[] nums, int target, int sum, int index, boolean added){
    if (index >= nums.length) return sum == target;
    if (nums[index] % 5 == 0) return groupSum5(nums, target, sum+nums[index], index+1, true);
    if (added && nums[index] == 1) return groupSum5(nums, target, sum, index+1, false);
    return groupSum5(nums, target, sum+nums[index], index+1, false) || groupSum5(nums, target, sum, index+1, false);
  }
}
//*RecursionClasswork X for commits
