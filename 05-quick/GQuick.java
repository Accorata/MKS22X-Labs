import java.util.Random;
public class GQuick {
  public static void quicksort(int[] data) {
    quicksort (data, 0, data.length-1);
  }
  public static void quicksort (int[] data, int start, int end){
    if (start < end) {
      int pivot = partitionDutch(data, start, end);
      quicksort(data, start, pivot-1);
      quicksort(data, pivot+1, end);
    }
  }
  public static int partition ( int [] data, int lo, int hi){
    if(hi == lo) return hi;
    int st = lo;
    swap(data,(lo + rng.nextInt(hi-lo)),lo);
    while (lo<hi){
      if(data[lo+1] < data[st]) {
        lo++;
      }
      else{
        swap(data,lo+1,hi);
        hi--;
      }
    }
    swap(data,lo,st);
    return lo;
  }
  public static int partitionDutch ( int [] data, int lo, int hi){
    if(hi == lo) return hi;
    int c = 0;
    swap(data,(lo + rng.nextInt(hi-lo)),lo);
    while (lo+1<=hi){
      if(data[lo+1] < data[lo-c]) {
        swap(data,lo-c,lo+1);
        lo++;
      }
      else if(data[lo+1] > data[lo]){
        swap(data,lo+1,hi);
        hi--;
      }else{
        lo++;c++;
      }
    }
    return lo-c;
  }
  private static void swap(int[] data, int a, int b){
    int val = data[a];
    data[a] = data[b];
    data[b] = val;
  }
  private static   Random rng = new Random();
}
