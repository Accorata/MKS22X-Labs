public class Test {
  public static void main(String[] args) {
    MyDeque<String> a = new MyDeque<String>(1);
    //System.out.println(a.toStringDebug());
    // a.addFirst("test2");
    // a.addFirst("test3");
    System.out.println(a.toStringDebug());
    a.addLast("last1");
    System.out.println(a.toStringDebug());
    System.out.println(a);
    // System.out.println(a.toStringDebug());
    // System.out.println(a.removeFirst());
    // a.addLast("last2");
    // System.out.println(a.toStringDebug());
    // a.addLast("last3");
    // System.out.println(a.toStringDebug());
    // a.addLast("last4");
    // System.out.println(a.toStringDebug());
    // a.addLast("last5");
    // System.out.println(a.toStringDebug());
    // a.addFirst("test1");
    // System.out.println(a.toStringDebug());
    a.addFirst("test2");
    System.out.println(a.toStringDebug());
    System.out.println(a);
    a.addFirst("test3");
    System.out.println(a.toStringDebug());
    System.out.println(a);
    // System.out.println(a);
    // a.removeFirst();
    // System.out.println(a.toStringDebug());
    // System.out.println(a);
    // System.out.println(a.getFirst());
    // System.out.println(a.getLast());
    //ystem.out.println(a);
  }
}
