import java.util.Arrays;
public class BurnTests {
  public static void main(String[] args) {
    //System.out.println(average(100,0.5));
    double start = 0;
    double end = 1;
    double interval = 0.1;
    //for (int i=0; i<3; i++) {
      System.out.println(Arrays.toString(test(start,end,interval)));
    //}

  }
  public static double average (int size, double density){
    double ans = 0;
    for (int i = 0; i<1000; i++) {
      BurnTrees b = new BurnTrees(size,size,density);
      ans += b.run();
    }
    return ans/1000;
  }
  public static double[] test(double start, double end, double interval){
    double[] max = new double[]{0,0,0,0};
    for (double i = start; i<end; i+=interval){
      double val = average(100,i);
      if (val > max[0]) {
        max[2] = max[0];
        max[3] = max[1];
        max[0] = val;
        max[1] = i;
      } else if (val > max[2]){
        max[2] = val;
        max[3] = i;
      }
      System.out.println(i+": "+val); //0.61
    }
    return max;
  }
}
