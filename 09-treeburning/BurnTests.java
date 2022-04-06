public class BurnTests {
  public static void main(String[] args) {
    System.out.println(average(100,0.5));
  }
  public static double average (int size, double density){
    double ans = 0;
    for (int i = 0; i<100; i++) {
      BurnTrees b = new BurnTrees(size,size,density);
      ans += b.run();
    }
    return ans/100;
  }
  public static void test(int start, int end, int interval){

  }
}
