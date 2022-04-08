import java.util.Arrays;
public class BurnTests {
  public static double average (int size, double density){
    double ans = 0;
    for (int i = 0; i<1000; i++) {
      BurnTrees b = new BurnTrees(size,size,density);
      ans += b.run();
    }
    return ans/1000;
  }
  public static double[] test(double start, double end, double interval, int size){
    double[] max = new double[]{0,0,0,0};
    for (double i = start; i<=end; i+=interval){
      double val = average(size,i);
      if (val > max[0]) {
        max[2] = max[0];
        max[3] = max[1];
        max[0] = val;
        max[1] = i;
      } else if (val > max[2]){
        max[2] = val;
        max[3] = i;
      }
      System.out.println(i+": "+val); //(double)((int)(i*100000)/1000)+"%
    }
    return max;
  }
}
