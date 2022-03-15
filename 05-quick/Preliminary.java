import java.util.Arrays;
public class Preliminary {
  public static void main(String[] args) {
    int[] test = new int []{999,999,999,4,3,2,1,0,999,999,999};
    int[] tests = new int []{7, 89, 3, 0, -4, 45, 89};
    //System.out.println(partition(test,3,7));
    System.out.println(quickselect(tests, Integer.parseInt(args[0])));
    System.out.println(Arrays.toString(tests));
  }
  public static int quickselect(int []data, int k){
    k--;
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
    data[start] = data[p];
    data[p] = temp;
    p = start;
    while(p < end) {
      if (data[p+1] == data[p]){
        if (addFront) {
          temp = data[p+1];
          data[p+1] = data[p];
          data[p] = temp;
          p++;
          addFront = false;
        } else {
          temp = data[p+1];
          data[p+1] = data[end];
          data[end] = temp;
          end--;
          addFront = true;
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
