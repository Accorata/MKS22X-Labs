import java.util.Arrays;
public class Quick {
  public static void main(String[] args) {
    int[] test = new int []{999,999,999,4,3,2,1,0,999,999,999};
    int[] ary = {2, 10, 15, 23, 0, 5};
    int[] problem = {4,4,4,4,4};
    //System.out.println(partition(test,3,7));
    //System.out.println(quickselect(problem, Integer.parseInt(args[0])));
    System.out.println(Arrays.toString(ary));
    quicksort(ary);
    System.out.println(Arrays.toString(ary));
  }
  public static void quicksort(int[] data) {
    quicksort (data, 0, data.length-1);
  }
  public static void quicksort (int[] data, int start, int end){
    if (start < end) {
      int pivot = partition(data, start, end);
      quicksort(data, start, pivot-1);
      quicksort(data, pivot+1, end);
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
