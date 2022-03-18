import java.util.Arrays;
public class Quick {
  public static void main(String[] args) {
    int[] test = new int []{999,999,999,4,3,2,1,0,0, 1, 2, 3, 4,999,999,999};
    int[] ary = {2, 10, 15, 23, 0, 5, 5678, -7, 0, 0, 0, 0, 0, 0, 0};
    int[] problem = {4,4,4,4,4};
    // System.out.println(Arrays.toString(test));
    // System.out.println(Arrays.toString(partitionDutch(test,3,12)));
    // System.out.println(Arrays.toString(test));
    //System.out.println(quickselect(ary, Integer.parseInt(args[0])));
    System.out.println(Arrays.toString(ary));
    quicksort(ary);
    System.out.println(Arrays.toString(ary));
  }
  public static void quicksort(int[] data) {
    quicksort (data, 0, data.length-1);
  }
  public static void quicksort (int[] data, int start, int end){
    if (start < end) {
      // int pivot = partition(data, start, end);
      // quicksort(data, start, pivot-1);
      // quicksort(data, pivot+1, end);
      int[] pivot = partitionDutch(data, start, end);
      quicksort(data, start, pivot[1]-1);
      quicksort(data, pivot[0]+1, end);
    }
  }
  public static void quicksortInsertion (int[] data, int start, int end){
    if (start < end) {
      if (Math.abs(start-end) > 32) {
        int[] pivot = partitionDutch(data, start, end);
        quicksort(data, pivot[0]+1, pivot[1]-1);
        quicksort(data, pivot[0]+1, pivot[1]-1);
      } else {
        //insertionSort(sdfghjkl);
      }
    }
  }
  public static int quickselect(int []data, int k){
    int start = 0;
    int end = data.length-1;
    int pivot = partition(data, start, end);
    while (pivot != k) {
      if (pivot < k){
        start = pivot;
        pivot = partition(data, start, end);
      } else {
        end = pivot;
        pivot = partition(data, start, end);
      }
    }
    return data[k];
  }
  public static void insertionSort(int[] data,int lo, int hi){
    int current;
    for (int i = 1; i<data.length; i++){
      if (data[i] < data[i-1]) {
        current = data[i];
        for (int j = i; j>0; j--){
          if (current < data[j-1]) {
            data[j] = data[j-1];
            data[j-1] = current;
          } else {
            data[j] = current;
            j = 0;
          }
        }
      }
    }
  }
  public static int[] partitionDutch(int[] data,int lo, int hi){
    int p = (int)(Math.random()*(hi-lo+1) + lo);
    int lt = lo;
    int temp = data[lo];
    data[lo] = data[p];
    data[p] = temp;
    p = lo;
    while(p < hi) {
      if (data[p+1] == data[p]){
        p++;
      } else if (data[p+1] < data[p]) {
        temp = data[lt];
        data[lt] = data[p+1];
        data[p+1] = temp;
        p++;
        lt++;
      } else {
        temp = data[p+1];
        data[p+1] = data[hi];
        data[hi] = temp;
        hi--;
      }
    }
    return new int[]{lt,p};
  }
  public static int partition ( int [] data, int start, int end){
    int p = (int)(Math.random()*(end-start+1) + start);
    int temp = data[start];
    boolean addFront = false;
    if (end == data.length-1) addFront = true;
    data[start] = data[p];
    data[p] = temp;
    p = start;
    while(p < end) {
      if (data[p+1] == data[p]){
        if (addFront) {
          addFront = false;
          temp = data[p+1];
          data[p+1] = data[p];
          data[p] = temp;
          p++;
        } else {
          addFront = true;
          temp = data[p+1];
          data[p+1] = data[end];
          data[end] = temp;
          end--;
        }
      } else if (data[p+1] < data[p]) {
        temp = data[p+1];
        data[p+1] = data[p];
        data[p] = temp;
        p++;
      } else {
        temp = data[p+1];
        data[p+1] = data[end];
        data[end] = temp;
        end--;
      }
    }
    return p;
  }
}
