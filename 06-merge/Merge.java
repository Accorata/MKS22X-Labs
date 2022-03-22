import java.util.Arrays;
public class Merge {
  public static void main(String[] args) {
    int[] a = new int[]{0,3,4,4,5,6};
    int[] b = new int[]{-3,-1, 0, 0, 5, 6};
    int[] n = merge(a,b);
    System.out.println(Arrays.toString(n));
  }
  public static int [] merge(int [] left, int[] right){
    int[] newArr = new int[left.length+right.length];
    int leftIndex = 0;
    int rightIndex = 0;
    for (int i = 0; i<newArr.length; i++){
      if (leftIndex < left.length && left[leftIndex] <= right[rightIndex]){
        newArr[i] = left[leftIndex];
        leftIndex++;
      } else {
        newArr[i] = right[rightIndex];
        rightIndex++;
      }
    }
    return newArr;
  }

  // public static void mergesort(data){
  //   int [] temp  =  mergeSortH(data);
  //   //copy temp into data
  // }

  public static int[] mergesortH(data){
    if (data.length > 1){
       left = new int[data.length/2];
       for (int i = 0; i<left.length; i++){
         left[i] = data[i];
       }
       right = new int[data.length-data.length/2];
       for (int i = 0; i<right.length; i++){
         right[i] = data[i+data.length/2];
       }
       return merge(mergesortH(left),mergesortH(right));
    }
  }
}
