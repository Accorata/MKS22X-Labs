public class Test {
  public static void main(String[] args) {
    MyDeque<String> a = new MyDeque<String>();
    System.out.println(a.toStringDebug());
    a.addLast("test1");
    System.out.println(a.toStringDebug());
    System.out.println(a);
  }
}
