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
    for (int i = start; i<size; i++) {
      ans += data[i];
      if (i != size-1) ans += ", ";
    }
    return ans + "]";
  }
  public String toStringDebug(){
    String ans = "[";
    for (int i = 0; i<data.length; i++) {
      ans += data[i];
      if (i != data.length-1) ans += ", ";
    }
    return ans + "]\nStart: "+start+" End: "+end+" Size: "+size;
  }
  // public void addFirst(E element){
  //   data[start-1] = element;
  //   start--;
  // }
  public void addLast(E element){
    data[end+1] = element;
    size++;
    end++;
    if (end >= data.length) end = 0;
  }
  // public E removeFirst(){ }
  // public E removeLast(){ }
  // public E getFirst(){ }
  // public E getLast(){ }
}
