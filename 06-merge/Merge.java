public class Merge {
  public static int [] merge(int [] left, int[] right){
    int[] newArr = new int[left.length+right.length];
    int leftIndex = 0;
    int rightIndex = 0;
    for (int i = 0; i<new.length; i++){
      if (left[leftIndex] >= right[rightIndex]){
        newArr[i] 
      }
    }
  }

  public static void mergesort(data){
    int [] temp  =  mergeSortH(data);
    //copy temp into data
  }

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
       return merge(mergesortH(left),mergesortH(right))
    }
  }
}
