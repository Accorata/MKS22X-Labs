public class MyDeque<E>{
  private E[] data;
  private int size;
  private int start, end;

  public MyDeque(){
    this(10);
  }
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
  }
  // public int size(){ }
  public String toString(){
    String ans = "[";
    for (int i = 0; i<size; i++) {
      ans += data[i];
      if (i != size-1) ans += ", ";
    }
    return ans + "]";
  }
  // public void addFirst(E element){ }
  // public void addLast(E element){ }
  // public E removeFirst(){ }
  // public E removeLast(){ }
  // public E getFirst(){ }
  // public E getLast(){ }
}
