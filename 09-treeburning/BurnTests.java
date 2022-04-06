public class BurnTests {
  public static void main(String[] args) {
    //System.out.println(average(100,0.5));
    test(0.60,0.62,0.001);
  }
  public static double average (int size, double density){
    double ans = 0;
    for (int i = 0; i<1000; i++) {
      BurnTrees b = new BurnTrees(size,size,density);
      ans += b.run();
    }
    return ans/1000;
  }
  public static void test(double start, double end, double interval){
    for (double i = start; i<end; i+=interval){
      System.out.println(i+": "+average(100,i)); //0.61
    }
  }
}
