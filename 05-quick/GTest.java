import java.util.Arrays;
public class GTest {
  public static void main(String[] args){

    int[] nums = {
     2,2,3,3,1,1,-2,-2
    };
    int[] nums2 = {
     2,2,3,3,1,1,-2,-2
    };
    GQuick.quicksort(nums);
    Arrays.sort(nums2);
    if(Arrays.equals(nums,nums2)) System.out.println("repeating works");
    nums = new int[] {
     1,2,3,4,5,6,7
    };
      nums2 = new int[] {
    1,2,3,4,5,6,7
    };
    GQuick.quicksort(nums);
    Arrays.sort(nums2);
    if(Arrays.equals(nums,nums2)) System.out.println("presorted works");
    nums = new int[] {
     0,0,0,000,0
    };
    nums2 = new int[] {
     0000,0,0,00,0
    };
    GQuick.quicksort(nums);
    Arrays.sort(nums2);
    if(Arrays.equals(nums,nums2)) System.out.println("0s work");
    nums = new int[] {
     5,4,3,2,1
    };
    nums2 = new int[] {
     5,4,3,2,1
    };
    GQuick.quicksort(nums);
    Arrays.sort(nums2);
    if(Arrays.equals(nums,nums2)) System.out.println("reverse works");
    nums =
      arrgen(5000000);

    nums2 = nums.clone();
    GQuick.quicksort(nums);
    Arrays.sort(nums2);
    if(Arrays.equals(nums,nums2)) System.out.println("Big Random Array Works");
    nums = new int[] {
     6,7,89,4,2,4
    };
    nums2 = new int[] {
      6,7,89,4,2,4
    };
    GQuick.quicksort(nums);
    Arrays.sort(nums2);

    if(Arrays.equals(nums,nums2)) System.out.println("Test Array works");


  }
  public static int[] arrgen(int len){
    int[] arr = new int[len];
    for(int i = 0;i< len;i++){
      arr[i]=(int)(Math.random() * 10000 -5000);
    }
    return arr;
  }
}
