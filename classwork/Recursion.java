//*RecursionClasswork X for commits
public class Recursion {
  public static boolean partialSum(int[] ary, int target){
    return partialSum(ary, target, 0, 0);
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
}
