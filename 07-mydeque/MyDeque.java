import java.util.NoSuchElementException;
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
  public int size(){
    return size;
  }
  public String toString(){
    if (start == end) return "[]";
    String ans = "[";
    int limit = end;
    if (end < start) limit = data.length-1;
    for (int i = start; i<=limit; i++) {
      ans += data[i];
      if (i != limit) ans += ", ";
    }
    if (end < start) {
      ans += ", ";
      for (int i = 0; i<=end; i++) {
        ans += data[i];
        if (i != end) ans += ", ";
      }
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
  public void addFirst(E element){
    if (element == null) throw new NullPointerException();
    if (size >= data.length) resize();
    if (size == 0) {
      data[start] = element;
    } else {
      if (start <= 0) start = data.length;
      data[start-1] = element;
      start--;
    }
    size++;
  }
  public void addLast(E element){
    if (element == null) throw new NullPointerException();
    if (size >= data.length) resize();
    if (size == 0) {
      data[end] = element;
    } else {
      if (end >= data.length-1) end = -1;
      data[end+1] = element;
      end++;
    }
    size++;
  }
  public E removeFirst(){
    if (data[start] == null) throw new NoSuchElementException();
    E value = data[start];
    data[start] = null;
    size--;
    if (size != 0) start++;
    if (start >= data.length) start = 0;
    return value;
  }
  public E removeLast(){
    if (data[end] == null) throw new NoSuchElementException();
    E value = data[end];
    data[end] = null;
    size--;
    if (size != 0) end--;
    if (end < 0) end = data.length-1;
    return value;
  }
  public E getFirst(){
    if (data[start] == null) throw new NoSuchElementException();
    return data[start];
  }
  public E getLast(){
    if (data[end] == null) throw new NoSuchElementException();
    return data[end];
  }
  private void resize(){
    @SuppressWarnings("unchecked")
    E[] n = (E[])new Object[size*2+1];
    if (size > 0) {
      int limit = end;
      if (end < start) limit = data.length-1;
      for (int i = start; i<=limit; i++){
        n[i-start] = data[i];
      }
      if (end < start) {
        int offset = size-end-1;
        for (int i = 0; i<=end; i++) {
          n[i+offset] = data[i];
        }
      }
      end = size-1;
    }
    start = 0;
    data = n;
  }
}
