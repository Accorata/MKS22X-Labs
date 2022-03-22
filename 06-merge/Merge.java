import java.util.Arrays;
public class Merge {
  public static void main(String[] args) {
    int[] a = new int[]{0,3,4,4,5,6};
    int[] b = new int[]{-3,-1, 0, 0, 5, 6};
    int[] n = merge(a,b);
    int[] arr = new int[]{5,67, 8,-1, 6, -89, 0, 0, 0, 0, 1, 1};
    //int[] m = mergesortH(arr);
    mergesort(arr);
    System.out.println(Arrays.toString(arr));
  }
  public static int [] merge(int [] left, int[] right){
    int[] newArr = new int[left.length+right.length];
    int leftIndex = 0;
    int rightIndex = 0;
    for (int i = 0; i<newArr.length; i++){
      if (rightIndex >= right.length || (leftIndex < left.length && left[leftIndex] <= right[rightIndex])){
        newArr[i] = left[leftIndex];
        leftIndex++;
      } else {
        newArr[i] = right[rightIndex];
        rightIndex++;
      }
    }
    return newArr;
  }
  public static void mergesort(int[] data){
    int [] temp  =  mergesortH(data);
    for (int i = 0; i<data.length; i++){
      data[i] = temp[i];
    }
  }
  public static int[] mergesortH(int[] data){
    if (data.length < 2) return data;
    int[] left = new int[data.length/2];
    for (int i = 0; i<left.length; i++){
      left[i] = data[i];
    }
    int[] right = new int[data.length-data.length/2];
    for (int i = 0; i<right.length; i++){
      right[i] = data[i+data.length/2];
    }
    //System.out.println(Arrays.toString(data)+"  "+Arrays.toString(left)+"  "+Arrays.toString(right));
    return merge(mergesortH(left),mergesortH(right));
  }
}
