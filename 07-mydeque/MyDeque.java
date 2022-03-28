public class MyDeque<E>{
  private E[] data;
  private int size;
  private int start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
  }
  // public MyDeque(int initialCapacity){  }
  // public int size(){ }
  public String toString(){
    String ans = "[";
    for (int i = 0; i<size; i++) {
      ans += data[i] + ", ";
    }
    return ans.substring(0,ans.length()-2) + "]";
  }
  // public void addFirst(E element){ }
  // public void addLast(E element){ }
  // public E removeFirst(){ }
  // public E removeLast(){ }
  // public E getFirst(){ }
  // public E getLast(){ }
}
