public class Merge {
  public static int [] merge(int [] left, int[] right){
          //return a new array that is the merged version of left and right
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
