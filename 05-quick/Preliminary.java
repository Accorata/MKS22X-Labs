import java.util.Arrays;
public class Preliminary {
  public static void main(String[] args) {
    int[] test = new int []{999,999,999,4,3,2,1,0,999,999,999};
    System.out.println(partition(test,3,7));
    System.out.println(Arrays.toString(test));
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
