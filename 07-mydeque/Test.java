public class Test {
  public static void main(String[] args) {
    MyDeque<String> a = new MyDeque<String>();
    System.out.println(a.toStringDebug());
    a.addFirst("test1");
    // a.addFirst("test2");
    // a.addFirst("test3");
    a.addLast("last1");
    System.out.println(a.toStringDebug());
    System.out.println(a.removeFirst());
    System.out.println(a.removeFirst());
    System.out.println(a.toStringDebug());
    a.addLast("last2");
    System.out.println(a.toStringDebug());
    // System.out.println(a.getFirst());
    // System.out.println(a.getLast());
    //ystem.out.println(a);
  }
}
