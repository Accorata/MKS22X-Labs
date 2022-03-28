public class Test {
  public static void main(String[] args) {
    MyDeque<String> a = new MyDeque<String>();
    System.out.println(a.toStringDebug());
    a.addFirst("test1");
    a.addFirst("test2");
    a.addFirst("test3");
    System.out.println(a.toStringDebug());
    System.out.println(a.size());
    //ystem.out.println(a);
  }
}
