import java.util.Arrays;
public class Preliminary {
  /*Modify the array such that:
*1. A random index from start to end inclusive is chosen, the
* corresponding element is designated the pivot element.
*2. all elements in range that are smaller than the pivot element
* are placed before the pivot element.
*3. all elements in range that are larger than the pivot element are
*placed after the pivot element.
*4. Only the indices from start to end inclusive are considered in range
*@return the index of the final position of the pivot element.
*/
  public static void main(String[] args) {
    int[] test = new int []{999,999,999,4,3,2,1,0,999,999,999};
    System.out.println(partition(test,3,7));
    System.out.println(Arrays.toString(test));
  }
  public static int partition ( int [] data, int start, int end){
    int p = (int)(Math.random()*(end+1) + start);
    System.out.println(data[p]);
    int temp = data[start];
    data[start] = data[p];
    data[p] = temp;
    int i = start+1;
    while(i<=end) {
      if (data[i] < data[p]) {
        temp = data[i];
        data[i] = data[p];
        data[p] = temp;
        i++;
      } else {
        temp = data[i];
        data[i] = data[end];
        data[end] = temp;
        end--;
      }
    }
    return i;
  }
}
